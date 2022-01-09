package com.ayutaki.chinjufumod.items.fusuma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_brown;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemFusumaB_brown extends ItemBaseFusuma {

	public ItemFusumaB_brown() {
		super(Fusuma_Blocks.FUSUMAB_brown);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(FusumaB_brown.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, FusumaB_brown.ID));
	}

}
