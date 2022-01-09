package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_jungle;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_jun extends ItemBaseGarasudo {

	public ItemGarasudoB_jun() {
		super(Garasudo_Blocks.GARASUDOB_JUN);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoorB_jungle.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_jungle.ID));
	}

}
