package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemKumade extends Item {

	public ItemKumade(Properties builder) {
		super(builder);
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = iworld.getBlockState(blockpos);
		Block block = blockstate.getBlock();

		ItemStack itemstack = context.getItem();

		/** 砂 **/
		if (block == Blocks.SAND) {

			iworld.playSound(playerIn, blockpos, SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			iworld.setBlockState(blockpos, Garden_Blocks.SAMON.getDefaultState().with(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.GRAVEL) {

			iworld.playSound(playerIn, blockpos, SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			iworld.setBlockState(blockpos, Garden_Blocks.SAMON_B.getDefaultState().with(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }
		
		return ActionResultType.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.STICK;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_kumade")).applyTextStyle(TextFormatting.GRAY));
	}

}
