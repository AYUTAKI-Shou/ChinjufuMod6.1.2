package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_black;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_black extends ItemBaseFusuma {

	public ItemFusumaB_black() {
		super(Fusuma_Blocks.FUSUMAB_black);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_black.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_black.ID));
	}

}
