package com.ayutaki.chinjufumod;

import org.apache.logging.log4j.Logger;

import com.ayutaki.chinjufumod.config.CMConfig_Core;
import com.ayutaki.chinjufumod.entity.EntitySittableBlock;
import com.ayutaki.chinjufumod.entity.Entity_AmmoKC;
import com.ayutaki.chinjufumod.entity.Entity_AmmoMedium;
import com.ayutaki.chinjufumod.entity.Entity_AmmoSmall;
import com.ayutaki.chinjufumod.entity.ToamiEntity;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ryusei;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ryusei2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ryusei3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ryusei4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Swordfish;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Swordfish3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Swordfish4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_TBF;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_TBF2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_TBF3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_TBF4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Tenzan;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Tenzan2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Tenzan3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Tenzan4;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Type97;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Type97_2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Type97_3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Type97_4;
import com.ayutaki.chinjufumod.handler.Biomes_CM;
import com.ayutaki.chinjufumod.handler.FlammableBlocks_CM;
import com.ayutaki.chinjufumod.handler.OreDictionary_CM;
import com.ayutaki.chinjufumod.handler.SmeltingRecipe_CM;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.proxy.CommonProxy;
import com.ayutaki.chinjufumod.registry.doors.Door_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Gate_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Shouji_Blocks;
import com.ayutaki.chinjufumod.tileentity.TileEntityCStove;
import com.ayutaki.chinjufumod.tileentity.TileEntityKitOven;
import com.ayutaki.chinjufumod.tileentity.TileEntityKitOven_B;
import com.ayutaki.chinjufumod.tileentity.TileEntityTansu;
import com.ayutaki.chinjufumod.world.generate.CM_OreGen;

import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ChinjufuMod.MOD_ID, name = ChinjufuMod.MOD_NAME,
		version = ChinjufuMod.MOD_VERSION, guiFactory = ChinjufuMod.GUI_FACTORY)
public class ChinjufuMod {

	/* 参照する値をここで管理 Manage referenced values here. */
	public static final String MOD_ID = "chinjufumod";
	public static final String MOD_NAME = "ChinjufuMod";
	public static final String MOD_VERSION = "[1.12.2]6.1.2";
	public static final String GUI_FACTORY = "com.ayutaki.chinjufumod.config.CMGuiFactory";

	public static final String CLIENT_PROXY_CLASS = "com.ayutaki.chinjufumod.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.ayutaki.chinjufumod.proxy.CommonProxy";


	/* クラス(設計書)をインスタンス(製品)にする Change Class to Instance. */
	@Instance
	public static ChinjufuMod instance;

	/* プロキシの登録 Register Proxy. */
	@SidedProxy(clientSide = ChinjufuMod.CLIENT_PROXY_CLASS, serverSide = ChinjufuMod.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	/* エラーログの出力 Output Error log. */
	private static Logger logger;


	/* エンティティの登録、コンフィグ読込など Register Entity and Config. */
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();

		MinecraftForge.EVENT_BUS.register(new CMConfig_Core());
		CMConfig_Core.init(event.getSuggestedConfigurationFile());

		proxy.preInit();
		proxy.registerEntityRender();

		/* EntityRegistry.registerModEntity(registryName,
		 * 		entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates); */
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:mountable_block"),
				EntitySittableBlock.class, "MountableBlock", 0, this, 80, 1, false);

		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_kc"),
				Entity_AmmoKC.class, "ammunition_kc", 1, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_medium"),
				Entity_AmmoMedium.class, "ammunition_medium", 2, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:ammunition_small"),
				Entity_AmmoSmall.class, "ammunition_small", 3, this, 64, 1, true);

		/* 艦載機 */
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_type97kk"),
				Entity_Type97.class, "type97kk", 4, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tenzan"),
				Entity_Tenzan.class, "tenzan", 5, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ryusei"),
				Entity_Ryusei.class, "ryusei", 6, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ju87"),
				Entity_Ju87.class, "ju87", 7, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tbf"),
				Entity_TBF.class, "tbf", 8, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_swordfish"),
				Entity_Swordfish.class, "swordfish", 9, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_gyorai"),
				Entity_Gyorai61cm.class, "gyorai", 14, this, 64, 1, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_type97kk"),
				Entity_Type97_2.class, "type97kk2", 15, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tenzan"),
				Entity_Tenzan2.class, "tenzan2", 16, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ryusei"),
				Entity_Ryusei2.class, "ryusei2", 17, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ju87"),
				Entity_Ju87_2.class, "ju87_2", 18, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tbf"),
				Entity_TBF2.class, "tbf2", 19, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_swordfish"),
				Entity_Swordfish.class, "swordfish2", 20, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_gyorai"),
				Entity_Gyorai61cm2.class, "gyorai2", 21, this, 64, 1, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_type97kk"),
				Entity_Type97_3.class, "type97kk3", 22, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tenzan"),
				Entity_Tenzan3.class, "tenzan3", 23, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ryusei"),
				Entity_Ryusei3.class, "ryusei3", 24, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ju87"),
				Entity_Ju87_3.class, "ju87_3", 25, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tbf"),
				Entity_TBF3.class, "tbf3", 26, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_swordfish"),
				Entity_Swordfish3.class, "swordfish3", 27, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_gyorai"),
				Entity_Gyorai61cm3.class, "gyorai3", 28, this, 64, 1, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_type97kk"),
				Entity_Type97_4.class, "type97kk4", 29, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tenzan"),
				Entity_Tenzan4.class, "tenzan4", 30, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ryusei"),
				Entity_Ryusei4.class, "ryuse4i", 31, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_ju87"),
				Entity_Ju87_4.class, "ju87_4", 32, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_tbf"),
				Entity_TBF4.class, "tbf4", 33, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_kk_swordfish"),
				Entity_Swordfish4.class, "swordfish4", 34, this, 64, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_gyorai"),
				Entity_Gyorai61cm4.class, "gyorai4", 35, this, 64, 1, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("chinjufumod:item_toami"),
				ToamiEntity.class, "toami", 36, this, 64, 1, true);

		/* 落葉 → パーティクルに変更 */

		/* registerTileEntity(Class<? extends TileEntity> tileEntityClass, ResourceLocation key) */
		GameRegistry.registerTileEntity(TileEntityCStove.class, new ResourceLocation("chinjufumod:cstove"));
		GameRegistry.registerTileEntity(TileEntityKitOven.class, new ResourceLocation("chinjufumod:kitoven"));
		GameRegistry.registerTileEntity(TileEntityKitOven_B.class, new ResourceLocation("chinjufumod:kitoven_b"));
		GameRegistry.registerTileEntity(TileEntityTansu.class, new ResourceLocation("chinjufumod:tansu"));

		/* 赤石が影響するブロック */
		Door_Blocks.load(event);
		Garasudo_Blocks.load(event);
		Shouji_Blocks.load(event);
		Fusuma_Blocks.load(event);
		Gate_Blocks.load(event);

		proxy.registerModels();

	}

	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

		proxy.init();

		GameRegistry.registerWorldGenerator(new CM_OreGen(), 0);
		OreDictionary_CM.registerOreDictionary();
		SmeltingRecipe_CM.registerSmeltingRecipes();
		SoundEvents_CM.registerSounds();
		FlammableBlocks_CM.init();

		for (Biomes_CM.ModBiomeEntry biomeEntry : Biomes_CM.biomeEntryList) {
			if (biomeEntry.getWeight() > 0) {
				BiomeManager.addBiome(biomeEntry.getType(), biomeEntry.getEntry());
				BiomeManager.addStrongholdBiome(biomeEntry.getBiome());
			}
		}
	}

	/* 他Modとの連携 Cooperation with other Mod. */
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

}
