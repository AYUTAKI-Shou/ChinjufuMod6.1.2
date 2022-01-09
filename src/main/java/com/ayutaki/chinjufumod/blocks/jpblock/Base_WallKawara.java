package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma;
import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma_B;
import com.ayutaki.chinjufumod.blocks.glassdoor.Base_GlassDoor;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorHalf;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorHalf_seasonal;
import com.ayutaki.chinjufumod.blocks.shouji.BaseShouji;
import com.ayutaki.chinjufumod.blocks.shoujih.BaseShouji_Win;
import com.ayutaki.chinjufumod.blocks.shoujih.ShoujiHalf;
import com.ayutaki.chinjufumod.blocks.shoujih.ShoujiHalf_seasonal;
import com.ayutaki.chinjufumod.blocks.window.BaseWindow;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowB;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Bottom;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Top;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Base_WallKawara extends Block {

	/* Property */
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	/* Collision ...Based on the value of WallBlock.*/
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
			new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D),
			new AxisAlignedBB(0.125D, 0.0D, 0.25D, 0.875D, 0.5D, 1.0D), //SOUTH
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 0.75D, 0.5D, 0.875D), //WEST
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 0.5D, 0.75D), //NORTH
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.875D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.875D, 0.5D, 1.0D),
			new AxisAlignedBB(0.25D, 0.0D, 0.125D, 1.0D, 0.5D, 0.875D), //EAST
			new AxisAlignedBB(0.125D, 0.0D, 0.125D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.125D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 0.875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D) };
	
	public Base_WallKawara(Material material) {
		super(material);

		setHardness(2.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(NORTH, false)
				.withProperty(EAST, false)
				.withProperty(SOUTH, false)
				.withProperty(WEST, false)
				.withProperty(STAGE_0_15, Integer.valueOf(0)));
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return BOUNDING_BOXES[getBoundingBoxIdx(state)];
	}

	private static int getBoundingBoxIdx(IBlockState state) {
		int i = 0;
		if (((Boolean)state.getValue(NORTH)).booleanValue()) { i |= 1 << EnumFacing.NORTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(EAST)).booleanValue()) { i |= 1 << EnumFacing.EAST.getHorizontalIndex(); }
		if (((Boolean)state.getValue(SOUTH)).booleanValue()) { i |= 1 << EnumFacing.SOUTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(WEST)).booleanValue()) { i |= 1 << EnumFacing.WEST.getHorizontalIndex(); }
		return i;
	}
	
	/* Connect the blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, facing);
		Block block = iblockstate.getBlock();
		boolean flag = (block instanceof Base_Wall || block instanceof Wall_DirtWall || block instanceof Base_WallKawara || block instanceof Wall_Sama ||
				block instanceof Base_GlassDoor || block instanceof GlassDoorHalf || block instanceof GlassDoorHalf_seasonal || block instanceof BlockWall ||
				block instanceof BaseShouji || block instanceof BaseShouji_Win || block instanceof ShoujiHalf || block instanceof ShoujiHalf_seasonal ||
				block instanceof BaseFusuma || block instanceof BaseFusuma_B || block instanceof BaseWindow || block instanceof BaseWindowB ||
				block instanceof BaseWindowTall_Bottom || block instanceof BaseWindowTall_Top ||block instanceof BaseWindowTall ||
				block instanceof BlockFenceGate || block instanceof BlockWall || block instanceof BlockPane);
		return !isExcepBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID || flag;
	}
	
	protected static boolean isExcepBlockForAttachWithPiston(Block blockIn) {
		return Block.isExceptBlockForAttachWithPiston(blockIn) || blockIn == Blocks.BARRIER || 
				blockIn == Blocks.MELON_BLOCK || blockIn == Blocks.PUMPKIN || blockIn == Blocks.LIT_PUMPKIN;
	}
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return canConnectTo(world, pos.offset(facing), facing.getOpposite());
	}

	private boolean canWallConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		BlockPos other = pos.offset(facing);
		Block block = world.getBlockState(other).getBlock();
		return block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());
	}
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		BlockPos downpos = pos.down();
		IBlockState downstate = worldIn.getBlockState(downpos);
		Block downblock = downstate.getBlock();
		
		boolean north = ((downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.EAST || 
				downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.WEST)) || canWallConnectTo(worldIn, pos, EnumFacing.NORTH));
		
		boolean east = ((downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.NORTH || 
				downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.SOUTH)) || canWallConnectTo(worldIn, pos, EnumFacing.EAST));
		
		boolean south = ((downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.EAST || 
				downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.WEST)) || canWallConnectTo(worldIn, pos, EnumFacing.SOUTH));
		
		boolean west = ((downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.NORTH || 
				downstate.getValue(Wall_Sama.H_FACING) == EnumFacing.SOUTH)) || canWallConnectTo(worldIn, pos, EnumFacing.WEST));
		
		return state.withProperty(NORTH, north).withProperty(EAST, east).withProperty(SOUTH, south).withProperty(WEST, west);
	}
	
	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, SOUTH, WEST, STAGE_0_15 });
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

}
