package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_acacia;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudo_aca extends ItemBaseGarasudo {

	public ItemGarasudo_aca() {
		super(Garasudo_Blocks.GARASUDO_ACA);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoor_acacia.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoor_acacia.ID));
	}

}
