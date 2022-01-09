package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_magenta;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_magenta extends ItemBaseFusuma {

	public ItemFusumaB_magenta() {
		super(Fusuma_Blocks.FUSUMAB_magenta);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_magenta.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_magenta.ID));
	}

}
