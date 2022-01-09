package com.ayutaki.chinjufumod.entity.kansaiki;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Entity_Gyorai61cm4 extends EntityThrowable {

	private ItemStack stack = ItemStack.EMPTY;

	public Entity_Gyorai61cm4(World worldIn) {
		super(worldIn);

		setSize(1.0F, 1.0F);
	}

	public Entity_Gyorai61cm4(World worldIn, EntityLivingBase entity, ItemStack stack) {
		super(worldIn, entity);
		this.stack = stack.copy();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();

		/**パーティクル **/
		this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		/** Server state control **/
		if (!world.isRemote && ticksExisted >= 60) { dropAndKill(); }
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
		stack.setCount(1);
		EntityItem item = new EntityItem(world, posX, posY, posZ, stack);
		world.spawnEntity(item);
		setDead();
	}

	private ItemStack getItemStack() {
		return this.stack.copy();
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult result) {

		switch (result.typeOfHit) {
		case BLOCK: {
			Block block = world.getBlockState(result.getBlockPos()).getBlock();
			/** ブロックは貫通 **/
			if (block == Blocks.AIR || block == Blocks.WATER || block instanceof BlockBush || block instanceof BlockLeaves) {
				return;
			}

			else {
				this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
				this.world.setEntityState(this, (byte)3);
				setDead();
			}
			break;
		}

		case ENTITY: {
			if (!world.isRemote && result.entityHit != null && result.entityHit instanceof EntityLivingBase && result.entityHit != getThrower()) {

				float i = 11.0F + 3.0F;
				int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);

				if (j == 0) { result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i); }
				if (j != 0) { result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i + j * 0.5F); }
				world.playSound(null, posX, posY, posZ, SoundEvents_CM.KK_ATACK, SoundCategory.MASTER, 2.0F, 1.0F);
				this.playSound(SoundEvents_CM.AM_IMPACT, 2.0F, 0.8F);
				this.world.setEntityState(this, (byte)3);
				setDead();
			}
			break;
		}

		default: break;
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
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setTag("fly_stack", stack.writeToNBT(new NBTTagCompound()));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		stack = new ItemStack(compound.getCompoundTag("fly_stack"));
	}

}
