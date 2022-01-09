package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.garden.Bonsai;
import com.ayutaki.chinjufumod.blocks.garden.Chouzubachi;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Top;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiSmall;
import com.ayutaki.chinjufumod.blocks.garden.IronFence_Bot;
import com.ayutaki.chinjufumod.blocks.garden.IronFence_Top;
import com.ayutaki.chinjufumod.blocks.garden.Ishitourou;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Top;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Top;
import com.ayutaki.chinjufumod.blocks.garden.Lit_Ishitourou;
import com.ayutaki.chinjufumod.blocks.garden.Lit_Longtourou;
import com.ayutaki.chinjufumod.blocks.garden.Longtourou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Longtourou_Top;
import com.ayutaki.chinjufumod.blocks.garden.Makibishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi;
import com.ayutaki.chinjufumod.blocks.garden.Niwaishi_slab;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_B;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshiTop_B2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_2;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_B;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi_B2;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_black;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_blue;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_brown;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_cyan;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_gray;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_green;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_lightb;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_lightg;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_lime;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_magenta;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_orange;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_pink;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_purple;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_red;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_white;
import com.ayutaki.chinjufumod.blocks.jpkasa.Kasa_yellow;

import net.minecraft.block.Block;

public class Garden_Blocks {

	public static Block KASA_white, KASA_orange, KASA_magenta, KASA_lightb,
								KASA_yellow, KASA_lime, KASA_pink, KASA_gray,
								KASA_lightg, KASA_cyan, KASA_purple, KASA_blue,
								KASA_brown, KASA_green, KASA_red, KASA_black;

	public static Block BONSAI_oak, BONSAI_spru, BONSAI_bir, BONSAI_jun, BONSAI_aca, BONSAI_doak;
	public static Block KANYOU_TOP, KANYOU_BOT, KANYOU2_TOP, KANYOU2_BOT;
	public static Block IKEGAKI_S;
	public static Block IKEGAKI_L_TOP, IKEGAKI_L_BOT;

	public static Block CHOUZUBACHI;
	public static Block SHISHIODOSHI, SHISHIODOSHI2, SHISHIODOSHIB, SHISHIODOSHIB2,
								SHISHIODOSHI_T, SHISHIODOSHI_T2, SHISHIODOSHI_TB, SHISHIODOSHI_TB2;

	public static Block ISHITOUROU, LIT_ISHITOUROU;
	public static Block LONGTOUROU_TOP, LONGTOUROU_BOT, LIT_LONGTOUROU_TOP;

	public static Block TETSUSAKU_TOP, TETSUSAKU_BOT;
	public static Block SAMON, SAMON_B;
	public static Block NIWAISHI, NIWAISHI_gra, NIWAISHI_dio, NIWAISHI_and;
	public static Block NIWAISHI_slab, NIWAISHI_slab_gra, NIWAISHI_slab_dio, NIWAISHI_slab_and;
	public static Block MAKIBISHI;
	
	public static void init() {

		KASA_white = new Kasa_white();
		KASA_orange = new Kasa_orange();
		KASA_magenta = new Kasa_magenta();
		KASA_lightb = new Kasa_lightb();
		KASA_yellow = new Kasa_yellow();
		KASA_lime = new Kasa_lime();
		KASA_pink = new Kasa_pink();
		KASA_gray = new Kasa_gray();
		KASA_lightg = new Kasa_lightg();
		KASA_cyan = new Kasa_cyan();
		KASA_purple = new Kasa_purple();
		KASA_blue = new Kasa_blue();
		KASA_brown = new Kasa_brown();
		KASA_green = new Kasa_green();
		KASA_red = new Kasa_red();
		KASA_black = new Kasa_black();

		BONSAI_oak = new Bonsai().setRegistryName("block_bonsai_oak").setUnlocalizedName("block_bonsai_oak").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_spru = new Bonsai().setRegistryName("block_bonsai_spruce").setUnlocalizedName("block_bonsai_spruce").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_bir = new Bonsai().setRegistryName("block_bonsai_birch").setUnlocalizedName("block_bonsai_birch").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_jun = new Bonsai().setRegistryName("block_bonsai_jungle").setUnlocalizedName("block_bonsai_jungle").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_aca = new Bonsai().setRegistryName("block_bonsai_acacia").setUnlocalizedName("block_bonsai_acacia").setCreativeTab(ChinjufuModTabs.WADECO);
		BONSAI_doak = new Bonsai().setRegistryName("block_bonsai_darkoak").setUnlocalizedName("block_bonsai_darkoak").setCreativeTab(ChinjufuModTabs.WADECO);

		KANYOU_TOP = new Kanyou_Top();
		KANYOU_BOT = new Kanyou_Bottom();
		KANYOU2_TOP = new Kanyou2_Top();
		KANYOU2_BOT = new Kanyou2_Bottom();
		IKEGAKI_S = new IkegakiSmall();
		IKEGAKI_L_TOP = new IkegakiLong_Top();
		IKEGAKI_L_BOT = new IkegakiLong_Bottom();

		CHOUZUBACHI = new Chouzubachi();
		SHISHIODOSHI = new ShishiOdoshi();
		SHISHIODOSHI2 = new ShishiOdoshi_2();
		SHISHIODOSHIB = new ShishiOdoshi_B();
		SHISHIODOSHIB2 = new ShishiOdoshi_B2();
		SHISHIODOSHI_T = new ShishiOdoshiTop();
		SHISHIODOSHI_T2 = new ShishiOdoshiTop_2();
		SHISHIODOSHI_TB = new ShishiOdoshiTop_B();
		SHISHIODOSHI_TB2 = new ShishiOdoshiTop_B2();

		ISHITOUROU = new Ishitourou();
		LIT_ISHITOUROU = new Lit_Ishitourou();
		LONGTOUROU_TOP = new Longtourou_Top();
		LONGTOUROU_BOT = new Longtourou_Bottom();
		LIT_LONGTOUROU_TOP = new Lit_Longtourou();

		TETSUSAKU_TOP = new IronFence_Top();
		TETSUSAKU_BOT = new IronFence_Bot();

		SAMON = new Samon().setRegistryName("block_samon").setUnlocalizedName("block_samon");
		SAMON_B = new Samon().setRegistryName("block_samon_black").setUnlocalizedName("block_samon_black");
		NIWAISHI = new Niwaishi().setRegistryName("block_niwaishi").setUnlocalizedName("block_niwaishi");
		NIWAISHI_gra = new Niwaishi().setRegistryName("block_niwaishi_gra").setUnlocalizedName("block_niwaishi_gra");
		NIWAISHI_dio = new Niwaishi().setRegistryName("block_niwaishi_dio").setUnlocalizedName("block_niwaishi_dio");
		NIWAISHI_and = new Niwaishi().setRegistryName("block_niwaishi_and").setUnlocalizedName("block_niwaishi_and");
		
		NIWAISHI_slab = new Niwaishi_slab().setRegistryName("block_niwaishi_slab").setUnlocalizedName("block_niwaishi_slab");
		NIWAISHI_slab_gra = new Niwaishi_slab().setRegistryName("block_niwaishi_slab_gra").setUnlocalizedName("block_niwaishi_slab_gra");
		NIWAISHI_slab_dio = new Niwaishi_slab().setRegistryName("block_niwaishi_slab_dio").setUnlocalizedName("block_niwaishi_slab_dio");
		NIWAISHI_slab_and = new Niwaishi_slab().setRegistryName("block_niwaishi_slab_and").setUnlocalizedName("block_niwaishi_slab_and");
		MAKIBISHI = new Makibishi();
	}


	public static void register() {

		registerBlock(KASA_white);
		registerBlock(KASA_orange);
		registerBlock(KASA_magenta);
		registerBlock(KASA_lightb);
		registerBlock(KASA_yellow);
		registerBlock(KASA_lime);
		registerBlock(KASA_pink);
		registerBlock(KASA_gray);
		registerBlock(KASA_lightg);
		registerBlock(KASA_cyan);
		registerBlock(KASA_purple);
		registerBlock(KASA_blue);
		registerBlock(KASA_brown);
		registerBlock(KASA_green);
		registerBlock(KASA_red);
		registerBlock(KASA_black);

		registerBlock(BONSAI_oak);
		registerBlock(BONSAI_spru);
		registerBlock(BONSAI_bir);
		registerBlock(BONSAI_jun);
		registerBlock(BONSAI_aca);
		registerBlock(BONSAI_doak);

		registerBlock(KANYOU_TOP);
		registerBlock(KANYOU_BOT);
		registerBlock(KANYOU2_TOP);
		registerBlock(KANYOU2_BOT);
		registerBlock(IKEGAKI_S);
		registerBlock(IKEGAKI_L_TOP);
		registerBlock(IKEGAKI_L_BOT);

		registerBlock(CHOUZUBACHI);
		registerBlock(SHISHIODOSHI);
		registerBlock(SHISHIODOSHI2);
		registerBlock(SHISHIODOSHIB);
		registerBlock(SHISHIODOSHIB2);
		registerBlock(SHISHIODOSHI_T);
		registerBlock(SHISHIODOSHI_T2);
		registerBlock(SHISHIODOSHI_TB);
		registerBlock(SHISHIODOSHI_TB2);

		registerBlock(ISHITOUROU);
		registerBlock(LIT_ISHITOUROU);
		registerBlock(LONGTOUROU_TOP);
		registerBlock(LONGTOUROU_BOT);
		registerBlock(LIT_LONGTOUROU_TOP);

		registerBlock(TETSUSAKU_TOP);
		registerBlock(TETSUSAKU_BOT);
		
		registerBlock(SAMON);
		registerBlock(SAMON_B);
		registerBlock(NIWAISHI);
		registerBlock(NIWAISHI_gra);
		registerBlock(NIWAISHI_dio);
		registerBlock(NIWAISHI_and);
		
		registerBlock(NIWAISHI_slab);
		registerBlock(NIWAISHI_slab_gra);
		registerBlock(NIWAISHI_slab_dio);
		registerBlock(NIWAISHI_slab_and);
		registerBlock(MAKIBISHI);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
