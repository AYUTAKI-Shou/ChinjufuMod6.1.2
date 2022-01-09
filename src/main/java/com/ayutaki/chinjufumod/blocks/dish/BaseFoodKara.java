package com.ayutaki.chinjufumod.blocks.dish;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BaseFoodKara extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	public BaseFoodKara(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlabWater_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.getLiquidTicks().scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true; }
		
		else { return false; }
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		
		else { return Fluids.EMPTY; }
	}

	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, STAGE_1_4, WATERLOGGED);
	}

}
