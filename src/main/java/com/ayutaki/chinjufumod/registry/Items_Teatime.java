package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.crop.NoriAmi;
import com.ayutaki.chinjufumod.blocks.crop.Toami_Wide;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_KinokoAmaKara;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Cider;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_CiderJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_MeadJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeNama;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeShin;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_WineJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.NabeAmazake_cooked;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Budoushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Hachimitsushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Ringoshu;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_board;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_duct;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_ductend;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_kanki_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen;
import com.ayutaki.chinjufumod.blocks.pantry.CanTea;
import com.ayutaki.chinjufumod.blocks.pantry.Chadutsu;
import com.ayutaki.chinjufumod.blocks.pantry.Tawara;
import com.ayutaki.chinjufumod.items.crops.ItemBoxSeeds;
import com.ayutaki.chinjufumod.items.crops.ItemChanoki_nae;
import com.ayutaki.chinjufumod.items.crops.ItemEnden;
import com.ayutaki.chinjufumod.items.crops.ItemGrape_nae;
import com.ayutaki.chinjufumod.items.crops.ItemHodaGi_Bot;
import com.ayutaki.chinjufumod.items.crops.ItemInagi_Bot;
import com.ayutaki.chinjufumod.items.crops.ItemMikan_nae;
import com.ayutaki.chinjufumod.items.crops.ItemSeedCabbage;
import com.ayutaki.chinjufumod.items.crops.ItemSeedCherry;
import com.ayutaki.chinjufumod.items.crops.ItemSeedCorn;
import com.ayutaki.chinjufumod.items.crops.ItemSeedHakusai;
import com.ayutaki.chinjufumod.items.crops.ItemSeedOnion;
import com.ayutaki.chinjufumod.items.crops.ItemSeedRice;
import com.ayutaki.chinjufumod.items.crops.ItemSeedSoy;
import com.ayutaki.chinjufumod.items.crops.ItemSeedSpinach;
import com.ayutaki.chinjufumod.items.crops.ItemSeedTomato;
import com.ayutaki.chinjufumod.items.dish.ItemChicken_large;
import com.ayutaki.chinjufumod.items.dish.ItemChicken_small;
import com.ayutaki.chinjufumod.items.dish.ItemCornSoup_small;
import com.ayutaki.chinjufumod.items.dish.ItemCurry;
import com.ayutaki.chinjufumod.items.dish.ItemCurryNabe;
import com.ayutaki.chinjufumod.items.dish.ItemCurrySet;
import com.ayutaki.chinjufumod.items.dish.ItemDon_Gyu;
import com.ayutaki.chinjufumod.items.dish.ItemDon_Kaisen;
import com.ayutaki.chinjufumod.items.dish.ItemDon_Katsu;
import com.ayutaki.chinjufumod.items.dish.ItemDon_Meshi;
import com.ayutaki.chinjufumod.items.dish.ItemDon_Oyako;
import com.ayutaki.chinjufumod.items.dish.ItemEggburgSet;
import com.ayutaki.chinjufumod.items.dish.ItemEggburg_small;
import com.ayutaki.chinjufumod.items.dish.ItemFish_boiled;
import com.ayutaki.chinjufumod.items.dish.ItemFryPan_kara;
import com.ayutaki.chinjufumod.items.dish.ItemFrypan_Bake_1;
import com.ayutaki.chinjufumod.items.dish.ItemFrypan_Bake_2;
import com.ayutaki.chinjufumod.items.dish.ItemFrypan_Nama_1;
import com.ayutaki.chinjufumod.items.dish.ItemFrypan_Nama_2;
import com.ayutaki.chinjufumod.items.dish.ItemGohan_small;
import com.ayutaki.chinjufumod.items.dish.ItemHakusaiduke;
import com.ayutaki.chinjufumod.items.dish.ItemIcecream;
import com.ayutaki.chinjufumod.items.dish.ItemJPChaUke;
import com.ayutaki.chinjufumod.items.dish.ItemJPTeaCup;
import com.ayutaki.chinjufumod.items.dish.ItemJPTeaSet;
import com.ayutaki.chinjufumod.items.dish.ItemKeiryoCup;
import com.ayutaki.chinjufumod.items.dish.ItemKeiryoCup_full;
import com.ayutaki.chinjufumod.items.dish.ItemKettle_boil;
import com.ayutaki.chinjufumod.items.dish.ItemKettle_full;
import com.ayutaki.chinjufumod.items.dish.ItemKettle_kara;
import com.ayutaki.chinjufumod.items.dish.ItemKyusu;
import com.ayutaki.chinjufumod.items.dish.ItemKyusu_kara;
import com.ayutaki.chinjufumod.items.dish.ItemMisoSoup_small;
import com.ayutaki.chinjufumod.items.dish.ItemNabeCooked_SNT;
import com.ayutaki.chinjufumod.items.dish.ItemNabeCornSoup;
import com.ayutaki.chinjufumod.items.dish.ItemNabeGohan;
import com.ayutaki.chinjufumod.items.dish.ItemNabeKaisui;
import com.ayutaki.chinjufumod.items.dish.ItemNabeMiso;
import com.ayutaki.chinjufumod.items.dish.ItemNabeNama_1;
import com.ayutaki.chinjufumod.items.dish.ItemNabeNama_2;
import com.ayutaki.chinjufumod.items.dish.ItemNabeTori;
import com.ayutaki.chinjufumod.items.dish.ItemNabe_kara;
import com.ayutaki.chinjufumod.items.dish.ItemPastaCheese;
import com.ayutaki.chinjufumod.items.dish.ItemPastaKinoko;
import com.ayutaki.chinjufumod.items.dish.ItemPastaTomato;
import com.ayutaki.chinjufumod.items.dish.ItemPizza_coocked;
import com.ayutaki.chinjufumod.items.dish.ItemRice_small;
import com.ayutaki.chinjufumod.items.dish.ItemSconeSet_1;
import com.ayutaki.chinjufumod.items.dish.ItemSconeSet_kara;
import com.ayutaki.chinjufumod.items.dish.ItemShouyuSara;
import com.ayutaki.chinjufumod.items.dish.ItemStew;
import com.ayutaki.chinjufumod.items.dish.ItemStewNabe;
import com.ayutaki.chinjufumod.items.dish.ItemSushiGeta_kara;
import com.ayutaki.chinjufumod.items.dish.ItemSushiMeshi;
import com.ayutaki.chinjufumod.items.dish.ItemSushiOkeFull_1;
import com.ayutaki.chinjufumod.items.dish.ItemSushiOke_kara;
import com.ayutaki.chinjufumod.items.dish.ItemSushiSet_4shoku;
import com.ayutaki.chinjufumod.items.dish.ItemSushiSet_Beef;
import com.ayutaki.chinjufumod.items.dish.ItemSushiSet_Fish;
import com.ayutaki.chinjufumod.items.dish.ItemSushiSet_Salmon;
import com.ayutaki.chinjufumod.items.dish.ItemSushiSet_Tamago;
import com.ayutaki.chinjufumod.items.dish.ItemTamagoyakiSet;
import com.ayutaki.chinjufumod.items.dish.ItemTamagoyaki_small;
import com.ayutaki.chinjufumod.items.dish.ItemTeaCup;
import com.ayutaki.chinjufumod.items.dish.ItemTeaPot;
import com.ayutaki.chinjufumod.items.dish.ItemTeaPot_kara;
import com.ayutaki.chinjufumod.items.dish.ItemTeaSet;
import com.ayutaki.chinjufumod.items.dish.ItemTonsui_small;
import com.ayutaki.chinjufumod.items.dish.ItemUdon_Niku;
import com.ayutaki.chinjufumod.items.dish.ItemUdon_Su;
import com.ayutaki.chinjufumod.items.dish.ItemUdon_Tsukimi;
import com.ayutaki.chinjufumod.items.dish.ItemYakijyakeSet;
import com.ayutaki.chinjufumod.items.dish.ItemYakizakanaSet;
import com.ayutaki.chinjufumod.items.dish.ItemZundou;
import com.ayutaki.chinjufumod.items.dish.ItemZundou_Dashi;
import com.ayutaki.chinjufumod.items.dish.ItemZundou_Milk;
import com.ayutaki.chinjufumod.items.dish.ItemZundou_Mizu;
import com.ayutaki.chinjufumod.items.dish.ItemZundou_Nama;
import com.ayutaki.chinjufumod.items.dish.ItemZundou_ShioMizu;
import com.ayutaki.chinjufumod.items.food.ItemFoodCheese;
import com.ayutaki.chinjufumod.items.food.ItemFoodCherry;
import com.ayutaki.chinjufumod.items.food.ItemFoodKirimi;
import com.ayutaki.chinjufumod.items.food.ItemFoodKushiSakana;
import com.ayutaki.chinjufumod.items.food.ItemFoodOnigiri;
import com.ayutaki.chinjufumod.items.food.ItemFoodPizza;
import com.ayutaki.chinjufumod.items.food.ItemFoodSushi;
import com.ayutaki.chinjufumod.items.food.ItemFoodSushi_Shouyu;
import com.ayutaki.chinjufumod.items.food.ItemModFood;
import com.ayutaki.chinjufumod.items.food.ItemSenbei;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.hakkou.ItemBinKoubo;
import com.ayutaki.chinjufumod.items.hakkou.ItemBinKoubo_full;
import com.ayutaki.chinjufumod.items.hakkou.ItemBinNyusan;
import com.ayutaki.chinjufumod.items.hakkou.ItemBinNyusan_full;
import com.ayutaki.chinjufumod.items.hakkou.ItemCheese_block;
import com.ayutaki.chinjufumod.items.hakkou.ItemCheese_curd;
import com.ayutaki.chinjufumod.items.hakkou.ItemDashi_bot_1;
import com.ayutaki.chinjufumod.items.hakkou.ItemDashi_bot_2;
import com.ayutaki.chinjufumod.items.hakkou.ItemDashi_bot_3;
import com.ayutaki.chinjufumod.items.hakkou.ItemDashi_bot_4;
import com.ayutaki.chinjufumod.items.hakkou.ItemGlass_Sake;
import com.ayutaki.chinjufumod.items.hakkou.ItemGlass_Wine;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru_Hakusai;
import com.ayutaki.chinjufumod.items.hakkou.ItemHakkouTaru_Shouyu;
import com.ayutaki.chinjufumod.items.hakkou.ItemKomezu_bot_1;
import com.ayutaki.chinjufumod.items.hakkou.ItemKomezu_bot_2;
import com.ayutaki.chinjufumod.items.hakkou.ItemMizuoke_full;
import com.ayutaki.chinjufumod.items.hakkou.ItemMizuoke_kara;
import com.ayutaki.chinjufumod.items.hakkou.ItemMizuoke_milk;
import com.ayutaki.chinjufumod.items.hakkou.ItemMoromi;
import com.ayutaki.chinjufumod.items.hakkou.ItemMushigome;
import com.ayutaki.chinjufumod.items.hakkou.ItemNabeAmazake_nama;
import com.ayutaki.chinjufumod.items.hakkou.ItemNimame;
import com.ayutaki.chinjufumod.items.hakkou.ItemSakekasu;
import com.ayutaki.chinjufumod.items.hakkou.ItemShouyu_bot_1;
import com.ayutaki.chinjufumod.items.hakkou.ItemShouyu_bot_2;
import com.ayutaki.chinjufumod.items.hakkou.ItemShouyu_bot_3;
import com.ayutaki.chinjufumod.items.hakkou.ItemShouyu_bot_4;
import com.ayutaki.chinjufumod.items.hakkou.ItemShubo;
import com.ayutaki.chinjufumod.items.kitchen.ItemKit_sink;
import com.ayutaki.chinjufumod.items.teatime.ItemChaba;
import com.ayutaki.chinjufumod.items.teatime.ItemDishes;
import com.ayutaki.chinjufumod.items.teatime.ItemDishes_Clay;
import com.ayutaki.chinjufumod.items.teatime.ItemIkaRaw;
import com.ayutaki.chinjufumod.items.teatime.ItemIne;
import com.ayutaki.chinjufumod.items.teatime.ItemKinokoAmakara;
import com.ayutaki.chinjufumod.items.teatime.ItemKomugi;
import com.ayutaki.chinjufumod.items.teatime.ItemMatch;
import com.ayutaki.chinjufumod.items.teatime.ItemPasta;
import com.ayutaki.chinjufumod.items.teatime.ItemShio;
import com.ayutaki.chinjufumod.items.teatime.ItemTTimeInfo;
import com.ayutaki.chinjufumod.items.teatime.ItemToami;
import com.ayutaki.chinjufumod.items.teatime.ItemToami_Wide;
import com.ayutaki.chinjufumod.items.unitblock.ItemTeaTable;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Teatime {

	/* 種・作物 */
	public static Item SEEDSBOX;
	public static Item SEEDS_CABBAGE, SEEDS_HAKUSAI, SEEDS_CORN,
								SEEDS_ONION, SEEDS_RICE, SEEDS_SOY,
								SEEDS_SPINACH, SEEDS_TOMATO, SEEDS_CHERRY;
	public static Item CHANOKI, BUDOUNOKI, MIKAN;
	public static Item HODAGI_BOT;

	public static Item CHABA;
	public static Item INAGI, INEWARA, INE, KOME, SAYA, SOY;

	public static Item FOOD_CABBAGE, FOOD_HAKUSAI, FOOD_CORN,
								FOOD_ONION, FOOD_SPINACH, FOOD_TOMATO,
								FOOD_GRAPE, FOOD_CHERRY, FOOD_MIKAN, FOOD_CORN_B;

	public static Item BOX_H_EMPTY, BOX_H_APPLE, BOX_H_BEEF,
								BOX_H_BEETROOT, BOX_H_BREAD, BOX_H_CARROT,
								BOX_H_CHICKEN, BOX_H_CHORUS, BOX_H_COCO,
								BOX_H_EGG, BOX_H_FISH, BOX_H_FLOUR,
								BOX_H_MUTTON, BOX_H_PORK, BOX_H_POTATO,
								BOX_H_RABBIT, BOX_H_SALMON;

	public static Item BOX_H_CABBAGE, BOX_H_HAKUSAI, BOX_H_CHERRY,
								BOX_H_CITRUS, BOX_H_CORN, BOX_H_GRAPE,
								BOX_H_ONION, BOX_H_RICE, BOX_H_SOY,
								BOX_H_SPINACH, BOX_H_TOMATO, BOX_H_TGREEN, BOX_H_TRED;

	public static Item CHADUTSU, CANTEA, TAWARA;

	/* 発酵 */
	public static Item KOUBOBOT_full, NYUSANBOT_full;
	public static Item KOUBO, NYUSAN;

	public static Item MIZUOKE, MIZUOKE_full, MIZUOKE_Milk;
	public static Item HAKKOUTARU;
	public static Item RINGOSHU_TARU, BUDOUSHU_TARU, HACHIMITSUSHU_TARU;
	public static Item NAMASAKEBOT, SHINSAKEBOT, JUKUSAKEBOT;
	public static Item NABEAMAZAKE_nama, NABEAMAZAKE;
	public static Item CIDERBOT, JUKUCIDERBOT;
	public static Item WINEBOT, JUKUWINEBOT;
	public static Item MEADBOT, JUKUMEADBOT;

	public static Item SAKEGLASS, WINEGLASS;
	public static Item WINE_TANA;

	public static Item HAKUSAI_TARU, SHOUYU_TARU;

	public static Item SHOUYU_bot_1, SHOUYU_bot_2, SHOUYU_bot_3, SHOUYU_bot_4;
	public static Item KOMEZU_bot_1, KOMEZU_bot_2;
	public static Item DASHI_bot_1, DASHI_bot_2, DASHI_bot_3, DASHI_bot_4;

	/* 食器 */
	public static Item Item_MATCH;
	public static Item Item_SARA, Item_DISH, CLAY_DISH;

	/* 中間素材 */
	public static Item SHIO;
	public static Item MUSHIGOME, KOMEKOUJI, SHUBO, MORO, SAKEKASU;
	public static Item NIMAME, MISO;
	public static Item KOMUGI, PASTA;

	/* 調理済み 寸胴→鍋→フライパン */
	public static Item ZUNDOU, ZUNDOU_NAMA, ZUNDOUMIZU, ZUNDOUMILK, ZUNDOUSHIO;
	public static Item CURRYNABE, STEWNABE, DASHINABE;

	public static Item NABE_kara, NABE_NAMA_1, NABE_KAISUI, NABE_NAMA_2;
	public static Item NABETORI, NABEMISO, NABEGOHAN, NABECORNSOUP, NABE_SNT;

	public static Item KEIRYO_CUP, KEIRYO_CUP_F;

	public static Item FRYPAN_kara, FRYPAN_NAMA_1, FRYPAN_NAMA_2, FPKINOKOAK_nama;
	public static Item FRYPAN_BAKE_1, FRYPAN_BAKE_2, FPKINOKOAK;

	public static Item NIBOSHI;
	public static Item CURRY, CURRYSET, STEW;
	public static Item UDON_SU, UDON_NIKU, UDON_TSUKIMI;
	public static Item TONSUITORI, MISOSOUP, GOHAN, RICE;

	public static Item DONBURI_MESHI, DONBURI_GYU, DONBURI_OYAKO, DONBURI_KATSU, DONBURI_KAISEN;

	public static Item FOOD_HAKUSAI2, HAKUSAIDUKE;
	public static Item TAMAGOYAKI, TAMAGOYAKITEI ,YAKIZAKANATEI, YAKIJYAKETEI;
	public static Item CORNSOUP, EGGBURG, EGGBURGSET;

	public static Item PASTATOMATO, PASTACHEESE, PASTAKINOKO;
	public static Item PIZZA, PC_PIZZA, CHICKEN, CHICKEN_small;

	public static Item SUSHIMESHI;
	public static Item SUSHIGETA_kara, SUSHISET_salmon, SUSHISET_fish, SUSHISET_beef, SUSHISET_tamago, SUSHISET_4shoku;
	public static Item SUSHIOKE, SUSHISET_1;
	public static Item SHOUYUSARA;

	public static Item Item_YAKAN_kara, KETTLE_full, Item_YAKAN_boil;
	public static Item KYUSU_kara, KYUSU, JPTEACUP, JPTEASET, JPCHAUKE;
	public static Item TEAPOT_kara, TEAPOT, TEACUP, TEASET;
	public static Item SCONESET_kara, SCONESET_1;

	public static Item ICECREAM;
	public static Item CHEESE_CURD, CHEESE;
	public static Item FRESH_CHEESE, PIECE_CHEESE;
	public static Item CHEESE_TANA;

	public static Item CAKE, BUN, SCONE, SENBEI, TOUFU;
	public static Item CHICKENSAND, EGGSAND;
	public static Item KIRIMI, SUSHI, SHOUYUSUSHI;

	public static Item NORIAMI, NORI_N, NORI_I, ONIGIRI;
	public static Item KUSHI_SAKANA, KUSHI_SAKANA_C;

	public static Item KIT_TANA;
	public static Item KITCHEN, KIT_BOARD, KIT_SINK1, KIT_STOVE, KIT_OVEN, KIT_OVEN_B, IRORI;
	public static Item KIT_KANKI_1, KIT_HAIKIDUCT, KIT_DUCTEND_1;

	public static Item TEATABLE;
	public static Item ENDEN;

	public static Item TOAMI, TOAMI_W;
	public static Item CUT_IKA, COOKED_IKA, IKA;	

	
	/* アイテムのインスタンスを生成 Instantiate items. */
	public static void init() {

		/* 種・作物 */
		SEEDSBOX = new ItemBoxSeeds();
		SEEDS_CABBAGE = new ItemSeedCabbage();
		SEEDS_HAKUSAI = new ItemSeedHakusai();
		SEEDS_CORN = new ItemSeedCorn();
		SEEDS_ONION = new ItemSeedOnion();
		SEEDS_RICE = new ItemSeedRice();
		SEEDS_SOY = new ItemSeedSoy();
		SEEDS_SPINACH = new ItemSeedSpinach();
		SEEDS_TOMATO = new ItemSeedTomato();
		SEEDS_CHERRY = new ItemSeedCherry();
		CHANOKI = new ItemChanoki_nae();
		BUDOUNOKI = new ItemGrape_nae();
		MIKAN = new ItemMikan_nae();
		HODAGI_BOT = new ItemHodaGi_Bot();

		CHABA = new ItemChaba("item_chaba");

		INAGI = new ItemInagi_Bot();
		INEWARA = new ItemTTimeInfo("item_inewara");
		INE = new ItemIne("item_ine");
		KOME = new ItemTTimeInfo("item_kome");
		SAYA = new ItemTTimeInfo("item_saya");
		SOY = new ItemTTimeInfo("item_soy");

		FOOD_CABBAGE = new ItemModFood("item_food_cabbage", 2, 0.3F, false);
		FOOD_HAKUSAI = new ItemModFood("item_food_hakusai", 2, 0.3F, false);
		FOOD_CORN = new ItemModFood("item_food_corn", 1, 0.3F, false);
		FOOD_GRAPE = new ItemModFood("item_food_grape", 1, 0.3F, false);
		FOOD_ONION = new ItemModFood("item_food_onion", 1, 0.3F, false);
		FOOD_SPINACH = new ItemModFood("item_food_spinach", 1, 0.3F, false);
		FOOD_TOMATO = new ItemModFood("item_food_tomato", 1, 0.3F, false);
		FOOD_CHERRY = new ItemFoodCherry("item_food_cherry", 1, 0.3F, false);
		FOOD_MIKAN = new ItemModFood("item_food_mikan", 1, 0.3F, false);
		FOOD_CORN_B = new ItemModFood("item_food_cornb", 5, 0.6F, false);

		BOX_H_EMPTY = new ItemBlock_noFuel(Kitchen_Blocks.BOX_H_EMPTY, "block_boxh_empty");
		BOX_H_APPLE = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_APPLE, "block_boxh_apple");
		BOX_H_BEEF = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_BEEF, "block_boxh_beef");
		BOX_H_BEETROOT = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_BEETROOT, "block_boxh_beetroot");
		BOX_H_BREAD = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_BREAD, "block_boxh_bread");
		BOX_H_CARROT = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CARROT, "block_boxh_carrot");
		BOX_H_CHICKEN = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CHICKEN, "block_boxh_chicken");
		BOX_H_CHORUS = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CHORUS, "block_boxh_chorus");
		BOX_H_COCO = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_COCO, "block_boxh_coco");
		BOX_H_EGG = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_EGG, "block_boxh_egg");
		BOX_H_FISH = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_FISH, "block_boxh_fish");
		BOX_H_FLOUR = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_FLOUR, "block_boxh_flour");
		BOX_H_MUTTON = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_MUTTON, "block_boxh_mutton");
		BOX_H_PORK = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_PORK, "block_boxh_pork");
		BOX_H_POTATO = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_POTATO, "block_boxh_potato");
		BOX_H_RABBIT = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_RABBIT, "block_boxh_rabbit");
		BOX_H_SALMON = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_SALMON, "block_boxh_salmon");

		BOX_H_CABBAGE = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CABBAGE, "block_boxh_cabbage");
		BOX_H_HAKUSAI = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_HAKUSAI, "block_boxh_hakusai");
		BOX_H_CHERRY = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CHERRY, "block_boxh_cherry");
		BOX_H_CITRUS = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CITRUS, "block_boxh_citrus");
		BOX_H_CORN = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_CORN, "block_boxh_corn");
		BOX_H_GRAPE = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_GRAPE, "block_boxh_grape");
		BOX_H_ONION = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_ONION, "block_boxh_onion");
		BOX_H_RICE = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_RICE, "block_boxh_rice");
		BOX_H_SOY = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_SOY, "block_boxh_soy");
		BOX_H_SPINACH = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_SPINACH, "block_boxh_spinach");
		BOX_H_TOMATO = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_TOMATO, "block_boxh_tomato");
		BOX_H_TGREEN = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_TGREEN, "block_boxh_tgreen");
		BOX_H_TRED = new ItemBlock_Fuel100(Kitchen_Blocks.BOX_H_TRED, "block_boxh_tred");

		CHADUTSU = new ItemBlock_noFuel(Kitchen_Blocks.CHADUTSU, Chadutsu.ID);
		CANTEA = new ItemBlock_noFuel(Kitchen_Blocks.CANTEA, CanTea.ID);
		TAWARA = new ItemBlock_Fuel200(Kitchen_Blocks.TAWARA, Tawara.ID);

		/* 発酵 */
		KOUBOBOT_full = new ItemBinKoubo_full();
		NYUSANBOT_full = new ItemBinNyusan_full();
		KOUBO = new ItemBinKoubo();
		NYUSAN = new ItemBinNyusan();

		MIZUOKE = new ItemMizuoke_kara(Blocks.AIR);
		MIZUOKE_full = new ItemMizuoke_full();
		MIZUOKE_Milk = new ItemMizuoke_milk("item_mizuoke_milk");

		HAKKOUTARU = new ItemHakkouTaru();
		RINGOSHU_TARU = new ItemBlock_noFuel(Hakkou_Blocks.RINGOSHU_TARU, TaruY_Ringoshu.ID);
		BUDOUSHU_TARU = new ItemBlock_noFuel(Hakkou_Blocks.BUDOUSHU_TARU, TaruY_Budoushu.ID);
		HACHIMITSUSHU_TARU = new ItemBlock_noFuel(Hakkou_Blocks.HACHIMITSUSHU_TARU, TaruY_Hachimitsushu.ID);

		NAMASAKEBOT = new ItemBlock_noFuel(Hakkou_Blocks.NAMASAKEBOT, Bottle_SakeNama.ID);
		SHINSAKEBOT = new ItemBlock_noFuel(Hakkou_Blocks.SHINSAKEBOT, Bottle_SakeShin.ID);
		JUKUSAKEBOT = new ItemBlock_noFuel(Hakkou_Blocks.JUKUSAKEBOT, Bottle_SakeJuku.ID);
		NABEAMAZAKE_nama = new ItemNabeAmazake_nama();
		NABEAMAZAKE = new ItemBlock_noFuel(Hakkou_Blocks.NABEAMAZAKE, NabeAmazake_cooked.ID);
		CIDERBOT = new ItemBlock_noFuel(Hakkou_Blocks.CIDERBOT, Bottle_Cider.ID);
		JUKUCIDERBOT = new ItemBlock_noFuel(Hakkou_Blocks.JUKUCIDERBOT, Bottle_CiderJuku.ID);
		WINEBOT = new ItemBlock_noFuel(Hakkou_Blocks.WINEBOT, Bottle_Wine.ID);
		JUKUWINEBOT = new ItemBlock_noFuel(Hakkou_Blocks.JUKUWINEBOT, Bottle_WineJuku.ID);
		MEADBOT = new ItemBlock_noFuel(Hakkou_Blocks.MEADBOT, Bottle_Mead.ID);
		JUKUMEADBOT = new ItemBlock_noFuel(Hakkou_Blocks.JUKUMEADBOT, Bottle_MeadJuku.ID);

		SAKEGLASS = new ItemGlass_Sake();
		WINEGLASS = new ItemGlass_Wine();
		WINE_TANA = new ItemBlock_Fuel300(Kitchen_Blocks.WINE_TANA, Kit_Tana2.ID);
		HAKUSAI_TARU = new ItemHakkouTaru_Hakusai();
		SHOUYU_TARU = new ItemHakkouTaru_Shouyu();

		SHOUYU_bot_1 = new ItemShouyu_bot_1();
		SHOUYU_bot_2 = new ItemShouyu_bot_2();
		SHOUYU_bot_3 = new ItemShouyu_bot_3();
		SHOUYU_bot_4 = new ItemShouyu_bot_4();

		KOMEZU_bot_1 = new ItemKomezu_bot_1();
		KOMEZU_bot_2 = new ItemKomezu_bot_2();

		DASHI_bot_1 = new ItemDashi_bot_1();
		DASHI_bot_2 = new ItemDashi_bot_2();
		DASHI_bot_3 = new ItemDashi_bot_3();
		DASHI_bot_4 = new ItemDashi_bot_4();

		/* 食器 */
		Item_MATCH = new ItemMatch("item_match_cm");
		Item_SARA = new ItemTTimeInfo("item_food_sara");
		Item_DISH = new ItemDishes().setRegistryName("item_food_dish");
		CLAY_DISH = new ItemDishes_Clay().setRegistryName("item_clay_dish");

		/* 中間素材 */
		SHIO = new ItemShio("item_salt");

		MUSHIGOME = new ItemMushigome("item_mushigome");
		KOMEKOUJI = new ItemTTimeInfo("item_komekouji");
		SHUBO = new ItemShubo("item_shubo");
		MORO = new ItemMoromi("item_moromi");
		SAKEKASU = new ItemSakekasu("item_sakekasu");

		NIMAME = new ItemNimame("item_nimame");
		MISO = new ItemTTimeInfo("item_miso");

		KOMUGI = new ItemKomugi("item_komugi");
		PASTA = new ItemPasta("item_pasta");

		/* 調理済み 寸胴→鍋→フライパン */
		ZUNDOU = new ItemZundou();
		ZUNDOU_NAMA = new ItemZundou_Nama();
		ZUNDOUMIZU = new ItemZundou_Mizu();
		ZUNDOUMILK = new ItemZundou_Milk();
		ZUNDOUSHIO = new ItemZundou_ShioMizu();
		CURRYNABE = new ItemCurryNabe();
		STEWNABE = new ItemStewNabe();
		DASHINABE = new ItemZundou_Dashi();

		NABE_kara = new ItemNabe_kara(Blocks.AIR);
		NABE_NAMA_1 = new ItemNabeNama_1();
		NABE_KAISUI = new ItemNabeKaisui();
		NABE_NAMA_2 = new ItemNabeNama_2();
		NABETORI = new ItemNabeTori();
		NABEMISO = new ItemNabeMiso();
		NABEGOHAN = new ItemNabeGohan();
		NABECORNSOUP = new ItemNabeCornSoup();
		NABE_SNT = new ItemNabeCooked_SNT();

		KEIRYO_CUP = new ItemKeiryoCup();
		KEIRYO_CUP_F = new ItemKeiryoCup_full();

		FRYPAN_kara = new ItemFryPan_kara();
		FRYPAN_NAMA_1 = new ItemFrypan_Nama_1();
		FRYPAN_NAMA_2 = new ItemFrypan_Nama_2();
		FPKINOKOAK_nama = new ItemBlock_noFuel(Dish_Blocks.FPKINOKOAK_nama, Frypan_KinokoAmaKara.ID);
		FRYPAN_BAKE_1 = new ItemFrypan_Bake_1();
		FRYPAN_BAKE_2 = new ItemFrypan_Bake_2();
		FPKINOKOAK = new ItemKinokoAmakara("item_food_frypan_b_kinokoak");

		NIBOSHI = new ItemFish_boiled();
		CURRY = new ItemCurry(10, 1.0F, false);
		CURRYSET = new ItemCurrySet();
		STEW = new ItemStew(8, 0.6F, false);

		UDON_SU = new ItemUdon_Su(5, 0.6F, false);
		UDON_NIKU = new ItemUdon_Niku(10, 0.8F, false);
		UDON_TSUKIMI = new ItemUdon_Tsukimi(10, 0.8F, false);

		TONSUITORI = new ItemTonsui_small(2, 0.5F, false);
		MISOSOUP = new ItemMisoSoup_small(2, 0.3F, false);
		GOHAN = new ItemGohan_small(3, 0.6F, false);
		RICE = new ItemRice_small(3, 0.6F, false);

		DONBURI_MESHI = new ItemDon_Meshi(5, 0.6F, false);
		DONBURI_GYU = new ItemDon_Gyu(10, 0.8F, false);
		DONBURI_OYAKO = new ItemDon_Oyako(10, 0.8F, false);
		DONBURI_KATSU = new ItemDon_Katsu(10, 1.0F, false);
		DONBURI_KAISEN = new ItemDon_Kaisen(10, 0.8F, false);
		
		FOOD_HAKUSAI2 = new ItemModFood("item_food_hakusai2", 2, 0.6F, false);
		HAKUSAIDUKE = new ItemHakusaiduke(1, 0.2F, false);

		TAMAGOYAKI = new ItemTamagoyaki_small(3, 0.5F, false);
		TAMAGOYAKITEI = new ItemTamagoyakiSet();
		YAKIZAKANATEI = new ItemYakizakanaSet();
		YAKIJYAKETEI = new ItemYakijyakeSet();

		CORNSOUP = new ItemCornSoup_small(2, 0.3F, false);
		EGGBURG = new ItemEggburg_small(5, 0.6F, false);
		EGGBURGSET = new ItemEggburgSet();

		PASTATOMATO = new ItemPastaTomato(10, 0.8F, false);
		PASTACHEESE = new ItemPastaCheese(10, 0.8F, false);
		PASTAKINOKO = new ItemPastaKinoko(10, 0.8F, false);

		PIZZA = new ItemPizza_coocked();
		PC_PIZZA = new ItemFoodPizza("item_food_pizza", 6, 0.6F, false);
		CHICKEN = new ItemChicken_large();
		CHICKEN_small = new ItemChicken_small(3, 0.5F, false);

		SUSHIMESHI = new ItemSushiMeshi();
		SUSHIGETA_kara = new ItemSushiGeta_kara();
		SUSHISET_salmon = new ItemSushiSet_Salmon();
		SUSHISET_fish = new ItemSushiSet_Fish();
		SUSHISET_beef = new ItemSushiSet_Beef();
		SUSHISET_tamago = new ItemSushiSet_Tamago();
		SUSHISET_4shoku = new ItemSushiSet_4shoku();
		SUSHIOKE = new ItemSushiOke_kara();
		SUSHISET_1 = new ItemSushiOkeFull_1();
		SHOUYUSARA = new ItemShouyuSara();

		Item_YAKAN_kara = new ItemKettle_kara();
		KETTLE_full = new ItemKettle_full();
		Item_YAKAN_boil = new ItemKettle_boil();
		KYUSU_kara = new ItemKyusu_kara();
		KYUSU = new ItemKyusu();
		JPTEACUP = new ItemJPTeaCup(); //drink
		JPTEASET = new ItemJPTeaSet();
		JPCHAUKE = new ItemJPChaUke();

		TEAPOT_kara = new ItemTeaPot_kara();
		TEAPOT = new ItemTeaPot();
		TEACUP = new ItemTeaCup(); //drink
		TEASET = new ItemTeaSet();
		SCONESET_kara = new ItemSconeSet_kara();
		SCONESET_1 = new ItemSconeSet_1();

		ICECREAM = new ItemIcecream(0, 0.0F, false);

		CHEESE_CURD = new ItemCheese_curd();
		CHEESE = new ItemCheese_block();

		/*バニラの食料
		registerItem(260, "apple", (new ItemFood(4, 0.3F, false)).setUnlocalizedName("apple"));
		registerItem(391, "carrot", (new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).setUnlocalizedName("carrots"));

		registerItem(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).setUnlocalizedName("potato"));
		registerItem(393, "baked_potato", (new ItemFood(5, 0.6F, false)).setUnlocalizedName("potatoBaked"));

		registerItem(297, "bread", (new ItemFood(5, 0.6F, false)).setUnlocalizedName("bread"));
		5＝肉メモリ2.5個分
		registerItem(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).setUnlocalizedName("beefCooked"));
		registerItem(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).setUnlocalizedName("chickenCooked"));*/

		FRESH_CHEESE = new ItemModFood("item_food_cheesef", 1, 0.3F, false);
		PIECE_CHEESE = new ItemFoodCheese("item_food_cheese", 1, 0.3F, false);
		CHEESE_TANA = new ItemBlock_Fuel150(Kitchen_Blocks.CHEESE_TANA, Kit_Cheese_Tana.ID);

		CAKE = new ItemModFood("item_food_cake", 5, 0.4F, false);
		BUN = new ItemModFood("item_food_bun", 6, 0.4F, false);
		SCONE = new ItemModFood("item_food_scone", 4, 0.3F, false);
		SENBEI = new ItemSenbei("item_food_senbei", 4, 0.3F, false);
		TOUFU = new ItemModFood("item_food_toufu", 4, 0.3F, false);

		CHICKENSAND = new ItemModFood("item_food_chickensand", 6, 0.6F, false);
		EGGSAND = new ItemModFood("item_food_eggsand", 6, 0.6F, false);
		KIRIMI = new ItemFoodKirimi("item_food_kirimi", 1, 0.1F, false);
		SUSHI = new ItemFoodSushi("item_food_sushi", 4, 0.6F, false);
		SHOUYUSUSHI = new ItemFoodSushi_Shouyu("item_food_sushishouyu", 5, 0.8F, false);

		NORIAMI = new ItemBlock_noFuel(Crop_Blocks.NORIAMI, NoriAmi.ID);
		NORI_N = new ItemTTimeInfo("item_food_norinama");
		NORI_I = new ItemModFood("item_food_noriita", 1, 0.1F, false);
		ONIGIRI = new ItemFoodOnigiri("item_food_onigiri", 4, 0.6F, false);

		KUSHI_SAKANA = new ItemTTimeInfo("item_kushi_sakana");
		KUSHI_SAKANA_C = new ItemFoodKushiSakana("item_kushi_sakana_c", 5, 0.8F, false);

		KIT_TANA = new ItemBlock_Fuel150(Kitchen_Blocks.KIT_TANA, Kit_Tana.ID);
		KITCHEN = new ItemBlock_Fuel150(Kitchen_Blocks.KITCHEN, Kitchen.ID);

		KIT_BOARD = new ItemBlock_Fuel300(Kitchen_Blocks.KIT_BOARD, Kit_board.ID);
		KIT_SINK1 = new ItemKit_sink();

		KIT_STOVE = new ItemBlock_noFuel(Kitchen_Blocks.KIT_STOVE, Kit_Cooktop_off.ID);
		KIT_OVEN = new ItemBlock_noFuel(Kitchen_Blocks.KIT_OVEN, "block_kit_oven");
		KIT_OVEN_B = new ItemBlock_noFuel(Kitchen_Blocks.KIT_OVEN_B, "block_kit_oven_black");
		IRORI = new ItemBlock_noFuel(Kitchen_Blocks.IRORI, Irori.ID);

		KIT_KANKI_1 = new ItemBlock_noFuel(Kitchen_Blocks.KIT_KANKI_1, Kit_kanki_off.ID);
		KIT_HAIKIDUCT = new ItemBlock_noFuel(Kitchen_Blocks.KIT_HAIKIDUCT, Kit_duct.ID);
		KIT_DUCTEND_1 = new ItemBlock_noFuel(Kitchen_Blocks.KIT_DUCTEND_1, Kit_ductend.ID);

		TEATABLE = new ItemTeaTable();
		ENDEN = new ItemEnden();
		
		TOAMI = new ItemToami("item_toami");
		TOAMI_W = new ItemToami_Wide(Crop_Blocks.TOAMI_W, Toami_Wide.ID);
		CUT_IKA = new ItemModFood("item_squid_cut", 2, 0.1F, false);
		COOKED_IKA = new ItemModFood("item_squid_cooked", 6, 0.8F, false);
		IKA = new ItemIkaRaw("item_squid_raw");

	}

	/* アイテムを登録する、ここから Register Items. From here. ↓*/
	public static void register() {

		registerItem(SEEDSBOX);
		registerItem(SEEDS_CABBAGE);
		registerItem(SEEDS_HAKUSAI);
		registerItem(SEEDS_CORN);
		registerItem(SEEDS_ONION);
		registerItem(SEEDS_RICE);
		registerItem(SEEDS_SOY);
		registerItem(SEEDS_SPINACH);
		registerItem(SEEDS_TOMATO);
		registerItem(SEEDS_CHERRY);
		registerItem(CHANOKI);
		registerItem(BUDOUNOKI);
		registerItem(MIKAN);
		registerItem(HODAGI_BOT);

		registerItem(CHABA);
		registerItem(INAGI);
		registerItem(INEWARA);
		registerItem(INE);
		registerItem(KOME);
		registerItem(SAYA);
		registerItem(SOY);

		registerItem(FOOD_CABBAGE);
		registerItem(FOOD_HAKUSAI);
		registerItem(FOOD_CORN);
		registerItem(FOOD_ONION);
		registerItem(FOOD_SPINACH);
		registerItem(FOOD_TOMATO);
		registerItem(FOOD_GRAPE);
		registerItem(FOOD_CHERRY);
		registerItem(FOOD_MIKAN);
		registerItem(FOOD_CORN_B);

		registerItem(BOX_H_EMPTY);
		registerItem(BOX_H_APPLE);
		registerItem(BOX_H_BEEF);
		registerItem(BOX_H_BEETROOT);
		registerItem(BOX_H_BREAD);
		registerItem(BOX_H_CARROT);
		registerItem(BOX_H_CHICKEN);
		registerItem(BOX_H_CHORUS);
		registerItem(BOX_H_COCO);
		registerItem(BOX_H_EGG);
		registerItem(BOX_H_FISH);
		registerItem(BOX_H_FLOUR);
		registerItem(BOX_H_MUTTON);
		registerItem(BOX_H_PORK);
		registerItem(BOX_H_POTATO);
		registerItem(BOX_H_RABBIT);
		registerItem(BOX_H_SALMON);

		registerItem(BOX_H_CABBAGE);
		registerItem(BOX_H_HAKUSAI);
		registerItem(BOX_H_CHERRY);
		registerItem(BOX_H_CITRUS);
		registerItem(BOX_H_CORN);
		registerItem(BOX_H_GRAPE);
		registerItem(BOX_H_ONION);
		registerItem(BOX_H_RICE);
		registerItem(BOX_H_SOY);
		registerItem(BOX_H_SPINACH);
		registerItem(BOX_H_TOMATO);
		registerItem(BOX_H_TGREEN);
		registerItem(BOX_H_TRED);

		registerItem(CHADUTSU);
		registerItem(CANTEA);
		registerItem(TAWARA);

		registerItem(KOUBOBOT_full);
		registerItem(NYUSANBOT_full);
		registerItem(KOUBO);
		registerItem(NYUSAN);

		registerItem(MIZUOKE);
		registerItem(MIZUOKE_full);
		registerItem(MIZUOKE_Milk);

		registerItem(HAKKOUTARU);
		registerItem(RINGOSHU_TARU);
		registerItem(BUDOUSHU_TARU);
		registerItem(HACHIMITSUSHU_TARU);

		registerItem(NAMASAKEBOT);
		registerItem(SHINSAKEBOT);
		registerItem(JUKUSAKEBOT);
		registerItem(NABEAMAZAKE_nama);
		registerItem(NABEAMAZAKE);
		registerItem(CIDERBOT);
		registerItem(JUKUCIDERBOT);
		registerItem(WINEBOT);
		registerItem(JUKUWINEBOT);
		registerItem(MEADBOT);
		registerItem(JUKUMEADBOT);

		registerItem(SAKEGLASS);
		registerItem(WINEGLASS);
		registerItem(WINE_TANA);

		registerItem(HAKUSAI_TARU);
		registerItem(SHOUYU_TARU);

		registerItem(SHOUYU_bot_1);
		registerItem(SHOUYU_bot_2);
		registerItem(SHOUYU_bot_3);
		registerItem(SHOUYU_bot_4);

		registerItem(KOMEZU_bot_1);
		registerItem(KOMEZU_bot_2);

		registerItem(DASHI_bot_1);
		registerItem(DASHI_bot_2);
		registerItem(DASHI_bot_3);
		registerItem(DASHI_bot_4);

		registerItem(Item_MATCH);
		registerItem(Item_SARA);
		registerItem(Item_DISH);
		registerItem(CLAY_DISH);

		registerItem(SHIO);

		registerItem(MUSHIGOME);
		registerItem(KOMEKOUJI);
		registerItem(SHUBO);
		registerItem(MORO);
		registerItem(SAKEKASU);

		registerItem(NIMAME);
		registerItem(MISO);

		registerItem(KOMUGI);
		registerItem(PASTA);

		registerItem(ZUNDOU);
		registerItem(ZUNDOU_NAMA);
		registerItem(ZUNDOUMIZU);
		registerItem(ZUNDOUMILK);
		registerItem(ZUNDOUSHIO);
		registerItem(CURRYNABE);
		registerItem(STEWNABE);
		registerItem(DASHINABE);

		registerItem(NABE_kara);
		registerItem(NABE_NAMA_1);
		registerItem(NABE_KAISUI);
		registerItem(NABE_NAMA_2);
		registerItem(NABETORI);
		registerItem(NABEMISO);
		registerItem(NABEGOHAN);
		registerItem(NABECORNSOUP);
		registerItem(NABE_SNT);

		registerItem(KEIRYO_CUP);
		registerItem(KEIRYO_CUP_F);

		registerItem(FRYPAN_kara);
		registerItem(FRYPAN_NAMA_1);
		registerItem(FRYPAN_NAMA_2);
		registerItem(FPKINOKOAK_nama);
		registerItem(FRYPAN_BAKE_1);
		registerItem(FRYPAN_BAKE_2);
		registerItem(FPKINOKOAK);

		registerItem(NIBOSHI);
		registerItem(CURRY);
		registerItem(CURRYSET);
		registerItem(STEW);

		registerItem(UDON_SU);
		registerItem(UDON_NIKU);
		registerItem(UDON_TSUKIMI);

		registerItem(TONSUITORI);
		registerItem(MISOSOUP);
		registerItem(GOHAN);
		registerItem(RICE);

		registerItem(DONBURI_MESHI);
		registerItem(DONBURI_GYU);
		registerItem(DONBURI_OYAKO);
		registerItem(DONBURI_KATSU);
		registerItem(DONBURI_KAISEN);
		
		registerItem(FOOD_HAKUSAI2);
		registerItem(HAKUSAIDUKE);

		registerItem(TAMAGOYAKI);
		registerItem(TAMAGOYAKITEI);
		registerItem(YAKIZAKANATEI);
		registerItem(YAKIJYAKETEI);

		registerItem(CORNSOUP);
		registerItem(EGGBURG);
		registerItem(EGGBURGSET);

		registerItem(PASTATOMATO);
		registerItem(PASTACHEESE);
		registerItem(PASTAKINOKO);

		registerItem(PIZZA);
		registerItem(PC_PIZZA);
		registerItem(CHICKEN);
		registerItem(CHICKEN_small);

		registerItem(SUSHIMESHI);
		registerItem(SUSHIGETA_kara);
		registerItem(SUSHISET_salmon);
		registerItem(SUSHISET_fish);
		registerItem(SUSHISET_beef);
		registerItem(SUSHISET_tamago);
		registerItem(SUSHISET_4shoku);
		registerItem(SUSHIOKE);
		registerItem(SUSHISET_1);
		registerItem(SHOUYUSARA);

		registerItem(Item_YAKAN_kara);
		registerItem(KETTLE_full);
		registerItem(Item_YAKAN_boil);
		registerItem(KYUSU_kara);
		registerItem(KYUSU);
		registerItem(JPTEACUP);
		registerItem(JPTEASET);
		registerItem(JPCHAUKE);

		registerItem(TEAPOT_kara);
		registerItem(TEAPOT);
		registerItem(TEACUP);
		registerItem(TEASET);
		registerItem(SCONESET_kara);
		registerItem(SCONESET_1);

		registerItem(ICECREAM);

		registerItem(CHEESE_CURD);
		registerItem(CHEESE);
		registerItem(FRESH_CHEESE);
		registerItem(PIECE_CHEESE);
		registerItem(CHEESE_TANA);

		registerItem(CAKE);
		registerItem(BUN);
		registerItem(SCONE);
		registerItem(SENBEI);
		registerItem(TOUFU);
		registerItem(CHICKENSAND);
		registerItem(EGGSAND);
		registerItem(KIRIMI);
		registerItem(SUSHI);
		registerItem(SHOUYUSUSHI);

		registerItem(NORIAMI);
		registerItem(NORI_N);
		registerItem(NORI_I);
		registerItem(ONIGIRI);

		registerItem(KUSHI_SAKANA);
		registerItem(KUSHI_SAKANA_C);

		registerItem(KIT_TANA);
		registerItem(KITCHEN);
		registerItem(KIT_BOARD);
		registerItem(KIT_SINK1);
		registerItem(KIT_STOVE);
		registerItem(KIT_OVEN);
		registerItem(KIT_OVEN_B);
		registerItem(IRORI);
		registerItem(KIT_KANKI_1);
		registerItem(KIT_HAIKIDUCT);
		registerItem(KIT_DUCTEND_1);

		registerItem(TEATABLE);
		registerItem(ENDEN);
		
		registerItem(TOAMI);
		registerItem(TOAMI_W);
		registerItem(CUT_IKA);
		registerItem(COOKED_IKA);
		registerItem(IKA);
		
		/** registerItem の順番に沿って、registerRenders が表示される **/
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}
	/*ここまで So far↑ */


	/* ドロップ時やインベントリにおける、アイテムの描画を登録。ここから↓
	* Register rendering of Items in drop and inventory. From here↓*/
	public static void registerRenders() {
		registerRender(SEEDSBOX);
		registerRender(SEEDS_CABBAGE);
		registerRender(SEEDS_HAKUSAI);
		registerRender(SEEDS_CORN);
		registerRender(SEEDS_ONION);
		registerRender(SEEDS_RICE);
		registerRender(SEEDS_SOY);
		registerRender(SEEDS_SPINACH);
		registerRender(SEEDS_TOMATO);
		registerRender(SEEDS_CHERRY);
		registerRender(CHANOKI);
		registerRender(BUDOUNOKI);
		registerRender(MIKAN);
		registerRender(HODAGI_BOT);

		registerRenderMeta(CHABA, 0, "item_chaba");
		registerRenderMeta(CHABA, 1, "item_chaba_green");
		registerRenderMeta(CHABA, 2, "item_chaba_red");
		registerRender(INAGI);
		registerRender(INEWARA);
		registerRenderMeta(INE, 0, "item_ine");
		registerRenderMeta(INE, 1, "item_ine_dry");
		registerRender(KOME);
		registerRender(SAYA);
		registerRender(SOY);

		registerRender(FOOD_CABBAGE);
		registerRender(FOOD_HAKUSAI);
		registerRender(FOOD_CORN);
		registerRender(FOOD_ONION);
		registerRender(FOOD_SPINACH);
		registerRender(FOOD_TOMATO);
		registerRender(FOOD_GRAPE);
		registerRender(FOOD_CHERRY);
		registerRender(FOOD_MIKAN);
		registerRender(FOOD_CORN_B);

		registerRender(BOX_H_EMPTY);
		registerRender(BOX_H_APPLE);
		registerRender(BOX_H_BEEF);
		registerRender(BOX_H_BEETROOT);
		registerRender(BOX_H_BREAD);
		registerRender(BOX_H_CARROT);
		registerRender(BOX_H_CHICKEN);
		registerRender(BOX_H_CHORUS);
		registerRender(BOX_H_COCO);
		registerRender(BOX_H_EGG);
		registerRender(BOX_H_FISH);
		registerRender(BOX_H_FLOUR);
		registerRender(BOX_H_MUTTON);
		registerRender(BOX_H_PORK);
		registerRender(BOX_H_POTATO);
		registerRender(BOX_H_RABBIT);
		registerRender(BOX_H_SALMON);

		registerRender(BOX_H_CABBAGE);
		registerRender(BOX_H_HAKUSAI);
		registerRender(BOX_H_CHERRY);
		registerRender(BOX_H_CITRUS);
		registerRender(BOX_H_CORN);
		registerRender(BOX_H_GRAPE);
		registerRender(BOX_H_ONION);
		registerRender(BOX_H_RICE);
		registerRender(BOX_H_SOY);
		registerRender(BOX_H_SPINACH);
		registerRender(BOX_H_TOMATO);
		registerRender(BOX_H_TGREEN);
		registerRender(BOX_H_TRED);

		registerRender(CHADUTSU);
		registerRender(CANTEA);
		registerRender(TAWARA);

		registerRender(KOUBOBOT_full);
		registerRender(NYUSANBOT_full);
		registerRender(KOUBO);
		registerRender(NYUSAN);

		registerRender(MIZUOKE);
		registerRender(MIZUOKE_full);
		registerRender(MIZUOKE_Milk);

		registerRenderMeta(HAKKOUTARU, 0, "block_taru_hakkou");
		registerRenderMeta(HAKKOUTARU, 1, "block_taru_kouji_f");
		registerRenderMeta(HAKKOUTARU, 2, "block_taru_shubo_f");
		registerRenderMeta(HAKKOUTARU, 3, "block_taru_moromi_f");
		registerRenderMeta(HAKKOUTARU, 4, "block_taru_jukusei_f");
		registerRender(RINGOSHU_TARU);
		registerRender(BUDOUSHU_TARU);
		registerRender(HACHIMITSUSHU_TARU);

		registerRender(NAMASAKEBOT);
		registerRender(SHINSAKEBOT);
		registerRender(JUKUSAKEBOT);
		registerRender(NABEAMAZAKE_nama);
		registerRender(NABEAMAZAKE);
		registerRender(CIDERBOT);
		registerRender(JUKUCIDERBOT);
		registerRender(WINEBOT);
		registerRender(JUKUWINEBOT);
		registerRender(MEADBOT);
		registerRender(JUKUMEADBOT);

		registerRenderMeta(SAKEGLASS, 1, "block_glass_sakenama");
		registerRenderMeta(SAKEGLASS, 2, "block_glass_sake");
		registerRenderMeta(SAKEGLASS, 3, "block_glass_sakejuku");
		registerRenderMeta(SAKEGLASS, 4, "block_glass_amazake");
		registerRenderMeta(WINEGLASS, 1, "block_glass_wine");
		registerRenderMeta(WINEGLASS, 2, "block_glass_winejuku");
		registerRenderMeta(WINEGLASS, 3, "block_glass_cider");
		registerRenderMeta(WINEGLASS, 4, "block_glass_ciderjuku");
		registerRenderMeta(WINEGLASS, 5, "block_glass_mead");
		registerRenderMeta(WINEGLASS, 6, "block_glass_meadjuku");
		registerRender(WINE_TANA);

		registerRenderMeta(HAKKOUTARU, 5, "block_taru_miso_f");
		registerRenderMeta(HAKUSAI_TARU, 1, "block_taru_hakusai_f");
		registerRenderMeta(HAKUSAI_TARU, 2, "block_taru_hakusai_f2");

		registerRenderMeta(SHOUYU_TARU, 1, "block_taru_shouyu_f");
		registerRenderMeta(SHOUYU_TARU, 2, "block_taru_komezu_f");
		registerRenderMeta(SHOUYU_TARU, 3, "block_taru_kinoko_f");
		registerRenderMeta(SHOUYU_TARU, 4, "block_taru_nori_f");
		registerRenderMeta(HAKKOUTARU, 6, "block_taru_koucha_f");

		registerRender(SHOUYU_bot_1);
		registerRender(SHOUYU_bot_2);
		registerRender(SHOUYU_bot_3);
		registerRender(SHOUYU_bot_4);

		registerRender(KOMEZU_bot_1);
		registerRender(KOMEZU_bot_2);

		registerRender(DASHI_bot_1);
		registerRender(DASHI_bot_2);
		registerRender(DASHI_bot_3);
		registerRender(DASHI_bot_4);

		registerRender(Item_MATCH);
		registerRender(Item_SARA);
		registerRenderMeta(Item_DISH, 1, "item_food_yunomi");
		registerRenderMeta(Item_DISH, 2, "item_food_teacup");
		registerRenderMeta(Item_DISH, 3, "item_food_chawan");
		registerRenderMeta(Item_DISH, 4, "item_food_shikki");
		registerRenderMeta(Item_DISH, 5, "item_food_tonsui");
		registerRenderMeta(Item_DISH, 6, "item_food_donburi");
		registerRenderMeta(Item_DISH, 7, "item_food_driglass");
		registerRenderMeta(Item_DISH, 8, "item_food_sakebot");

		registerRenderMeta(CLAY_DISH, 1, "item_clay_sara");
		registerRenderMeta(CLAY_DISH, 2, "item_clay_yunomi");
		registerRenderMeta(CLAY_DISH, 3, "item_clay_kyusu");
		registerRenderMeta(CLAY_DISH, 4, "item_clay_teacup");
		registerRenderMeta(CLAY_DISH, 5, "item_clay_teapot");
		registerRenderMeta(CLAY_DISH, 6, "item_clay_chawan");
		registerRenderMeta(CLAY_DISH, 7, "item_clay_nabe");
		registerRenderMeta(CLAY_DISH, 8, "item_clay_tonsui");
		registerRenderMeta(CLAY_DISH, 9, "item_clay_donburi");

		registerRenderMeta(SHIO, 0, "item_salt");
		registerRenderMeta(SHIO, 1, "item_nigari");
		registerRenderMeta(SHIO, 2, "item_rennet");

		registerRender(MUSHIGOME);
		registerRender(KOMEKOUJI);
		registerRender(SHUBO);
		registerRender(MORO);
		registerRender(SAKEKASU);

		registerRender(NIMAME);
		registerRender(MISO);

		registerRenderMeta(KOMUGI, 1, "item_flour");
		registerRenderMeta(KOMUGI, 2, "item_butter");
		registerRenderMeta(KOMUGI, 3, "item_kiji_bun");
		registerRenderMeta(KOMUGI, 4, "item_kiji_burg");
		registerRenderMeta(KOMUGI, 5, "item_kiji_scone");
		registerRenderMeta(KOMUGI, 6, "item_kiji_senbei");
		registerRenderMeta(KOMUGI, 7, "item_kiji_pizza");
		registerRenderMeta(KOMUGI, 8, "item_food_pizza_n");

		registerRenderMeta(PASTA, 1, "item_food_pasta_n");
		registerRenderMeta(PASTA, 2, "item_food_pasta_s");
		registerRenderMeta(PASTA, 3, "item_food_udon_n");
		registerRenderMeta(PASTA, 4, "item_food_shouyu_don");
		registerRenderMeta(PASTA, 5, "item_food_tsuyu_don");

		registerRender(ZUNDOU);
		registerRenderMeta(ZUNDOU_NAMA, 2, "block_food_cunabe_n");
		registerRenderMeta(ZUNDOU_NAMA, 3, "block_food_stewnabe_n");
		registerRender(ZUNDOUMIZU);
		registerRender(ZUNDOUMILK);
		registerRender(ZUNDOUSHIO);
		registerRender(CURRYNABE);
		registerRender(STEWNABE);
		registerRender(DASHINABE);

		registerRender(NABE_kara);
		registerRenderMeta(NABE_NAMA_1, 1, "block_food_nabe_n");
		registerRenderMeta(NABE_NAMA_1, 2, "block_food_nabemiso_n");
		registerRenderMeta(NABE_NAMA_1, 3, "block_food_nabegohan_n");
		registerRenderMeta(NABE_NAMA_1, 4, "block_food_nabecorns_n");

		registerRender(NABE_KAISUI);
		registerRenderMeta(NABE_NAMA_2, 2, "block_food_nabenimame_n");
		registerRenderMeta(NABE_NAMA_2, 3, "block_food_nabetoufu_n");

		registerRender(NABETORI);
		registerRender(NABEMISO);
		registerRender(NABEGOHAN);
		registerRender(NABECORNSOUP);

		registerRenderMeta(NABE_SNT, 1, "block_food_nabeshio_b");
		registerRenderMeta(NABE_SNT, 2, "block_food_nabenimame_b");
		registerRenderMeta(NABE_SNT, 3, "block_food_nabetoufu_b");

		registerRender(KEIRYO_CUP);
		registerRender(KEIRYO_CUP_F);

		registerRender(FRYPAN_kara);
		registerRenderMeta(FRYPAN_NAMA_1, 1, "block_food_frypan_n_tamago");
		registerRenderMeta(FRYPAN_NAMA_1, 2, "block_food_frypan_n_eggb");
		registerRenderMeta(FRYPAN_NAMA_1, 3, "block_food_frypan_n_tomatos");
		registerRenderMeta(FRYPAN_NAMA_1, 4, "block_food_frypan_n_kinokos");

		registerRenderMeta(FRYPAN_NAMA_2, 1, "block_food_frypan_n_gyudon");
		registerRenderMeta(FRYPAN_NAMA_2, 2, "block_food_frypan_n_oyakodon");
		registerRenderMeta(FRYPAN_NAMA_2, 3, "block_food_frypan_n_katsu");
		registerRenderMeta(FRYPAN_NAMA_2, 4, "block_food_frypan_n_katsudon");
		registerRender(FPKINOKOAK_nama);

		registerRenderMeta(FRYPAN_BAKE_1, 1, "block_food_frypan_b_tamago");
		registerRenderMeta(FRYPAN_BAKE_1, 2, "block_food_frypan_b_eggb");
		registerRenderMeta(FRYPAN_BAKE_1, 3, "block_food_frypan_b_tomatos");
		registerRenderMeta(FRYPAN_BAKE_1, 4, "block_food_frypan_b_kinokos");

		registerRenderMeta(FRYPAN_BAKE_2, 1, "block_food_frypan_b_gyudon");
		registerRenderMeta(FRYPAN_BAKE_2, 2, "block_food_frypan_b_oyakodon");
		registerRenderMeta(FRYPAN_BAKE_2, 3, "block_food_frypan_b_katsu");
		registerRenderMeta(FRYPAN_BAKE_2, 4, "block_food_frypan_b_katsudon");
		registerRender(FPKINOKOAK);

		registerRender(NIBOSHI);
		registerRender(CURRY);
		registerRender(CURRYSET);
		registerRender(STEW);

		registerRender(UDON_SU);
		registerRender(UDON_NIKU);
		registerRender(UDON_TSUKIMI);

		registerRender(TONSUITORI);
		registerRender(MISOSOUP);
		registerRender(GOHAN);
		registerRender(RICE);

		registerRender(DONBURI_MESHI);
		registerRender(DONBURI_GYU);
		registerRender(DONBURI_OYAKO);
		registerRender(DONBURI_KATSU);
		registerRender(DONBURI_KAISEN);
		
		registerRender(FOOD_HAKUSAI2);
		registerRender(HAKUSAIDUKE);

		registerRender(TAMAGOYAKI);
		registerRender(TAMAGOYAKITEI);
		registerRender(YAKIZAKANATEI);
		registerRender(YAKIJYAKETEI);

		registerRender(CORNSOUP);
		registerRender(EGGBURG);
		registerRender(EGGBURGSET);

		registerRender(PASTATOMATO);
		registerRender(PASTACHEESE);
		registerRender(PASTAKINOKO);

		registerRender(PIZZA);
		registerRender(PC_PIZZA);
		registerRender(CHICKEN);
		registerRender(CHICKEN_small);

		registerRender(SUSHIMESHI);
		registerRender(SUSHIGETA_kara);
		registerRender(SUSHISET_salmon);
		registerRender(SUSHISET_fish);
		registerRender(SUSHISET_beef);
		registerRender(SUSHISET_tamago);
		registerRender(SUSHISET_4shoku);
		registerRender(SUSHIOKE);
		registerRender(SUSHISET_1);
		registerRender(SHOUYUSARA);

		registerRender(Item_YAKAN_kara);
		registerRender(KETTLE_full);
		registerRender(Item_YAKAN_boil);
		registerRender(KYUSU_kara);
		registerRender(KYUSU);
		registerRender(JPTEACUP);
		registerRender(JPTEASET);
		registerRenderMeta(JPCHAUKE, 0, "block_food_senbei");
		registerRenderMeta(JPCHAUKE, 1, "block_food_mikan");
		registerRenderMeta(JPCHAUKE, 2, "block_food_scone");

		registerRender(TEAPOT_kara);
		registerRender(TEAPOT);
		registerRender(TEACUP);
		registerRender(TEASET);
		registerRender(SCONESET_kara);
		registerRender(SCONESET_1);

		registerRender(ICECREAM);

		registerRender(CHEESE_CURD);
		registerRender(CHEESE);
		registerRender(FRESH_CHEESE);
		registerRender(PIECE_CHEESE);
		registerRender(CHEESE_TANA);

		registerRender(CAKE);
		registerRender(BUN);
		registerRender(SCONE);
		registerRender(SENBEI);
		registerRender(TOUFU);
		registerRender(CHICKENSAND);
		registerRender(EGGSAND);
		registerRenderMeta(KIRIMI, 1, "item_food_kirimi_salmon");
		registerRenderMeta(KIRIMI, 2, "item_food_kirimi_fish");
		registerRenderMeta(KIRIMI, 3, "item_food_kirimi_beef");
		registerRenderMeta(KIRIMI, 4, "item_food_kirimi_tamago");

		registerRenderMeta(SUSHI, 1, "item_food_sushi_salmon");
		registerRenderMeta(SUSHI, 2, "item_food_sushi_fish");
		registerRenderMeta(SUSHI, 3, "item_food_sushi_beef");
		registerRenderMeta(SUSHI, 4, "item_food_sushi_tamago");

		registerRenderMeta(SHOUYUSUSHI, 1, "item_food_sushishouyu_salmon");
		registerRenderMeta(SHOUYUSUSHI, 2, "item_food_sushishouyu_fish");
		registerRenderMeta(SHOUYUSUSHI, 3, "item_food_sushishouyu_beef");
		registerRenderMeta(SHOUYUSUSHI, 4, "item_food_sushishouyu_tamago");

		registerRender(NORIAMI);
		registerRender(NORI_N);
		registerRender(NORI_I);
		registerRenderMeta(ONIGIRI, 0, "item_food_onigiri");
		registerRenderMeta(ONIGIRI, 1, "item_food_onigirishake");
		registerRenderMeta(ONIGIRI, 2, "item_food_futomaki");

		registerRender(KUSHI_SAKANA);
		registerRender(KUSHI_SAKANA_C);

		registerRender(KIT_TANA);
		registerRender(KITCHEN);
		registerRender(KIT_BOARD);
		registerRender(KIT_SINK1);

		registerRender(KIT_STOVE);
		registerRender(KIT_OVEN);
		registerRender(KIT_OVEN_B);
		registerRender(IRORI);
		registerRender(KIT_KANKI_1);
		registerRender(KIT_HAIKIDUCT);
		registerRender(KIT_DUCTEND_1);

		registerRender(TEATABLE);
		registerRender(ENDEN);
		
		registerRender(TOAMI);
		registerRender(TOAMI_W);
		registerRender(CUT_IKA);
		registerRender(COOKED_IKA);
		registerRender(IKA);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

	/*ここまで So far↑ */

}
