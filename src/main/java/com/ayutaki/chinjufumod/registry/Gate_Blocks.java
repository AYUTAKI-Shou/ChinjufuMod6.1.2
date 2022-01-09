package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.gate.Gate_iron;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce;
import com.ayutaki.chinjufumod.blocks.season.Door_CM;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Gate_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block GATE_SPRUCE = register("block_gate_spruce", new Gate_spruce(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid()));
	public static Block GATE_SPRUCE_B = register("block_gate_spruce_b", new Gate_spruce(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid()));
	public static Block GATE_IRON = register("block_gate_iron", new Gate_iron(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.METAL).notSolid()));
	public static Block GATE_IRONGRILL = register("block_gate_irongrill", new Gate_irongrill(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.METAL).notSolid()));

	public static Block DOOR_SAKURA = register("block_door_sakura", new Door_CM(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid()));
	public static Block DOOR_KAEDE = register("block_door_kaede", new Door_CM(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid()));
	public static Block DOOR_ICHOH = register("block_door_ichoh", new Door_CM(Block.Properties.create(Material.WOOD)
			.hardnessAndResistance(1.0F, 10.0F).sound(SoundType.WOOD).notSolid()));

	/* Share variables */

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
