package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Mikan;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Scone;
import com.ayutaki.chinjufumod.blocks.dish.Chauke_Senbei;
import com.ayutaki.chinjufumod.blocks.dish.Chicken;
import com.ayutaki.chinjufumod.blocks.dish.Chicken_small;
import com.ayutaki.chinjufumod.blocks.dish.Corn_Soup;
import com.ayutaki.chinjufumod.blocks.dish.Curry;
import com.ayutaki.chinjufumod.blocks.dish.Curry_set;
import com.ayutaki.chinjufumod.blocks.dish.Donburi;
import com.ayutaki.chinjufumod.blocks.dish.EggBurg;
import com.ayutaki.chinjufumod.blocks.dish.EggBurg_set;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_DonGyu;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_DonKatsu;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_DonOyako;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_EggBurg;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Katsu;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_KinokoAK;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_PastaKinoko;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_PastaTomato;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_Tamago;
import com.ayutaki.chinjufumod.blocks.dish.Frypan_kara;
import com.ayutaki.chinjufumod.blocks.dish.Gohan;
import com.ayutaki.chinjufumod.blocks.dish.Hakusai_Duke;
import com.ayutaki.chinjufumod.blocks.dish.IceCream;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_C;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_E2;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R1;
import com.ayutaki.chinjufumod.blocks.dish.Irori_Sakana_R2;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaCup;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaKyusu;
import com.ayutaki.chinjufumod.blocks.dish.JPTea_Set;
import com.ayutaki.chinjufumod.blocks.dish.KeiryoCup;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_kara;
import com.ayutaki.chinjufumod.blocks.dish.Miso_Soup;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_Nimame;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_Shio;
import com.ayutaki.chinjufumod.blocks.dish.Nabe2_Toufu;
import com.ayutaki.chinjufumod.blocks.dish.NabeCorn;
import com.ayutaki.chinjufumod.blocks.dish.NabeCorn_nama;
import com.ayutaki.chinjufumod.blocks.dish.NabeGohan;
import com.ayutaki.chinjufumod.blocks.dish.NabeGohan_nama;
import com.ayutaki.chinjufumod.blocks.dish.NabeMiso;
import com.ayutaki.chinjufumod.blocks.dish.NabeMiso_nama;
import com.ayutaki.chinjufumod.blocks.dish.NabeTori;
import com.ayutaki.chinjufumod.blocks.dish.NabeTori_nama;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.blocks.dish.Niboshi;
import com.ayutaki.chinjufumod.blocks.dish.Pasta;
import com.ayutaki.chinjufumod.blocks.dish.Pizza;
import com.ayutaki.chinjufumod.blocks.dish.RiceDish;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_1;
import com.ayutaki.chinjufumod.blocks.dish.SconeSet_kara;
import com.ayutaki.chinjufumod.blocks.dish.ShouyuSara_1;
import com.ayutaki.chinjufumod.blocks.dish.Stew;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Beef;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Fish;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Salmon;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_Tamago;
import com.ayutaki.chinjufumod.blocks.dish.SushiGeta_kara1_5;
import com.ayutaki.chinjufumod.blocks.dish.SushiMeshi;
import com.ayutaki.chinjufumod.blocks.dish.SushiOke;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_1;
import com.ayutaki.chinjufumod.blocks.dish.SushiOkeFull_9;
import com.ayutaki.chinjufumod.blocks.dish.SushiSet;
import com.ayutaki.chinjufumod.blocks.dish.Tamagoyaki;
import com.ayutaki.chinjufumod.blocks.dish.Tamagoyaki_set;
import com.ayutaki.chinjufumod.blocks.dish.TeaCup;
import com.ayutaki.chinjufumod.blocks.dish.TeaPot;
import com.ayutaki.chinjufumod.blocks.dish.Tea_Set;
import com.ayutaki.chinjufumod.blocks.dish.Tonsui;
import com.ayutaki.chinjufumod.blocks.dish.Udon;
import com.ayutaki.chinjufumod.blocks.dish.YakiJyake_set;
import com.ayutaki.chinjufumod.blocks.dish.YakiZakana_set;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Curry;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Dashi;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Fish;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Oriito;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Pasta;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Stew;
import com.ayutaki.chinjufumod.blocks.dish.Zundou4_Udon;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Aku;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Milk;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Mizu;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_NamaCurry;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_NamaStew;
import com.ayutaki.chinjufumod.blocks.dish.Zundou_Shio;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Dish_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block ZUNDOU = register("block_food_zundou", new Zundou(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_MIZU = register("block_zundou_mizu", new Zundou_Mizu(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_SHIO = register("block_zundou_shiomizu", new Zundou_Shio(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_MILK = register("block_zundou_milk", new Zundou_Milk(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block ZUNDOU_NCURRY = register("block_food_cunabe_n", new Zundou_NamaCurry(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_CURRY = register("block_food_cunabe_1", new Zundou4_Curry(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block ZUNDOU_NSTEW = register("block_food_stewnabe_n", new Zundou_NamaStew(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_STEW = register("block_food_stewnabe_1", new Zundou4_Stew(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block ZUNDOU_FISH = register("block_zundou_fish", new Zundou4_Fish(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_DASHI = register("block_food_dashinabe_1", new Zundou4_Dashi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_UDON = register("block_zundou_udon", new Zundou4_Udon(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_PASTA = register("block_zundou_pasta", new Zundou4_Pasta(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block ZUNDOU_AKU = register("block_zundou_aku", new Zundou_Aku(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block ZUNDOU_ORIITO = register("block_zundou_oriito", new Zundou4_Oriito(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block NABE_kara = register("block_food_karanabe", new Nabe_kara(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABETORI_nama = register("block_food_nabe_n", new NabeTori_nama(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABEMISO_nama = register("block_food_nabemiso_n", new NabeMiso_nama(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABEGOHAN_nama = register("block_food_nabegohan_n", new NabeGohan_nama(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABECORN_nama = register("block_food_nabecorns_n", new NabeCorn_nama(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABESHIO_nama = register("block_food_nabeshio_n", new Nabe2_Shio(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABENIMAME_nama = register("block_food_nabenimame_n", new Nabe2_Nimame(Block.Properties.create(Material.WOOD)
			.doesNotBlockMovement().hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABETOUFU_nama = register("block_food_nabetoufu_n", new Nabe2_Toufu(Block.Properties.create(Material.WOOD)
			.doesNotBlockMovement().hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block NABETORI = register("block_food_nabe_1", new NabeTori(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABEMISO = register("block_food_nabemiso_1", new NabeMiso(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABEGOHAN = register("block_food_nabegohan_1", new NabeGohan(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block NABECORN = register("block_food_nabecorns_1", new NabeCorn(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block KEIRYO_CUP = register("block_measurecup", new KeiryoCup(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid()));

	public static Block FRYPAN_kara = register("block_food_frypan", new Frypan_kara(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPTAMAGO_nama = register("block_food_frypan_n_tamago", new Frypan_Tamago(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPGYUDON_nama = register("block_food_frypan_n_gyudon", new Frypan_DonGyu(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPOYAKODON_nama = register("block_food_frypan_n_oyakodon", new Frypan_DonOyako(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPKATSU_nama = register("block_food_frypan_n_katsu", new Frypan_Katsu(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPKATSUDON_nama = register("block_food_frypan_n_katsudon", new Frypan_DonKatsu(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPEGGBURG_nama = register("block_food_frypan_n_eggb", new Frypan_EggBurg(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPTOMATO_nama = register("block_food_frypan_n_tomatos", new Frypan_PastaTomato(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPKINOKO_nama = register("block_food_frypan_n_kinokos", new Frypan_PastaKinoko(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block FPKINOKOAK_nama = register("block_food_frypan_n_kinokoak", new Frypan_KinokoAK(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block NIBOSHI = register("block_niboshi", new Niboshi(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.SNOW).notSolid()));

	public static Block CURRY = register("block_food_curry_1", new Curry(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block CURRYSET = register("block_food_curryset_1", new Curry_set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block STEW = register("block_food_stew_1", new Stew(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block UDON_SU = register("block_food_udonsu_1", new Udon(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block UDON_NIKU = register("block_food_udonniku_1", new Udon(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block UDON_TSUKIMI = register("block_food_udontsukimi_1", new Udon(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block TONSUITORI = register("block_food_tonsui_1", new Tonsui(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block MISOSOUP = register("block_food_misosp_1", new Miso_Soup(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block GOHAN = register("block_food_gohan_1", new Gohan(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block RICE = register("block_food_rice_1", new RiceDish(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block DONBURI_MESHI = register("block_food_donmeshi_1", new Donburi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block DONBURI_GYU = register("block_food_dongyu_1", new Donburi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block DONBURI_OYAKO = register("block_food_donoyako_1", new Donburi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block DONBURI_KATSU = register("block_food_donkatsu_1", new Donburi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block DONBURI_KAISEN = register("block_food_donkaisen_1", new Donburi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	
	public static Block HAKUSAIDUKE = register("block_food_hsd_1", new Hakusai_Duke(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block TAMAGOYAKI = register("block_food_tgy_1", new Tamagoyaki(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block TAMAGOYAKITEI = register("block_food_tgytei_1", new Tamagoyaki_set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block YAKIZAKANATEI = register("block_food_yakizakanatei_1", new YakiZakana_set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block YAKIJYAKETEI = register("block_food_yakijyaketei_1", new YakiJyake_set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block CORNSOUP = register("block_food_cornsp_1", new Corn_Soup(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block EGGBURG = register("block_food_egb_1", new EggBurg(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block EGGBURGSET = register("block_food_egbset_1", new EggBurg_set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block PASTATOMATO = register("block_food_pastatoma_1", new Pasta(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block PASTACHEESE = register("block_food_pastacheese_1", new Pasta(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block PASTAKINOKO = register("block_food_pastakinoko_1", new Pasta(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block PIZZA = register("block_food_pizza_1", new Pizza(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block CHICKEN = register("block_food_roastchicken_1", new Chicken(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block CHICKEN_small = register("block_food_chickenb_1", new Chicken_small(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block SUSHIMESHI = register("block_food_sushimeshi", new SushiMeshi(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIGETA_kara = register("block_food_sushigeta_kara", new SushiGeta_kara1_5(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIGETA_salmon = register("block_food_sushigeta_salmon", new SushiGeta_Salmon(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIGETA_fish = register("block_food_sushigeta_fish", new SushiGeta_Fish(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIGETA_beef = register("block_food_sushigeta_beef", new SushiGeta_Beef(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIGETA_tamago = register("block_food_sushigeta_tamago", new SushiGeta_Tamago(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block SUSHISET_salmon = register("block_food_sushiset_salmon", new SushiSet(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHISET_fish = register("block_food_sushiset_fish", new SushiSet(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHISET_beef = register("block_food_sushiset_beef", new SushiSet(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHISET_tamago = register("block_food_sushiset_tamago", new SushiSet(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHISET_4shoku = register("block_food_sushiset_4shoku", new SushiSet(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block SUSHIOKE = register("block_food_sushioke_kara", new SushiOke(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block SUSHIOKE_FULL_1 = register("block_food_sushiokefull_1", new SushiOkeFull_1(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block SUSHIOKE_FULL_9 = register("block_food_sushiokefull_9", new SushiOkeFull_9(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block SHOUYUSARA_1 = register("block_food_shouyusara_1", new ShouyuSara_1(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block KETTLE_kara = register("item_kettle_kara", new Kettle_kara(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block KETTLE_full = register("block_kettle_full", new Kettle_full(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block KYUSU = register("block_food_kyusu_1", new JPTeaKyusu(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block JPTEACUP = register("block_food_jpteacup_1", new JPTeaCup(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid()));
	public static Block JPTEASET = register("block_food_jpteaset_1", new JPTea_Set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block CHAUKE_SENBEI = register("block_food_senbei", new Chauke_Senbei(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));
	public static Block CHAUKE_MIKAN = register("block_food_mikan", new Chauke_Mikan(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid()));

	public static Block TEAPOT = register("block_food_teapot_1", new TeaPot(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block TEACUP = register("block_food_teacup_1", new TeaCup(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid()));
	public static Block TEASET = register("block_food_teaset_1", new Tea_Set(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));
	public static Block CHAUKE_SCONE = register("block_food_scone", new Chauke_Scone(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.STONE).notSolid()));

	public static Block SCONESET_kara = register("block_food_teastand", new SconeSet_kara(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));
	public static Block SCONESET_1 = register("block_food_sconeset_1", new SconeSet_1(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL).notSolid()));

	public static Block ICECREAM = register("block_food_icecream_1", new IceCream(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid()));

	public static Block IRORISAKANA_E1 = register("block_irori_sakana_e1", new Irori_Sakana_E1(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));
	public static Block IRORISAKANA_E2 = register("block_irori_sakana_e2", new Irori_Sakana_E2(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));
	public static Block IRORISAKANA_R1 = register("block_irori_sakana_r1", new Irori_Sakana_R1(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));
	public static Block IRORISAKANA_R2 = register("block_irori_sakana_r2", new Irori_Sakana_R2(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));
	public static Block IRORISAKANA_C = register("block_irori_sakana_c", new Irori_Sakana_C(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F).sound(SoundType.SNOW).notSolid()));

	/* Share variables */

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
