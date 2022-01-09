package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.crop.Cabbage;
import com.ayutaki.chinjufumod.blocks.crop.Chanoki;
import com.ayutaki.chinjufumod.blocks.crop.Corn;
import com.ayutaki.chinjufumod.blocks.crop.Corn_Top;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.crop.Enden_kara;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_3B_B;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_C_kare;
import com.ayutaki.chinjufumod.blocks.crop.GrapeTop_Nae_3;
import com.ayutaki.chinjufumod.blocks.crop.Grape_3B_B;
import com.ayutaki.chinjufumod.blocks.crop.Grape_C_kare;
import com.ayutaki.chinjufumod.blocks.crop.Grape_Nae_3;
import com.ayutaki.chinjufumod.blocks.crop.Hakusai;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Top;
import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.Inagi_Top;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Nae;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Top;
import com.ayutaki.chinjufumod.blocks.crop.NoriAmi;
import com.ayutaki.chinjufumod.blocks.crop.Onion;
import com.ayutaki.chinjufumod.blocks.crop.Rice;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.blocks.crop.Sakura_me;
import com.ayutaki.chinjufumod.blocks.crop.SeedsBox;
import com.ayutaki.chinjufumod.blocks.crop.Soy;
import com.ayutaki.chinjufumod.blocks.crop.Spinach;
import com.ayutaki.chinjufumod.blocks.crop.Toami_Wide;
import com.ayutaki.chinjufumod.blocks.crop.Tomato;

import net.minecraft.block.Block;

public final class Crop_Blocks {

	public static Block SEEDSBOX;

	public static Block CHANOKI;
	public static Block BUDOUNOKI_nae, BUDOUNOKI_B, BUDOUNOKI_C,
								BUDOUTOP_nae, BUDOUTOP_B, BUDOUTOP_C;
	public static Block MIKAN, MIKAN_TOP;

	public static Block CABBAGE, HAKUSAI, CORN, CORN_TOP;
	public static Block ONION, RICE, RICE_8;
	public static Block SOY, SPINACH, TOMATO, SAKURA;

	public static Block HODAGI_A_BOT, HODAGI_A_TOP;
	public static Block HODAGI_B_BOT, HODAGI_B_TOP;
	public static Block HODAGI_C_BOT, HODAGI_C_TOP;

	public static Block INAGI_BOT, INAGI_TOP, NORIAMI, ENDEN, ENDEN_k ,TOAMI_W;


	public static void init() {

		SEEDSBOX = new SeedsBox();

		CHANOKI = new Chanoki();
		BUDOUNOKI_nae = new Grape_Nae_3();
		BUDOUNOKI_B = new Grape_3B_B();
		BUDOUNOKI_C = new Grape_C_kare();
		BUDOUTOP_nae = new GrapeTop_Nae_3();
		BUDOUTOP_B = new GrapeTop_3B_B();
		BUDOUTOP_C = new GrapeTop_C_kare();
		MIKAN = new Mikan_Nae();
		MIKAN_TOP = new Mikan_Top();

		CABBAGE = new Cabbage();
		HAKUSAI = new Hakusai();
		CORN = new Corn();
		CORN_TOP = new Corn_Top();
		ONION = new Onion();
		RICE = new Rice();
		RICE_8 = new Rice_8();
		SOY = new Soy();
		SPINACH = new Spinach();
		TOMATO = new Tomato();
		SAKURA = new Sakura_me();

		HODAGI_A_BOT = new HodaGi_A_Bot();
		HODAGI_A_TOP = new HodaGi_A_Top();
		HODAGI_B_BOT = new HodaGi_B_Bot();
		HODAGI_B_TOP = new HodaGi_B_Top();
		HODAGI_C_BOT = new HodaGi_C_Bot();
		HODAGI_C_TOP = new HodaGi_C_Top();

		INAGI_BOT = new Inagi();
		INAGI_TOP = new Inagi_Top();

		NORIAMI = new NoriAmi();
		ENDEN = new Enden();
		ENDEN_k = new Enden_kara();
		TOAMI_W = new Toami_Wide();
	}


	public static void register() {

		registerBlock(SEEDSBOX);

		registerBlock(CHANOKI);
		registerBlock(BUDOUNOKI_nae);
		registerBlock(BUDOUNOKI_B);
		registerBlock(BUDOUNOKI_C);
		registerBlock(BUDOUTOP_nae);
		registerBlock(BUDOUTOP_B);
		registerBlock(BUDOUTOP_C);
		registerBlock(MIKAN);
		registerBlock(MIKAN_TOP);

		registerBlock(CABBAGE);
		registerBlock(HAKUSAI);
		registerBlock(CORN);
		registerBlock(CORN_TOP);
		registerBlock(ONION);
		registerBlock(RICE);
		registerBlock(RICE_8);
		registerBlock(SOY);
		registerBlock(SPINACH);
		registerBlock(TOMATO);
		registerBlock(SAKURA);

		registerBlock(HODAGI_A_BOT);
		registerBlock(HODAGI_A_TOP);
		registerBlock(HODAGI_B_BOT);
		registerBlock(HODAGI_B_TOP);
		registerBlock(HODAGI_C_BOT);
		registerBlock(HODAGI_C_TOP);

		registerBlock(INAGI_BOT);
		registerBlock(INAGI_TOP);

		registerBlock(NORIAMI);
		registerBlock(ENDEN);
		registerBlock(ENDEN_k);
		registerBlock(TOAMI_W);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
