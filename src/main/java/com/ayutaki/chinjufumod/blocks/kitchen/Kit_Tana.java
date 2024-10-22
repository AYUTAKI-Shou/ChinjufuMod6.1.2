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

public class Kit_Tana extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 10.0D);
	protected static final VoxelShape AABB_WEST = Block.box(6.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.box(0.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

	public Kit_Tana(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		if (item == Items_Teatime.SARA) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SARA1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.TONSUI) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_TONSUI1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.YUNOMI) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_YUNOMI1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana7.STAGE_1_7, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.TCUP_kara) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_TCUP1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana7.STAGE_1_7, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.CHAWAN) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_CHAWAN1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SHIKKI) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundWoodenDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SHIKKI1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana6.STAGE_1_6, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.DRINKGLASS) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_DRINKGLASS1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana9.STAGE_1_9, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.DONBURI) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_DONBURI1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana4.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item == Items_Teatime.SUSHIGETA_kara) {
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundWoodenDishPlace(worldIn, pos);
			
			worldIn.setBlock(pos, Kitchen_Blocks.KIT_SUSHIGETA1.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Base_Tana4.STAGE_1_4, Integer.valueOf(1)), 3); }

		if (item != Items_Teatime.SARA && item != Items_Teatime.TONSUI && item != Items_Teatime.YUNOMI &&
				item != Items_Teatime.TCUP_kara && item != Items_Teatime.CHAWAN && item != Items_Teatime.SHIKKI &&
				item != Items_Teatime.DRINKGLASS && item != Items_Teatime.DONBURI && item != Items_Teatime.SUSHIGETA_kara) {
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
		tooltip.add((new TranslationTextComponent("tips.block_kit_tana")).withStyle(TextFormatting.GRAY));
	}

}
