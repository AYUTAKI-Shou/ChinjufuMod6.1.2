package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lightgray;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_lightgray extends ItemBaseFusuma {

	public ItemFusuma_lightgray() {
		super(Fusuma_Blocks.FUSUMA_lightgray);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_lightgray.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_lightgray.ID));
	}

}
