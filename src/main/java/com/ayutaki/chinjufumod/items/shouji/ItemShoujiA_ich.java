package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_ichoh;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_ich extends ItemBaseShouji {

	public ItemShoujiA_ich() {
		super(Shouji_Blocks.SHOUJIA_ICH);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(ShoujiB_ichoh.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_ichoh.ID));
	}

}
