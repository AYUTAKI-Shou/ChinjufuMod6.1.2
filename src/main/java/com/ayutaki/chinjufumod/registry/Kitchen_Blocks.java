package com.ayutaki.chinjufumod.registry;

import java.util.function.ToIntFunction;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Board;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_AAA;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_OAA;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cheese_Tana;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Duct;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Ductend;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Kanki;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Sink;
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
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDonburi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaDrinkglass_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSara_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaShikki_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaSushiGeta_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTcup_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaTonsui_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_TanaYunomi_1;
import com.ayutaki.chinjufumod.blocks.kitchen.Kitchen;

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
public class Kitchen_Blocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block KITCHEN = register("block_kitchen", new Kitchen(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_BOARD = register("block_kit_board", new Kit_Board(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SINK = register("block_kit_sink", new Kit_Sink(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_COOKTOP = register("block_kit_stove", new Kit_Cooktop(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 6.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never).lightLevel(litCooktop(14))));

	public static Block KIT_OVEN = register("block_kit_oven", new Kitchen_Oven(AbstractBlock.Properties.of(Material.METAL).strength(2.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().lightLevel(litBlockEmission(14))));
	public static Block KIT_OVEN_B = register("block_kit_oven_black", new Kitchen_Oven_B(AbstractBlock.Properties.of(Material.METAL).strength(2.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().lightLevel(litBlockEmission(14))));
	public static Block IRORI = register("block_irori", new Irori(AbstractBlock.Properties.of(Material.METAL).randomTicks().strength(2.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().lightLevel(litIrori(14, 12))));

	public static Block KIT_KANKI_1 = register("block_kit_kanki", new Kit_Kanki(AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_HAIKIDUCT = register("block_kit_duct", new Kit_Duct(AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_DUCTEND_1 = register("block_kit_ductend", new Kit_Ductend(AbstractBlock.Properties.of(Material.METAL).strength(1.0F, 6.0F).sound(SoundType.METAL)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_TANA = register("block_kit_tana", new Kit_Tana(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_CHAWAN1 = register("block_kit_chawan1", new Kit_TanaChawan_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SHIKKI1 = register("block_kit_shikki1", new Kit_TanaShikki_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SARA1 = register("block_kit_sara1", new Kit_TanaSara_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_TONSUI1 = register("block_kit_tonsui1", new Kit_TanaTonsui_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_YUNOMI1 = register("block_kit_yunomi1", new Kit_TanaYunomi_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_TCUP1 = register("block_kit_tcup1", new Kit_TanaTcup_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_DRINKGLASS1 = register("block_kit_driglass1", new Kit_TanaDrinkglass_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_DONBURI1 = register("block_kit_donburi1", new Kit_TanaDonburi_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SUSHIGETA1 = register("block_kit_sushigeta1", new Kit_TanaSushiGeta_1(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block WINE_TANA = register("block_kit2_tana", new Kit_Tana2(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block KIT_SAKENAMA = register("block_kit2_sakenama", new Kit_Tana2SakeNama(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SAKE = register("block_kit2_sake", new Kit_Tana2Sake(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_SAKEJUKU = register("block_kit2_sakejuku", new Kit_Tana2SakeJuku(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_CIDER = register("block_kit2_cider", new Kit_Tana2Cider(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_CIDERJUKU = register("block_kit2_ciderjuku", new Kit_Tana2CiderJuku(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_WINE = register("block_kit2_wine", new Kit_Tana2Wine(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_WINEJUKU = register("block_kit2_winejuku", new Kit_Tana2WineJuku(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_MEAD = register("block_kit2_mead", new Kit_Tana2Mead(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block KIT_MEADJUKU = register("block_kit2_meadjuku", new Kit_Tana2MeadJuku(AbstractBlock.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	public static Block CHEESE_TANA = register("block_kit_cheese_tana", new Kit_Cheese_Tana(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block CHEESE_OAA = register("block_kit_cheese_oaa", new Kit_Cheese_OAA(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));
	public static Block CHEESE_AAA = register("block_kit_cheese_aaa", new Kit_Cheese_AAA(AbstractBlock.Properties.of(Material.WOOD).randomTicks().strength(2.0F, 3.0F).sound(SoundType.WOOD)
			.noOcclusion().isValidSpawn(Kitchen_Blocks::neverEntity).isSuffocating(Kitchen_Blocks::never)));

	/* Share variables */
	private static boolean never(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	private static Boolean neverEntity(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> entity) {
		return (boolean)false;
	}

	private static ToIntFunction<BlockState> litIrori(int value1, int value2) {
		return (state) -> { return state.getValue(Irori.LIT)? value1 : (((state.getValue(Irori.STAGE_0_10) >= 7) && (state.getValue(Irori.STAGE_0_10) <= 9))? value2 : 0); };
	}

	private static ToIntFunction<BlockState> litBlockEmission(int value) {
		return (state) -> { return state.getValue(BlockStateProperties.LIT) ? value : 0; };
	}
	
	private static ToIntFunction<BlockState> litCooktop(int value) {
		return (state) -> { return (state.getValue(Kit_Cooktop.STAGE_1_3) ==2) ? value : 0; };
	}

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
