package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_birch;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_bir extends ItemBaseShouji {

	public ItemShouji_bir() {
		super(Shouji_Blocks.SHOUJI_BIR);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_birch.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_birch.ID));
	}

}
