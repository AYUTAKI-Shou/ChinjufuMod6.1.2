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

		textureWidth = 64;
		textureHeight = 112;

		/* 帯 */
		this.GISOU1 = new ModelRenderer(this, 32, 32);
		this.GISOU1.addBox(-4.0F, 5.0F, 3.01F, 8, 5, 1);
		this.GISOU1.setRotationPoint(0F, 0F, 0F);

		this.GISOU8 = new ModelRenderer(this, 32, 45);
		this.GISOU8.addBox(-4.0F, 7.4F, 3.1F, 8, 5, 1);
		this.GISOU8.setRotationPoint(0F, 0F, 0F);

		/* 浴衣用ボディ */
		this.GISOU2 = new ModelRenderer(this, 0, 32);
		this.GISOU2.addBox(-5.0F, -0.5F, -3.0F, 10, 16, 6);
		this.GISOU2.setRotationPoint(0F, 0F, 0F);

		/* 左腕 */
		this.GISOU3= new ModelRenderer(this, 24, 54);
		this.GISOU3.addBox(-1.5F, -2.5F, -2.5F, 5, 12, 5);
		this.GISOU3.setRotationPoint(0F, 0F, 0F);

		/* 右腕 */
		this.GISOU4= new ModelRenderer(this, 0, 54);
		this.GISOU4.addBox(-3.5F, -2.5F, -2.5F, 5, 12, 5);
		this.GISOU4.setRotationPoint(0F, 0F, 0F);

		/* 浴衣左足 */
		this.GISOU5= new ModelRenderer(this, 24, 74);
		this.GISOU5.addBox(-2.85F, -1.01F, -2.9F, 6, 14, 6);
		this.GISOU5.setRotationPoint(0F, 0F, 0F);

		this.GISOU9= new ModelRenderer(this, 24, 94);
		this.GISOU9.addBox(-6.85F, -1.01F, -2.901F, 10, 14, 1);
		this.GISOU9.setRotationPoint(0F, 0F, 0F);

		/* 浴衣右足 */
		this.GISOU7= new ModelRenderer(this, 0, 74);
		this.GISOU7.addBox(-3.15F, -1.01F, -2.89F, 6, 14, 6);
		this.GISOU7.setRotationPoint(0F, 0F, 0F);

		/* 下駄左足 */
		this.GISOUA= new ModelRenderer(this, 0, 94);
		this.GISOUA.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.GISOUA.setRotationPoint(0F, 0F, 0F);

		/* 下駄右足 */
		this.GISOUB= new ModelRenderer(this, 0, 94);
		this.GISOUB.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.GISOUB.mirror = true;
		this.GISOUB.setRotationPoint(0F, 0F, 0F);

		/* 各箇所の子として位置づける */
		bipedBody.addChild(GISOU1);
		bipedBody.addChild(GISOU8);
		bipedBody.addChild(GISOU2);
		bipedLeftArm.addChild(GISOU3);
		bipedRightArm.addChild(GISOU4);

		bipedLeftLeg.addChild(GISOU5);
		bipedLeftLeg.addChild(GISOU9);
		bipedRightLeg.addChild(GISOU7);

		bipedLeftLeg.addChild(GISOUA);
		bipedRightLeg.addChild(GISOUB);
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
