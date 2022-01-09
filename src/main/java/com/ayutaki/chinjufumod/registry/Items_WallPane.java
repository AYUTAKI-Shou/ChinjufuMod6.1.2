package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.cmblock.Item_BrickC;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_WallPane {

	public static Item RGRA_slabhalf, RDIO_slabhalf, RAND_slabhalf;
	public static Item RGRA_stairs, RDIO_stairs, RAND_stairs;

	public static Item BRICK_C;
	public static Item BGC_slabhalf, BDC_slabhalf, BAC_slabhalf;
	public static Item BGRA_stairs, BDIO_stairs, BAND_stairs;

	public static Item BRICK_STONE_PIL, BRICK_GRA_PIL, BRICK_DIO_PIL, BRICK_AND_PIL;
	public static Item PILLAR_oak, PILLAR_spru, PILLAR_bir, PILLAR_jun, PILLAR_aca, PILLAR_doak;
	public static Item PILLARSLAB_oak, PILLARSLAB_spru, PILLARSLAB_bir, PILLARSLAB_jun, PILLARSLAB_aca, PILLARSLAB_doak;

	public static void init() {

		RGRA_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.RGRA_slabhalf, "block_rgra_slabhalf");
		RDIO_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.RDIO_slabhalf, "block_rdio_slabhalf");
		RAND_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.RAND_slabhalf, "block_rand_slabhalf");
		RGRA_stairs = new ItemBlock_noFuel(WallBrick_Blocks.RGRA_stairs, "block_rockstairs_gra");
		RDIO_stairs = new ItemBlock_noFuel(WallBrick_Blocks.RDIO_stairs, "block_rockstairs_dio");
		RAND_stairs = new ItemBlock_noFuel(WallBrick_Blocks.RAND_stairs, "block_rockstairs_and");

		BRICK_C = new Item_BrickC();
		BGC_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.BGC_slabhalf, "block_bgc_slabhalf");
		BDC_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.BDC_slabhalf, "block_bdc_slabhalf");
		BAC_slabhalf = new ItemBlock_noFuel(WallBrick_Blocks.BAC_slabhalf, "block_bac_slabhalf");
		BGRA_stairs = new ItemBlock_noFuel(WallBrick_Blocks.BGRA_stairs, "block_brickstairs_gra_c");
		BDIO_stairs = new ItemBlock_noFuel(WallBrick_Blocks.BDIO_stairs, "block_brickstairs_dio_c");
		BAND_stairs = new ItemBlock_noFuel(WallBrick_Blocks.BAND_stairs, "block_brickstairs_and_c");

		BRICK_STONE_PIL = new ItemBlock_noFuel(WallBrick_Blocks.BRICK_STONE_PIL, "block_brick_stone_pil_c");
		BRICK_GRA_PIL = new ItemBlock_noFuel(WallBrick_Blocks.BRICK_GRA_PIL, "block_brick_gra_pil_c");
		BRICK_DIO_PIL = new ItemBlock_noFuel(WallBrick_Blocks.BRICK_DIO_PIL, "block_brick_dio_pil_c");
		BRICK_AND_PIL = new ItemBlock_noFuel(WallBrick_Blocks.BRICK_AND_PIL, "block_brick_and_pil_c");

		PILLAR_oak = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_oak, "block_pillar_oak_c");
		PILLAR_spru = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_spru, "block_pillar_spru_c");
		PILLAR_bir = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_bir, "block_pillar_bir_c");
		PILLAR_jun = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_jun, "block_pillar_jun_c");
		PILLAR_aca = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_aca, "block_pillar_aca_c");
		PILLAR_doak = new ItemBlock_Fuel300(WallBrick_Blocks.PILLAR_doak, "block_pillar_doak_c");

		PILLARSLAB_oak = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_oak, "block_kamoi_oak");
		PILLARSLAB_spru = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_spru, "block_kamoi_spruce");
		PILLARSLAB_bir = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_bir, "block_kamoi_birch");
		PILLARSLAB_jun = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_jun, "block_kamoi_jungle");
		PILLARSLAB_aca = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_aca, "block_kamoi_acacia");
		PILLARSLAB_doak = new ItemBlock_Fuel150(WallBrick_Blocks.PILLARSLAB_doak, "block_kamoi_darkoak");

	}

	public static void register() {

		registerItem(RGRA_slabhalf);
		registerItem(RDIO_slabhalf);
		registerItem(RAND_slabhalf);
		registerItem(RGRA_stairs);
		registerItem(RDIO_stairs);
		registerItem(RAND_stairs);

		registerItem(BRICK_C);
		registerItem(BGC_slabhalf);
		registerItem(BDC_slabhalf);
		registerItem(BAC_slabhalf);
		registerItem(BGRA_stairs);
		registerItem(BDIO_stairs);
		registerItem(BAND_stairs);

		registerItem(BRICK_STONE_PIL);
		registerItem(BRICK_GRA_PIL);
		registerItem(BRICK_DIO_PIL);
		registerItem(BRICK_AND_PIL);

		registerItem(PILLAR_oak);
		registerItem(PILLAR_spru);
		registerItem(PILLAR_bir);
		registerItem(PILLAR_jun);
		registerItem(PILLAR_aca);
		registerItem(PILLAR_doak);

		registerItem(PILLARSLAB_oak);
		registerItem(PILLARSLAB_spru);
		registerItem(PILLARSLAB_bir);
		registerItem(PILLARSLAB_jun);
		registerItem(PILLARSLAB_aca);
		registerItem(PILLARSLAB_doak);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(RGRA_slabhalf);
		registerRender(RDIO_slabhalf);
		registerRender(RAND_slabhalf);
		registerRender(RGRA_stairs);
		registerRender(RDIO_stairs);
		registerRender(RAND_stairs);

		registerRenderMeta(BRICK_C, 1, "block_brick_gra_c");
		registerRenderMeta(BRICK_C, 2, "block_brick_dio_c");
		registerRenderMeta(BRICK_C, 3, "block_brick_and_c");
		registerRenderMeta(BRICK_C, 4, "block_brick_gra_ch_c");
		registerRenderMeta(BRICK_C, 5, "block_brick_dio_ch_c");
		registerRenderMeta(BRICK_C, 6, "block_brick_and_ch_c");
		registerRenderMeta(BRICK_C, 7, "block_brick_gra_cr_c");
		registerRenderMeta(BRICK_C, 8, "block_brick_dio_cr_c");
		registerRenderMeta(BRICK_C, 9, "block_brick_and_cr_c");
		registerRenderMeta(BRICK_C, 10, "block_brick_gra_mos_c");
		registerRenderMeta(BRICK_C, 11, "block_brick_dio_mos_c");
		registerRenderMeta(BRICK_C, 12, "block_brick_and_mos_c");

		registerRender(BGC_slabhalf);
		registerRender(BDC_slabhalf);
		registerRender(BAC_slabhalf);
		registerRender(BGRA_stairs);
		registerRender(BDIO_stairs);
		registerRender(BAND_stairs);

		registerRender(BRICK_STONE_PIL);
		registerRender(BRICK_GRA_PIL);
		registerRender(BRICK_DIO_PIL);
		registerRender(BRICK_AND_PIL);

		registerRender(PILLAR_oak);
		registerRender(PILLAR_spru);
		registerRender(PILLAR_bir);
		registerRender(PILLAR_jun);
		registerRender(PILLAR_aca);
		registerRender(PILLAR_doak);

		registerRender(PILLARSLAB_oak);
		registerRender(PILLARSLAB_spru);
		registerRender(PILLARSLAB_bir);
		registerRender(PILLARSLAB_jun);
		registerRender(PILLARSLAB_aca);
		registerRender(PILLARSLAB_doak);

	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
