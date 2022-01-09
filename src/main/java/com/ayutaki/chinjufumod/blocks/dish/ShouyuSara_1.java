package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShouyuSara_1 extends BaseFood_Stage9Water {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(6.0D, 0.0D, 9.0D, 10.0D, 0.5D, 13.0D);
	protected static final VoxelShape AABB_WEST = Block.box(3.0D, 0.0D, 6.0D, 7.0D, 0.5D, 10.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(6.0D, 0.0D, 3.0D, 10.0D, 0.5D, 7.0D);
	protected static final VoxelShape AABB_EAST = Block.box(9.0D, 0.0D, 6.0D, 13.0D, 0.5D, 10.0D);

	protected static final VoxelShape DOWN_SOUTH = Block.box(6.0D, -8.0D, 9.0D, 10.0D, 0.1D, 13.0D);
	protected static final VoxelShape DOWN_WEST = Block.box(3.0D, -8.0D, 6.0D, 7.0D, 0.1D, 10.0D);
	protected static final VoxelShape DOWN_NORTH = Block.box(6.0D, -8.0D, 3.0D, 10.0D, 0.1D, 7.0D);
	protected static final VoxelShape DOWN_EAST = Block.box(9.0D, -8.0D, 6.0D, 13.0D, 0.1D, 10.0D);

	public ShouyuSara_1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_9);

		if (!state.getValue(WATERLOGGED)) {
			
			/** Not empty **/
			if (i != 9) {
				if (item == Items_Teatime.SUSHI_S) {
					/** Collect with an Item **/
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundTake(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_S)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_S))) {
						playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_S), false); }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }
		
				if (item == Items_Teatime.SUSHI_F) {
					/** Collect with an Item **/
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundTake(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_F)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_F))) {
						playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_F), false); }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }
		
				if (item == Items_Teatime.SUSHI_B) {
					/** Collect with an Item **/
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundTake(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_B)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_B))) {
						playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_B), false); }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }
		
				if (item == Items_Teatime.SUSHI_T) {
					/** Collect with an Item **/
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundTake(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_T)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHOUYUSUSHI_T))) {
						playerIn.drop(new ItemStack(Items_Teatime.SHOUYUSUSHI_T), false); }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(i + 1)), 3); }
				
				if (item != Items_Teatime.SUSHI_S && item != Items_Teatime.SUSHI_F && item != Items_Teatime.SUSHI_B && item != Items_Teatime.SUSHI_T) {
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		
			/** Empty **/
			if (i == 9) {
				if (item == Items_Teatime.SHOUYU_bot_1) {
					CMEvents.SoysauceTo2(worldIn, pos, playerIn, hand);	
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
	
				if (item == Items_Teatime.SHOUYU_bot_2) {
					CMEvents.SoysauceTo3(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
	
				if (item == Items_Teatime.SHOUYU_bot_3) {
					CMEvents.SoysauceTo4(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
	
				if (item == Items_Teatime.SHOUYU_bot_4) {
					CMEvents.SoysauceToBottle(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(1)), 3); }
				
				if (item != Items_Teatime.SHOUYU_bot_1 && item != Items_Teatime.SHOUYU_bot_2 && item != Items_Teatime.SHOUYU_bot_3 && item != Items_Teatime.SHOUYU_bot_4) {
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case NORTH:
		default:
			return flag? AABB_NORTH : DOWN_NORTH;
		case SOUTH:
			return flag? AABB_SOUTH : DOWN_SOUTH;
		case WEST:
			return flag? AABB_WEST : DOWN_WEST;
		case EAST:
			return flag? AABB_EAST : DOWN_EAST;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_9);
		return (i == 1)? new ItemStack(Items_Teatime.SHOUYUSARA_1) : new ItemStack(Items_Teatime.SARA);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_1_9, Integer.valueOf(9)), 3); }
		
		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_food_shouyusara_1")).withStyle(TextFormatting.GRAY));
	}

}
