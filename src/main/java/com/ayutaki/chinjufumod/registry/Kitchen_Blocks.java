package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.furnace.Lit_Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_AAA;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_OAA;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_aida;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_on;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2Cider;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2CiderJuku;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2Mead;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2MeadJuku;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2Sake;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2SakeJuku;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2SakeNama;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2Wine;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Tana2WineJuku;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaChawan_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaChawan_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDonburi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_E;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSushiGeta_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_A;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_board;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_duct;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_ductend;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_kanki_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_kanki_on;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_sink_bot;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_sink_top;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen_Donabe;
import com.ayutaki.chinjufumod.blocks.pantry.Box_H;
import com.ayutaki.chinjufumod.blocks.pantry.Box_HCM;
import com.ayutaki.chinjufumod.blocks.pantry.CanTea;
import com.ayutaki.chinjufumod.blocks.pantry.Chadutsu;
import com.ayutaki.chinjufumod.blocks.pantry.Sack_H;
import com.ayutaki.chinjufumod.blocks.pantry.Tawara;

import net.minecraft.block.Block;

public class Kitchen_Blocks {

	public static Box_H BOX_H_EMPTY;
	public static Box_H BOX_H_APPLE;
	public static Box_H BOX_H_BEEF;
	public static Box_H BOX_H_BEETROOT;
	public static Box_H BOX_H_BREAD;
	public static Box_H BOX_H_CARROT;
	public static Box_H BOX_H_CHICKEN;
	public static Box_H BOX_H_CHORUS;
	public static Sack_H BOX_H_COCO;
	public static Box_H BOX_H_EGG;
	public static Box_H BOX_H_FISH;
	public static Sack_H BOX_H_FLOUR;
	public static Box_H BOX_H_MUTTON;
	public static Box_H BOX_H_PORK;
	public static Box_H BOX_H_POTATO;
	public static Box_H BOX_H_RABBIT;
	public static Box_H BOX_H_SALMON;

	public static Box_HCM BOX_H_CABBAGE;
	public static Box_HCM BOX_H_HAKUSAI;
	public static Box_HCM BOX_H_CHERRY;
	public static Box_HCM BOX_H_CITRUS;
	public static Box_HCM BOX_H_CORN;
	public static Box_HCM BOX_H_GRAPE;
	public static Box_HCM BOX_H_ONION;
	public static Sack_H BOX_H_RICE;
	public static Sack_H BOX_H_SOY;
	public static Box_HCM BOX_H_SPINACH;
	public static Box_HCM BOX_H_TOMATO;
	public static Sack_H BOX_H_TGREEN;
	public static Sack_H BOX_H_TRED;

	public static Block CHADUTSU, CANTEA, TAWARA;

	public static Block KITCHEN;

	public static Block KIT_BOARD, KIT_SINK_TOP, KIT_SINK_BOT;
	public static Block KIT_STOVE, KIT_STOVE_1, LIT_KITSTOVE,
								KIT_OVEN, LIT_KITOVEN, KIT_OVEN_B, LIT_KITOVEN_B, IRORI, LIT_IRORI;

	public static Block KIT_KANKI_1, KIT_KANKI_2, KIT_HAIKIDUCT, KIT_DUCTEND_1;

	public static Block KIT_TANA, WINE_TANA, CHEESE_TANA;

	public static Block KIT_DONABE;

	public static Block KIT_CHAWAN1, KIT_CHAWANA;
	public static Block KIT_SHIKKI1, KIT_SHIKKIA;
	public static Block KIT_YUNOMI1, KIT_YUNOMIA;
	public static Block KIT_SARA1, KIT_SARAA;
	public static Block KIT_TCUP1, KIT_TCUPA;
	public static Block KIT_TONSUI1, KIT_TONSUIA;
	public static Block KIT_DRINKGLASS1, KIT_DRINKGLASSA, KIT_DRINKGLASSE;
	public static Block KIT_DONBURI1, KIT_SUSHIGETA1;

	public static Block CHEESE_OAA, CHEESE_AAA;

	public static Block KIT_SAKENAMA, KIT_SAKE, KIT_SAKEJUKU;
	public static Block KIT_CIDER, KIT_CIDERJUKU;
	public static Block KIT_WINE, KIT_WINEJUKU;
	public static Block KIT_MEAD, KIT_MEADJUKU;


	public static void init() {

		BOX_H_EMPTY = new Box_H("block_boxh_empty");
		BOX_H_APPLE = new Box_H("block_boxh_apple");
		BOX_H_BEEF = new Box_H("block_boxh_beef");
		BOX_H_BEETROOT = new Box_H("block_boxh_beetroot");
		BOX_H_BREAD = new Box_H("block_boxh_bread");
		BOX_H_CARROT = new Box_H("block_boxh_carrot");
		BOX_H_CHICKEN = new Box_H("block_boxh_chicken");
		BOX_H_CHORUS = new Box_H("block_boxh_chorus");
		BOX_H_COCO = new Sack_H("block_boxh_coco");
		BOX_H_EGG = new Box_H("block_boxh_egg");
		BOX_H_FISH = new Box_H("block_boxh_fish");
		BOX_H_FLOUR = new Sack_H("block_boxh_flour");
		BOX_H_MUTTON = new Box_H("block_boxh_mutton");
		BOX_H_PORK = new Box_H("block_boxh_pork");
		BOX_H_POTATO = new Box_H("block_boxh_potato");
		BOX_H_RABBIT = new Box_H("block_boxh_rabbit");
		BOX_H_SALMON = new Box_H("block_boxh_salmon");

		BOX_H_CABBAGE = new Box_HCM("block_boxh_cabbage");
		BOX_H_HAKUSAI = new Box_HCM("block_boxh_hakusai");
		BOX_H_CHERRY = new Box_HCM("block_boxh_cherry");
		BOX_H_CITRUS = new Box_HCM("block_boxh_citrus");
		BOX_H_CORN = new Box_HCM("block_boxh_corn");
		BOX_H_GRAPE = new Box_HCM("block_boxh_grape");
		BOX_H_ONION = new Box_HCM("block_boxh_onion");
		BOX_H_RICE = new Sack_H("block_boxh_rice");
		BOX_H_SOY = new Sack_H("block_boxh_soy");
		BOX_H_SPINACH = new Box_HCM("block_boxh_spinach");
		BOX_H_TOMATO = new Box_HCM("block_boxh_tomato");
		BOX_H_TGREEN = new Sack_H("block_boxh_tgreen");
		BOX_H_TRED = new Sack_H("block_boxh_tred");

		CHADUTSU = new Chadutsu();
		CANTEA = new CanTea();
		TAWARA = new Tawara();

		KITCHEN = new Kitchen();

		KIT_BOARD = new Kit_board();
		KIT_SINK_TOP = new Kit_sink_top();
		KIT_SINK_BOT = new Kit_sink_bot();

		KIT_STOVE = new Kit_Cooktop_off();
		KIT_STOVE_1 = new Kit_Cooktop_aida().setRegistryName("block_kit_stove_1").setUnlocalizedName("block_kit_stove_1");
		LIT_KITSTOVE = new Kit_Cooktop_on().setRegistryName("lit_block_kit_stove").setUnlocalizedName("lit_block_kit_stove");
		KIT_OVEN = new Kitchen_Oven(false, "block_kit_oven");
		LIT_KITOVEN = new Kitchen_Oven(true, "lit_block_kit_oven").setHardness(1.0F).setResistance(10.0F);
		KIT_OVEN_B = new Kitchen_Oven_B(false, "block_kit_oven_black");
		LIT_KITOVEN_B = new Kitchen_Oven_B(true, "lit_block_kit_oven_black").setHardness(1.0F).setResistance(10.0F);
		IRORI = new Irori();
		LIT_IRORI = new Lit_Irori().setRegistryName("lit_block_irori").setUnlocalizedName("lit_block_irori");

		KIT_KANKI_1 = new Kit_kanki_off();
		KIT_KANKI_2 = new Kit_kanki_on().setRegistryName("block_kit_kanki_2").setUnlocalizedName("block_kit_kanki_2");
		KIT_HAIKIDUCT = new Kit_duct();
		KIT_DUCTEND_1 = new Kit_ductend();

		KIT_TANA = new Kit_Tana();
		WINE_TANA = new Kit_Tana2();
		CHEESE_TANA = new Kit_Cheese_Tana();

		KIT_DONABE = new Kitchen_Donabe();

		KIT_CHAWAN1 = new Kit_TanaChawan_1();
		KIT_CHAWANA = new Kit_TanaChawan_A();
		KIT_SHIKKI1 = new Kit_TanaShikki_1();
		KIT_SHIKKIA = new Kit_TanaShikki_A();
		KIT_YUNOMI1 = new Kit_TanaYunomi_1();
		KIT_YUNOMIA = new Kit_TanaYunomi_A();
		KIT_SARA1 = new Kit_TanaSara_1();
		KIT_SARAA = new Kit_TanaSara_A();
		KIT_TCUP1 = new Kit_TanaTcup_1();
		KIT_TCUPA = new Kit_TanaTcup_A();
		KIT_TONSUI1 = new Kit_TanaTonsui_1();
		KIT_TONSUIA = new Kit_TanaTonsui_A();
		KIT_DRINKGLASS1 = new Kit_TanaDrinkglass_1();
		KIT_DRINKGLASSA = new Kit_TanaDrinkglass_A();
		KIT_DRINKGLASSE = new Kit_TanaDrinkglass_E();
		KIT_DONBURI1 = new Kit_TanaDonburi_1();
		KIT_SUSHIGETA1 = new Kit_TanaSushiGeta_1();

		CHEESE_OAA = new Kit_Cheese_OAA();
		CHEESE_AAA = new Kit_Cheese_AAA();

		KIT_SAKENAMA = new Kit_Tana2SakeNama();
		KIT_SAKE = new Kit_Tana2Sake();
		KIT_SAKEJUKU = new Kit_Tana2SakeJuku();
		KIT_WINE = new Kit_Tana2Wine();
		KIT_WINEJUKU = new Kit_Tana2WineJuku();
		KIT_CIDER = new Kit_Tana2Cider();
		KIT_CIDERJUKU = new Kit_Tana2CiderJuku();
		KIT_MEAD = new Kit_Tana2Mead();
		KIT_MEADJUKU = new Kit_Tana2MeadJuku();

	}


	public static void register() {

		registerBlock(BOX_H_EMPTY);
		registerBlock(BOX_H_APPLE);
		registerBlock(BOX_H_BEEF);
		registerBlock(BOX_H_BEETROOT);
		registerBlock(BOX_H_BREAD);
		registerBlock(BOX_H_CARROT);
		registerBlock(BOX_H_CHICKEN);
		registerBlock(BOX_H_CHORUS);
		registerBlock(BOX_H_COCO);
		registerBlock(BOX_H_EGG);
		registerBlock(BOX_H_FISH);
		registerBlock(BOX_H_FLOUR);
		registerBlock(BOX_H_MUTTON);
		registerBlock(BOX_H_PORK);
		registerBlock(BOX_H_POTATO);
		registerBlock(BOX_H_RABBIT);
		registerBlock(BOX_H_SALMON);

		registerBlock(BOX_H_CABBAGE);
		registerBlock(BOX_H_HAKUSAI);
		registerBlock(BOX_H_CHERRY);
		registerBlock(BOX_H_CITRUS);
		registerBlock(BOX_H_CORN);
		registerBlock(BOX_H_GRAPE);
		registerBlock(BOX_H_ONION);
		registerBlock(BOX_H_RICE);
		registerBlock(BOX_H_SOY);
		registerBlock(BOX_H_SPINACH);
		registerBlock(BOX_H_TOMATO);
		registerBlock(BOX_H_TGREEN);
		registerBlock(BOX_H_TRED);

		registerBlock(CHADUTSU);
		registerBlock(CANTEA);
		registerBlock(TAWARA);

		registerBlock(KITCHEN);
		registerBlock(KIT_BOARD);
		registerBlock(KIT_SINK_TOP);
		registerBlock(KIT_SINK_BOT);

		registerBlock(KIT_STOVE);
		registerBlock(KIT_STOVE_1);
		registerBlock(LIT_KITSTOVE);
		registerBlock(KIT_OVEN);
		registerBlock(LIT_KITOVEN);
		registerBlock(KIT_OVEN_B);
		registerBlock(LIT_KITOVEN_B);
		registerBlock(IRORI);
		registerBlock(LIT_IRORI);

		registerBlock(KIT_KANKI_1);
		registerBlock(KIT_KANKI_2);
		registerBlock(KIT_HAIKIDUCT);
		registerBlock(KIT_DUCTEND_1);

		registerBlock(KIT_TANA);
		registerBlock(WINE_TANA);

		registerBlock(CHEESE_TANA);

		registerBlock(KIT_DONABE);

		registerBlock(KIT_CHAWAN1);
		registerBlock(KIT_CHAWANA);
		registerBlock(KIT_SHIKKI1);
		registerBlock(KIT_SHIKKIA);
		registerBlock(KIT_YUNOMI1);
		registerBlock(KIT_YUNOMIA);
		registerBlock(KIT_SARA1);
		registerBlock(KIT_SARAA);
		registerBlock(KIT_TCUP1);
		registerBlock(KIT_TCUPA);
		registerBlock(KIT_TONSUI1);
		registerBlock(KIT_TONSUIA);
		registerBlock(KIT_DRINKGLASS1);
		registerBlock(KIT_DRINKGLASSA);
		registerBlock(KIT_DRINKGLASSE);
		registerBlock(KIT_DONBURI1);
		registerBlock(KIT_SUSHIGETA1);

		registerBlock(CHEESE_OAA);
		registerBlock(CHEESE_AAA);

		registerBlock(KIT_SAKENAMA);
		registerBlock(KIT_SAKE);
		registerBlock(KIT_SAKEJUKU);
		registerBlock(KIT_WINE);
		registerBlock(KIT_WINEJUKU);
		registerBlock(KIT_CIDER);
		registerBlock(KIT_CIDERJUKU);
		registerBlock(KIT_MEAD);
		registerBlock(KIT_MEADJUKU);

	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
