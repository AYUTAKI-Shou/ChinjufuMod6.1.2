package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_oak;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_oak extends ItemBaseShouji {

	public ItemShoujiA_oak() {
		super(Shouji_Blocks.SHOUJIA);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(ShoujiB_oak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_oak.ID));
	}

}
