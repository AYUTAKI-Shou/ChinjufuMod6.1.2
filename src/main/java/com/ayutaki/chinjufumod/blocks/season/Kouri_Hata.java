package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Kouri_Hata extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 16.0D, 1.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(15.0D, 0.0D, 2.0D, 16.0D, 16.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(2.0D, 0.0D, 15.0D, 14.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 1.0D, 16.0D, 14.0D);

	public Kouri_Hata(Block.Properties properties) {
		super(properties);
	}

	/* 窒息 */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* 立方体 */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);

		switch(direction) {
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case NORTH:
		default:
			return AABB_NORTH;
		case EAST:
			return AABB_EAST;
		}
	}

}
