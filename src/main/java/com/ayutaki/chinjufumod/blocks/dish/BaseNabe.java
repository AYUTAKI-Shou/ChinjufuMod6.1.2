package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BaseNabe extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty COOK = BooleanProperty.create("cook");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(1.5D, 0.0D, 3.5D, 10.5D, 4.5D, 12.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(3.5D, 0.0D, 1.5D, 12.5D, 4.5D, 10.5D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(5.5D, 0.0D, 3.5D, 14.5D, 4.5D, 12.5D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(3.5D, 0.0D, 5.5D, 12.5D, 4.5D, 14.5D);

	protected static final VoxelShape COOK_SOUTH = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);
	protected static final VoxelShape COOK_WEST = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);
	protected static final VoxelShape COOK_NORTH = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);
	protected static final VoxelShape COOK_EAST = Block.makeCuboidShape(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(1.5D, -8.0D, 3.5D, 10.5D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(3.5D, -8.0D, 1.5D, 12.5D, 0.1D, 10.5D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(5.5D, -8.0D, 3.5D, 14.5D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(3.5D, -8.0D, 5.5D, 12.5D, 0.1D, 14.5D);

	public BaseNabe(Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(COOK, Boolean.valueOf(false))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(COOK, this.connectCook(worldIn, pos, Direction.DOWN))
				.with(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	/* Connect the blocks. */
	protected boolean connectCook(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return (block instanceof FurnaceBlock || block instanceof Kitchen_Oven || block instanceof Kitchen_Oven_B ||
				block instanceof Irori || block instanceof Kit_Cooktop);
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlabWater_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.get(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.get(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.get(Kotatsu.WATERLOGGED)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn)); }

		boolean cook = connectCook(worldIn, pos, Direction.DOWN);
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(COOK, cook).with(DOWN, down);
	}

	/* TickRandom */
	@Override
	public int tickRate(IWorldReader world) {
		return 60;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
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

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(COOK, DOWN, H_FACING, STAGE_1_4, WATERLOGGED);
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

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		boolean flag= !((Boolean)state.get(COOK)).booleanValue();
		boolean flag2= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
		case SOUTH:
			return flag ? (flag2? AABB_SOUTH : DOWN_SOUTH) : COOK_SOUTH;
		case WEST:
			return flag ? (flag2? AABB_WEST : DOWN_WEST) : COOK_WEST;
		case NORTH:
		default:
			return flag ? (flag2? AABB_NORTH : DOWN_NORTH) : COOK_NORTH;
		case EAST:
			return flag ? (flag2? AABB_EAST : DOWN_EAST) : COOK_EAST;
		}
	}

	/* 効果音・パーティクル */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		BlockState downstate = worldIn.getBlockState(pos.down());
		Block downblock = downstate.getBlock();

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (this != Dish_Blocks.NABEGOHAN) {

			if ((downblock == Blocks.FURNACE && downstate.get(FurnaceBlock.LIT) == true) ||
					(downblock == Kitchen_Blocks.KIT_OVEN && downstate.get(Kitchen_Oven.LIT) == true) ||
					(downblock == Kitchen_Blocks.KIT_OVEN_B && downstate.get(Kitchen_Oven_B.LIT) == true) ||
					(downblock == Kitchen_Blocks.IRORI && downstate.get(Irori.LIT) == true) ||
					(downblock == Kitchen_Blocks.KIT_COOKTOP && downstate.get(Kit_Cooktop.STAGE_1_3) == 2)) {

				if (rand.nextDouble() < 0.1D) {
					worldIn.playSound(d0, d1, d2, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.3F, 0.7F, false); }

				if (rand.nextDouble() < 0.25D) {
					/** 種類, 座標x, y, z, 速度x, y, z **/
					worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
			}
		}
	}

}
