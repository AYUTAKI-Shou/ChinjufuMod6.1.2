package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.furniture.Takeakari;
import com.ayutaki.chinjufumod.blocks.futon.Futon_black;
import com.ayutaki.chinjufumod.blocks.futon.Futon_blue;
import com.ayutaki.chinjufumod.blocks.futon.Futon_brown;
import com.ayutaki.chinjufumod.blocks.futon.Futon_cyan;
import com.ayutaki.chinjufumod.blocks.futon.Futon_gray;
import com.ayutaki.chinjufumod.blocks.futon.Futon_green;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lightb;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lightg;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lime;
import com.ayutaki.chinjufumod.blocks.futon.Futon_magenta;
import com.ayutaki.chinjufumod.blocks.futon.Futon_orange;
import com.ayutaki.chinjufumod.blocks.futon.Futon_pink;
import com.ayutaki.chinjufumod.blocks.futon.Futon_purple;
import com.ayutaki.chinjufumod.blocks.futon.Futon_red;
import com.ayutaki.chinjufumod.blocks.futon.Futon_white;
import com.ayutaki.chinjufumod.blocks.futon.Futon_yellow;
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
import com.ayutaki.chinjufumod.items.chair.ItemWaraZabuton;
import com.ayutaki.chinjufumod.items.chair.ItemZabuton;
import com.ayutaki.chinjufumod.items.color.ItemHake;
import com.ayutaki.chinjufumod.items.color.ItemHake_Black;
import com.ayutaki.chinjufumod.items.color.ItemHake_Blue;
import com.ayutaki.chinjufumod.items.color.ItemHake_Brown;
import com.ayutaki.chinjufumod.items.color.ItemHake_Cyan;
import com.ayutaki.chinjufumod.items.color.ItemHake_Gray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Green;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightBlue;
import com.ayutaki.chinjufumod.items.color.ItemHake_LightGray;
import com.ayutaki.chinjufumod.items.color.ItemHake_Lime;
import com.ayutaki.chinjufumod.items.color.ItemHake_Magenta;
import com.ayutaki.chinjufumod.items.color.ItemHake_Orange;
import com.ayutaki.chinjufumod.items.color.ItemHake_Pink;
import com.ayutaki.chinjufumod.items.color.ItemHake_Purple;
import com.ayutaki.chinjufumod.items.color.ItemHake_Red;
import com.ayutaki.chinjufumod.items.color.ItemHake_White;
import com.ayutaki.chinjufumod.items.color.ItemHake_Yellow;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel100;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel150;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_Fuel200;
import com.ayutaki.chinjufumod.items.fuel.ItemBlock_noFuel;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_black;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_blue;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_brown;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_cyan;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_gray;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_green;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_lightblue;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_lightgray;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_lime;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_magenta;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_orange;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_pink;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_purple;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_red;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_white;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusumaB_yellow;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_black;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_blue;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_brown;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_cyan;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_gray;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_green;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_lightblue;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_lightgray;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_lime;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_magenta;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_orange;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_pink;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_purple;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_red;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_white;
import com.ayutaki.chinjufumod.items.fusuma.ItemFusuma_yellow;
import com.ayutaki.chinjufumod.items.garden.ItemChisel;
import com.ayutaki.chinjufumod.items.garden.ItemChouzubachi;
import com.ayutaki.chinjufumod.items.garden.ItemIkegakiLong;
import com.ayutaki.chinjufumod.items.garden.ItemIkegakiSmall;
import com.ayutaki.chinjufumod.items.garden.ItemIronFence;
import com.ayutaki.chinjufumod.items.garden.ItemIshitourou;
import com.ayutaki.chinjufumod.items.garden.ItemKanyou;
import com.ayutaki.chinjufumod.items.garden.ItemKumade;
import com.ayutaki.chinjufumod.items.garden.ItemLongtourou;
import com.ayutaki.chinjufumod.items.garden.ItemShishiOdoshi;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_bamboo;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_bamboo_K;
import com.ayutaki.chinjufumod.items.gate.ItemDoor_bamboo_Y;
import com.ayutaki.chinjufumod.items.gate.ItemGate_iron;
import com.ayutaki.chinjufumod.items.gate.ItemGate_irongrill;
import com.ayutaki.chinjufumod.items.gate.ItemGate_spruce;
import com.ayutaki.chinjufumod.items.gate.ItemGate_spruce_B;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_aca;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_bir;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_doak;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_jun;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_oak;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudoB_spru;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_aca;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_bir;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_doak;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_jun;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_oak;
import com.ayutaki.chinjufumod.items.glassdoor.ItemGarasudo_spru;
import com.ayutaki.chinjufumod.items.jpdeco.ItemTobukuro;
import com.ayutaki.chinjufumod.items.jpdeco.ItemTobukuroWin;
import com.ayutaki.chinjufumod.items.jpdeco.ItemTobukuroWin_spruce;
import com.ayutaki.chinjufumod.items.jpdeco.ItemTobukuro_spruce;
import com.ayutaki.chinjufumod.items.jpdeco.ItemWadaiko;
import com.ayutaki.chinjufumod.items.lamp.ItemAndon_1;
import com.ayutaki.chinjufumod.items.lamp.ItemAndon_2;
import com.ayutaki.chinjufumod.items.lamp.ItemAndon_3;
import com.ayutaki.chinjufumod.items.lamp.ItemAndon_4;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_aca;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_bir;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_doak;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_jun;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_oak;
import com.ayutaki.chinjufumod.items.shouji.ItemShoujiA_spru;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_aca;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_bir;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_doak;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_jun;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_oak;
import com.ayutaki.chinjufumod.items.shouji.ItemShouji_spru;
import com.ayutaki.chinjufumod.items.unitblock.ItemEndai;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Wadeco {

	public static Item GARASUDO, GARASUDO_SPRU, GARASUDO_BIR,
								GARASUDO_JUN, GARASUDO_ACA, GARASUDO_DOAK;
	public static Item GARASUDOB, GARASUDOB_SPRU, GARASUDOB_BIR,
								GARASUDOB_JUN, GARASUDOB_ACA, GARASUDOB_DOAK;

	public static Item GARASUDOH, GARASUDOH_SPRU, GARASUDOH_BIR,
								GARASUDOH_JUN, GARASUDOH_ACA, GARASUDOH_DOAK;

	public static Item SHOUJI, SHOUJI_SPRU, SHOUJI_BIR,
								SHOUJI_JUN, SHOUJI_ACA, SHOUJI_DOAK;
	public static Item SHOUJIA, SHOUJIA_SPRU, SHOUJIA_BIR,
								SHOUJIA_JUN, SHOUJIA_ACA, SHOUJIA_DOAK;

	public static Item SHOUJIH, SHOUJIH_SPRU, SHOUJIH_BIR,
								SHOUJIH_JUN, SHOUJIH_ACA, SHOUJIH_DOAK;

	public static Item SHOUJIWIN_oak, SHOUJIWIN_spruce, SHOUJIWIN_birch,
								SHOUJIWIN_jungle, SHOUJIWIN_acacia, SHOUJIWIN_darkoak;

	public static Item RANMA_oak, RANMA_spru, RANMA_bir, RANMA_jun, RANMA_aca, RANMA_doak;
	public static Item RANMAB_oak, RANMAB_spru, RANMAB_bir, RANMAB_jun, RANMAB_aca, RANMAB_doak;
	public static Item RANMAC_oak, RANMAC_spru, RANMAC_bir, RANMAC_jun, RANMAC_aca, RANMAC_doak;
	public static Item KANKI_oak, KANKI_spru, KANKI_bir, KANKI_jun, KANKI_aca, KANKI_doak;
	public static Item KOUSHI_oak, KOUSHI_spru, KOUSHI_bir, KOUSHI_jun, KOUSHI_aca, KOUSHI_doak;
	public static Item KOUSHIB_oak, KOUSHIB_spru, KOUSHIB_bir, KOUSHIB_jun, KOUSHIB_aca, KOUSHIB_doak;

	public static Item FUSUMA_white, FUSUMA_orange, FUSUMA_magenta,
								FUSUMA_lightblue, FUSUMA_yellow, FUSUMA_lime,
								FUSUMA_pink, FUSUMA_gray, FUSUMA_lightgray,
								FUSUMA_cyan, FUSUMA_purple, FUSUMA_blue,
								FUSUMA_brown, FUSUMA_green, FUSUMA_red, FUSUMA_black;
	public static Item FUSUMAB_white, FUSUMAB_orange, FUSUMAB_magenta,
								FUSUMAB_lightblue, FUSUMAB_yellow, FUSUMAB_lime,
								FUSUMAB_pink, FUSUMAB_gray, FUSUMAB_lightgray,
								FUSUMAB_cyan, FUSUMAB_purple, FUSUMAB_blue,
								FUSUMAB_brown, FUSUMAB_green, FUSUMAB_red, FUSUMAB_black;

	public static Item SUDARE;

	public static Item NOREN_white, NOREN_orange, NOREN_magenta, NOREN_lightb,
								NOREN_yellow, NOREN_lime, NOREN_pink, NOREN_gray,
								NOREN_lightg, NOREN_cyan, NOREN_purple, NOREN_blue,
								NOREN_brown, NOREN_green, NOREN_red, NOREN_black;

	public static Item WARAZABUTON, ZABUTON;

	public static Item ZAISU_white, ZAISU_orange, ZAISU_magenta, ZAISU_lightb,
								ZAISU_yellow, ZAISU_lime, ZAISU_pink, ZAISU_gray,
								ZAISU_lightg, ZAISU_cyan, ZAISU_purple, ZAISU_blue,
								ZAISU_brown, ZAISU_green, ZAISU_red, ZAISU_black;

	public static Item TATAMI_H, TATAMI_H_white, TATAMI_H_orange, TATAMI_H_magenta, TATAMI_H_lightb,
								TATAMI_H_yellow, TATAMI_H_lime, TATAMI_H_pink, TATAMI_H_gray,
								TATAMI_H_lightg, TATAMI_H_cyan, TATAMI_H_purple, TATAMI_H_blue,
								TATAMI_H_brown, TATAMI_H_green, TATAMI_H_red, TATAMI_H_black;

	public static Item TATAMI_HY, TATAMI_HY_white, TATAMI_HY_orange, TATAMI_HY_magenta, TATAMI_HY_lightb,
								TATAMI_HY_yellow, TATAMI_HY_lime, TATAMI_HY_pink, TATAMI_HY_gray,
								TATAMI_HY_lightg, TATAMI_HY_cyan, TATAMI_HY_purple, TATAMI_HY_blue,
								TATAMI_HY_brown, TATAMI_HY_green, TATAMI_HY_red, TATAMI_HY_black;

	public static Item TAKECUBE, TAKECUBE_Y, TAKECUBE_K, TAKE_SH, TAKE_SHY, TAKE_SHK, TAKE_ST, TAKE_STY, TAKE_STK;
	public static Item TAKEFENCE, TAKEFENCE_Y, TAKEFENCE_K;
	public static Item TAKEFENCEGATE, TAKEFENCEGATE_Y, TAKEFENCEGATE_K, TAKEDOOR, TAKEDOOR_Y, TAKEDOOR_K;
	public static Item TAKE_TRAPDOOR, TAKE_TRAPDOOR_Y, TAKE_TRAPDOOR_K;
	public static Item TAKE_PLATE, TAKE_PLATE_Y, TAKE_PLATE_K;
	public static Item TAKE_BUTTON, TAKE_BUTTON_Y, TAKE_BUTTON_K;

	public static Item FUTON_white, FUTON_orange, FUTON_magenta, FUTON_lightb,
								FUTON_yellow, FUTON_lime, FUTON_pink, FUTON_gray,
								FUTON_lightg, FUTON_cyan, FUTON_purple, FUTON_blue,
								FUTON_brown, FUTON_green, FUTON_red, FUTON_black;

	public static Item ANDON_1, ANDON_2, ANDON_3, ANDON_4;

	public static Item KASA_white, KASA_orange, KASA_magenta, KASA_lightb,
								KASA_yellow, KASA_lime, KASA_pink, KASA_gray,
								KASA_lightg, KASA_cyan, KASA_purple, KASA_blue,
								KASA_brown, KASA_green, KASA_red, KASA_black;

	public static Item TOBUKUROS_WINR, TOBUKUROS_BOTR, TOBUKURO_WINR, TOBUKURO_BOTR;

	public static Item BONSAI_oak, BONSAI_spru, BONSAI_bir, BONSAI_jun, BONSAI_aca, BONSAI_doak;
	public static Item KANYOU_BOT, IKEGAKI, IKEGAKILONG_BOT;

	public static Item SHISHIODOSHI;
	public static Item CHOUZUBACHI, ISHITOUROU, LONGTOUROU;
	public static Item TAKEAKARI;

	public static Item WADAIKO, WADAIKO_small;

	public static Item ENDAI;

	public static Item GATE_SPRUCE, GATE_SPRUCE_B, GATE_IRON, GATE_IRONGRILL, TETSUSAKU_BOT;

	public static Item HAKE;
	public static Item HAKE_white, HAKE_orange, HAKE_magenta, HAKE_lightb,
								HAKE_yellow, HAKE_lime, HAKE_pink, HAKE_gray,
								HAKE_lightg, HAKE_cyan, HAKE_purple, HAKE_blue,
								HAKE_brown, HAKE_green, HAKE_red, HAKE_black;

	public static Item KUMADE, NOMI, MAKIBISHI;

	public static void init() {

		GARASUDO = new ItemGarasudo_oak();
		GARASUDO_SPRU = new ItemGarasudo_spru();
		GARASUDO_BIR = new ItemGarasudo_bir();
		GARASUDO_JUN = new ItemGarasudo_jun();
		GARASUDO_ACA = new ItemGarasudo_aca();
		GARASUDO_DOAK = new ItemGarasudo_doak();
		GARASUDOB = new ItemGarasudoB_oak();
		GARASUDOB_SPRU = new ItemGarasudoB_spru();
		GARASUDOB_BIR = new ItemGarasudoB_bir();
		GARASUDOB_JUN = new ItemGarasudoB_jun();
		GARASUDOB_ACA = new ItemGarasudoB_aca();
		GARASUDOB_DOAK = new ItemGarasudoB_doak();

		GARASUDOH = new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH, "block_garasudohalf");
		GARASUDOH_SPRU= new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_SPRU, "block_garasudohalf_spruce");
		GARASUDOH_BIR= new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_BIR, "block_garasudohalf_birch");
		GARASUDOH_JUN= new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_JUN, "block_garasudohalf_jungle");
		GARASUDOH_ACA= new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_ACA, "block_garasudohalf_acacia");
		GARASUDOH_DOAK= new ItemBlock_noFuel(Slidingdoor_Blocks.GARASUDOH_DOAK, "block_garasudohalf_darkoak");

		SHOUJI = new ItemShouji_oak();
		SHOUJI_SPRU = new ItemShouji_spru();
		SHOUJI_BIR = new ItemShouji_bir();
		SHOUJI_JUN = new ItemShouji_jun();
		SHOUJI_ACA = new ItemShouji_aca();
		SHOUJI_DOAK = new ItemShouji_doak();
		SHOUJIA = new ItemShoujiA_oak();
		SHOUJIA_SPRU = new ItemShoujiA_spru();
		SHOUJIA_BIR = new ItemShoujiA_bir();
		SHOUJIA_JUN = new ItemShoujiA_jun();
		SHOUJIA_ACA = new ItemShoujiA_aca();
		SHOUJIA_DOAK = new ItemShoujiA_doak();

		SHOUJIH = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH, "block_shoujihalf");
		SHOUJIH_SPRU = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_SPRU, "block_shoujihalf_spruce");
		SHOUJIH_BIR = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_BIR, "block_shoujihalf_birch");
		SHOUJIH_JUN = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_JUN, "block_shoujihalf_jungle");
		SHOUJIH_ACA = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_ACA, "block_shoujihalf_acacia");
		SHOUJIH_DOAK = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIH_DOAK, "block_shoujihalf_darkoak");

		SHOUJIWIN_oak = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_oak, "block_shoujih");
		SHOUJIWIN_spruce = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_spruce, "block_shoujih_spruce");
		SHOUJIWIN_birch = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_birch, "block_shoujih_birch");
		SHOUJIWIN_jungle = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_jungle, "block_shoujih_jungle");
		SHOUJIWIN_acacia = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_acacia, "block_shoujih_acacia");
		SHOUJIWIN_darkoak = new ItemBlock_Fuel100(Slidingdoor_Blocks.SHOUJIWIN_darkoak, "block_shoujih_darkoak");

		RANMA_oak = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_oak, "block_ranma_oak");
		RANMA_spru = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_spru, "block_ranma_spru");
		RANMA_bir = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_bir, "block_ranma_bir");
		RANMA_jun = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_jun, "block_ranma_jun");
		RANMA_aca = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_aca, "block_ranma_aca");
		RANMA_doak = new ItemBlock_Fuel100(JPDeco_Blocks.RANMA_doak, "block_ranma_doak");

		RANMAB_oak = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_oak, "block_ranmab_oak");
		RANMAB_spru = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_spru, "block_ranmab_spru");
		RANMAB_bir = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_bir, "block_ranmab_bir");
		RANMAB_jun = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_jun, "block_ranmab_jun");
		RANMAB_aca = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_aca, "block_ranmab_aca");
		RANMAB_doak = new ItemBlock_Fuel100(JPDeco_Blocks.RANMAB_doak, "block_ranmab_doak");

		RANMAC_oak = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_oak, "block_ranmac_oak");
		RANMAC_spru = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_spru, "block_ranmac_spru");
		RANMAC_bir = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_bir, "block_ranmac_bir");
		RANMAC_jun = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_jun, "block_ranmac_jun");
		RANMAC_aca = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_aca, "block_ranmac_aca");
		RANMAC_doak = new ItemBlock_noFuel(JPDeco_Blocks.RANMAC_doak, "block_ranmac_doak");

		KANKI_oak = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_oak, "block_kanki_oak");
		KANKI_spru = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_spru, "block_kanki_spru");
		KANKI_bir = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_bir, "block_kanki_bir");
		KANKI_jun = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_jun, "block_kanki_jun");
		KANKI_aca = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_aca, "block_kanki_aca");
		KANKI_doak = new ItemBlock_Fuel100(JPDeco_Blocks.KANKI_doak, "block_kanki_doak");

		KOUSHI_oak = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_oak, "block_koushi_oak");
		KOUSHI_spru = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_spru, "block_koushi_spru");
		KOUSHI_bir = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_bir, "block_koushi_bir");
		KOUSHI_jun = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_jun, "block_koushi_jun");
		KOUSHI_aca = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_aca, "block_koushi_aca");
		KOUSHI_doak = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHI_doak, "block_koushi_doak");

		KOUSHIB_oak = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_oak, "block_koushib_oak");
		KOUSHIB_spru = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_spru, "block_koushib_spru");
		KOUSHIB_bir = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_bir, "block_koushib_bir");
		KOUSHIB_jun = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_jun, "block_koushib_jun");
		KOUSHIB_aca = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_aca, "block_koushib_aca");
		KOUSHIB_doak = new ItemBlock_Fuel100(JPDeco_Blocks.KOUSHIB_doak, "block_koushib_doak");

		FUSUMA_white = new ItemFusuma_white();
		FUSUMA_orange = new ItemFusuma_orange();
		FUSUMA_magenta = new ItemFusuma_magenta();
		FUSUMA_lightblue = new ItemFusuma_lightblue();
		FUSUMA_yellow = new ItemFusuma_yellow();
		FUSUMA_lime = new ItemFusuma_lime();
		FUSUMA_pink = new ItemFusuma_pink();
		FUSUMA_gray = new ItemFusuma_gray();
		FUSUMA_lightgray = new ItemFusuma_lightgray();
		FUSUMA_cyan = new ItemFusuma_cyan();
		FUSUMA_purple = new ItemFusuma_purple();
		FUSUMA_blue = new ItemFusuma_blue();
		FUSUMA_brown = new ItemFusuma_brown();
		FUSUMA_green = new ItemFusuma_green();
		FUSUMA_red = new ItemFusuma_red();
		FUSUMA_black = new ItemFusuma_black();

		FUSUMAB_white = new ItemFusumaB_white();
		FUSUMAB_orange = new ItemFusumaB_orange();
		FUSUMAB_magenta = new ItemFusumaB_magenta();
		FUSUMAB_lightblue = new ItemFusumaB_lightblue();
		FUSUMAB_yellow = new ItemFusumaB_yellow();
		FUSUMAB_lime = new ItemFusumaB_lime();
		FUSUMAB_pink = new ItemFusumaB_pink();
		FUSUMAB_gray = new ItemFusumaB_gray();
		FUSUMAB_lightgray = new ItemFusumaB_lightgray();
		FUSUMAB_cyan = new ItemFusumaB_cyan();
		FUSUMAB_purple = new ItemFusumaB_purple();
		FUSUMAB_blue = new ItemFusumaB_blue();
		FUSUMAB_brown = new ItemFusumaB_brown();
		FUSUMAB_green = new ItemFusumaB_green();
		FUSUMAB_red = new ItemFusumaB_red();
		FUSUMAB_black = new ItemFusumaB_black();

		SUDARE = new ItemBlock_Fuel100(JPDeco_Blocks.SUDARE, "block_sudare_1");

		NOREN_white = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_white, "block_noren_white");
		NOREN_orange = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_orange, "block_noren_orange");
		NOREN_magenta = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_magenta, "block_noren_magenta");
		NOREN_lightb = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_lightb, "block_noren_lightb");
		NOREN_yellow = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_yellow, "block_noren_yellow");
		NOREN_lime = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_lime, "block_noren_lime");
		NOREN_pink = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_pink, "block_noren_pink");
		NOREN_gray = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_gray, "block_noren_gray");
		NOREN_lightg = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_lightg, "block_noren_lightg");
		NOREN_cyan = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_cyan, "block_noren_cyan");
		NOREN_purple = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_purple, "block_noren_purple");
		NOREN_blue = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_blue, "block_noren_blue");
		NOREN_brown = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_brown, "block_noren_brown");
		NOREN_green = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_green, "block_noren_green");
		NOREN_red = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_red, "block_noren_red");
		NOREN_black = new ItemBlock_noFuel(JPDeco_Blocks.NOREN_black, "block_noren_black");

		WARAZABUTON = new ItemWaraZabuton();
		ZABUTON = new ItemZabuton();

		ZAISU_white = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_white, "block_zaisu_white");
		ZAISU_orange = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_orange, "block_zaisu_orange");
		ZAISU_magenta = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_magenta, "block_zaisu_magenta");
		ZAISU_lightb = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_lightb, "block_zaisu_lightb");
		ZAISU_yellow = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_yellow, "block_zaisu_yellow");
		ZAISU_lime = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_lime, "block_zaisu_lime");
		ZAISU_pink = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_pink, "block_zaisu_pink");
		ZAISU_gray = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_gray, "block_zaisu_gray");
		ZAISU_lightg = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_lightg, "block_zaisu_lightg");
		ZAISU_cyan = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_cyan, "block_zaisu_cyan");
		ZAISU_purple = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_purple, "block_zaisu_purple");
		ZAISU_blue = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_blue, "block_zaisu_blue");
		ZAISU_brown = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_brown, "block_zaisu_brown");
		ZAISU_green = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_green, "block_zaisu_green");
		ZAISU_red = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_red, "block_zaisu_red");
		ZAISU_black = new ItemBlock_Fuel150(JPDeco_Blocks.ZAISU_black, "block_zaisu_black");

		TATAMI_H = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H, "block_tatamih");
		TATAMI_H_white = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_white, "block_tatamih_white");
		TATAMI_H_orange = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_orange, "block_tatamih_orange");
		TATAMI_H_magenta = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_magenta, "block_tatamih_magenta");
		TATAMI_H_lightb = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_lightb, "block_tatamih_lightb");
		TATAMI_H_yellow = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_yellow, "block_tatamih_yellow");
		TATAMI_H_lime = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_lime, "block_tatamih_lime");
		TATAMI_H_pink = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_pink, "block_tatamih_pink");
		TATAMI_H_gray = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_gray, "block_tatamih_gray");
		TATAMI_H_lightg = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_lightg, "block_tatamih_lightg");
		TATAMI_H_cyan = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_cyan, "block_tatamih_cyan");
		TATAMI_H_purple = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_purple, "block_tatamih_purple");
		TATAMI_H_blue = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_blue, "block_tatamih_blue");
		TATAMI_H_brown = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_brown, "block_tatamih_brown");
		TATAMI_H_green = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_green, "block_tatamih_green");
		TATAMI_H_red = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_red, "block_tatamih_red");
		TATAMI_H_black = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_H_black, "block_tatamih_black");

		TATAMI_HY = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY, "block_tatamih_y");
		TATAMI_HY_white = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_white, "block_tatamih_y_white");
		TATAMI_HY_orange = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_orange, "block_tatamih_y_orange");
		TATAMI_HY_magenta = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_magenta, "block_tatamih_y_magenta");
		TATAMI_HY_lightb = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_lightb, "block_tatamih_y_lightb");
		TATAMI_HY_yellow = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_yellow, "block_tatamih_y_yellow");
		TATAMI_HY_lime = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_lime, "block_tatamih_y_lime");
		TATAMI_HY_pink = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_pink, "block_tatamih_y_pink");
		TATAMI_HY_gray = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_gray, "block_tatamih_y_gray");
		TATAMI_HY_lightg = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_lightg, "block_tatamih_y_lightg");
		TATAMI_HY_cyan = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_cyan, "block_tatamih_y_cyan");
		TATAMI_HY_purple = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_purple, "block_tatamih_y_purple");
		TATAMI_HY_blue = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_blue, "block_tatamih_y_blue");
		TATAMI_HY_brown = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_brown, "block_tatamih_y_brown");
		TATAMI_HY_green = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_green, "block_tatamih_y_green");
		TATAMI_HY_red = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_red, "block_tatamih_y_red");
		TATAMI_HY_black = new ItemBlock_Fuel150(JPDeco_Blocks.TATAMI_HY_black, "block_tatamih_y_black");

		TAKECUBE = new ItemBlock_Fuel200(JPDeco_Blocks.TAKECUBE, "block_bamboo_cube");
		TAKECUBE_Y = new ItemBlock_Fuel200(JPDeco_Blocks.TAKECUBE_Y, "block_bamboo_y_cube");
		TAKECUBE_K = new ItemBlock_Fuel200(JPDeco_Blocks.TAKECUBE_K, "block_bamboo_k_cube");
		TAKE_SH = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_SH, "block_bamboo_slab");
		TAKE_SHY = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_SHY, "block_bamboo_y_slab");
		TAKE_SHK = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_SHK, "block_bamboo_k_slab");
		TAKE_ST = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_ST, "block_bamboo_stairs");
		TAKE_STY = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_STY, "block_bamboo_y_stairs");
		TAKE_STK = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_STK, "block_bamboo_k_stairs");

		TAKEFENCE = new ItemBlock_Fuel150(JPDeco_Blocks.TAKEFENCE, "block_bamboo_fence");
		TAKEFENCE_Y = new ItemBlock_Fuel150(JPDeco_Blocks.TAKEFENCE_Y, "block_bamboo_y_fence");
		TAKEFENCE_K = new ItemBlock_Fuel150(JPDeco_Blocks.TAKEFENCE_K, "block_bamboo_k_fence");

		TAKEFENCEGATE = new ItemBlock_Fuel150(Door_Blocks.TAKEFENCEGATE, "block_bamboo_fencegate");
		TAKEFENCEGATE_Y = new ItemBlock_Fuel150(Door_Blocks.TAKEFENCEGATE_Y, "block_bamboo_y_fencegate");
		TAKEFENCEGATE_K = new ItemBlock_Fuel150(Door_Blocks.TAKEFENCEGATE_K, "block_bamboo_k_fencegate");
		TAKEDOOR = new ItemDoor_bamboo();
		TAKEDOOR_Y = new ItemDoor_bamboo_Y();
		TAKEDOOR_K = new ItemDoor_bamboo_K();

		TAKE_TRAPDOOR = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR, "block_bamboo_trapdoor");
		TAKE_TRAPDOOR_Y = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR_Y, "block_bamboo_y_trapdoor");
		TAKE_TRAPDOOR_K = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_TRAPDOOR_K, "block_bamboo_k_trapdoor");
		TAKE_PLATE = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_PLATE, "block_bamboo_plate");
		TAKE_PLATE_Y = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_PLATE_Y, "block_bamboo_y_plate");
		TAKE_PLATE_K = new ItemBlock_Fuel150(JPDeco_Blocks.TAKE_PLATE_K, "block_bamboo_k_plate");
		TAKE_BUTTON = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_BUTTON, "block_bamboo_button");
		TAKE_BUTTON_Y = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_BUTTON_Y, "block_bamboo_y_button");
		TAKE_BUTTON_K = new ItemBlock_Fuel100(JPDeco_Blocks.TAKE_BUTTON_K, "block_bamboo_k_button");

		FUTON_white = new ItemBlock_Fuel150(Futon_Blocks.FUTON_white, Futon_white.ID);
		FUTON_orange = new ItemBlock_Fuel150(Futon_Blocks.FUTON_orange, Futon_orange.ID);
		FUTON_magenta = new ItemBlock_Fuel150(Futon_Blocks.FUTON_magenta, Futon_magenta.ID);
		FUTON_lightb = new ItemBlock_Fuel150(Futon_Blocks.FUTON_lightb, Futon_lightb.ID);
		FUTON_yellow = new ItemBlock_Fuel150(Futon_Blocks.FUTON_yellow, Futon_yellow.ID);
		FUTON_lime = new ItemBlock_Fuel150(Futon_Blocks.FUTON_lime, Futon_lime.ID);
		FUTON_pink = new ItemBlock_Fuel150(Futon_Blocks.FUTON_pink, Futon_pink.ID);
		FUTON_gray = new ItemBlock_Fuel150(Futon_Blocks.FUTON_gray, Futon_gray.ID);
		FUTON_lightg = new ItemBlock_Fuel150(Futon_Blocks.FUTON_lightg, Futon_lightg.ID);
		FUTON_cyan = new ItemBlock_Fuel150(Futon_Blocks.FUTON_cyan, Futon_cyan.ID);
		FUTON_purple = new ItemBlock_Fuel150(Futon_Blocks.FUTON_purple, Futon_purple.ID);
		FUTON_blue = new ItemBlock_Fuel150(Futon_Blocks.FUTON_blue, Futon_blue.ID);
		FUTON_brown = new ItemBlock_Fuel150(Futon_Blocks.FUTON_brown, Futon_brown.ID);
		FUTON_green = new ItemBlock_Fuel150(Futon_Blocks.FUTON_green, Futon_green.ID);
		FUTON_red = new ItemBlock_Fuel150(Futon_Blocks.FUTON_red, Futon_red.ID);
		FUTON_black = new ItemBlock_Fuel150(Futon_Blocks.FUTON_black, Futon_black.ID);

		ANDON_1 = new ItemAndon_1();
		ANDON_2 = new ItemAndon_2();
		ANDON_3 = new ItemAndon_3();
		ANDON_4 = new ItemAndon_4();

		KASA_white = new ItemBlock_noFuel(Garden_Blocks.KASA_white, Kasa_white.ID);
		KASA_orange = new ItemBlock_noFuel(Garden_Blocks.KASA_orange, Kasa_orange.ID);
		KASA_magenta = new ItemBlock_noFuel(Garden_Blocks.KASA_magenta, Kasa_magenta.ID);
		KASA_lightb = new ItemBlock_noFuel(Garden_Blocks.KASA_lightb, Kasa_lightb.ID);
		KASA_yellow = new ItemBlock_noFuel(Garden_Blocks.KASA_yellow, Kasa_yellow.ID);
		KASA_lime = new ItemBlock_noFuel(Garden_Blocks.KASA_lime, Kasa_lime.ID);
		KASA_pink = new ItemBlock_noFuel(Garden_Blocks.KASA_pink, Kasa_pink.ID);
		KASA_gray = new ItemBlock_noFuel(Garden_Blocks.KASA_gray, Kasa_gray.ID);
		KASA_lightg = new ItemBlock_noFuel(Garden_Blocks.KASA_lightg, Kasa_lightg.ID);
		KASA_cyan = new ItemBlock_noFuel(Garden_Blocks.KASA_cyan, Kasa_cyan.ID);
		KASA_purple = new ItemBlock_noFuel(Garden_Blocks.KASA_purple, Kasa_purple.ID);
		KASA_blue = new ItemBlock_noFuel(Garden_Blocks.KASA_blue, Kasa_blue.ID);
		KASA_brown = new ItemBlock_noFuel(Garden_Blocks.KASA_brown, Kasa_brown.ID);
		KASA_green = new ItemBlock_noFuel(Garden_Blocks.KASA_green, Kasa_green.ID);
		KASA_red = new ItemBlock_noFuel(Garden_Blocks.KASA_red, Kasa_red.ID);
		KASA_black = new ItemBlock_noFuel(Garden_Blocks.KASA_black, Kasa_black.ID);

		TOBUKUROS_WINR = new ItemTobukuroWin_spruce();
		TOBUKUROS_BOTR = new ItemTobukuro_spruce();
		TOBUKURO_WINR = new ItemTobukuroWin();
		TOBUKURO_BOTR = new ItemTobukuro();

		BONSAI_oak = new ItemBlock_noFuel(Garden_Blocks.BONSAI_oak, "block_bonsai_oak");
		BONSAI_spru = new ItemBlock_noFuel(Garden_Blocks.BONSAI_spru, "block_bonsai_spruce");
		BONSAI_bir = new ItemBlock_noFuel(Garden_Blocks.BONSAI_bir, "block_bonsai_birch");
		BONSAI_jun = new ItemBlock_noFuel(Garden_Blocks.BONSAI_jun, "block_bonsai_jungle");
		BONSAI_aca = new ItemBlock_noFuel(Garden_Blocks.BONSAI_aca, "block_bonsai_acacia");
		BONSAI_doak = new ItemBlock_noFuel(Garden_Blocks.BONSAI_doak, "block_bonsai_darkoak");

		KANYOU_BOT = new ItemKanyou();
		IKEGAKI = new ItemIkegakiSmall();
		IKEGAKILONG_BOT = new ItemIkegakiLong();

		SHISHIODOSHI = new ItemShishiOdoshi();
		CHOUZUBACHI = new ItemChouzubachi();
		ISHITOUROU = new ItemIshitourou();
		LONGTOUROU = new ItemLongtourou();

		TAKEAKARI = new ItemBlock_Fuel100(Lamp_Blocks.TAKEAKARI, Takeakari.ID);

		WADAIKO = new ItemWadaiko();
		WADAIKO_small = new ItemBlock_Fuel150(JPDeco_Blocks.WADAIKO_small, "block_wadaiko_small");

		ENDAI = new ItemEndai();

		GATE_SPRUCE = new ItemGate_spruce();
		GATE_SPRUCE_B = new ItemGate_spruce_B();
		GATE_IRON = new ItemGate_iron();
		GATE_IRONGRILL = new ItemGate_irongrill();
		TETSUSAKU_BOT = new ItemIronFence();

		HAKE = new ItemHake("item_hake");
		HAKE_white = new ItemHake_White("item_hake_white");
		HAKE_orange = new ItemHake_Orange("item_hake_orange");
		HAKE_magenta = new ItemHake_Magenta("item_hake_magenta");
		HAKE_lightb = new ItemHake_LightBlue("item_hake_lightblue");
		HAKE_yellow = new ItemHake_Yellow("item_hake_yellow");
		HAKE_lime = new ItemHake_Lime("item_hake_lime");
		HAKE_pink = new ItemHake_Pink("item_hake_pink");
		HAKE_gray = new ItemHake_Gray("item_hake_gray");
		HAKE_lightg = new ItemHake_LightGray("item_hake_lightgray");
		HAKE_cyan = new ItemHake_Cyan("item_hake_cyan");
		HAKE_purple = new ItemHake_Purple("item_hake_purple");
		HAKE_blue = new ItemHake_Blue("item_hake_blue");
		HAKE_brown = new ItemHake_Brown("item_hake_brown");
		HAKE_green = new ItemHake_Green("item_hake_green");
		HAKE_red = new ItemHake_Red("item_hake_red");
		HAKE_black = new ItemHake_Black("item_hake_black");

		KUMADE = new ItemKumade("item_kumade");
		NOMI = new ItemChisel("item_chisel");
		MAKIBISHI = new ItemBlock_noFuel(Garden_Blocks.MAKIBISHI, "block_makibishi");
	}

	public static void register() {

		registerItem(GARASUDO);
		registerItem(GARASUDO_SPRU);
		registerItem(GARASUDO_BIR);
		registerItem(GARASUDO_JUN);
		registerItem(GARASUDO_ACA);
		registerItem(GARASUDO_DOAK);
		registerItem(GARASUDOB);
		registerItem(GARASUDOB_SPRU);
		registerItem(GARASUDOB_BIR);
		registerItem(GARASUDOB_JUN);
		registerItem(GARASUDOB_ACA);
		registerItem(GARASUDOB_DOAK);

		registerItem(GARASUDOH);
		registerItem(GARASUDOH_SPRU);
		registerItem(GARASUDOH_BIR);
		registerItem(GARASUDOH_JUN);
		registerItem(GARASUDOH_ACA);
		registerItem(GARASUDOH_DOAK);

		registerItem(SHOUJI);
		registerItem(SHOUJI_SPRU);
		registerItem(SHOUJI_BIR);
		registerItem(SHOUJI_JUN);
		registerItem(SHOUJI_ACA);
		registerItem(SHOUJI_DOAK);
		registerItem(SHOUJIA);
		registerItem(SHOUJIA_SPRU);
		registerItem(SHOUJIA_BIR);
		registerItem(SHOUJIA_JUN);
		registerItem(SHOUJIA_ACA);
		registerItem(SHOUJIA_DOAK);

		registerItem(SHOUJIH);
		registerItem(SHOUJIH_SPRU);
		registerItem(SHOUJIH_BIR);
		registerItem(SHOUJIH_JUN);
		registerItem(SHOUJIH_ACA);
		registerItem(SHOUJIH_DOAK);

		registerItem(SHOUJIWIN_oak);
		registerItem(SHOUJIWIN_spruce );
		registerItem(SHOUJIWIN_birch );
		registerItem(SHOUJIWIN_jungle);
		registerItem(SHOUJIWIN_acacia);
		registerItem(SHOUJIWIN_darkoak);

		registerItem(RANMA_oak);
		registerItem(RANMA_spru);
		registerItem(RANMA_bir);
		registerItem(RANMA_jun);
		registerItem(RANMA_aca);
		registerItem(RANMA_doak);

		registerItem(RANMAB_oak);
		registerItem(RANMAB_spru);
		registerItem(RANMAB_bir);
		registerItem(RANMAB_jun);
		registerItem(RANMAB_aca);
		registerItem(RANMAB_doak);

		registerItem(RANMAC_oak);
		registerItem(RANMAC_spru);
		registerItem(RANMAC_bir);
		registerItem(RANMAC_jun);
		registerItem(RANMAC_aca);
		registerItem(RANMAC_doak);

		registerItem(KANKI_oak);
		registerItem(KANKI_spru);
		registerItem(KANKI_bir);
		registerItem(KANKI_jun);
		registerItem(KANKI_aca);
		registerItem(KANKI_doak);

		registerItem(KOUSHI_oak);
		registerItem(KOUSHI_spru);
		registerItem(KOUSHI_bir);
		registerItem(KOUSHI_jun);
		registerItem(KOUSHI_aca);
		registerItem(KOUSHI_doak);

		registerItem(KOUSHIB_oak);
		registerItem(KOUSHIB_spru);
		registerItem(KOUSHIB_bir);
		registerItem(KOUSHIB_jun);
		registerItem(KOUSHIB_aca);
		registerItem(KOUSHIB_doak);

		registerItem(FUSUMA_white);
		registerItem(FUSUMA_orange);
		registerItem(FUSUMA_magenta);
		registerItem(FUSUMA_lightblue);
		registerItem(FUSUMA_yellow);
		registerItem(FUSUMA_lime);
		registerItem(FUSUMA_pink);
		registerItem(FUSUMA_gray);
		registerItem(FUSUMA_lightgray);
		registerItem(FUSUMA_cyan);
		registerItem(FUSUMA_purple);
		registerItem(FUSUMA_blue);
		registerItem(FUSUMA_brown);
		registerItem(FUSUMA_green);
		registerItem(FUSUMA_red);
		registerItem(FUSUMA_black);

		registerItem(FUSUMAB_white);
		registerItem(FUSUMAB_orange);
		registerItem(FUSUMAB_magenta);
		registerItem(FUSUMAB_lightblue);
		registerItem(FUSUMAB_yellow);
		registerItem(FUSUMAB_lime);
		registerItem(FUSUMAB_pink);
		registerItem(FUSUMAB_gray);
		registerItem(FUSUMAB_lightgray);
		registerItem(FUSUMAB_cyan);
		registerItem(FUSUMAB_purple);
		registerItem(FUSUMAB_blue);
		registerItem(FUSUMAB_brown);
		registerItem(FUSUMAB_green);
		registerItem(FUSUMAB_red);
		registerItem(FUSUMAB_black);

		registerItem(SUDARE);

		registerItem(NOREN_white);
		registerItem(NOREN_orange);
		registerItem(NOREN_magenta);
		registerItem(NOREN_lightb);
		registerItem(NOREN_yellow);
		registerItem(NOREN_lime);
		registerItem(NOREN_pink);
		registerItem(NOREN_gray);
		registerItem(NOREN_lightg);
		registerItem(NOREN_cyan);
		registerItem(NOREN_purple);
		registerItem(NOREN_blue);
		registerItem(NOREN_brown);
		registerItem(NOREN_green);
		registerItem(NOREN_red);
		registerItem(NOREN_black);

		registerItem(WARAZABUTON);
		registerItem(ZABUTON);

		registerItem(ZAISU_white);
		registerItem(ZAISU_orange);
		registerItem(ZAISU_magenta);
		registerItem(ZAISU_lightb);
		registerItem(ZAISU_yellow);
		registerItem(ZAISU_lime);
		registerItem(ZAISU_pink);
		registerItem(ZAISU_gray);
		registerItem(ZAISU_lightg);
		registerItem(ZAISU_cyan);
		registerItem(ZAISU_purple);
		registerItem(ZAISU_blue);
		registerItem(ZAISU_brown);
		registerItem(ZAISU_green);
		registerItem(ZAISU_red);
		registerItem(ZAISU_black);

		registerItem(TATAMI_H);
		registerItem(TATAMI_H_white);
		registerItem(TATAMI_H_orange);
		registerItem(TATAMI_H_magenta);
		registerItem(TATAMI_H_lightb);
		registerItem(TATAMI_H_yellow);
		registerItem(TATAMI_H_lime);
		registerItem(TATAMI_H_pink);
		registerItem(TATAMI_H_gray);
		registerItem(TATAMI_H_lightg);
		registerItem(TATAMI_H_cyan);
		registerItem(TATAMI_H_purple);
		registerItem(TATAMI_H_blue);
		registerItem(TATAMI_H_brown);
		registerItem(TATAMI_H_green);
		registerItem(TATAMI_H_red);
		registerItem(TATAMI_H_black);

		registerItem(TATAMI_HY);
		registerItem(TATAMI_HY_white);
		registerItem(TATAMI_HY_orange);
		registerItem(TATAMI_HY_magenta);
		registerItem(TATAMI_HY_lightb);
		registerItem(TATAMI_HY_yellow);
		registerItem(TATAMI_HY_lime);
		registerItem(TATAMI_HY_pink);
		registerItem(TATAMI_HY_gray);
		registerItem(TATAMI_HY_lightg);
		registerItem(TATAMI_HY_cyan);
		registerItem(TATAMI_HY_purple);
		registerItem(TATAMI_HY_blue);
		registerItem(TATAMI_HY_brown);
		registerItem(TATAMI_HY_green);
		registerItem(TATAMI_HY_red);
		registerItem(TATAMI_HY_black);

		registerItem(TAKECUBE);
		registerItem(TAKECUBE_Y);
		registerItem(TAKECUBE_K);
		registerItem(TAKE_SH);
		registerItem(TAKE_SHY);
		registerItem(TAKE_SHK);
		registerItem(TAKE_ST);
		registerItem(TAKE_STY);
		registerItem(TAKE_STK);

		registerItem(TAKEFENCE);
		registerItem(TAKEFENCE_Y);
		registerItem(TAKEFENCE_K);

		registerItem(TAKEFENCEGATE);
		registerItem(TAKEFENCEGATE_Y);
		registerItem(TAKEFENCEGATE_K);
		registerItem(TAKEDOOR);
		registerItem(TAKEDOOR_Y);
		registerItem(TAKEDOOR_K);

		registerItem(TAKE_TRAPDOOR);
		registerItem(TAKE_TRAPDOOR_Y);
		registerItem(TAKE_TRAPDOOR_K);
		registerItem(TAKE_PLATE);
		registerItem(TAKE_PLATE_Y);
		registerItem(TAKE_PLATE_K);
		registerItem(TAKE_BUTTON);
		registerItem(TAKE_BUTTON_Y);
		registerItem(TAKE_BUTTON_K);

		registerItem(FUTON_white);
		registerItem(FUTON_orange);
		registerItem(FUTON_magenta);
		registerItem(FUTON_lightb);
		registerItem(FUTON_yellow);
		registerItem(FUTON_lime);
		registerItem(FUTON_pink);
		registerItem(FUTON_gray);
		registerItem(FUTON_lightg);
		registerItem(FUTON_cyan);
		registerItem(FUTON_purple);
		registerItem(FUTON_blue);
		registerItem(FUTON_brown);
		registerItem(FUTON_green);
		registerItem(FUTON_red);
		registerItem(FUTON_black);

		registerItem(ANDON_1);
		registerItem(ANDON_2);
		registerItem(ANDON_3);
		registerItem(ANDON_4);

		registerItem(KASA_white);
		registerItem(KASA_orange);
		registerItem(KASA_magenta);
		registerItem(KASA_lightb);
		registerItem(KASA_yellow);
		registerItem(KASA_lime);
		registerItem(KASA_pink);
		registerItem(KASA_gray);
		registerItem(KASA_lightg);
		registerItem(KASA_cyan);
		registerItem(KASA_purple);
		registerItem(KASA_blue);
		registerItem(KASA_brown);
		registerItem(KASA_green);
		registerItem(KASA_red);
		registerItem(KASA_black);

		registerItem(TOBUKUROS_WINR);
		registerItem(TOBUKUROS_BOTR);
		registerItem(TOBUKURO_WINR);
		registerItem(TOBUKURO_BOTR);

		registerItem(BONSAI_oak);
		registerItem(BONSAI_spru);
		registerItem(BONSAI_bir);
		registerItem(BONSAI_jun);
		registerItem(BONSAI_aca);
		registerItem(BONSAI_doak);
		registerItem(KANYOU_BOT);
		registerItem(IKEGAKI);
		registerItem(IKEGAKILONG_BOT);

		registerItem(SHISHIODOSHI);
		registerItem(CHOUZUBACHI);
		registerItem(ISHITOUROU);
		registerItem(LONGTOUROU);

		registerItem(TAKEAKARI);

		registerItem(WADAIKO);
		registerItem(WADAIKO_small);

		registerItem(ENDAI);

		registerItem(GATE_SPRUCE);
		registerItem(GATE_SPRUCE_B);
		registerItem(GATE_IRON);
		registerItem(GATE_IRONGRILL);
		registerItem(TETSUSAKU_BOT);

		registerItem(HAKE);
		registerItem(HAKE_white);
		registerItem(HAKE_orange);
		registerItem(HAKE_magenta);
		registerItem(HAKE_lightb);
		registerItem(HAKE_yellow);
		registerItem(HAKE_lime);
		registerItem(HAKE_pink);
		registerItem(HAKE_gray);
		registerItem(HAKE_lightg);
		registerItem(HAKE_cyan);
		registerItem(HAKE_purple);
		registerItem(HAKE_blue);
		registerItem(HAKE_brown);
		registerItem(HAKE_green);
		registerItem(HAKE_red);
		registerItem(HAKE_black);

		registerItem(KUMADE);
		registerItem(NOMI);
		registerItem(MAKIBISHI);
	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(GARASUDO);
		registerRender(GARASUDO_SPRU);
		registerRender(GARASUDO_BIR);
		registerRender(GARASUDO_JUN);
		registerRender(GARASUDO_ACA);
		registerRender(GARASUDO_DOAK);
		registerRender(GARASUDOB);
		registerRender(GARASUDOB_SPRU);
		registerRender(GARASUDOB_BIR);
		registerRender(GARASUDOB_JUN);
		registerRender(GARASUDOB_ACA);
		registerRender(GARASUDOB_DOAK);

		registerRender(GARASUDOH);
		registerRender(GARASUDOH_SPRU);
		registerRender(GARASUDOH_BIR);
		registerRender(GARASUDOH_JUN);
		registerRender(GARASUDOH_ACA);
		registerRender(GARASUDOH_DOAK);

		registerRender(SHOUJI);
		registerRender(SHOUJI_SPRU);
		registerRender(SHOUJI_BIR);
		registerRender(SHOUJI_JUN);
		registerRender(SHOUJI_ACA);
		registerRender(SHOUJI_DOAK);
		registerRender(SHOUJIA);
		registerRender(SHOUJIA_SPRU);
		registerRender(SHOUJIA_BIR);
		registerRender(SHOUJIA_JUN);
		registerRender(SHOUJIA_ACA);
		registerRender(SHOUJIA_DOAK);

		registerRender(SHOUJIH);
		registerRender(SHOUJIH_SPRU);
		registerRender(SHOUJIH_BIR);
		registerRender(SHOUJIH_JUN);
		registerRender(SHOUJIH_ACA);
		registerRender(SHOUJIH_DOAK);

		registerRender(SHOUJIWIN_oak);
		registerRender(SHOUJIWIN_spruce );
		registerRender(SHOUJIWIN_birch );
		registerRender(SHOUJIWIN_jungle);
		registerRender(SHOUJIWIN_acacia);
		registerRender(SHOUJIWIN_darkoak);

		registerRender(RANMA_oak);
		registerRender(RANMA_spru);
		registerRender(RANMA_bir);
		registerRender(RANMA_jun);
		registerRender(RANMA_aca);
		registerRender(RANMA_doak);

		registerRender(RANMAB_oak);
		registerRender(RANMAB_spru);
		registerRender(RANMAB_bir);
		registerRender(RANMAB_jun);
		registerRender(RANMAB_aca);
		registerRender(RANMAB_doak);

		registerRender(RANMAC_oak);
		registerRender(RANMAC_spru);
		registerRender(RANMAC_bir);
		registerRender(RANMAC_jun);
		registerRender(RANMAC_aca);
		registerRender(RANMAC_doak);

		registerRender(KANKI_oak);
		registerRender(KANKI_spru);
		registerRender(KANKI_bir);
		registerRender(KANKI_jun);
		registerRender(KANKI_aca);
		registerRender(KANKI_doak);

		registerRender(KOUSHI_oak);
		registerRender(KOUSHI_spru);
		registerRender(KOUSHI_bir);
		registerRender(KOUSHI_jun);
		registerRender(KOUSHI_aca);
		registerRender(KOUSHI_doak);

		registerRender(KOUSHIB_oak);
		registerRender(KOUSHIB_spru);
		registerRender(KOUSHIB_bir);
		registerRender(KOUSHIB_jun);
		registerRender(KOUSHIB_aca);
		registerRender(KOUSHIB_doak);

		registerRender(FUSUMA_white);
		registerRender(FUSUMA_orange);
		registerRender(FUSUMA_magenta);
		registerRender(FUSUMA_lightblue);
		registerRender(FUSUMA_yellow);
		registerRender(FUSUMA_lime);
		registerRender(FUSUMA_pink);
		registerRender(FUSUMA_gray);
		registerRender(FUSUMA_lightgray);
		registerRender(FUSUMA_cyan);
		registerRender(FUSUMA_purple);
		registerRender(FUSUMA_blue);
		registerRender(FUSUMA_brown);
		registerRender(FUSUMA_green);
		registerRender(FUSUMA_red);
		registerRender(FUSUMA_black);

		registerRender(FUSUMAB_white);
		registerRender(FUSUMAB_orange);
		registerRender(FUSUMAB_magenta);
		registerRender(FUSUMAB_lightblue);
		registerRender(FUSUMAB_yellow);
		registerRender(FUSUMAB_lime);
		registerRender(FUSUMAB_pink);
		registerRender(FUSUMAB_gray);
		registerRender(FUSUMAB_lightgray);
		registerRender(FUSUMAB_cyan);
		registerRender(FUSUMAB_purple);
		registerRender(FUSUMAB_blue);
		registerRender(FUSUMAB_brown);
		registerRender(FUSUMAB_green);
		registerRender(FUSUMAB_red);
		registerRender(FUSUMAB_black);

		registerRender(SUDARE);

		registerRender(NOREN_white);
		registerRender(NOREN_orange);
		registerRender(NOREN_magenta);
		registerRender(NOREN_lightb);
		registerRender(NOREN_yellow);
		registerRender(NOREN_lime);
		registerRender(NOREN_pink);
		registerRender(NOREN_gray);
		registerRender(NOREN_lightg);
		registerRender(NOREN_cyan);
		registerRender(NOREN_purple);
		registerRender(NOREN_blue);
		registerRender(NOREN_brown);
		registerRender(NOREN_green);
		registerRender(NOREN_red);
		registerRender(NOREN_black);

		registerRender(WARAZABUTON);
		registerRenderMeta(ZABUTON, 0, "block_mzabuton_white");
		registerRenderMeta(ZABUTON, 1, "block_mzabuton_orange");
		registerRenderMeta(ZABUTON, 2, "block_mzabuton_magenta");
		registerRenderMeta(ZABUTON, 3, "block_mzabuton_lightb");
		registerRenderMeta(ZABUTON, 4, "block_mzabuton_yellow");
		registerRenderMeta(ZABUTON, 5, "block_mzabuton_lime");
		registerRenderMeta(ZABUTON, 6, "block_mzabuton_pink");
		registerRenderMeta(ZABUTON, 7, "block_mzabuton_gray");
		registerRenderMeta(ZABUTON, 8, "block_mzabuton_lightg");
		registerRenderMeta(ZABUTON, 9, "block_mzabuton_cyan");
		registerRenderMeta(ZABUTON, 10, "block_mzabuton_purple");
		registerRenderMeta(ZABUTON, 11, "block_mzabuton_blue");
		registerRenderMeta(ZABUTON, 12, "block_mzabuton_brown");
		registerRenderMeta(ZABUTON, 13, "block_mzabuton_green");
		registerRenderMeta(ZABUTON, 14, "block_mzabuton_red");
		registerRenderMeta(ZABUTON, 15, "block_mzabuton_black");

		registerRender(ZAISU_white);
		registerRender(ZAISU_orange);
		registerRender(ZAISU_magenta);
		registerRender(ZAISU_lightb);
		registerRender(ZAISU_yellow);
		registerRender(ZAISU_lime);
		registerRender(ZAISU_pink);
		registerRender(ZAISU_gray);
		registerRender(ZAISU_lightg);
		registerRender(ZAISU_cyan);
		registerRender(ZAISU_purple);
		registerRender(ZAISU_blue);
		registerRender(ZAISU_brown);
		registerRender(ZAISU_green);
		registerRender(ZAISU_red);
		registerRender(ZAISU_black);

		registerRender(TATAMI_H);
		registerRender(TATAMI_H_white);
		registerRender(TATAMI_H_orange);
		registerRender(TATAMI_H_magenta);
		registerRender(TATAMI_H_lightb);
		registerRender(TATAMI_H_yellow);
		registerRender(TATAMI_H_lime);
		registerRender(TATAMI_H_pink);
		registerRender(TATAMI_H_gray);
		registerRender(TATAMI_H_lightg);
		registerRender(TATAMI_H_cyan);
		registerRender(TATAMI_H_purple);
		registerRender(TATAMI_H_blue);
		registerRender(TATAMI_H_brown);
		registerRender(TATAMI_H_green);
		registerRender(TATAMI_H_red);
		registerRender(TATAMI_H_black);

		registerRender(TATAMI_HY);
		registerRender(TATAMI_HY_white);
		registerRender(TATAMI_HY_orange);
		registerRender(TATAMI_HY_magenta);
		registerRender(TATAMI_HY_lightb);
		registerRender(TATAMI_HY_yellow);
		registerRender(TATAMI_HY_lime);
		registerRender(TATAMI_HY_pink);
		registerRender(TATAMI_HY_gray);
		registerRender(TATAMI_HY_lightg);
		registerRender(TATAMI_HY_cyan);
		registerRender(TATAMI_HY_purple);
		registerRender(TATAMI_HY_blue);
		registerRender(TATAMI_HY_brown);
		registerRender(TATAMI_HY_green);
		registerRender(TATAMI_HY_red);
		registerRender(TATAMI_HY_black);

		registerRender(TAKECUBE);
		registerRender(TAKECUBE_Y);
		registerRender(TAKECUBE_K);
		registerRender(TAKE_SH);
		registerRender(TAKE_SHY);
		registerRender(TAKE_SHK);
		registerRender(TAKE_ST);
		registerRender(TAKE_STY);
		registerRender(TAKE_STK);

		registerRender(TAKEFENCE);
		registerRender(TAKEFENCE_Y);
		registerRender(TAKEFENCE_K);

		registerRender(TAKEFENCEGATE);
		registerRender(TAKEFENCEGATE_Y);
		registerRender(TAKEFENCEGATE_K);
		registerRender(TAKEDOOR);
		registerRender(TAKEDOOR_Y);
		registerRender(TAKEDOOR_K);

		registerRender(TAKE_TRAPDOOR);
		registerRender(TAKE_TRAPDOOR_Y);
		registerRender(TAKE_TRAPDOOR_K);
		registerRender(TAKE_PLATE);
		registerRender(TAKE_PLATE_Y);
		registerRender(TAKE_PLATE_K);
		registerRender(TAKE_BUTTON);
		registerRender(TAKE_BUTTON_Y);
		registerRender(TAKE_BUTTON_K);

		registerRender(FUTON_white);
		registerRender(FUTON_orange);
		registerRender(FUTON_magenta);
		registerRender(FUTON_lightb);
		registerRender(FUTON_yellow);
		registerRender(FUTON_lime);
		registerRender(FUTON_pink);
		registerRender(FUTON_gray);
		registerRender(FUTON_lightg);
		registerRender(FUTON_cyan);
		registerRender(FUTON_purple);
		registerRender(FUTON_blue);
		registerRender(FUTON_brown);
		registerRender(FUTON_green);
		registerRender(FUTON_red);
		registerRender(FUTON_black);

		registerRenderMeta(ANDON_1, 1, "block_andon_white");
		registerRenderMeta(ANDON_1, 2, "block_andon_orange");
		registerRenderMeta(ANDON_1, 3, "block_andon_magenta");
		registerRenderMeta(ANDON_1, 4, "block_andon_lightb");
		registerRenderMeta(ANDON_2, 1, "block_andon_yellow");
		registerRenderMeta(ANDON_2, 2, "block_andon_lime");
		registerRenderMeta(ANDON_2, 3, "block_andon_pink");
		registerRenderMeta(ANDON_2, 4, "block_andon_gray");
		registerRenderMeta(ANDON_3, 1, "block_andon_lightg");
		registerRenderMeta(ANDON_3, 2, "block_andon_cyan");
		registerRenderMeta(ANDON_3, 3, "block_andon_purple");
		registerRenderMeta(ANDON_3, 4, "block_andon_blue");
		registerRenderMeta(ANDON_4, 1, "block_andon_brown");
		registerRenderMeta(ANDON_4, 2, "block_andon_green");
		registerRenderMeta(ANDON_4, 3, "block_andon_red");
		registerRenderMeta(ANDON_4, 4, "block_andon_black");

		registerRender(KASA_white);
		registerRender(KASA_orange);
		registerRender(KASA_magenta);
		registerRender(KASA_lightb);
		registerRender(KASA_yellow);
		registerRender(KASA_lime);
		registerRender(KASA_pink);
		registerRender(KASA_gray);
		registerRender(KASA_lightg);
		registerRender(KASA_cyan);
		registerRender(KASA_purple);
		registerRender(KASA_blue);
		registerRender(KASA_brown);
		registerRender(KASA_green);
		registerRender(KASA_red);
		registerRender(KASA_black);

		registerRender(TOBUKUROS_WINR);
		registerRender(TOBUKUROS_BOTR);
		registerRender(TOBUKURO_WINR);
		registerRender(TOBUKURO_BOTR);

		registerRender(BONSAI_oak);
		registerRender(BONSAI_spru);
		registerRender(BONSAI_bir);
		registerRender(BONSAI_jun);
		registerRender(BONSAI_aca);
		registerRender(BONSAI_doak);

		registerRenderMeta(KANYOU_BOT, 0, "block_kanyouoak_bot");
		registerRenderMeta(KANYOU_BOT, 1, "block_kanyouspruce_bot");
		registerRenderMeta(KANYOU_BOT, 2, "block_kanyoubirch_bot");
		registerRenderMeta(KANYOU_BOT, 3, "block_kanyoujungle_bot");
		registerRenderMeta(KANYOU_BOT, 4, "block_kanyouacacia_bot");
		registerRenderMeta(KANYOU_BOT, 5, "block_kanyoudarkoak_bot");
		registerRenderMeta(IKEGAKI, 0, "block_low_oak");
		registerRenderMeta(IKEGAKI, 1, "block_low_spruce");
		registerRenderMeta(IKEGAKI, 2, "block_low_birch");
		registerRenderMeta(IKEGAKI, 3, "block_low_jungle");
		registerRenderMeta(IKEGAKI, 4, "block_low_acacia");
		registerRenderMeta(IKEGAKI, 5, "block_low_darkoak");
		registerRenderMeta(IKEGAKILONG_BOT, 0, "block_longoak_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 1, "block_longspruce_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 2, "block_longbirch_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 3, "block_longjungle_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 4, "block_longacacia_bot");
		registerRenderMeta(IKEGAKILONG_BOT, 5, "block_longdarkoak_bot");

		registerRender(SHISHIODOSHI);
		registerRenderMeta(CHOUZUBACHI, 0, "block_chouzubachi_kara");
		registerRenderMeta(CHOUZUBACHI, 1, "block_chouzu_gra_kara");
		registerRenderMeta(CHOUZUBACHI, 2, "block_chouzu_dio_kara");
		registerRenderMeta(CHOUZUBACHI, 3, "block_chouzu_and_kara");
		registerRenderMeta(ISHITOUROU, 1, "block_ishitourou_stone");
		registerRenderMeta(ISHITOUROU, 2, "block_ishitourou_gra");
		registerRenderMeta(ISHITOUROU, 3, "block_ishitourou_dio");
		registerRenderMeta(ISHITOUROU, 4, "block_ishitourou_and");
		registerRenderMeta(LONGTOUROU, 1, "block_longtourou_stone");
		registerRenderMeta(LONGTOUROU, 2, "block_longtourou_gra");
		registerRenderMeta(LONGTOUROU, 3, "block_longtourou_dio");
		registerRenderMeta(LONGTOUROU, 4, "block_longtourou_and");

		registerRender(TAKEAKARI);

		registerRender(WADAIKO);
		registerRender(WADAIKO_small);

		registerRenderMeta(ENDAI, 0, "block_mendai");
		registerRenderMeta(ENDAI, 1, "block_mendai_red");

		registerRender(GATE_SPRUCE);
		registerRender(GATE_SPRUCE_B);
		registerRender(GATE_IRON);
		registerRender(GATE_IRONGRILL);
		registerRender(TETSUSAKU_BOT);

		registerRender(HAKE);
		registerRender(HAKE_white);
		registerRender(HAKE_orange);
		registerRender(HAKE_magenta);
		registerRender(HAKE_lightb);
		registerRender(HAKE_yellow);
		registerRender(HAKE_lime);
		registerRender(HAKE_pink);
		registerRender(HAKE_gray);
		registerRender(HAKE_lightg);
		registerRender(HAKE_cyan);
		registerRender(HAKE_purple);
		registerRender(HAKE_blue);
		registerRender(HAKE_brown);
		registerRender(HAKE_green);
		registerRender(HAKE_red);
		registerRender(HAKE_black);

		registerRender(KUMADE);
		registerRender(NOMI);
		registerRender(MAKIBISHI);
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

	private static void registerRenderMeta(Item item, int meta, String fileName) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(new ResourceLocation(ChinjufuMod.MOD_ID, fileName), "inventory"));
	}

}
