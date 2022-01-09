package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.garden.Base_Niwaishi;
import com.ayutaki.chinjufumod.handler.CMEvents;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemChisel extends Item {

	public ItemChisel(Properties builder) {
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
		
		/** Stone **/
		if (block == Blocks.STONE) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.GRANITE) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_gra.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.DIORITE) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_dio.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.ANDESITE) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_and.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		/** Slab **/
		if (block == Blocks.STONE_SLAB) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_slab.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.GRANITE_SLAB) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_slab_gra.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.DIORITE_SLAB) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_slab_dio.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }

		if (block == Blocks.ANDESITE_SLAB) {
			CMEvents.soundChisel(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Garden_Blocks.NIWAISHI_slab_and.getDefaultState().with(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);

			itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS; }
		
		/** Garden stone → Base_Niwaishi に移動 **/

		return ActionResultType.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_chisel")).applyTextStyle(TextFormatting.GRAY));
	}

}
