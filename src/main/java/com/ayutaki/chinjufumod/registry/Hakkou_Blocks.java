package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.hakkou.Bot_Dashi;
import com.ayutaki.chinjufumod.blocks.hakkou.Bot_Koubo;
import com.ayutaki.chinjufumod.blocks.hakkou.Bot_Nyusan;
import com.ayutaki.chinjufumod.blocks.hakkou.Bot_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Cider;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_CiderJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_MeadJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_SakeNama;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Bottle_WineJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese;
import com.ayutaki.chinjufumod.blocks.hakkou.Cheese_Curd;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Amazake;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Cider;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_CiderJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Mead;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_MeadJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Sake;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_SakeJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_SakeNama;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_Wine;
import com.ayutaki.chinjufumod.blocks.hakkou.Glass_WineJuku;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke_full;
import com.ayutaki.chinjufumod.blocks.hakkou.NabeAmazake;
import com.ayutaki.chinjufumod.blocks.hakkou.NabeAmazake_nama;
import com.ayutaki.chinjufumod.blocks.hakkou.Tana_Kinoko;
import com.ayutaki.chinjufumod.blocks.hakkou.Tana_Konbu;
import com.ayutaki.chinjufumod.blocks.hakkou.Tana_Koucha;
import com.ayutaki.chinjufumod.blocks.hakkou.Tana_Kouji;
import com.ayutaki.chinjufumod.blocks.hakkou.Tana_Nori;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruF_Hakusai1;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruF_Hakusai2;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruF_Komezu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruF_Shouyu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Budoushu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Cocoa;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Hachimitsu;
import com.ayutaki.chinjufumod.blocks.hakkou.TaruY_Ringoshu;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Hakkou;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Jukusei;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Miso;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Moromi;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_Shubo;
import com.ayutaki.chinjufumod.blocks.hakkou.Zundou_ColdMilk;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Hakkou_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block KOUBOBOT_full = register("block_bin_koubo_f", new Bot_Koubo(AbstractBlock.Properties.of(Material.STONE).noCollission().randomTicks().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block NYUSANBOT_full = register("block_bin_nyusan_f", new Bot_Nyusan(AbstractBlock.Properties.of(Material.STONE).noCollission().randomTicks().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block MIZUOKE = register("block_mizuoke", new Mizuoke(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block MIZUOKE_full = register("block_mizuoke_full", new Mizuoke_full(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	/* Barrel */
	public static Block HAKKOU_TARU = register("block_taru_hakkou", new Taru_Hakkou(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block KOUJI_TARU = register("block_taru_kouji_f", new Tana_Kouji(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SHUBO_TARU = register("block_taru_shubo_f", new Taru_Shubo(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block MOROMI_TARU = register("block_taru_moromi_f", new Taru_Moromi(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block JUKUSEI_TARU = register("block_taru_jukusei_f", new Taru_Jukusei(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));

	public static Block RINGOSHU_TARU = register("block_taru_ringoshu_f", new TaruY_Ringoshu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block BUDOUSHU_TARU = register("block_taru_budoushu_f", new TaruY_Budoushu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block HACHIMITSU_TARU = register("block_taru_hachimitsushu_f", new TaruY_Hachimitsu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block COCOA_TARU = register("block_taru_cocoa_f", new TaruY_Cocoa(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));

	/* Bottle */
	public static Block NAMASAKEBOT = register("block_bot_sakenama_1", new Bottle_SakeNama(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SAKEBOT = register("block_bot_sake_1", new Bottle_Sake(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUSAKEBOT = register("block_bot_sakejuku_1", new Bottle_SakeJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block NABEAMAZAKE_nama = register("block_food_nabeaz_n", new NabeAmazake_nama(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block NABEAMAZAKE = register("block_food_nabeaz_1", new NabeAmazake(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block CIDERBOT = register("block_bot_cider_1", new Bottle_Cider(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUCIDERBOT = register("block_bot_ciderjuku_1", new Bottle_CiderJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block WINEBOT = register("block_bot_wine_1", new Bottle_Wine(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUWINEBOT = register("block_bot_winejuku_1", new Bottle_WineJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block MEADBOT = register("block_bot_mead_1", new Bottle_Mead(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUMEADBOT = register("block_bot_meadjuku_1", new Bottle_MeadJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	/* Glass */
	public static Block NAMASAKEGLASS = register("block_glass_sakenama", new Glass_SakeNama(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SAKEGLASS = register("block_glass_sake", new Glass_Sake(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUSAKEGLASS = register("block_glass_sakejuku", new Glass_SakeJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block AMAZAKEGLASS = register("block_glass_amazake", new Glass_Amazake(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block CIDERGLASS = register("block_glass_cider", new Glass_Cider(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUCIDERGLASS = register("block_glass_ciderjuku", new Glass_CiderJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block WINEGLASS = register("block_glass_wine", new Glass_Wine(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUWINEGLASS = register("block_glass_winejuku", new Glass_WineJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block MEADGLASS = register("block_glass_mead", new Glass_Mead(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block JUKUMEADGLASS = register("block_glass_meadjuku", new Glass_MeadJuku(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block MISO_TARU = register("block_taru_miso_f", new Taru_Miso(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block HAKUSAI_TARU1 = register("block_taru_hakusai_f", new TaruF_Hakusai1(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block HAKUSAI_TARU2 = register("block_taru_hakusai_f2", new TaruF_Hakusai2(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block SHOUYU_TARU = register("block_taru_shouyu_f", new TaruF_Shouyu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block KOMEZU_TARU = register("block_taru_komezu_f", new TaruF_Komezu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity)));
	public static Block KINOKO_TARU = register("block_taru_kinoko_f", new Tana_Kinoko(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block KONBU_TARU = register("block_taru_konbu_f", new Tana_Konbu(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block NORI_TARU = register("block_taru_nori_f", new Tana_Nori(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block KOUCHA_TARU = register("block_taru_koucha_f", new Tana_Koucha(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(1.0F, 4.2F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block SHOUYU_bot_1 = register("block_shouyu_bot", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SHOUYU_bot_2 = register("block_shouyu_bot_2", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SHOUYU_bot_3 = register("block_shouyu_bot_3", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block SHOUYU_bot_4 = register("block_shouyu_bot_4", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block KOMEZU_bot_1 = register("block_komezu_bot", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block KOMEZU_bot_2 = register("block_komezu_bot_2", new Bot_Shouyu(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block DASHI_bot_1 = register("block_dashi_bot", new Bot_Dashi(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block DASHI_bot_2 = register("block_dashi_bot_2", new Bot_Dashi(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block DASHI_bot_3 = register("block_dashi_bot_3", new Bot_Dashi(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block DASHI_bot_4 = register("block_dashi_bot_4", new Bot_Dashi(AbstractBlock.Properties.of(Material.STONE).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	public static Block COLD_MILK = register("block_zundou_coldmilk", new Zundou_ColdMilk(AbstractBlock.Properties.of(Material.METAL).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block CHEESE_CURD = register("block_food_cheesecurd", new Cheese_Curd(AbstractBlock.Properties.of(Material.WOOD).noCollission().randomTicks().strength(1.0F, 1.0F).sound(SoundType.SNOW)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));
	public static Block CHEESE = register("block_food_cheese_1", new Cheese(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Hakkou_Blocks::neverEntity).isSuffocating(Hakkou_Blocks::never)));

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
