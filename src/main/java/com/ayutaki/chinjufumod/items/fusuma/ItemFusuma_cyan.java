package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_cyan;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_cyan extends ItemBaseFusuma {

	public ItemFusuma_cyan() {
		super(Fusuma_Blocks.FUSUMA_cyan);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_cyan.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_cyan.ID));
	}

}
