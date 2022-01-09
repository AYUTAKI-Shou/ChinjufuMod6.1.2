package com.ayutaki.chinjufumod.blocks.gate;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.properties.DoorHingeSide;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Gate_spruce extends BaseGate {

	/* Collision */
	protected static final VoxelShape CLOSEL_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSEL_WEST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);
	protected static final VoxelShape CLOSEL_NORTH = Block.box(-16.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSEL_EAST = Block.box(0.0D, 0.0D, -16.0D, 16.0D, 32.0D, 16.0D);

	protected static final VoxelShape OPENL_SOUTH = Block.box(15.9D, 0.0D, 4.0D, 32.0D, 32.0D, 32.0D);
	protected static final VoxelShape OPENL_WEST = Block.box(-16.0D, 0.0D, 15.9D, 12.0D, 32.0D, 32.0D);
	protected static final VoxelShape OPENL_NORTH = Block.box(-16.0D, 0.0D, -16.0D, 0.1D, 32.0D, 12.0D);
	protected static final VoxelShape OPENL_EAST = Block.box(4.0D, 0.0D, -16.0D, 32.0D, 32.0D, 0.1D);

	protected static final VoxelShape CLOSER_SOUTH = Block.box(-16.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_WEST = Block.box(0.0D, 0.0D, -16.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_NORTH = Block.box(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_EAST = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);

	protected static final VoxelShape OPENR_SOUTH = Block.box(-16.0D, 0.0D, 4.0D, 0.1D, 32.0D, 32.0D);
	protected static final VoxelShape OPENR_WEST = Block.box(-16.0D, 0.0D, -16.0D, 12.0D, 32.0D, 0.1D);
	protected static final VoxelShape OPENR_NORTH = Block.box(15.9D, 0.0D, -16.0D, 32.0D, 32.0D, 12.0D);
	protected static final VoxelShape OPENR_EAST = Block.box(4.0D, 0.0D, 15.9D, 32.0D, 32.0D, 32.0D);

	public Gate_spruce(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		boolean flagopen = !state.getValue(OPEN);
		boolean flagright = state.getValue(HINGE) == DoorHingeSide.RIGHT;

		switch (direction) {
		case NORTH:
		default:
			return flagopen? (flagright? CLOSER_NORTH : CLOSEL_NORTH) :(flagright? OPENR_NORTH : OPENL_NORTH);
		case SOUTH:
			return flagopen? (flagright? CLOSER_SOUTH : CLOSEL_SOUTH) : (flagright? OPENR_SOUTH : OPENL_SOUTH);
		case WEST:
			return flagopen? (flagright? CLOSER_WEST : CLOSEL_WEST) :(flagright? OPENR_WEST : OPENL_WEST);
		case EAST:
			return flagopen? (flagright? CLOSER_EAST : CLOSEL_EAST) :(flagright? OPENR_EAST : OPENL_EAST);
		}
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		return ActionResultType.FAIL;
	}

	public void setOpen(BlockState state, World worldIn, BlockPos pos, boolean open) {
		BlockState blockstate = worldIn.getBlockState(pos);
		if (blockstate.getBlock() == this && blockstate.getValue(OPEN) != open) {
			worldIn.setBlock(pos, blockstate.setValue(OPEN, Boolean.valueOf(open)), 10);
			this.moveSound(worldIn, pos, open);
		}
	}

	/* Get POWER. */
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.hasNeighborSignal(pos) || worldIn.hasNeighborSignal(pos.relative(state.getValue(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));

		if (block != this && flag != state.getValue(POWERED)) {
			if (flag != state.getValue(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlock(pos, state.setValue(POWERED, Boolean.valueOf(flag)).setValue(OPEN, Boolean.valueOf(flag)), 2);
		}
	}

	/* Play Sound */
	private void moveSound(World worldIn, BlockPos pos, boolean isOpening) {
		if (isOpening == true) {
			worldIn.playSound(null, pos, SoundEvents_CM.GATE_WOOD, SoundCategory.BLOCKS, 1.0F, 1.0F); }

		if (isOpening != true) {
			worldIn.playSound(null, pos, SoundEvents_CM.GATE_WOOD, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	}

}
