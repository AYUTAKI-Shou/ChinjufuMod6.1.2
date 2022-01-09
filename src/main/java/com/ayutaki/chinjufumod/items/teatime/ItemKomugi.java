package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKomugi extends Item {

	public ItemKomugi(String unlocalizedName) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "item_flour";
		case 2:
			return "item." + "item_butter";
		case 3:
			return "item." + "item_kiji_bun";
		case 4:
			return "item." + "item_kiji_burg";
		case 5:
			return "item." + "item_kiji_scone";
		case 6:
			return "item." + "item_kiji_senbei";
		case 7:
			return "item." + "item_kiji_pizza";
		case 8:
			return "item." + "item_food_pizza_n";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		if (stack.getMetadata() == 3) { tooltip.add(I18n.format("tips.item_kiji_bun")); }
		if (stack.getMetadata() == 4) { tooltip.add(I18n.format("tips.item_kiji_burg")); }
		if (stack.getMetadata() == 5) { tooltip.add(I18n.format("tips.item_kiji_scone")); }
		if (stack.getMetadata() == 6) { tooltip.add(I18n.format("tips.item_kiji_senbei")); }
	}


}
