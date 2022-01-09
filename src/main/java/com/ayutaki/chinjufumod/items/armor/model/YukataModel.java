package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;

public class YukataModel extends BipedModel<LivingEntity> {

	private ModelRenderer GISOU1;
	private ModelRenderer GISOU2;
	private ModelRenderer GISOU3;
	private ModelRenderer GISOU4;
	private ModelRenderer GISOU5;
	private ModelRenderer GISOU7;
	private ModelRenderer GISOU8;
	private ModelRenderer GISOU9;
	private ModelRenderer GISOUA;
	private ModelRenderer GISOUB;

	public YukataModel(float modelSize) {
		super(modelSize, 0.0F, 64, 112);

		this.texWidth = 64;
		this.texHeight = 112;

		/* 帯 */
		this.GISOU1 = new ModelRenderer(this, 32, 32);
		this.GISOU1.addBox(-4.0F, 5.0F, 3.01F, 8, 5, 1);
		this.GISOU1.setPos(0F, 0F, 0F);

		this.GISOU8 = new ModelRenderer(this, 32, 45);
		this.GISOU8.addBox(-4.0F, 7.4F, 3.1F, 8, 5, 1);
		this.GISOU8.setPos(0F, 0F, 0F);

		/* 浴衣用ボディ */
		this.GISOU2 = new ModelRenderer(this, 0, 32);
		this.GISOU2.addBox(-5.0F, -0.5F, -3.0F, 10, 16, 6);
		this.GISOU2.setPos(0F, 0F, 0F);

		/* 左腕 */
		this.GISOU3= new ModelRenderer(this, 24, 54);
		this.GISOU3.addBox(-1.5F, -2.5F, -2.5F, 5, 12, 5);
		this.GISOU3.setPos(0F, 0F, 0F);

		/* 右腕 */
		this.GISOU4= new ModelRenderer(this, 0, 54);
		this.GISOU4.addBox(-3.5F, -2.5F, -2.5F, 5, 12, 5);
		this.GISOU4.setPos(0F, 0F, 0F);

		/* 浴衣左足 */
		this.GISOU5= new ModelRenderer(this, 24, 74);
		this.GISOU5.addBox(-2.85F, -1.01F, -2.9F, 6, 14, 6);
		this.GISOU5.setPos(0F, 0F, 0F);

		this.GISOU9= new ModelRenderer(this, 24, 94);
		this.GISOU9.addBox(-6.85F, -1.01F, -2.901F, 10, 14, 1);
		this.GISOU9.setPos(0F, 0F, 0F);

		/* 浴衣右足 */
		this.GISOU7= new ModelRenderer(this, 0, 74);
		this.GISOU7.addBox(-3.15F, -1.01F, -2.89F, 6, 14, 6);
		this.GISOU7.setPos(0F, 0F, 0F);

		/* 下駄左足 */
		this.GISOUA= new ModelRenderer(this, 0, 94);
		this.GISOUA.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.GISOUA.setPos(0F, 0F, 0F);

		/* 下駄右足 */
		this.GISOUB= new ModelRenderer(this, 0, 94);
		this.GISOUB.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.GISOUB.mirror = true;
		this.GISOUB.setPos(0F, 0F, 0F);

		/* 各箇所の子として位置づける */
		body.addChild(GISOU1);
		body.addChild(GISOU8);
		body.addChild(GISOU2);
		leftArm.addChild(GISOU3);
		rightArm.addChild(GISOU4);

		leftLeg.addChild(GISOU5);
		leftLeg.addChild(GISOU9);
		rightLeg.addChild(GISOU7);

		leftLeg.addChild(GISOUA);
		rightLeg.addChild(GISOUB);
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
