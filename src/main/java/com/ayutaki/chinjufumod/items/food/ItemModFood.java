package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {

	private PotionEffect[] effects;

	public ItemModFood(String unlocalizedName, int amount, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, isWolfFood);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		this.effects = potionEffects;

		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	public ItemModFood(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect...potionEffects) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		this.effects = potionEffects;

		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		for (PotionEffect effect : effects) {
			playerIn.addPotionEffect(new PotionEffect(effect));
		}
	}

}
