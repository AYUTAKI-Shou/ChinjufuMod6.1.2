package com.ayutaki.chinjufumod.items.hakkou;

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
public class SakeGlass extends BlockNamedItem {

	public SakeGlass(Block block, Item.Properties builder) {
		super(block, builder.tab(ItemGroups_CM.TEATIME));
	}

	/* アイテム消費時の追加処理 */
	@Override
	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {

		PlayerEntity playerIn = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

		if (this == Items_Teatime.NAMASAKEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.SAKEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUSAKEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 2));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (this == Items_Teatime.AMAZAKEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DIG_SPEED, 2000, 0)); }

		if (this == Items_Teatime.CIDERGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUCIDERGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2250, 0)); }
		if (this == Items_Teatime.WINEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUWINEGLASS) {
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (this == Items_Teatime.MEADGLASS) {
			entityLiving.removeEffect(Effects.POISON);
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 0));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2600, 0)); }
		if (this == Items_Teatime.JUKUMEADGLASS) {
			entityLiving.removeEffect(Effects.POISON);
			entityLiving.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 2250, 1));
			entityLiving.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2250, 0)); }

		if (playerIn != null) {
			playerIn.awardStat(Stats.ITEM_USED.get(this));

			if (!playerIn.abilities.instabuild) {
				if (this != Items_Teatime.AMAZAKEGLASS) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.DRINKGLASS); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.DRINKGLASS))) {
						playerIn.drop(new ItemStack(Items_Teatime.DRINKGLASS), false); } }

				if (this == Items_Teatime.AMAZAKEGLASS) {
					if (stack.isEmpty()) { return new ItemStack(Items_Teatime.YUNOMI); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.YUNOMI))) {
						playerIn.drop(new ItemStack(Items_Teatime.YUNOMI), false); } }

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
		return UseAction.DRINK;
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		playerIn.startUsingItem(hand);
		return ActionResult.consume(playerIn.getItemInHand(hand));
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
	}

}