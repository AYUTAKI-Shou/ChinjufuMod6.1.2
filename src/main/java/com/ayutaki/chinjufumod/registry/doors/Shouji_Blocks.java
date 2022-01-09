package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_acacia;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_birch;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_darkoak;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_ichoh;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_jungle;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_kaede;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_oak;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_sakura;
import com.ayutaki.chinjufumod.blocks.shouji.ShoujiB_spruce;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_acacia;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_birch;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_darkoak;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_ichoh;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_jungle;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_kaede;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_oak;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_sakura;
import com.ayutaki.chinjufumod.blocks.shouji.Shouji_spruce;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Shouji_Blocks {

	public static Shouji_oak SHOUJI;
	public static Shouji_acacia SHOUJI_ACA;
	public static Shouji_birch SHOUJI_BIR;
	public static Shouji_darkoak SHOUJI_DOAK;
	public static Shouji_jungle SHOUJI_JUN;
	public static Shouji_spruce SHOUJI_SPRU;
	public static Shouji_sakura SHOUJI_SAKU;
	public static Shouji_ichoh SHOUJI_ICH;
	public static Shouji_kaede SHOUJI_KAE;

	public static ShoujiB_oak SHOUJIA;
	public static ShoujiB_acacia SHOUJIA_ACA;
	public static ShoujiB_birch SHOUJIA_BIR;
	public static ShoujiB_darkoak SHOUJIA_DOAK;
	public static ShoujiB_jungle SHOUJIA_JUN;
	public static ShoujiB_spruce SHOUJIA_SPRU;
	public static ShoujiB_sakura SHOUJIA_SAKU;
	public static ShoujiB_ichoh SHOUJIA_ICH;
	public static ShoujiB_kaede SHOUJIA_KAE;


	/* → main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		SHOUJI = new Shouji_oak();
		SHOUJI_ACA = new Shouji_acacia();
		SHOUJI_BIR = new Shouji_birch();
		SHOUJI_DOAK = new Shouji_darkoak();
		SHOUJI_JUN = new Shouji_jungle();
		SHOUJI_SPRU = new Shouji_spruce();
		SHOUJI_SAKU = new Shouji_sakura();
		SHOUJI_ICH = new Shouji_ichoh();
		SHOUJI_KAE = new Shouji_kaede();

		SHOUJIA = new ShoujiB_oak();
		SHOUJIA_ACA = new ShoujiB_acacia();
		SHOUJIA_BIR = new ShoujiB_birch();
		SHOUJIA_DOAK = new ShoujiB_darkoak();
		SHOUJIA_JUN = new ShoujiB_jungle();
		SHOUJIA_SPRU = new ShoujiB_spruce();
		SHOUJIA_SAKU = new ShoujiB_sakura();
		SHOUJIA_ICH = new ShoujiB_ichoh();
		SHOUJIA_KAE = new ShoujiB_kaede();

	}

}
