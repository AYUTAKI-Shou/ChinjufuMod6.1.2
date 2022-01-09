package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Hakkou;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Cider;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_CiderJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_MeadJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeNama;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeShin;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_WineJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese_block;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese_curd;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Dashi;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Kara_Bottle_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Komezu;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke_full;
import com.ayutaki.chinjufumod.blocks.hakkou.NabeAmazake_cooked;
import com.ayutaki.chinjufumod.blocks.hakkou.Bin_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Budoushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Cocoa;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Hachimitsushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Ringoshu;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Hakkou;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_HakusaiDuke;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.Zundou_ColdMilk;

import net.minecraft.block.Block;

public final class Hakkou_Blocks {

	public static Block MIZUOKE, MIZUOKE_full;

	public static Block NAMASAKEBOT, SHINSAKEBOT, JUKUSAKEBOT, NABEAMAZAKE;

	public static Block WINEBOT, JUKUWINEBOT, CIDERBOT, JUKUCIDERBOT, MEADBOT, JUKUMEADBOT;
	public static Block SAKEGLASS, WINEGLASS;

	public static Block KARABOT, KARABOTJP, KARABOTMEAD;

	public static Block HAKKOUBOT;

	public static Block COLD_MILK;
	public static Block CHEESE_CURD, CHEESE;

	public static Block SHOUYU_bot, KOMEZU_bot, DASHI_bot;

	public static Block HAKKOUTARU, SHOUYUTARU, HAKUSAITARU;
	public static Block RINGOSHU_TARU, BUDOUSHU_TARU, HACHIMITSUSHU_TARU, COCOA_TARU;


	public static void init() {

		MIZUOKE = new Mizuoke();
		MIZUOKE_full = new Mizuoke_full();

		NAMASAKEBOT = new Bottle_SakeNama();
		SHINSAKEBOT = new Bottle_SakeShin();
		JUKUSAKEBOT = new Bottle_SakeJuku();
		NABEAMAZAKE = new NabeAmazake_cooked();

		WINEBOT = new Bottle_Wine();
		JUKUWINEBOT = new Bottle_WineJuku();
		CIDERBOT = new Bottle_Cider();
		JUKUCIDERBOT = new Bottle_CiderJuku();
		MEADBOT = new Bottle_Mead();
		JUKUMEADBOT = new Bottle_MeadJuku();

		SAKEGLASS = new Glass_Sake();
		WINEGLASS = new Glass_Wine();

		KARABOT = new Kara_Bottle();
		KARABOTJP = new Kara_Bottle_Sake();
		KARABOTMEAD = new Kara_Bottle_Mead();

		HAKKOUBOT = new Bin_Hakkou();

		COLD_MILK = new Zundou_ColdMilk();
		CHEESE_CURD = new Cheese_curd();
		CHEESE = new Cheese_block();

		SHOUYU_bot = new Bin_Shouyu();
		KOMEZU_bot = new Bin_Komezu();
		DASHI_bot = new Bin_Dashi();

		HAKKOUTARU = new Taru_Hakkou();
		RINGOSHU_TARU = new TaruY_Ringoshu();
		BUDOUSHU_TARU = new TaruY_Budoushu();
		HACHIMITSUSHU_TARU = new TaruY_Hachimitsushu();
		COCOA_TARU = new TaruY_Cocoa();

		SHOUYUTARU = new Taru_Shouyu();
		HAKUSAITARU = new Taru_HakusaiDuke();

	}

	public static void register() {

		registerBlock(MIZUOKE);
		registerBlock(MIZUOKE_full);

		registerBlock(NAMASAKEBOT);
		registerBlock(SHINSAKEBOT);
		registerBlock(JUKUSAKEBOT);
		registerBlock(NABEAMAZAKE);

		registerBlock(WINEBOT);
		registerBlock(JUKUWINEBOT);
		registerBlock(CIDERBOT);
		registerBlock(JUKUCIDERBOT);
		registerBlock(MEADBOT);
		registerBlock(JUKUMEADBOT);

		registerBlock(SAKEGLASS);
		registerBlock(WINEGLASS);

		registerBlock(KARABOT);
		registerBlock(KARABOTJP);
		registerBlock(KARABOTMEAD);

		registerBlock(HAKKOUBOT);

		registerBlock(COLD_MILK);
		registerBlock(CHEESE_CURD);
		registerBlock(CHEESE);

		registerBlock(SHOUYU_bot);
		registerBlock(KOMEZU_bot);
		registerBlock(DASHI_bot);

		registerBlock(HAKKOUTARU);
		registerBlock(RINGOSHU_TARU);
		registerBlock(BUDOUSHU_TARU);
		registerBlock(HACHIMITSUSHU_TARU);

		registerBlock(COCOA_TARU);
		registerBlock(SHOUYUTARU);
		registerBlock(HAKUSAITARU);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
