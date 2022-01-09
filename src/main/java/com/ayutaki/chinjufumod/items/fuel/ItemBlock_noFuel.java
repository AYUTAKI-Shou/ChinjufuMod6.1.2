package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

public class ItemBlock_noFuel extends ItemBlock {

	public ItemBlock_noFuel(Block block, String unlocalizedName) {
		super(block);

		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
	}

}
