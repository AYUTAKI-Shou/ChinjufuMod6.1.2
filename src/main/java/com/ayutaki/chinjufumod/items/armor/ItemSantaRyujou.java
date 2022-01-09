package com.ayutaki.chinjufumod.items.armor;

import com.ayutaki.chinjufumod.registry.Items_ArmorMaterial;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemSantaRyujou extends ItemArmor {

	public ItemSantaRyujou(int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(Items_ArmorMaterial.RYUJOUSANTA, renderIndexIn, equipmentSlotIn);

	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {

		int k;
		k = repair.getMetadata();

		if (this == Items_Seasonal.RYUJOUSANTA_BOOTS) {

			if (k == 15) {
				return (repair.getItem() == Item.getItemFromBlock(Blocks.CARPET)); }

			if (k != 15) { return false; }
		}

		if (k == 14) {
			return (repair.getItem() == Item.getItemFromBlock(Blocks.CARPET)); }

		return false;
	}
}
