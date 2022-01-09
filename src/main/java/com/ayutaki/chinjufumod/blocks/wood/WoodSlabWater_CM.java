package com.ayutaki.chinjufumod.blocks.wood;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class WoodSlabWater_CM extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<SlabType> TYPE = EnumProperty.create("type", SlabType.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOTTOM = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_TOP = Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public WoodSlabWater_CM(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = context.getLevel().getBlockState(blockpos);
		FluidState fluid = context.getLevel().getFluidState(blockpos);
		if (blockstate.getBlock() == this) {
			/** Change to SlabType.DOUBLE. **/
			return blockstate.setValue(TYPE, SlabType.DOUBLE);
		}

		else {
			BlockState blockState2 = this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)));
			Direction direction = context.getClickedFace();

			return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)blockpos.getY() <= 0.5D) ? blockState2 : blockState2.setValue(TYPE, SlabType.TOP);
		}
	}

	/* DOUBLE への置き換え boolean t/f */
	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		ItemStack itemstack = context.getItemInHand();
		SlabType slabtype = state.getValue(TYPE);

		/** DOUBLE でない時 かつ これをアイテム(アイテムブロック)として使う時 **/
		if (slabtype != SlabType.DOUBLE && itemstack.getItem() == this.asItem()) {

			if (context.replacingClickedOnBlock()) {
				boolean flag = context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5D;
				Direction direction = context.getClickedFace();

				if (slabtype == SlabType.BOTTOM) { return direction == Direction.UP || flag && direction.getAxis().isHorizontal(); }

				else { return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal(); }
			}
			else { return true; }
		}
		else { return false; }
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
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		return super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch (type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).is(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}

	/* Create Blockstate */
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(TYPE, WATERLOGGED);
	}

	public boolean useShapeForLightOcclusion(BlockState state) {
		return state.getValue(TYPE) != SlabType.DOUBLE;
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		SlabType slabtype = state.getValue(TYPE);
		switch (slabtype) {
		case DOUBLE:
			return VoxelShapes.block();
		case TOP:
			return AABB_TOP;
		default:
			return AABB_BOTTOM;
		}
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }

}
