package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_birch;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_bir extends ItemBaseGarasudo {

	public ItemGarasudoB_bir() {
		super(Garasudo_Blocks.GARASUDOB_BIR);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoorB_birch.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_birch.ID));
	}

}
