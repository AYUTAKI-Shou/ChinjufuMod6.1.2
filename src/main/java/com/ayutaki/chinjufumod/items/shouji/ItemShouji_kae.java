package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_kaede;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_kae extends ItemBaseShouji {

	public ItemShouji_kae() {
		super(Shouji_Blocks.SHOUJI_KAE);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Shouji_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_kaede.ID));
	}

}

