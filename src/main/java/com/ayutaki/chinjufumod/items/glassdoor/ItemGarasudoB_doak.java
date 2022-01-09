package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_darkoak;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_doak extends ItemBaseGarasudo {

	public ItemGarasudoB_doak() {
		super(Garasudo_Blocks.GARASUDOB_DOAK);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoorB_darkoak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_darkoak.ID));
	}

}
