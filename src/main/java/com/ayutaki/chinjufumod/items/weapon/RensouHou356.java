package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RensouHou356 extends BowItem {

	public RensouHou356(Item.Properties builder) {
		super(builder);
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	@Override
	public void releaseUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {

		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
			ItemStack itemstack = playerIn.getProjectile(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !itemstack.isEmpty() || mode);

			if (i < 0) return;

			/** 使用する弾 instanceof も要書替 **/
			if (!itemstack.isEmpty() || mode) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items_Weapon.AMMUNITION_L);
				}

				/** 弾速計算 **/
				float f = getPowerForTime(i);

				if (!((double)f < 0.1D)) {

					boolean mode1 = playerIn.abilities.instabuild || (itemstack.getItem() instanceof Ammo_Small && ((Ammo_Large)itemstack.getItem()).isInfinite(itemstack, stack, playerIn));

					if (!worldIn.isClientSide) {

						Ammo_Large arrowitem = (Ammo_Large)(itemstack.getItem() instanceof Ammo_Small ? itemstack.getItem() : Items_Weapon.AMMUNITION_L);
						AbstractAmmo_Entity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerIn);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, f * 4.0F, 1.0F);

						if (f == 1.0F) { abstractarrowentity.setCritArrow(true); }

						/* 基本値にレベルに応じて加算 標準で POWER (15.0-2.0)÷2 */
						int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
						if (playerIn.experienceLevel < 12) {
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + (double)j * 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + 0.5D); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + (double)j * 0.5D + 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + 1.0D); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + (double)j * 0.5D + 1.0D); }
						}
						
						if (playerIn.experienceLevel >= 25) {
							if (j == 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + 1.5D); }
							if (j > 0) { abstractarrowentity.setBaseDamage(abstractarrowentity.getBaseDamage() + 6.5D + (double)j * 0.5D + 1.5D); }
						}

						/* PUNCH I の効果を乗せる */
						int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack);
						if (k == 0) { abstractarrowentity.setKnockback(1); }
						if (k > 0) { abstractarrowentity.setKnockback(k + 1); }

						if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) { abstractarrowentity.setSecondsOnFire(100); }

						/* 壊れた時 */
						stack.hurtAndBreak(1, playerIn, (user) -> { user.broadcastBreakEvent(playerIn.getUsedItemHand()); } );

						if (mode1 || playerIn.abilities.instabuild && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
							 abstractarrowentity.pickup = AbstractAmmo_Entity.PickupStatus.CREATIVE_ONLY;
						}
						worldIn.addFreshEntity(abstractarrowentity);
					}

					/* 発射時のPlay Soundを変更 */
					worldIn.playSound((PlayerEntity)null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_FIRE, SoundCategory.PLAYERS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!mode1 && !playerIn.abilities.instabuild) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							playerIn.inventory.removeItem(itemstack);
						}
					}

					/* 薬莢のドロップ、クリエイティブモードに分岐 */
					if (!worldIn.isClientSide) {
						if (!playerIn.abilities.instabuild) {
							playerIn.drop(new ItemStack(Items_Weapon.CARTRIDGE_L), false);
							worldIn.playSound(null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents_CM.AM_CARTRIDGE, SoundCategory.PLAYERS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
						}
						else if (playerIn.abilities.instabuild) { }
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}


	/* 引き絞り程度に対する弾速計算 */
	public static float getPowerForTime(int charge) {
		return 1.0F;
	}

	/* 引き絞り継続時間 */
	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	/* 使用中のアクション */
	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {

		ItemStack itemstack = playerIn.getItemInHand(handIn);
		boolean flag = !playerIn.getProjectile(itemstack).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.abilities.instabuild && !flag) {
			return ActionResult.fail(itemstack);
		}
		else {
			playerIn.startUsingItem(handIn);
			return ActionResult.consume(itemstack);
		}
	}

	/* 使用する弾 */
	public static final Predicate<ItemStack> AMMOL = (itemstack) -> {
		return itemstack.getItem() == Items_Weapon.AMMUNITION_L;
	};

	@Override
	public Predicate<ItemStack> getAllSupportedProjectiles() {
		return AMMOL;
	}

	public AbstractAmmo_Entity customeArrow(AbstractAmmo_Entity arrow) {
		return arrow;
	}

	@Override
	public int getDefaultProjectileRange() {
		return 20;
	}

	/* Items needed for repair. */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_rensouhou_large")).withStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.item_rensouhou356")).withStyle(TextFormatting.DARK_GREEN));
	}

}
