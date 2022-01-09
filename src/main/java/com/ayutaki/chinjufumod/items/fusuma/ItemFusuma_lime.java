package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lime;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_lime extends ItemBaseFusuma {

	public ItemFusuma_lime() {
		super(Fusuma_Blocks.FUSUMA_lime);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_lime.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_lime.ID));
	}

}
