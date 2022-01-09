package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DressingTable_Top extends BaseStage3_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.0, 0.0625, 0.125, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.0, 0.0625, 0.125, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.0, 0.0625, 0.125, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.0, 0.0625, 0.125, 1.0, 0.9375);

	/*1-1=オーク,2=マツ,3=シラカバ, 2-1=ジャングル,2=アカシア,3=Dオーク, 3-1=サクラ,2=カエデ,3=イチョウ */
	public DressingTable_Top() {
		super(Material.WOOD);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return AABB_SOUTH;

		case EAST:
			return AABB_EAST;

		case WEST:
			return AABB_WEST;

		case NORTH:
		default:
			return AABB_NORTH;
		}
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

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_s ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_b ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_j ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_a ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_d ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_saku ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_kae ||
			worldIn.getBlockState(pos.down()).getBlock() == Furniture_Blocks.DRESSINGTABLE_ich) {

			worldIn.destroyBlock(pos.down(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (this == Furniture_Blocks.DRESSINGTABLE_TOP1) {
			if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE, 1, 0)); }
			if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_s, 1, 0)); }
			if (i == 3) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_b, 1, 0)); }
		}

		if (this == Furniture_Blocks.DRESSINGTABLE_TOP2) {
			if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_j, 1, 0)); }
			if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_a, 1, 0)); }
			if (i == 3) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_d, 1, 0)); }
		}

		if (this == Furniture_Blocks.DRESSINGTABLE_TOP3) {
			if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_saku, 1, 0)); }
			if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_kae, 1, 0)); }
			if (i == 3) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_ich, 1, 0)); }
		}
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		if (this == Furniture_Blocks.DRESSINGTABLE_TOP1) {
			if (i == 2) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_s, 1, 0); }
			if (i == 3) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_b, 1, 0); }
		}

		if (this == Furniture_Blocks.DRESSINGTABLE_TOP2) {
			if (i == 1) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_j, 1, 0); }
			if (i == 2) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_a, 1, 0); }
			if (i == 3) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_d, 1, 0); }
		}

		if (this == Furniture_Blocks.DRESSINGTABLE_TOP3) {
			if (i == 1) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_saku, 1, 0); }
			if (i == 2) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_kae, 1, 0); }
			if (i == 3) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_ich, 1, 0); }
		}
		return new ItemStack(Items_Chinjufu.DRESSINGTABLE, 1, 0);
	}

}
