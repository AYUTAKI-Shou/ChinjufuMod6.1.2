package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class Gyorai61cmEntity extends ThrowableEntity implements IRendersAsItem {

	private ItemStack stack = new ItemStack(Items_Weapon.GYORAI_61cm);

	public Gyorai61cmEntity(EntityType<Gyorai61cmEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public Gyorai61cmEntity(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.GYORAI61, entity, worldIn);
		this.stack = stack.copy();
	}

	@Override
	protected void defineSynchedData() { }

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

		/** パーティクル **/
		this.level.addParticle(ParticleTypes.CLOUD, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!level.isClientSide && tickCount >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
		ItemEntity item = new ItemEntity(level, getX(), getY(), getZ(), stack);
		level.addFreshEntity(item);
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

		/** ダメージ値 艦これの 火力＋雷装または爆装 の数値を使う 97式は 5.0F 2で+1.0F 3で+2.0F **/
		float i = 11.0F;
		int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, stack);

		if (j == 0) { result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i); }
		if (j > 0) { result.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), i + j * 0.5F); }
		this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
		this.remove();
	}

	/* Block との衝突 */
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState blockstate = this.level.getBlockState(result.getBlockPos());
		blockstate.onProjectileHit(this.level, blockstate, result, this);

		Block block = blockstate.getBlock();
		if (blockstate.getMaterial().isReplaceable() || block == Blocks.KELP) { return; }
		
		if (!blockstate.getMaterial().isReplaceable() && block != Blocks.KELP) { 
			this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
			this.remove(); }
	}

	@Override
	protected float getGravity() {
		if (this.isInWater()) { return 0F; }
		return 0.01F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean isInWater() {
		return false;
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
