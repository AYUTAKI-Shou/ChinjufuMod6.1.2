package com.ayutaki.chinjufumod.items.weapon;

import com.ayutaki.chinjufumod.entity.Entity_AmmoKC;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmmunition_KC extends Item {

	public ItemAmmunition_KC() {
		super();
	}

	public Entity_AmmoKC createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) {
		Entity_AmmoKC entitytippedarrow = new Entity_AmmoKC(worldIn, shooter);
		return entitytippedarrow;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer playerIn) {
		int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
		return enchant <= 0 ? false : this.getClass() == ItemAmmunition_KC.class;
	}

}
