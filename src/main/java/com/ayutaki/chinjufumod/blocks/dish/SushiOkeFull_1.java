package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SushiOkeFull_1 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.5D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, -0.1D, 16.0D);

	public SushiOkeFull_1(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_9);

		/** Hand is empty. **/
		if (itemstack.isEmpty()) {
			CMEvents.soundTake_Pick(worldIn, pos);

			if (i < 8) {
				if (i == 1) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 2) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 3) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B)); }
				if (i == 4) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T)); }

				if (i == 5) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S)); }
				if (i == 6) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F)); }
				if (i == 7) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B)); }

				worldIn.setBlockState(pos, state.with(STAGE_1_9, Integer.valueOf(i + 1))); }

			if (i == 8) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T));

				worldIn.setBlockState(pos, Dish_Blocks.SUSHIOKE_FULL_9.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(DOWN, state.get(DOWN))
						.with(STAGE_1_9, Integer.valueOf(1))); }
		}
		
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.get(STAGE_1_9);
		return (i == 1)? new ItemStack(Items_Teatime.SUSHIOKE_FULL_1) : new ItemStack(Items_Teatime.SUSHIOKE);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.SUSHIOKE_FULL_9.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(DOWN, state.get(DOWN))
					.with(SushiOkeFull_9.STAGE_1_9, Integer.valueOf(9))
					.with(SushiOkeFull_9.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

}
