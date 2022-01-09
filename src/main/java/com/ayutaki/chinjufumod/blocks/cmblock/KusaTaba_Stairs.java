package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class KusaTaba_Stairs extends BlockStairs {

	public KusaTaba_Stairs(String unlocalizedName, IBlockState state) {
		super(state);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));

		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);

		this.useNeighborBrightness = true;
	}

}
