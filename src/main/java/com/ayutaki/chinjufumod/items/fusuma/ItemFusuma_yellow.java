package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_yellow;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_yellow extends ItemBaseFusuma {

	public ItemFusuma_yellow() {
		super(Fusuma_Blocks.FUSUMA_yellow);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_yellow.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_yellow.ID));
	}

}
