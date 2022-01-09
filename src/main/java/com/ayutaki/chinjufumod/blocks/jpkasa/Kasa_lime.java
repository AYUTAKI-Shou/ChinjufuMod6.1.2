package com.ayutaki.chinjufumod.blocks.jpkasa;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Kasa_lime extends BaseMKasa {

	public static final String ID = "block_mkasa_lime";

	public Kasa_lime() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		boolean back = worldIn.getBlockState(pos.south()).getBlock() == this;
		boolean forward = worldIn.getBlockState(pos.north()).getBlock() == this;
		boolean left = worldIn.getBlockState(pos.west()).getBlock() == this;
		boolean right = worldIn.getBlockState(pos.east()).getBlock() == this;
		return state.withProperty(BACK, back).withProperty(FORWARD, forward).withProperty(LEFT, left).withProperty(RIGHT, right);
	}

}
