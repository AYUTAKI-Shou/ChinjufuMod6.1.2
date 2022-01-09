package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_spruce;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_spru extends ItemBaseShouji {

	public ItemShouji_spru() {
		super(Shouji_Blocks.SHOUJI_SPRU);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_spruce.ID));
	}

}
