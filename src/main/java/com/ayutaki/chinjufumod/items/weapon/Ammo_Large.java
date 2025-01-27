package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.entity.AbstractAmmo_Entity;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Large;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Ammo_Large extends Item {

	public Ammo_Large(Item.Properties builder) {
		super(builder);
	}

	public AbstractAmmo_Entity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		return new AmmoEntity_Large(worldIn, shooter);
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity playerIn) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY_ARROWS, bow);
		return enchant <= 0 ? false : this.getClass() == Ammo_Large.class;
	}

}
