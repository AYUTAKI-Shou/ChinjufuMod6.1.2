package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_red;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_red extends ItemBaseFusuma {

	public ItemFusumaB_red() {
		super(Fusuma_Blocks.FUSUMAB_red);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_red.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_red.ID));
	}

}
