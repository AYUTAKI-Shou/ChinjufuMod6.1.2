package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HodaGi_A_Bot extends Base_HodaGi_Bot {

	public HodaGi_A_Bot(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);
		double hitY = hit.getHitVec().y - (double)hit.getPos().getY();

		if (i != 1) {
			
			if (itemstack.isEmpty() && hitY < 0.75D) {
				
				CMEvents.takeKinoko(worldIn, pos, playerIn);
				
				if (i == 2) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_B_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(1))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
		
				if (i == 3) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_B_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(2))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
		
				if (i == 4) {
					worldIn.setBlockState(pos, Crop_Blocks.HODAGI_B_BOT.getDefaultState()
							.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING))
							.with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(3))
							.with(Base_HodaGi_Bot.WATERLOGGED, state.get(WATERLOGGED))); }
			}
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(), Crop_Blocks.HODAGI_A_TOP.getDefaultState()
				.with(Base_HodaGi_Bot.H_FACING, state.get(H_FACING)).with(Base_HodaGi_Bot.STAGE_1_4, Integer.valueOf(1)));
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_hodagi_a_bot")).applyTextStyle(TextFormatting.GRAY));
	}

}
