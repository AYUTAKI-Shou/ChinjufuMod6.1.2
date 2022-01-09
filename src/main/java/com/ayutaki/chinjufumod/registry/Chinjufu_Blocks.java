package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair_Top;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.LogChair;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStamp;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock_W;
import com.ayutaki.chinjufumod.blocks.cmblock.AmuBauxBox;
import com.ayutaki.chinjufumod.blocks.cmblock.BauxiteOre;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater1;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater2;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater3;

import net.minecraft.block.Block;

public class Chinjufu_Blocks {

	/* 追加するブロックの宣言 Declare blocks to add. */
	public static Block BAUXITE_ORE;
	public static Block EMPTY_BOX;

	public static Block AMUBAUX;
	public static Block ALUMI, ALUMI_W;
	public static Block B_ADMIRAL_STAMP;

	public static Block WAKE_WATER1, WAKE_WATER2, WAKE_WATER3;


	public static Block ADMIRALCHAIR_TOP, ADMIRALCHAIR;
	public static Block CAFECHAIR, LOGCHAIR;


	/* ブロックのインスタンスを生成 Instantiate blocks. */
	public static void init() {
		BAUXITE_ORE = new BauxiteOre();
		EMPTY_BOX = new EmptyBox();

		AMUBAUX = new AmuBauxBox();
		ALUMI = new AlumiBlock();
		ALUMI_W = new AlumiBlock_W();
		B_ADMIRAL_STAMP = new AdmiralStamp();

		WAKE_WATER1 = new WakeWater1();
		WAKE_WATER2 = new WakeWater2();
		WAKE_WATER3 = new WakeWater3();

		ADMIRALCHAIR_TOP = new AdmiralChair_Top();
		ADMIRALCHAIR = new AdmiralChair();

		CAFECHAIR = new CafeChair();
		LOGCHAIR = new LogChair();


	}


	/* ブロックを登録する、ここから Register Blocks. From here. ↓*/
	public static void register() {
		registerBlock(BAUXITE_ORE);
		registerBlock(EMPTY_BOX);

		registerBlock(AMUBAUX);
		registerBlock(ALUMI);
		registerBlock(ALUMI_W);
		registerBlock(B_ADMIRAL_STAMP);

		registerBlock(WAKE_WATER1);
		registerBlock(WAKE_WATER2);
		registerBlock(WAKE_WATER3);

		registerBlock(ADMIRALCHAIR_TOP);
		registerBlock(ADMIRALCHAIR);

		registerBlock(CAFECHAIR);
		registerBlock(LOGCHAIR);

	}

	/** ブロックの登録 Register Blocks. **/
	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}
	/*ここまで So far↑ */

}
