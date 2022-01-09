package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.gate.Door_kaede;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemDoor_kaede extends ItemDoor {

	public ItemDoor_kaede() {
		super(Door_Blocks.DOOR_KAEDE);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Door_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Door_kaede.ID));
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
	}

}
