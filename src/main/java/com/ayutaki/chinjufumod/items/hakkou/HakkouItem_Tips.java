package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HakkouItem_Tips extends BlockNamedItem {

	public HakkouItem_Tips(Block block, Item.Properties builder) {
		super(block, builder);
	}

	/* tips表示 GRAYが1.12.2でのデフォルト色。Item.class の334行目*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);

		if (this == Items_Teatime.SHOUYU_bot_1 || this == Items_Teatime.DASHI_bot_1) {
			tooltip.add((new TranslationTextComponent("tips.block_bot")).applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.SHOUYU_bot_2 || this == Items_Teatime.DASHI_bot_2) {
			tooltip.add((new TranslationTextComponent("tips.block_bot_2")).applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.SHOUYU_bot_3 || this == Items_Teatime.DASHI_bot_3 || this == Items_Teatime.KOMEZU_bot_1) {
			tooltip.add((new TranslationTextComponent("tips.block_bot_3")).applyTextStyle(TextFormatting.GRAY)); }

		if (this == Items_Teatime.SHOUYU_bot_4 || this == Items_Teatime.DASHI_bot_4 || this == Items_Teatime.KOMEZU_bot_2) {
			tooltip.add((new TranslationTextComponent("tips.block_bot_4")).applyTextStyle(TextFormatting.GRAY)); }
	}

}
