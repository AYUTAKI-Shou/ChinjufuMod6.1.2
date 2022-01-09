package com.ayutaki.chinjufumod.blocks.gate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

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
import net.minecraftforge.common.ToolType;

public class Gate_iron extends BaseGate {

	/* Collision */
	protected static final VoxelShape CLOSEL_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSEL_WEST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);
	protected static final VoxelShape CLOSEL_NORTH = Block.makeCuboidShape(-16.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSEL_EAST = Block.makeCuboidShape(0.0D, 0.0D, -16.0D, 16.0D, 32.0D, 16.0D);

	protected static final VoxelShape OPENL_SOUTH = Block.makeCuboidShape(15.9D, 0.0D, 4.0D, 32.0D, 32.0D, 32.0D);
	protected static final VoxelShape OPENL_WEST = Block.makeCuboidShape(-16.0D, 0.0D, 15.9D, 12.0D, 32.0D, 32.0D);
	protected static final VoxelShape OPENL_NORTH = Block.makeCuboidShape(-16.0D, 0.0D, -16.0D, 0.1D, 32.0D, 12.0D);
	protected static final VoxelShape OPENL_EAST = Block.makeCuboidShape(4.0D, 0.0D, -16.0D, 32.0D, 32.0D, 0.1D);

	protected static final VoxelShape CLOSER_SOUTH = Block.makeCuboidShape(-16.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_WEST = Block.makeCuboidShape(0.0D, 0.0D, -16.0D, 16.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 32.0D, 32.0D, 16.0D);
	protected static final VoxelShape CLOSER_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 32.0D);

	protected static final VoxelShape OPENR_SOUTH = Block.makeCuboidShape(-16.0D, 0.0D, 4.0D, 0.1D, 32.0D, 32.0D);
	protected static final VoxelShape OPENR_WEST = Block.makeCuboidShape(-16.0D, 0.0D, -16.0D, 12.0D, 32.0D, 0.1D);
	protected static final VoxelShape OPENR_NORTH = Block.makeCuboidShape(15.9D, 0.0D, -16.0D, 32.0D, 32.0D, 12.0D);
	protected static final VoxelShape OPENR_EAST = Block.makeCuboidShape(4.0D, 0.0D, 15.9D, 32.0D, 32.0D, 32.0D);

	public Gate_iron(Block.Properties properties) {
		super(properties);
	}

	/* 影対策 */
	public int getLightValue(BlockState state) {
		return (Config_CM.getInstance().antiShadow() == true)? 1 : 0;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		boolean flagopen = !state.get(OPEN);
		boolean flagright = state.get(HINGE) == DoorHingeSide.RIGHT;

		switch(direction) {
		case SOUTH:
			return flagopen? (flagright? CLOSER_SOUTH : CLOSEL_SOUTH) : (flagright? OPENR_SOUTH : OPENL_SOUTH);
		case WEST:
			return flagopen? (flagright? CLOSER_WEST : CLOSEL_WEST) :(flagright? OPENR_WEST : OPENL_WEST);
		case NORTH:
		default:
			return flagopen? (flagright? CLOSER_NORTH : CLOSEL_NORTH) :(flagright? OPENR_NORTH : OPENL_NORTH);
		case EAST:
			return flagopen? (flagright? CLOSER_EAST : CLOSEL_EAST) :(flagright? OPENR_EAST : OPENL_EAST);
		}
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		return ActionResultType.FAIL;
	}

	public void toggleDoor(BlockState state, World worldIn, BlockPos pos, boolean open) {
		BlockState blockstate = worldIn.getBlockState(pos);
		if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
			worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(open)), 10);
			this.moveSound(worldIn, pos, open);
		}
	}

	/* 隣接ブロックの変化 */
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));

		if (block != this && flag != state.get(POWERED)) {
			if (flag != state.get(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)), 2);
		}
	}

	/* Play Sound */
	private void moveSound(World worldIn, BlockPos pos, boolean isOpening) {
		if (isOpening == true) {
			worldIn.playSound(null, pos, SoundEvents_CM.GATE_IRON_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F); }

		if (isOpening == false) {
			worldIn.playSound(null, pos, SoundEvents_CM.GATE_IRON_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	}

	/* 採取適正ツール */
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
