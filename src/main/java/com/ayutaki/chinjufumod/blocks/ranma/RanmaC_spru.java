package com.ayutaki.chinjufumod.blocks.ranma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class RanmaC_spru extends BaseRanma {

	public static final PropertyEnum<Type> TYPE = PropertyEnum.create("type", Type.class);
	public static final PropertyInteger VER = PropertyInteger.create("ver", 1, 2);

	public RanmaC_spru(Material material, String unlocalizedName) {
		super(material, unlocalizedName);
		setCreativeTab(ChinjufuModTabs.WADECO);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		Integer integer = (Integer)state.getValue(VER);
		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = left_block.getBlock() instanceof RanmaC_spru && left_block.getValue(H_FACING).equals(facing);
		boolean right = right_block.getBlock() instanceof RanmaC_spru && right_block.getValue(H_FACING).equals(facing);

		if (right) {

			if (left) { return state.withProperty(TYPE, Type.BOTH).withProperty(VER, integer); }

			else { return state.withProperty(TYPE, Type.RIGHT).withProperty(VER, integer); } }

		else if (left) {

			if (right) { return state.withProperty(TYPE, Type.BOTH).withProperty(VER, integer); }

			else { return state.withProperty(TYPE, Type.LEFT).withProperty(VER, integer); } }
		 
		return state.withProperty(TYPE, Type.DEFAULT).withProperty(VER, integer);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

}
