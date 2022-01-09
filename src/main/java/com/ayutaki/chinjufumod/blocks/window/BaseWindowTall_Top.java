package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseWindowTall_Top extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger STAGE_1_3 = PropertyInteger.create("stage", 1, 3);

	/* Collisionの数値 */
	protected static final AxisAlignedBB SOUTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB EAST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB WEST_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_CLOSE = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.0625, 0.0, 0.5, 1.0, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB EAST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB WEST_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_2 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.5, 0.0, 0.5, 0.5625, 1.0);

	protected static final AxisAlignedBB SOUTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB EAST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB WEST_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);
	protected static final AxisAlignedBB NORTH_AABB_3 = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, -0.875, 0.0, 0.5, 0.1875, 1.0);

	protected BaseWindowTall_Top(Material materialIn) {
		super(materialIn);

		setHardness(1.0F);
		setResistance(1.0F);
		setSoundType(SoundType.WOOD);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_3, Integer.valueOf(1)));

		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/* Collision */
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return (i == 1)? SOUTH_AABB_CLOSE : ((i ==2)? SOUTH_AABB_2 : SOUTH_AABB_3);

		case EAST:
			return (i == 1)? EAST_AABB_CLOSE : ((i ==2)? EAST_AABB_2 : EAST_AABB_3);

		case WEST:
			return (i == 1)? WEST_AABB_CLOSE : ((i ==2)? WEST_AABB_2 : WEST_AABB_3);

		case NORTH:
		default:
			return (i == 1)? NORTH_AABB_CLOSE : ((i ==2)? NORTH_AABB_2 : NORTH_AABB_3);
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? SOUTH_AABB_CLOSE : ((i ==2)? SOUTH_AABB_2 : SOUTH_AABB_3));
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? EAST_AABB_CLOSE : ((i ==2)? EAST_AABB_2 : EAST_AABB_3));
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? WEST_AABB_CLOSE : ((i ==2)? WEST_AABB_2 : WEST_AABB_3));
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? NORTH_AABB_CLOSE : ((i ==2)? NORTH_AABB_2 : NORTH_AABB_3));
			break;
		}
	}

	/* RightClick Action */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (hitY > 0.03125) {
			worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_3), 2);
		}
		return true;
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_3)).intValue() - 1 << 2;
		return i;
	}


	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(STAGE_1_3, Integer.valueOf(1 + (meta >> 2)));
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (3 - ((Integer)blockState.getValue(STAGE_1_3)).intValue()) * 2;
	}

	/* 初期BlockStateContainerの生成 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, STAGE_1_3 });
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
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

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

}
