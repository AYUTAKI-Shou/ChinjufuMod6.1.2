package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lightblue;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_lightblue extends ItemBaseFusuma {

	public ItemFusuma_lightblue() {
		super(Fusuma_Blocks.FUSUMA_lightblue);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_lightblue.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_lightblue.ID));
	}

}
