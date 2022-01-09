package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FourWayBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallHeight;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class Wall_Kawara extends Block implements IWaterLoggable {

	/* Property */
	public static final BooleanProperty NORTH = BooleanProperty.create("north");
	public static final BooleanProperty EAST = BooleanProperty.create("east");
	public static final BooleanProperty SOUTH = BooleanProperty.create("south");
	public static final BooleanProperty WEST = BooleanProperty.create("west");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	private static final VoxelShape AABB_ALONE = VoxelShapes.or(Block.box(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
			Block.box(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D));
	
	private static final VoxelShape AABB_CENTER = Block.box(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	private static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.box(2.0D, 0.0D, 0.0D, 14.0D, 4.0D, 11.0D),
			Block.box(5.0D, 4.0D, 0.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_EAST = VoxelShapes.or(Block.box(5.0D, 0.0D, 2.0D, 16.0D, 4.0D, 14.0D),
			Block.box(11.0D, 4.0D, 5.0D, 16.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.box(2.0D, 0.0D, 5.0D, 14.0D, 4.0D, 16.0D),
			Block.box(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 16.0D));
	private static final VoxelShape AABB_WEST = VoxelShapes.or(Block.box(0.0D, 0.0D, 2.0D, 11.0D, 4.0D, 14.0D),
			Block.box(0.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	
	private static final VoxelShape UNDER_NE = Block.box(2.0D, 0.0D, 11.0D, 5.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_NW = Block.box(11.0D, 0.0D, 11.0D, 14.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_SE = Block.box(2.0D, 0.0D, 2.0D, 5.0D, 4.0D, 5.0D);
	private static final VoxelShape UNDER_SW = Block.box(11.0D, 0.0D, 2.0D, 14.0D, 4.0D, 5.0D);
	
	private static final VoxelShape AABB_NORTH2 = VoxelShapes.or(Block.box(2.0D, 0.0D, 11.0D, 14.0D, 4.0D, 12.0D),
			Block.box(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 12.0D));
	private static final VoxelShape AABB_EAST2 = VoxelShapes.or(Block.box(4.0D, 0.0D, 2.0D, 5.0D, 4.0D, 14.0D),
			Block.box(4.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH2 = VoxelShapes.or(Block.box(2.0D, 0.0D, 4.0D, 14.0D, 4.0D, 5.0D),
			Block.box(5.0D, 4.0D, 4.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_WEST2 = VoxelShapes.or(Block.box(11.0D, 0.0D, 2.0D, 12.0D, 4.0D, 14.0D),
			Block.box(11.0D, 4.0D, 5.0D, 12.0D, 8.0D, 11.0D));
	
	public Wall_Kawara(AbstractBlock.Properties properties) {
		super(properties);
		
		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(NORTH, Boolean.valueOf(false))
				.setValue(EAST, Boolean.valueOf(false))
				.setValue(SOUTH, Boolean.valueOf(false))
				.setValue(WEST, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		
		IWorldReader worldIn = context.getLevel();
		BlockPos posIn = context.getClickedPos();
		BlockPos northpos = posIn.north();
		BlockPos eastpos = posIn.east();
		BlockPos southpos = posIn.south();
		BlockPos westpos = posIn.west();
		BlockState northstate = worldIn.getBlockState(northpos);
		BlockState eaststate = worldIn.getBlockState(eastpos);
		BlockState southstate = worldIn.getBlockState(southpos);
		BlockState weststate = worldIn.getBlockState(westpos);
			
		BlockPos downpos = posIn.below();
		BlockState downstate = worldIn.getBlockState(downpos);
		Block downblock = downstate.getBlock();
		
		boolean north = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.NORTH)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.EAST || downstate.getValue(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.NORTH)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.NORTH_WALL) != WallHeight.NONE)) ||
				canConnectTo(northstate, northstate.isFaceSturdy(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
			
		boolean east = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.EAST)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downstate.getValue(Wall_Sama.H_FACING) == Direction.SOUTH)) || 
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.EAST)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.EAST_WALL) != WallHeight.NONE)) ||
				canConnectTo(eaststate, eaststate.isFaceSturdy(worldIn, eastpos, Direction.WEST), Direction.WEST);
			
		boolean south = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.SOUTH)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.EAST || downstate.getValue(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.SOUTH)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.SOUTH_WALL) != WallHeight.NONE)) ||
				canConnectTo(southstate, southstate.isFaceSturdy(worldIn, southpos, Direction.NORTH), Direction.NORTH);
			
		boolean west = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.WEST)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downstate.getValue(Wall_Sama.H_FACING) == Direction.SOUTH)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.WEST)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.WEST_WALL) != WallHeight.NONE)) ||
				canConnectTo(weststate, weststate.isFaceSturdy(worldIn, westpos, Direction.EAST), Direction.EAST);
				
		return this.defaultBlockState().setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west)
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
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


	/* Connect the blocks. */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(state, direction);
		return block instanceof Wall_Kawara || state.is(BlockTags.WALLS) || !isExceptionForConnection(block) && sturdy || block instanceof PaneBlock || flag;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos posIn, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(posIn, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		BlockPos northpos = posIn.north();
		BlockPos eastpos = posIn.east();
		BlockPos southpos = posIn.south();
		BlockPos westpos = posIn.west();
		BlockState northstate = worldIn.getBlockState(northpos);
		BlockState eaststate = worldIn.getBlockState(eastpos);
		BlockState southstate = worldIn.getBlockState(southpos);
		BlockState weststate = worldIn.getBlockState(westpos);
			
		BlockPos downpos = posIn.below();
		BlockState downstate = worldIn.getBlockState(downpos);
		Block downblock = downstate.getBlock();
		
		boolean north = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.NORTH)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.EAST || downstate.getValue(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.NORTH)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.NORTH_WALL) != WallHeight.NONE)) ||
				canConnectTo(northstate, northstate.isFaceSturdy(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
			
		boolean east = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.EAST)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downstate.getValue(Wall_Sama.H_FACING) == Direction.SOUTH)) || 
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.EAST)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.EAST_WALL) != WallHeight.NONE)) ||
				canConnectTo(eaststate, eaststate.isFaceSturdy(worldIn, eastpos, Direction.WEST), Direction.WEST);
			
		boolean south = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.SOUTH)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.EAST || downstate.getValue(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.SOUTH)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.SOUTH_WALL) != WallHeight.NONE)) ||
				canConnectTo(southstate, southstate.isFaceSturdy(worldIn, southpos, Direction.NORTH), Direction.NORTH);
			
		boolean west = (downblock instanceof Wall_Plaster && downstate.getValue(Wall_Plaster.WEST)) || 
				(downblock instanceof Wall_Sama && (downstate.getValue(Wall_Sama.H_FACING) == Direction.NORTH || downstate.getValue(Wall_Sama.H_FACING) == Direction.SOUTH)) ||
				(downblock instanceof FourWayBlock && downstate.getValue(FourWayBlock.WEST)) ||
				(downblock instanceof WallBlock && (downstate.getValue(WallBlock.WEST_WALL) != WallHeight.NONE)) ||
				canConnectTo(weststate, weststate.isFaceSturdy(worldIn, westpos, Direction.EAST), Direction.EAST);

		return stateIn.setValue(NORTH, north).setValue(EAST, east).setValue(SOUTH, south).setValue(WEST, west);
	}

	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.getValue(NORTH).booleanValue();
		boolean east = state.getValue(EAST).booleanValue();
		boolean south = state.getValue(SOUTH).booleanValue();
		boolean west = state.getValue(WEST).booleanValue();
		
		VoxelShape shape = AABB_CENTER;

		if (!north && !south && !east && !west) { shape = AABB_ALONE; }

		if (north && !south && !east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_NORTH2); }
		if (!north && south && !east && !west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_SOUTH2); }
		if (!north && !south && east && !west) { shape = VoxelShapes.or(shape, AABB_EAST, AABB_EAST2); }
		if (!north && !south && !east && west) { shape = VoxelShapes.or(shape, AABB_WEST, AABB_WEST2); }
		
		if (north && south && !east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_SOUTH); }
		if (!north && !south && east && west) { shape = VoxelShapes.or(shape, AABB_EAST, AABB_WEST); }
		
		if (north && !south && east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, UNDER_NE); }
		if (north && !south && !east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_WEST, UNDER_NW); }
		if (!north && south && east && !west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_EAST, UNDER_SE); }
		if (!north && south && !east && west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_WEST, UNDER_SW); }
		
		if (north && south && east && !west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_SOUTH); }
		if (north && south && !east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_WEST, AABB_SOUTH); }
		if (north && !south && east && west) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_WEST); }
		if (!north && south && east && west) { shape = VoxelShapes.or(shape, AABB_SOUTH, AABB_EAST, AABB_WEST); }
		
		if (north && east && west && south) { shape = VoxelShapes.or(shape, AABB_NORTH, AABB_EAST, AABB_WEST, AABB_SOUTH); }

		return shape;
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED);
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

}
