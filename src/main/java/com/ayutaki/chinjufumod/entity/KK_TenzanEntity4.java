package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class KK_TenzanEntity4 extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.defineId(KK_TenzanEntity4.class, DataSerializers.INT);
	private ItemStack stack = new ItemStack(Items_Weapon.TENZAN);

	public KK_TenzanEntity4(EntityType<KK_TenzanEntity4> type, World worldIn) {
		super(type, worldIn);
	}

	public KK_TenzanEntity4(LivingEntity entityIn, World worldIn, ItemStack itemstack) {
		super(EntityTypes_CM.TENZAN, entityIn, worldIn);
		stack = itemstack.copy();
	}

	@Override
	protected void defineSynchedData() {
		entityData.define(RETURN_TO, Integer.valueOf(-1));
	}

	/* Flying render */
	@Nonnull
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();
		/** プロペラ音 **/
		playSound(SoundEvents_CM.KK_PROPELLER, 2.0F, 1.0F);

		if (!level.isClientSide) {
			Entity thrower = getOwner();
			
			if (isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					setDeltaMovement(motion.toVector3d());
					
					if (distanceToSqr(thrower) < 2) { dropAndKill(); } }
			}
			
			if (!isReturning()) {
				if (thrower == null && tickCount > 200) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/* アイテム化と Entity 削除 */
	private void dropAndKill() {
		ItemStack stack = getItemStack();
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}

	/* stack.copy() で耐久値を反映 */
	private ItemStack getItemStack() {
		return stack.copy();
	}

	/* implements IRendersAsItem で必須 */
	@Nonnull
	@Override
	public ItemStack getItem() {
		return getItemStack();
	}

	/* 衝突処理 */
	@Override
	protected void onHit(RayTraceResult result) {
		RayTraceResult.Type raytraceresult$type = result.getType();
		if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
			onHitEntity((EntityRayTraceResult)result); }

		else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
			onHitBlock((BlockRayTraceResult)result); }
	}

	/* Entity との衝突 */
	@Override
	protected void onHitEntity(EntityRayTraceResult result) {

		Entity thrower = getOwner();
		if (!level.isClientSide && result.getEntity() instanceof LivingEntity && result.getEntity() != thrower) {
			/** 村人などは攻撃せずにアイテム化 **/
			if (result.getEntity() instanceof VillagerEntity || result.getEntity() instanceof HorseEntity || result
					.getEntity() instanceof DonkeyEntity || result.getEntity() instanceof TameableEntity) {

				playSound(SoundEvents_CM.KK_STOP, 2.0F, 1.0F);
				dropAndKill();
			}

			/** その他 Mob にはダメージを与える **/
			else {
				/** ダメージ値 艦これの 火力＋雷装または爆装 の数値を使う 97式は 5.0F 2で+1.0F 3で+2.0F。工廠指示書を難しくした分の加算 + 1.0F;**/
				float i = 7.0F + 3.0F;
				int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);

				if (j == 0) { result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i); }
				if (j > 0) { result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i + j * 0.5F); }
				this.playSound(SoundEvents_CM.KK_ATACK, 2.0F, 1.0F);
			}
		}
	}

	/* Block との衝突 */
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState blockstate = level.getBlockState(result.getBlockPos());
		blockstate.onProjectileHit(level, blockstate, result, this);

		/** ブロックは貫通 **/
		Block block = blockstate.getBlock();
		if (block instanceof Block) { return; }
	}

	@Override
	protected float getGravity() {
		return 0.0F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean isInWater() {
		return false;
	}
	
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return entityData.get(RETURN_TO).intValue();
	}

	private void setEntityToReturnTo(int entityID) {
		entityData.set(RETURN_TO, Integer.valueOf(entityID));
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		if (!stack.isEmpty()) {
			compound.put("fly_stack", stack.save(new CompoundNBT()));
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("fly_stack")) {
			stack = ItemStack.of(compound.getCompound("fly_stack"));
		}
	}

}
