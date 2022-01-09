package com.ayutaki.chinjufumod.items.food;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemFoodSushi_Shouyu extends ItemFood {

	public ItemFoodSushi_Shouyu(String unlocalizedName, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));

		setCreativeTab(ChinjufuModTabs.TEATIME);
		/** Have sub items. **/
		setHasSubtypes(true);
		setAlwaysEdible();
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_food_sushishouyu_salmon";
		case 2:
			return "item." + "item_food_sushishouyu_fish";
		case 3:
			return "item." + "item_food_sushishouyu_beef";
		case 4:
			return "item." + "item_food_sushishouyu_tamago";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
		}
	}

	/* 食べ終わった時の処理 */
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		int i;
		i = stack.getMetadata();

		/** ポーションエフェクト の追加 **/
		/* 1秒＝20 */
		if (i == 1) { playerIn.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 60, 0)); }

		if (i == 2) { playerIn.addPotionEffect(new PotionEffect(MobEffects.SPEED, 1000, 0)); }

		if (i == 3) { playerIn.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1000, 0)); }

		/* 1秒＝20 玉子焼き調理分加算 */
		if (i == 4) { playerIn.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1200, 0)); }
	}

}