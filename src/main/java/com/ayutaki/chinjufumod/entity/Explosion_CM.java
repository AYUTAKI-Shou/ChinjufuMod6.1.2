package com.ayutaki.chinjufumod.entity;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.EntityExplosionContext;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Explosion_CM extends Explosion {

	private static final ExplosionContext EXPLOSION_DAMAGE_CALCULATOR = new ExplosionContext();
	private final boolean fire;
	private final Explosion.Mode blockInteraction;
	private final Random random = new Random();
	private final World level;
	private final double x;
	private final double y;
	private final double z;
	@Nullable
	private final Entity entity;
	private final float radius;
	private final DamageSource damageSource;
	private final ExplosionContext damageCalculator;
	private final List<BlockPos> toBlow = Lists.newArrayList();
	private final Map<PlayerEntity, Vector3d> hitPlayers = Maps.newHashMap();
	private final Vector3d position;

	@OnlyIn(Dist.CLIENT)
	public Explosion_CM(World worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, xIn, yIn, zIn, sizeIn, false, Explosion.Mode.DESTROY, affectedPositions);
	}

	@OnlyIn(Dist.CLIENT)
	public Explosion_CM(World worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.Mode mode, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, xIn, yIn, zIn, sizeIn, fireIn, mode);
		this.toBlow.addAll(affectedPositions);
	}

	@OnlyIn(Dist.CLIENT)
	public Explosion_CM(World worldIn, @Nullable Entity entityIn, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.Mode mode) {
		this(worldIn, entityIn, (DamageSource)null, (ExplosionContext)null, xIn, yIn, zIn, sizeIn, fireIn, mode);
	}

	public Explosion_CM(World worldIn, @Nullable Entity entityIn, @Nullable DamageSource source, @Nullable ExplosionContext context, double xIn, double yIn, double zIn, float sizeIn, boolean fireIn, Explosion.Mode mode) {
		super(worldIn, entityIn, source, context, xIn, yIn, zIn, sizeIn, fireIn, mode);
		this.level = worldIn;
		this.entity = entityIn;
		this.radius = sizeIn;
		this.x = xIn;
		this.y = yIn;
		this.z = zIn;
		this.fire = fireIn;
		this.blockInteraction = mode;
		this.damageSource = source == null ? DamageSource.explosion(this) : source;
		this.damageCalculator = context == null ? this.makeDamageCalculator(entityIn) : context;
		this.position = new Vector3d(this.x, this.y, this.z);
	}

	private ExplosionContext makeDamageCalculator(@Nullable Entity entityIn) {
		return (ExplosionContext)(entityIn == null ? EXPLOSION_DAMAGE_CALCULATOR : new EntityExplosionContext(entityIn));
	}

	public static float getSeenPercent(Vector3d v3d, Entity entityIn) {
		AxisAlignedBB axisalignedbb = entityIn.getBoundingBox();
		double d0 = 1.0D / ((axisalignedbb.maxX - axisalignedbb.minX) * 2.0D + 1.0D);
		double d1 = 1.0D / ((axisalignedbb.maxY - axisalignedbb.minY) * 2.0D + 1.0D);
		double d2 = 1.0D / ((axisalignedbb.maxZ - axisalignedbb.minZ) * 2.0D + 1.0D);
		double d3 = (1.0D - Math.floor(1.0D / d0) * d0) / 2.0D;
		double d4 = (1.0D - Math.floor(1.0D / d2) * d2) / 2.0D;
		if (!(d0 < 0.0D) && !(d1 < 0.0D) && !(d2 < 0.0D)) {
			int i = 0;
			int j = 0;

			for(float f = 0.0F; f <= 1.0F; f = (float)((double)f + d0)) {
				for(float f1 = 0.0F; f1 <= 1.0F; f1 = (float)((double)f1 + d1)) {
					for(float f2 = 0.0F; f2 <= 1.0F; f2 = (float)((double)f2 + d2)) {
						double d5 = MathHelper.lerp((double)f, axisalignedbb.minX, axisalignedbb.maxX);
						double d6 = MathHelper.lerp((double)f1, axisalignedbb.minY, axisalignedbb.maxY);
						double d7 = MathHelper.lerp((double)f2, axisalignedbb.minZ, axisalignedbb.maxZ);
						Vector3d vector3d = new Vector3d(d5 + d3, d6, d7 + d4);
						if (entityIn.level.clip(new RayTraceContext(vector3d, v3d, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, entityIn)).getType() == RayTraceResult.Type.MISS) {
							++i;
						}

						++j;
					}
				}
			}

			return (float)i / (float)j;
		} else {
			return 0.0F;
		}
	}

	/* ブロックの破壊に関する設定
	 * Does the first part of the explosion (destroy blocks) */
	public void explode() {
		Set<BlockPos> set = Sets.newHashSet();
		//int i = 16;

		for(int j = 0; j < 16; ++j) {
			for(int k = 0; k < 16; ++k) {
				for(int l = 0; l < 16; ++l) {
					if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
						double d0 = (double)((float)j / 15.0F * 2.0F - 1.0F);
						double d1 = (double)((float)k / 15.0F * 2.0F - 1.0F);
						double d2 = (double)((float)l / 15.0F * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.radius * (0.7F + this.level.random.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;

						for(@SuppressWarnings("unused")
						float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							BlockState blockstate = this.level.getBlockState(blockpos);
							FluidState fluidstate = this.level.getFluidState(blockpos);
							Optional<Float> optional = this.damageCalculator.getBlockExplosionResistance(this, this.level, blockpos, blockstate, fluidstate);
							if (optional.isPresent()) {
								f -= (optional.get() + 0.3F) * 0.3F;
							}

							if (f > 0.0F && this.damageCalculator.shouldBlockExplode(this, this.level, blockpos, blockstate, f)) {
								set.add(blockpos);
							}

							d4 += d0 * (double)0.3F;
							d6 += d1 * (double)0.3F;
							d8 += d2 * (double)0.3F;
						}
					}
				}
			}
		}

		/* 爆発の影響を受ける範囲 */
		this.toBlow.addAll(set);
		float f2 = this.radius * 2.0F;
		int k1 = MathHelper.floor(this.x - (double)f2 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double)f2 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double)f2 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double)f2 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double)f2 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double)f2 + 1.0D);
		List<Entity> list = this.level.getEntities(this.entity, new AxisAlignedBB((double)k1, (double)i2, (double)j2, (double)l1, (double)i1, (double)j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.level, this, list, f2);
		Vector3d vector3d = new Vector3d(this.x, this.y, this.z);

		/* 爆破サイズに応じて、爆破範囲内のエンティティにダメージを与える */
		for(int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);

			/* 爆発への免疫、爆心からの距離に応じてダメージ判定 */
			if (!entity.ignoreExplosion()) {
				double d12 = (double)(MathHelper.sqrt(entity.distanceToSqr(vector3d)) / f2);

				/** 爆心に近いときはダメージ判定を行う **/
				if (d12 <= 1.0D) {
					double d5 = entity.getX() - this.x;
					double d7 = (entity instanceof TNTEntity ? entity.getY() : entity.getEyeY()) - this.y;
					double d9 = entity.getZ() - this.z;
					double d13 = (double)MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
					if (d13 != 0.0D) {
						d5 = d5 / d13;
						d7 = d7 / d13;
						d9 = d9 / d13;
						double d14 = (double)getSeenPercent(vector3d, entity);
						double d10 = (1.0D - d12) * d14;
						entity.hurt(this.getDamageSource(), (float)((int)((d10 * d10 + d10) / 2.0D * 7.0D * (double)f2 + 1.0D)));
						double d11 = d10;

						/* 爆破耐性のエンチャントに対する処理 */
						if (entity instanceof LivingEntity) {
							d11 = ProtectionEnchantment.getExplosionKnockbackAfterDampener((LivingEntity)entity, d10);
						}

						entity.setDeltaMovement(entity.getDeltaMovement().add(d5 * d11, d7 * d11, d9 * d11));

						/* 爆風による吹き飛び 上への吹き飛びを0.8倍 */
						if (entity instanceof PlayerEntity) {
							PlayerEntity playerIn = (PlayerEntity)entity;
							if (!playerIn.isSpectator() && (!playerIn.isCreative() || !playerIn.abilities.flying)) {
								this.hitPlayers.put(playerIn, new Vector3d(d5 * d10, d7 * d10 * 0.8, d9 * d10));
							}
						}
					}
				}
			}
		}

	}

	/* 音やパーティクルの設定
	 * Does the second part of the explosion (sound, particles, drop spawn) */
	@SuppressWarnings("deprecation")
	public void finalizeExplosion(boolean spawnParticles) {

		/** パーティクルの設定 → 弾Entityへ **/
		
		/** ブロックの破壊 **/
		boolean flag = this.blockInteraction != Explosion.Mode.NONE;
		if (flag) {
			ObjectArrayList<Pair<ItemStack, BlockPos>> objectarraylist = new ObjectArrayList<>();
			Collections.shuffle(this.toBlow, this.level.random);

			for(BlockPos blockpos : this.toBlow) {
				BlockState blockstate = this.level.getBlockState(blockpos);
				//Block block = blockstate.getBlock();
				if (!blockstate.isAir(this.level, blockpos)) {
					BlockPos blockpos1 = blockpos.immutable();
					this.level.getProfiler().push("explosion_blocks");
					if (blockstate.canDropFromExplosion(this.level, blockpos, this) && this.level instanceof ServerWorld) {
						TileEntity tileentity = blockstate.hasTileEntity() ? this.level.getBlockEntity(blockpos) : null;
						LootContext.Builder lootcontext$builder = (new LootContext.Builder((ServerWorld)this.level)).withRandom(this.level.random).withParameter(LootParameters.ORIGIN, Vector3d.atCenterOf(blockpos)).withParameter(LootParameters.TOOL, ItemStack.EMPTY).withOptionalParameter(LootParameters.BLOCK_ENTITY, tileentity).withOptionalParameter(LootParameters.THIS_ENTITY, this.entity);
						if (this.blockInteraction == Explosion.Mode.DESTROY) {
							lootcontext$builder.withParameter(LootParameters.EXPLOSION_RADIUS, this.radius);
						}

						blockstate.getDrops(lootcontext$builder).forEach((p_229977_2_) -> {
							addBlockDrops(objectarraylist, p_229977_2_, blockpos1);
						});
					}

					blockstate.onBlockExploded(this.level, blockpos, this);
					this.level.getProfiler().pop();
				}
			}

			for(Pair<ItemStack, BlockPos> pair : objectarraylist) {
				Block.popResource(this.level, pair.getSecond(), pair.getFirst());
			}
		}

		/** 炎上をともなう爆発 **/
		if (this.fire) {
			for(BlockPos blockpos2 : this.toBlow) {
				if (this.random.nextInt(3) == 0 && this.level.getBlockState(blockpos2).isAir() && this.level.getBlockState(blockpos2.below()).isSolidRender(this.level, blockpos2.below())) {
					this.level.setBlockAndUpdate(blockpos2, AbstractFireBlock.getState(this.level, blockpos2));
				}
			}
		}
	}

	private static void addBlockDrops(ObjectArrayList<Pair<ItemStack, BlockPos>> object, ItemStack stack, BlockPos pos) {
		int i = object.size();

		for(int j = 0; j < i; ++j) {
			Pair<ItemStack, BlockPos> pair = object.get(j);
			ItemStack itemstack = pair.getFirst();
			if (ItemEntity.areMergable(itemstack, stack)) {
				ItemStack itemstack1 = ItemEntity.merge(itemstack, stack, 16);
				object.set(j, Pair.of(itemstack1, pair.getSecond()));
				if (stack.isEmpty()) {
					return;
				}
			}
		}

		object.add(Pair.of(stack, pos));
	}

	public DamageSource getDamageSource() {
		return this.damageSource;
	}

	public Map<PlayerEntity, Vector3d> getHitPlayers() {
		return this.hitPlayers;
	}

	/*爆発ブロックを配置したエンティティ、爆発の原因となったエンティティ、またはnullを返す
	 * Returns either the entity that placed the explosive block, the entity that caused the explosion or null. */
	@Nullable
	public LivingEntity getSourceMob() {
		if (this.entity == null) {
			return null;
		} else if (this.entity instanceof TNTEntity) {
			return ((TNTEntity)this.entity).getOwner();
		} else if (this.entity instanceof LivingEntity) {
			return (LivingEntity)this.entity;
		} else {
			if (this.entity instanceof ProjectileEntity) {
				Entity entity = ((ProjectileEntity)this.entity).getOwner();
				if (entity instanceof LivingEntity) {
					return (LivingEntity)entity;
				}
			}

			return null;
		}
	}

	public void clearToBlow() {
		this.toBlow.clear();
	}

	public List<BlockPos> getToBlow() {
		return this.toBlow;
	}

	public Vector3d getPosition() {
		return this.position;
	}

	@Nullable
	public Entity getExploder() {
		return this.entity;
	}

	public static enum Mode {
		NONE,
		BREAK,
		DESTROY;
	}

}
