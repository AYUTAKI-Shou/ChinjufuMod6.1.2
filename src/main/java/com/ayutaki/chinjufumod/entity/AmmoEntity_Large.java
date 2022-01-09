package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Large extends AbstractAmmo_Entity {

	public AmmoEntity_Large(EntityType<? extends AmmoEntity_Large> type, World worldIn) {
		super(type, worldIn);
	}

	public AmmoEntity_Large(World worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_L, x, y, z, worldIn);
	}

	public AmmoEntity_Large(World worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_L, shooter, worldIn);
	}


	/* PotionEffect null */
	public void setEffectsFromItemt(ItemStack stack) { }

	public static int getCustomColor(ItemStack stack) { return -1; }

	@SuppressWarnings("unused")
	private void updateColor() { }

	public void addEffect(EffectInstance instance) { }

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
	}

	/* ↓↓Hit result↓↓ */
	/**小口径 音1.0-1.2 威力－, 中口径 音1.5-1.0 威力1.25, 大口径 音2.0-0.8 威力2.5**/
	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		super.onHitEntity(result);
		this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.5D, 0.0D);
		
		if (!this.level.isClientSide) {
			/** Config value **/
			boolean blast = Config_CM.getInstance().blastBlockBreak();
			this.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.5F, false, (blast == true)? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
			this.remove();
		}
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.5D, 0.0D);
		
		if (!this.level.isClientSide) {
			/** Config value **/
			boolean blast = Config_CM.getInstance().blastBlockBreak();
			this.createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.5F, false, (blast == true)? Explosion.Mode.DESTROY : Explosion.Mode.NONE);
			this.remove();
		}
	}

	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		return this.explode(entityIn, (DamageSource)null, (ExplosionContext)null, xIn, yIn, zIn, value, flag, mode);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, @Nullable ExplosionContext context, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode mode) {
		Explosion_CM explosion = new Explosion_CM(level, this, damage, context, xIn, yIn, zIn, value, flag, mode);
		explosion.explode();
		explosion.finalizeExplosion(true);
		return explosion;
	}

	/* Pickup AIR */
	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(Items.AIR);
	}

	@Override
	public void handleEntityEvent(byte value) {
		super.handleEntityEvent(value);
	}

	/* Flying render */
	@Nonnull
	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
