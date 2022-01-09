package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Kit_Cheese_AAA extends BaseStage4_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
	public Kit_Cheese_AAA(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);

		/** Hand is empty. **/
		if (itemstack.isEmpty()) {
			/** stage1=AAA **/
			if (i == 1) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE_CURD));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_OAA.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
						.with(BaseStage3_FaceWater.WATERLOGGED, state.get(WATERLOGGED))); } /* → OAA */
	
	
			/** stage2=BAA **/
			if (i == 2) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_OAA.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
						.with(BaseStage3_FaceWater.WATERLOGGED, state.get(WATERLOGGED))); } /* → OAA */
	
	
			/** stage3=BBA **/
			if (i == 3) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_OAA.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
						.with(BaseStage3_FaceWater.WATERLOGGED, state.get(WATERLOGGED))); } /* → OBA */
	
	
			/** stage4=BBB **/
			if (i == 4) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_OAA.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(3))
						.with(BaseStage3_FaceWater.WATERLOGGED, state.get(WATERLOGGED))); } /* → OBB */
			}
		
		/** Hand is not empty. **/
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	protected boolean hasWater(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-2, -2, -2), pos.add(2, 2, 2))) {
			if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
				return true;
			}
		}
		return false;
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos) == true) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 100); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 100); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 100);
			CMEvents.soundSnowBreak(worldIn, pos);
			this.dropRottenfood(worldIn, pos);
			worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
					.with(BaseStage3_FaceWater.WATERLOGGED, state.get(WATERLOGGED)), 3); }
		
		else { }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
		int i = state.get(STAGE_1_4);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i < 4 && !hasWater(worldIn, pos) && rand.nextInt(4) == 0) {
			worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }

		else { }
	}


	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 3);
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
		return new ItemStack(Items_Teatime.CHEESE_TANA);
	}

}
