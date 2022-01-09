package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_sakura;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_saku extends ItemBaseGarasudo {

	public ItemGarasudoB_saku() {
		super(Garasudo_Blocks.GARASUDOB_SAKU);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(GlassDoorB_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_sakura.ID));
	}

}
