package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.LeavesBlock;
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

@OnlyIn( value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class Gyorai61cmEntity4 extends ThrowableEntity implements IRendersAsItem {

	private ItemStack stack = new ItemStack(Items_Weapon.GYORAI_61cm);

	public Gyorai61cmEntity4(EntityType<Gyorai61cmEntity4> type, World worldIn) {
		super(type, worldIn);
	}

	public Gyorai61cmEntity4(LivingEntity entity, World worldIn, ItemStack stack) {
		super(EntityTypes_CM.GYORAI61, entity, worldIn);
		this.stack = stack.copy();
	}

	@Override
	protected void registerData() {
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

		/** パーティクル **/
		double d0 = this.getPosX();
		double d1 = this.getPosY();
		double d2 = this.getPosZ();
		this.world.addParticle(ParticleTypes.CLOUD, d0, d1, d2, 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!world.isRemote && ticksExisted >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
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

			if (block == Blocks.AIR || block == Blocks.WATER || block instanceof BushBlock || block instanceof LeavesBlock) {
				return;
			}

			else {
				this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
				this.world.setEntityState(this, (byte)3);
				this.remove();
			}
			break;
		}

		case ENTITY: {
			EntityRayTraceResult entityResult = (EntityRayTraceResult) result;
			float i = 11.0F + 3.0F;
			int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);

			if (j == 0) { entityResult.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i); }
			if (j > 0) { entityResult.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i + j * 0.5F); }
			this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
			this.world.setEntityState(this, (byte)3);
			this.remove();

			break;
		}
		default:
			break;
		}
	}

	@Override
	protected float getGravityVelocity() {
		if (this.inWater) { return 0F; }
		return 0.01F;
	}

	/* 水による速度への影響 */
	@Override
	public boolean handleWaterMovement() {
		return false;
	}

	public boolean isPushedByWater() {
		return false;
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
