package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_spruce;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_spru extends ItemBaseShouji {

	public ItemShoujiA_spru() {
		super(Shouji_Blocks.SHOUJIA_SPRU);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(ShoujiB_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_spruce.ID));
	}

}
