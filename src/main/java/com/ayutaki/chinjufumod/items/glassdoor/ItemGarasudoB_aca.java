package com.ayutaki.chinjufumod.items.glassdoor;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_acacia;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGarasudoB_aca extends ItemBaseGarasudo {

	public ItemGarasudoB_aca() {
		super(Garasudo_Blocks.GARASUDOB_ACA);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(GlassDoorB_acacia.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, GlassDoorB_acacia.ID));
	}

}
