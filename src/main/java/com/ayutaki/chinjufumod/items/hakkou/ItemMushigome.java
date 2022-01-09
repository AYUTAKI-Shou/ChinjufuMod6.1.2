package com.ayutaki.chinjufumod.items.hakkou;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemMushigome extends Item {

	public ItemMushigome(String unlocalizedName) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setMaxStackSize(64);
		setContainerItem(Items.BOWL);
	}

	/* 素材として使った時に特定のアイテムを返す */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return new ItemStack(Items.BOWL);
	}

}
