package com.ayutaki.chinjufumod.config;

import java.io.File;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CMConfig_Core {

	public static Configuration config;

	public static final String GENERAL = "general";

	public static boolean isGeneratorEnabled = true;
	public static int isGeneratorChance = 25;

	public static boolean sakuraBiomeRegister = true;
	public static int sakuraBiomeChance = 4;
	public static int sakuraTreeChance = 3;

	public static boolean kaedeBiomeRegister = true;
	public static int kaedeBiomeChance = 4;
	public static int kaedeTreeChance = 3;

	public static boolean ichohBiomeRegister = true;
	public static int ichohBiomeChance = 4;
	public static int ichohTreeChance = 3;

	public static boolean blastBlockBreak = true;
	public static boolean useMAKIMONO = true;
	
	public static void init(File file) {
		if (config == null) {
			config = new Configuration(file);
			loadConfig(false);
		}
	}

	public static void loadConfig(boolean shouldChange) {

		/* General*/
		isGeneratorEnabled = config.getBoolean("enabledGenerator", GENERAL,
				isGeneratorEnabled, "BauxiteOre will be generated, when this setting is true.", "config.bauxiteore.enabledGenerator");

		/** config.getInt(name, category, defaultValue, minValue, maxValue, comment, langKey) **/
		isGeneratorChance = config.getInt("generatorChance", GENERAL,
				25, 1, 100, "RedStone Ore=25, Gold Ore=8", "config.bauxiteore.chance");

		/* 桜 */
		sakuraBiomeRegister = config.getBoolean("sakuraBiomeRegister", GENERAL,
				sakuraBiomeRegister, "CherryBiome will be generated, when this setting is true.", "config.cherrybiome.register");

		sakuraBiomeChance = config.getInt("sakuraChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.cherrybiome.chance");

		sakuraTreeChance = config.getInt("sakuraChanceTree", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.cherrytree.chance");

		/* 楓 */
		kaedeBiomeRegister = config.getBoolean("kaedeBiomeRegister", GENERAL,
				kaedeBiomeRegister, "AcerBiome will be generated, when this setting is true.", "config.acerbiome.register");

		kaedeBiomeChance = config.getInt("kaedeChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.acerbiome.chance");

		kaedeTreeChance = config.getInt("kaedeTreeBiome", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.acertree.chance");

		/* 銀杏 */
		ichohBiomeRegister = config.getBoolean("ichohBiomeRegister", GENERAL,
				ichohBiomeRegister, "GinkgoBiome will be generated, when this setting is true.", "config.ginkgobiome.register");

		ichohBiomeChance = config.getInt("ichohChanceBiome", GENERAL,
				4, 1, 19, "Common=19, Rare=1", "config.ginkgobiome.chance");

		ichohTreeChance = config.getInt("ichohChanceTree", GENERAL,
				3, 1, 19, "Common=19, Rare=1", "config.ginkgotree.chance");


		/* 爆風によるブロック破壊 */
		blastBlockBreak = config.getBoolean("blastBlockBreak", GENERAL,
				blastBlockBreak, "Ammo blast breaks the block, when this setting is true.", "config.blastblockbreak.enabled");
		
		/* 巻物ブロック */
		useMAKIMONO = config.getBoolean("useMAKIMONO", GENERAL,
				useMAKIMONO, "You can use MAKIMONO block, when this setting is true.", "config.usemakimono");

		/* 設定内容をコンフィグファイルに保存する*/
		if (config.hasChanged() && shouldChange) { }
		config.save();

	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.getModID().equals(ChinjufuMod.MOD_ID)) {
			loadConfig(true);
		}
	}

}
