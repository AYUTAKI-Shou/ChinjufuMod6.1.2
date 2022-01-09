package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_ichoh;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_ich extends ItemBaseShouji {

	public ItemShouji_ich() {
		super(Shouji_Blocks.SHOUJI_ICH);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Shouji_ichoh.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_ichoh.ID));
	}

}
