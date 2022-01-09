package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity2;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity3;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity4;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import com.google.common.collect.Multimap;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Gyorai61cm extends Item {

	private final float attackDamage = 11.0F - 1.0F;
	private final float attackSpeed = -2.4F;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	public Gyorai61cm(Item.Properties properties) {
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
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlotType p_111205_1_) {
		return p_111205_1_ == EquipmentSlotType.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(p_111205_1_);
	}

	/* 手に持って使用 */
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	@Override
	public boolean canAttackBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		return !playerIn.isCreative();
	}

	@Override
	public boolean mineBlock(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity attacker) {
		stack.shrink(1);
		return true;
	}

	/* 投げて使用 */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand hand) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		boolean mode = playerIn.abilities.instabuild;
		
		int j = 8;

		worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.GYORAI, SoundCategory.MASTER, 1.0F, 1.0F);
		
		if (!worldIn.isClientSide) {
			
			/** レベルに応じた Entity発艦 **/
			if (playerIn.experienceLevel < 12) {
				Gyorai61cmEntity kansaiki = new Gyorai61cmEntity(playerIn, worldIn, itemstack);
				kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
				worldIn.addFreshEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
				Gyorai61cmEntity2 kansaiki = new Gyorai61cmEntity2(playerIn, worldIn, itemstack);
				kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
				worldIn.addFreshEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
				Gyorai61cmEntity3 kansaiki = new Gyorai61cmEntity3(playerIn, worldIn, itemstack);
				kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
				worldIn.addFreshEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 25) {
				Gyorai61cmEntity4 kansaiki = new Gyorai61cmEntity4(playerIn, worldIn, itemstack);
				kansaiki.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 0.25F * j, 1.0F);
				worldIn.addFreshEntity(kansaiki); }
		}

		playerIn.awardStat(Stats.ITEM_USED.get(this));

		if (!mode) { itemstack.shrink(1); }

		return ActionResult.sidedSuccess(itemstack, worldIn.isClientSide());
	}

	/* Return the enchantability factor of the item, most of the time is based on material. */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_gyorai")).withStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.item_gyorai2")).withStyle(TextFormatting.DARK_GREEN));
	}

}
