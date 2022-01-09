package com.ayutaki.chinjufumod.entity.kansaiki;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.entity.kansaiki.helper.Vector3;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Entity_Type97_2 extends EntityThrowable {

	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.createKey(Entity_Type97_2.class, DataSerializers.VARINT);
	private ItemStack stack = ItemStack.EMPTY;

	public Entity_Type97_2(World worldIn) {
		super(worldIn);

		setSize(2.0F, 2.0F);
	}

	public Entity_Type97_2(World worldIn, EntityLivingBase entity, ItemStack stack) {
		super(worldIn, entity);
		this.stack = stack.copy();
	}

	public void shoot(Entity entityThrower, float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
		float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
		float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
		this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
		this.motionX += entityThrower.motionX;
		this.motionZ += entityThrower.motionZ;

		if (!entityThrower.onGround) { this.motionY += entityThrower.motionY; }
		
		/** プロペラ音 投擲時に出す **/
		this.playSound(SoundEvents_CM.KK_PROPELLER, 2.0F, 1.0F);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(RETURN_TO, -1);
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		/** プロペラ音 1.12.2 では処理負荷が高過ぎる **/
		
		/** Server state control **/
		if (!world.isRemote) {
			Entity thrower = getThrower();
			
			if (isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null) {
					Vector3 motion = Vector3.fromEntityCenter(thrower).subtract(Vector3.fromEntityCenter(this)).normalize();
					motionX = motion.x;
					motionY = motion.y;
					motionZ = motion.z;
					
					if (getDistanceSq(thrower) < 2) { dropAndKill(); } }
			}
			
			
			if (!isReturning()) {
				if (thrower == null && ticksExisted > 200) { dropAndKill(); }
				
				if (thrower != null && ticksExisted >= 60) { setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	private void dropAndKill() {
		ItemStack stack = getItemStack();
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
			if (block instanceof Block) { return; }
			break;
		}

		case ENTITY: {
			if (!world.isRemote && result.entityHit != null && result.entityHit instanceof EntityLivingBase && result.entityHit != getThrower()) {

				/** 村人などは攻撃せずにアイテム化 **/
				if (result.entityHit instanceof EntityVillager || result.entityHit instanceof EntityHorse || result.entityHit instanceof EntityTameable) {
					this.playSound(SoundEvents_CM.KK_STOP, 2.0F, 1.0F);
					dropAndKill();
				}

				/** その他 Mob にはダメージを与える **/
				else {
					/** ダメージ値 艦これの 火力＋雷装または爆装 の数値を使う 97式は 5.0F **/
					float i = 5.0F + 1.0F;
					int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, stack);

					if (j == 0) { result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i); }
					if (j != 0) { result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), i + j * 0.5F); }
					this.playSound(SoundEvents_CM.KK_ATACK, 2.0F, 1.0F);
				}
			}
			break;
		}

		default: break;
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

	/* Renderで参照する state */
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
