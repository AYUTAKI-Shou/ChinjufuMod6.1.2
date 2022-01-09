package com.ayutaki.chinjufumod.entity;

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
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Large extends AmmoAbstract_Entity {

	@SuppressWarnings("unused")
	private SoundEvent hitSound = this.getHitEntitySound();

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
	public void setPotionEffect(ItemStack stack) { }

	public static int getCustomColor(ItemStack stack) { return -1; }

	/* Pickup AIR */
	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	/* ↓↓Hit result↓↓ */
	@Override
	public void tick() {
		super.tick();

		/** inGround remove **/
		if (this.inGround) {
			this.remove();
		}
	}

	@Override
	protected void arrowHit(LivingEntity living) {
		super.arrowHit(living);
	}

	@Override
	protected void onHit(RayTraceResult raytraceResult) {
		super.onHit(raytraceResult);

		this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.5D, 0.0D);
		
		if (!this.world.isRemote) {
		RayTraceResult.Type raytraceresult$type = raytraceResult.getType();
		/** Config value **/
		boolean blast = Config_CM.getInstance().blastBlockBreak();

			if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
				this.onEntityHit((EntityRayTraceResult)raytraceResult);
				/**小口径 音1.0-1.2 威力－, 中口径 音1.5-1.0 威力1.25, 大口径 音2.0-0.8 威力2.5**/
				this.playSound(this.getHitEntitySound(), 2.0F, 0.8F / (this.rand.nextFloat() * 0.2F + 0.9F));
				this.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.5F, false, (blast == true)? Explosion.Mode.BREAK : Explosion.Mode.NONE);
				this.remove();
			}

			else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
				this.playSound(this.getHitEntitySound(), 2.0F, 0.8F / (this.rand.nextFloat() * 0.2F + 0.9F));
				this.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.5F, false, (blast == true)? Explosion.Mode.BREAK : Explosion.Mode.NONE);
				this.remove();
			}
		}
	}

	public Explosion_CM createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		return this.explode(entityIn, (DamageSource)null, xIn, yIn, zIn, value, flag, modeIn);
	}

	public Explosion_CM explode(@Nullable Entity entityIn, @Nullable DamageSource damage, double xIn, double yIn, double zIn, float value, boolean flag, Explosion.Mode modeIn) {
		Explosion_CM explosion = new Explosion_CM(world, this, xIn, yIn, zIn, value, flag, modeIn);
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		return explosion;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult entityRay) {
		super.onEntityHit(entityRay);
	}

	/* Flying render */
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
