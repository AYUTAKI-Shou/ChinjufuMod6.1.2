package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_gray;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_gray extends ItemBaseFusuma {

	public ItemFusumaB_gray() {
		super(Fusuma_Blocks.FUSUMAB_gray);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_gray.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_gray.ID));
	}

}
