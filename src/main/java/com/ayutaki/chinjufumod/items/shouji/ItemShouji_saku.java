package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_sakura;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_saku extends ItemBaseShouji {

	public ItemShouji_saku() {
		super(Shouji_Blocks.SHOUJI_SAKU);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(Shouji_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_sakura.ID));
	}

}

