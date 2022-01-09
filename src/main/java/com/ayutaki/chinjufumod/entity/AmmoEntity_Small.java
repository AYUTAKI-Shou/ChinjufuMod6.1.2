package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class AmmoEntity_Small extends AbstractAmmo_Entity {

	public AmmoEntity_Small(EntityType<? extends AbstractAmmo_Entity> type, World worldIn) {
		super(type, worldIn);
	}

	public AmmoEntity_Small(World worldIn, double x, double y, double z) {
		super(EntityTypes_CM.AMMO_S, x, y, z, worldIn);
	}

	public AmmoEntity_Small(World worldIn, LivingEntity shooter) {
		super(EntityTypes_CM.AMMO_S, shooter, worldIn);
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

	@Override
	protected void onHitEntity(EntityRayTraceResult result) {
		super.onHitEntity(result);
		this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.5D, 0.0D);
	}

	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		super.onHitBlock(result);
		this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 0.0D, 0.5D, 0.0D);
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
