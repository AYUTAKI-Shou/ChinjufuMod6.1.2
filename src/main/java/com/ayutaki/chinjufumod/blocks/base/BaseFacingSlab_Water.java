package com.ayutaki.chinjufumod.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class BaseFacingSlab_Water extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<SlabType> TYPE = EnumProperty.create("type", SlabType.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOTTOM = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
	protected static final VoxelShape AABB_TOP = Block.makeCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public BaseFacingSlab_Water(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(TYPE, SlabType.BOTTOM)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		BlockState blockstate = context.getWorld().getBlockState(blockpos);
		IFluidState ifluidstate = context.getWorld().getFluidState(blockpos);
		if (blockstate.getBlock() == this) {
			/** それの blockstate を拾った上で DOUBLE にする **/
			return blockstate.with(TYPE, SlabType.DOUBLE);
		}

		else {
			BlockState blockState2 = this.getDefaultState().with(TYPE, SlabType.BOTTOM).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER))
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
			Direction direction = context.getFace();

			return direction != Direction.DOWN && (direction == Direction.UP || context.getHitVec().y - (double)blockpos.getY() <= 0.5D) ? blockState2 : blockState2.with(TYPE, SlabType.TOP);
		}
	}

	/* DOUBLE への置き換え boolean t/f */
	@Override
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		ItemStack itemstack = useContext.getItem();
		SlabType slabtype = state.get(TYPE);

		/** DOUBLE でない時 かつ これをアイテム(アイテムブロック)として使う時 **/
		if (slabtype != SlabType.DOUBLE && itemstack.getItem() == this.asItem()) {

			if (useContext.replacingClickedOnBlock()) {
				boolean flag = useContext.getHitVec().y - (double)useContext.getPos().getY() > 0.5D;
				Direction direction = useContext.getFace();

				if (slabtype == SlabType.BOTTOM) {
					return direction == Direction.UP || flag && direction.getAxis().isHorizontal();
				}
				else {
					return direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal();
				}
			}
			else {
				return true;
			}
		}

		/** それ以外 **/
		else {
			return false;
		}
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	public boolean isTransparent(BlockState state) {
		return state.get(TYPE) != SlabType.DOUBLE;
	}

	/* Collisions for each property. */
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		SlabType slabtype = state.get(TYPE);
		switch(slabtype) {
		case DOUBLE:
			return VoxelShapes.fullCube();
		case TOP:
			return AABB_TOP;
		default:
			return AABB_BOTTOM;
		}
	}

	/* 窒息 */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(TYPE) != SlabType.DOUBLE) { return false; }
		return true;
	}

	/* 立方体 */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(TYPE) != SlabType.DOUBLE) { return false; }
		return true;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		if (state.get(TYPE) != SlabType.BOTTOM) { return true; }
		return false;
	}

}
