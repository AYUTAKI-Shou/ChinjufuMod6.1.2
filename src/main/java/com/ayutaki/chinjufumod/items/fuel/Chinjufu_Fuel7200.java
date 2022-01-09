package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Chinjufu_Fuel7200 extends BlockNamedItem {

	public Chinjufu_Fuel7200(Block block, Item.Properties builder) {
		super(block, builder.group(ItemGroups_CM.CHINJUFU));
	}

	/* かまど燃焼時間 */
	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 7200;
	}

}
