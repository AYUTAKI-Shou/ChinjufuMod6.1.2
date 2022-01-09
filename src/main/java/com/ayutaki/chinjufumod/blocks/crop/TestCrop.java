package com.ayutaki.chinjufumod.blocks.crop;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class TestCrop extends BlockCrops {

	public TestCrop(String unlocalizedName) {
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));

		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_CABBAGE;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.FOOD_CABBAGE;
	}

}
