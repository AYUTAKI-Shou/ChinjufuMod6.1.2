package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.gate.Door_bamboo_K;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemDoor_bamboo_K extends ItemDoor {

	public ItemDoor_bamboo_K() {
		super(Door_Blocks.TAKEDOOR_K);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Door_bamboo_K.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Door_bamboo_K.ID));
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 150;
	}

}
