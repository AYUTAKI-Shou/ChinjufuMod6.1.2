package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_pink;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_pink extends ItemBaseFusuma {

	public ItemFusuma_pink() {
		super(Fusuma_Blocks.FUSUMA_pink);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_pink.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_pink.ID));
	}

}
