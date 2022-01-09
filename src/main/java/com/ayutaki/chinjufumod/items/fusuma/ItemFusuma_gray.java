package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_gray;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_gray extends ItemBaseFusuma {

	public ItemFusuma_gray() {
		super(Fusuma_Blocks.FUSUMA_gray);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_gray.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_gray.ID));
	}

}
