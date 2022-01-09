package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlanks_Blocks;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.init.Blocks;

public class FlammableBlocks_CM {

	/* FireBlock を参考に 立方体・半ブロック・階段に絞る */
	public static void init() {

		//registerFlammable(Chinjufu_Blocks.OIL_DRUM, 5, 5);
		registerFlammable(Chinjufu_Blocks.EMPTY_BOX, 5, 20);

		registerFlammable(JPDeco_Blocks.TATAMI_H, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_white, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_orange, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_magenta, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_lightb, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_yellow, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_lime, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_pink, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_gray, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_lightg, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_cyan, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_purple, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_blue, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_brown, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_green, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_red, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_H_black, 5, 20);

		registerFlammable(JPDeco_Blocks.TATAMI_HY, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_white, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_orange, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_magenta, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_lightb, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_yellow, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_lime, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_pink, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_gray, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_lightg, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_cyan, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_purple, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_blue, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_brown, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_green, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_red, 5, 20);
		registerFlammable(JPDeco_Blocks.TATAMI_HY_black, 5, 20);

		registerFlammable(JPDeco_Blocks.TAKECUBE, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKECUBE_Y, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKECUBE_K, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_ST, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_STY, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_STK, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_SH, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_SHY, 5, 20);
		registerFlammable(JPDeco_Blocks.TAKE_SHK, 5, 20);

		registerFlammable(Garden_Blocks.IKEGAKI_S, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_L_TOP, 5, 20);
		registerFlammable(Garden_Blocks.IKEGAKI_L_BOT, 5, 20);

		registerFlammable(Hakkou_Blocks.HAKKOUTARU, 5, 20);
		registerFlammable(Hakkou_Blocks.SHOUYUTARU, 5, 20);
		registerFlammable(Hakkou_Blocks.HAKUSAITARU, 5, 20);
		registerFlammable(Hakkou_Blocks.COCOA_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.RINGOSHU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.BUDOUSHU_TARU, 5, 20);
		registerFlammable(Hakkou_Blocks.HACHIMITSUSHU_TARU, 5, 20);

		registerFlammable(Kitchen_Blocks.BOX_H_EMPTY, 5, 20);
		//registerFlammable(Kitchen_Blocks.BOX_H_EMPTY2, 5, 20);
		//registerFlammable(Kitchen_Blocks.BOX_H_EMPTY3, 5, 20);

		registerFlammable(Kitchen_Blocks.BOX_H_APPLE, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_BEEF, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_BEETROOT, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_BREAD, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CARROT, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CHICKEN, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CHORUS, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_COCO, 5, 20);
		//registerFlammable(Kitchen_Blocks.BOX_H_COD, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_EGG, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_FISH, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_FLOUR, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_MUTTON, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_PORK, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_POTATO, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_RABBIT, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_SALMON, 5, 20);

		registerFlammable(Kitchen_Blocks.BOX_H_CABBAGE, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_HAKUSAI, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CHERRY, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CITRUS, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_CORN, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_GRAPE, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_ONION, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_RICE, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_SOY, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_SPINACH, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_TOMATO, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_TGREEN, 5, 20);
		registerFlammable(Kitchen_Blocks.BOX_H_TRED, 5, 20);

		registerFlammable(Seasonal_Blocks.KUSATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KUSATABA_STAIRS, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KUSATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA_RF, 5, 20);
		registerFlammable(Seasonal_Blocks.WARATABA_STAIRS, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA, 5, 20);
		registerFlammable(Seasonal_Blocks.KAYATABA_STAIRS, 5, 20);

		registerFlammable(Unit_Blocks.UNITDESK, 5, 20);
		registerFlammable(Unit_Blocks.UNITDESK_sub, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE, 5, 20);
		registerFlammable(Unit_Blocks.CAFETABLE_sub, 5, 20);
		registerFlammable(Unit_Blocks.ENDAI, 5, 20);
		registerFlammable(Unit_Blocks.ENDAI_sub, 5, 20);

		registerFlammable(WallBrick_Blocks.PILLAR_oak, 5, 5);
		registerFlammable(WallBrick_Blocks.PILLAR_spru, 5, 5);
		registerFlammable(WallBrick_Blocks.PILLAR_bir, 5, 5);
		registerFlammable(WallBrick_Blocks.PILLAR_jun, 5, 5);
		registerFlammable(WallBrick_Blocks.PILLAR_aca, 5, 5);
		registerFlammable(WallBrick_Blocks.PILLAR_doak, 5, 5);

		registerFlammable(Seasonal_Blocks.SAKURA_flow, 30, 60);
		registerFlammable(Seasonal_Blocks.KAEDE_leaf, 30, 60);
		registerFlammable(Seasonal_Blocks.ICHOH_leaf, 30, 60);
		registerFlammable(Seasonal_Blocks.OAKKARE_leaf, 30, 60);
		registerFlammable(Seasonal_Blocks.SAKURA_log, 5, 5);
		registerFlammable(Seasonal_Blocks.KAEDE_log, 5, 5);
		registerFlammable(Seasonal_Blocks.ICHOH_log, 5, 5);

		registerFlammable(Seasonal_Blocks.PLANKS, 5, 20);
		registerFlammable(Seasonal_Blocks.SAKURA_slabhalf, 5, 20);
		registerFlammable(Seasonal_Blocks.KAEDE_slabhalf, 5, 20);
		registerFlammable(Seasonal_Blocks.ICHOH_slabhalf, 5, 20);
		registerFlammable(Seasonal_Blocks.SAKURA_stairs, 5, 20);
		registerFlammable(Seasonal_Blocks.KAEDE_stairs, 5, 20);
		registerFlammable(Seasonal_Blocks.ICHOH_stairs, 5, 20);
		registerFlammable(Seasonal_Blocks.PILLAR_saku, 5, 5);
		registerFlammable(Seasonal_Blocks.PILLAR_kae, 5, 5);
		registerFlammable(Seasonal_Blocks.PILLAR_ich, 5, 5);
		registerFlammable(Seasonal_Blocks.PILLARSLAB_saku, 5, 5);
		registerFlammable(Seasonal_Blocks.PILLARSLAB_kae, 5, 5);
		registerFlammable(Seasonal_Blocks.PILLARSLAB_ich, 5, 5);
		registerFlammable(Seasonal_Blocks.SAKURA_carpet, 60, 20);
		registerFlammable(Seasonal_Blocks.KAEDE_carpet, 60, 20);
		registerFlammable(Seasonal_Blocks.ICHOH_carpet, 60, 20);
		registerFlammable(Seasonal_Blocks.OCHIBA_carpet, 60, 20);

		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_oak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_spru, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_bir, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_jun, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_aca, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_doak, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_saku, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_kae, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_oak_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_spru_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_bir_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_jun_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_aca_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_doak_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_saku_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_kae_ich, 5, 5);
		registerFlammable(KamoiPlanks_Blocks.KAMOI_ich_ich, 5, 5);

	}

	public static void registerFlammable(Block block, int encouragement, int flammability) {
		BlockFire fireblock = (BlockFire) Blocks.FIRE;
		fireblock.setFireInfo(block, encouragement, flammability);
	}

}
