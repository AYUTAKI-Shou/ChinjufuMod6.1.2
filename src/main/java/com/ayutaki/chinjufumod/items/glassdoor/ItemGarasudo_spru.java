package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_spruce;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_spru extends ItemBaseGarasudo {

	public ItemGarasudo_spru() {
		super(Garasudo_Blocks.GARASUDO_SPRU);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoor_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_spruce.ID));
	}

}
