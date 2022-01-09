package com.ayutaki.chinjufumod.blocks.wallpane;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPlank_Pillar extends BlockRotatedPillar {

	public BlockPlank_Pillar() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WALLPANEL);

		setHardness(2.0F);
		setResistance(5.0F);

		setSoundType(SoundType.WOOD);
	}

}
