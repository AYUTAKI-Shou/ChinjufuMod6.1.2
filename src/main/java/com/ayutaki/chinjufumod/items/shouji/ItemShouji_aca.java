package com.ayutaki.chinjufumod.items.shouji;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_acacia;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemShouji_aca extends ItemBaseShouji {

	public ItemShouji_aca() {
		super(Shouji_Blocks.SHOUJI_ACA);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Shouji_acacia.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Shouji_acacia.ID));
	}

}
