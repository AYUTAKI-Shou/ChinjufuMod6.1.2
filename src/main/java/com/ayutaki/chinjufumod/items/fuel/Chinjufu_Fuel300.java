package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Chinjufu_Fuel300 extends BlockNamedItem {

	public Chinjufu_Fuel300(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.CHINJUFU));
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 300;
	}

}
