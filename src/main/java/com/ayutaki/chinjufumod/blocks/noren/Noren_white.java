package com.ayutaki.chinjufumod.blocks.noren;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Noren_white extends BaseNoren {

	public static final PropertyEnum<Type> TYPE = PropertyEnum.create("type", Type.class);

	public Noren_white(Material material, String unlocalizedName) {
		super(material, unlocalizedName);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = left_block.getBlock() instanceof Noren_white && left_block.getValue(H_FACING).equals(facing);
		boolean right = right_block.getBlock() instanceof Noren_white && right_block.getValue(H_FACING).equals(facing);

		 if (right) {

			if (left) { return state.withProperty(TYPE, Type.BOTH); }

			else { return state.withProperty(TYPE, Type.RIGHT); } }

		else if (left) {

			if (right) { return state.withProperty(TYPE, Type.BOTH); }

			else { return state.withProperty(TYPE, Type.LEFT); } }
		 
		return state.withProperty(TYPE, Type.DEFAULT);
	}

}
