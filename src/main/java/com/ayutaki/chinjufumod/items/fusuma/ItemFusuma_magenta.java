package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_magenta;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusuma_magenta extends ItemBaseFusuma {

	public ItemFusuma_magenta() {
		super(Fusuma_Blocks.FUSUMA_magenta);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Fusuma_magenta.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Fusuma_magenta.ID));
	}

}
