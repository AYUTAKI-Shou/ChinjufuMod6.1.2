package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_yellow;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_yellow extends ItemBaseFusuma {

	public ItemFusumaB_yellow() {
		super(Fusuma_Blocks.FUSUMAB_yellow);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_yellow.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_yellow.ID));
	}

}
