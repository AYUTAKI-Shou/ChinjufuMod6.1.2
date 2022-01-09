package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_pink;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_pink extends ItemBaseFusuma {

	public ItemFusumaB_pink() {
		super(Fusuma_Blocks.FUSUMAB_pink);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_pink.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_pink.ID));
	}

}
