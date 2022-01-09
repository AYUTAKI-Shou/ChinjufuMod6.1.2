package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_sakura;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_saku extends ItemBaseGarasudo {

	public ItemGarasudo_saku() {
		super(Garasudo_Blocks.GARASUDO_SAKU);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(GlassDoor_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_sakura.ID));
	}

}
