package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_darkoak;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_doak extends ItemBaseGarasudo {

	public ItemGarasudo_doak() {
		super(Garasudo_Blocks.GARASUDO_DOAK);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoor_darkoak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_darkoak.ID));
	}

}
