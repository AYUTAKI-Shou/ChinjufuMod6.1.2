package com.ayutaki.chinjufumod.blocks.cmblock;

import javax.annotation.Nullable;

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
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.common.ToolType;

public class AlumiBlock extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<AlumiType> TYPE = EnumProperty.create("type", AlumiType.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOTTOM = Block.box(0.5D, 0.0D, 0.5D, 15.5D, 8.0D, 15.5D);
	protected static final VoxelShape AABB_BOX = Block.box(0.5D, 0.0D, 0.5D, 15.5D, 16.0D, 15.5D);

	public AlumiBlock(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(TYPE, AlumiType.BOTTOM)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = context.getLevel().getBlockState(blockpos);

		if (blockstate.getBlock() == this) {
			/** Change to SlabType.DOUBLE. **/
			return blockstate.setValue(TYPE, AlumiType.DOUBLE).setValue(WATERLOGGED, Boolean.valueOf(false));
		}

		else {
			FluidState fluid = context.getLevel().getFluidState(blockpos);
			BlockState blockState2 = this.defaultBlockState().setValue(TYPE, AlumiType.BOTTOM).setValue(WATERLOGGED, Boolean.valueOf(Boolean.valueOf(fluid.getType() == Fluids.WATER)))
					.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
			Direction direction = context.getClickedFace();

			return direction != Direction.DOWN && (direction == Direction.UP || context.getClickLocation().y - (double)blockpos.getY() <= 0.5D) ? blockState2 : blockState2;
		}
	}

	/* DOUBLE への置き換え boolean t/f */
	@Override
	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		ItemStack itemstack = context.getItemInHand();
		AlumiType slabtype = state.getValue(TYPE);

		/** DOUBLE でない時 かつ これをアイテム(アイテムブロック)として使う時 **/
		if (slabtype != AlumiType.DOUBLE && itemstack.getItem() == this.asItem()) {

			if (context.replacingClickedOnBlock()) {
				boolean flag = context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5D;
				Direction direction = context.getClickedFace();

				if (slabtype == AlumiType.BOTTOM) {
					return direction == Direction.UP || flag && direction.getAxis().isHorizontal(); }
				
				else { return false; }
			}
			
			else { return true; }
		}

		/** それ以外 **/
		else { return false; }
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

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
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
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return state.getValue(TYPE) != AlumiType.DOUBLE;
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		AlumiType slabtype = state.getValue(TYPE);
		switch (slabtype) {
		case DOUBLE:
			return AABB_BOX;
		default:
			return AABB_BOTTOM;
		}
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

	public enum AlumiType implements IStringSerializable {
		BOTTOM("bottom"),
		DOUBLE("double");

		private final String name;

		private AlumiType(String name) { this.name = name; }

		public String toString() { return this.name; }

		public String getSerializedName() { return this.name; }
	}

}
