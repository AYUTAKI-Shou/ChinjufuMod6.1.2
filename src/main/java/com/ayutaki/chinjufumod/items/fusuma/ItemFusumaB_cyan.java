package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_cyan;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_cyan extends ItemBaseFusuma {

	public ItemFusumaB_cyan() {
		super(Fusuma_Blocks.FUSUMAB_cyan);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_cyan.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_cyan.ID));
	}

}
