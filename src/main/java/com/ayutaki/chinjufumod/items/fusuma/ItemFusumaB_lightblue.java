package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lightblue;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_lightblue extends ItemBaseFusuma {

	public ItemFusumaB_lightblue() {
		super(Fusuma_Blocks.FUSUMAB_lightblue);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_lightblue.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_lightblue.ID));
	}

}