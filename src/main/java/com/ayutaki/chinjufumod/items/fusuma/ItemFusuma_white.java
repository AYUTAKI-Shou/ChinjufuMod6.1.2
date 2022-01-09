package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_white;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_white extends ItemBaseFusuma {

	public ItemFusuma_white() {
		super(Fusuma_Blocks.FUSUMA_white);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_white.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_white.ID));
	}

}
