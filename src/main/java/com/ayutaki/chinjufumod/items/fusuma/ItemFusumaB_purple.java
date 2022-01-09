package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_purple;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_purple extends ItemBaseFusuma {

	public ItemFusumaB_purple() {
		super(Fusuma_Blocks.FUSUMAB_purple);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_purple.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_purple.ID));
	}

}
