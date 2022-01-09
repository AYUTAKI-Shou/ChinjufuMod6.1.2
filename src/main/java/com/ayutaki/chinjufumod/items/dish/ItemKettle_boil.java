package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemKettle_boil extends ItemBlockBace {

	public ItemKettle_boil() {
		super(Dish_Blocks.KETTLE_full);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setUnlocalizedName("item_kettle_boil");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "item_kettle_boil"));

		/*クラフトで使うと、空のやかんが返ってくる*/
		setMaxStackSize(1);
		setContainerItem(Items_Teatime.Item_YAKAN_kara);
	}

	/* 素材として使った時に特定のアイテムを返す */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return new ItemStack(Items_Teatime.Item_YAKAN_kara);
	}

}
