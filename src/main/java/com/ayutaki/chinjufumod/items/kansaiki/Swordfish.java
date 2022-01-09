package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity2;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity3;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity4;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.google.common.collect.Multimap;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Swordfish extends BaseKansaiki {

	private final float attackDamage = 5.0F - 1.0F;
	private final float attackSpeed = -2.4F;

	public Swordfish(Properties builder) {
		super(builder);
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EquipmentSlotType.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, AttributeModifier.Operation.ADDITION));
		}
		return multimap;
	}

	/* 投げて使用 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.abilities.isCreativeMode;
		
		if (!worldIn.isRemote) {
			
			if (!playerIn.areEyesInFluid(FluidTags.WATER, true)) {
				/** Entity の速度≒飛距離 **/
				int j = 4;

				if (mode) {
					
					/** レベルに応じた Entity発艦 **/
					if (playerIn.experienceLevel < 12) {
						KK_SwordfishEntity kansaiki = new KK_SwordfishEntity(playerIn, worldIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
						worldIn.addEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
						KK_SwordfishEntity2 kansaiki = new KK_SwordfishEntity2(playerIn, worldIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
						worldIn.addEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
						KK_SwordfishEntity3 kansaiki = new KK_SwordfishEntity3(playerIn, worldIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
						worldIn.addEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 25) {
						KK_SwordfishEntity4 kansaiki = new KK_SwordfishEntity4(playerIn, worldIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
						worldIn.addEntity(kansaiki); }

					playerIn.inventory.deleteStack(itemstack); } // World is CreativeMode.
	
				if (!mode) {
					if (itemstack.getDamage() >= (itemstack.getMaxDamage() - 1)) {
						CMEvents.soundKKBreak(worldIn, playerIn);
						itemstack.shrink(1); }
	
					else {
						/** 発艦時に耐久消費 **/
						itemstack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );
	
						/** レベルに応じた Entity発艦 **/
						if (playerIn.experienceLevel < 12) {
							KK_SwordfishEntity kansaiki = new KK_SwordfishEntity(playerIn, worldIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
							worldIn.addEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							KK_SwordfishEntity2 kansaiki = new KK_SwordfishEntity2(playerIn, worldIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
							worldIn.addEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							KK_SwordfishEntity3 kansaiki = new KK_SwordfishEntity3(playerIn, worldIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
							worldIn.addEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 25) {
							KK_SwordfishEntity4 kansaiki = new KK_SwordfishEntity4(playerIn, worldIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
							worldIn.addEntity(kansaiki); }
						
						itemstack.shrink(1); } } // World is not CreativeMode.
			} // Player is not under the Water.
			
			if (playerIn.areEyesInFluid(FluidTags.WATER, true)) { 
				CMEvents.textKKError(worldIn, playerIn); 
			} // Player is under the Water.
		}
		return ActionResult.resultSuccess(itemstack);
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_kk")).applyTextStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.item_kk_swordfish")).applyTextStyle(TextFormatting.DARK_GREEN));
	}

}
