package com.ayutaki.chinjufumod.blocks.wood;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

public class Stairs_SeasonalPlank extends BlockStairs {

	public Stairs_SeasonalPlank(String unlocalizedName, IBlockState state) {
		super(state);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);

		this.useNeighborBrightness = true;
	}

}
