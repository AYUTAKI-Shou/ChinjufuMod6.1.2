package com.ayutaki.chinjufumod.blocks.garden;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class IronFence extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape BOT_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_WEST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 16.0D, 8.5D);
	protected static final VoxelShape BOT_EAST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 16.0D, 16.0D);

	protected static final VoxelShape TOP_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 16.0D, 27.0D, 8.5D);
	protected static final VoxelShape TOP_WEST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);
	protected static final VoxelShape TOP_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.5D, 27.0D, 16.0D, 8.5D);
	protected static final VoxelShape TOP_EAST = Block.makeCuboidShape(7.5D, 0.0D, 0.0D, 8.5D, 27.0D, 16.0D);

	public IronFence(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(TYPE, Type.DEFAULT)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* 設置制限 isSolidSide → true */
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (state.get(HALF) == DoubleBlockHalf.LOWER) {
			return true;
		}
		else {
			return blockstate.getBlock() == this;
		}
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3);
	}

	/* 同時破壊とドロップの指定 1.16.5に合わせる */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, blockpos, Block.getStateId(blockstate));

			ItemStack itemstack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(blockstate)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, itemstack);
				Block.spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, playerIn, itemstack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
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
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : this.getConnectState(state, worldIn, pos, state.get(H_FACING));
		}
		else {
			return Blocks.AIR.getDefaultState();
		}
	}

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, Direction targetDirection) {
		BlockState state = worldIn.getBlockState(source.offset(direction));

		if(state.getBlock() == this) {
			Direction fenceDirection = state.get(H_FACING);
			return fenceDirection.equals(targetDirection);
		}
		return false;
	}

	private BlockState getConnectState(BlockState state, IWorld worldIn, BlockPos pos, Direction dir) {
		boolean left = canConnectTo(worldIn, pos, dir.rotateY(), dir) || canConnectTo(worldIn, pos, dir.rotateY(), dir.rotateY());
		boolean right = canConnectTo(worldIn, pos, dir.rotateYCCW(), dir) || canConnectTo(worldIn, pos, dir.rotateYCCW(), dir.rotateYCCW());

		if(left && right) {
			return state.with(TYPE, Type.BOTH);
		}

		else if(left) {
			return state.with(TYPE, Type.RIGHT);
		}

		else if(right) {
			return state.with(TYPE, Type.LEFT);
		}
		return state.with(TYPE, Type.DEFAULT);
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, TYPE, WATERLOGGED);
	}

	/* 窒息 */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* 立方体 */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
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

	public enum Type implements IStringSerializable {
		DEFAULT("default"),
		LEFT("left"),
		RIGHT("right"),
		BOTH("both");

		private final String id;

		Type(String id) { this.id = id; }

		@Override
		public String getName() { return id; }

		@Override
		public String toString() { return id; }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);

		switch(direction) {
		case SOUTH:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_SOUTH : TOP_SOUTH;
		case WEST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_WEST : TOP_WEST;
		case NORTH:
		default:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_NORTH : TOP_NORTH;
		case EAST:
			return (state.get(HALF) == DoubleBlockHalf.LOWER)? BOT_EAST : TOP_EAST;
		}
	}

}
