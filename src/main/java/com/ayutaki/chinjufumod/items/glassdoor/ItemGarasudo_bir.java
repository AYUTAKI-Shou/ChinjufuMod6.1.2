package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_birch;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_bir extends ItemBaseGarasudo {

	public ItemGarasudo_bir() {
		super(Garasudo_Blocks.GARASUDO_BIR);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoor_birch.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_birch.ID));
	}

}
