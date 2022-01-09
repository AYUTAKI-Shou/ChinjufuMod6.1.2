package com.ayutaki.chinjufumod.items.teatime;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class ItemPasta extends Item {

	public ItemPasta(String unlocalizedName) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_food_pasta_n";
		case 2:
			return "item." + "item_food_pasta_s";
		case 3:
			return "item." + "item_food_udon_n";
		case 4:
			return "item." + "item_food_shouyu_don";
		case 5:
			return "item." + "item_food_tsuyu_don";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
		}
	}

	/* ToolTip*/


}
