package com.ayutaki.chinjufumod.blocks.furniture;

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

public class HangLamp extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty FACING = DirectionProperty
			.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP, Direction.DOWN);
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_UP = Block.box(5.0D, 0.0D, 7.0D, 11.0D, 12.0D, 9.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(2.0D, 8.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	protected static final VoxelShape AABB_SOUTH = Block.box(5.0D, 4.0D, 0.0D, 11.0D, 12.0D, 3.5D);
	protected static final VoxelShape AABB_WEST = Block.box(12.5D, 4.0D, 5.0D, 16.0D, 12.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(5.0D, 4.0D, 12.5D, 11.0D, 12.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 4.0D, 5.0D, 3.5D, 12.0D, 11.0D);

	public HangLamp(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.UP)
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		boolean lit = state.getValue(LIT);

		if (lit == false) {
			CMEvents.soundStoneButton_On(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }

		if (lit == true) {
			CMEvents.soundStoneButton_Off(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)).setValue(FACING, context.getClickedFace());
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
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
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(FACING);

		switch (direction) {
		default:
		case UP:
			return AABB_UP;
		case DOWN:
			return AABB_DOWN;
		case NORTH:
			return AABB_NORTH;
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case EAST:
			return AABB_EAST;
		}
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, LIT, WATERLOGGED);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_lamp")).withStyle(TextFormatting.GRAY));
	}

}
