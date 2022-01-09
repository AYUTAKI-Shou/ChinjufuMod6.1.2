package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_purple;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_purple extends ItemBaseFusuma {

	public ItemFusuma_purple() {
		super(Fusuma_Blocks.FUSUMA_purple);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_purple.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_purple.ID));
	}

}
