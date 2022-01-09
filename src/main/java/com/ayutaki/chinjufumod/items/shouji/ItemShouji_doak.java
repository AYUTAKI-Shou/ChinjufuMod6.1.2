package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_darkoak;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_doak extends ItemBaseShouji {

	public ItemShouji_doak() {
		super(Shouji_Blocks.SHOUJI_DOAK);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_darkoak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_darkoak.ID));
	}

}