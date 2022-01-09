package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Koushi_B extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty UP = BooleanProperty.create("up");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final IntegerProperty VER = IntegerProperty.create("ver", 1, 2);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_WEST = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_EAST = Block.box(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape S2_EAST = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Koushi_B(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(UP, Boolean.valueOf(false))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(VER, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		
		if (itemstack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(VER), 3);
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}

		return ActionResultType.PASS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		IBlockReader worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();

		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(UP, this.canConnectTo(worldIn, pos, Direction.UP))
				.setValue(DOWN, this.canConnectTo(worldIn, pos, Direction.DOWN));
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

	/* Connect the blocks. */
	protected boolean canConnectTo(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockState state = worldIn.getBlockState(pos.relative(face));
		return state.getBlock() == this;
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
			return true;
		}
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
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		boolean up = canConnectTo(worldIn, pos, Direction.UP);
		boolean down = canConnectTo(worldIn, pos, Direction.DOWN);
		return stateIn.setValue(UP, up).setValue(DOWN, down);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, VER, UP, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(VER);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : S2_NORTH;
		case SOUTH:
			return (i == 1)? S1_SOUTH : S2_SOUTH;
		case WEST:
			return (i == 1)? S1_WEST : S2_WEST;
		case EAST:
			return (i == 1)? S1_EAST : S2_EAST;
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.wp_stage2")).withStyle(TextFormatting.GRAY));
	}

}
