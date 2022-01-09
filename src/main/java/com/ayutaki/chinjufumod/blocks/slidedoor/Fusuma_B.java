package com.ayutaki.chinjufumod.blocks.slidedoor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
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

public class Fusuma_B extends BaseSlidedoor {

	public Fusuma_B(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			worldIn.setBlockState(pos, state.cycle(OPEN));

			if (state.get(OPEN) == true) { CMEvents.soundFusumaL(worldIn, pos); }
			if (state.get(OPEN) == false) { CMEvents.soundFusumaL(worldIn, pos); }

			return ActionResultType.SUCCESS;
		}
	}

	public void toggleDoor(BlockState state, World worldIn, BlockPos pos, boolean open) {
		BlockState blockstate = worldIn.getBlockState(pos);
		if (blockstate.getBlock() == this && blockstate.get(OPEN) != open) {
			worldIn.setBlockState(pos, blockstate.with(OPEN, Boolean.valueOf(open)), 10);
			this.moveSound(worldIn, pos, open);
		}
	}

	/* 隣接ブロックの変化 */
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));

		if (block != this && flag != state.get(POWERED)) {
			if (flag != state.get(OPEN)) { this.moveSound(worldIn, pos, flag); }
			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)).with(OPEN, Boolean.valueOf(flag)), 2);
		}
	}

	/* Play Sound */
	private void moveSound(World worldIn, BlockPos pos, boolean isOpening) {
		if (isOpening == true) {
			CMEvents.soundFusumaL(worldIn, pos); }

		if (isOpening == false) {
			CMEvents.soundFusumaL(worldIn, pos); }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_fusuma")).applyTextStyle(TextFormatting.GRAY));
	}

}
