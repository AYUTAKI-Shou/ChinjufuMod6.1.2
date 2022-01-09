package com.ayutaki.chinjufumod.entity;

import com.ayutaki.chinjufumod.config.CMConfig_Core;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Entity_AmmoMedium extends Base_EntityAmmo {

	public Entity_AmmoMedium(World worldIn) {
		super(worldIn);
	}

	public Entity_AmmoMedium(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	public Entity_AmmoMedium(World worldIn, EntityLivingBase shooter) {
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
		World worldIn = this.world;

		/* 爆発の呼び出し EntityPlayerを除外して発射時の当たりを避ける */
		EntityLivingBase entitylivingbase = (EntityLivingBase)entity;

		if (!(entitylivingbase instanceof EntityPlayer)) {

			/** 爆心, 爆心からの座標, 威力, 炎上, ブロック破壊の有無
			 * Hypocenter, Coordinates from the hypocenter, Power, Flame, Destroy the block **/
			CMExplosion explosion = new CMExplosion(worldIn, this, this.posX, this.posY, this.posZ, 1.25F, false, CMConfig_Core.blastBlockBreak);
			explosion.doExplosionA();
			explosion.doExplosionB(true);
			this.playSound(SoundEvents_CM.AM_IMPACT, 1.5F, 1.0F);
		}
	}

	/**小口径 音1.0-1.2 威力－, 中口径 音1.5-1.0 威力1.25, 大口径 音2.0-0.8 威力2.5**/
}
