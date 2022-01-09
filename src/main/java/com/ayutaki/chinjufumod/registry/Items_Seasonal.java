package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.wood.FallLeaf;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Leaf_Sakuraflower;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Ichoh;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Kaede;
import com.ayutaki.chinjufumod.blocks.wood.Nae_OakKare;
import com.ayutaki.chinjufumod.blocks.wood.Nae_Sakura;
import com.ayutaki.chinjufumod.items.armor.ItemSantaAkashi;
import com.ayutaki.chinjufumod.items.armor.ItemSantaKumano;
import com.ayutaki.chinjufumod.items.armor.ItemSantaRyujou;
import com.ayutaki.chinjufumod.items.armor.ItemSantaSuzuya;
import com.ayutaki.chinjufumod.items.armor.ItemSantaTeitoku;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Hamakaze;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Ikaduchi;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Inaduma;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Kawakaze;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Oboro;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Teitoku;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_TeitokuB;
import com.ayutaki.chinjufumod.items.armor.ItemYkt_Urakaze;
import com.ayutaki.chinjufumod.items.food.ItemFoodChoco;
import com.ayutaki.chinjufumod.items.food.ItemFoodWataame;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.garden.ItemSeason_IkegakiLong;
import com.ayutaki.chinjufumod.items.garden.ItemSeason_IkegakiSmall;
import com.ayutaki.chinjufumod.items.garden.ItemSeason_Kanyou;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_ichoh;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_kaede;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_sakura;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_ich;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_kae;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_saku;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_ich;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_kae;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_saku;
import com.ayutaki.chinjufumod.items.hakkou.ItemChocoRaw;
import com.ayutaki.chinjufumod.items.hakkou.ItemCocoa_ferm;
import com.ayutaki.chinjufumod.items.hakkou.ItemCocoa_mass;
import com.ayutaki.chinjufumod.items.hakkou.ItemCocoa_roast;
import com.ayutaki.chinjufumod.items.seasonal.ItemKakigouri;
import com.ayutaki.chinjufumod.items.seasonal.ItemKakigouri_Green;
import com.ayutaki.chinjufumod.items.seasonal.ItemKakigouri_Pink;
import com.ayutaki.chinjufumod.items.seasonal.ItemKakigouri_Red;
import com.ayutaki.chinjufumod.items.seasonal.ItemKakigouri_Yellow;
import com.ayutaki.chinjufumod.items.seasonal.ItemNewYear_Xmas;
import com.ayutaki.chinjufumod.items.seasonal.ItemPlanks_1_Sakura;
import com.ayutaki.chinjufumod.items.seasonal.ItemPlanks_2_Kaede;
import com.ayutaki.chinjufumod.items.seasonal.ItemPlanks_3_Ichoh;
import com.ayutaki.chinjufumod.items.seasonal.ItemPresent;
import com.ayutaki.chinjufumod.items.seasonal.ItemPresent_B;
import com.ayutaki.chinjufumod.items.seasonal.ItemSeasonalInfo;
import com.ayutaki.chinjufumod.items.seasonal.ItemSnowCore;
import com.ayutaki.chinjufumod.items.seasonal.ItemSnowMan;
import com.ayutaki.chinjufumod.items.seasonal.ItemSuiden;
import com.ayutaki.chinjufumod.items.seasonal.ItemZundou_Aku;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_ich;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_kae;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_saku;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_ich;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_kae;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_saku;
import com.ayutaki.chinjufumod.items.unitblock.ItemChabudai;
import com.ayutaki.chinjufumod.items.unitblock.ItemKotatsu;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Seasonal {

	public static Item ORIITO, TANMONO, WARAHAI;
	public static Item AKUNABE;
	public static Item FALL_LEAF, SUIDEN;

	public static Item SAKURA_flow, KAEDE_leaf, ICHOH_leaf, OAKKARE_leaf;
	public static Item SAKURA_log, KAEDE_log, ICHOH_log;
	public static Item SAKURA_nae, KAEDE_nae, ICHOH_nae, OAKKARE_nae;

	public static Item PLANKS_sakura, PLANKS_kaede, PLANKS_ichoh;
	public static Item SAKURA_slabhalf, KAEDE_slabhalf, ICHOH_slabhalf;
	public static Item SAKURA_stairs, KAEDE_stairs, ICHOH_stairs;
	public static Item PILLAR_saku, PILLAR_kae, PILLAR_ich;
	public static Item PILLARSLAB_saku, PILLARSLAB_kae, PILLARSLAB_ich;

	public static Item SAKURA_FENCE, KAEDE_FENCE, ICHOH_FENCE, SAKURA_FGATE, KAEDE_FGATE, ICHOH_FGATE;
	public static Item DOOR_SAKURA, DOOR_KAEDE, DOOR_ICHOH;
	public static Item SAKURA_TRAPDOOR, KAEDE_TRAPDOOR, ICHOH_TRAPDOOR;
	public static Item SAKURA_PLATE, KAEDE_PLATE, ICHOH_PLATE;
	public static Item SAKURA_BUTTON, KAEDE_BUTTON, ICHOH_BUTTON;

	public static Item SAKURA_carpet, KAEDE_carpet, ICHOH_carpet, OCHIBA_carpet;

	public static Item WP_LOG_sakura, WP_LOG_kaede, WP_LOG_ichoh;
	public static Item WP_PLANK_sakura, WP_PLANK_kaede, WP_PLANK_ichoh;

	public static Item GARASUDO_SAKU, GARASUDO_KAE, GARASUDO_ICH;
	public static Item GARASUDOB_SAKU, GARASUDOB_KAE, GARASUDOB_ICH;
	public static Item GARASUDOH_SAKU, GARASUDOH_KAE, GARASUDOH_ICH;
	public static Item SHOUJI_SAKU, SHOUJI_KAE, SHOUJI_ICH;
	public static Item SHOUJIA_SAKU, SHOUJIA_KAE, SHOUJIA_ICH;
	public static Item SHOUJIH_SAKU, SHOUJIH_KAE, SHOUJIH_ICH;
	public static Item SHOUJIWIN_sakura, SHOUJIWIN_kaede, SHOUJIWIN_ichoh;

	public static Item RANMA_saku, RANMA_kae, RANMA_ich;
	public static Item RANMAB_saku, RANMAB_kae, RANMAB_ich;
	public static Item RANMAC_saku, RANMAC_kae, RANMAC_ich;
	public static Item KANKI_saku, KANKI_kae, KANKI_ich;
	public static Item KOUSHI_saku, KOUSHI_kae, KOUSHI_ich;
	public static Item KOUSHIB_saku, KOUSHIB_kae, KOUSHIB_ich;

	public static Item BONSAI_sakura, BONSAI_kaede, BONSAI_ichoh, BONSAI_kare;
	public static Item SKANYOU_BOT, SIKEGAKI, SIKEGAKILONG_BOT;

	public static Item CHABUDAI, KOTATSU;

	public static Item KUSATABA, KUSATABA_STAIRS, WARATABA;
	public static Item KUSATABA_RF, WARATABA_RF, KAYATABA_RF;
	public static Item WARATABA_STAIRS, KAYATABA, KAYATABA_STAIRS;

	public static Item SHIMENAWA, NEWYEAR_XMAS;
	public static Item PRESENT, PRESENT_B;
	
	public static Item SNOWCORE, SNOWMAN;
	
	public static Item HINAKAZARI, HINADAN;

	public static Item COCOA_F, COCOA_R, COCOA_M, CHOCO_raw;
	public static Item COCOA_TARU;
	public static Item FOOD_CHOCO;

	public static Item UCHIWA_white, UCHIWA_orange, UCHIWA_magenta, UCHIWA_lightb,
								UCHIWA_yellow, UCHIWA_lime, UCHIWA_pink, UCHIWA_gray,
								UCHIWA_lightg, UCHIWA_cyan, UCHIWA_purple, UCHIWA_blue,
								UCHIWA_brown, UCHIWA_green, UCHIWA_red, UCHIWA_black;

	public static Item FOOD_WATAGASHI;
	public static Item WATAGASHI_block, WATAGASHI_pink, WATAGASHI_red, WATAGASHI_yellow, WATAGASHI_green;
	public static Item KAKIGOURI_hata;
	public static Item KAKIGOURI_block, KAKIGOURI_pink, KAKIGOURI_red, KAKIGOURI_yellow, KAKIGOURI_green;

	public static Item YKTD_BOOTS, YKTO_BOOTS;
	public static Item IKADUCHIYKT_HELMET, IKADUCHIYKT_CHESTPLATE, IKADUCHIYKT_LEGGINGS;
	public static Item INADUMAYKT_HELMET, INADUMAYKT_CHESTPLATE, INADUMAYKT_LEGGINGS;
	public static Item HAMAKAZEYKT_HELMET, HAMAKAZEYKT_CHESTPLATE, HAMAKAZEYKT_LEGGINGS;
	public static Item URAKAZEYKT_HELMET, URAKAZEYKT_CHESTPLATE, URAKAZEYKT_LEGGINGS;
	public static Item KAWAKAZEYKT_HELMET, KAWAKAZEYKT_CHESTPLATE, KAWAKAZEYKT_LEGGINGS;
	public static Item OBOROYKT_HELMET, OBOROYKT_CHESTPLATE, OBOROYKT_LEGGINGS;
	public static Item TTOKUYKT_CHESTPLATE, TTOKUYKT_LEGGINGS, TTOKUYKTB_CHESTPLATE, TTOKUYKTB_LEGGINGS;

	public static Item AKASHISANTA_HELMET, AKASHISANTA_CHESTPLATE, AKASHISANTA_LEGGINGS, AKASHISANTA_BOOTS;
	public static Item KUMANOSANTA_HELMET, KUMANOSANTA_CHESTPLATE, KUMANOSANTA_LEGGINGS, KUMANOSANTA_BOOTS;
	public static Item SUZUYASANTA_HELMET, SUZUYASANTA_CHESTPLATE, SUZUYASANTA_LEGGINGS, SUZUYASANTA_BOOTS;
	public static Item RYUJOUSANTA_HELMET, RYUJOUSANTA_CHESTPLATE, RYUJOUSANTA_LEGGINGS, RYUJOUSANTA_BOOTS;
	public static Item TEITOKUSANTA_HELMET, TEITOKUSANTA_CHESTPLATE, TEITOKUSANTA_LEGGINGS, TEITOKUSANTA_BOOTS;


	public static void init() {

		WARAHAI = new ItemSeasonalInfo("item_warahai");
		ORIITO = new ItemSeasonalInfo("item_oriito");
		TANMONO = new ItemSeasonalInfo("item_tanmono");
		AKUNABE = new ItemZundou_Aku();
		FALL_LEAF = new ItemBlock_noFuel(Seasonal_Blocks.FALL_LEAF, FallLeaf.ID);
		SUIDEN = new ItemSuiden(); //default の meta が 0 ではない為、ItemBlockのクラスを書いて対応

		SAKURA_flow = new ItemBlock_noFuel(Seasonal_Blocks.SAKURA_flow, Leaf_Sakuraflower.ID);
		KAEDE_leaf = new ItemBlock_noFuel(Seasonal_Blocks.KAEDE_leaf, Leaf_Kaede.ID);
		ICHOH_leaf = new ItemBlock_noFuel(Seasonal_Blocks.ICHOH_leaf, Leaf_Ichoh.ID);
		OAKKARE_leaf = new ItemBlock_noFuel(Seasonal_Blocks.OAKKARE_leaf, Leaf_OakKare.ID);
		SAKURA_log = new ItemBlock_Fuel300(Seasonal_Blocks.SAKURA_log, "block_tree_sakura_log");
		KAEDE_log = new ItemBlock_Fuel300(Seasonal_Blocks.KAEDE_log, "block_tree_kaede_log");
		ICHOH_log = new ItemBlock_Fuel300(Seasonal_Blocks.ICHOH_log, "block_tree_ichoh_log");
		SAKURA_nae = new ItemBlock_Fuel100(Seasonal_Blocks.SAKURA_nae, Nae_Sakura.ID);
		KAEDE_nae = new ItemBlock_Fuel100(Seasonal_Blocks.KAEDE_nae, Nae_Kaede.ID);
		ICHOH_nae = new ItemBlock_Fuel100(Seasonal_Blocks.ICHOH_nae, Nae_Ichoh.ID);
		OAKKARE_nae = new ItemBlock_Fuel100(Seasonal_Blocks.OAKKARE_nae, Nae_OakKare.ID);

		PLANKS_sakura = new ItemPlanks_1_Sakura();
		PLANKS_kaede = new ItemPlanks_2_Kaede();
		PLANKS_ichoh = new ItemPlanks_3_Ichoh();
		SAKURA_slabhalf = new ItemBlock_Fuel150(Seasonal_Blocks.SAKURA_slabhalf, "block_slabhalf_sakura");
		KAEDE_slabhalf = new ItemBlock_Fuel150(Seasonal_Blocks.KAEDE_slabhalf, "block_slabhalf_kaede");
		ICHOH_slabhalf = new ItemBlock_Fuel150(Seasonal_Blocks.ICHOH_slabhalf, "block_slabhalf_ichoh");
		SAKURA_stairs = new ItemBlock_Fuel300(Seasonal_Blocks.SAKURA_stairs, "block_stairs_sakura");
		KAEDE_stairs = new ItemBlock_Fuel300(Seasonal_Blocks.KAEDE_stairs, "block_stairs_kaede");
		ICHOH_stairs = new ItemBlock_Fuel300(Seasonal_Blocks.ICHOH_stairs, "block_stairs_ichoh");
		PILLAR_saku = new ItemBlock_Fuel300(Seasonal_Blocks.PILLAR_saku, "block_pillar_sakura");
		PILLAR_kae = new ItemBlock_Fuel300(Seasonal_Blocks.PILLAR_kae, "block_pillar_kaede");
		PILLAR_ich = new ItemBlock_Fuel300(Seasonal_Blocks.PILLAR_ich, "block_pillar_ichoh");
		PILLARSLAB_saku = new ItemBlock_Fuel150(Seasonal_Blocks.PILLARSLAB_saku, "block_kamoi_sakura");
		PILLARSLAB_kae = new ItemBlock_Fuel150(Seasonal_Blocks.PILLARSLAB_kae, "block_kamoi_kaede");
		PILLARSLAB_ich = new ItemBlock_Fuel150(Seasonal_Blocks.PILLARSLAB_ich, "block_kamoi_ichoh");

		SAKURA_FENCE = new ItemBlock_Fuel300(Seasonal_Blocks.SAKURA_FENCE, "block_fence_sakura");
		KAEDE_FENCE = new ItemBlock_Fuel300(Seasonal_Blocks.KAEDE_FENCE, "block_fence_kaede");
		ICHOH_FENCE = new ItemBlock_Fuel300(Seasonal_Blocks.ICHOH_FENCE, "block_fence_ichoh");
		SAKURA_FGATE = new ItemBlock_Fuel300(Door_Blocks.SAKURA_FGATE, "block_fencegate_sakura");
		KAEDE_FGATE = new ItemBlock_Fuel300(Door_Blocks.KAEDE_FGATE, "block_fencegate_kaede");
		ICHOH_FGATE = new ItemBlock_Fuel300(Door_Blocks.ICHOH_FGATE, "block_fencegate_ichoh");

		DOOR_SAKURA = new ItemDoor_sakura();
		DOOR_KAEDE = new ItemDoor_kaede();
		DOOR_ICHOH = new ItemDoor_ichoh();

		SAKURA_TRAPDOOR = new ItemBlock_Fuel300(Seasonal_Blocks.SAKURA_TRAPDOOR, "block_trapdoor_sakura");
		KAEDE_TRAPDOOR = new ItemBlock_Fuel300(Seasonal_Blocks.KAEDE_TRAPDOOR, "block_trapdoor_kaede");
		ICHOH_TRAPDOOR = new ItemBlock_Fuel300(Seasonal_Blocks.ICHOH_TRAPDOOR, "block_trapdoor_ichoh");
		SAKURA_PLATE = new ItemBlock_Fuel300(Seasonal_Blocks.SAKURA_PLATE, "block_plate_sakura");
		KAEDE_PLATE = new ItemBlock_Fuel300(Seasonal_Blocks.KAEDE_PLATE, "block_plate_kaede");
		ICHOH_PLATE = new ItemBlock_Fuel300(Seasonal_Blocks.ICHOH_PLATE, "block_plate_ichoh");
		SAKURA_BUTTON = new ItemBlock_Fuel100(Seasonal_Blocks.SAKURA_BUTTON, "block_button_sakura");
		KAEDE_BUTTON = new ItemBlock_Fuel100(Seasonal_Blocks.KAEDE_BUTTON, "block_button_kaede");
		ICHOH_BUTTON = new ItemBlock_Fuel100(Seasonal_Blocks.ICHOH_BUTTON, "block_button_ichoh");

		SAKURA_carpet = new ItemBlock_noFuel(Seasonal_Blocks.SAKURA_carpet, "block_carpet_sakura");
		KAEDE_carpet = new ItemBlock_noFuel(Seasonal_Blocks.KAEDE_carpet, "block_carpet_kaede");
		ICHOH_carpet = new ItemBlock_noFuel(Seasonal_Blocks.ICHOH_carpet, "block_carpet_ichoh");
		OCHIBA_carpet = new ItemBlock_noFuel(Seasonal_Blocks.OCHIBA_carpet, "block_carpet_ochiba");

		WP_LOG_sakura = new ItemBlock_noFuel(Seasonal_Blocks.WP_LOG_sakura, "block_wp_log_sakura");
		WP_LOG_kaede = new ItemBlock_noFuel(Seasonal_Blocks.WP_LOG_kaede, "block_wp_log_kaede");
		WP_LOG_ichoh = new ItemBlock_noFuel(Seasonal_Blocks.WP_LOG_ichoh, "block_wp_log_ichoh");
		WP_PLANK_sakura = new ItemBlock_noFuel(Seasonal_Blocks.WP_PLANK_sakura, "block_wp_plank_sakura");
		WP_PLANK_kaede = new ItemBlock_noFuel(Seasonal_Blocks.WP_PLANK_kaede, "block_wp_plank_kaede");
		WP_PLANK_ichoh = new ItemBlock_noFuel(Seasonal_Blocks.WP_PLANK_ichoh, "block_wp_plank_ichoh");

		GARASUDO_SAKU = new ItemGarasudo_saku();
		GARASUDO_KAE = new ItemGarasudo_kae();
		GARASUDO_ICH = new ItemGarasudo_ich();
		GARASUDOB_SAKU = new ItemGarasudoB_saku();
		GARASUDOB_KAE = new ItemGarasudoB_kae();
		GARASUDOB_ICH = new ItemGarasudoB_ich();

		GARASUDOH_SAKU = new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_SAKU, "block_garasudohalf_sakura");
		GARASUDOH_KAE = new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_KAE, "block_garasudohalf_kaede");
		GARASUDOH_ICH = new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_ICH, "block_garasudohalf_ichoh");

		SHOUJI_SAKU = new ItemShouji_saku();
		SHOUJI_KAE = new ItemShouji_kae();
		SHOUJI_ICH = new ItemShouji_ich();
		SHOUJIA_SAKU = new ItemShoujiA_saku();
		SHOUJIA_KAE = new ItemShoujiA_kae();
		SHOUJIA_ICH = new ItemShoujiA_ich();

		SHOUJIH_SAKU = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_SAKU, "block_shoujihalf_sakura");
		SHOUJIH_KAE = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_KAE, "block_shoujihalf_kaede");
		SHOUJIH_ICH = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_ICH, "block_shoujihalf_ichoh");
		SHOUJIWIN_sakura = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_sakura, "block_shoujih_sakura");
		SHOUJIWIN_kaede = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_kaede, "block_shoujih_kaede");
		SHOUJIWIN_ichoh = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_ichoh, "block_shoujih_ichoh");

		RANMA_saku = new ItemBlock_Fuel100(Seasonal_Blocks.RANMA_saku, "block_ranma_saku");
		RANMA_kae = new ItemBlock_Fuel100(Seasonal_Blocks.RANMA_kae, "block_ranma_kae");
		RANMA_ich = new ItemBlock_Fuel100(Seasonal_Blocks.RANMA_ich, "block_ranma_ich");
		RANMAB_saku = new ItemBlock_Fuel100(Seasonal_Blocks.RANMAB_saku, "block_ranmab_saku");
		RANMAB_kae = new ItemBlock_Fuel100(Seasonal_Blocks.RANMAB_kae, "block_ranmab_kae");
		RANMAB_ich = new ItemBlock_Fuel100(Seasonal_Blocks.RANMAB_ich, "block_ranmab_ich");
		RANMAC_saku = new ItemBlock_noFuel(Seasonal_Blocks.RANMAC_saku, "block_ranmac_saku");
		RANMAC_kae = new ItemBlock_noFuel(Seasonal_Blocks.RANMAC_kae, "block_ranmac_kae");
		RANMAC_ich = new ItemBlock_noFuel(Seasonal_Blocks.RANMAC_ich, "block_ranmac_ich");
		KANKI_saku = new ItemBlock_Fuel100(Seasonal_Blocks.KANKI_saku, "block_kanki_saku");
		KANKI_kae = new ItemBlock_Fuel100(Seasonal_Blocks.KANKI_kae, "block_kanki_kae");
		KANKI_ich = new ItemBlock_Fuel100(Seasonal_Blocks.KANKI_ich, "block_kanki_ich");
		KOUSHI_saku = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHI_saku, "block_koushi_saku");
		KOUSHI_kae = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHI_kae, "block_koushi_kae");
		KOUSHI_ich = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHI_ich, "block_koushi_ich");
		KOUSHIB_saku = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHIB_saku, "block_koushib_saku");
		KOUSHIB_kae = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHIB_kae, "block_koushib_kae");
		KOUSHIB_ich = new ItemBlock_Fuel100(Seasonal_Blocks.KOUSHIB_ich, "block_koushib_ich");

		BONSAI_sakura = new ItemBlock_noFuel(Seasonal_Blocks.BONSAI_sakura, "block_bonsai_sakura");
		BONSAI_kaede = new ItemBlock_noFuel(Seasonal_Blocks.BONSAI_kaede, "block_bonsai_kaede");
		BONSAI_ichoh = new ItemBlock_noFuel(Seasonal_Blocks.BONSAI_ichoh, "block_bonsai_ichoh");
		BONSAI_kare = new ItemBlock_noFuel(Seasonal_Blocks.BONSAI_kare, "block_bonsai_oakkare");
		SKANYOU_BOT = new ItemSeason_Kanyou();
		SIKEGAKI = new ItemSeason_IkegakiSmall();
		SIKEGAKILONG_BOT = new ItemSeason_IkegakiLong();

		CHABUDAI = new ItemChabudai();
		KOTATSU = new ItemKotatsu();

		KUSATABA = new ItemBlock_Fuel200(Seasonal_Blocks.KUSATABA, "block_tabakusa");
		WARATABA = new ItemBlock_Fuel200(Seasonal_Blocks.WARATABA, "block_tabawara");
		KAYATABA = new ItemBlock_Fuel200(Seasonal_Blocks.KAYATABA, "block_tabakaya");
		KUSATABA_RF = new ItemBlock_Fuel100(Seasonal_Blocks.KUSATABA_RF, "block_tabakusa_roof");
		WARATABA_RF = new ItemBlock_Fuel100(Seasonal_Blocks.WARATABA_RF, "block_tabawara_roof");
		KAYATABA_RF = new ItemBlock_Fuel100(Seasonal_Blocks.KAYATABA_RF, "block_tabakaya_roof");
		KUSATABA_STAIRS = new ItemBlock_Fuel200(Seasonal_Blocks.KUSATABA_STAIRS, "block_tabakusa_stairs");
		WARATABA_STAIRS = new ItemBlock_Fuel200(Seasonal_Blocks.WARATABA_STAIRS, "block_tabawara_stairs");
		KAYATABA_STAIRS = new ItemBlock_Fuel200(Seasonal_Blocks.KAYATABA_STAIRS, "block_tabakaya_stairs");

		SHIMENAWA = new ItemBlock_Fuel100(Seasonal_Blocks.SHIMENAWA, "block_shimenawa");
		NEWYEAR_XMAS = new ItemNewYear_Xmas();
		PRESENT = new ItemPresent();
		PRESENT_B = new ItemPresent_B();
		SNOWCORE = new ItemSnowCore();
		SNOWMAN = new ItemSnowMan();
		
		HINAKAZARI = new ItemBlock(Seasonal_Blocks.HINAKAZARI).setRegistryName("block_hinakazari").setUnlocalizedName("block_hinakazari");
		HINADAN = new ItemBlock(Seasonal_Blocks.HINADAN).setRegistryName("block_hinadan").setUnlocalizedName("block_hinadan");

		COCOA_F = new ItemCocoa_ferm().setRegistryName("item_cocoa_ferm").setUnlocalizedName("item_cocoa_ferm").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_R= new ItemCocoa_roast().setRegistryName("item_cocoa_roast").setUnlocalizedName("item_cocoa_roast").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_M= new ItemCocoa_mass().setRegistryName("item_cocoa_mass").setUnlocalizedName("item_cocoa_mass").setCreativeTab(ChinjufuModTabs.SEASONAL);
		CHOCO_raw = new ItemChocoRaw().setRegistryName("item_choco_raw").setUnlocalizedName("item_choco_raw").setCreativeTab(ChinjufuModTabs.SEASONAL);
		COCOA_TARU = new ItemBlock(Hakkou_Blocks.COCOA_TARU).setRegistryName("block_taru_cocoa_f").setUnlocalizedName("block_taru_cocoa_f");
		FOOD_CHOCO = new ItemFoodChoco(1, 0.3F, false).setRegistryName("item_food_choco").setCreativeTab(ChinjufuModTabs.SEASONAL);

		UCHIWA_white = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_white, "block_uchiwa_white");
		UCHIWA_orange = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_orange, "block_uchiwa_orange");
		UCHIWA_magenta = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_magenta, "block_uchiwa_magenta");
		UCHIWA_lightb = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_lightb, "block_uchiwa_lightb");
		UCHIWA_yellow = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_yellow, "block_uchiwa_yellow");
		UCHIWA_lime = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_lime, "block_uchiwa_lime");
		UCHIWA_pink = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_pink, "block_uchiwa_pink");
		UCHIWA_gray = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_gray, "block_uchiwa_gray");
		UCHIWA_lightg = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_lightg, "block_uchiwa_lightg");
		UCHIWA_cyan = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_cyan, "block_uchiwa_cyan");
		UCHIWA_purple = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_purple, "block_uchiwa_purple");
		UCHIWA_blue = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_blue, "block_uchiwa_blue");
		UCHIWA_brown = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_brown, "block_uchiwa_brown");
		UCHIWA_green = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_green, "block_uchiwa_green");
		UCHIWA_red = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_red, "block_uchiwa_red");
		UCHIWA_black = new ItemBlock_noFuel(Seasonal_Blocks.UCHIWA_black, "block_uchiwa_black");

		FOOD_WATAGASHI = new ItemFoodWataame(1, 0.3F, false).setRegistryName("item_food_watagashi").setCreativeTab(ChinjufuModTabs.SEASONAL);
		WATAGASHI_block = new ItemBlock_noFuel(Seasonal_Blocks.WATAGASHI_block, "block_watagashi");
		WATAGASHI_pink = new ItemBlock_noFuel(Seasonal_Blocks.WATAGASHI_pink, "block_watagashi_pink");
		WATAGASHI_red = new ItemBlock_noFuel(Seasonal_Blocks.WATAGASHI_red, "block_watagashi_red");
		WATAGASHI_yellow = new ItemBlock_noFuel(Seasonal_Blocks.WATAGASHI_yellow, "block_watagashi_yellow");
		WATAGASHI_green = new ItemBlock_noFuel(Seasonal_Blocks.WATAGASHI_green, "block_watagashi_green");

		KAKIGOURI_hata = new ItemBlock_noFuel(Seasonal_Blocks.KAKIGOURI_hata, "block_kakigouri_hata");
		KAKIGOURI_block = new ItemKakigouri(0, 0.0F, false);
		KAKIGOURI_pink = new ItemKakigouri_Pink(0, 0.0F, false);
		KAKIGOURI_red = new ItemKakigouri_Red(0, 0.0F, false);
		KAKIGOURI_yellow = new ItemKakigouri_Yellow(0, 0.0F, false);
		KAKIGOURI_green = new ItemKakigouri_Green(0, 0.0F, false);

		/* 浴衣 */
		YKTD_BOOTS = new ItemYkt_Ikaduchi(1,EntityEquipmentSlot.FEET).setRegistryName("item_ykt_getadoak").setUnlocalizedName("item_ykt_getadoak");
		YKTO_BOOTS = new ItemYkt_Teitoku(1,EntityEquipmentSlot.FEET).setRegistryName("item_ykt_getaoak").setUnlocalizedName("item_ykt_getaoak");

		IKADUCHIYKT_HELMET = new ItemYkt_Ikaduchi(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_ikaduchi_kazari").setUnlocalizedName("item_ykt_ikaduchi_kazari");
		IKADUCHIYKT_CHESTPLATE = new ItemYkt_Ikaduchi(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_ikaduchi_mini").setUnlocalizedName("item_ykt_ikaduchi_mini");
		IKADUCHIYKT_LEGGINGS = new ItemYkt_Ikaduchi(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_ikaduchi_long").setUnlocalizedName("item_ykt_ikaduchi_long");

		INADUMAYKT_HELMET = new ItemYkt_Inaduma(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_inaduma_kazari").setUnlocalizedName("item_ykt_inaduma_kazari");
		INADUMAYKT_CHESTPLATE = new ItemYkt_Inaduma(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_inaduma_mini").setUnlocalizedName("item_ykt_inaduma_mini");
		INADUMAYKT_LEGGINGS = new ItemYkt_Inaduma(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_inaduma_long").setUnlocalizedName("item_ykt_inaduma_long");

		HAMAKAZEYKT_HELMET = new ItemYkt_Hamakaze(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_hamakaze_kazari").setUnlocalizedName("item_ykt_hamakaze_kazari");
		HAMAKAZEYKT_CHESTPLATE = new ItemYkt_Hamakaze(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_hamakaze_mini").setUnlocalizedName("item_ykt_hamakaze_mini");
		HAMAKAZEYKT_LEGGINGS = new ItemYkt_Hamakaze(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_hamakaze_long").setUnlocalizedName("item_ykt_hamakaze_long");

		URAKAZEYKT_HELMET = new ItemYkt_Urakaze(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_urakaze_kazari").setUnlocalizedName("item_ykt_urakaze_kazari");
		URAKAZEYKT_CHESTPLATE = new ItemYkt_Urakaze(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_urakaze_mini").setUnlocalizedName("item_ykt_urakaze_mini");
		URAKAZEYKT_LEGGINGS = new ItemYkt_Urakaze(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_urakaze_long").setUnlocalizedName("item_ykt_urakaze_long");

		KAWAKAZEYKT_HELMET = new ItemYkt_Kawakaze(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_kawakaze_kazari").setUnlocalizedName("item_ykt_kawakaze_kazari");
		KAWAKAZEYKT_CHESTPLATE = new ItemYkt_Kawakaze(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_kawakaze_mini").setUnlocalizedName("item_ykt_kawakaze_mini");
		KAWAKAZEYKT_LEGGINGS = new ItemYkt_Kawakaze(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_kawakaze_long").setUnlocalizedName("item_ykt_kawakaze_long");

		OBOROYKT_HELMET = new ItemYkt_Oboro(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ykt_oboro_kazari").setUnlocalizedName("item_ykt_oboro_kazari");
		OBOROYKT_CHESTPLATE = new ItemYkt_Oboro(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_oboro_mini").setUnlocalizedName("item_ykt_oboro_mini");
		OBOROYKT_LEGGINGS = new ItemYkt_Oboro(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_oboro_long").setUnlocalizedName("item_ykt_oboro_long");

		TTOKUYKT_CHESTPLATE = new ItemYkt_Teitoku(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_ttoku_mini").setUnlocalizedName("item_ykt_ttoku_mini");
		TTOKUYKT_LEGGINGS = new ItemYkt_Teitoku(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_ttoku_long").setUnlocalizedName("item_ykt_ttoku_long");
		TTOKUYKTB_CHESTPLATE = new ItemYkt_TeitokuB(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ykt_ttokub_mini").setUnlocalizedName("item_ykt_ttokub_mini");
		TTOKUYKTB_LEGGINGS = new ItemYkt_TeitokuB(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ykt_ttokub_long").setUnlocalizedName("item_ykt_ttokub_long");

		/* サンタコス */
		AKASHISANTA_HELMET = new ItemSantaAkashi(1, EntityEquipmentSlot.HEAD).setRegistryName("item_santaakashi_helmet").setUnlocalizedName("item_santaakashi_helmet").setCreativeTab(ChinjufuModTabs.SEASONAL);
		AKASHISANTA_CHESTPLATE = new ItemSantaAkashi(1,EntityEquipmentSlot.CHEST).setRegistryName("item_santaakashi_chestplate").setUnlocalizedName("item_santaakashi_chestplate").setCreativeTab(ChinjufuModTabs.SEASONAL);
		AKASHISANTA_LEGGINGS = new ItemSantaAkashi(2, EntityEquipmentSlot.LEGS).setRegistryName("item_santaakashi_leggings").setUnlocalizedName("item_santaakashi_leggings").setCreativeTab(ChinjufuModTabs.SEASONAL);
		AKASHISANTA_BOOTS = new ItemSantaAkashi(1,EntityEquipmentSlot.FEET).setRegistryName("item_santaakashi_boots").setUnlocalizedName("item_santaakashi_boots").setCreativeTab(ChinjufuModTabs.SEASONAL);

		KUMANOSANTA_HELMET = new ItemSantaKumano(1, EntityEquipmentSlot.HEAD).setRegistryName("item_santakumano_helmet").setUnlocalizedName("item_santakumano_helmet").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KUMANOSANTA_CHESTPLATE = new ItemSantaKumano(1,EntityEquipmentSlot.CHEST).setRegistryName("item_santakumano_chestplate").setUnlocalizedName("item_santakumano_chestplate").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KUMANOSANTA_LEGGINGS = new ItemSantaKumano(2, EntityEquipmentSlot.LEGS).setRegistryName("item_santakumano_leggings").setUnlocalizedName("item_santakumano_leggings").setCreativeTab(ChinjufuModTabs.SEASONAL);
		KUMANOSANTA_BOOTS = new ItemSantaKumano(1,EntityEquipmentSlot.FEET).setRegistryName("item_santakumano_boots").setUnlocalizedName("item_santakumano_boots").setCreativeTab(ChinjufuModTabs.SEASONAL);

		SUZUYASANTA_HELMET = new ItemSantaSuzuya(1, EntityEquipmentSlot.HEAD).setRegistryName("item_santasuzuya_helmet").setUnlocalizedName("item_santasuzuya_helmet").setCreativeTab(ChinjufuModTabs.SEASONAL);
		SUZUYASANTA_CHESTPLATE = new ItemSantaSuzuya(1,EntityEquipmentSlot.CHEST).setRegistryName("item_santasuzuya_chestplate").setUnlocalizedName("item_santasuzuya_chestplate").setCreativeTab(ChinjufuModTabs.SEASONAL);
		SUZUYASANTA_LEGGINGS = new ItemSantaSuzuya(2, EntityEquipmentSlot.LEGS).setRegistryName("item_santasuzuya_leggings").setUnlocalizedName("item_santasuzuya_leggings").setCreativeTab(ChinjufuModTabs.SEASONAL);
		SUZUYASANTA_BOOTS = new ItemSantaSuzuya(1,EntityEquipmentSlot.FEET).setRegistryName("item_santasuzuya_boots").setUnlocalizedName("item_santasuzuya_boots").setCreativeTab(ChinjufuModTabs.SEASONAL);

		RYUJOUSANTA_HELMET = new ItemSantaRyujou(1, EntityEquipmentSlot.HEAD).setRegistryName("item_santaryujou_helmet").setUnlocalizedName("item_santaryujou_helmet").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RYUJOUSANTA_CHESTPLATE = new ItemSantaRyujou(1,EntityEquipmentSlot.CHEST).setRegistryName("item_santaryujou_chestplate").setUnlocalizedName("item_santaryujou_chestplate").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RYUJOUSANTA_LEGGINGS = new ItemSantaRyujou(2, EntityEquipmentSlot.LEGS).setRegistryName("item_santaryujou_leggings").setUnlocalizedName("item_santaryujou_leggings").setCreativeTab(ChinjufuModTabs.SEASONAL);
		RYUJOUSANTA_BOOTS = new ItemSantaRyujou(1,EntityEquipmentSlot.FEET).setRegistryName("item_santaryujou_boots").setUnlocalizedName("item_santaryujou_boots").setCreativeTab(ChinjufuModTabs.SEASONAL);

		TEITOKUSANTA_HELMET = new ItemSantaTeitoku(1, EntityEquipmentSlot.HEAD).setRegistryName("item_santattk_helmet").setUnlocalizedName("item_santattk_helmet").setCreativeTab(ChinjufuModTabs.SEASONAL);
		TEITOKUSANTA_CHESTPLATE = new ItemSantaTeitoku(1,EntityEquipmentSlot.CHEST).setRegistryName("item_santattk_chestplate").setUnlocalizedName("item_santattk_chestplate").setCreativeTab(ChinjufuModTabs.SEASONAL);
		TEITOKUSANTA_LEGGINGS = new ItemSantaTeitoku(2, EntityEquipmentSlot.LEGS).setRegistryName("item_santattk_leggings").setUnlocalizedName("item_santattk_leggings").setCreativeTab(ChinjufuModTabs.SEASONAL);
		TEITOKUSANTA_BOOTS = new ItemSantaTeitoku(1,EntityEquipmentSlot.FEET).setRegistryName("item_santattk_boots").setUnlocalizedName("item_santattk_boots").setCreativeTab(ChinjufuModTabs.SEASONAL);

	}


	public static void register() {

		registerItem(WARAHAI);
		registerItem(ORIITO);
		registerItem(TANMONO);
		registerItem(AKUNABE);
		registerItem(FALL_LEAF);
		registerItem(SUIDEN);

		registerItem(SAKURA_flow);
		registerItem(KAEDE_leaf);
		registerItem(ICHOH_leaf);
		registerItem(OAKKARE_leaf);
		registerItem(SAKURA_log);
		registerItem(KAEDE_log);
		registerItem(ICHOH_log);
		registerItem(SAKURA_nae);
		registerItem(KAEDE_nae);
		registerItem(ICHOH_nae);
		registerItem(OAKKARE_nae);

		registerItem(PLANKS_sakura);
		registerItem(PLANKS_kaede);
		registerItem(PLANKS_ichoh);
		registerItem(SAKURA_slabhalf);
		registerItem(KAEDE_slabhalf);
		registerItem(ICHOH_slabhalf);
		registerItem(SAKURA_stairs);
		registerItem(KAEDE_stairs);
		registerItem(ICHOH_stairs);
		registerItem(PILLAR_saku);
		registerItem(PILLAR_kae);
		registerItem(PILLAR_ich);
		registerItem(PILLARSLAB_saku);
		registerItem(PILLARSLAB_kae);
		registerItem(PILLARSLAB_ich);

		registerItem(SAKURA_FENCE);
		registerItem(KAEDE_FENCE);
		registerItem(ICHOH_FENCE);
		registerItem(SAKURA_FGATE);
		registerItem(KAEDE_FGATE);
		registerItem(ICHOH_FGATE);

		registerItem(DOOR_SAKURA);
		registerItem(DOOR_KAEDE);
		registerItem(DOOR_ICHOH);

		registerItem(SAKURA_TRAPDOOR);
		registerItem(KAEDE_TRAPDOOR);
		registerItem(ICHOH_TRAPDOOR);
		registerItem(SAKURA_PLATE);
		registerItem(KAEDE_PLATE);
		registerItem(ICHOH_PLATE);
		registerItem(SAKURA_BUTTON);
		registerItem(KAEDE_BUTTON);
		registerItem(ICHOH_BUTTON);

		registerItem(SAKURA_carpet);
		registerItem(KAEDE_carpet);
		registerItem(ICHOH_carpet);
		registerItem(OCHIBA_carpet);

		registerItem(WP_LOG_sakura);
		registerItem(WP_LOG_kaede);
		registerItem(WP_LOG_ichoh);
		registerItem(WP_PLANK_sakura);
		registerItem(WP_PLANK_kaede);
		registerItem(WP_PLANK_ichoh);

		registerItem(GARASUDO_SAKU);
		registerItem(GARASUDO_KAE);
		registerItem(GARASUDO_ICH);
		registerItem(GARASUDOB_SAKU);
		registerItem(GARASUDOB_KAE);
		registerItem(GARASUDOB_ICH);
		registerItem(GARASUDOH_SAKU);
		registerItem(GARASUDOH_KAE);
		registerItem(GARASUDOH_ICH);

		registerItem(SHOUJI_SAKU);
		registerItem(SHOUJI_KAE);
		registerItem(SHOUJI_ICH);
		registerItem(SHOUJIA_SAKU);
		registerItem(SHOUJIA_KAE);
		registerItem(SHOUJIA_ICH);

		registerItem(SHOUJIH_SAKU);
		registerItem(SHOUJIH_KAE);
		registerItem(SHOUJIH_ICH);
		registerItem(SHOUJIWIN_sakura);
		registerItem(SHOUJIWIN_kaede);
		registerItem(SHOUJIWIN_ichoh);

		registerItem(RANMA_saku);
		registerItem(RANMA_kae);
		registerItem(RANMA_ich);
		registerItem(RANMAB_saku);
		registerItem(RANMAB_kae);
		registerItem(RANMAB_ich);
		registerItem(RANMAC_saku);
		registerItem(RANMAC_kae);
		registerItem(RANMAC_ich);
		registerItem(KANKI_saku);
		registerItem(KANKI_kae);
		registerItem(KANKI_ich);
		registerItem(KOUSHI_saku);
		registerItem(KOUSHI_kae);
		registerItem(KOUSHI_ich);
		registerItem(KOUSHIB_saku);
		registerItem(KOUSHIB_kae);
		registerItem(KOUSHIB_ich);

		registerItem(BONSAI_sakura);
		registerItem(BONSAI_kaede);
		registerItem(BONSAI_ichoh);
		registerItem(BONSAI_kare);
		registerItem(SKANYOU_BOT);
		registerItem(SIKEGAKI);
		registerItem(SIKEGAKILONG_BOT);

		registerItem(CHABUDAI);
		registerItem(KOTATSU);

		registerItem(KUSATABA);
		registerItem(WARATABA);
		registerItem(KAYATABA);
		registerItem(KUSATABA_RF);
		registerItem(WARATABA_RF);
		registerItem(KAYATABA_RF);
		registerItem(KUSATABA_STAIRS);
		registerItem(WARATABA_STAIRS);
		registerItem(KAYATABA_STAIRS);

		registerItem(SHIMENAWA);
		registerItem(NEWYEAR_XMAS);
		registerItem(PRESENT);
		registerItem(PRESENT_B);
		registerItem(SNOWCORE);
		registerItem(SNOWMAN);
		
		registerItem(HINAKAZARI);
		registerItem(HINADAN);

		registerItem(COCOA_F);
		registerItem(COCOA_R);
		registerItem(COCOA_M);
		registerItem(CHOCO_raw);
		registerItem(COCOA_TARU);
		registerItem(FOOD_CHOCO);

		registerItem(UCHIWA_white);
		registerItem(UCHIWA_orange);
		registerItem(UCHIWA_magenta);
		registerItem(UCHIWA_lightb);
		registerItem(UCHIWA_yellow);
		registerItem(UCHIWA_lime);
		registerItem(UCHIWA_pink);
		registerItem(UCHIWA_gray);
		registerItem(UCHIWA_lightg);
		registerItem(UCHIWA_cyan);
		registerItem(UCHIWA_purple);
		registerItem(UCHIWA_blue);
		registerItem(UCHIWA_brown);
		registerItem(UCHIWA_green);
		registerItem(UCHIWA_red);
		registerItem(UCHIWA_black);

		registerItem(FOOD_WATAGASHI);
		registerItem(WATAGASHI_block);
		registerItem(WATAGASHI_pink);
		registerItem(WATAGASHI_red);
		registerItem(WATAGASHI_yellow);
		registerItem(WATAGASHI_green);

		registerItem(KAKIGOURI_hata);
		registerItem(KAKIGOURI_block);
		registerItem(KAKIGOURI_pink);
		registerItem(KAKIGOURI_red);
		registerItem(KAKIGOURI_yellow);
		registerItem(KAKIGOURI_green);

		registerItem(YKTD_BOOTS);
		registerItem(YKTO_BOOTS);
		registerItem(IKADUCHIYKT_HELMET);
		registerItem(IKADUCHIYKT_CHESTPLATE);
		registerItem(IKADUCHIYKT_LEGGINGS);
		registerItem(INADUMAYKT_HELMET);
		registerItem(INADUMAYKT_CHESTPLATE);
		registerItem(INADUMAYKT_LEGGINGS);

		registerItem(HAMAKAZEYKT_HELMET);
		registerItem(HAMAKAZEYKT_CHESTPLATE);
		registerItem(HAMAKAZEYKT_LEGGINGS);
		registerItem(URAKAZEYKT_HELMET);
		registerItem(URAKAZEYKT_CHESTPLATE);
		registerItem(URAKAZEYKT_LEGGINGS);
		registerItem(KAWAKAZEYKT_HELMET);
		registerItem(KAWAKAZEYKT_CHESTPLATE);
		registerItem(KAWAKAZEYKT_LEGGINGS);
		registerItem(OBOROYKT_HELMET);
		registerItem(OBOROYKT_CHESTPLATE);
		registerItem(OBOROYKT_LEGGINGS);

		registerItem(TTOKUYKT_CHESTPLATE);
		registerItem(TTOKUYKT_LEGGINGS);
		registerItem(TTOKUYKTB_CHESTPLATE);
		registerItem(TTOKUYKTB_LEGGINGS);

		registerItem(AKASHISANTA_HELMET);
		registerItem(AKASHISANTA_CHESTPLATE);
		registerItem(AKASHISANTA_LEGGINGS);
		registerItem(AKASHISANTA_BOOTS);
		registerItem(KUMANOSANTA_HELMET);
		registerItem(KUMANOSANTA_CHESTPLATE);
		registerItem(KUMANOSANTA_LEGGINGS);
		registerItem(KUMANOSANTA_BOOTS);
		registerItem(SUZUYASANTA_HELMET);
		registerItem(SUZUYASANTA_CHESTPLATE);
		registerItem(SUZUYASANTA_LEGGINGS);
		registerItem(SUZUYASANTA_BOOTS);
		registerItem(RYUJOUSANTA_HELMET);
		registerItem(RYUJOUSANTA_CHESTPLATE);
		registerItem(RYUJOUSANTA_LEGGINGS);
		registerItem(RYUJOUSANTA_BOOTS);
		registerItem(TEITOKUSANTA_HELMET);
		registerItem(TEITOKUSANTA_CHESTPLATE);
		registerItem(TEITOKUSANTA_LEGGINGS);
		registerItem(TEITOKUSANTA_BOOTS);


	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(WARAHAI);
		registerRender(ORIITO);
		registerRender(TANMONO);
		registerRender(AKUNABE);
		registerRender(FALL_LEAF);
		registerRender(SUIDEN);

		registerRender(SAKURA_flow);
		registerRender(KAEDE_leaf);
		registerRender(ICHOH_leaf);
		registerRender(OAKKARE_leaf);
		registerRender(SAKURA_log);
		registerRender(KAEDE_log);
		registerRender(ICHOH_log);
		registerRender(SAKURA_nae);
		registerRender(KAEDE_nae);
		registerRender(ICHOH_nae);
		registerRender(OAKKARE_nae);

		registerRender(PLANKS_sakura);
		registerRender(PLANKS_kaede);
		registerRender(PLANKS_ichoh);
		registerRender(SAKURA_slabhalf);
		registerRender(KAEDE_slabhalf);
		registerRender(ICHOH_slabhalf);
		registerRender(SAKURA_stairs);
		registerRender(KAEDE_stairs);
		registerRender(ICHOH_stairs);
		registerRender(PILLAR_saku);
		registerRender(PILLAR_kae);
		registerRender(PILLAR_ich);
		registerRender(PILLARSLAB_saku);
		registerRender(PILLARSLAB_kae);
		registerRender(PILLARSLAB_ich);

		registerRender(SAKURA_FENCE);
		registerRender(KAEDE_FENCE);
		registerRender(ICHOH_FENCE);
		registerRender(SAKURA_FGATE);
		registerRender(KAEDE_FGATE);
		registerRender(ICHOH_FGATE);

		registerRender(DOOR_SAKURA);
		registerRender(DOOR_KAEDE);
		registerRender(DOOR_ICHOH);

		registerRender(SAKURA_TRAPDOOR);
		registerRender(KAEDE_TRAPDOOR);
		registerRender(ICHOH_TRAPDOOR);
		registerRender(SAKURA_PLATE);
		registerRender(KAEDE_PLATE);
		registerRender(ICHOH_PLATE);
		registerRender(SAKURA_BUTTON);
		registerRender(KAEDE_BUTTON);
		registerRender(ICHOH_BUTTON);

		registerRender(SAKURA_carpet);
		registerRender(KAEDE_carpet);
		registerRender(ICHOH_carpet);
		registerRender(OCHIBA_carpet);

		registerRender(WP_LOG_sakura);
		registerRender(WP_LOG_kaede);
		registerRender(WP_LOG_ichoh);
		registerRender(WP_PLANK_sakura);
		registerRender(WP_PLANK_kaede);
		registerRender(WP_PLANK_ichoh);

		registerRender(GARASUDO_SAKU);
		registerRender(GARASUDO_KAE);
		registerRender(GARASUDO_ICH);
		registerRender(GARASUDOB_SAKU);
		registerRender(GARASUDOB_KAE);
		registerRender(GARASUDOB_ICH);
		registerRender(GARASUDOH_SAKU);
		registerRender(GARASUDOH_KAE);
		registerRender(GARASUDOH_ICH);

		registerRender(SHOUJI_SAKU);
		registerRender(SHOUJI_KAE);
		registerRender(SHOUJI_ICH);
		registerRender(SHOUJIA_SAKU);
		registerRender(SHOUJIA_KAE);
		registerRender(SHOUJIA_ICH);

		registerRender(SHOUJIH_SAKU);
		registerRender(SHOUJIH_KAE);
		registerRender(SHOUJIH_ICH);
		registerRender(SHOUJIWIN_sakura);
		registerRender(SHOUJIWIN_kaede);
		registerRender(SHOUJIWIN_ichoh);

		registerRender(RANMA_saku);
		registerRender(RANMA_kae);
		registerRender(RANMA_ich);
		registerRender(RANMAB_saku);
		registerRender(RANMAB_kae);
		registerRender(RANMAB_ich);
		registerRender(RANMAC_saku);
		registerRender(RANMAC_kae);
		registerRender(RANMAC_ich);
		registerRender(KANKI_saku);
		registerRender(KANKI_kae);
		registerRender(KANKI_ich);
		registerRender(KOUSHI_saku);
		registerRender(KOUSHI_kae);
		registerRender(KOUSHI_ich);
		registerRender(KOUSHIB_saku);
		registerRender(KOUSHIB_kae);
		registerRender(KOUSHIB_ich);

		registerRender(BONSAI_sakura);
		registerRender(BONSAI_kaede);
		registerRender(BONSAI_ichoh);
		registerRender(BONSAI_kare);
		registerRenderMeta(SKANYOU_BOT, 0, "block_kanyousakura_bot");
		registerRenderMeta(SKANYOU_BOT, 1, "block_kanyoukaede_bot");
		registerRenderMeta(SKANYOU_BOT, 2, "block_kanyouichoh_bot");
		registerRenderMeta(SKANYOU_BOT, 3, "block_kanyouoakkare_bot");
		registerRenderMeta(SIKEGAKI, 0, "block_low_sakura");
		registerRenderMeta(SIKEGAKI, 1, "block_low_kaede");
		registerRenderMeta(SIKEGAKI, 2, "block_low_ichoh");
		registerRenderMeta(SIKEGAKI, 3, "block_low_oakkare");
		registerRenderMeta(SIKEGAKILONG_BOT, 0, "block_longsakura_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 1, "block_longkaede_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 2, "block_longichoh_bot");
		registerRenderMeta(SIKEGAKILONG_BOT, 3, "block_longoakkare_bot");

		registerRenderMeta(CHABUDAI, 0, "block_chabudai");
		registerRenderMeta(CHABUDAI, 1, "block_chabudai_spruce");
		registerRenderMeta(CHABUDAI, 2, "block_chabudai_birch");
		registerRenderMeta(CHABUDAI, 3, "block_chabudai_jungle");
		registerRenderMeta(CHABUDAI, 4, "block_chabudai_acacia");
		registerRenderMeta(CHABUDAI, 5, "block_chabudai_darkoak");
		registerRenderMeta(CHABUDAI, 6, "block_chabudai_sakura");
		registerRenderMeta(CHABUDAI, 7, "block_chabudai_kaede");
		registerRenderMeta(CHABUDAI, 8, "block_chabudai_ichoh");

		registerRenderMeta(KOTATSU, 0, "block_kotatsu");
		registerRenderMeta(KOTATSU, 1, "block_kotatsu_spruce");
		registerRenderMeta(KOTATSU, 2, "block_kotatsu_birch");
		registerRenderMeta(KOTATSU, 3, "block_kotatsu_jungle");
		registerRenderMeta(KOTATSU, 4, "block_kotatsu_acacia");
		registerRenderMeta(KOTATSU, 5, "block_kotatsu_darkoak");
		registerRenderMeta(KOTATSU, 6, "block_kotatsu_sakura");
		registerRenderMeta(KOTATSU, 7, "block_kotatsu_kaede");
		registerRenderMeta(KOTATSU, 8, "block_kotatsu_ichoh");

		registerRender(KUSATABA);
		registerRender(WARATABA);
		registerRender(KAYATABA);
		registerRender(KUSATABA_RF);
		registerRender(WARATABA_RF);
		registerRender(KAYATABA_RF);
		registerRender(KUSATABA_STAIRS);
		registerRender(WARATABA_STAIRS);
		registerRender(KAYATABA_STAIRS);

		registerRender(SHIMENAWA);
		registerRenderMeta(NEWYEAR_XMAS, 1, "block_kadomatsu");
		registerRenderMeta(NEWYEAR_XMAS, 2, "block_kagamimochi");
		registerRenderMeta(NEWYEAR_XMAS, 3, "block_xmastree");
		registerRenderMeta(NEWYEAR_XMAS, 4, "block_xmastree_w");
		registerRenderMeta(PRESENT, 1, "block_present_app");
		registerRenderMeta(PRESENT, 2, "block_present_bok");
		registerRenderMeta(PRESENT, 3, "block_present_dia");
		registerRenderMeta(PRESENT, 4, "block_present_lap");
		registerRenderMeta(PRESENT_B, 1, "block_present_bla");
		registerRenderMeta(PRESENT_B, 2, "block_present_chc");
		registerRenderMeta(PRESENT_B, 3, "block_present_chh");
		registerRender(SNOWCORE);
		registerRender(SNOWMAN);
		
		registerRender(HINAKAZARI);
		registerRender(HINADAN);

		registerRender(COCOA_F);
		registerRender(COCOA_R);
		registerRender(COCOA_M);
		registerRender(CHOCO_raw);
		registerRender(COCOA_TARU);
		registerRenderMeta(FOOD_CHOCO, 1, "item_food_choco");
		registerRenderMeta(FOOD_CHOCO, 2, "item_food_choco_apple");
		registerRenderMeta(FOOD_CHOCO, 3, "item_food_choco_cherry");
		registerRenderMeta(FOOD_CHOCO, 4, "item_food_choco_grape");
		registerRenderMeta(FOOD_CHOCO, 5, "item_food_choco_greentea");
		registerRenderMeta(FOOD_CHOCO, 6, "item_food_choco_heart");

		registerRender(UCHIWA_white);
		registerRender(UCHIWA_orange);
		registerRender(UCHIWA_magenta);
		registerRender(UCHIWA_lightb);
		registerRender(UCHIWA_yellow);
		registerRender(UCHIWA_lime);
		registerRender(UCHIWA_pink);
		registerRender(UCHIWA_gray);
		registerRender(UCHIWA_lightg);
		registerRender(UCHIWA_cyan);
		registerRender(UCHIWA_purple);
		registerRender(UCHIWA_blue);
		registerRender(UCHIWA_brown);
		registerRender(UCHIWA_green);
		registerRender(UCHIWA_red);
		registerRender(UCHIWA_black);

		registerRenderMeta(FOOD_WATAGASHI, 1, "item_food_watagashi");
		registerRenderMeta(FOOD_WATAGASHI, 2, "item_food_watagashi_y");
		registerRenderMeta(FOOD_WATAGASHI, 3, "item_food_watagashi_p");
		registerRenderMeta(FOOD_WATAGASHI, 4, "item_food_watagashi_r");
		registerRenderMeta(FOOD_WATAGASHI, 5, "item_food_watagashi_g");
		registerRender(WATAGASHI_block);
		registerRender(WATAGASHI_pink);
		registerRender(WATAGASHI_red);
		registerRender(WATAGASHI_yellow);
		registerRender(WATAGASHI_green);

		registerRender(KAKIGOURI_hata);
		registerRender(KAKIGOURI_block);
		registerRender(KAKIGOURI_pink);
		registerRender(KAKIGOURI_red);
		registerRender(KAKIGOURI_yellow);
		registerRender(KAKIGOURI_green);

		registerRender(YKTD_BOOTS);
		registerRender(YKTO_BOOTS);

		registerRender(IKADUCHIYKT_HELMET);
		registerRender(IKADUCHIYKT_CHESTPLATE);
		registerRender(IKADUCHIYKT_LEGGINGS);
		registerRender(INADUMAYKT_HELMET);
		registerRender(INADUMAYKT_CHESTPLATE);
		registerRender(INADUMAYKT_LEGGINGS);

		registerRender(HAMAKAZEYKT_HELMET);
		registerRender(HAMAKAZEYKT_CHESTPLATE);
		registerRender(HAMAKAZEYKT_LEGGINGS);
		registerRender(URAKAZEYKT_HELMET);
		registerRender(URAKAZEYKT_CHESTPLATE);
		registerRender(URAKAZEYKT_LEGGINGS);
		registerRender(KAWAKAZEYKT_HELMET);
		registerRender(KAWAKAZEYKT_CHESTPLATE);
		registerRender(KAWAKAZEYKT_LEGGINGS);
		registerRender(OBOROYKT_HELMET);
		registerRender(OBOROYKT_CHESTPLATE);
		registerRender(OBOROYKT_LEGGINGS);
		registerRender(TTOKUYKT_CHESTPLATE);
		registerRender(TTOKUYKT_LEGGINGS);
		registerRender(TTOKUYKTB_CHESTPLATE);
		registerRender(TTOKUYKTB_LEGGINGS);

		registerRender(AKASHISANTA_HELMET);
		registerRender(AKASHISANTA_CHESTPLATE);
		registerRender(AKASHISANTA_LEGGINGS);
		registerRender(AKASHISANTA_BOOTS);
		registerRender(KUMANOSANTA_HELMET);
		registerRender(KUMANOSANTA_CHESTPLATE);
		registerRender(KUMANOSANTA_LEGGINGS);
		registerRender(KUMANOSANTA_BOOTS);
		registerRender(SUZUYASANTA_HELMET);
		registerRender(SUZUYASANTA_CHESTPLATE);
		registerRender(SUZUYASANTA_LEGGINGS);
		registerRender(SUZUYASANTA_BOOTS);
		registerRender(RYUJOUSANTA_HELMET);
		registerRender(RYUJOUSANTA_CHESTPLATE);
		registerRender(RYUJOUSANTA_LEGGINGS);
		registerRender(RYUJOUSANTA_BOOTS);
		registerRender(TEITOKUSANTA_HELMET);
		registerRender(TEITOKUSANTA_CHESTPLATE);
		registerRender(TEITOKUSANTA_LEGGINGS);
		registerRender(TEITOKUSANTA_BOOTS);

	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
