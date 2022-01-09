package com.ayutaki.chinjufumod.items.fuel;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBlock_Fuel100 extends ItemBlock {

	public ItemBlock_Fuel100(Block block, String unlocalizedName) {
		super(block);

		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 100;
	}

}
