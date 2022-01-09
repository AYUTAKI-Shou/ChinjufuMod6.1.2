package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.furnace.Lit_Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_aida;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_on;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk_sub;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBeseNabe extends Block {

	/* Property */
	public static final PropertyInteger STAGE_1_4 = PropertyInteger.create("stage", 1, 4);
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool DOWN2 = PropertyBool.create("down2");

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);

	protected static final AxisAlignedBB AABB_DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	protected static final AxisAlignedBB AABB_DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	protected static final AxisAlignedBB AABB_DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	protected static final AxisAlignedBB AABB_DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);

	protected static final AxisAlignedBB AABB_DOWN2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	protected static final AxisAlignedBB AABB_DOWN2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	protected static final AxisAlignedBB AABB_DOWN2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	protected static final AxisAlignedBB AABB_DOWN2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);

	protected BlockBeseNabe(Material materialIn) {
		super(materialIn);

		/*鍋・皿*/
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_4, Integer.valueOf(1))
				.withProperty(DOWN, Boolean.valueOf(false))
				.withProperty(DOWN2, Boolean.valueOf(false)));
	}

	/*湯気のエフェクト*/
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;

		if (this !=Dish_Blocks.NABEGOHAN) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
				.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
				.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
				.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B || worldIn
				.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_IRORI) {

				for (int la = 0; la < 1; ++la) {
					double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
					double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d3 = 0.12D;
					double d4 = 0.17D;
					par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0 - d4 + 0.25, d1 + d3 -0.5, d2, 0.0D, 0.0D, 0.0D);
				}
			}

			/** 効果音 **/
			if (rand.nextDouble() < 0.1D) {

				if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_IRORI) {

				worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.5F, 0.7F, false);
				}
			}
		}

		if (this ==Dish_Blocks.NABEGOHAN) { }
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_4)).intValue() - 1 << 2;
		return i;
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
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		boolean flag2= !((Boolean)state.getValue(DOWN2)).booleanValue();

		switch (direction) {

		case SOUTH:
			return flag ? (flag2? AABB_SOUTH : AABB_DOWN2_SOUTH) : AABB_DOWN_SOUTH;

		case EAST:
			return flag ? (flag2? AABB_EAST : AABB_DOWN2_EAST) : AABB_DOWN_EAST;

		case WEST:
			return flag ? (flag2? AABB_WEST : AABB_DOWN2_WEST) : AABB_DOWN_WEST;

		case NORTH:
		default:
			/** !down= true : false **/
			return flag ? (flag2? AABB_NORTH : AABB_DOWN2_NORTH) : AABB_DOWN_NORTH;
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() instanceof Kitchen_Oven || worldIn
				.getBlockState(pos).getBlock() instanceof Kitchen_Oven_B || worldIn
				.getBlockState(pos).getBlock() instanceof Irori || worldIn
				.getBlockState(pos).getBlock() instanceof Lit_Irori || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_on || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_off || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_aida || worldIn
				.getBlockState(pos).getBlock() instanceof BlockFurnace;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo2(IBlockAccess worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		return block instanceof Chabudai || block instanceof LowDesk || block instanceof Kotatsu ||
					block instanceof Chabudai_sub || block instanceof LowDesk_sub || block instanceof Kotatsu_sub ||
					(block instanceof BaseFacingSlabW && state.getValue(BaseFacingSlabW.HALF) == BaseFacingSlabW.SlabHalf.BOTTOM && state.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabW && state.getValue(BaseSlabW.HALF) == BaseSlabW.SlabHalf.BOTTOM && state.getValue(BaseSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabWType2 && state.getValue(BaseSlabWType2.HALF) == BaseSlabWType2.SlabHalf.BOTTOM && state.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(block instanceof BlockHalfWoodSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlabNew && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()))
				.withProperty(DOWN2, this.canConnectTo2(worldIn, pos.down()));
	}

	/*初期BlockStateContainerの生成 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, DOWN2, H_FACING, STAGE_1_4 });
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

}
