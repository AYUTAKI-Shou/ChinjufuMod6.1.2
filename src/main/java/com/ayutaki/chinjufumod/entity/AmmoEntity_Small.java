package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Small extends AmmoAbstract_Entity {

	@SuppressWarnings("unused")
	private SoundEvent hitSound = this.getHitEntitySound();

	public AmmoEntity_Small(EntityType<? extends AmmoEntity_Small> type, World worldIn) {
		super(type, worldIn);
	}

	public AmmoEntity_Small(World worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_S, x, y, z, worldIn);
	}

	public AmmoEntity_Small(World worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_S, shooter, worldIn);
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
		RayTraceResult.Type raytraceresult$type = raytraceResult.getType();

		this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.5D, 0.0D);
		
		if (raytraceresult$type == RayTraceResult.Type.ENTITY) {
			this.onEntityHit((EntityRayTraceResult)raytraceResult);
			this.playSound(this.getHitEntitySound(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
		}

		else if (raytraceresult$type == RayTraceResult.Type.BLOCK) {
			this.playSound(this.getHitEntitySound(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
		}
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
