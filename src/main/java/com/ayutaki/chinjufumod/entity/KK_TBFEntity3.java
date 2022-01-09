package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.entity.helper.Vector3;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
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

@OnlyIn( value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class KK_TBFEntity3 extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(KK_TBFEntity3.class, DataSerializers.VARINT);
	private ItemStack stack = new ItemStack(Items_Weapon.TBF);

	public KK_TBFEntity3(EntityType<KK_TBFEntity3> type, World worldIn) {
		super(type, worldIn);
	}

	public KK_TBFEntity3(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.TBF, entity, worldIn);
		this.stack = stack.copy();
	}

	@Override
	protected void registerData() {
		dataManager.register(RETURN_TO, -1);
	}

	/* Flying render */
	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void tick() {
		super.tick();
		/** プロペラ音 **/
		this.playSound(SoundEvents_CM.KK_PROPELLER, 2.0F, 1.0F);

		/** Server state control **/
		if (!world.isRemote) {
			Entity thrower = getThrower();
			
			if (isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					setMotion(motion.toVec3D());

					if (getDistanceSq(thrower) < 2) { dropAndKill(); } }
			}

			if (!isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/* アイテム化と Entity 削除 */
	private void dropAndKill() {
		ItemStack stack = getItemStack();
		ItemEntity item = new ItemEntity(world, getPosX(), getPosY(), getPosZ(), stack);
		world.addEntity(item);
		remove();
	}

	/* stack.copy() で耐久値を反映 */
	private ItemStack getItemStack() {
		return this.stack.copy();
	}

	/* implements IRendersAsItem で必須 */
	@Nonnull
	@Override
	public ItemStack getItem() {
		return getItemStack();
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		switch (result.getType()) {
		case BLOCK: {
			BlockRayTraceResult blockResult = (BlockRayTraceResult) result;
			Block block = world.getBlockState(blockResult.getPos()).getBlock();

			/** ブロックは貫通 **/
			if (block instanceof Block) { return; }
			break;
		}

		case ENTITY: {
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			LivingEntity thrower = getThrower();

			if (!world.isRemote && entityResult.getEntity() instanceof LivingEntity && entityResult.getEntity() != thrower) {

				/** 村人などは攻撃せずにアイテム化 **/
				if (entityResult.getEntity() instanceof VillagerEntity || entityResult.getEntity() instanceof HorseEntity || entityResult
						.getEntity() instanceof DonkeyEntity || entityResult.getEntity() instanceof TameableEntity) {
					entityDropItem(getItemStack(), 0.5f);
					this.playSound(SoundEvents_CM.KK_STOP, 2.0F, 1.0F);
					this.remove();
				}

				/** その他 Mob にはダメージを与える **/
				else {
					/** ダメージ値 艦これの 火力＋雷装または爆装 の数値を使う 97式は 5.0F。工廠指示書を難しくした分の加算 + 1.0F;**/
					float i = 11.0F + 2.0F;
					int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);

					if (j == 0) { entityResult.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i); }
					if (j > 0) { entityResult.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i + j * 0.5F); }
					this.playSound(SoundEvents_CM.KK_ATACK, 2.0F, 1.0F);
				}
			}
			break;
		}
		default:
			break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		return 0F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
	}
	
	public boolean isReturning() {
		return getEntityToReturnTo() > -1;
	}

	private int getEntityToReturnTo() {
		return dataManager.get(RETURN_TO);
	}

	private void setEntityToReturnTo(int entityID) {
		dataManager.set(RETURN_TO, entityID);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		if (!stack.isEmpty()) {
			compound.put("fly_stack", stack.write(new CompoundNBT()));
		}
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("fly_stack")) {
			stack = ItemStack.read(compound.getCompound("fly_stack"));
		}
	}

}
