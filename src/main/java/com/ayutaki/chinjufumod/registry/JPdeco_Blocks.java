package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooButton;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooCube;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooFence;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooPressurePlate;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooSlab;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooStairs;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooTrapDoor;
import com.ayutaki.chinjufumod.blocks.chair.WaraZabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Bot;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Small;
import com.ayutaki.chinjufumod.blocks.gakki.Wadaiko_Top;
import com.ayutaki.chinjufumod.blocks.garden.Sudare;
import com.ayutaki.chinjufumod.blocks.noren.Noren_black;
import com.ayutaki.chinjufumod.blocks.noren.Noren_blue;
import com.ayutaki.chinjufumod.blocks.noren.Noren_brown;
import com.ayutaki.chinjufumod.blocks.noren.Noren_cyan;
import com.ayutaki.chinjufumod.blocks.noren.Noren_gray;
import com.ayutaki.chinjufumod.blocks.noren.Noren_green;
import com.ayutaki.chinjufumod.blocks.noren.Noren_lightb;
import com.ayutaki.chinjufumod.blocks.noren.Noren_lightg;
import com.ayutaki.chinjufumod.blocks.noren.Noren_lime;
import com.ayutaki.chinjufumod.blocks.noren.Noren_magenta;
import com.ayutaki.chinjufumod.blocks.noren.Noren_orange;
import com.ayutaki.chinjufumod.blocks.noren.Noren_pink;
import com.ayutaki.chinjufumod.blocks.noren.Noren_purple;
import com.ayutaki.chinjufumod.blocks.noren.Noren_red;
import com.ayutaki.chinjufumod.blocks.noren.Noren_white;
import com.ayutaki.chinjufumod.blocks.noren.Noren_yellow;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_aca;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_bir;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_doak;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_jun;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_oak;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_spru;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_aca;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_bir;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_doak;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_jun;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_oak;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_spru;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_aca;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_bir;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_doak;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_jun;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_oak;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_spru;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_aca;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_bir;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_doak;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_jun;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_oak;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_spru;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_aca;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_bir;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_doak;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_jun;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_oak;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_spru;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_aca;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_bir;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_doak;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_jun;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_oak;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_spru;
import com.ayutaki.chinjufumod.blocks.tatami.Tatami_H;
import com.ayutaki.chinjufumod.blocks.tatami.Tatami_HY;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class JPDeco_Blocks {

	public static Block RANMA_oak, RANMA_spru, RANMA_bir, RANMA_jun, RANMA_aca, RANMA_doak;
	public static Block RANMAB_oak, RANMAB_spru, RANMAB_bir, RANMAB_jun, RANMAB_aca, RANMAB_doak;
	public static Block RANMAC_oak, RANMAC_spru, RANMAC_bir, RANMAC_jun, RANMAC_aca, RANMAC_doak;
	public static Block KANKI_oak, KANKI_spru, KANKI_bir, KANKI_jun, KANKI_aca, KANKI_doak;
	public static Block KOUSHI_oak, KOUSHI_spru, KOUSHI_bir, KOUSHI_jun, KOUSHI_aca, KOUSHI_doak;
	public static Block KOUSHIB_oak, KOUSHIB_spru, KOUSHIB_bir, KOUSHIB_jun, KOUSHIB_aca, KOUSHIB_doak;

	public static Block SUDARE;

	public static Block NOREN_white, NOREN_orange, NOREN_magenta, NOREN_lightb,
								NOREN_yellow, NOREN_lime, NOREN_pink, NOREN_gray,
								NOREN_lightg, NOREN_cyan, NOREN_purple, NOREN_blue,
								NOREN_brown, NOREN_green, NOREN_red, NOREN_black;

	public static Block ZABUTON, WARAZABUTON;

	public static Block ZAISU_white, ZAISU_orange, ZAISU_magenta, ZAISU_lightb,
								ZAISU_yellow, ZAISU_lime, ZAISU_pink, ZAISU_gray,
								ZAISU_lightg, ZAISU_cyan, ZAISU_purple, ZAISU_blue,
								ZAISU_brown, ZAISU_green, ZAISU_red, ZAISU_black;

	public static Tatami_H TATAMI_H, TATAMI_H_white, TATAMI_H_orange, TATAMI_H_magenta, TATAMI_H_lightb,
								TATAMI_H_yellow, TATAMI_H_lime, TATAMI_H_pink, TATAMI_H_gray,
								TATAMI_H_lightg, TATAMI_H_cyan, TATAMI_H_purple, TATAMI_H_blue,
								TATAMI_H_brown, TATAMI_H_green, TATAMI_H_red, TATAMI_H_black;

	public static Tatami_HY TATAMI_HY, TATAMI_HY_white, TATAMI_HY_orange, TATAMI_HY_magenta, TATAMI_HY_lightb,
								TATAMI_HY_yellow, TATAMI_HY_lime, TATAMI_HY_pink, TATAMI_HY_gray,
								TATAMI_HY_lightg, TATAMI_HY_cyan, TATAMI_HY_purple, TATAMI_HY_blue,
								TATAMI_HY_brown, TATAMI_HY_green, TATAMI_HY_red, TATAMI_HY_black;

	public static Block TAKECUBE, TAKECUBE_Y, TAKECUBE_K, TAKE_ST, TAKE_STY, TAKE_STK;
	public static BambooSlab TAKE_SH, TAKE_SHY, TAKE_SHK;
	public static Block TAKEFENCE, TAKEFENCE_Y, TAKEFENCE_K;
	public static Block TAKE_TRAPDOOR, TAKE_TRAPDOOR_Y, TAKE_TRAPDOOR_K;
	public static Block TAKE_PLATE, TAKE_PLATE_Y, TAKE_PLATE_K;
	public static Block TAKE_BUTTON, TAKE_BUTTON_Y, TAKE_BUTTON_K;

	public static Block WADAIKO_TOP, WADAIKO_BOT, WADAIKO_small;


	public static void init() {

		RANMA_oak = new Ranma_oak(Material.WOOD, "block_ranma_oak");
		RANMA_spru = new Ranma_spru(Material.WOOD, "block_ranma_spru");
		RANMA_bir = new Ranma_bir(Material.WOOD, "block_ranma_bir");
		RANMA_jun = new Ranma_jun(Material.WOOD, "block_ranma_jun");
		RANMA_aca = new Ranma_aca(Material.WOOD, "block_ranma_aca");
		RANMA_doak = new Ranma_doak(Material.WOOD, "block_ranma_doak");

		RANMAB_oak = new RanmaB_oak(Material.WOOD, "block_ranmab_oak");
		RANMAB_spru = new RanmaB_spru(Material.WOOD, "block_ranmab_spru");
		RANMAB_bir = new RanmaB_bir(Material.WOOD, "block_ranmab_bir");
		RANMAB_jun = new RanmaB_jun(Material.WOOD, "block_ranmab_jun");
		RANMAB_aca = new RanmaB_aca(Material.WOOD, "block_ranmab_aca");
		RANMAB_doak = new RanmaB_doak(Material.WOOD, "block_ranmab_doak");

		RANMAC_oak = new RanmaC_oak(Material.WOOD, "block_ranmac_oak");
		RANMAC_spru = new RanmaC_spru(Material.WOOD, "block_ranmac_spru");
		RANMAC_bir = new RanmaC_bir(Material.WOOD, "block_ranmac_bir");
		RANMAC_jun = new RanmaC_jun(Material.WOOD, "block_ranmac_jun");
		RANMAC_aca = new RanmaC_aca(Material.WOOD, "block_ranmac_aca");
		RANMAC_doak = new RanmaC_doak(Material.WOOD, "block_ranmac_doak");

		KANKI_oak = new Kanki_oak(Material.WOOD, "block_kanki_oak");
		KANKI_spru = new Kanki_spru(Material.WOOD, "block_kanki_spru");
		KANKI_bir = new Kanki_bir(Material.WOOD, "block_kanki_bir");
		KANKI_jun = new Kanki_jun(Material.WOOD, "block_kanki_jun");
		KANKI_aca = new Kanki_aca(Material.WOOD, "block_kanki_aca");
		KANKI_doak = new Kanki_doak(Material.WOOD, "block_kanki_doak");

		KOUSHI_oak = new Koushi_oak(Material.WOOD, "block_koushi_oak");
		KOUSHI_spru = new Koushi_spru(Material.WOOD, "block_koushi_spru");
		KOUSHI_bir = new Koushi_bir(Material.WOOD, "block_koushi_bir");
		KOUSHI_jun = new Koushi_jun(Material.WOOD, "block_koushi_jun");
		KOUSHI_aca = new Koushi_aca(Material.WOOD, "block_koushi_aca");
		KOUSHI_doak = new Koushi_doak(Material.WOOD, "block_koushi_doak");

		KOUSHIB_oak = new KoushiB_oak(Material.WOOD, "block_koushib_oak");
		KOUSHIB_spru = new KoushiB_spru(Material.WOOD, "block_koushib_spru");
		KOUSHIB_bir = new KoushiB_bir(Material.WOOD, "block_koushib_bir");
		KOUSHIB_jun = new KoushiB_jun(Material.WOOD, "block_koushib_jun");
		KOUSHIB_aca = new KoushiB_aca(Material.WOOD, "block_koushib_aca");
		KOUSHIB_doak = new KoushiB_doak(Material.WOOD, "block_koushib_doak");

		SUDARE = new Sudare().setRegistryName("block_sudare_1").setUnlocalizedName("block_sudare_1");

		NOREN_white = new Noren_white(Material.WOOD, "block_noren_white");
		NOREN_orange = new Noren_orange(Material.WOOD, "block_noren_orange");
		NOREN_magenta = new Noren_magenta(Material.WOOD, "block_noren_magenta");
		NOREN_lightb = new Noren_lightb(Material.WOOD, "block_noren_lightb");
		NOREN_yellow = new Noren_yellow(Material.WOOD, "block_noren_yellow");
		NOREN_lime = new Noren_lime(Material.WOOD, "block_noren_lime");
		NOREN_pink = new Noren_pink(Material.WOOD, "block_noren_pink");
		NOREN_gray = new Noren_gray(Material.WOOD, "block_noren_gray");
		NOREN_lightg = new Noren_lightg(Material.WOOD, "block_noren_lightg");
		NOREN_cyan = new Noren_cyan(Material.WOOD, "block_noren_cyan");
		NOREN_purple = new Noren_purple(Material.WOOD, "block_noren_purple");
		NOREN_blue = new Noren_blue(Material.WOOD, "block_noren_blue");
		NOREN_brown = new Noren_brown(Material.WOOD, "block_noren_brown");
		NOREN_green = new Noren_green(Material.WOOD, "block_noren_green");
		NOREN_red = new Noren_red(Material.WOOD, "block_noren_red");
		NOREN_black = new Noren_black(Material.WOOD, "block_noren_black");

		ZABUTON = new Zabuton();
		WARAZABUTON = new WaraZabuton();

		ZAISU_white = new Zaisu().setRegistryName("block_zaisu_white").setUnlocalizedName("block_zaisu_white");
		ZAISU_orange = new Zaisu().setRegistryName("block_zaisu_orange").setUnlocalizedName("block_zaisu_orange");
		ZAISU_magenta = new Zaisu().setRegistryName("block_zaisu_magenta").setUnlocalizedName("block_zaisu_magenta");
		ZAISU_lightb = new Zaisu().setRegistryName("block_zaisu_lightb").setUnlocalizedName("block_zaisu_lightb");
		ZAISU_yellow = new Zaisu().setRegistryName("block_zaisu_yellow").setUnlocalizedName("block_zaisu_yellow");
		ZAISU_lime = new Zaisu().setRegistryName("block_zaisu_lime").setUnlocalizedName("block_zaisu_lime");
		ZAISU_pink = new Zaisu().setRegistryName("block_zaisu_pink").setUnlocalizedName("block_zaisu_pink");
		ZAISU_gray = new Zaisu().setRegistryName("block_zaisu_gray").setUnlocalizedName("block_zaisu_gray");
		ZAISU_lightg = new Zaisu().setRegistryName("block_zaisu_lightg").setUnlocalizedName("block_zaisu_lightg");
		ZAISU_cyan = new Zaisu().setRegistryName("block_zaisu_cyan").setUnlocalizedName("block_zaisu_cyan");
		ZAISU_purple = new Zaisu().setRegistryName("block_zaisu_purple").setUnlocalizedName("block_zaisu_purple");
		ZAISU_blue = new Zaisu().setRegistryName("block_zaisu_blue").setUnlocalizedName("block_zaisu_blue");
		ZAISU_brown = new Zaisu().setRegistryName("block_zaisu_brown").setUnlocalizedName("block_zaisu_brown");
		ZAISU_green = new Zaisu().setRegistryName("block_zaisu_green").setUnlocalizedName("block_zaisu_green");
		ZAISU_red = new Zaisu().setRegistryName("block_zaisu_red").setUnlocalizedName("block_zaisu_red");
		ZAISU_black = new Zaisu().setRegistryName("block_zaisu_black").setUnlocalizedName("block_zaisu_black");

		TATAMI_H = new Tatami_H("block_tatamih");
		TATAMI_H_white = new Tatami_H("block_tatamih_white");
		TATAMI_H_orange = new Tatami_H("block_tatamih_orange");
		TATAMI_H_magenta = new Tatami_H("block_tatamih_magenta");
		TATAMI_H_lightb = new Tatami_H("block_tatamih_lightb");
		TATAMI_H_yellow = new Tatami_H("block_tatamih_yellow");
		TATAMI_H_lime = new Tatami_H("block_tatamih_lime");
		TATAMI_H_pink = new Tatami_H("block_tatamih_pink");
		TATAMI_H_gray = new Tatami_H("block_tatamih_gray");
		TATAMI_H_lightg = new Tatami_H("block_tatamih_lightg");
		TATAMI_H_cyan = new Tatami_H("block_tatamih_cyan");
		TATAMI_H_purple = new Tatami_H("block_tatamih_purple");
		TATAMI_H_blue = new Tatami_H("block_tatamih_blue");
		TATAMI_H_brown = new Tatami_H("block_tatamih_brown");
		TATAMI_H_green = new Tatami_H("block_tatamih_green");
		TATAMI_H_red = new Tatami_H("block_tatamih_red");
		TATAMI_H_black = new Tatami_H("block_tatamih_black");

		TATAMI_HY = new Tatami_HY("block_tatamih_y");
		TATAMI_HY_white = new Tatami_HY("block_tatamih_y_white");
		TATAMI_HY_orange = new Tatami_HY("block_tatamih_y_orange");
		TATAMI_HY_magenta = new Tatami_HY("block_tatamih_y_magenta");
		TATAMI_HY_lightb = new Tatami_HY("block_tatamih_y_lightb");
		TATAMI_HY_yellow = new Tatami_HY("block_tatamih_y_yellow");
		TATAMI_HY_lime = new Tatami_HY("block_tatamih_y_lime");
		TATAMI_HY_pink = new Tatami_HY("block_tatamih_y_pink");
		TATAMI_HY_gray = new Tatami_HY("block_tatamih_y_gray");
		TATAMI_HY_lightg = new Tatami_HY("block_tatamih_y_lightg");
		TATAMI_HY_cyan = new Tatami_HY("block_tatamih_y_cyan");
		TATAMI_HY_purple = new Tatami_HY("block_tatamih_y_purple");
		TATAMI_HY_blue = new Tatami_HY("block_tatamih_y_blue");
		TATAMI_HY_brown = new Tatami_HY("block_tatamih_y_brown");
		TATAMI_HY_green = new Tatami_HY("block_tatamih_y_green");
		TATAMI_HY_red = new Tatami_HY("block_tatamih_y_red");
		TATAMI_HY_black = new Tatami_HY("block_tatamih_y_black");

		TAKECUBE = new BambooCube().setRegistryName("block_bamboo_cube").setUnlocalizedName("block_bamboo_cube");
		TAKECUBE_Y = new BambooCube().setRegistryName("block_bamboo_y_cube").setUnlocalizedName("block_bamboo_y_cube");
		TAKECUBE_K = new BambooCube().setRegistryName("block_bamboo_k_cube").setUnlocalizedName("block_bamboo_k_cube");
		TAKE_ST = new BambooStairs("block_bamboo_stairs");
		TAKE_STY = new BambooStairs("block_bamboo_y_stairs");
		TAKE_STK = new BambooStairs("block_bamboo_k_stairs");
		TAKE_SH = new BambooSlab("block_bamboo_slab");
		TAKE_SHY = new BambooSlab("block_bamboo_y_slab");
		TAKE_SHK = new BambooSlab("block_bamboo_k_slab");

		TAKEFENCE = new BambooFence().setRegistryName("block_bamboo_fence").setUnlocalizedName("block_bamboo_fence");
		TAKEFENCE_Y = new BambooFence().setRegistryName("block_bamboo_y_fence").setUnlocalizedName("block_bamboo_y_fence");
		TAKEFENCE_K = new BambooFence().setRegistryName("block_bamboo_k_fence").setUnlocalizedName("block_bamboo_k_fence");

		TAKE_TRAPDOOR = new BambooTrapDoor().setRegistryName("block_bamboo_trapdoor").setUnlocalizedName("block_bamboo_trapdoor");
		TAKE_TRAPDOOR_Y = new BambooTrapDoor().setRegistryName("block_bamboo_y_trapdoor").setUnlocalizedName("block_bamboo_y_trapdoor");
		TAKE_TRAPDOOR_K = new BambooTrapDoor().setRegistryName("block_bamboo_k_trapdoor").setUnlocalizedName("block_bamboo_k_trapdoor");
		TAKE_PLATE = new BambooPressurePlate().setRegistryName("block_bamboo_plate").setUnlocalizedName("block_bamboo_plate");
		TAKE_PLATE_Y = new BambooPressurePlate().setRegistryName("block_bamboo_y_plate").setUnlocalizedName("block_bamboo_y_plate");
		TAKE_PLATE_K = new BambooPressurePlate().setRegistryName("block_bamboo_k_plate").setUnlocalizedName("block_bamboo_k_plate");
		TAKE_BUTTON = new BambooButton().setRegistryName("block_bamboo_button").setUnlocalizedName("block_bamboo_button");
		TAKE_BUTTON_Y = new BambooButton().setRegistryName("block_bamboo_y_button").setUnlocalizedName("block_bamboo_y_button");
		TAKE_BUTTON_K = new BambooButton().setRegistryName("block_bamboo_k_button").setUnlocalizedName("block_bamboo_k_button");

		WADAIKO_TOP = new Wadaiko_Top();
		WADAIKO_BOT = new Wadaiko_Bot();
		WADAIKO_small = new Wadaiko_Small();

	}


	public static void register() {

		registerBlock(RANMA_oak);
		registerBlock(RANMA_spru);
		registerBlock(RANMA_bir);
		registerBlock(RANMA_jun);
		registerBlock(RANMA_aca);
		registerBlock(RANMA_doak);

		registerBlock(RANMAB_oak);
		registerBlock(RANMAB_spru);
		registerBlock(RANMAB_bir);
		registerBlock(RANMAB_jun);
		registerBlock(RANMAB_aca);
		registerBlock(RANMAB_doak);

		registerBlock(RANMAC_oak);
		registerBlock(RANMAC_spru);
		registerBlock(RANMAC_bir);
		registerBlock(RANMAC_jun);
		registerBlock(RANMAC_aca);
		registerBlock(RANMAC_doak);

		registerBlock(KANKI_oak);
		registerBlock(KANKI_spru);
		registerBlock(KANKI_bir);
		registerBlock(KANKI_jun);
		registerBlock(KANKI_aca);
		registerBlock(KANKI_doak);

		registerBlock(KOUSHI_oak);
		registerBlock(KOUSHI_spru);
		registerBlock(KOUSHI_bir);
		registerBlock(KOUSHI_jun);
		registerBlock(KOUSHI_aca);
		registerBlock(KOUSHI_doak);

		registerBlock(KOUSHIB_oak);
		registerBlock(KOUSHIB_spru);
		registerBlock(KOUSHIB_bir);
		registerBlock(KOUSHIB_jun);
		registerBlock(KOUSHIB_aca);
		registerBlock(KOUSHIB_doak);

		registerBlock(SUDARE);

		registerBlock(NOREN_white);
		registerBlock(NOREN_orange);
		registerBlock(NOREN_magenta);
		registerBlock(NOREN_lightb);
		registerBlock(NOREN_yellow);
		registerBlock(NOREN_lime);
		registerBlock(NOREN_pink);
		registerBlock(NOREN_gray);
		registerBlock(NOREN_lightg);
		registerBlock(NOREN_cyan);
		registerBlock(NOREN_purple);
		registerBlock(NOREN_blue);
		registerBlock(NOREN_brown);
		registerBlock(NOREN_green);
		registerBlock(NOREN_red);
		registerBlock(NOREN_black);

		registerBlock(ZABUTON);
		registerBlock(WARAZABUTON);

		registerBlock(ZAISU_white);
		registerBlock(ZAISU_orange);
		registerBlock(ZAISU_magenta);
		registerBlock(ZAISU_lightb);
		registerBlock(ZAISU_yellow);
		registerBlock(ZAISU_lime);
		registerBlock(ZAISU_pink);
		registerBlock(ZAISU_gray);
		registerBlock(ZAISU_lightg);
		registerBlock(ZAISU_cyan);
		registerBlock(ZAISU_purple);
		registerBlock(ZAISU_blue);
		registerBlock(ZAISU_brown);
		registerBlock(ZAISU_green);
		registerBlock(ZAISU_red);
		registerBlock(ZAISU_black);

		registerBlock(TATAMI_H);
		registerBlock(TATAMI_H_white);
		registerBlock(TATAMI_H_orange);
		registerBlock(TATAMI_H_magenta);
		registerBlock(TATAMI_H_lightb);
		registerBlock(TATAMI_H_yellow);
		registerBlock(TATAMI_H_lime);
		registerBlock(TATAMI_H_pink);
		registerBlock(TATAMI_H_gray);
		registerBlock(TATAMI_H_lightg);
		registerBlock(TATAMI_H_cyan);
		registerBlock(TATAMI_H_purple);
		registerBlock(TATAMI_H_blue);
		registerBlock(TATAMI_H_brown);
		registerBlock(TATAMI_H_green);
		registerBlock(TATAMI_H_red);
		registerBlock(TATAMI_H_black);

		registerBlock(TATAMI_HY);
		registerBlock(TATAMI_HY_white);
		registerBlock(TATAMI_HY_orange);
		registerBlock(TATAMI_HY_magenta);
		registerBlock(TATAMI_HY_lightb);
		registerBlock(TATAMI_HY_yellow);
		registerBlock(TATAMI_HY_lime);
		registerBlock(TATAMI_HY_pink);
		registerBlock(TATAMI_HY_gray);
		registerBlock(TATAMI_HY_lightg);
		registerBlock(TATAMI_HY_cyan);
		registerBlock(TATAMI_HY_purple);
		registerBlock(TATAMI_HY_blue);
		registerBlock(TATAMI_HY_brown);
		registerBlock(TATAMI_HY_green);
		registerBlock(TATAMI_HY_red);
		registerBlock(TATAMI_HY_black);

		registerBlock(TAKECUBE);
		registerBlock(TAKECUBE_Y);
		registerBlock(TAKECUBE_K);
		registerBlock(TAKE_ST);
		registerBlock(TAKE_STY);
		registerBlock(TAKE_STK);
		registerBlock(TAKE_SH);
		registerBlock(TAKE_SHY);
		registerBlock(TAKE_SHK);

		registerBlock(TAKEFENCE);
		registerBlock(TAKEFENCE_Y);
		registerBlock(TAKEFENCE_K);

		registerBlock(TAKE_TRAPDOOR);
		registerBlock(TAKE_TRAPDOOR_Y);
		registerBlock(TAKE_TRAPDOOR_K);
		registerBlock(TAKE_PLATE);
		registerBlock(TAKE_PLATE_Y);
		registerBlock(TAKE_PLATE_K);
		registerBlock(TAKE_BUTTON);
		registerBlock(TAKE_BUTTON_Y);
		registerBlock(TAKE_BUTTON_K);

		registerBlock(WADAIKO_TOP);
		registerBlock(WADAIKO_BOT);
		registerBlock(WADAIKO_small);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
