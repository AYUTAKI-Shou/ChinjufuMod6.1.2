package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lightgray;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_lightgray extends ItemBaseFusuma {

	public ItemFusumaB_lightgray() {
		super(Fusuma_Blocks.FUSUMAB_lightgray);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_lightgray.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_lightgray.ID));
	}

}
