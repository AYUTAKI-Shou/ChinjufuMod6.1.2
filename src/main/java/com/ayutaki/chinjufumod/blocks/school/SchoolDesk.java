package com.ayutaki.chinjufumod.blocks.school;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class SchoolDesk extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(-3.0D, 15.0D, 0.0D, 19.0D, 16.0D, 16.0D), 
			Block.box(-2.0D, 11.0D, 1.0D, 18.0D, 15.0D, 15.0D),
			Block.box(-2.0D, 3.0D, 1.0D, 18.0D, 5.0D, 2.0D),
			Block.box(-2.0D, 0.0D, 1.0D, 0.0D, 15.0D, 15.0D),
			Block.box(16.0D, 0.0D, 1.0D, 18.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(0.0D, 15.0D, -3.0D, 16.0D, 16.0D, 19.0D), 
			Block.box(1.0D, 11.0D, -2.0D, 15.0D, 15.0D, 18.0D),
			Block.box(14.0D, 3.0D, -2.0D, 15.0D, 5.0D, 18.0D),
			Block.box(1.0D, 0.0D, -2.0D, 15.0D, 15.0D, 0.0D),
			Block.box(1.0D, 0.0D, 16.0D, 15.0D, 15.0D, 18.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(-3.0D, 15.0D, 0.0D, 19.0D, 16.0D, 16.0D), 
			Block.box(-2.0D, 11.0D, 1.0D, 18.0D, 15.0D, 15.0D),
			Block.box(-2.0D, 3.0D, 14.0D, 18.0D, 5.0D, 15.0D),
			Block.box(-2.0D, 0.0D, 1.0D, 0.0D, 15.0D, 15.0D),
			Block.box(16.0D, 0.0D, 1.0D, 18.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(0.0D, 15.0D, -3.0D, 16.0D, 16.0D, 19.0D), 
			Block.box(1.0D, 11.0D, -2.0D, 15.0D, 15.0D, 18.0D),
			Block.box(1.0D, 3.0D, -2.0D, 2.0D, 5.0D, 18.0D),
			Block.box(1.0D, 0.0D, -2.0D, 15.0D, 15.0D, 0.0D),
			Block.box(1.0D, 0.0D, 16.0D, 15.0D, 15.0D, 18.0D));

	public SchoolDesk(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH :
		default : return AABB_NORTH;
		case SOUTH : return AABB_SOUTH;
		case EAST : return AABB_EAST;
		case WEST : return AABB_WEST;
		} // switch
	}

}
