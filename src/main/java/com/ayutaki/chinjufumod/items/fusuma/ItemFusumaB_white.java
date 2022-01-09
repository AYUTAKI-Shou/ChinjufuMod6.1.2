package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_white;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_white extends ItemBaseFusuma {

	public ItemFusumaB_white() {
		super(Fusuma_Blocks.FUSUMAB_white);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_white.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_white.ID));
	}

}
