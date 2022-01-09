package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;

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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseWindow extends Block {

	/* Property */
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.453125, 0.0, 0.0, 0.546875, 1.0, 1.0);

	protected static final AxisAlignedBB AABB_OL_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -0.453125, 0.0, 0.89375, 0.546875, 1.0, 0.9875);
	protected static final AxisAlignedBB AABB_OL_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -0.453125, 0.0, 0.89375, 0.546875, 1.0, 0.9875);
	protected static final AxisAlignedBB AABB_OL_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -0.453125, 0.0, 0.89375, 0.546875, 1.0, 0.9875);
	protected static final AxisAlignedBB AABB_OL_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -0.453125, 0.0, 0.89375, 0.546875, 1.0, 0.9875);

	protected static final AxisAlignedBB AABB_OR_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -0.453125, 0.0, 0.0125, 0.546875, 1.0, 0.10625);
	protected static final AxisAlignedBB AABB_OR_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -0.453125, 0.0, 0.0125, 0.546875, 1.0, 0.10625);
	protected static final AxisAlignedBB AABB_OR_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -0.453125, 0.0, 0.0125, 0.546875, 1.0, 0.10625);
	protected static final AxisAlignedBB AABB_OR_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -0.453125, 0.0, 0.0125, 0.546875, 1.0, 0.10625);

	protected BaseWindow(Material material) {
		super(material);

		setHardness(1.0F);
		setResistance(1.0F);
		setSoundType(SoundType.WOOD);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_4, Integer.valueOf(1)));

		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=Close Left、2=Open Left、3=Close Right、4=Open Right **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			CMEvents.soundWin_Open(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);
		}

		if (i == 2) {
			CMEvents.soundWin_Close(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3);
		}

		if (i == 3) {
			CMEvents.soundWin_Open(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);
		}

		if (i == 4) {
			CMEvents.soundWin_Close(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3);
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
		i = i | ((Integer)state.getValue(STAGE_1_4)).intValue() - 1 << 2;
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
				.withProperty(STAGE_1_4, Integer.valueOf(1 + (meta >> 2)));
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (4 - ((Integer)blockState.getValue(STAGE_1_4)).intValue()) * 2;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_SOUTH : ((i ==2)? AABB_OL_SOUTH : ((i ==3)? AABB_SOUTH : AABB_OR_SOUTH));

		case EAST:
			return (i == 1)? AABB_EAST : ((i ==2)? AABB_OL_EAST : ((i ==3)? AABB_EAST : AABB_OR_EAST));

		case WEST:
			return (i == 1)? AABB_WEST : ((i ==2)? AABB_OL_WEST : ((i ==3)? AABB_WEST : AABB_OR_WEST));

		case NORTH:
		default:
			return (i == 1)? AABB_NORTH : ((i ==2)? AABB_OL_NORTH : ((i ==3)? AABB_NORTH : AABB_OR_NORTH));
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_SOUTH : ((i ==2)? AABB_OL_SOUTH : ((i ==3)? AABB_SOUTH : AABB_OR_SOUTH)));
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_EAST : ((i ==2)? AABB_OL_EAST : ((i ==3)? AABB_EAST : AABB_OR_EAST)));
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_WEST : ((i ==2)? AABB_OL_WEST : ((i ==3)? AABB_WEST : AABB_OR_WEST)));
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_NORTH : ((i ==2)? AABB_OL_NORTH : ((i ==3)? AABB_NORTH : AABB_OR_NORTH)));
			break;
		}
	}

	/*初期BlockStateContainerの生成 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, STAGE_1_4 });
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

}
