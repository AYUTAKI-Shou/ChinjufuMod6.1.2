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
				armorModel.head.visible = armorSlot == EquipmentSlotType.HEAD;
				armorModel.hat.visible = armorSlot == EquipmentSlotType.HEAD;
				armorModel.body.visible = (armorSlot == EquipmentSlotType.CHEST) || (armorSlot == EquipmentSlotType.CHEST);
				armorModel.rightArm.visible = armorSlot == EquipmentSlotType.CHEST;
				armorModel.leftArm.visible = armorSlot == EquipmentSlotType.CHEST;
				armorModelLegs.rightLeg.visible = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);
				armorModelLegs.leftLeg.visible = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);

				armorModel.crouching = entityLiving.isCrouching();
				armorModel.young = entityLiving.isBaby();

				armorModelLegs.crouching = entityLiving.isCrouching();
				armorModelLegs.young = entityLiving.isBaby();
			}
			return (Armor)armorModel;
		}
		return null;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
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
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);

		if (this != Items_Seasonal.YKTD_GETA && this != Items_Seasonal.YKTO_GETA &&
			this != Items_Seasonal.IKADUCHIYKT_HELMET && this != Items_Seasonal.INADUMAYKT_HELMET &&
			this != Items_Seasonal.KAWAKAZEYKT_HELMET && this != Items_Seasonal.URAKAZEYKT_HELMET &&
			this != Items_Seasonal.OBOROYKT_HELMET && this != Items_Seasonal.HAMAKAZEYKT_HELMET) {

			tooltip.add((new TranslationTextComponent("tips.item_ykt")).withStyle(TextFormatting.GRAY)); }
	}

}
