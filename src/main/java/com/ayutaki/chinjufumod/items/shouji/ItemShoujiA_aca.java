package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_acacia;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShoujiA_aca extends ItemBaseShouji {

	public ItemShoujiA_aca() {
		super(Shouji_Blocks.SHOUJIA_ACA);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(ShoujiB_acacia.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShoujiB_acacia.ID));
	}

}
