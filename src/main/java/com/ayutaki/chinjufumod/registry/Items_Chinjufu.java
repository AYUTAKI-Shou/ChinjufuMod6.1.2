package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.chair.Bench_acacia;
import com.ayutaki.chinjufumod.blocks.chair.Bench_birch;
import com.ayutaki.chinjufumod.blocks.chair.Bench_doak;
import com.ayutaki.chinjufumod.blocks.chair.Bench_ichoh;
import com.ayutaki.chinjufumod.blocks.chair.Bench_jungle;
import com.ayutaki.chinjufumod.blocks.chair.Bench_kaede;
import com.ayutaki.chinjufumod.blocks.chair.Bench_oak;
import com.ayutaki.chinjufumod.blocks.chair.Bench_sakura;
import com.ayutaki.chinjufumod.blocks.chair.Bench_spruce;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_black;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_blue;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_brown;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_cyan;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_gray;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_green;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_leather;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_lightblue;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_lightgray;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_lime;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_magenta;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_orange;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_pink;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_purple;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_red;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_white;
import com.ayutaki.chinjufumod.blocks.chair.Sofa_yellow;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStamp;
import com.ayutaki.chinjufumod.blocks.cmblock.BauxiteOre;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_bot;
import com.ayutaki.chinjufumod.blocks.furniture.HangLamp;
import com.ayutaki.chinjufumod.blocks.furniture.MarineLamp;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.harbor.Keikai;
import com.ayutaki.chinjufumod.blocks.school.BlackBoard;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_joint;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_topk;
import com.ayutaki.chinjufumod.items.chair.ItemAdmiralChair;
import com.ayutaki.chinjufumod.items.chair.ItemCafeChair;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_acacia;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_birch;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_darkoak;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_ichoh;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_jungle;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_kaede;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_oak;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_sakura;
import com.ayutaki.chinjufumod.items.chair.ItemDinnerChair_spruce;
import com.ayutaki.chinjufumod.items.chair.ItemLogChair;
import com.ayutaki.chinjufumod.items.chinjufu.ItemAdmiralStamp;
import com.ayutaki.chinjufumod.items.chinjufu.ItemChinjufuInfo;
import com.ayutaki.chinjufumod.items.chinjufu.ItemShouhou;
import com.ayutaki.chinjufumod.items.cmblock.Item_AlumiBlock;
import com.ayutaki.chinjufumod.items.cmblock.Item_AmuBauxBox;
import com.ayutaki.chinjufumod.items.cmblock.Item_OilDrum;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel300;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_a;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_b;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_d;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_ich;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_j;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_kae;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_s;
import com.ayutaki.chinjufumod.items.furniture.ItemDressingTable_saku;
import com.ayutaki.chinjufumod.items.lamp.ItemCandle;
import com.ayutaki.chinjufumod.items.unitblock.ItemCafeTable;
import com.ayutaki.chinjufumod.items.unitblock.ItemLetterTray;
import com.ayutaki.chinjufumod.items.unitblock.ItemLowDesk;
import com.ayutaki.chinjufumod.items.unitblock.ItemUnitDesk;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_acacia;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_birch;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_darkoak;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_ichoh;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_jungle;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_kaede;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_oak;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_sakura;
import com.ayutaki.chinjufumod.items.window.ItemWindowB_spruce;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_acacia;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_birch;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_darkoak;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_ichoh;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_jungle;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_kaede;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_oak;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_sakura;
import com.ayutaki.chinjufumod.items.window.ItemWindowTallBot_spruce;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_acacia;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_birch;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_darkoak;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_ichoh;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_jungle;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_kaede;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_oak;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_sakura;
import com.ayutaki.chinjufumod.items.window.ItemWindowTall_spruce;
import com.ayutaki.chinjufumod.items.window.ItemWindow_acacia;
import com.ayutaki.chinjufumod.items.window.ItemWindow_birch;
import com.ayutaki.chinjufumod.items.window.ItemWindow_darkoak;
import com.ayutaki.chinjufumod.items.window.ItemWindow_ichoh;
import com.ayutaki.chinjufumod.items.window.ItemWindow_jungle;
import com.ayutaki.chinjufumod.items.window.ItemWindow_kaede;
import com.ayutaki.chinjufumod.items.window.ItemWindow_oak;
import com.ayutaki.chinjufumod.items.window.ItemWindow_sakura;
import com.ayutaki.chinjufumod.items.window.ItemWindow_spruce;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Chinjufu {

	public static Item EMBLEM_C;
	public static Item ADMIRAL_STAMP, ADMIRAL_STAMP_B, WORK_ORDER;
	public static Item SHOUHOU_empty, SHOUHOU;
	
	public static Item BAUXITE, ALUMINUM;
	public static Item SUMI;

	public static Item BAUXITE_ORE;
	public static Item OIL_DRUM;
	public static Item EMPTY_BOX, AMUBAUX, ALUMI;
	public static Item B_ADMIRAL_STAMP;

	public static Item DRESSINGTABLE, DRESSINGTABLE_s,DRESSINGTABLE_b,
								DRESSINGTABLE_j, DRESSINGTABLE_a, DRESSINGTABLE_d,
								DRESSINGTABLE_saku, DRESSINGTABLE_kae, DRESSINGTABLE_ich;
	public static Item UNITDESK, CAFETABLE;

	public static Item DININGCHAIR, DININGCHAIR_s, DININGCHAIR_b,
								DININGCHAIR_j, DININGCHAIR_a, DININGCHAIR_d,
								DININGCHAIR_saku, DININGCHAIR_kae, DININGCHAIR_ich;
	public static Item LOGCHAIR, CAFECHAIR;
	public static Item SOFA_leather, SOFA_white, SOFA_orange, SOFA_magenta, SOFA_lightb,
								SOFA_yellow, SOFA_lime, SOFA_pink, SOFA_gray,
								SOFA_lightg, SOFA_cyan, SOFA_purple, SOFA_blue,
								SOFA_brown, SOFA_green, SOFA_red, SOFA_black;
	public static Item BENCH, BENCH_spru, BENCH_bir,
								BENCH_jun, BENCH_aca, BENCH_doak,
								BENCH_saku, BENCH_kae, BENCH_ich;

	public static Item SCHOOLCHAIR, SCHOOLCHAIR_s,SCHOOLCHAIR_b,
								SCHOOLCHAIR_j, SCHOOLCHAIR_a, SCHOOLCHAIR_d,
								SCHOOLCHAIR_saku, SCHOOLCHAIR_kae, SCHOOLCHAIR_ich;
	public static Item SCHOOLDESK, SCHOOLDESK_s,SCHOOLDESK_b,
								SCHOOLDESK_j, SCHOOLDESK_a, SCHOOLDESK_d,
								SCHOOLDESK_saku, SCHOOLDESK_kae, SCHOOLDESK_ich;
	public static Item TEACHERDESK, TEACHERDESK_s,TEACHERDESK_b,
								TEACHERDESK_j, TEACHERDESK_a, TEACHERDESK_d,
								TEACHERDESK_saku, TEACHERDESK_kae, TEACHERDESK_ich;

	public static Item LOWDESK, LETTERTRAY, BLACKBOARD;

	public static Item WINDOW_oak, WINDOW_spruce, WINDOW_birch,
								WINDOW_jungle, WINDOW_acacia, WINDOW_darkoak,
								WINDOW_sakura, WINDOW_kaede, WINDOW_ichoh;
	public static Item WINDOWB_oak, WINDOWB_spruce, WINDOWB_birch,
								WINDOWB_jungle, WINDOWB_acacia, WINDOWB_darkoak,
								WINDOWB_sakura, WINDOWB_kaede, WINDOWB_ichoh;
	public static Item WINDOWTALLBOT_oak, WINDOWTALLBOT_spruce, WINDOWTALLBOT_birch,
								WINDOWTALLBOT_jungle, WINDOWTALLBOT_acacia, WINDOWTALLBOT_darkoak,
								WINDOWTALLBOT_sakura, WINDOWTALLBOT_kaede, WINDOWTALLBOT_ichoh;
	public static Item WINDOWTALL_oak, WINDOWTALL_spruce, WINDOWTALL_birch,
								WINDOWTALL_jungle, WINDOWTALL_acacia, WINDOWTALL_darkoak,
								WINDOWTALL_sakura, WINDOWTALL_kaede, WINDOWTALL_ichoh;

	public static Item STOVECHIMNEY, STOVECHIMNEY_joint, STOVECHIMNEY_topk;
	public static Item CSTOVE_bot;

	public static Item CANDLE;
	public static Item LAMP, STANDARM, STAND, M_LAMP;

	public static Item ADMIRALCHAIR;
	public static Item TANSU_OAK, DOAK_TANSU, SPRUCE_TANSU;

	public static Item KEIKAIBLOCK;

	public static Item KEIRYUKUI,KEIRYUKUI_b;

	public static Item TRUSS, TRUSS_white, TRUSS_orange, TRUSS_magenta,
								TRUSS_lightb, TRUSS_yellow, TRUSS_lime, TRUSS_pink,
								TRUSS_gray, TRUSS_cyan, TRUSS_purple, TRUSS_blue,
								TRUSS_brown, TRUSS_green, TRUSS_red, TRUSS_black;


	/* アイテムのインスタンスを生成 Instantiate an item. */
	public static void init() {

		EMBLEM_C = new Item().setRegistryName("item_emblem_c").setUnlocalizedName("item_emblem_c");
		ADMIRAL_STAMP = new ItemAdmiralStamp("item_admiralstamp");
		ADMIRAL_STAMP_B = new ItemAdmiralStamp("item_admiralstamp_b").setCreativeTab(ChinjufuModTabs.CHINJUFU);
		WORK_ORDER = new ItemChinjufuInfo("item_workorder");
		SHOUHOU_empty = new ItemChinjufuInfo("item_shouhou_empty");
		SHOUHOU = new ItemShouhou("item_shouhou");
		
		BAUXITE = new ItemChinjufuInfo("item_bauxite");
		ALUMINUM = new ItemChinjufuInfo("item_ingot_alumi");
		SUMI = new ItemChinjufuInfo("item_sumi_c");

		BAUXITE_ORE = new ItemBlock_noFuel(Chinjufu_Blocks.BAUXITE_ORE, BauxiteOre.ID);
		OIL_DRUM = new Item_OilDrum();
		EMPTY_BOX = new ItemBlock_Fuel100(Chinjufu_Blocks.EMPTY_BOX, EmptyBox.ID);
		AMUBAUX = new Item_AmuBauxBox();
		ALUMI = new Item_AlumiBlock();
		B_ADMIRAL_STAMP = new ItemBlock_noFuel(Chinjufu_Blocks.B_ADMIRAL_STAMP, AdmiralStamp.ID);

		DRESSINGTABLE = new ItemDressingTable();
		DRESSINGTABLE_s = new ItemDressingTable_s();
		DRESSINGTABLE_b = new ItemDressingTable_b();
		DRESSINGTABLE_j = new ItemDressingTable_j();
		DRESSINGTABLE_a = new ItemDressingTable_a();
		DRESSINGTABLE_d = new ItemDressingTable_d();
		DRESSINGTABLE_saku = new ItemDressingTable_saku();
		DRESSINGTABLE_kae = new ItemDressingTable_kae();
		DRESSINGTABLE_ich = new ItemDressingTable_ich();

		UNITDESK = new ItemUnitDesk();
		CAFETABLE = new ItemCafeTable();

		DININGCHAIR = new ItemDinnerChair_oak();
		DININGCHAIR_s = new ItemDinnerChair_spruce();
		DININGCHAIR_b = new ItemDinnerChair_birch();
		DININGCHAIR_j = new ItemDinnerChair_jungle();
		DININGCHAIR_a = new ItemDinnerChair_acacia();
		DININGCHAIR_d = new ItemDinnerChair_darkoak();
		DININGCHAIR_saku = new ItemDinnerChair_sakura();
		DININGCHAIR_kae = new ItemDinnerChair_kaede();
		DININGCHAIR_ich = new ItemDinnerChair_ichoh();

		LOGCHAIR = new ItemLogChair();
		CAFECHAIR = new ItemCafeChair();

		SOFA_leather = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_leather, Sofa_leather.ID);
		SOFA_white = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_white, Sofa_white.ID);
		SOFA_orange = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_orange, Sofa_orange.ID);
		SOFA_magenta = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_magenta, Sofa_magenta.ID);
		SOFA_lightb = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_lightb, Sofa_lightblue.ID);
		SOFA_yellow = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_yellow, Sofa_yellow.ID);
		SOFA_lime = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_lime, Sofa_lime.ID);
		SOFA_pink = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_pink, Sofa_pink.ID);
		SOFA_gray = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_gray, Sofa_gray.ID);
		SOFA_lightg = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_lightg, Sofa_lightgray.ID);
		SOFA_cyan = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_cyan, Sofa_cyan.ID);
		SOFA_purple = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_purple, Sofa_purple.ID);
		SOFA_blue = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_blue, Sofa_blue.ID);
		SOFA_brown = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_brown, Sofa_brown.ID);
		SOFA_green = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_green, Sofa_green.ID);
		SOFA_red = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_red, Sofa_red.ID);
		SOFA_black = new ItemBlock_Fuel150(Furniture_Blocks.SOFA_black, Sofa_black.ID);

		BENCH = new ItemBlock_Fuel150(Furniture_Blocks.BENCH, Bench_oak.ID);
		BENCH_spru = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_spru, Bench_spruce.ID);
		BENCH_bir = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_bir, Bench_birch.ID);
		BENCH_jun = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_jun, Bench_jungle.ID);
		BENCH_aca = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_aca, Bench_acacia.ID);
		BENCH_doak = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_doak, Bench_doak.ID);
		BENCH_saku = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_saku, Bench_sakura.ID);
		BENCH_kae = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_kae, Bench_kaede.ID);
		BENCH_ich = new ItemBlock_Fuel150(Furniture_Blocks.BENCH_ich, Bench_ichoh.ID);

		SCHOOLCHAIR = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR, "block_schoolchair");
		SCHOOLCHAIR_s = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_s, "block_schoolchair_s");
		SCHOOLCHAIR_b = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_b, "block_schoolchair_b");
		SCHOOLCHAIR_j = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_j, "block_schoolchair_j");
		SCHOOLCHAIR_a = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_a, "block_schoolchair_a");
		SCHOOLCHAIR_d = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_d, "block_schoolchair_d");
		SCHOOLCHAIR_saku = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_saku, "block_schoolchair_saku");
		SCHOOLCHAIR_kae = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_kae, "block_schoolchair_kae");
		SCHOOLCHAIR_ich = new ItemBlock_Fuel150(Furniture_Blocks.SCHOOLCHAIR_ich, "block_schoolchair_ich");

		SCHOOLDESK = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK, "block_schooldesk");
		SCHOOLDESK_s = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_s, "block_schooldesk_s");
		SCHOOLDESK_b = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_b, "block_schooldesk_b");
		SCHOOLDESK_j = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_j, "block_schooldesk_j");
		SCHOOLDESK_a = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_a, "block_schooldesk_a");
		SCHOOLDESK_d = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_d, "block_schooldesk_d");
		SCHOOLDESK_saku = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_saku, "block_schooldesk_saku");
		SCHOOLDESK_kae = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_kae, "block_schooldesk_kae");
		SCHOOLDESK_ich = new ItemBlock_Fuel200(Furniture_Blocks.SCHOOLDESK_ich, "block_schooldesk_ich");

		TEACHERDESK = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK, "block_teacherdesk");
		TEACHERDESK_s = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_s, "block_teacherdesk_s");
		TEACHERDESK_b = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_b, "block_teacherdesk_b");
		TEACHERDESK_j = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_j, "block_teacherdesk_j");
		TEACHERDESK_a = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_a, "block_teacherdesk_a");
		TEACHERDESK_d = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_d, "block_teacherdesk_d");
		TEACHERDESK_saku = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_saku, "block_teacherdesk_saku");
		TEACHERDESK_kae = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_kae, "block_teacherdesk_kae");
		TEACHERDESK_ich = new ItemBlock_Fuel300(Furniture_Blocks.TEACHERDESK_ich, "block_teacherdesk_ich");

		LOWDESK = new ItemLowDesk();
		LETTERTRAY = new ItemLetterTray();
		BLACKBOARD = new ItemBlock_noFuel(Furniture_Blocks.BLACKBOARD, BlackBoard.ID);

		WINDOW_oak = new ItemWindow_oak();
		WINDOW_spruce = new ItemWindow_spruce();
		WINDOW_birch = new ItemWindow_birch();
		WINDOW_jungle = new ItemWindow_jungle();
		WINDOW_acacia = new ItemWindow_acacia();
		WINDOW_darkoak = new ItemWindow_darkoak();
		WINDOW_sakura = new ItemWindow_sakura();
		WINDOW_kaede = new ItemWindow_kaede();
		WINDOW_ichoh = new ItemWindow_ichoh();

		WINDOWB_oak = new ItemWindowB_oak();
		WINDOWB_spruce = new ItemWindowB_spruce();
		WINDOWB_birch = new ItemWindowB_birch();
		WINDOWB_jungle = new ItemWindowB_jungle();
		WINDOWB_acacia = new ItemWindowB_acacia();
		WINDOWB_darkoak = new ItemWindowB_darkoak();
		WINDOWB_sakura = new ItemWindowB_sakura();
		WINDOWB_kaede = new ItemWindowB_kaede();
		WINDOWB_ichoh = new ItemWindowB_ichoh();

		WINDOWTALLBOT_oak = new ItemWindowTallBot_oak();
		WINDOWTALLBOT_spruce = new ItemWindowTallBot_spruce();
		WINDOWTALLBOT_birch = new ItemWindowTallBot_birch();
		WINDOWTALLBOT_jungle = new ItemWindowTallBot_jungle();
		WINDOWTALLBOT_acacia = new ItemWindowTallBot_acacia();
		WINDOWTALLBOT_darkoak = new ItemWindowTallBot_darkoak();
		WINDOWTALLBOT_sakura = new ItemWindowTallBot_sakura();
		WINDOWTALLBOT_kaede = new ItemWindowTallBot_kaede();
		WINDOWTALLBOT_ichoh = new ItemWindowTallBot_ichoh();

		WINDOWTALL_oak = new ItemWindowTall_oak();
		WINDOWTALL_spruce = new ItemWindowTall_spruce();
		WINDOWTALL_birch = new ItemWindowTall_birch();
		WINDOWTALL_jungle = new ItemWindowTall_jungle();
		WINDOWTALL_acacia = new ItemWindowTall_acacia();
		WINDOWTALL_darkoak = new ItemWindowTall_darkoak();
		WINDOWTALL_sakura = new ItemWindowTall_sakura();
		WINDOWTALL_kaede = new ItemWindowTall_kaede();
		WINDOWTALL_ichoh = new ItemWindowTall_ichoh();

		STOVECHIMNEY = new ItemBlock_noFuel(Furniture_Blocks.STOVECHIMNEY, StoveChimney.ID);
		STOVECHIMNEY_joint = new ItemBlock_noFuel(Furniture_Blocks.STOVECHIMNEY_joint, StoveChimney_joint.ID);
		STOVECHIMNEY_topk = new ItemBlock_noFuel(Furniture_Blocks.STOVECHIMNEY_topk, StoveChimney_topk.ID);
		CSTOVE_bot = new ItemBlock_noFuel(Furniture_Blocks.CSTOVE_bot, CStove_bot.ID);

		CANDLE = new ItemCandle();
		LAMP = new ItemBlock_noFuel(Lamp_Blocks.LAMP, HangLamp.ID);
		STANDARM = new ItemBlock_noFuel(Lamp_Blocks.STANDARM, StandArm.ID);
		STAND = new ItemBlock_noFuel(Lamp_Blocks.STAND, StandBedroom.ID);
		M_LAMP = new ItemBlock_noFuel(Lamp_Blocks.M_LAMP, MarineLamp.ID);

		ADMIRALCHAIR = new ItemAdmiralChair();
		TANSU_OAK = new ItemBlock_Fuel300(Furniture_Blocks.TANSU_OAK, "block_tansu_oak");
		DOAK_TANSU = new ItemBlock_Fuel300(Furniture_Blocks.DOAK_TANSU, "block_tansu_doak");
		SPRUCE_TANSU = new ItemBlock_Fuel300(Furniture_Blocks.SPRUCE_TANSU, "block_tansu_spruce");

		KEIKAIBLOCK = new ItemBlock_noFuel(Harbor_Blocks.KEIKAIBLOCK, Keikai.ID);

		KEIRYUKUI = new ItemBlock_noFuel(Harbor_Blocks.KEIRYUKUI, "block_keiryukui");
		KEIRYUKUI_b = new ItemBlock_noFuel(Harbor_Blocks.KEIRYUKUI_b, "block_keiryukui_b");

		TRUSS = new ItemBlock_noFuel(Harbor_Blocks.TRUSS, "block_ctruss");
		TRUSS_white = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_white, "block_ctruss_white");
		TRUSS_orange = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_orange, "block_ctruss_orange");
		TRUSS_magenta = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_magenta, "block_ctruss_magenta");
		TRUSS_lightb = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_lightb, "block_ctruss_lightb");
		TRUSS_yellow = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_yellow, "block_ctruss_yellow");
		TRUSS_lime = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_lime, "block_ctruss_lime");
		TRUSS_pink = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_pink, "block_ctruss_pink");
		TRUSS_gray = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_gray, "block_ctruss_gray");
		TRUSS_cyan = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_cyan, "block_ctruss_cyan");
		TRUSS_purple = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_purple, "block_ctruss_purple");
		TRUSS_blue = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_blue, "block_ctruss_blue");
		TRUSS_brown = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_brown, "block_ctruss_brown");
		TRUSS_green = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_green, "block_ctruss_green");
		TRUSS_red = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_red, "block_ctruss_red");
		TRUSS_black = new ItemBlock_noFuel(Harbor_Blocks.TRUSS_black, "block_ctruss_black");

	}


	/* アイテムを登録する、ここから Register Items. From here. ↓*/
	public static void register() {
		registerItem(EMBLEM_C);
		registerItem(ADMIRAL_STAMP);
		registerItem(ADMIRAL_STAMP_B);
		registerItem(WORK_ORDER);
		registerItem(SHOUHOU_empty);
		registerItem(SHOUHOU);
		
		registerItem(BAUXITE);
		registerItem(ALUMINUM);
		registerItem(SUMI);

		registerItem(BAUXITE_ORE);
		registerItem(OIL_DRUM);
		registerItem(EMPTY_BOX);
		registerItem(AMUBAUX);
		registerItem(ALUMI);
		registerItem(B_ADMIRAL_STAMP);

		registerItem(DRESSINGTABLE);
		registerItem(DRESSINGTABLE_s);
		registerItem(DRESSINGTABLE_b);
		registerItem(DRESSINGTABLE_j);
		registerItem(DRESSINGTABLE_a);
		registerItem(DRESSINGTABLE_d);
		registerItem(DRESSINGTABLE_saku);
		registerItem(DRESSINGTABLE_kae);
		registerItem(DRESSINGTABLE_ich);

		registerItem(UNITDESK);
		registerItem(CAFETABLE);

		registerItem(DININGCHAIR);
		registerItem(DININGCHAIR_s);
		registerItem(DININGCHAIR_b);
		registerItem(DININGCHAIR_j);
		registerItem(DININGCHAIR_a);
		registerItem(DININGCHAIR_d);
		registerItem(DININGCHAIR_saku);
		registerItem(DININGCHAIR_kae);
		registerItem(DININGCHAIR_ich);

		registerItem(LOGCHAIR);
		registerItem(CAFECHAIR);

		registerItem(SOFA_leather);
		registerItem(SOFA_white);
		registerItem(SOFA_orange);
		registerItem(SOFA_magenta);
		registerItem(SOFA_lightb);
		registerItem(SOFA_yellow);
		registerItem(SOFA_lime);
		registerItem(SOFA_pink);
		registerItem(SOFA_gray);
		registerItem(SOFA_lightg);
		registerItem(SOFA_cyan);
		registerItem(SOFA_purple);
		registerItem(SOFA_blue);
		registerItem(SOFA_brown);
		registerItem(SOFA_green);
		registerItem(SOFA_red);
		registerItem(SOFA_black);

		registerItem(BENCH);
		registerItem(BENCH_spru);
		registerItem(BENCH_bir);
		registerItem(BENCH_jun);
		registerItem(BENCH_aca);
		registerItem(BENCH_doak);
		registerItem(BENCH_saku);
		registerItem(BENCH_kae);
		registerItem(BENCH_ich);

		registerItem(SCHOOLCHAIR);
		registerItem(SCHOOLCHAIR_s);
		registerItem(SCHOOLCHAIR_b);
		registerItem(SCHOOLCHAIR_j);
		registerItem(SCHOOLCHAIR_a);
		registerItem(SCHOOLCHAIR_d);
		registerItem(SCHOOLCHAIR_saku);
		registerItem(SCHOOLCHAIR_kae);
		registerItem(SCHOOLCHAIR_ich);

		registerItem(SCHOOLDESK);
		registerItem(SCHOOLDESK_s);
		registerItem(SCHOOLDESK_b);
		registerItem(SCHOOLDESK_j);
		registerItem(SCHOOLDESK_a);
		registerItem(SCHOOLDESK_d);
		registerItem(SCHOOLDESK_saku);
		registerItem(SCHOOLDESK_kae);
		registerItem(SCHOOLDESK_ich);

		registerItem(TEACHERDESK);
		registerItem(TEACHERDESK_s);
		registerItem(TEACHERDESK_b);
		registerItem(TEACHERDESK_j);
		registerItem(TEACHERDESK_a);
		registerItem(TEACHERDESK_d);
		registerItem(TEACHERDESK_saku);
		registerItem(TEACHERDESK_kae);
		registerItem(TEACHERDESK_ich);

		registerItem(LOWDESK);
		registerItem(LETTERTRAY);
		registerItem(BLACKBOARD);

		registerItem(WINDOW_oak);
		registerItem(WINDOW_spruce );
		registerItem(WINDOW_birch );
		registerItem(WINDOW_jungle);
		registerItem(WINDOW_acacia);
		registerItem(WINDOW_darkoak);
		registerItem(WINDOW_sakura);
		registerItem(WINDOW_kaede);
		registerItem(WINDOW_ichoh);

		registerItem(WINDOWB_oak);
		registerItem(WINDOWB_spruce );
		registerItem(WINDOWB_birch );
		registerItem(WINDOWB_jungle);
		registerItem(WINDOWB_acacia);
		registerItem(WINDOWB_darkoak);
		registerItem(WINDOWB_sakura);
		registerItem(WINDOWB_kaede);
		registerItem(WINDOWB_ichoh);

		registerItem(WINDOWTALLBOT_oak);
		registerItem(WINDOWTALLBOT_spruce);
		registerItem(WINDOWTALLBOT_birch);
		registerItem(WINDOWTALLBOT_jungle);
		registerItem(WINDOWTALLBOT_acacia);
		registerItem(WINDOWTALLBOT_darkoak);
		registerItem(WINDOWTALLBOT_sakura);
		registerItem(WINDOWTALLBOT_kaede);
		registerItem(WINDOWTALLBOT_ichoh);

		registerItem(WINDOWTALL_oak);
		registerItem(WINDOWTALL_spruce);
		registerItem(WINDOWTALL_birch);
		registerItem(WINDOWTALL_jungle);
		registerItem(WINDOWTALL_acacia);
		registerItem(WINDOWTALL_darkoak);
		registerItem(WINDOWTALL_sakura);
		registerItem(WINDOWTALL_kaede);
		registerItem(WINDOWTALL_ichoh);

		registerItem(STOVECHIMNEY);
		registerItem(STOVECHIMNEY_joint);
		registerItem(STOVECHIMNEY_topk);
		registerItem(CSTOVE_bot);

		registerItem(CANDLE);
		registerItem(LAMP);
		registerItem(STANDARM);
		registerItem(STAND);
		registerItem(M_LAMP);

		registerItem(ADMIRALCHAIR);
		registerItem(TANSU_OAK);
		registerItem(DOAK_TANSU);
		registerItem(SPRUCE_TANSU);

		registerItem(KEIKAIBLOCK);

		registerItem(KEIRYUKUI);
		registerItem(KEIRYUKUI_b);

		registerItem(TRUSS);
		registerItem(TRUSS_white);
		registerItem(TRUSS_orange);
		registerItem(TRUSS_magenta);
		registerItem(TRUSS_lightb);
		registerItem(TRUSS_yellow);
		registerItem(TRUSS_lime);
		registerItem(TRUSS_pink);
		registerItem(TRUSS_gray);
		registerItem(TRUSS_cyan);
		registerItem(TRUSS_purple);
		registerItem(TRUSS_blue);
		registerItem(TRUSS_brown);
		registerItem(TRUSS_green);
		registerItem(TRUSS_red);
		registerItem(TRUSS_black);

	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}
	/*ここまで So far↑ */


	/* ドロップ時やインベントリにおける、アイテムやアイテムブロックの描画を登録。ここから↓
	* Register rendering of Items and ItemBlocks in drop and inventory. From here↓*/
	public static void registerRenders() {

		registerRender(EMBLEM_C);
		registerRender(ADMIRAL_STAMP);
		registerRender(ADMIRAL_STAMP_B);
		registerRender(WORK_ORDER);
		registerRender(SHOUHOU_empty);
		registerRender(SHOUHOU);
		
		registerRender(BAUXITE);
		registerRender(ALUMINUM);
		registerRender(SUMI);

		registerRender(BAUXITE_ORE);
		registerRender(OIL_DRUM);
		registerRender(EMPTY_BOX);
		registerRenderMeta(AMUBAUX, 1, "block_ammunition_box");
		registerRenderMeta(AMUBAUX, 2, "block_bauxite_box");
		registerRenderMeta(ALUMI, 1, "block_alumi_block");
		registerRenderMeta(ALUMI, 2, "block_steel_block");
		registerRenderMeta(ALUMI, 3, "block_gold_block");
		registerRender(B_ADMIRAL_STAMP);

		registerRender(DRESSINGTABLE);
		registerRender(DRESSINGTABLE_s);
		registerRender(DRESSINGTABLE_b);
		registerRender(DRESSINGTABLE_j);
		registerRender(DRESSINGTABLE_a);
		registerRender(DRESSINGTABLE_d);
		registerRender(DRESSINGTABLE_saku);
		registerRender(DRESSINGTABLE_kae);
		registerRender(DRESSINGTABLE_ich);

		registerRenderMeta(UNITDESK, 0, "block_unitdesk");
		registerRenderMeta(UNITDESK, 1, "block_unitdesk_spruce");
		registerRenderMeta(UNITDESK, 2, "block_unitdesk_birch");
		registerRenderMeta(UNITDESK, 3, "block_unitdesk_jungle");
		registerRenderMeta(UNITDESK, 4, "block_unitdesk_acacia");
		registerRenderMeta(UNITDESK, 5, "block_unitdesk_darkoak");
		registerRenderMeta(UNITDESK, 6, "block_unitdesk_sakura");
		registerRenderMeta(UNITDESK, 7, "block_unitdesk_kaede");
		registerRenderMeta(UNITDESK, 8, "block_unitdesk_ichoh");

		registerRenderMeta(CAFETABLE, 0, "block_cafetable");
		registerRenderMeta(CAFETABLE, 1, "block_cafetable_spruce");
		registerRenderMeta(CAFETABLE, 2, "block_cafetable_birch");
		registerRenderMeta(CAFETABLE, 3, "block_cafetable_jungle");
		registerRenderMeta(CAFETABLE, 4, "block_cafetable_acacia");
		registerRenderMeta(CAFETABLE, 5, "block_cafetable_darkoak");
		registerRenderMeta(CAFETABLE, 6, "block_cafetable_sakura");
		registerRenderMeta(CAFETABLE, 7, "block_cafetable_kaede");
		registerRenderMeta(CAFETABLE, 8, "block_cafetable_ichoh");

		registerRender(DININGCHAIR);
		registerRender(DININGCHAIR_s);
		registerRender(DININGCHAIR_b);
		registerRender(DININGCHAIR_j);
		registerRender(DININGCHAIR_a);
		registerRender(DININGCHAIR_d);
		registerRender(DININGCHAIR_saku);
		registerRender(DININGCHAIR_kae);
		registerRender(DININGCHAIR_ich);

		registerRenderMeta(LOGCHAIR, 0, "block_logchair");
		registerRenderMeta(LOGCHAIR, 1, "block_logchair_spruce");
		registerRenderMeta(LOGCHAIR, 2, "block_logchair_birch");
		registerRenderMeta(LOGCHAIR, 3, "block_logchair_jungle");
		registerRenderMeta(LOGCHAIR, 4, "block_logchair_acacia");
		registerRenderMeta(LOGCHAIR, 5, "block_logchair_darkoak");
		registerRenderMeta(LOGCHAIR, 6, "block_logchair_sakura");
		registerRenderMeta(LOGCHAIR, 7, "block_logchair_kaede");
		registerRenderMeta(LOGCHAIR, 8, "block_logchair_ichoh");

		registerRenderMeta(CAFECHAIR, 0, "block_cafechair_white");
		registerRenderMeta(CAFECHAIR, 1, "block_cafechair_orange");
		registerRenderMeta(CAFECHAIR, 2, "block_cafechair_magenta");
		registerRenderMeta(CAFECHAIR, 3, "block_cafechair_lightb");
		registerRenderMeta(CAFECHAIR, 4, "block_cafechair_yellow");
		registerRenderMeta(CAFECHAIR, 5, "block_cafechair_lime");
		registerRenderMeta(CAFECHAIR, 6, "block_cafechair_pink");
		registerRenderMeta(CAFECHAIR, 7, "block_cafechair_gray");
		registerRenderMeta(CAFECHAIR, 8, "block_cafechair_lightg");
		registerRenderMeta(CAFECHAIR, 9, "block_cafechair_cyan");
		registerRenderMeta(CAFECHAIR, 10, "block_cafechair_purple");
		registerRenderMeta(CAFECHAIR, 11, "block_cafechair_blue");
		registerRenderMeta(CAFECHAIR, 12, "block_cafechair_brown");
		registerRenderMeta(CAFECHAIR, 13, "block_cafechair_green");
		registerRenderMeta(CAFECHAIR, 14, "block_cafechair_red");
		registerRenderMeta(CAFECHAIR, 15, "block_cafechair_black");

		registerRender(SOFA_leather);
		registerRender(SOFA_white);
		registerRender(SOFA_orange);
		registerRender(SOFA_magenta);
		registerRender(SOFA_lightb);
		registerRender(SOFA_yellow);
		registerRender(SOFA_lime);
		registerRender(SOFA_pink);
		registerRender(SOFA_gray);
		registerRender(SOFA_lightg);
		registerRender(SOFA_cyan);
		registerRender(SOFA_purple);
		registerRender(SOFA_blue);
		registerRender(SOFA_brown);
		registerRender(SOFA_green);
		registerRender(SOFA_red);
		registerRender(SOFA_black);

		registerRender(BENCH);
		registerRender(BENCH_spru);
		registerRender(BENCH_bir);
		registerRender(BENCH_jun);
		registerRender(BENCH_aca);
		registerRender(BENCH_doak);
		registerRender(BENCH_saku);
		registerRender(BENCH_kae);
		registerRender(BENCH_ich);

		registerRender(SCHOOLCHAIR);
		registerRender(SCHOOLCHAIR_s);
		registerRender(SCHOOLCHAIR_b);
		registerRender(SCHOOLCHAIR_j);
		registerRender(SCHOOLCHAIR_a);
		registerRender(SCHOOLCHAIR_d);
		registerRender(SCHOOLCHAIR_saku);
		registerRender(SCHOOLCHAIR_kae);
		registerRender(SCHOOLCHAIR_ich);

		registerRender(SCHOOLDESK);
		registerRender(SCHOOLDESK_s);
		registerRender(SCHOOLDESK_b);
		registerRender(SCHOOLDESK_j);
		registerRender(SCHOOLDESK_a);
		registerRender(SCHOOLDESK_d);
		registerRender(SCHOOLDESK_saku);
		registerRender(SCHOOLDESK_kae);
		registerRender(SCHOOLDESK_ich);

		registerRender(TEACHERDESK);
		registerRender(TEACHERDESK_s);
		registerRender(TEACHERDESK_b);
		registerRender(TEACHERDESK_j);
		registerRender(TEACHERDESK_a);
		registerRender(TEACHERDESK_d);
		registerRender(TEACHERDESK_saku);
		registerRender(TEACHERDESK_kae);
		registerRender(TEACHERDESK_ich);

		registerRenderMeta(LOWDESK, 0, "block_lowdesk");
		registerRenderMeta(LOWDESK, 1, "block_lowdesk_spruce");
		registerRenderMeta(LOWDESK, 2, "block_lowdesk_birch");
		registerRenderMeta(LOWDESK, 3, "block_lowdesk_jungle");
		registerRenderMeta(LOWDESK, 4, "block_lowdesk_acacia");
		registerRenderMeta(LOWDESK, 5, "block_lowdesk_darkoak");
		registerRenderMeta(LOWDESK, 6, "block_lowdesk_sakura");
		registerRenderMeta(LOWDESK, 7, "block_lowdesk_kaede");
		registerRenderMeta(LOWDESK, 8, "block_lowdesk_ichoh");

		registerRenderMeta(LETTERTRAY, 1, "block_lettertray_c");
		registerRenderMeta(LETTERTRAY, 2, "block_fudetray_c");
		registerRender(BLACKBOARD);

		registerRender(WINDOW_oak);
		registerRender(WINDOW_spruce );
		registerRender(WINDOW_birch );
		registerRender(WINDOW_jungle);
		registerRender(WINDOW_acacia);
		registerRender(WINDOW_darkoak);
		registerRender(WINDOW_sakura);
		registerRender(WINDOW_kaede);
		registerRender(WINDOW_ichoh);

		registerRender(WINDOWB_oak);
		registerRender(WINDOWB_spruce );
		registerRender(WINDOWB_birch );
		registerRender(WINDOWB_jungle);
		registerRender(WINDOWB_acacia);
		registerRender(WINDOWB_darkoak);
		registerRender(WINDOWB_sakura);
		registerRender(WINDOWB_kaede);
		registerRender(WINDOWB_ichoh);

		registerRender(WINDOWTALLBOT_oak);
		registerRender(WINDOWTALLBOT_spruce);
		registerRender(WINDOWTALLBOT_birch);
		registerRender(WINDOWTALLBOT_jungle);
		registerRender(WINDOWTALLBOT_acacia);
		registerRender(WINDOWTALLBOT_darkoak);
		registerRender(WINDOWTALLBOT_sakura);
		registerRender(WINDOWTALLBOT_kaede);
		registerRender(WINDOWTALLBOT_ichoh);

		registerRender(WINDOWTALL_oak);
		registerRender(WINDOWTALL_spruce);
		registerRender(WINDOWTALL_birch);
		registerRender(WINDOWTALL_jungle);
		registerRender(WINDOWTALL_acacia);
		registerRender(WINDOWTALL_darkoak);
		registerRender(WINDOWTALL_sakura);
		registerRender(WINDOWTALL_kaede);
		registerRender(WINDOWTALL_ichoh);

		registerRender(STOVECHIMNEY);
		registerRender(STOVECHIMNEY_joint);
		registerRender(STOVECHIMNEY_topk);
		registerRender(CSTOVE_bot);

		registerRenderMeta(CANDLE, 0, "block_candle_white");
		registerRenderMeta(CANDLE, 1, "block_candle_orange");
		registerRenderMeta(CANDLE, 2, "block_candle_magenta");
		registerRenderMeta(CANDLE, 3, "block_candle_lightb");
		registerRenderMeta(CANDLE, 4, "block_candle_yellow");
		registerRenderMeta(CANDLE, 5, "block_candle_lime");
		registerRenderMeta(CANDLE, 6, "block_candle_pink");
		registerRenderMeta(CANDLE, 7, "block_candle_gray");
		registerRenderMeta(CANDLE, 8, "block_candle_lightg");
		registerRenderMeta(CANDLE, 9, "block_candle_cyan");
		registerRenderMeta(CANDLE, 10, "block_candle_purple");
		registerRenderMeta(CANDLE, 11, "block_candle_blue");
		registerRenderMeta(CANDLE, 12, "block_candle_brown");
		registerRenderMeta(CANDLE, 13, "block_candle_green");
		registerRenderMeta(CANDLE, 14, "block_candle_red");
		registerRenderMeta(CANDLE, 15, "block_candle_black");

		registerRender(LAMP);
		registerRender(STANDARM);
		registerRender(STAND);
		registerRender(M_LAMP);

		registerRenderMeta(ADMIRALCHAIR, 1, "block_admiralchair");
		registerRenderMeta(ADMIRALCHAIR, 2, "block_admiralchair_red");
		registerRender(TANSU_OAK);
		registerRender(DOAK_TANSU);
		registerRender(SPRUCE_TANSU);

		registerRender(KEIKAIBLOCK);

		registerRender(KEIRYUKUI);
		registerRender(KEIRYUKUI_b);

		registerRender(TRUSS);
		registerRender(TRUSS_white);
		registerRender(TRUSS_orange);
		registerRender(TRUSS_magenta);
		registerRender(TRUSS_lightb);
		registerRender(TRUSS_yellow);
		registerRender(TRUSS_lime);
		registerRender(TRUSS_pink);
		registerRender(TRUSS_gray);
		registerRender(TRUSS_cyan);
		registerRender(TRUSS_purple);
		registerRender(TRUSS_blue);
		registerRender(TRUSS_brown);
		registerRender(TRUSS_green);
		registerRender(TRUSS_red);
		registerRender(TRUSS_black);

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
