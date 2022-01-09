package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.cmblock.AdmiralStampBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.blocks.cmblock.AmmoBauxiteBox;
import com.ayutaki.chinjufumod.blocks.cmblock.BauxiteOre;
import com.ayutaki.chinjufumod.blocks.cmblock.EmptyBox;
import com.ayutaki.chinjufumod.blocks.cmblock.Oil_Drum;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater1;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater2;
import com.ayutaki.chinjufumod.blocks.cmblock.WakeWater3;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChinjufuModBlocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block BAUXITE_ORE = register("block_bauxite_ore", new BauxiteOre(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)
			.harvestTool(ToolType.PICKAXE).harvestLevel(2).hardnessAndResistance(3.0F, 3.0F)));

	public static Block OIL_DRUM = register("block_fuel_can", new Oil_Drum(Block.Properties.create(Material.WOOD).sound(SoundType.METAL).hardnessAndResistance(1.0F, 3.0F).notSolid()));

	public static Block EMPTY_BOX = register("block_empty_box", new EmptyBox(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block AMMOBOX = register("block_ammunition_box", new AmmoBauxiteBox(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block BAUXITE_BOX = register("block_bauxite_box", new AmmoBauxiteBox(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1.0F, 3.0F).notSolid()));


	public static Block ALUMI_BLOCK = register("block_alumi_block", new AlumiBlock(Block.Properties.create(Material.WOOD).sound(SoundType.METAL).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block STEEL_BLOCK = register("block_steel_block", new AlumiBlock(Block.Properties.create(Material.WOOD).sound(SoundType.METAL).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block GOLD_BLOCK = register("block_gold_block", new AlumiBlock(Block.Properties.create(Material.WOOD).sound(SoundType.METAL).hardnessAndResistance(1.0F, 3.0F).notSolid()));

	public static Block B_ADMIRAL_STAMP = register("block_stamp_block", new AdmiralStampBlock(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.5F).notSolid()));

	public static Block WAKE_WATER1 = register("block_wake_water1", new WakeWater1(Block.Properties.create(Material.GLASS).sound(SoundType.SNOW).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block WAKE_WATER2 = register("block_wake_water2", new WakeWater2(Block.Properties.create(Material.GLASS).sound(SoundType.SNOW).hardnessAndResistance(1.0F, 3.0F).notSolid()));
	public static Block WAKE_WATER3 = register("block_wake_water3", new WakeWater3(Block.Properties.create(Material.GLASS).sound(SoundType.SNOW).hardnessAndResistance(1.0F, 3.0F).notSolid()));

	/* Share variables */

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
