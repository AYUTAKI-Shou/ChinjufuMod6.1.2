package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.AmmoAbstract_Entity;
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RensouHou127 extends BowItem {

	public RensouHou127(Item.Properties builder) {
		super(builder);

		this.addPropertyOverride(new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return !(entity.getActiveItemStack().getItem() instanceof RensouHou127) ? 0.0F : (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20.0F;
		} } );

		this.addPropertyOverride(new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F;
		});
	}

	/* Called when the player stops using an Item (stops holding the right mouse button). */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {

		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entityLiving;
			boolean mode = playerIn.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerIn.findAmmo(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !itemstack.isEmpty() || mode);

			if (i < 0) return;

			/** 使用する弾 instanceof も要書替 **/
			if (!itemstack.isEmpty() || mode) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items_Weapon.AMMUNITION_S);
				}

				/** 弾速計算 **/
				float f = getArrowVelocity(i);

				if (!((double)f < 0.1D)) {

					boolean mode1 = playerIn.abilities.isCreativeMode || (itemstack.getItem() instanceof Ammo_Small && ((Ammo_Small)itemstack.getItem()).isInfinite(itemstack, stack, playerIn));

					if (!worldIn.isRemote) {

						Ammo_Small arrowitem = (Ammo_Small)(itemstack.getItem() instanceof Ammo_Small ? itemstack.getItem() : Items_Weapon.AMMUNITION_S);
						AmmoAbstract_Entity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerIn);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, f * 3.0F, 1.0F);

						if (f == 1.0F) { abstractarrowentity.setIsCritical(true); }

						/* ダメージは弓矢と同じ */
						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (playerIn.experienceLevel < 12) {
							if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage()); }
							if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 0.5D); }
							if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 1.0D); }
							if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + 1.0D); }
						}
						
						if (playerIn.experienceLevel >= 25) {
							if (j == 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 1.5D); }
							if (j > 0) { abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double)j * 0.5D + 1.5D); }
						}
						
						/* PUNCH I の効果を乗せる */
						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						if (k == 0) { abstractarrowentity.setKnockbackStrength(1); }
						if (k > 0) { abstractarrowentity.setKnockbackStrength(k + 1); }

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { abstractarrowentity.setFire(100); }

						/* 壊れた時 */
						stack.damageItem(1, playerIn, (user) -> { user.sendBreakAnimation(playerIn.getActiveHand()); } );

						if (mode1 || playerIn.abilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
							abstractarrowentity.pickupStatus = AmmoAbstract_Entity.PickupStatus.CREATIVE_ONLY;
						}
						worldIn.addEntity(abstractarrowentity);
					}

					/* 発射時の効果音を変更 */
					worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM
							.AM_FIRE, SoundCategory.PLAYERS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!mode1 && !playerIn.abilities.isCreativeMode) {
						itemstack.shrink(1);
						if (itemstack.isEmpty()) {
							playerIn.inventory.deleteStack(itemstack);
						}
					}

					/* 薬莢のドロップ、クリエイティブモードに分岐 */
					if (!worldIn.isRemote) {
						if (!playerIn.abilities.isCreativeMode) {
							playerIn.dropItem(new ItemStack(Items_Weapon.CARTRIDGE_S), false);
							worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents_CM
									.AM_CARTRIDGE, SoundCategory.PLAYERS, 0.5F, 1.4F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
						}
						else if (playerIn.abilities.isCreativeMode) { }
					}

					playerIn.addStat(Stats.ITEM_USED.get(this));
				}
			}
		}
	}


	/* 引き絞り程度に対する弾速計算
	public static float getArrowVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) { f = 1.0F; }
		return f;
	} */

	/* 引き絞り程度に対する弾速計算 */
	public static float getArrowVelocity(int charge) {
		return 1.0F;
	}

	/* 引き絞り継続時間 */
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	/* 使用中のアクション */
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	/* Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see {@link #onItemUse}. */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
		if (ret != null) return ret;

		if (!playerIn.abilities.isCreativeMode && !flag) {
			return ActionResult.resultFail(itemstack);
		}
		else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(itemstack);
		}
	}

	/* 使用する弾 */
	public static final Predicate<ItemStack> AMMOS = (itemstack) -> {
		return itemstack.getItem() == Items_Weapon.AMMUNITION_S;
	};

	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return AMMOS;
	}

	public AmmoAbstract_Entity customeArrow(AmmoAbstract_Entity arrow) {
		return arrow;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items.IRON_INGOT;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_rensouhou_small")).applyTextStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.item_rensouhou127")).applyTextStyle(TextFormatting.DARK_GREEN));
	}

}
