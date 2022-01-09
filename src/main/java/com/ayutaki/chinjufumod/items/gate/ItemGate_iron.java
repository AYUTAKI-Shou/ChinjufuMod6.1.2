package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_iron;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGate_iron extends ItemBaseGate {

	public ItemGate_iron() {
		super(Gate_Blocks.GATE_IRON);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Gate_iron.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Gate_iron.ID));
	}

}
