package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Base_HodaGi_Bot extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(5.0D, 0.0D, 4.0D, 11.0D, 12.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(1.0D, 0.0D, 5.0D, 12.0D, 12.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(5.0D, 0.0D, 1.0D, 11.0D, 12.0D, 12.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(4.0D, 0.0D, 5.0D, 15.0D, 12.0D, 11.0D);

	public Base_HodaGi_Bot(Block.Properties properties) {
		super(properties);
		
		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
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
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, STAGE_1_4, WATERLOGGED);
	}

	/* TickRandom */
	private boolean inShade(ServerWorld worldIn, BlockPos pos) {
		return ((worldIn.canSeeSky(pos) && !worldIn.isDaytime()) || (!worldIn.canSeeSky(pos) && worldIn.getLightSubtracted(pos, 0) <= 11));
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_4);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!state.get(WATERLOGGED)) {
			if (i != 4) {
				if (inShade(worldIn, pos) && rand.nextInt(8) == 0) {
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
			
			if (i == 4) { }
		}
		

		if (state.get(WATERLOGGED)) {
			if (i != 1) {
				if (rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(1)));
					this.dropRottenfood(worldIn, pos); } }
			
			if (i == 1) { }
		}
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		switch(direction) {
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case NORTH:
		default:
			return AABB_NORTH;
		case EAST:
			return AABB_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HODAGI);
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

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState blockstate = worldIn.getBlockState(pos.up());
		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (blockstate.getBlock() instanceof Base_HodaGi_Top) {
			worldIn.destroyBlock(pos.up(), false); }
		
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

}

