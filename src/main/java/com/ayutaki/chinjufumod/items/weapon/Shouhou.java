package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Shouhou extends Item {

	public Shouhou(Item.Properties builder) {
		super(builder);
	}

	/* RightClick Action */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if (!worldIn.isRemote) {
			worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ITEM_BOOK_PAGE_TURN, SoundCategory.PLAYERS, 1.2F, 1.0F);

			worldIn.addEntity(new ExperienceOrbEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 100));
			itemstack.shrink(1);
			
			return ActionResult.resultSuccess(itemstack);
		}
		return ActionResult.resultSuccess(itemstack);
	}
	
	/* アイテムは @Nullable World worldIn、ブロックは @Nullable IBlockReader worldIn*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_shouhou")).applyTextStyle(TextFormatting.GRAY));
	}

}
