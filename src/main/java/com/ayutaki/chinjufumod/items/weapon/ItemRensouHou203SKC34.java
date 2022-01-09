package com.ayutaki.chinjufumod.items.weapon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.Entity_AmmoMedium;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemRensouHou203SKC34 extends ItemBow {

	public ItemRensouHou203SKC34() {
		this.maxStackSize = 1;
		setMaxDamage(2000);

		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter() {

			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

				if (entityIn == null) {
					return 0.0F;
				}
				else {
					return entityIn.getActiveItemStack().getItem() != Items_Weapon.RENSOUHOU_SKC ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
				}
			}
		});

		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter() {

			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
			}
		});
	}

	protected ItemStack findAmmo(EntityPlayer playerIn) {

		if (this.isArrow(playerIn.getHeldItem(EnumHand.OFF_HAND))) {
			return playerIn.getHeldItem(EnumHand.OFF_HAND);
		}

		else if (this.isArrow(playerIn.getHeldItem(EnumHand.MAIN_HAND))) {
			return playerIn.getHeldItem(EnumHand.MAIN_HAND);
		}
		else {

			for (int i = 0; i < playerIn.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = playerIn.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack)) {
					return itemstack;
				}
			}
			return ItemStack.EMPTY;
		}
	}

	/* 弾に使うアイテムの新スタンス指定 */
	protected boolean isArrow(ItemStack stack) {
		return stack.getItem() instanceof ItemAmmunition_Medium;
	}

	/**
	 * Called when the playerIn stops using an Item (stops holding the right mouse button).
	 */
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {

		if (entityLiving instanceof EntityPlayer) {

			EntityPlayer playerIn = (EntityPlayer)entityLiving;
			boolean mode = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = this.findAmmo(playerIn);

			int i = this.getMaxItemUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerIn, i, !itemstack.isEmpty() || mode);
			if (i < 0) return;

			if (!itemstack.isEmpty() || mode) {

				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(Items_Weapon.AMMUNITION_MEDIUM);
				}

				float f = getArrowVelocity(i);

				if ((double)f >= 0.1D) {

					boolean flag1 = playerIn.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemAmmunition_Medium && ((ItemAmmunition_Medium) itemstack.getItem()).isInfinite(itemstack, stack, playerIn));

					if (!worldIn.isRemote) {

						/* 弾のインスタンス、発射するエンティティ */
						ItemAmmunition_Medium itemarrow = (ItemAmmunition_Medium)(itemstack.getItem() instanceof ItemAmmunition_Medium ? itemstack.getItem() : Items_Weapon.AMMUNITION_MEDIUM);
						Entity_AmmoMedium entityarrow = (Entity_AmmoMedium) itemarrow.createArrow(worldIn, itemstack, playerIn);

						/* 弾道計算 */
						entityarrow.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, f * 3.5F, 1.0F);

						if (f == 1.0F) { entityarrow.setIsCritical(true); }

						/* 基本値にレベルに応じて加算 */
						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (playerIn.experienceLevel < 12) {
							if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D); }
							if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + (double)j * 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + 0.5D); }
							if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + (double)j * 0.5D + 0.5D); }
						}
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + 1.0D); }
							if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + (double)j * 0.5D + 1.0D); }
						}
						
						if (playerIn.experienceLevel >= 25) {
							if (j == 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + 1.5D); }
							if (j > 0) { entityarrow.setDamage(entityarrow.getDamage() + 4.0D + (double)j * 0.5D + 1.5D); }
						}
						
						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						/* PUNCH I の効果を乗せる */
						if (k == 0) { entityarrow.setKnockbackStrength(1); }
						if (k > 0) { entityarrow.setKnockbackStrength(k + 1); }

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) { entityarrow.setFire(100); }

						stack.damageItem(1, playerIn);

						if (flag1 || playerIn.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW)) {
							entityarrow.pickupStatus = Entity_AmmoMedium.PickupStatus.CREATIVE_ONLY;
						}

						worldIn.spawnEntity(entityarrow);
					}

					/* 発射時の効果音を変更 */
					worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ,
							SoundEvents_CM.AM_FIRE, SoundCategory.MASTER, 1.0F, 1.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

					if (!flag1 && !playerIn.capabilities.isCreativeMode) {
						itemstack.shrink(1);

						if (itemstack.isEmpty()) {
							playerIn.inventory.deleteStack(itemstack);
						}
					}

					/* 薬莢のドロップ、クリエイティブモードに分岐 */
					if (!worldIn.isRemote) {
						if (!creativeUse(playerIn)) {
							playerIn.dropItem(new ItemStack(Items_Weapon.CARTRIDGE_MEDIUM), false);
							worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ,
									SoundEvents_CM.AM_CARTRIDGE, SoundCategory.MASTER, 1.0F, 1.2F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
						}
						else if (creativeUse(playerIn)) {

						}
					}
					playerIn.addStat(StatList.getObjectUseStats(this));
				}
			}
		}
	}

	/* 引き絞りに寄って矢に与える速度 */
	public static float getArrowVelocity(int charge) {
		return 1.0F;
	}

	/* クリエイティブモードで薬莢を出さないための設定 */
	public boolean creativeUse(Entity e) {
		return (e instanceof EntityPlayer && ((EntityPlayer) e).capabilities.isCreativeMode) || !(e instanceof EntityPlayer);
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_rensouhou_medium", meta));
		tooltip.add(TextFormatting.DARK_GREEN + I18n.format("tips.item_rensouhou203_skc34", meta));
	}
}
