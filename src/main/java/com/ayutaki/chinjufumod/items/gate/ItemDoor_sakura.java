package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.gate.Door_sakura;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemDoor_sakura extends ItemDoor {

	public ItemDoor_sakura() {
		super(Door_Blocks.DOOR_SAKURA);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Door_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Door_sakura.ID));
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
	}

}
