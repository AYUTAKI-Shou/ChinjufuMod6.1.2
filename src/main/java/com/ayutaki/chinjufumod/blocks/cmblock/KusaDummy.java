package com.ayutaki.chinjufumod.blocks.cmblock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class KusaDummy extends Block {

	public KusaDummy() {
		super(Material.WOOD);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.PLANT);
	}

}
