package com.ayutaki.chinjufumod.items.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelYukataBody extends ModelBiped {

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

	public ModelYukataBody(float scale) {
		super(scale, 0, 64, 112);

		textureWidth = 64;
		textureHeight = 112;

		/* 帯 */
		this.GISOU1 = new ModelRenderer(this, 32, 32);
		this.GISOU1.addBox(-4.0F, 5.0F, 3.01F, 8, 5, 1);
		this.setRotation(GISOU1, 0F, 0F, 0F);

		this.GISOU8 = new ModelRenderer(this, 32, 45);
		this.GISOU8.addBox(-4.0F, 7.4F, 3.1F, 8, 5, 1);
		this.setRotation(GISOU8, 0F, 0F, 0F);

		/* 浴衣用ボディ */
		this.GISOU2 = new ModelRenderer(this, 0, 32);
		this.GISOU2.addBox(-5.0F, -0.5F, -3.0F, 10, 16, 6);
		this.setRotation(GISOU2, 0F, 0F, 0F);

		/* 左腕 */
		this.GISOU3= new ModelRenderer(this, 24, 54);
		this.GISOU3.addBox(-1.5F, -2.5F, -2.5F, 5, 12, 5);
		this.setRotation(GISOU3, 0F, 0F, 0F);

		/* 右腕 */
		this.GISOU4= new ModelRenderer(this, 0, 54);
		this.GISOU4.addBox(-3.5F, -2.5F, -2.5F, 5, 12, 5);
		this.setRotation(GISOU4, 0F, 0F, 0F);

		/* 浴衣左足 */
		this.GISOU5= new ModelRenderer(this, 24, 74);
		this.GISOU5.addBox(-2.85F, -1.01F, -2.9F, 6, 14, 6);
		this.setRotation(GISOU5, 0F, 0F, 0F);

		this.GISOU9= new ModelRenderer(this, 24, 94);
		this.GISOU9.addBox(-6.85F, -1.01F, -2.901F, 10, 14, 1);
		this.setRotation(GISOU9, 0F, 0F, 0F);

		/* 浴衣右足 */
		this.GISOU7= new ModelRenderer(this, 0, 74);
		this.GISOU7.addBox(-3.15F, -1.01F, -2.89F, 6, 14, 6);
		this.setRotation(GISOU7, 0F, 0F, 0F);

		/* 下駄左足 */
		this.GISOUA= new ModelRenderer(this, 0, 94);
		this.GISOUA.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.setRotation(GISOUA, 0F, 0F, 0F);

		/* 下駄右足 */
		this.GISOUB= new ModelRenderer(this, 0, 94);
		this.GISOUB.addBox(-2.5F, -0.99F, -2.5F, 5, 13, 5);
		this.GISOUB.mirror = true;
		this.setRotation(GISOUB, 0F, 0F, 0F);

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

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
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
