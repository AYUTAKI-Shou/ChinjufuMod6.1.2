package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_orange;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_orange extends ItemBaseFusuma {

	public ItemFusuma_orange() {
		super(Fusuma_Blocks.FUSUMA_orange);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_orange.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_orange.ID));
	}

}
