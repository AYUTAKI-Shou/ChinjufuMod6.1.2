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
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SushiSet extends BaseFood_Stage5Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 14.0D, 3.0D, 12.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(3.5D, 0.0D, 0.0D, 11.0D, 3.0D, 14.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(2.0D, 0.0D, 3.5D, 16.0D, 3.0D, 11.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(5.0D, 0.0D, 2.0D, 12.5D, 3.0D, 16.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.makeCuboidShape(0.0D, -8.0D, 5.0D, 14.0D, 0.1D, 12.5D);
	protected static final VoxelShape DOWN_WEST = Block.makeCuboidShape(3.5D, -8.0D, 0.0D, 11.0D, 0.1D, 14.0D);
	protected static final VoxelShape DOWN_NORTH = Block.makeCuboidShape(2.0D, -8.0D, 3.5D, 16.0D, 0.1D, 11.0D);
	protected static final VoxelShape DOWN_EAST = Block.makeCuboidShape(5.0D, -8.0D, 2.0D, 12.5D, 0.1D, 16.0D);

	public SushiSet(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_5);

		if (i != 5) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
	
				CMEvents.soundTake_Pick(worldIn, pos);
				if (i == 1) {
					if (this == Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					if (this == Dish_Blocks.SUSHISET_salmon) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					if (this == Dish_Blocks.SUSHISET_fish) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					if (this == Dish_Blocks.SUSHISET_beef) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					if (this == Dish_Blocks.SUSHISET_tamago) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); } }
	
				if (i == 2) {
					if (this == Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					if (this == Dish_Blocks.SUSHISET_salmon) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					if (this == Dish_Blocks.SUSHISET_fish) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					if (this == Dish_Blocks.SUSHISET_beef) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					if (this == Dish_Blocks.SUSHISET_tamago) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); } }
	
				if (i == 3) {
					if (this == Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					if (this == Dish_Blocks.SUSHISET_salmon) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					if (this == Dish_Blocks.SUSHISET_fish) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					if (this == Dish_Blocks.SUSHISET_beef) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					if (this == Dish_Blocks.SUSHISET_tamago) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); } }
	
				if (i == 4) {
					if (this == Dish_Blocks.SUSHISET_4shoku) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); }
					if (this == Dish_Blocks.SUSHISET_salmon) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					if (this == Dish_Blocks.SUSHISET_fish) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					if (this == Dish_Blocks.SUSHISET_beef) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					if (this == Dish_Blocks.SUSHISET_tamago) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); } }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1))); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		switch(direction) {
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.get(STAGE_1_5);

		if (this == Dish_Blocks.SUSHISET_4shoku && i == 1) { return new ItemStack(Items_Teatime.SUSHISET_4shoku); }
		if (this == Dish_Blocks.SUSHISET_salmon && i == 1) { return new ItemStack(Items_Teatime.SUSHISET_salmon); }
		if (this == Dish_Blocks.SUSHISET_fish && i == 1) { return new ItemStack(Items_Teatime.SUSHISET_fish); }
		if (this == Dish_Blocks.SUSHISET_beef && i == 1) { return new ItemStack(Items_Teatime.SUSHISET_beef); }
		if (this == Dish_Blocks.SUSHISET_tamago && i == 1) { return new ItemStack(Items_Teatime.SUSHISET_tamago); }
		return new ItemStack(Items_Teatime.SUSHIGETA_kara);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_5);
		
		if (i != 5) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(5)));
				this.dropRottenfood(worldIn, pos); }
			
			else { }
		}
		
		if (i == 5) { }
	}

}
