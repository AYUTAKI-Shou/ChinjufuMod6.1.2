package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Teatime_Fuel300 extends BlockNamedItem {

	public Teatime_Fuel300(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.TEATIME));
	}

	/* BurnTime in a Furnace */
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 300;
	}

}
