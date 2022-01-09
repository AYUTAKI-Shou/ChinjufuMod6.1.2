package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_kaede;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_kae extends ItemBaseGarasudo {

	public ItemGarasudoB_kae() {
		super(Garasudo_Blocks.GARASUDOB_KAE);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(GlassDoorB_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_kaede.ID));
	}

}
