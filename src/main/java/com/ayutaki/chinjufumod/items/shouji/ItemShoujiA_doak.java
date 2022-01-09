package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_darkoak;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_doak extends ItemBaseShouji {

	public ItemShoujiA_doak() {
		super(Shouji_Blocks.SHOUJIA_DOAK);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(ShoujiB_darkoak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_darkoak.ID));
	}

}
