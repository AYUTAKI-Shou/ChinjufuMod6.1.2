package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_oak;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_oak extends ItemBaseShouji {

	public ItemShouji_oak() {
		super(Shouji_Blocks.SHOUJI);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_oak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_oak.ID));
	}

}
