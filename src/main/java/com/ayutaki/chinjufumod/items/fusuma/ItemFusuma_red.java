package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_red;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_red extends ItemBaseFusuma {

	public ItemFusuma_red() {
		super(Fusuma_Blocks.FUSUMA_red);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_red.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_red.ID));
	}

}
