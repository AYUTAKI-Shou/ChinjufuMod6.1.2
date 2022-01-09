package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_spruce;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_spru extends ItemBaseGarasudo {

	public ItemGarasudoB_spru() {
		super(Garasudo_Blocks.GARASUDOB_SPRU);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoorB_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_spruce.ID));
	}

}
