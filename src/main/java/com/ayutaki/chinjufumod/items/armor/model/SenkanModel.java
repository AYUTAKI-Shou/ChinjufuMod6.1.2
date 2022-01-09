package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;

public class SenkanModel extends BipedModel<LivingEntity> {

	private ModelRenderer GISOU1;
	private ModelRenderer GISOU2;

	private ModelRenderer GISOU5;
	private ModelRenderer GISOU6;

	public SenkanModel(float modelSize) {
		super(modelSize, 0.0F, 80, 96);

		this.texWidth = 80;
		this.texHeight = 96;

		/* 左右の装甲 */
		this.GISOU1 = new ModelRenderer(this, 0, 58);
		this.GISOU1.addBox(-11.0F, -9.0F, -4.0F, 22, 24, 14);
		this.GISOU1.setPos(0F, 0F, 0F);

		/* 背中の煙突 */
		this.GISOU2 = new ModelRenderer(this, 0, 32);
		this.GISOU2.addBox(-11.0F, -9.0F, 3.51F, 22, 24, 2);
		this.GISOU2.setPos(0F, 0F, 0F);

		/* 腰にジョイントを付ける場合 */
		this.GISOU5 = new ModelRenderer(this, 48, 42);
		this.GISOU5.addBox(-2.0F, 6.0F, 2.0F, 4, 2, 1);
		this.GISOU5.setPos(0F, 0F, 0F);

		this.GISOU6 = new ModelRenderer(this, 48, 32);
		this.GISOU6.addBox(-2.0F, 6.0F, 1.5F, 4, 2, 4);
		this.GISOU6.setPos(0F, 0F, 0F);

		/* ボディ(＝チェスト)の子として位置づける */
		body.addChild(GISOU1);
		body.addChild(GISOU2);

		body.addChild(GISOU5);
		body.addChild(GISOU6);
	}

	protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	/* アーマースタンドでの向き不一致を防止 */
	public void setupAnim(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		if (entityIn instanceof ArmorStandEntity) {
			ArmorStandEntity armorstand = (ArmorStandEntity) entityIn;
			this.head.xRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getX();
			this.head.yRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getY();
			this.head.zRot = ((float)Math.PI / 180F) * armorstand.getHeadPose().getZ();
			this.head.setPos(0.0F, 1.0F, 0.0F);
			this.body.xRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getX();
			this.body.yRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getY();
			this.body.zRot = ((float)Math.PI / 180F) * armorstand.getBodyPose().getZ();
			this.leftArm.xRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getX();
			this.leftArm.yRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getY();
			this.leftArm.zRot = ((float)Math.PI / 180F) * armorstand.getLeftArmPose().getZ();
			this.rightArm.xRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getX();
			this.rightArm.yRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getY();
			this.rightArm.zRot = ((float)Math.PI / 180F) * armorstand.getRightArmPose().getZ();
			this.leftLeg.xRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getX();
			this.leftLeg.yRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getY();
			this.leftLeg.zRot = ((float)Math.PI / 180F) * armorstand.getLeftLegPose().getZ();
			this.leftLeg.setPos(1.9F, 11.0F, 0.0F);
			this.rightLeg.xRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getX();
			this.rightLeg.yRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getY();
			this.rightLeg.zRot = ((float)Math.PI / 180F) * armorstand.getRightLegPose().getZ();
			this.rightLeg.setPos(-1.9F, 11.0F, 0.0F);
			this.hat.copyFrom(this.head);
		}

		else super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

}
