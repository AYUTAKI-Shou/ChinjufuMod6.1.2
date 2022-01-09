package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class GrapeTop_C_kare extends BaseStage3_Face {

	/** 収穫1、枯れ2、3→Bの1 **/
	public static final String ID = "block_wood_grapetop_c";

	private static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);

	private static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);
	private static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.0, 0.8125, 0.5, 1.0);

	private static final AxisAlignedBB AABB_3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, 0.0, 0.625, 0.4375, 1.0);
	private static final AxisAlignedBB AABB_3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, 0.0, 0.625, 0.4375, 1.0);
	private static final AxisAlignedBB AABB_3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, 0.0, 0.625, 0.4375, 1.0);
	private static final AxisAlignedBB AABB_3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, 0.0, 0.625, 0.4375, 1.0);

	/*苗木*/
	public GrapeTop_C_kare() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		EnumFacing direction = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_1_SOUTH : ((i == 2)? AABB_2_SOUTH : AABB_3_SOUTH);

		case EAST:
			return (i == 1)? AABB_1_EAST : ((i == 2)? AABB_2_EAST : AABB_3_EAST);

		case WEST:
			return (i == 1)? AABB_1_WEST : ((i == 2)? AABB_2_WEST : AABB_3_WEST);

		case NORTH:
		default:
			return (i == 1)? AABB_1_NORTH : ((i == 2)? AABB_2_NORTH : AABB_3_NORTH);
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** Top側のドロップは空気ブロックにしてある為、Bot側のドロップを有効にする **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Crop_Blocks.BUDOUNOKI_C) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.down(), false); }
			worldIn.destroyBlock(pos.down(), true);
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		stack.add(new ItemStack(Items.AIR));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.BUDOUNOKI, 1, 0);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
