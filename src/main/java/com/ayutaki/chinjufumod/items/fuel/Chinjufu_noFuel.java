package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class Chinjufu_noFuel extends BlockNamedItem {

	public Chinjufu_noFuel(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.CHINJUFU));
	}

	/* BurnTime in a Furnace */

}
