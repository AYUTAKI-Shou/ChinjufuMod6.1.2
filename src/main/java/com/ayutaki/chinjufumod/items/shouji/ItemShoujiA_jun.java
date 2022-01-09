package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_jungle;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_jun extends ItemBaseShouji {

	public ItemShoujiA_jun() {
		super(Shouji_Blocks.SHOUJIA_JUN);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(ShoujiB_jungle.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_jungle.ID));
	}

}
