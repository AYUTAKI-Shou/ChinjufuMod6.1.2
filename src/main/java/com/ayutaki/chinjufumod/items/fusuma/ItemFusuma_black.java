package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_black;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_black extends ItemBaseFusuma {

	public ItemFusuma_black() {
		super(Fusuma_Blocks.FUSUMA_black);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_black.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_black.ID));
	}

}
