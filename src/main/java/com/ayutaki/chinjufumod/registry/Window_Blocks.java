package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.Window;
import com.ayutaki.chinjufumod.blocks.window.WindowB;
import com.ayutaki.chinjufumod.blocks.window.WindowTall;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Bot;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_Top;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Window_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block WINDOW_oak = register("block_window", window());
	public static Block WINDOW_spruce = register("block_window_spruce", window());
	public static Block WINDOW_birch = register("block_window_birch", window());
	public static Block WINDOW_jungle = register("block_window_jungle", window());
	public static Block WINDOW_acacia = register("block_window_acacia", window());
	public static Block WINDOW_darkoak = register("block_window_darkoak", window());
	public static Block WINDOW_sakura = register("block_window_sakura", window());
	public static Block WINDOW_kaede = register("block_window_kaede", window());
	public static Block WINDOW_ichoh = register("block_window_ichoh", window());

	public static Block WINDOWB_oak = register("block_windowb", windowBtype());
	public static Block WINDOWB_spruce = register("block_windowb_spruce", windowBtype());
	public static Block WINDOWB_birch = register("block_windowb_birch", windowBtype());
	public static Block WINDOWB_jungle = register("block_windowb_jungle", windowBtype());
	public static Block WINDOWB_acacia = register("block_windowb_acacia", windowBtype());
	public static Block WINDOWB_darkoak = register("block_windowb_darkoak", windowBtype());
	public static Block WINDOWB_sakura = register("block_windowb_sakura", windowBtype());
	public static Block WINDOWB_kaede = register("block_windowb_kaede", windowBtype());
	public static Block WINDOWB_ichoh = register("block_windowb_ichoh", windowBtype());

	public static Block WINDOWTALLBOT_oak = register("block_windowtallbot", windowTallBot());
	public static Block WINDOWTALLBOT_spruce = register("block_windowtallbot_spruce", windowTallBot());
	public static Block WINDOWTALLBOT_birch = register("block_windowtallbot_birch", windowTallBot());
	public static Block WINDOWTALLBOT_jungle = register("block_windowtallbot_jungle", windowTallBot());
	public static Block WINDOWTALLBOT_acacia = register("block_windowtallbot_acacia", windowTallBot());
	public static Block WINDOWTALLBOT_darkoak = register("block_windowtallbot_darkoak", windowTallBot());
	public static Block WINDOWTALLBOT_sakura = register("block_windowtallbot_sakura", windowTallBot());
	public static Block WINDOWTALLBOT_kaede = register("block_windowtallbot_kaede", windowTallBot());
	public static Block WINDOWTALLBOT_ichoh = register("block_windowtallbot_ichoh", windowTallBot());

	public static Block WINDOWTALLTOP_oak = register("block_windowtalltop", windowTallTop());
	public static Block WINDOWTALLTOP_spruce = register("block_windowtalltop_spruce", windowTallTop());
	public static Block WINDOWTALLTOP_birch = register("block_windowtalltop_birch", windowTallTop());
	public static Block WINDOWTALLTOP_jungle = register("block_windowtalltop_jungle", windowTallTop());
	public static Block WINDOWTALLTOP_acacia = register("block_windowtalltop_acacia", windowTallTop());
	public static Block WINDOWTALLTOP_darkoak = register("block_windowtalltop_darkoak", windowTallTop());
	public static Block WINDOWTALLTOP_sakura = register("block_windowtalltop_sakura", windowTallTop());
	public static Block WINDOWTALLTOP_kaede = register("block_windowtalltop_kaede", windowTallTop());
	public static Block WINDOWTALLTOP_ichoh = register("block_windowtalltop_ichoh", windowTallTop());

	public static Block WINDOWTALL_oak = register("block_windowtall", windowTall());
	public static Block WINDOWTALL_spruce = register("block_windowtall_spruce", windowTall());
	public static Block WINDOWTALL_birch = register("block_windowtall_birch", windowTall());
	public static Block WINDOWTALL_jungle = register("block_windowtall_jungle", windowTall());
	public static Block WINDOWTALL_acacia = register("block_windowtall_acacia", windowTall());
	public static Block WINDOWTALL_darkoak = register("block_windowtall_darkoak", windowTall());
	public static Block WINDOWTALL_sakura = register("block_windowtall_sakura", windowTall());
	public static Block WINDOWTALL_kaede = register("block_windowtall_kaede", windowTall());
	public static Block WINDOWTALL_ichoh = register("block_windowtall_ichoh", windowTall());

	/* Share variables */
	private static Window window() {
		return new Window(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WindowB windowBtype() {
		return new WindowB(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WindowTall_Bot windowTallBot() {
		return new WindowTall_Bot(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WindowTall_Top windowTallTop() {
		return new WindowTall_Top(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	private static WindowTall windowTall() {
		return new WindowTall(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F).sound(SoundType.WOOD).notSolid());
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
