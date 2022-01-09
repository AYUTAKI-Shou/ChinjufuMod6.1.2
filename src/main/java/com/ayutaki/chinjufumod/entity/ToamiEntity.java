package com.ayutaki.chinjufumod.entity;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.handler.EntityTypes_CM;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
public class ToamiEntity extends ThrowableEntity implements IRendersAsItem {

	private static final DataParameter<Integer> RETURN_TO = EntityDataManager.defineId(ToamiEntity.class, DataSerializers.INT);
	private ItemStack stack = new ItemStack(Items_Teatime.TOAMI);
	
	public ToamiEntity(EntityType<ToamiEntity> type, World worldIn) {
		super(type, worldIn);
	}

	public ToamiEntity(LivingEntity entityIn, World worldIn, ItemStack itemstack) {
		super(EntityTypes_CM.TOAMI, entityIn, worldIn);
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

		if (!level.isClientSide) {
			Entity thrower = getOwner();
			
			if (isReturning()) { 
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null) { returnAndKill(); } }
			
			if (!isReturning()) {
				if (thrower == null && tickCount > 60) { dropAndKill(); }
				
				if (thrower != null && tickCount >= 15) { setEntityToReturnTo(getEntityToReturnTo() + 1); } }
		}
	}

	/* アイテム化と Entity 削除 */
	private void returnAndKill() {
		Entity thrower = getOwner();
		ItemStack stack = getItemStack();
		ItemEntity item = new ItemEntity(level, thrower.getX(), thrower.getY(), thrower.getZ(), stack);
		level.addFreshEntity(item);
		remove();
	}

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
		return new ItemStack(Items_Teatime.TOAMI);
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
		
		if (isReturning()) { return; }

		if (!isReturning()) { 
			if (!level.isClientSide && result.getEntity() instanceof LivingEntity) {
				
				if (result.getEntity() instanceof CodEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.COD)); }
				
				if (result.getEntity() instanceof SalmonEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.SALMON)); }
				
				if (result.getEntity() instanceof TropicalFishEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.TROPICAL_FISH)); }
				
				if (result.getEntity() instanceof PufferfishEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items.PUFFERFISH));
					((LivingEntity) thrower).addEffect(new EffectInstance(Effects.POISON, 60, 0));  }
				
				if (result.getEntity() instanceof SquidEntity) {
					result.getEntity().playSound(SoundEvents.BUCKET_FILL_FISH, 2.0F, 1.0F);
					result.getEntity().remove();
					thrower.spawnAtLocation(new ItemStack(Items_Teatime.IKA)); }
				
				if (!(result.getEntity() instanceof CodEntity) && !(result.getEntity() instanceof SalmonEntity) &&
						!(result.getEntity() instanceof TropicalFishEntity) && !(result.getEntity() instanceof PufferfishEntity) &&
						!(result.getEntity() instanceof SquidEntity)) {
					
					result.getEntity().playSound(SoundEvents.GENERIC_HURT, 2.0F, 1.0F);
					((LivingEntity) result.getEntity()).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 300, 1));
					setEntityToReturnTo(getEntityToReturnTo() + 1); }
			}
		}
	}

	/* Block との衝突 */
	@Override
	protected void onHitBlock(BlockRayTraceResult result) {
		BlockState blockstate = level.getBlockState(result.getBlockPos());
		blockstate.onProjectileHit(level, blockstate, result, this);
		
		Block block = blockstate.getBlock();
		if (blockstate.getMaterial().isReplaceable() || block == Blocks.KELP ||
				block == Crop_Blocks.SHIKAKE_AMI || block == Crop_Blocks.YOUSHOKU_AMI) { 
			return; }
		
		if (!blockstate.getMaterial().isReplaceable() && block != Blocks.KELP &&
				block != Crop_Blocks.SHIKAKE_AMI && block != Crop_Blocks.YOUSHOKU_AMI) { 
			//test sound... level.playSound(null, result.getBlockPos(), SoundEvents.STONE_BREAK, SoundCategory.BLOCKS, 3.0F, 0.8F);
			setEntityToReturnTo(getEntityToReturnTo() + 1); }
	}

	@Override
	protected float getGravity() {
		return 0F;
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
