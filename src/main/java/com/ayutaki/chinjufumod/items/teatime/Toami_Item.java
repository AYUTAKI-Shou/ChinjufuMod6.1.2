package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.ToamiEntity;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Toami_Item extends BlockNamedItem {

	public Toami_Item(Block blockIn, Item.Properties builder) {
		super(blockIn, builder);
	}

	/* 投げて使用 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.abilities.isCreativeMode;

		playerIn.playSound(SoundEvents_CM.THROW, 1.0F, 1.0F);
		
		if (!worldIn.isRemote) {

			/** Entity の速度≒飛距離 **/
			int j = 6;

			if (mode) {
				ToamiEntity toami = new ToamiEntity(playerIn, worldIn, itemstack);
				toami.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.addEntity(toami);

				playerIn.inventory.deleteStack(itemstack); } // World is CreativeMode.

			if (!mode) {
				if (itemstack.getDamage() >= (itemstack.getMaxDamage() - 1)) {
					CMEvents.soundKKBreak(worldIn, playerIn);
					itemstack.shrink(1); }

				else {
					/** 投擲時に耐久消費 **/
					itemstack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );

					ToamiEntity toami = new ToamiEntity(playerIn, worldIn, itemstack);
					toami.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
					worldIn.addEntity(toami);
					
					itemstack.shrink(1); } } // World is not CreativeMode.
		}

		return ActionResult.resultSuccess(itemstack);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.STRING || material.getItem() == Items_Seasonal.ORIITO; }
	
	//////* BlockItem *///////////////////////////////////////////////
	/** 設置処理の分岐 **/
	public ActionResultType onItemUse(ItemUseContext context) {
		return this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand()).getType();
	}

	public ActionResultType tryPlace(BlockItemUseContext context) {
		return ActionResultType.FAIL;
	}

	protected boolean canPlace(BlockItemUseContext context, BlockState state) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_toami")).applyTextStyle(TextFormatting.GRAY));
	}

}
