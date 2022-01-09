package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.items.armor.model.GisouModel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KagaArmor extends ArmorItem {

	public KagaArmor(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, Armor _default) {

		GisouModel armorModel = new GisouModel(1.0F);
		GisouModel armorModelLegs = new GisouModel(0.5F);

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

}
