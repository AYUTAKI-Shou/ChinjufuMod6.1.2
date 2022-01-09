package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;

public class ModelSenkanBody extends ModelBiped {

	private ModelRenderer GISOU1;
	private ModelRenderer GISOU2;

	private ModelRenderer GISOU5;
	private ModelRenderer GISOU6;

	public ModelSenkanBody(float scale) {

		super(scale, 0, 80, 96);
		textureWidth = 80;
		textureHeight = 96;

		/* 左右の装甲 */
		this.GISOU1 = new ModelRenderer(this, 0, 58);
		this.GISOU1.addBox(-11.0F, -9.0F, -4.0F, 22, 24, 14);
		this.setRotation(GISOU1, 0F, 0F, 0F);

		/* 背中の煙突 */
		this.GISOU2 = new ModelRenderer(this, 0, 32);
		this.GISOU2.addBox(-11.0F, -9.0F, 3.51F, 22, 24, 2);
		this.setRotation(GISOU2, 0F, 0F, 0F);

		/* 腰にジョイントを付ける場合 */
		this.GISOU5 = new ModelRenderer(this, 48, 42);
		this.GISOU5.addBox(-2.0F, 6.0F, 2.0F, 4, 2, 1);
		this.setRotation(GISOU5, 0F, 0F, 0F);

		this.GISOU6 = new ModelRenderer(this, 48, 32);
		this.GISOU6.addBox(-2.0F, 6.0F, 1.5F, 4, 2, 4);
		this.setRotation(GISOU6, 0F, 0F, 0F);

		/* ボディ(＝チェスト)の子として位置づける */
		bipedBody.addChild(GISOU1);
		bipedBody.addChild(GISOU2);

		bipedBody.addChild(GISOU5);
		bipedBody.addChild(GISOU6);

	}

	/* アーマースタンド用の Facing で向きの不一致を防止 */
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {

		if (entityIn instanceof EntityArmorStand) {
			EntityArmorStand entityarmorstand = (EntityArmorStand)entityIn;
			this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
			this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
			this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
			this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
			this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
			this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
			this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
			this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
			this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
			this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
			this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
			this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
			copyModelAngles(this.bipedHead, this.bipedHeadwear);
		}
		else super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
