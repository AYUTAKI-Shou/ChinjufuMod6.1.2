package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_orange;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_orange extends ItemBaseFusuma {

	public ItemFusumaB_orange() {
		super(Fusuma_Blocks.FUSUMAB_orange);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_orange.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_orange.ID));
	}

}
