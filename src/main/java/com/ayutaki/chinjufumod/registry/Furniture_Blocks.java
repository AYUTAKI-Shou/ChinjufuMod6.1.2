package com.ayutaki.chinjufumod.registry;

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
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_acacia;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_birch;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_darkoak;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_ichoh;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_jungle;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_kaede;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_oak;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_sakura;
import com.ayutaki.chinjufumod.blocks.chair.DiningChair_spruce;
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
import com.ayutaki.chinjufumod.blocks.furnace.CStove_bot;
import com.ayutaki.chinjufumod.blocks.furnace.CStove_top;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable_Top;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.blocks.school.BlackBoard;
import com.ayutaki.chinjufumod.blocks.school.SchoolChair;
import com.ayutaki.chinjufumod.blocks.school.SchoolDesk;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_joint;
import com.ayutaki.chinjufumod.blocks.school.StoveChimney_topk;
import com.ayutaki.chinjufumod.blocks.school.TeacherDesk;

import net.minecraft.block.Block;

public class Furniture_Blocks {

	public static Block DRESSINGTABLE, DRESSINGTABLE_s,DRESSINGTABLE_b,
								DRESSINGTABLE_j, DRESSINGTABLE_a, DRESSINGTABLE_d,
								DRESSINGTABLE_saku, DRESSINGTABLE_kae, DRESSINGTABLE_ich,
								DRESSINGTABLE_TOP1, DRESSINGTABLE_TOP2, DRESSINGTABLE_TOP3;

	public static Block DININGCHAIR, DININGCHAIR_s, DININGCHAIR_b,
								DININGCHAIR_j, DININGCHAIR_a, DININGCHAIR_d,
								DININGCHAIR_saku, DININGCHAIR_kae, DININGCHAIR_ich;

	public static Block SOFA_leather, SOFA_white, SOFA_orange, SOFA_magenta, SOFA_lightb,
								SOFA_yellow, SOFA_lime, SOFA_pink, SOFA_gray,
								SOFA_lightg, SOFA_cyan, SOFA_purple, SOFA_blue,
								SOFA_brown, SOFA_green, SOFA_red, SOFA_black;

	public static Block BENCH, BENCH_spru, BENCH_bir,
								BENCH_jun, BENCH_aca, BENCH_doak,
								BENCH_saku, BENCH_kae, BENCH_ich;

	public static Block BLACKBOARD;

	public static Block SCHOOLCHAIR, SCHOOLCHAIR_s,SCHOOLCHAIR_b,
								SCHOOLCHAIR_j, SCHOOLCHAIR_a, SCHOOLCHAIR_d,
								SCHOOLCHAIR_saku, SCHOOLCHAIR_kae, SCHOOLCHAIR_ich;

	public static Block SCHOOLDESK, SCHOOLDESK_s,SCHOOLDESK_b,
								SCHOOLDESK_j, SCHOOLDESK_a, SCHOOLDESK_d,
								SCHOOLDESK_saku, SCHOOLDESK_kae, SCHOOLDESK_ich;

	public static Block TEACHERDESK, TEACHERDESK_s,TEACHERDESK_b,
								TEACHERDESK_j, TEACHERDESK_a, TEACHERDESK_d,
								TEACHERDESK_saku, TEACHERDESK_kae, TEACHERDESK_ich;

	public static Block STOVECHIMNEY, STOVECHIMNEY_joint, STOVECHIMNEY_topk;

	public static Block CSTOVE_top, LIT_CSTOVE_top, CSTOVE_bot;

	public static Block TANSU_OAK, TANSU_OAK_OPEN, DOAK_TANSU, SPRUCE_TANSU;


	public static void init() {

		DRESSINGTABLE = new DressingTable().setRegistryName("block_dressingtable").setUnlocalizedName("block_dressingtable");
		DRESSINGTABLE_s = new DressingTable().setRegistryName("block_dressingtable_s").setUnlocalizedName("block_dressingtable_s");
		DRESSINGTABLE_b = new DressingTable().setRegistryName("block_dressingtable_b").setUnlocalizedName("block_dressingtable_b");
		DRESSINGTABLE_j = new DressingTable().setRegistryName("block_dressingtable_j").setUnlocalizedName("block_dressingtable_j");
		DRESSINGTABLE_a = new DressingTable().setRegistryName("block_dressingtable_a").setUnlocalizedName("block_dressingtable_a");
		DRESSINGTABLE_d = new DressingTable().setRegistryName("block_dressingtable_d").setUnlocalizedName("block_dressingtable_d");
		DRESSINGTABLE_saku = new DressingTable().setRegistryName("block_dressingtable_saku").setUnlocalizedName("block_dressingtable_saku");
		DRESSINGTABLE_kae = new DressingTable().setRegistryName("block_dressingtable_kae").setUnlocalizedName("block_dressingtable_kae");
		DRESSINGTABLE_ich = new DressingTable().setRegistryName("block_dressingtable_ich").setUnlocalizedName("block_dressingtable_ich");

		DRESSINGTABLE_TOP1 = new DressingTable_Top().setRegistryName("block_dressingtable_top1").setUnlocalizedName("block_dressingtable_top1");
		DRESSINGTABLE_TOP2 = new DressingTable_Top().setRegistryName("block_dressingtable_top2").setUnlocalizedName("block_dressingtable_top2");
		DRESSINGTABLE_TOP3 = new DressingTable_Top().setRegistryName("block_dressingtable_top3").setUnlocalizedName("block_dressingtable_top3");

		DININGCHAIR = new DiningChair_oak().setRegistryName("block_diningchair").setUnlocalizedName("block_diningchair");
		DININGCHAIR_s = new DiningChair_spruce().setRegistryName("block_diningchair_s").setUnlocalizedName("block_diningchair_s");
		DININGCHAIR_b = new DiningChair_birch().setRegistryName("block_diningchair_b").setUnlocalizedName("block_diningchair_b");
		DININGCHAIR_j = new DiningChair_jungle().setRegistryName("block_diningchair_j").setUnlocalizedName("block_diningchair_j");
		DININGCHAIR_a = new DiningChair_acacia().setRegistryName("block_diningchair_a").setUnlocalizedName("block_diningchair_a");
		DININGCHAIR_d = new DiningChair_darkoak().setRegistryName("block_diningchair_d").setUnlocalizedName("block_diningchair_d");
		DININGCHAIR_saku = new DiningChair_sakura().setRegistryName("block_diningchair_saku").setUnlocalizedName("block_diningchair_saku");
		DININGCHAIR_kae = new DiningChair_kaede().setRegistryName("block_diningchair_kae").setUnlocalizedName("block_diningchair_kae");
		DININGCHAIR_ich = new DiningChair_ichoh().setRegistryName("block_diningchair_ich").setUnlocalizedName("block_diningchair_ich");

		SOFA_leather = new Sofa_leather();
		SOFA_white = new Sofa_white();
		SOFA_orange = new Sofa_orange();
		SOFA_magenta = new Sofa_magenta();
		SOFA_lightb = new Sofa_lightblue();
		SOFA_yellow = new Sofa_yellow();
		SOFA_lime = new Sofa_lime();
		SOFA_pink = new Sofa_pink();
		SOFA_gray = new Sofa_gray();
		SOFA_lightg = new Sofa_lightgray();
		SOFA_cyan = new Sofa_cyan();
		SOFA_purple = new Sofa_purple();
		SOFA_blue = new Sofa_blue();
		SOFA_brown = new Sofa_brown();
		SOFA_green = new Sofa_green();
		SOFA_red = new Sofa_red();
		SOFA_black = new Sofa_black();

		BENCH = new Bench_oak();
		BENCH_spru = new Bench_spruce();
		BENCH_bir = new Bench_birch();
		BENCH_jun = new Bench_jungle();
		BENCH_aca = new Bench_acacia();
		BENCH_doak = new Bench_doak();
		BENCH_saku = new Bench_sakura();
		BENCH_kae = new Bench_kaede();
		BENCH_ich = new Bench_ichoh();

		BLACKBOARD = new BlackBoard();

		SCHOOLCHAIR = new SchoolChair().setRegistryName("block_schoolchair").setUnlocalizedName("block_schoolchair");
		SCHOOLCHAIR_s = new SchoolChair().setRegistryName("block_schoolchair_s").setUnlocalizedName("block_schoolchair_s");
		SCHOOLCHAIR_b = new SchoolChair().setRegistryName("block_schoolchair_b").setUnlocalizedName("block_schoolchair_b");
		SCHOOLCHAIR_j = new SchoolChair().setRegistryName("block_schoolchair_j").setUnlocalizedName("block_schoolchair_j");
		SCHOOLCHAIR_a = new SchoolChair().setRegistryName("block_schoolchair_a").setUnlocalizedName("block_schoolchair_a");
		SCHOOLCHAIR_d = new SchoolChair().setRegistryName("block_schoolchair_d").setUnlocalizedName("block_schoolchair_d");
		SCHOOLCHAIR_saku = new SchoolChair().setRegistryName("block_schoolchair_saku").setUnlocalizedName("block_schoolchair_saku");
		SCHOOLCHAIR_kae = new SchoolChair().setRegistryName("block_schoolchair_kae").setUnlocalizedName("block_schoolchair_kae");
		SCHOOLCHAIR_ich = new SchoolChair().setRegistryName("block_schoolchair_ich").setUnlocalizedName("block_schoolchair_ich");

		SCHOOLDESK = new SchoolDesk().setRegistryName("block_schooldesk").setUnlocalizedName("block_schooldesk");
		SCHOOLDESK_s = new SchoolDesk().setRegistryName("block_schooldesk_s").setUnlocalizedName("block_schooldesk_s");
		SCHOOLDESK_b = new SchoolDesk().setRegistryName("block_schooldesk_b").setUnlocalizedName("block_schooldesk_b");
		SCHOOLDESK_j = new SchoolDesk().setRegistryName("block_schooldesk_j").setUnlocalizedName("block_schooldesk_j");
		SCHOOLDESK_a = new SchoolDesk().setRegistryName("block_schooldesk_a").setUnlocalizedName("block_schooldesk_a");
		SCHOOLDESK_d = new SchoolDesk().setRegistryName("block_schooldesk_d").setUnlocalizedName("block_schooldesk_d");
		SCHOOLDESK_saku = new SchoolDesk().setRegistryName("block_schooldesk_saku").setUnlocalizedName("block_schooldesk_saku");
		SCHOOLDESK_kae = new SchoolDesk().setRegistryName("block_schooldesk_kae").setUnlocalizedName("block_schooldesk_kae");
		SCHOOLDESK_ich = new SchoolDesk().setRegistryName("block_schooldesk_ich").setUnlocalizedName("block_schooldesk_ich");

		TEACHERDESK = new TeacherDesk().setRegistryName("block_teacherdesk").setUnlocalizedName("block_teacherdesk");
		TEACHERDESK_s = new TeacherDesk().setRegistryName("block_teacherdesk_s").setUnlocalizedName("block_teacherdesk_s");
		TEACHERDESK_b = new TeacherDesk().setRegistryName("block_teacherdesk_b").setUnlocalizedName("block_teacherdesk_b");
		TEACHERDESK_j = new TeacherDesk().setRegistryName("block_teacherdesk_j").setUnlocalizedName("block_teacherdesk_j");
		TEACHERDESK_a = new TeacherDesk().setRegistryName("block_teacherdesk_a").setUnlocalizedName("block_teacherdesk_a");
		TEACHERDESK_d = new TeacherDesk().setRegistryName("block_teacherdesk_d").setUnlocalizedName("block_teacherdesk_d");
		TEACHERDESK_saku = new TeacherDesk().setRegistryName("block_teacherdesk_saku").setUnlocalizedName("block_teacherdesk_saku");
		TEACHERDESK_kae = new TeacherDesk().setRegistryName("block_teacherdesk_kae").setUnlocalizedName("block_teacherdesk_kae");
		TEACHERDESK_ich = new TeacherDesk().setRegistryName("block_teacherdesk_ich").setUnlocalizedName("block_teacherdesk_ich");

		STOVECHIMNEY = new StoveChimney();
		STOVECHIMNEY_joint = new StoveChimney_joint();
		STOVECHIMNEY_topk = new StoveChimney_topk();

		CSTOVE_top = new CStove_top(false, "block_cstove_top");
		LIT_CSTOVE_top = new CStove_top(true, "lit_block_cstove_top").setHardness(1.0F).setResistance(10.0F);
		CSTOVE_bot = new CStove_bot();

		TANSU_OAK = new Tansu().setRegistryName("block_tansu_oak").setUnlocalizedName("block_tansu_oak");
		DOAK_TANSU = new Tansu().setRegistryName("block_tansu_doak").setUnlocalizedName("block_tansu_doak");
		SPRUCE_TANSU = new Tansu().setRegistryName("block_tansu_spruce").setUnlocalizedName("block_tansu_spruce");

	}


	public static void register() {

		registerBlock(DRESSINGTABLE);
		registerBlock(DRESSINGTABLE_s);
		registerBlock(DRESSINGTABLE_b);
		registerBlock(DRESSINGTABLE_j);
		registerBlock(DRESSINGTABLE_a);
		registerBlock(DRESSINGTABLE_d);
		registerBlock(DRESSINGTABLE_saku);
		registerBlock(DRESSINGTABLE_kae);
		registerBlock(DRESSINGTABLE_ich);

		registerBlock(DRESSINGTABLE_TOP1);
		registerBlock(DRESSINGTABLE_TOP2);
		registerBlock(DRESSINGTABLE_TOP3);

		registerBlock(DININGCHAIR);
		registerBlock(DININGCHAIR_s);
		registerBlock(DININGCHAIR_b);
		registerBlock(DININGCHAIR_j);
		registerBlock(DININGCHAIR_a);
		registerBlock(DININGCHAIR_d);
		registerBlock(DININGCHAIR_saku);
		registerBlock(DININGCHAIR_kae);
		registerBlock(DININGCHAIR_ich);

		registerBlock(SOFA_leather);
		registerBlock(SOFA_white);
		registerBlock(SOFA_orange);
		registerBlock(SOFA_magenta);
		registerBlock(SOFA_lightb);
		registerBlock(SOFA_yellow);
		registerBlock(SOFA_lime);
		registerBlock(SOFA_pink);
		registerBlock(SOFA_gray);
		registerBlock(SOFA_lightg);
		registerBlock(SOFA_cyan);
		registerBlock(SOFA_purple);
		registerBlock(SOFA_blue);
		registerBlock(SOFA_brown);
		registerBlock(SOFA_green);
		registerBlock(SOFA_red);
		registerBlock(SOFA_black);

		registerBlock(BENCH);
		registerBlock(BENCH_spru);
		registerBlock(BENCH_bir);
		registerBlock(BENCH_jun);
		registerBlock(BENCH_aca);
		registerBlock(BENCH_doak);
		registerBlock(BENCH_saku);
		registerBlock(BENCH_kae);
		registerBlock(BENCH_ich);

		registerBlock(BLACKBOARD);

		registerBlock(SCHOOLCHAIR);
		registerBlock(SCHOOLCHAIR_s);
		registerBlock(SCHOOLCHAIR_b);
		registerBlock(SCHOOLCHAIR_j);
		registerBlock(SCHOOLCHAIR_a);
		registerBlock(SCHOOLCHAIR_d);
		registerBlock(SCHOOLCHAIR_saku);
		registerBlock(SCHOOLCHAIR_kae);
		registerBlock(SCHOOLCHAIR_ich);

		registerBlock(SCHOOLDESK);
		registerBlock(SCHOOLDESK_s);
		registerBlock(SCHOOLDESK_b);
		registerBlock(SCHOOLDESK_j);
		registerBlock(SCHOOLDESK_a);
		registerBlock(SCHOOLDESK_d);
		registerBlock(SCHOOLDESK_saku);
		registerBlock(SCHOOLDESK_kae);
		registerBlock(SCHOOLDESK_ich);

		registerBlock(TEACHERDESK);
		registerBlock(TEACHERDESK_s);
		registerBlock(TEACHERDESK_b);
		registerBlock(TEACHERDESK_j);
		registerBlock(TEACHERDESK_a);
		registerBlock(TEACHERDESK_d);
		registerBlock(TEACHERDESK_saku);
		registerBlock(TEACHERDESK_kae);
		registerBlock(TEACHERDESK_ich);

		registerBlock(STOVECHIMNEY);
		registerBlock(STOVECHIMNEY_joint);
		registerBlock(STOVECHIMNEY_topk);

		registerBlock(CSTOVE_top);
		registerBlock(LIT_CSTOVE_top);
		registerBlock(CSTOVE_bot);

		registerBlock(TANSU_OAK);
		registerBlock(DOAK_TANSU);
		registerBlock(SPRUCE_TANSU);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
