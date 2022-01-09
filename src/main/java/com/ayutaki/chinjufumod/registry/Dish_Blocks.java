package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_3shu;
import com.ayutaki.chinjufumod.blocks.dish.Chicken_large;
import com.ayutaki.chinjufumod.blocks.dish.Chicken_small;
import com.ayutaki.chinjufumod.blocks.dish.CornSoup_small;
import com.ayutaki.chinjufumod.blocks.dish.CurrySet;
import com.ayutaki.chinjufumod.blocks.dish.Curry_small;
import com.ayutaki.chinjufumod.blocks.dish.Don_Gyu;
import com.ayutaki.chinjufumod.blocks.dish.Don_Kaisen;
import com.ayutaki.chinjufumod.blocks.dish.Don_Katsu;
import com.ayutaki.chinjufumod.blocks.dish.Don_Meshi;
import com.ayutaki.chinjufumod.blocks.dish.Don_Oyako;
import com.ayutaki.chinjufumod.blocks.dish.EggburgSet;
import com.ayutaki.chinjufumod.blocks.dish.Eggburg_small;
import com.ayutaki.chinjufumod.blocks.dish.FoodKara_Sushi;
import com.ayutaki.chinjufumod.blocks.dish.FoodKara_Tei;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Bake_1;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Bake_2;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_KinokoAmaKara;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Nama_1;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Nama_2;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_kara;
import com.ayutaki.chinjufumod.blocks.dish.Gohan_small;
import com.ayutaki.chinjufumod.blocks.dish.Hakusaiduke;
import com.ayutaki.chinjufumod.blocks.dish.Icecream;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_C;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E2;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R2;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaCup;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaKyusu;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaSet;
import com.ayutaki.chinjufumod.blocks.dish.Kakigouri;
import com.ayutaki.chinjufumod.blocks.dish.Kakigouri_Green;
import com.ayutaki.chinjufumod.blocks.dish.Kakigouri_Pink;
import com.ayutaki.chinjufumod.blocks.dish.Kakigouri_Red;
import com.ayutaki.chinjufumod.blocks.dish.Kakigouri_Yellow;
import com.ayutaki.chinjufumod.blocks.dish.KeiryoCup;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.MisoSoup_small;
import com.ayutaki.chinjufumod.blocks.dish.NabeCooked_SNT;
import com.ayutaki.chinjufumod.blocks.dish.NabeCornSoup_cooked;
import com.ayutaki.chinjufumod.blocks.dish.NabeGohan_cooked;
import com.ayutaki.chinjufumod.blocks.dish.NabeMiso_cooked;
import com.ayutaki.chinjufumod.blocks.dish.NabeNama_1_TMGC;
import com.ayutaki.chinjufumod.blocks.dish.NabeNama_2_SNTA;
import com.ayutaki.chinjufumod.blocks.dish.NabeTori_cooked;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.blocks.dish.Niboshi;
import com.ayutaki.chinjufumod.blocks.dish.PastaCheese;
import com.ayutaki.chinjufumod.blocks.dish.PastaKinoko;
import com.ayutaki.chinjufumod.blocks.dish.PastaTomato;
import com.ayutaki.chinjufumod.blocks.dish.Pizza_cooked;
import com.ayutaki.chinjufumod.blocks.dish.Rice_small;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_1;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_a;
import com.ayutaki.chinjufumod.blocks.dish.ShouyuSara_1;
import com.ayutaki.chinjufumod.blocks.dish.ShouyuSara_5;
import com.ayutaki.chinjufumod.blocks.dish.Stew_small;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Beef;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Fish;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Salmon;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Tamago;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_kara1_4;
import com.ayutaki.chinjufumod.blocks.dish.SushiMeshi;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_1;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_5;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_9;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_d;
import com.ayutaki.chinjufumod.blocks.dish.SushiOke_kara;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet_4shoku;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet_Beef;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet_Fish;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet_Salmon;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet_Tamago;
import com.ayutaki.chinjufumod.blocks.dish.TamagoyakiSet;
import com.ayutaki.chinjufumod.blocks.dish.Tamagoyaki_small;
import com.ayutaki.chinjufumod.blocks.dish.TeaCup;
import com.ayutaki.chinjufumod.blocks.dish.TeaPot;
import com.ayutaki.chinjufumod.blocks.dish.TeaPot_kara;
import com.ayutaki.chinjufumod.blocks.dish.TeaSet;
import com.ayutaki.chinjufumod.blocks.dish.TeaStand;
import com.ayutaki.chinjufumod.blocks.dish.Tonsui_small;
import com.ayutaki.chinjufumod.blocks.dish.Udon_Niku;
import com.ayutaki.chinjufumod.blocks.dish.Udon_Su;
import com.ayutaki.chinjufumod.blocks.dish.Udon_Tsukimi;
import com.ayutaki.chinjufumod.blocks.dish.YakijyakeSet;
import com.ayutaki.chinjufumod.blocks.dish.YakizakanaSet;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Fish;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_MizuMilk;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Oriito;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Pasta;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Shio_Aku;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Udon;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_cooked_Curry;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_cooked_Dashi;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_cooked_Stew;

import net.minecraft.block.Block;

public final class Dish_Blocks {

	public static Block ZUNDOU;
	public static Block CURRYNABE, CURRY, CURRYSET;

	public static Block STEWNABE, STEW;

	public static Block MIZUMILKNABE;
	public static Block FISH_ZUNDOU, NIBOSHI;

	public static Block DASHINABE, UDONNABE;
	public static Block UDON_SU, UDON_NIKU, UDON_TSUKIMI;

	public static Block NABE_kara, NABE_nama, NABE_nama_2, NABE_cooked;
	public static Block NABETORI, TONSUITORI;
	public static Block NABEMISO, MISOSOUP;
	public static Block NABEGOHAN, GOHAN, RICE;
	public static Block DONBURI_MESHI, DONBURI_GYU, DONBURI_KATSU, DONBURI_OYAKO, DONBURI_KAISEN;

	public static Block HAKUSAIDUKE;
	public static Block TAMAGOYAKI;
	public static Block TAMAGOYAKITEI, YAKIZAKANATEI, YAKIJYAKETEI;

	public static Block SUSHIMESHI;

	public static Block SUSHIGETA_kara1_4, SUSHIGETA_salmon, SUSHIGETA_fish, SUSHIGETA_beef, SUSHIGETA_tamago;
	public static Block SUSHISET_salmon, SUSHISET_fish, SUSHISET_beef, SUSHISET_tamago, SUSHISET_4shoku;

	public static Block SUSHIOKE, SUSHIOKE_FULL_1, SUSHIOKE_FULL_5, SUSHIOKE_FULL_9, SUSHIOKE_FULL_d;
	public static Block SHOUYUSARA_1, SHOUYUSARA_5;

	public static Block NABECORNSOUP, CORNSOUP;

	public static Block KEIRYO_CUP;
	public static Block FRYPAN_kara, FRYPAN_NAMA_1, FRYPAN_BAKE_1, FRYPAN_NAMA_2, FRYPAN_BAKE_2, FPKINOKOAK_nama;

	public static Block EGGBURG, EGGBURGSET;

	public static Block PASTANABE, PASTATOMATO, PASTACHEESE, PASTAKINOKO;
	public static Block PIZZA;

	public static Block CHICKEN, CHICKEN_small;

	public static Block KETTLE_full, KYUSU, JPTEACUP, JPTEASET, JPCHAUKE;
	public static Block TEAPOT_kara, TEAPOT, TEACUP, TEASET;
	public static Block SCONESET_kara, SCONESET_1, SCONESET_a;

	public static Block ICECREAM;
	public static Block KAKIGOURI_block, KAKIGOURI_pink, KAKIGOURI_red, KAKIGOURI_yellow, KAKIGOURI_green;

	public static Block SHIOAKUNABE, ORIITONABE;

	public static Block FOODKARA_TEI, FOODKARA_SUSHI;

	public static Block IRORISAKANA_E1, IRORISAKANA_E2, IRORISAKANA_R1, IRORISAKANA_R2, IRORISAKANA_C;


	public static void init() {

		ZUNDOU = new Zundou();
		CURRYNABE = new Zundou_cooked_Curry();
		CURRY = new Curry_small();
		CURRYSET = new CurrySet();

		STEWNABE = new Zundou_cooked_Stew();
		STEW = new Stew_small();

		MIZUMILKNABE = new Zundou_MizuMilk();
		FISH_ZUNDOU = new Zundou_Fish();
		NIBOSHI = new Niboshi();

		DASHINABE = new Zundou_cooked_Dashi();
		UDONNABE = new Zundou_Udon();
		UDON_SU = new Udon_Su();
		UDON_NIKU = new Udon_Niku();
		UDON_TSUKIMI = new Udon_Tsukimi();

		NABE_kara = new Nabe_kara();
		NABE_nama = new NabeNama_1_TMGC();
		NABE_nama_2 = new NabeNama_2_SNTA();
		NABE_cooked = new NabeCooked_SNT();
		NABETORI = new NabeTori_cooked();
		TONSUITORI = new Tonsui_small();

		NABEMISO = new NabeMiso_cooked();
		MISOSOUP = new MisoSoup_small();

		NABEGOHAN = new NabeGohan_cooked();
		GOHAN = new Gohan_small();
		RICE = new Rice_small();

		DONBURI_MESHI = new Don_Meshi();
		DONBURI_GYU = new Don_Gyu();
		DONBURI_KATSU = new Don_Katsu();
		DONBURI_OYAKO = new Don_Oyako();
		DONBURI_KAISEN = new Don_Kaisen();

		HAKUSAIDUKE = new Hakusaiduke();

		TAMAGOYAKI = new Tamagoyaki_small();
		TAMAGOYAKITEI = new TamagoyakiSet();
		YAKIZAKANATEI = new YakizakanaSet();
		YAKIJYAKETEI = new YakijyakeSet();

		SUSHIMESHI = new SushiMeshi();

		SUSHIGETA_kara1_4 = new SushiGeta_kara1_4();
		SUSHIGETA_salmon = new SushiGeta_Salmon();
		SUSHIGETA_fish = new SushiGeta_Fish();
		SUSHIGETA_beef = new SushiGeta_Beef();
		SUSHIGETA_tamago = new SushiGeta_Tamago();

		SUSHISET_salmon = new SushiSet_Salmon();
		SUSHISET_fish = new SushiSet_Fish();
		SUSHISET_beef = new SushiSet_Beef();
		SUSHISET_tamago = new SushiSet_Tamago();
		SUSHISET_4shoku = new SushiSet_4shoku();

		SUSHIOKE = new SushiOke_kara();
		SUSHIOKE_FULL_1 = new SushiOkeFull_1();
		SUSHIOKE_FULL_5 = new SushiOkeFull_5();
		SUSHIOKE_FULL_9 = new SushiOkeFull_9();
		SUSHIOKE_FULL_d = new SushiOkeFull_d();

		SHOUYUSARA_1 = new ShouyuSara_1();
		SHOUYUSARA_5 = new ShouyuSara_5();

		NABECORNSOUP = new NabeCornSoup_cooked();
		CORNSOUP = new CornSoup_small();

		KEIRYO_CUP = new KeiryoCup();

		FRYPAN_kara = new Frypan_kara();
		FRYPAN_NAMA_1 = new Frypan_Nama_1();
		FRYPAN_NAMA_2 = new Frypan_Nama_2();
		FRYPAN_BAKE_1 = new Frypan_Bake_1();
		FRYPAN_BAKE_2 = new Frypan_Bake_2();
		FPKINOKOAK_nama = new Frypan_KinokoAmaKara();

		EGGBURG = new Eggburg_small();
		EGGBURGSET = new EggburgSet();

		PASTANABE = new Zundou_Pasta();
		PASTATOMATO = new PastaTomato();
		PASTACHEESE = new PastaCheese();
		PASTAKINOKO = new PastaKinoko();

		PIZZA = new Pizza_cooked();

		CHICKEN = new Chicken_large();
		CHICKEN_small = new Chicken_small();

		KETTLE_full = new Kettle_full();
		KYUSU = new JPTeaKyusu();
		JPTEACUP = new JPTeaCup();
		JPTEASET = new JPTeaSet();
		JPCHAUKE = new Chauke_3shu();

		TEAPOT_kara = new TeaPot_kara();
		TEAPOT = new TeaPot();
		TEACUP = new TeaCup();
		TEASET = new TeaSet();

		SCONESET_kara = new TeaStand();
		SCONESET_1 = new SconeSet_1();
		SCONESET_a = new SconeSet_a();
		ICECREAM = new Icecream();

		KAKIGOURI_block = new Kakigouri();
		KAKIGOURI_pink = new Kakigouri_Pink();
		KAKIGOURI_red = new Kakigouri_Red();
		KAKIGOURI_yellow = new Kakigouri_Yellow();
		KAKIGOURI_green = new Kakigouri_Green();

		SHIOAKUNABE = new Zundou_Shio_Aku();
		ORIITONABE = new Zundou_Oriito();

		FOODKARA_TEI = new FoodKara_Tei();
		FOODKARA_SUSHI = new FoodKara_Sushi();

		IRORISAKANA_E1 = new Irori_Sakana_E1();
		IRORISAKANA_E2 = new Irori_Sakana_E2();
		IRORISAKANA_R1 = new Irori_Sakana_R1();
		IRORISAKANA_R2 = new Irori_Sakana_R2();
		IRORISAKANA_C = new Irori_Sakana_C();

	}

	public static void register() {

		registerBlock(ZUNDOU);
		registerBlock(CURRYNABE);
		registerBlock(CURRY);
		registerBlock(CURRYSET);

		registerBlock(STEWNABE);
		registerBlock(STEW);

		registerBlock(MIZUMILKNABE);
		registerBlock(FISH_ZUNDOU);
		registerBlock(NIBOSHI);

		registerBlock(DASHINABE);
		registerBlock(UDONNABE);
		registerBlock(UDON_SU);
		registerBlock(UDON_NIKU);
		registerBlock(UDON_TSUKIMI);

		registerBlock(NABE_kara);
		registerBlock(NABE_nama);
		registerBlock(NABE_nama_2);
		registerBlock(NABE_cooked);
		registerBlock(NABETORI);
		registerBlock(TONSUITORI);

		registerBlock(NABEMISO);
		registerBlock(MISOSOUP);

		registerBlock(NABEGOHAN);
		registerBlock(GOHAN);
		registerBlock(RICE);

		registerBlock(DONBURI_MESHI);
		registerBlock(DONBURI_GYU);
		registerBlock(DONBURI_KATSU);
		registerBlock(DONBURI_OYAKO);
		registerBlock(DONBURI_KAISEN);
		
		registerBlock(HAKUSAIDUKE);

		registerBlock(TAMAGOYAKI);
		registerBlock(TAMAGOYAKITEI);
		registerBlock(YAKIZAKANATEI);
		registerBlock(YAKIJYAKETEI);

		registerBlock(SUSHIMESHI);

		registerBlock(SUSHIGETA_kara1_4);
		registerBlock(SUSHIGETA_salmon);
		registerBlock(SUSHIGETA_fish);
		registerBlock(SUSHIGETA_beef);
		registerBlock(SUSHIGETA_tamago);

		registerBlock(SUSHISET_salmon);
		registerBlock(SUSHISET_fish);
		registerBlock(SUSHISET_beef);
		registerBlock(SUSHISET_tamago);
		registerBlock(SUSHISET_4shoku);

		registerBlock(SUSHIOKE);
		registerBlock(SUSHIOKE_FULL_1);
		registerBlock(SUSHIOKE_FULL_5);
		registerBlock(SUSHIOKE_FULL_9);
		registerBlock(SUSHIOKE_FULL_d);

		registerBlock(SHOUYUSARA_1);
		registerBlock(SHOUYUSARA_5);

		registerBlock(NABECORNSOUP);
		registerBlock(CORNSOUP);

		registerBlock(KEIRYO_CUP);

		registerBlock(FRYPAN_kara);
		registerBlock(FRYPAN_NAMA_1);
		registerBlock(FRYPAN_NAMA_2);
		registerBlock(FRYPAN_BAKE_1);
		registerBlock(FRYPAN_BAKE_2);
		registerBlock(FPKINOKOAK_nama);

		registerBlock(EGGBURG);
		registerBlock(EGGBURGSET);

		registerBlock(PASTANABE);
		registerBlock(PASTATOMATO);
		registerBlock(PASTACHEESE);
		registerBlock(PASTAKINOKO);

		registerBlock(PIZZA);

		registerBlock(CHICKEN);
		registerBlock(CHICKEN_small);

		registerBlock(KETTLE_full);
		registerBlock(KYUSU);
		registerBlock(JPTEACUP);
		registerBlock(JPTEASET);
		registerBlock(JPCHAUKE);

		registerBlock(TEAPOT_kara);
		registerBlock(TEAPOT);
		registerBlock(TEACUP);
		registerBlock(TEASET);

		registerBlock(SCONESET_kara);
		registerBlock(SCONESET_1);
		registerBlock(SCONESET_a);
		registerBlock(ICECREAM);

		registerBlock(KAKIGOURI_block);
		registerBlock(KAKIGOURI_pink);
		registerBlock(KAKIGOURI_red);
		registerBlock(KAKIGOURI_yellow);
		registerBlock(KAKIGOURI_green);

		registerBlock(SHIOAKUNABE);
		registerBlock(ORIITONABE);

		registerBlock(FOODKARA_TEI);
		registerBlock(FOODKARA_SUSHI);

		registerBlock(IRORISAKANA_E1);
		registerBlock(IRORISAKANA_E2);
		registerBlock(IRORISAKANA_R1);
		registerBlock(IRORISAKANA_R2);
		registerBlock(IRORISAKANA_C);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
