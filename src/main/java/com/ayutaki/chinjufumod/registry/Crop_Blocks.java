package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.crop.Ami_Shikake;
import com.ayutaki.chinjufumod.blocks.crop.Ami_Youshoku;
import com.ayutaki.chinjufumod.blocks.crop.Cabbage;
import com.ayutaki.chinjufumod.blocks.crop.Chanoki;
import com.ayutaki.chinjufumod.blocks.crop.Corn;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.crop.Enden_kara;
import com.ayutaki.chinjufumod.blocks.crop.Grape;
import com.ayutaki.chinjufumod.blocks.crop.Hakusai;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_A_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_B_Top;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Bot;
import com.ayutaki.chinjufumod.blocks.crop.HodaGi_C_Top;
import com.ayutaki.chinjufumod.blocks.crop.Inagi;
import com.ayutaki.chinjufumod.blocks.crop.Mikan;
import com.ayutaki.chinjufumod.blocks.crop.NoriAmi;
import com.ayutaki.chinjufumod.blocks.crop.Onion;
import com.ayutaki.chinjufumod.blocks.crop.Rice;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.blocks.crop.Sakura_me;
import com.ayutaki.chinjufumod.blocks.crop.SeedsBox;
import com.ayutaki.chinjufumod.blocks.crop.Soy;
import com.ayutaki.chinjufumod.blocks.crop.Spinach;
import com.ayutaki.chinjufumod.blocks.crop.Tomato;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Crop_Blocks {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ChinjufuMod.MOD_ID);

	public static Block SEEDSBOX = register("block_seedsbox", new SeedsBox(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(0.5F).sound(SoundType.CROP).notSolid()));

	public static Block CABBAGE = register("block_vege_cabbage", new Cabbage(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block HAKUSAI = register("block_vege_hakusai", new Hakusai(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block CORN = register("block_vege_corn", new Corn(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block ONION = register("block_vege_onion", new Onion(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block RICE = register("block_vege_rice", new Rice(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block RICE_8 = register("block_vege_rice_8", new Rice_8(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block SOY = register("block_vege_soy", new Soy(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block SPINACH = register("block_vege_spinach", new Spinach(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block TOMATO = register("block_vege_tomato", new Tomato(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));
	public static Block SAKURA = register("block_tree_sakura_me", new Sakura_me(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(0.1F).sound(SoundType.CROP).notSolid()));

	public static Block CHANOKI = register("block_wood_chanoki", new Chanoki(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block BUDOUNOKI = register("block_wood_grape", new Grape(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block MIKAN = register("block_wood_mikan", new Mikan(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));

	public static Block HODAGI_A_BOT = register("block_hodagi_a_bot", new HodaGi_A_Bot(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block HODAGI_A_TOP = register("block_hodagi_a_top", new HodaGi_A_Top(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block HODAGI_B_BOT = register("block_hodagi_b_bot", new HodaGi_B_Bot(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block HODAGI_B_TOP = register("block_hodagi_b_top", new HodaGi_B_Top(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block HODAGI_C_BOT = register("block_hodagi_c_bot", new HodaGi_C_Bot(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block HODAGI_C_TOP = register("block_hodagi_c_top", new HodaGi_C_Top(Block.Properties.create(Material.WOOD).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));

	public static Block NORIAMI = register("block_noriami", new NoriAmi(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));
	public static Block INAGI = register("block_inagi", new Inagi(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.WOOD).notSolid()));

	public static Block ENDEN = register("block_enden", new Enden(Block.Properties.create(Material.SAND).tickRandomly().hardnessAndResistance(2.0F).sound(SoundType.SAND).notSolid()));
	public static Block ENDEN_k = register("block_enden_k", new Enden_kara(Block.Properties.create(Material.SAND).tickRandomly().hardnessAndResistance(2.0F).sound(SoundType.SAND).notSolid()));
	
	public static Block TOAMI = register("item_toami", new Block(Block.Properties.create(Material.WOOL)));
	public static Block SHIKAKE_AMI = register("block_ami_shikake", new Ami_Shikake(Block.Properties.create(Material.WOOL).tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.CLOTH).notSolid()));
	public static Block YOUSHOKU_AMI = register("block_ami_youshoku", new Ami_Youshoku(Block.Properties.create(Material.WOOL).tickRandomly().hardnessAndResistance(1.0F).sound(SoundType.CLOTH).notSolid()));
	
	/* Share variables */

	///* Register *///
	private static Block register(String name, Block block) {
		BLOCKS.register(name, () -> block);
		return block;
	}

}
