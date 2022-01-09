package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_brown;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_brown extends ItemBaseFusuma {

	public ItemFusuma_brown() {
		super(Fusuma_Blocks.FUSUMA_brown);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_brown.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_brown.ID));
	}

}
