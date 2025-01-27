package com.ayutaki.chinjufumod.blocks.school;

import javax.annotation.Nullable;

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
import net.minecraftforge.common.ToolType;

public class StoveChimney_joint extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(5.9D, 9.9D, 0.0D, 10.1D, 14.1D, 10.1D),
			Block.box(5.9D, 14.0D, 5.9D, 10.1D, 16.0D, 10.1D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(5.9D, 9.9D, 5.9D, 16.0D, 14.1D, 10.1D),
			Block.box(5.9D, 14.0D, 5.9D, 10.1D, 16.0D, 10.1D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(5.9D, 9.9D, 5.9D, 10.1D, 14.1D, 16.0D),
			Block.box(5.9D, 14.0D, 5.9D, 10.1D, 16.0D, 10.1D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(0.0D, 9.9D, 5.9D, 10.1D, 14.1D, 10.1D),
			Block.box(5.9D, 14.0D, 5.9D, 10.1D, 16.0D, 10.1D));

	public StoveChimney_joint(AbstractBlock.Properties properties) {
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

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

}
