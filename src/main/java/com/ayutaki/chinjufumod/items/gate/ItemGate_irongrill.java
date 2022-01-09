package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGate_irongrill extends ItemBaseGate {

	public ItemGate_irongrill() {
		super(Gate_Blocks.GATE_IRONGRILL);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Gate_irongrill.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Gate_irongrill.ID));
	}

}
