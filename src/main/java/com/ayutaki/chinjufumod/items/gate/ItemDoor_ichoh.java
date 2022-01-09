package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.gate.Door_ichoh;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemDoor_ichoh extends ItemDoor {

	public ItemDoor_ichoh() {
		super(Door_Blocks.DOOR_ICHOH);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Door_ichoh.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Door_ichoh.ID));
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
	}

}
