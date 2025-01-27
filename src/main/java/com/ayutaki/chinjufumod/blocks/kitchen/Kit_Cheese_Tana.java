package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kit_Cheese_Tana extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	/* stage1=OOO, stage2=OOA, stage3=OOB */
	public Kit_Cheese_Tana(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		int i = state.getValue(STAGE_1_3);

		/** Hand is empty. **/
		if (itemstack.isEmpty() && item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) {
			
			/** stage1=OOO **/
			if (i == 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			/** stage2=OOA **/
			if (i == 2) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE_CURD));

				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		
			/** stage3=OOB **/
			if (i == 3) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		}
		
		/** Hand is not empty. **/
		if (!itemstack.isEmpty()) {
			
			if (item == Items_Teatime.CHEESE_CURD) {
				if (i == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(2)), 3); } /* → OOA */

				if (i == 2) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					
					worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(1))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OAA */
				
				if (i == 3) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					
					worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OBA */
			}
			
			if (item == Items_Teatime.CHEESE) {
				if (i == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3); } /* → OOB */
				
				if (i == 2) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					
					worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(2))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OBA */
				
				if (i == 3) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					
					worldIn.setBlock(pos, Kitchen_Blocks.CHEESE_OAA.defaultBlockState()
							.setValue(BaseStage3_FaceWater.H_FACING, state.getValue(H_FACING))
							.setValue(BaseStage3_FaceWater.STAGE_1_3, Integer.valueOf(3))
							.setValue(BaseStage3_FaceWater.WATERLOGGED, state.getValue(WATERLOGGED)), 3); } /* → OBB */
			}
			
			if (item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) { CMEvents.textFullItem(worldIn, pos, playerIn); }	
		}

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
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

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

		/* stage1=OOO, stage2=OOA, stage3=OOB */
		int i = state.getValue(STAGE_1_3);

		if (inWater(state, worldIn, pos)) {
			if (i != 1) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 100);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			if (i == 1) { }
		}

		else { }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_3);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i == 2 && !hasWater(worldIn, pos) && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }

		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kit_cheese_tana")).withStyle(TextFormatting.GRAY));
	}

}
