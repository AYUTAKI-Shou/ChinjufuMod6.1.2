package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.entity.Entity_AmmoSmall;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmmunition_Small extends Item {

	public ItemAmmunition_Small() {
		super();
	}

	public Entity_AmmoSmall createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		Entity_AmmoSmall entitytippedarrow = new Entity_AmmoSmall(worldIn, shooter);
		return entitytippedarrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer playerIn) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == ItemAmmunition_Small.class;
	}

}
/*
ItemArrow から、Entityの呼び出し
Enityは、EntityArrrowを書き換えたBaseを拡張
連装砲で、ItemとEntityを呼び出し
 */