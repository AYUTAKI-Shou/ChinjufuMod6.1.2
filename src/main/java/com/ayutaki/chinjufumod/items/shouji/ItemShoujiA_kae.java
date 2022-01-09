package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_kaede;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_kae extends ItemBaseShouji {

	public ItemShoujiA_kae() {
		super(Shouji_Blocks.SHOUJIA_KAE);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(ShoujiB_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_kaede.ID));
	}

}
