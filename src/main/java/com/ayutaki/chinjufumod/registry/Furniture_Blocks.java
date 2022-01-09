package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.DressingTable;
import com.ayutaki.chinjufumod.blocks.furniture.HangLamp;
import com.ayutaki.chinjufumod.blocks.furniture.MarineLamp;
import com.ayutaki.chinjufumod.blocks.furniture.StandArm;
import com.ayutaki.chinjufumod.blocks.furniture.StandBedroom;
import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.handler.TileEntity_CM;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Furniture_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block DRESSINGTABLE = register("block_dressingtable", dressingTable());
	public static Block DRESSINGTABLE_spruce = register("block_dressingtable_s", dressingTable());
	public static Block DRESSINGTABLE_birch = register("block_dressingtable_b", dressingTable());
	public static Block DRESSINGTABLE_jungle = register("block_dressingtable_j", dressingTable());
	public static Block DRESSINGTABLE_acacia = register("block_dressingtable_a", dressingTable());
	public static Block DRESSINGTABLE_darkoak = register("block_dressingtable_d", dressingTable());
	public static Block DRESSINGTABLE_sakura = register("block_dressingtable_saku", dressingTable());
	public static Block DRESSINGTABLE_kaede = register("block_dressingtable_kae", dressingTable());
	public static Block DRESSINGTABLE_ichoh = register("block_dressingtable_ich", dressingTable());

	public static Block LAMP = register("block_lamp", new HangLamp(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 2.0F).sound(SoundType.METAL).notSolid()));
	public static Block STANDARM = register("block_standarm", new StandArm(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 2.0F).sound(SoundType.METAL).notSolid()));
	public static Block STAND = register("block_standbedroom", new StandBedroom(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 2.0F).sound(SoundType.METAL).notSolid()));
	public static Block M_LAMP = register("block_marinelamp", new MarineLamp(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
			.hardnessAndResistance(1.0F, 2.0F).sound(SoundType.METAL).notSolid()));

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

	public static Block TANSU_OAK = register("block_tansu_oak", new Tansu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));
	public static Block DOAK_TANSU = register("block_tansu_doak", new Tansu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));
	public static Block SPRUCE_TANSU = register("block_tansu_spruce", new Tansu(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD), () -> {
		return TileEntity_CM.TANSU; }));

	/* Share variables */
	private static Candle candle() {
		return new Candle(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F, 1.0F).sound(SoundType.STONE).notSolid());
	}

	private static DressingTable dressingTable() {
		return new DressingTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 3.0F).sound(SoundType.WOOD).notSolid());
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
