package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lime;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_lime extends ItemBaseFusuma {

	public ItemFusumaB_lime() {
		super(Fusuma_Blocks.FUSUMAB_lime);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_lime.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_lime.ID));
	}

}
