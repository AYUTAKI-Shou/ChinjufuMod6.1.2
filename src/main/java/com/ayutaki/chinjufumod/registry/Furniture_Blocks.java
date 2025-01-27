package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.HangLamp;
import com.ayutaki.chinjufumod.blocks.furniture.MarineLamp;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Furniture_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block DRESSINGTABLE = register("block_dressingtable", dressingTable());
	public static Block DRESSINGTABLE_spruce = register("block_dressingtable_s", dressingTable());
	public static Block DRESSINGTABLE_birch = register("block_dressingtable_b", dressingTable());
	public static Block DRESSINGTABLE_jungle = register("block_dressingtable_j", dressingTable());
	public static Block DRESSINGTABLE_acacia = register("block_dressingtable_a", dressingTable());
	public static Block DRESSINGTABLE_darkoak = register("block_dressingtable_d", dressingTable());
	public static Block DRESSINGTABLE_sakura = register("block_dressingtable_saku", dressingTable());
	public static Block DRESSINGTABLE_kaede = register("block_dressingtable_kae", dressingTable());
	public static Block DRESSINGTABLE_ichoh = register("block_dressingtable_ich", dressingTable());

	public static Block LAMP = register("block_lamp", new HangLamp(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 2.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(15))));
	public static Block STANDARM = register("block_standarm", new StandArm(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 2.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(15))));
	public static Block STAND = register("block_standbedroom", new StandBedroom(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 2.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(15))));
	public static Block M_LAMP = register("block_marinelamp", new MarineLamp(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 2.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(15))));

	public static Block CANDLE_white = register("block_candle_white", candle());
	public static Block CANDLE_orange = register("block_candle_orange", candle());
	public static Block CANDLE_magenta = register("block_candle_magenta", candle());
	public static Block CANDLE_lightb = register("block_candle_lightb", candle());
	public static Block CANDLE_yellow = register("block_candle_yellow", candle());
	public static Block CANDLE_lime = register("block_candle_lime", candle());
	public static Block CANDLE_pink = register("block_candle_pink", candle());
	public static Block CANDLE_gray = register("block_candle_gray", candle());
	public static Block CANDLE_lightg = register("block_candle_lightg", candle());
	public static Block CANDLE_cyan = register("block_candle_cyan", candle());
	public static Block CANDLE_purple = register("block_candle_purple", candle());
	public static Block CANDLE_blue = register("block_candle_blue", candle());
	public static Block CANDLE_brown = register("block_candle_brown", candle());
	public static Block CANDLE_green = register("block_candle_green", candle());
	public static Block CANDLE_red = register("block_candle_red", candle());
	public static Block CANDLE_black = register("block_candle_black", candle());

	public static Block TANSU_OAK = register("block_tansu_oak", new Tansu(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));
	public static Block DOAK_TANSU = register("block_tansu_doak", new Tansu(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));
	public static Block SPRUCE_TANSU = register("block_tansu_spruce", new Tansu(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));

	/* Share variables */
	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}

	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static Candle candle() {
		return new Candle(AbstractBlock.Properties.of(Material.WOOD).noCollission().strength(1.0F, 1.0F).sound(SoundType.STONE)
				.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never).lightLevel(litBlockEmission(13)));
	}

	private static DressingTable dressingTable() {
		return new DressingTable(AbstractBlock.Properties.of(Material.WOOD).strength(1.0F, 3.0F).sound(SoundType.WOOD)
				.noOcclusion().isValidSpawn(Furniture_Blocks::neverEntity).isSuffocating(Furniture_Blocks::never));
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
