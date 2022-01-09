package com.ayutaki.chinjufumod.items.shield;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Shield_CM extends ShieldItem {

	public Shield_CM(Item.Properties builder) {
		super(builder);
		/** 336×3 =1008, ×5=1680, ×7=2352, ×9=3024 **/
	}
		
	/* 盾として消耗処理 */
	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		return stack.getItem() instanceof ShieldItem;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_shield")).withStyle(TextFormatting.GRAY));
	}

}
