package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class Seasonal_noFuel extends BlockNamedItem {

	public Seasonal_noFuel(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.SEASONAL));
	}

	/* BurnTime in a Furnace */

}