package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_acacia;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_birch;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_darkoak;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_ichoh;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_jungle;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_kaede;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_oak;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_sakura;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorB_spruce;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_acacia;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_birch;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_darkoak;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_ichoh;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_jungle;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_kaede;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_oak;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_sakura;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoor_spruce;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Garasudo_Blocks {

	public static GlassDoor_oak GARASUDO;
	public static GlassDoor_acacia GARASUDO_ACA;
	public static GlassDoor_birch GARASUDO_BIR;
	public static GlassDoor_darkoak GARASUDO_DOAK;
	public static GlassDoor_jungle GARASUDO_JUN;
	public static GlassDoor_spruce GARASUDO_SPRU;
	public static GlassDoor_sakura GARASUDO_SAKU;
	public static GlassDoor_ichoh GARASUDO_ICH;
	public static GlassDoor_kaede GARASUDO_KAE;

	public static GlassDoorB_oak GARASUDOB;
	public static GlassDoorB_acacia GARASUDOB_ACA;
	public static GlassDoorB_birch GARASUDOB_BIR;
	public static GlassDoorB_darkoak GARASUDOB_DOAK;
	public static GlassDoorB_jungle GARASUDOB_JUN;
	public static GlassDoorB_spruce GARASUDOB_SPRU;
	public static GlassDoorB_sakura GARASUDOB_SAKU;
	public static GlassDoorB_ichoh GARASUDOB_ICH;
	public static GlassDoorB_kaede GARASUDOB_KAE;


	/* → main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		GARASUDO = new GlassDoor_oak();
		GARASUDO_ACA = new GlassDoor_acacia();
		GARASUDO_BIR = new GlassDoor_birch();
		GARASUDO_DOAK = new GlassDoor_darkoak();
		GARASUDO_JUN = new GlassDoor_jungle();
		GARASUDO_SPRU = new GlassDoor_spruce();
		GARASUDO_SAKU = new GlassDoor_sakura();
		GARASUDO_ICH = new GlassDoor_ichoh();
		GARASUDO_KAE = new GlassDoor_kaede();

		GARASUDOB = new GlassDoorB_oak();
		GARASUDOB_ACA = new GlassDoorB_acacia();
		GARASUDOB_BIR = new GlassDoorB_birch();
		GARASUDOB_DOAK = new GlassDoorB_darkoak();
		GARASUDOB_JUN = new GlassDoorB_jungle();
		GARASUDOB_SPRU = new GlassDoorB_spruce();
		GARASUDOB_SAKU = new GlassDoorB_sakura();
		GARASUDOB_ICH = new GlassDoorB_ichoh();
		GARASUDOB_KAE = new GlassDoorB_kaede();

	}

}
