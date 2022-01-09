package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_oak;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_oak extends ItemBaseGarasudo {

	public ItemGarasudo_oak() {
		super(Garasudo_Blocks.GARASUDO);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoor_oak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_oak.ID));
	}

}
