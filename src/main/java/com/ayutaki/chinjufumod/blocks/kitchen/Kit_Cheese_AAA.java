package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
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
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
	public Kit_Cheese_AAA(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		/** Hand is empty. **/
		if (itemstack.isEmpty()) {
			/** stage1=AAA **/
			if (i == 1) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE_CURD));
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
						.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OAA */
	
	
			/** stage2=BAA **/
			if (i == 2) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE));
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
						.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OAA */
	
	
			/** stage3=BBA **/
			if (i == 3) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE));
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
						.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OBA */
	
	
			/** stage4=BBB **/
			if (i == 4) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE));
				CMEvents.soundTake_Pick(worldIn, pos);
				worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(3))
						.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OBB */
		}
		
		/** Hand is not empty. **/
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	protected boolean hasWater(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-2, -2, -2), pos.offset(2, 2, 2))) {
			if (worldIn.getFluidState(blockpos).is(FluidTags.WATER)) {
				return true;
			}
		}
		return false;
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos) == true) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_TANA.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
					.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }

		else { }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/* stage1=AAA, stage2=BAA, stage3=BBA, stage4=BBB */
		int i = state.getValue(STAGE_1_4);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i < 4 && !hasWater(worldIn, pos) && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }

		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 3);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return AABB_NORTH;
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case EAST:
			return AABB_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.CHEESE_TANA);
	}

}