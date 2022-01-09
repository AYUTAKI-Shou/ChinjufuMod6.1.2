package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_blue;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_blue extends ItemBaseFusuma {

	public ItemFusuma_blue() {
		super(Fusuma_Blocks.FUSUMA_blue);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_blue.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_blue.ID));
	}

}
