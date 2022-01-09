package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_kaede;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_kae extends ItemBaseGarasudo {

	public ItemGarasudo_kae() {
		super(Garasudo_Blocks.GARASUDO_KAE);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(GlassDoor_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_kaede.ID));
	}

}
