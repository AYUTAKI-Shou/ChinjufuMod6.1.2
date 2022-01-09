package com.ayutaki.chinjufumod.blocks.chair;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Sofa_cyan extends BaseSofa {

	public static final String ID = "block_sofa_cyan";
	/* つなげたくないから旧式のまま */
	public static final PropertyEnum<Type> TYPE = PropertyEnum.create("type", Type.class);

	public Sofa_cyan() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		EnumFacing facing = (EnumFacing) state.getValue(H_FACING);
		IBlockState left_block = worldIn.getBlockState(pos.offset(facing.rotateYCCW()));
		IBlockState right_block = worldIn.getBlockState(pos.offset(facing.rotateY()));
		boolean left = left_block.getBlock() instanceof Sofa_cyan && left_block.getValue(H_FACING).equals(facing);
		boolean right = right_block.getBlock() instanceof Sofa_cyan && right_block.getValue(H_FACING).equals(facing);

		 if (right) {

			if (left) { return state.withProperty(TYPE, Type.BOTH); }

			else { return state.withProperty(TYPE, Type.RIGHT); } }

		else if (left) {

			if (right) { return state.withProperty(TYPE, Type.BOTH); }

			else { return state.withProperty(TYPE, Type.LEFT); } }
		 
		return state.withProperty(TYPE, Type.DEFAULT);
	}

}
