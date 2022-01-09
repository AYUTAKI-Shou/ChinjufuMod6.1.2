package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_blue;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_blue extends ItemBaseFusuma {

	public ItemFusumaB_blue() {
		super(Fusuma_Blocks.FUSUMAB_blue);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_blue.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_blue.ID));
	}

}
