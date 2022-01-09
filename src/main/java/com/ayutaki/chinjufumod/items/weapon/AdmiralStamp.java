package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AdmiralStamp extends Item {

	public AdmiralStamp(Item.Properties builder) {
		super(builder);
	}

	@Override
	public boolean hasContainerItem() {
		return true;
	}

	@Override
	@Nullable
	public ItemStack getContainerItem(ItemStack itemStack) {

		ItemStack stack = itemStack.copy();
		if (stack.attemptDamageItem(1, random, null)) {
			stack.shrink(1);
			stack.setDamage(0);
		}
	 return stack;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return false;
	}
	
	/* アイテムは @Nullable World worldIn、ブロックは @Nullable IBlockReader worldIn*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_admiral_stamp")).applyTextStyle(TextFormatting.GRAY));
	}

}
