package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_jungle;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_jun extends ItemBaseShouji {

	public ItemShouji_jun() {
		super(Shouji_Blocks.SHOUJI_JUN);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_jungle.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_jungle.ID));
	}

}
