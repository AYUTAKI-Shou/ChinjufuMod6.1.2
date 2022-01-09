package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.cmblock.KusaDummy;
import com.ayutaki.chinjufumod.blocks.cmblock.KusaTaba;
import com.ayutaki.chinjufumod.blocks.cmblock.KusaTaba_Stairs;
import com.ayutaki.chinjufumod.blocks.cmblock.Roof;
import com.ayutaki.chinjufumod.blocks.garden.Bonsai_sesonal;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoi.Kamoi_Sakura;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_ich;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_kae;
import com.ayutaki.chinjufumod.blocks.ranma.Kanki_saku;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_ich;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_kae;
import com.ayutaki.chinjufumod.blocks.ranma.KoushiB_saku;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_ich;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_kae;
import com.ayutaki.chinjufumod.blocks.ranma.Koushi_saku;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_ich;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_kae;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaB_saku;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_ich;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_kae;
import com.ayutaki.chinjufumod.blocks.ranma.RanmaC_saku;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_ich;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_kae;
import com.ayutaki.chinjufumod.blocks.ranma.Ranma_saku;
import com.ayutaki.chinjufumod.blocks.season.Fence_CM;
import com.ayutaki.chinjufumod.blocks.season.Hinadan;
import com.ayutaki.chinjufumod.blocks.season.Hinakazari;
import com.ayutaki.chinjufumod.blocks.season.Kourihata;
import com.ayutaki.chinjufumod.blocks.season.NewYear_Xmas;
import com.ayutaki.chinjufumod.blocks.season.NewYear_Xmas_Top;
import com.ayutaki.chinjufumod.blocks.season.Present;
import com.ayutaki.chinjufumod.blocks.season.Present_B;
import com.ayutaki.chinjufumod.blocks.season.PressurePlate_CM;
import com.ayutaki.chinjufumod.blocks.season.Shimenawa;
import com.ayutaki.chinjufumod.blocks.season.SnowCore;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot1;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot1D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot2;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot2D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot3;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot3D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot4;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot4D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot5;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot5D;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top1;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top2;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top3;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top4;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Top5;
import com.ayutaki.chinjufumod.blocks.season.TrapDoor_CM;
import com.ayutaki.chinjufumod.blocks.season.Uchiwa;
import com.ayutaki.chinjufumod.blocks.season.Wataame_block;
import com.ayutaki.chinjufumod.blocks.season.WoodButton_CM;
import com.ayutaki.chinjufumod.blocks.wallpane.BlockPlank_Pillar;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_log;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plank;
import com.ayutaki.chinjufumod.blocks.wood.Carpet_Leaf;
import com.ayutaki.chinjufumod.blocks.wood.FallLeaf;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Sakuraflower;
import com.ayutaki.chinjufumod.blocks.wood.Log_WoodCM;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Nae_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Sakura;
import com.ayutaki.chinjufumod.blocks.wood.Planks_CM;
import com.ayutaki.chinjufumod.blocks.wood.Slab_SeasonalPlank;
import com.ayutaki.chinjufumod.blocks.wood.Stairs_SeasonalPlank;
import com.ayutaki.chinjufumod.blocks.wood.Suiden;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Seasonal_Blocks {

	public static Block FALL_LEAF, SUIDEN;

	public static Block SAKURA_flow, KAEDE_leaf, ICHOH_leaf, OAKKARE_leaf;
	public static Block SAKURA_log, KAEDE_log, ICHOH_log;
	public static Block SAKURA_nae, KAEDE_nae, ICHOH_nae, OAKKARE_nae;

	public static Block PLANKS;
	public static Block SAKURA_stairs, KAEDE_stairs, ICHOH_stairs;
	public static Slab_SeasonalPlank SAKURA_slabhalf, KAEDE_slabhalf, ICHOH_slabhalf;
	public static Block PILLAR_saku, PILLAR_kae, PILLAR_ich;
	public static Block PILLARSLAB_saku, PILLARSLAB_kae, PILLARSLAB_ich;
	public static Block SAKURA_FENCE, KAEDE_FENCE, ICHOH_FENCE;

	public static Block SAKURA_TRAPDOOR, KAEDE_TRAPDOOR, ICHOH_TRAPDOOR;
	public static Block SAKURA_PLATE, KAEDE_PLATE, ICHOH_PLATE;
	public static Block SAKURA_BUTTON, KAEDE_BUTTON, ICHOH_BUTTON;

	public static Block SAKURA_carpet, KAEDE_carpet, ICHOH_carpet, OCHIBA_carpet;

	public static Block WP_LOG_sakura, WP_LOG_kaede, WP_LOG_ichoh;
	public static Block WP_PLANK_sakura, WP_PLANK_kaede, WP_PLANK_ichoh;

	public static Block RANMA_saku, RANMA_kae, RANMA_ich;
	public static Block RANMAB_saku, RANMAB_kae, RANMAB_ich;
	public static Block RANMAC_saku, RANMAC_kae, RANMAC_ich;
	public static Block KANKI_saku, KANKI_kae, KANKI_ich;
	public static Block KOUSHI_saku, KOUSHI_kae, KOUSHI_ich;
	public static Block KOUSHIB_saku, KOUSHIB_kae, KOUSHIB_ich;

	public static Block BONSAI_sakura, BONSAI_kaede, BONSAI_ichoh, BONSAI_kare;

	public static Block DUMMY_KUSA;
	public static Block KUSATABA, KUSATABA_STAIRS, WARATABA;
	public static Block KUSATABA_RF, WARATABA_RF, KAYATABA_RF;
	public static Block WARATABA_STAIRS, KAYATABA, KAYATABA_STAIRS;

	public static Block SHIMENAWA;
	public static Block NEWYEAR_XMAS, NEWYEAR_XMAS_TOP;
	public static Block PRESENT, PRESENT_B;
	public static Block HINAKAZARI, HINADAN;

	public static Block UCHIWA_white, UCHIWA_orange, UCHIWA_magenta, UCHIWA_lightb,
								UCHIWA_yellow, UCHIWA_lime, UCHIWA_pink, UCHIWA_gray,
								UCHIWA_lightg, UCHIWA_cyan, UCHIWA_purple, UCHIWA_blue,
								UCHIWA_brown, UCHIWA_green, UCHIWA_red, UCHIWA_black;

	public static Block WATAGASHI_block, WATAGASHI_pink, WATAGASHI_red, WATAGASHI_yellow, WATAGASHI_green;
	public static Block KAKIGOURI_hata;
	
	public static Block SNOWCORE;
	public static Block SNOWMAN_TOP1, SNOWMAN_TOP2, SNOWMAN_TOP3, SNOWMAN_TOP4, SNOWMAN_TOP5;
	public static Block SNOWMAN_BOT1, SNOWMAN_BOT2, SNOWMAN_BOT3, SNOWMAN_BOT4, SNOWMAN_BOT5;
	public static Block SNOWMAN_BOT1D, SNOWMAN_BOT2D, SNOWMAN_BOT3D, SNOWMAN_BOT4D, SNOWMAN_BOT5D;

	public static void init() {

		FALL_LEAF = new FallLeaf();
		SUIDEN = new Suiden();

		SAKURA_flow = new Leaf_Sakuraflower();
		KAEDE_leaf = new Leaf_Kaede();
		ICHOH_leaf = new Leaf_Ichoh();
		OAKKARE_leaf = new Leaf_OakKare();

		SAKURA_log = new Log_WoodCM().setRegistryName("block_tree_sakura_log").setUnlocalizedName("block_tree_sakura_log");
		KAEDE_log = new Log_WoodCM().setRegistryName("block_tree_kaede_log").setUnlocalizedName("block_tree_kaede_log");
		ICHOH_log = new Log_WoodCM().setRegistryName("block_tree_ichoh_log").setUnlocalizedName("block_tree_ichoh_log");

		SAKURA_nae = new Nae_Sakura();
		KAEDE_nae = new Nae_Kaede();
		ICHOH_nae = new Nae_Ichoh();
		OAKKARE_nae = new Nae_OakKare();

		PLANKS = new Planks_CM();
		SAKURA_stairs = new Stairs_SeasonalPlank("block_stairs_sakura", PLANKS.getDefaultState()).setRegistryName("block_stairs_sakura").setUnlocalizedName("block_stairs_sakura");
		KAEDE_stairs = new Stairs_SeasonalPlank("block_stairs_kaede", PLANKS.getDefaultState()).setRegistryName("block_stairs_kaede").setUnlocalizedName("block_stairs_kaede");
		ICHOH_stairs = new Stairs_SeasonalPlank("block_stairs_ichoh", PLANKS.getDefaultState()).setRegistryName("block_stairs_ichoh").setUnlocalizedName("block_stairs_ichoh");
		SAKURA_slabhalf = new Slab_SeasonalPlank("block_slabhalf_sakura");
		KAEDE_slabhalf = new Slab_SeasonalPlank("block_slabhalf_kaede");
		ICHOH_slabhalf = new Slab_SeasonalPlank("block_slabhalf_ichoh");

		PILLAR_saku = new BlockPlank_Pillar().setRegistryName("block_pillar_sakura").setUnlocalizedName("block_pillar_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLAR_kae = new BlockPlank_Pillar().setRegistryName("block_pillar_kaede").setUnlocalizedName("block_pillar_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLAR_ich = new BlockPlank_Pillar().setRegistryName("block_pillar_ichoh").setUnlocalizedName("block_pillar_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_saku = new Kamoi_Sakura(Material.WOOD, "block_kamoi_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_kae = new Kamoi_Kaede(Material.WOOD, "block_kamoi_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		PILLARSLAB_ich = new Kamoi_Ichoh(Material.WOOD, "block_kamoi_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		SAKURA_FENCE = new Fence_CM().setRegistryName("block_fence_sakura").setUnlocalizedName("block_fence_sakura");
		KAEDE_FENCE = new Fence_CM().setRegistryName("block_fence_kaede").setUnlocalizedName("block_fence_kaede");
		ICHOH_FENCE = new Fence_CM().setRegistryName("block_fence_ichoh").setUnlocalizedName("block_fence_ichoh");

		SAKURA_TRAPDOOR = new TrapDoor_CM().setRegistryName("block_trapdoor_sakura").setUnlocalizedName("block_trapdoor_sakura");
		KAEDE_TRAPDOOR = new TrapDoor_CM().setRegistryName("block_trapdoor_kaede").setUnlocalizedName("block_trapdoor_kaede");
		ICHOH_TRAPDOOR = new TrapDoor_CM().setRegistryName("block_trapdoor_ichoh").setUnlocalizedName("block_trapdoor_ichoh");
		SAKURA_PLATE = new PressurePlate_CM().setRegistryName("block_plate_sakura").setUnlocalizedName("block_plate_sakura");
		KAEDE_PLATE = new PressurePlate_CM().setRegistryName("block_plate_kaede").setUnlocalizedName("block_plate_kaede");
		ICHOH_PLATE = new PressurePlate_CM().setRegistryName("block_plate_ichoh").setUnlocalizedName("block_plate_ichoh");
		SAKURA_BUTTON = new WoodButton_CM().setRegistryName("block_button_sakura").setUnlocalizedName("block_button_sakura");
		KAEDE_BUTTON = new WoodButton_CM().setRegistryName("block_button_kaede").setUnlocalizedName("block_button_kaede");
		ICHOH_BUTTON = new WoodButton_CM().setRegistryName("block_button_ichoh").setUnlocalizedName("block_button_ichoh");

		SAKURA_carpet = new Carpet_Leaf().setRegistryName("block_carpet_sakura").setUnlocalizedName("block_carpet_sakura");
		KAEDE_carpet = new Carpet_Leaf().setRegistryName("block_carpet_kaede").setUnlocalizedName("block_carpet_kaede");
		ICHOH_carpet = new Carpet_Leaf().setRegistryName("block_carpet_ichoh").setUnlocalizedName("block_carpet_ichoh");
		OCHIBA_carpet = new Carpet_Leaf().setRegistryName("block_carpet_ochiba").setUnlocalizedName("block_carpet_ochiba");

		WP_LOG_sakura = new WP_log("block_wp_log_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_LOG_kaede = new WP_log("block_wp_log_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_LOG_ichoh = new WP_log("block_wp_log_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		WP_PLANK_sakura = new WP_plank("block_wp_plank_sakura").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_PLANK_kaede = new WP_plank("block_wp_plank_kaede").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WP_PLANK_ichoh = new WP_plank("block_wp_plank_ichoh").setCreativeTab(ChinjufuModTabs.SEASONAL);

		BONSAI_sakura = new Bonsai_sesonal().setRegistryName("block_bonsai_sakura").setUnlocalizedName("block_bonsai_sakura");
		BONSAI_kaede = new Bonsai_sesonal().setRegistryName("block_bonsai_kaede").setUnlocalizedName("block_bonsai_kaede");
		BONSAI_ichoh = new Bonsai_sesonal().setRegistryName("block_bonsai_ichoh").setUnlocalizedName("block_bonsai_ichoh");
		BONSAI_kare = new Bonsai_sesonal().setRegistryName("block_bonsai_oakkare").setUnlocalizedName("block_bonsai_oakkare");

		RANMA_saku = new Ranma_saku(Material.WOOD, "block_ranma_saku");
		RANMA_kae = new Ranma_kae(Material.WOOD, "block_ranma_kae");
		RANMA_ich = new Ranma_ich(Material.WOOD, "block_ranma_ich");
		RANMAB_saku = new RanmaB_saku(Material.WOOD, "block_ranmab_saku");
		RANMAB_kae = new RanmaB_kae(Material.WOOD, "block_ranmab_kae");
		RANMAB_ich = new RanmaB_ich(Material.WOOD, "block_ranmab_ich");
		RANMAC_saku = new RanmaC_saku(Material.WOOD, "block_ranmac_saku");
		RANMAC_kae = new RanmaC_kae(Material.WOOD, "block_ranmac_kae");
		RANMAC_ich = new RanmaC_ich(Material.WOOD, "block_ranmac_ich");

		KANKI_saku = new Kanki_saku(Material.WOOD, "block_kanki_saku");
		KANKI_kae = new Kanki_kae(Material.WOOD, "block_kanki_kae");
		KANKI_ich = new Kanki_ich(Material.WOOD, "block_kanki_ich");

		KOUSHI_saku = new Koushi_saku(Material.WOOD, "block_koushi_saku");
		KOUSHI_kae = new Koushi_kae(Material.WOOD, "block_koushi_kae");
		KOUSHI_ich = new Koushi_ich(Material.WOOD, "block_koushi_ich");
		KOUSHIB_saku = new KoushiB_saku(Material.WOOD, "block_koushib_saku");
		KOUSHIB_kae = new KoushiB_kae(Material.WOOD, "block_koushib_kae");
		KOUSHIB_ich = new KoushiB_ich(Material.WOOD, "block_koushib_ich");

		DUMMY_KUSA = new KusaDummy().setRegistryName("block_dummy_kusa").setUnlocalizedName("block_dummy_kusa");
		KUSATABA = new KusaTaba("block_tabakusa");
		WARATABA = new KusaTaba("block_tabawara");
		KAYATABA = new KusaTaba("block_tabakaya");
		KUSATABA_RF = new Roof("block_tabakusa_roof");
		WARATABA_RF = new Roof("block_tabawara_roof");
		KAYATABA_RF = new Roof("block_tabakaya_roof");
		KUSATABA_STAIRS = new KusaTaba_Stairs("block_tabakusa_stairs", DUMMY_KUSA.getDefaultState());
		WARATABA_STAIRS = new KusaTaba_Stairs("block_tabawara_stairs", DUMMY_KUSA.getDefaultState());
		KAYATABA_STAIRS = new KusaTaba_Stairs("block_tabakaya_stairs", DUMMY_KUSA.getDefaultState());

		SHIMENAWA = new Shimenawa().setRegistryName("block_shimenawa").setUnlocalizedName("block_shimenawa");
		NEWYEAR_XMAS = new NewYear_Xmas();
		NEWYEAR_XMAS_TOP = new NewYear_Xmas_Top();
		PRESENT = new Present();
		PRESENT_B = new Present_B();
		HINAKAZARI = new Hinakazari().setRegistryName("block_hinakazari").setUnlocalizedName("block_hinakazari");
		HINADAN = new Hinadan().setRegistryName("block_hinadan").setUnlocalizedName("block_hinadan");

		UCHIWA_white = new Uchiwa().setRegistryName("block_uchiwa_white").setUnlocalizedName("block_uchiwa_white");
		UCHIWA_orange = new Uchiwa().setRegistryName("block_uchiwa_orange").setUnlocalizedName("block_uchiwa_orange");
		UCHIWA_magenta = new Uchiwa().setRegistryName("block_uchiwa_magenta").setUnlocalizedName("block_uchiwa_magenta");
		UCHIWA_lightb = new Uchiwa().setRegistryName("block_uchiwa_lightb").setUnlocalizedName("block_uchiwa_lightb");
		UCHIWA_yellow = new Uchiwa().setRegistryName("block_uchiwa_yellow").setUnlocalizedName("block_uchiwa_yellow");
		UCHIWA_lime = new Uchiwa().setRegistryName("block_uchiwa_lime").setUnlocalizedName("block_uchiwa_lime");
		UCHIWA_pink = new Uchiwa().setRegistryName("block_uchiwa_pink").setUnlocalizedName("block_uchiwa_pink");
		UCHIWA_gray = new Uchiwa().setRegistryName("block_uchiwa_gray").setUnlocalizedName("block_uchiwa_gray");
		UCHIWA_lightg = new Uchiwa().setRegistryName("block_uchiwa_lightg").setUnlocalizedName("block_uchiwa_lightg");
		UCHIWA_cyan = new Uchiwa().setRegistryName("block_uchiwa_cyan").setUnlocalizedName("block_uchiwa_cyan");
		UCHIWA_purple = new Uchiwa().setRegistryName("block_uchiwa_purple").setUnlocalizedName("block_uchiwa_purple");
		UCHIWA_blue = new Uchiwa().setRegistryName("block_uchiwa_blue").setUnlocalizedName("block_uchiwa_blue");
		UCHIWA_brown = new Uchiwa().setRegistryName("block_uchiwa_brown").setUnlocalizedName("block_uchiwa_brown");
		UCHIWA_green = new Uchiwa().setRegistryName("block_uchiwa_green").setUnlocalizedName("block_uchiwa_green");
		UCHIWA_red = new Uchiwa().setRegistryName("block_uchiwa_red").setUnlocalizedName("block_uchiwa_red");
		UCHIWA_black = new Uchiwa().setRegistryName("block_uchiwa_black").setUnlocalizedName("block_uchiwa_black");

		WATAGASHI_block = new Wataame_block().setRegistryName("block_watagashi").setUnlocalizedName("block_watagashi");
		WATAGASHI_pink = new Wataame_block().setRegistryName("block_watagashi_pink").setUnlocalizedName("block_watagashi_pink");
		WATAGASHI_red = new Wataame_block().setRegistryName("block_watagashi_red").setUnlocalizedName("block_watagashi_red");
		WATAGASHI_yellow = new Wataame_block().setRegistryName("block_watagashi_yellow").setUnlocalizedName("block_watagashi_yellow");
		WATAGASHI_green = new Wataame_block().setRegistryName("block_watagashi_green").setUnlocalizedName("block_watagashi_green");

		KAKIGOURI_hata = new Kourihata().setRegistryName("block_kakigouri_hata").setUnlocalizedName("block_kakigouri_hata");

		SNOWCORE = new SnowCore();
		SNOWMAN_TOP1 = new SnowMan_Top1();
		SNOWMAN_TOP2 = new SnowMan_Top2();
		SNOWMAN_TOP3 = new SnowMan_Top3();
		SNOWMAN_TOP4 = new SnowMan_Top4();
		SNOWMAN_TOP5 = new SnowMan_Top5();
		
		SNOWMAN_BOT1 = new SnowMan_Bot1();
		SNOWMAN_BOT2 = new SnowMan_Bot2();
		SNOWMAN_BOT3 = new SnowMan_Bot3();
		SNOWMAN_BOT4 = new SnowMan_Bot4();
		SNOWMAN_BOT5 = new SnowMan_Bot5();

		SNOWMAN_BOT1D = new SnowMan_Bot1D();
		SNOWMAN_BOT2D = new SnowMan_Bot2D();
		SNOWMAN_BOT3D = new SnowMan_Bot3D();
		SNOWMAN_BOT4D = new SnowMan_Bot4D();
		SNOWMAN_BOT5D = new SnowMan_Bot5D();

	}


	public static void register() {

		registerBlock(FALL_LEAF);
		registerBlock(SUIDEN);

		registerBlock(SAKURA_log);
		registerBlock(KAEDE_log);
		registerBlock(ICHOH_log);

		registerBlock(SAKURA_flow);
		registerBlock(KAEDE_leaf);
		registerBlock(ICHOH_leaf);
		registerBlock(OAKKARE_leaf);

		registerBlock(SAKURA_nae);
		registerBlock(KAEDE_nae);
		registerBlock(ICHOH_nae);
		registerBlock(OAKKARE_nae);

		registerBlock(PLANKS);
		registerBlock(SAKURA_stairs);
		registerBlock(KAEDE_stairs);
		registerBlock(ICHOH_stairs);
		registerBlock(SAKURA_slabhalf);
		registerBlock(KAEDE_slabhalf);
		registerBlock(ICHOH_slabhalf);

		registerBlock(PILLAR_saku);
		registerBlock(PILLAR_kae);
		registerBlock(PILLAR_ich);
		registerBlock(PILLARSLAB_saku);
		registerBlock(PILLARSLAB_kae);
		registerBlock(PILLARSLAB_ich);

		registerBlock(SAKURA_FENCE);
		registerBlock(KAEDE_FENCE);
		registerBlock(ICHOH_FENCE);

		registerBlock(SAKURA_TRAPDOOR);
		registerBlock(KAEDE_TRAPDOOR);
		registerBlock(ICHOH_TRAPDOOR);
		registerBlock(SAKURA_PLATE);
		registerBlock(KAEDE_PLATE);
		registerBlock(ICHOH_PLATE);
		registerBlock(SAKURA_BUTTON);
		registerBlock(KAEDE_BUTTON);
		registerBlock(ICHOH_BUTTON);

		registerBlock(SAKURA_carpet);
		registerBlock(KAEDE_carpet);
		registerBlock(ICHOH_carpet);
		registerBlock(OCHIBA_carpet);

		registerBlock(WP_LOG_sakura);
		registerBlock(WP_LOG_kaede);
		registerBlock(WP_LOG_ichoh);

		registerBlock(WP_PLANK_sakura);
		registerBlock(WP_PLANK_kaede);
		registerBlock(WP_PLANK_ichoh);

		registerBlock(RANMA_saku);
		registerBlock(RANMA_kae);
		registerBlock(RANMA_ich);
		registerBlock(RANMAB_saku);
		registerBlock(RANMAB_kae);
		registerBlock(RANMAB_ich);
		registerBlock(RANMAC_saku);
		registerBlock(RANMAC_kae);
		registerBlock(RANMAC_ich);

		registerBlock(KANKI_saku);
		registerBlock(KANKI_kae);
		registerBlock(KANKI_ich);

		registerBlock(KOUSHI_saku);
		registerBlock(KOUSHI_kae);
		registerBlock(KOUSHI_ich);
		registerBlock(KOUSHIB_saku);
		registerBlock(KOUSHIB_kae);
		registerBlock(KOUSHIB_ich);

		registerBlock(BONSAI_sakura);
		registerBlock(BONSAI_kaede);
		registerBlock(BONSAI_ichoh);
		registerBlock(BONSAI_kare);

		registerBlock(DUMMY_KUSA);
		registerBlock(KUSATABA);
		registerBlock(WARATABA);
		registerBlock(KAYATABA);
		registerBlock(KUSATABA_RF);
		registerBlock(WARATABA_RF);
		registerBlock(KAYATABA_RF);
		registerBlock(KUSATABA_STAIRS);
		registerBlock(WARATABA_STAIRS);
		registerBlock(KAYATABA_STAIRS);

		registerBlock(SHIMENAWA);
		registerBlock(NEWYEAR_XMAS);
		registerBlock(NEWYEAR_XMAS_TOP);
		registerBlock(PRESENT);
		registerBlock(PRESENT_B);
		registerBlock(HINAKAZARI);
		registerBlock(HINADAN);

		registerBlock(UCHIWA_white);
		registerBlock(UCHIWA_orange);
		registerBlock(UCHIWA_magenta);
		registerBlock(UCHIWA_lightb);
		registerBlock(UCHIWA_yellow);
		registerBlock(UCHIWA_lime);
		registerBlock(UCHIWA_pink);
		registerBlock(UCHIWA_gray);
		registerBlock(UCHIWA_lightg);
		registerBlock(UCHIWA_cyan);
		registerBlock(UCHIWA_purple);
		registerBlock(UCHIWA_blue);
		registerBlock(UCHIWA_brown);
		registerBlock(UCHIWA_green);
		registerBlock(UCHIWA_red);
		registerBlock(UCHIWA_black);

		registerBlock(WATAGASHI_block);
		registerBlock(WATAGASHI_pink);
		registerBlock(WATAGASHI_red);
		registerBlock(WATAGASHI_yellow);
		registerBlock(WATAGASHI_green);

		registerBlock(KAKIGOURI_hata);
		
		registerBlock(SNOWCORE);
		registerBlock(SNOWMAN_TOP1);
		registerBlock(SNOWMAN_TOP2);
		registerBlock(SNOWMAN_TOP3);
		registerBlock(SNOWMAN_TOP4);
		registerBlock(SNOWMAN_TOP5);
		
		registerBlock(SNOWMAN_BOT1);
		registerBlock(SNOWMAN_BOT2);
		registerBlock(SNOWMAN_BOT3);
		registerBlock(SNOWMAN_BOT4);
		registerBlock(SNOWMAN_BOT5);

		registerBlock(SNOWMAN_BOT1D);
		registerBlock(SNOWMAN_BOT2D);
		registerBlock(SNOWMAN_BOT3D);
		registerBlock(SNOWMAN_BOT4D);
		registerBlock(SNOWMAN_BOT5D);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
