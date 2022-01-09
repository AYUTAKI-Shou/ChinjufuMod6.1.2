package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.YukataModel;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Yukata extends ArmorItem {

	public Yukata(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, Armor _default) {

		YukataModel armorModel = new YukataModel(1.0F);
		YukataModel armorModelLegs = new YukataModel(0.5F);

		if (itemStack != null) {

			if (armorModel != null) {
				armorModel.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
				armorModel.bipedHeadwear.showModel = armorSlot == EquipmentSlotType.HEAD;
				armorModel.bipedBody.showModel = (armorSlot == EquipmentSlotType.CHEST) || (armorSlot == EquipmentSlotType.CHEST);
				armorModel.bipedRightArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				armorModel.bipedLeftArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				armorModelLegs.bipedRightLeg.showModel = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);
				armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);

				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isChild = entityLiving.isChild();

				armorModelLegs.isSneak = entityLiving.isSneaking();
				armorModelLegs.isChild = entityLiving.isChild();
			}
			return (Armor)armorModel;
		}
		return null;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		if (this == Items_Seasonal.YKTD_GETA) { return material.getItem() == Items.DARK_OAK_SLAB; }

		if (this == Items_Seasonal.YKTO_GETA) { return material.getItem() == Items.OAK_SLAB; }

		if (this == Items_Seasonal.IKADUCHIYKT_HELMET || this == Items_Seasonal.INADUMAYKT_HELMET) {
			return material.getItem() == Items_Seasonal.KAEDE_slabhalf; }

		if (this == Items_Seasonal.KAWAKAZEYKT_HELMET || this == Items_Seasonal.URAKAZEYKT_HELMET) {
			return material.getItem() == Items.BIRCH_SLAB; }

		if (this == Items_Seasonal.OBOROYKT_HELMET) { return material.getItem() == Items.DANDELION; }

		if (this == Items_Seasonal.HAMAKAZEYKT_HELMET) { return material.getItem() == Items.POPPY; }

		else { return material.getItem() == Items_Seasonal.TANMONO; }
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);

		if (this != Items_Seasonal.YKTD_GETA && this != Items_Seasonal.YKTO_GETA &&
			this != Items_Seasonal.IKADUCHIYKT_HELMET && this != Items_Seasonal.INADUMAYKT_HELMET &&
			this != Items_Seasonal.KAWAKAZEYKT_HELMET && this != Items_Seasonal.URAKAZEYKT_HELMET &&
			this != Items_Seasonal.OBOROYKT_HELMET && this != Items_Seasonal.HAMAKAZEYKT_HELMET) {

			tooltip.add((new TranslationTextComponent("tips.item_ykt")).applyTextStyle(TextFormatting.GRAY)); }
	}

}
