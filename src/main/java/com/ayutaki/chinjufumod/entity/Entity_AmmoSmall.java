package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Entity_AmmoSmall extends Base_EntityAmmo implements IProjectile {

	public Entity_AmmoSmall(World worldIn) {
		super(worldIn);
	}

	public Entity_AmmoSmall(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public Entity_AmmoSmall(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	/* 不可欠なメソッドだが、AIRを呼び出して無効化 */
	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(Items.AIR);
	}

	/* ここから エンティティやブロックに当たった時の処理 */
	public void onUpdate() {
		super.onUpdate();

		/* inGroundを上書きして、地面衝突時の処理を指定 */
		if (this.inGround) {

			/** inGroundで弾エンティティを消す **/
			this.setDead();
		}
	}

	@Override
	public void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);

		Entity entity = raytraceResultIn.entityHit;

		/* 爆発の呼び出し */
		this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.5D, 0.0D);

		/* 効果音の上書き */
		if (entity != null) {
			this.playSound(SoundEvents_CM.AM_IMPACT, 1.0F, 1.2F);
		}
		else {
			this.playSound(SoundEvents_CM.AM_IMPACT, 1.0F, 1.2F);
		}

	}

	/* エンティティに当たった時、爆発を呼び出して範囲攻撃 */
	@Override
	public void arrowHit(EntityLivingBase living) {
		super.arrowHit(living);

		/* 効果音の呼び出し */
		this.playSound(SoundEvents_CM.AM_IMPACT, 1.0F, 1.2F);

		/* 爆発の呼び出し */
		this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.5D, 0.0D);

	}
/**小口径 音1.0-1.2 威力－, 中口径 音1.5-1.0 威力1.0, 大口径 音2.0-0.8 威力1.8**/
}
