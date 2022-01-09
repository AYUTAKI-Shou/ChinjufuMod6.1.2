package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* MilkBucketItem を参照。extends は BlockNamedItem とする */
public class Dish_addItem extends BlockNamedItem {

	public Dish_addItem(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.TEATIME));
	}

	/* アイテム消費時の処理 */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		/** 追加効果 **/
		if (this == Items_Teatime.STEW) {
			/** ポーションエフェクトの追加 一口100 通常 120 **/
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 8, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.UDON_SU) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.UDON_NIKU || this == Items_Teatime.UDON_TSUKIMI) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.TONSUITORI) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 2, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 1000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 1500, 0)); }

		if (this == Items_Teatime.MISOSOUP) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 2, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.GOHAN) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }

		if (this == Items_Teatime.RICE) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 3, 0)); }

		if (this == Items_Teatime.DONBURI_MESHI) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 5, 0)); }

		if (this == Items_Teatime.CORNSOUP) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 2, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.HAKUSAIDUKE) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 500, 0)); }

		if (this == Items_Teatime.TAMAGOYAKI || this == Items_Teatime.CHICKEN_small) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 3, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 200, 0)); }

		if (this == Items_Teatime.DONBURI_GYU || this == Items_Teatime.DONBURI_OYAKO || this == Items_Teatime.DONBURI_KAISEN) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }

		if (this == Items_Teatime.DONBURI_KATSU) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3500, 0));
			entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3500, 0)); }

		if (this == Items_Teatime.EGGBURG) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 5, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 300, 0)); }

		if (this == Items_Teatime.PASTATOMATO || this == Items_Teatime.PASTACHEESE || this == Items_Teatime.PASTAKINOKO) {
			entityLiving.addEffect(new EffectInstance(Effects.SATURATION, 10, 0));
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 3000, 0));
			entityLiving.addEffect(new EffectInstance(Effects.HEAL, 1, 0));
			entityLiving.addEffect(new EffectInstance(Effects.REGENERATION, 3000, 0)); }


		/** アイテムの返し **/
		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.instabuild) {

				if (this == Items_Teatime.UDON_SU || this == Items_Teatime.UDON_NIKU || this == Items_Teatime.UDON_TSUKIMI ||
					this == Items_Teatime.DONBURI_MESHI || this == Items_Teatime.DONBURI_GYU || this == Items_Teatime.DONBURI_OYAKO ||
					this == Items_Teatime.DONBURI_KAISEN || this == Items_Teatime.DONBURI_KATSU) {

					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DONBURI); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.DONBURI))) { playerIn.drop(new ItemStack(Items_Teatime.DONBURI), false); }
				}

				else if (this == Items_Teatime.TONSUITORI) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.TONSUI); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.TONSUI))) { playerIn.drop(new ItemStack(Items_Teatime.TONSUI), false); }
				}


				else if (this == Items_Teatime.MISOSOUP) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.SHIKKI); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SHIKKI))) { playerIn.drop(new ItemStack(Items_Teatime.SHIKKI), false); }
				}

				else if (this == Items_Teatime.GOHAN) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.CHAWAN); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.CHAWAN))) { playerIn.drop(new ItemStack(Items_Teatime.CHAWAN), false); }
				}

				else if (this == Items_Teatime.STEW || this == Items_Teatime.RICE || this == Items_Teatime.CORNSOUP ||
							this == Items_Teatime.HAKUSAIDUKE || this == Items_Teatime.TAMAGOYAKI || this == Items_Teatime.CHICKEN_small ||
							this == Items_Teatime.EGGBURG || this == Items_Teatime.PASTATOMATO || this == Items_Teatime.PASTACHEESE ||
							this == Items_Teatime.PASTAKINOKO) {

					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.SARA); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SARA))) { playerIn.drop(new ItemStack(Items_Teatime.SARA), false); }
				}

				stack.shrink(1);
			}
		}
		return stack;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.EAT;
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		/** 食物が必要な時だけ成功 **/
		if (playerIn.getFoodData().needsFood()) {
			playerIn.startUsingItem(hand);
			return ActionResult.consume(playerIn.getItemInHand(hand));
		}
		return ActionResult.fail(playerIn.getItemInHand(hand));
	}

	/* 設置処理の分岐 スニーク時 playerIn.isCrouching() 座っている時 playerIn.isPassenger() */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getClickedFace() == Direction.UP && (playerIn.isCrouching() || playerIn.isPassenger())) {
			return this.place(new BlockItemUseContext(context)); }

		else {
			return this.use(context.getLevel(), context.getPlayer(), context.getHand()).getResult(); }
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_simpledish")).withStyle(TextFormatting.GRAY));
		if (this == Items_Teatime.DONBURI_GYU) {
			tooltip.add((new TranslationTextComponent("tips.block_food_dongyu_1")).withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KATSU) {
			tooltip.add((new TranslationTextComponent("tips.block_food_donkatsu_1")).withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_OYAKO) {
			tooltip.add((new TranslationTextComponent("tips.block_food_donoyako_1")).withStyle(TextFormatting.GRAY)); }
		if (this == Items_Teatime.DONBURI_KAISEN) {
			tooltip.add((new TranslationTextComponent("tips.block_food_donkaisen_1")).withStyle(TextFormatting.GRAY)); }
	}

}
