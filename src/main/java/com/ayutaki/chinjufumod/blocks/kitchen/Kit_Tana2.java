package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kit_Tana2 extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 12.0D);
	protected static final VoxelShape AABB_WEST = Block.box(4.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 4.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 16.0D);

	public Kit_Tana2(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		if (item == Items_Teatime.NAMASAKEBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SAKENAMA.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SAKEBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SAKE.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUSAKEBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SAKEJUKU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.CIDERBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_CIDER.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUCIDERBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_CIDERJUKU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.WINEBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_WINE.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUWINEBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_WINEJUKU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.MEADBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_MEAD.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.JUKUMEADBOT) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_MEADJUKU.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_WineTana.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item != Items_Teatime.NAMASAKEBOT && item != Items_Teatime.SAKEBOT && item != Items_Teatime.JUKUSAKEBOT &&
				item != Items_Teatime.CIDERBOT && item != Items_Teatime.JUKUCIDERBOT &&
				item != Items_Teatime.WINEBOT && item != Items_Teatime.JUKUWINEBOT &&
				item != Items_Teatime.MEADBOT && item != Items_Teatime.JUKUMEADBOT) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kit2_tana")).withStyle(TextFormatting.GRAY));
	}

}
