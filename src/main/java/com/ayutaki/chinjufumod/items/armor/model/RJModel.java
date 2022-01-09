package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;

public class RJModel extends BipedModel<LivingEntity> {

	private ModelRenderer GISOU1;
	private ModelRenderer GISOU2;
	private ModelRenderer GISOU5;
	private ModelRenderer GISOU6;
	private ModelRenderer GISOU7;

	public RJModel(float modelSize) {
		super(modelSize, 0.0F, 64, 120);

		textureWidth = 64;
		textureHeight = 120;

		/* 電探と煙突 */
		this.GISOU1 = new ModelRenderer(this, 0, 71);
		this.GISOU1.addBox(-11.0F, -10.0F, 4.01F, 22, 28, 1);
		this.GISOU1.setRotationPoint(0F, 0F, 0F);

		/* レギンス用の薄いボディ */
		this.GISOU2 = new ModelRenderer(this, 0, 52);
		this.GISOU2.addBox(-4.5F, -0.5F, -2.5F, 9, 14, 5);
		this.GISOU2.setRotationPoint(0F, 0F, 0F);

		/* レギンス左足 */
		this.GISOU5= new ModelRenderer(this, 0, 100);
		this.GISOU5.addBox(-2.5F, -1.01F, -2.5F, 5, 8, 5);
		this.GISOU5.setRotationPoint(0F, 0F, 0F);

		/* レギンス右足 */
		this.GISOU6= new ModelRenderer(this, 0, 100);
		this.GISOU6.mirror = true;
		this.GISOU6.addBox(-2.5F, -1.01F, -2.5F, 5, 8, 5);
		this.GISOU6.setRotationPoint(0F, 0F, 0F);

		/* 龍驤バイザー */
		this.GISOU7= new ModelRenderer(this, 20, 100);
		this.GISOU7.addBox(-5.0F, -10.0F, -8.1F, 10, 5, 3);
		this.GISOU7.setRotationPoint( 0F, 0F, 0F);

		/* ボディ(＝チェストプレート)の子として位置づける */
		bipedBody.addChild(GISOU1);
		bipedBody.addChild(GISOU2);

		bipedLeftLeg.addChild(GISOU5);
		bipedRightLeg.addChild(GISOU6);
		bipedHead.addChild(GISOU7);
		this.bipedHeadwear.showModel = false;
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
