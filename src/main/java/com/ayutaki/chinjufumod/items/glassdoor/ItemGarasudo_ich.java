package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_ichoh;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_ich extends ItemBaseGarasudo {

	public ItemGarasudo_ich() {
		super(Garasudo_Blocks.GARASUDO_ICH);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(GlassDoor_ichoh.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_ichoh.ID));
	}

}
