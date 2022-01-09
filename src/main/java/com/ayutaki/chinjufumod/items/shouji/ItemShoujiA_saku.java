package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_sakura;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_saku extends ItemBaseShouji {

	public ItemShoujiA_saku() {
		super(Shouji_Blocks.SHOUJIA_SAKU);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setUnlocalizedName(ShoujiB_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_sakura.ID));
	}

}
