package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.FourWayBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
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
	private static final VoxelShape AABB_ALONE = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D));
	
	private static final VoxelShape AABB_CENTER = Block.makeCuboidShape(5.0D, 4.0D, 5.0D, 11.0D, 8.0D, 11.0D);
	private static final VoxelShape AABB_NORTH = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 0.0D, 14.0D, 4.0D, 11.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 0.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_EAST = VoxelShapes.or(Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 16.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(11.0D, 4.0D, 5.0D, 16.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 5.0D, 14.0D, 4.0D, 16.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 16.0D));
	private static final VoxelShape AABB_WEST = VoxelShapes.or(Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 11.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(0.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	
	private static final VoxelShape UNDER_NE = Block.makeCuboidShape(2.0D, 0.0D, 11.0D, 5.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_NW = Block.makeCuboidShape(11.0D, 0.0D, 11.0D, 14.0D, 4.0D, 14.0D);
	private static final VoxelShape UNDER_SE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 5.0D, 4.0D, 5.0D);
	private static final VoxelShape UNDER_SW = Block.makeCuboidShape(11.0D, 0.0D, 2.0D, 14.0D, 4.0D, 5.0D);
	
	private static final VoxelShape AABB_NORTH2 = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 11.0D, 14.0D, 4.0D, 12.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 11.0D, 11.0D, 8.0D, 12.0D));
	private static final VoxelShape AABB_EAST2 = VoxelShapes.or(Block.makeCuboidShape(4.0D, 0.0D, 2.0D, 5.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(4.0D, 4.0D, 5.0D, 5.0D, 8.0D, 11.0D));
	private static final VoxelShape AABB_SOUTH2 = VoxelShapes.or(Block.makeCuboidShape(2.0D, 0.0D, 4.0D, 14.0D, 4.0D, 5.0D),
			Block.makeCuboidShape(5.0D, 4.0D, 4.0D, 11.0D, 8.0D, 5.0D));
	private static final VoxelShape AABB_WEST2 = VoxelShapes.or(Block.makeCuboidShape(11.0D, 0.0D, 2.0D, 12.0D, 4.0D, 14.0D),
			Block.makeCuboidShape(11.0D, 4.0D, 5.0D, 12.0D, 8.0D, 11.0D));
	
	public Wall_Kawara(Block.Properties properties) {
		super(properties);
		
		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.valueOf(false))
				.with(EAST, Boolean.valueOf(false))
				.with(SOUTH, Boolean.valueOf(false))
				.with(WEST, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		
		IWorldReader worldIn = context.getWorld();
		BlockPos posIn = context.getPos();
		BlockPos northpos = posIn.north();
		BlockPos eastpos = posIn.east();
		BlockPos southpos = posIn.south();
		BlockPos westpos = posIn.west();
		BlockState northstate = worldIn.getBlockState(northpos);
		BlockState eaststate = worldIn.getBlockState(eastpos);
		BlockState southstate = worldIn.getBlockState(southpos);
		BlockState weststate = worldIn.getBlockState(westpos);
			
		BlockPos downpos = posIn.down();
		BlockState downstate = worldIn.getBlockState(downpos);
		Block downblock = downstate.getBlock();
		
		boolean north = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.NORTH)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.EAST || downstate.get(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.NORTH)) ||
				canConnectTo(northstate, northstate.isSolidSide(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
			
		boolean east = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.EAST)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.NORTH || downstate.get(Wall_Sama.H_FACING) == Direction.SOUTH)) || 
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.EAST)) ||
				canConnectTo(eaststate, eaststate.isSolidSide(worldIn, eastpos, Direction.WEST), Direction.WEST);
			
		boolean south = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.SOUTH)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.EAST || downstate.get(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.SOUTH)) ||
				canConnectTo(southstate, southstate.isSolidSide(worldIn, southpos, Direction.NORTH), Direction.NORTH);
			
		boolean west = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.WEST)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.NORTH || downstate.get(Wall_Sama.H_FACING) == Direction.SOUTH)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.WEST)) ||
				canConnectTo(weststate, weststate.isSolidSide(worldIn, westpos, Direction.EAST), Direction.EAST);
				
		return this.getDefaultState().with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west)
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}
	
	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	/* Connect the blocks. */
	private boolean canConnectTo(BlockState state, boolean sturdy, Direction direction) {
		Block block = state.getBlock();
		boolean flag = block instanceof FenceGateBlock && FenceGateBlock.isParallel(state, direction);
		return state.isIn(BlockTags.WALLS) || !cannotAttach(block) && sturdy || block instanceof PaneBlock || flag;
	}

	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos posIn, BlockPos facingPos) {
		if ((Boolean)stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(posIn, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		BlockPos northpos = posIn.north();
		BlockPos eastpos = posIn.east();
		BlockPos southpos = posIn.south();
		BlockPos westpos = posIn.west();
		BlockState northstate = worldIn.getBlockState(northpos);
		BlockState eaststate = worldIn.getBlockState(eastpos);
		BlockState southstate = worldIn.getBlockState(southpos);
		BlockState weststate = worldIn.getBlockState(westpos);
			
		BlockPos downpos = posIn.down();
		BlockState downstate = worldIn.getBlockState(downpos);
		Block downblock = downstate.getBlock();
		
		boolean north = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.NORTH)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.EAST || downstate.get(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.NORTH)) ||
				canConnectTo(northstate, northstate.isSolidSide(worldIn, northpos, Direction.SOUTH), Direction.SOUTH);
			
		boolean east = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.EAST)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.NORTH || downstate.get(Wall_Sama.H_FACING) == Direction.SOUTH)) || 
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.EAST)) ||
				canConnectTo(eaststate, eaststate.isSolidSide(worldIn, eastpos, Direction.WEST), Direction.WEST);
			
		boolean south = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.SOUTH)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.EAST || downstate.get(Wall_Sama.H_FACING) == Direction.WEST)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.SOUTH)) ||
				canConnectTo(southstate, southstate.isSolidSide(worldIn, southpos, Direction.NORTH), Direction.NORTH);
			
		boolean west = (downblock instanceof Wall_Plaster && downstate.get(Wall_Plaster.WEST)) || 
				(downblock instanceof Wall_Sama && (downstate.get(Wall_Sama.H_FACING) == Direction.NORTH || downstate.get(Wall_Sama.H_FACING) == Direction.SOUTH)) ||
				(downblock instanceof FourWayBlock && downstate.get(FourWayBlock.WEST)) ||
				canConnectTo(weststate, weststate.isSolidSide(worldIn, westpos, Direction.EAST), Direction.EAST);
		
		return stateIn.with(NORTH, north).with(EAST, east).with(SOUTH, south).with(WEST, west);
	}
	
	/* Collision */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		boolean north = state.get(NORTH).booleanValue();
		boolean east = state.get(EAST).booleanValue();
		boolean south = state.get(SOUTH).booleanValue();
		boolean west = state.get(WEST).booleanValue();

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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
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

}
