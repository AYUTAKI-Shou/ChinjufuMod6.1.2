package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;

public class Teatime_noFuel extends BlockNamedItem {

	public Teatime_noFuel(Block block, Item.Properties builder) {
		super(block, builder.group(ItemGroups_CM.TEATIME));
	}

}
