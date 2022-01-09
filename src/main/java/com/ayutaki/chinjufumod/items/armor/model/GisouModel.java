package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;

public class GisouModel extends BipedModel<LivingEntity> {

	private ModelRenderer GISOU1;
	private ModelRenderer GISOU2;
	private ModelRenderer GISOU3;
	private ModelRenderer GISOU4;
	private ModelRenderer GISOU5;
	private ModelRenderer GISOU6;

	public GisouModel(float modelSize) {
		super(modelSize, 0.0F, 64, 120);

		textureWidth = 64;
		textureHeight = 120;

		/* 電探と煙突 */
		this.GISOU1 = new ModelRenderer(this, 0, 71);
		this.GISOU1.addBox(-11.0F, -10.0F, 4.01F, 22, 28, 1);
		this.GISOU1.setRotationPoint(0F, 0F, 0F);

		/* ボディに別枠を被せる */
		this.GISOU2 = new ModelRenderer(this, 0, 52);
		this.GISOU2.addBox(-5.0F, -1.0F, -3.1F, 10, 12, 7);
		this.GISOU2.setRotationPoint(0F, 0F, 0F);

		/* 左腕甲板 */
		this.GISOU3= new ModelRenderer(this, 46, 32);
		this.GISOU3.addBox(4.0F, -8.0F, -4.0F, 1, 24, 8);
		this.GISOU3.setRotationPoint(0F, 0F, 0F);

		/* 右腕甲板 */
		this.GISOU4= new ModelRenderer(this, 46, 64);
		this.GISOU4.addBox(-5.0F, -8.0F, -4.0F, 1, 24, 8);
		this.GISOU4.setRotationPoint(0F, 0F, 0F);

		/* 左足ブーツ */
		this.GISOU5= new ModelRenderer(this, 0, 100);
		this.GISOU5.addBox(-2.5F, 5.1F, -2.5F, 5, 8, 5);
		this.GISOU5.setRotationPoint(0F, 0F, 0F);

		/* 右足ブーツ */
		this.GISOU6= new ModelRenderer(this, 0, 100);
		this.GISOU6.mirror = true;
		this.GISOU6.addBox(-2.5F, 5.1F, -2.5F, 5, 8, 5);
		this.GISOU6.setRotationPoint(0F, 0F, 0F);

		/* ボディ(＝チェストプレート)の子として位置づける */
		bipedBody.addChild(GISOU1);
		bipedBody.addChild(GISOU2);
		bipedLeftArm.addChild(GISOU3);
		bipedRightArm.addChild(GISOU4);

		bipedLeftLeg.addChild(GISOU5);
		bipedRightLeg.addChild(GISOU6);

	}

	protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	/* アーマースタンドでの向き不一致を防止 */
	public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		if (entityIn instanceof ArmorStandEntity) {
			ArmorStandEntity armorstand = (ArmorStandEntity) entityIn;
			this.bipedHead.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			this.bipedBody.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getBodyRotation().getZ();
			this.bipedLeftArm.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getLeftArmRotation().getZ();
			this.bipedRightArm.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getRightArmRotation().getZ();
			this.bipedLeftLeg.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			this.bipedRightLeg.rotateAngleX = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = ((float)Math.PI / 180F) * armorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			this.bipedHeadwear.copyModelAngles(this.bipedHead);
		}

		else super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

}
