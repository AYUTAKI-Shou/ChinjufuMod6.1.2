package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_green;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_green extends ItemBaseFusuma {

	public ItemFusuma_green() {
		super(Fusuma_Blocks.FUSUMA_green);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_green.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_green.ID));
	}

}
