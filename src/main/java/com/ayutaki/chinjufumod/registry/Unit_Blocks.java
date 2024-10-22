package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.unitblock.CafeTable;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Endai;
import com.ayutaki.chinjufumod.blocks.unitblock.TrayFude;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.TrayLetter;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.UnitDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenBook;
import com.ayutaki.chinjufumod.blocks.unitblock.WrittenMakimono;

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
public class Unit_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block UNITDESK = register("block_unitdesk", unitDesk());
	public static Block UNITDESK_spruce = register("block_unitdesk_spruce", unitDesk());
	public static Block UNITDESK_birch = register("block_unitdesk_birch", unitDesk());
	public static Block UNITDESK_jungle = register("block_unitdesk_jungle", unitDesk());
	public static Block UNITDESK_acacia = register("block_unitdesk_acacia", unitDesk());
	public static Block UNITDESK_darkoak = register("block_unitdesk_darkoak", unitDesk());
	public static Block UNITDESK_sakura = register("block_unitdesk_sakura", unitDesk());
	public static Block UNITDESK_kaede = register("block_unitdesk_kaede", unitDesk());
	public static Block UNITDESK_ichoh = register("block_unitdesk_ichoh", unitDesk());

	public static Block CAFETABLE = register("block_cafetable", cafeTable());
	public static Block CAFETABLE_spruce = register("block_cafetable_spruce", cafeTable());
	public static Block CAFETABLE_birch = register("block_cafetable_birch", cafeTable());
	public static Block CAFETABLE_jungle = register("block_cafetable_jungle", cafeTable());
	public static Block CAFETABLE_acacia = register("block_cafetable_acacia", cafeTable());
	public static Block CAFETABLE_darkoak = register("block_cafetable_darkoak", cafeTable());
	public static Block CAFETABLE_sakura = register("block_cafetable_sakura", cafeTable());
	public static Block CAFETABLE_kaede = register("block_cafetable_kaede", cafeTable());
	public static Block CAFETABLE_ichoh = register("block_cafetable_ichoh", cafeTable());

	public static Block ENDAI = register("block_mendai", endai());
	public static Block ENDAI_r = register("block_mendai_red", endai());
	public static Block TEATABLE = register("block_teatable", cafeTable());

	public static Block LOWDESK = register("block_lowdesk", lowDesk());
	public static Block LOWDESK_spruce = register("block_lowdesk_spruce", lowDesk());
	public static Block LOWDESK_birch = register("block_lowdesk_birch", lowDesk());
	public static Block LOWDESK_jungle = register("block_lowdesk_jungle", lowDesk());
	public static Block LOWDESK_acacia = register("block_lowdesk_acacia", lowDesk());
	public static Block LOWDESK_darkoak = register("block_lowdesk_darkoak", lowDesk());
	public static Block LOWDESK_sakura = register("block_lowdesk_sakura", lowDesk());
	public static Block LOWDESK_kaede = register("block_lowdesk_kaede", lowDesk());
	public static Block LOWDESK_ichoh = register("block_lowdesk_ichoh", lowDesk());

	public static Block LETTERTRAY = register("block_lettertray_c", letterTray());
	public static Block FUDETRAY = register("block_fudetray_c", fudeTray());

	public static Block CHABUDAI = register("block_chabudai", chabudai());
	public static Block CHABUDAI_spruce = register("block_chabudai_spruce", chabudai());
	public static Block CHABUDAI_birch = register("block_chabudai_birch", chabudai());
	public static Block CHABUDAI_jungle = register("block_chabudai_jungle", chabudai());
	public static Block CHABUDAI_acacia = register("block_chabudai_acacia", chabudai());
	public static Block CHABUDAI_darkoak = register("block_chabudai_darkoak", chabudai());
	public static Block CHABUDAI_sakura = register("block_chabudai_sakura", chabudai());
	public static Block CHABUDAI_kaede = register("block_chabudai_kaede", chabudai());
	public static Block CHABUDAI_ichoh = register("block_chabudai_ichoh", chabudai());

	public static Block KOTATSU = register("block_kotatsu", kotatsu());
	public static Block KOTATSU_spruce = register("block_kotatsu_spruce", kotatsu());
	public static Block KOTATSU_birch = register("block_kotatsu_birch", kotatsu());
	public static Block KOTATSU_jungle = register("block_kotatsu_jungle", kotatsu());
	public static Block KOTATSU_acacia = register("block_kotatsu_acacia", kotatsu());
	public static Block KOTATSU_darkoak = register("block_kotatsu_darkoak", kotatsu());
	public static Block KOTATSU_sakura = register("block_kotatsu_sakura", kotatsu());
	public static Block KOTATSU_kaede = register("block_kotatsu_kaede", kotatsu());
	public static Block KOTATSU_ichoh = register("block_kotatsu_ichoh", kotatsu());

	public static Block KASA_white = register("block_mkasa_white", wagasa());
	public static Block KASA_orange = register("block_mkasa_orange", wagasa());
	public static Block KASA_magenta = register("block_mkasa_magenta", wagasa());
	public static Block KASA_lightb = register("block_mkasa_lightb", wagasa());
	public static Block KASA_yellow = register("block_mkasa_yellow", wagasa());
	public static Block KASA_lime = register("block_mkasa_lime", wagasa());
	public static Block KASA_pink = register("block_mkasa_pink", wagasa());
	public static Block KASA_gray = register("block_mkasa_gray", wagasa());
	public static Block KASA_lightg = register("block_mkasa_lightg", wagasa());
	public static Block KASA_cyan = register("block_mkasa_cyan", wagasa());
	public static Block KASA_purple = register("block_mkasa_purple", wagasa());
	public static Block KASA_blue = register("block_mkasa_blue", wagasa());
	public static Block KASA_brown = register("block_mkasa_brown", wagasa());
	public static Block KASA_green = register("block_mkasa_green", wagasa());
	public static Block KASA_red = register("block_mkasa_red", wagasa());
	public static Block KASA_black = register("block_mkasa_black", wagasa());

	public static Block WRITTEN_BOOK = register("block_written_book", new WrittenBook(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD)
			.strength(0.5F).noCollission().noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never)));
	public static Block WRITTEN_MAKIMONO = register("block_written_makimono", new WrittenMakimono(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD)
			.strength(0.5F).noCollission().noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never)));
	
	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static UnitDesk unitDesk() {
		return new UnitDesk(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static CafeTable cafeTable() {
		return new CafeTable(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static Endai endai() {
		return new Endai(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static LowDesk lowDesk() {
		return new LowDesk(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static TrayLetter letterTray() {
		return new TrayLetter(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static TrayFude fudeTray() {
		return new TrayFude(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}
	
	private static Chabudai chabudai() {
		return new Chabudai(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static Kotatsu kotatsu() {
		return new Kotatsu(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	private static Wagasa wagasa() {
		return new Wagasa(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 1.0F).sound(SoundType.WOOL)
				.noOcclusion().isValidSpawn(Unit_Blocks::neverEntity).isSuffocating(Unit_Blocks::never));
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
