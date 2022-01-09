package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.KK_TBFEntity;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity2;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity3;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity4;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TBF extends BaseKansaiki {

	private final float attackDamage = 11.0F - 1.0F;
	private final float attackSpeed = -2.4F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public TBF(Item.Properties properties) {
		super(properties);

		Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
		builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		this.defaultModifiers = builder.build();
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	@SuppressWarnings("deprecation")
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType slotType) {
		return slotType == EquipmentSlotType.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slotType);
	}

	/* 投げて使用 */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.abilities.instabuild;
		
		if (!worldIn.isClientSide) {

			if (!playerIn.isUnderWater()) {
				/** Entity の速度≒飛距離 **/
				int j = 8;
				
				if (mode) {
					
					/** レベルに応じた Entity発艦 **/
					if (playerIn.experienceLevel < 12) {
						KK_TBFEntity kansaiki = new KK_TBFEntity(playerIn, worldIn, itemstack);
						kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
						worldIn.addFreshEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
						KK_TBFEntity2 kansaiki = new KK_TBFEntity2(playerIn, worldIn, itemstack);
						kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
						worldIn.addFreshEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
						KK_TBFEntity3 kansaiki = new KK_TBFEntity3(playerIn, worldIn, itemstack);
						kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
						worldIn.addFreshEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 25) {
						KK_TBFEntity4 kansaiki = new KK_TBFEntity4(playerIn, worldIn, itemstack);
						kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
						worldIn.addFreshEntity(kansaiki); }
					
					playerIn.awardStat(Stats.ITEM_USED.get(this));
					playerIn.inventory.removeItem(itemstack);
				} // World is CreativeMode.
	
				if (!mode) {
					if (itemstack.getDamageValue() >= (itemstack.getMaxDamage() - 1)) {
						CMEvents.soundKKBreak(worldIn, playerIn);
						
						playerIn.awardStat(Stats.ITEM_USED.get(this));
						itemstack.shrink(1); }
	
					else {
						/** 発艦時に耐久消費 **/
						itemstack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );
	
						/** レベルに応じた Entity発艦 **/
						if (playerIn.experienceLevel < 12) {
							KK_TBFEntity kansaiki = new KK_TBFEntity(playerIn, worldIn, itemstack);
							kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
							worldIn.addFreshEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							KK_TBFEntity2 kansaiki = new KK_TBFEntity2(playerIn, worldIn, itemstack);
							kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
							worldIn.addFreshEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							KK_TBFEntity3 kansaiki = new KK_TBFEntity3(playerIn, worldIn, itemstack);
							kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
							worldIn.addFreshEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 25) {
							KK_TBFEntity4 kansaiki = new KK_TBFEntity4(playerIn, worldIn, itemstack);
							kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
							worldIn.addFreshEntity(kansaiki); }
	
						playerIn.awardStat(Stats.ITEM_USED.get(this));
						itemstack.shrink(1); } } // World is not CreativeMode.
			} // Player is not under the Water.
			
			if (playerIn.isUnderWater()) {
				CMEvents.textKKError(worldIn, playerIn);
			} // Player is under the Water.
		}
		
		return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_kk")).withStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.item_kk_tbf")).withStyle(TextFormatting.DARK_GREEN));
	}

}
