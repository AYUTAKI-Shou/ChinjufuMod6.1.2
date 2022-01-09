package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.EntitySittableBlock;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DressingTable extends BaseFacingSapo {

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);

	private static final AxisAlignedBB AABB_BASE = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.75, 0.125, 0.1875, 1.0, 0.875);

	public DressingTable() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		if (!(entityIn instanceof EntitySittableBlock)) {

			EnumFacing facing = state.getValue(H_FACING);
			switch(facing) {
			case SOUTH:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SOUTH);
				break;
				
			case EAST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_EAST);
				break;
				
			case WEST:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WEST);
				break;
				
			case NORTH:
			default:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NORTH);
				break;
			}
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_BASE);
		}
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
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

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.up()).getBlock() == Furniture_Blocks.DRESSINGTABLE_TOP1 ||
				worldIn.getBlockState(pos.up()).getBlock() == Furniture_Blocks.DRESSINGTABLE_TOP2 ||
						worldIn.getBlockState(pos.up()).getBlock() == Furniture_Blocks.DRESSINGTABLE_TOP3) {
				worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == Furniture_Blocks.DRESSINGTABLE) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_s) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_s, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_b) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_b, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_j) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_j, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_a) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_a, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_d) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_d, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_saku) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_saku, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_kae) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_kae, 1, 0)); }
		if (this == Furniture_Blocks.DRESSINGTABLE_ich) { stack.add(new ItemStack(Items_Chinjufu.DRESSINGTABLE_ich, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == Furniture_Blocks.DRESSINGTABLE_s) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_s, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_b) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_b, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_j) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_j, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_a) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_a, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_d) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_d, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_saku) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_saku, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_kae) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_kae, 1, 0); }
		if (this == Furniture_Blocks.DRESSINGTABLE_ich) { return new ItemStack(Items_Chinjufu.DRESSINGTABLE_ich, 1, 0); }
		return new ItemStack(Items_Chinjufu.DRESSINGTABLE, 1, 0);
	}

}
