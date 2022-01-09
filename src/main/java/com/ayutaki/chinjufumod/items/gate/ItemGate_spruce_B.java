package com.ayutaki.chinjufumod.items.gate;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce_B;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemGate_spruce_B extends ItemBaseGate {

	public ItemGate_spruce_B() {
		super(Gate_Blocks.GATE_SPRUCE_B);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setUnlocalizedName(Gate_spruce_B.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Gate_spruce_B.ID));
	}

}
