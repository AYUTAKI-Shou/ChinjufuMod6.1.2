package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.bamboo.BambooFenceGate;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooFenceGate_K;
import com.ayutaki.chinjufumod.blocks.bamboo.BambooFenceGate_Y;
import com.ayutaki.chinjufumod.blocks.gate.Door_bamboo;
import com.ayutaki.chinjufumod.blocks.gate.Door_bamboo_K;
import com.ayutaki.chinjufumod.blocks.gate.Door_bamboo_Y;
import com.ayutaki.chinjufumod.blocks.gate.Door_ichoh;
import com.ayutaki.chinjufumod.blocks.gate.Door_kaede;
import com.ayutaki.chinjufumod.blocks.gate.Door_sakura;
import com.ayutaki.chinjufumod.blocks.season.FenceGate_Ichoh;
import com.ayutaki.chinjufumod.blocks.season.FenceGate_Kaede;
import com.ayutaki.chinjufumod.blocks.season.FenceGate_Sakura;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Door_Blocks {

	public static Door_sakura DOOR_SAKURA;
	public static Door_kaede DOOR_KAEDE;
	public static Door_ichoh DOOR_ICHOH;

	public static FenceGate_Sakura SAKURA_FGATE;
	public static FenceGate_Kaede KAEDE_FGATE;
	public static FenceGate_Ichoh ICHOH_FGATE;

	public static BambooFenceGate TAKEFENCEGATE;
	public static BambooFenceGate_Y TAKEFENCEGATE_Y;
	public static BambooFenceGate_K TAKEFENCEGATE_K;

	public static Door_bamboo TAKEDOOR;
	public static Door_bamboo_Y TAKEDOOR_Y;
	public static Door_bamboo_K TAKEDOOR_K;


	/* → main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		DOOR_SAKURA = new Door_sakura();
		DOOR_KAEDE = new Door_kaede();
		DOOR_ICHOH = new Door_ichoh();

		SAKURA_FGATE = new FenceGate_Sakura();
		KAEDE_FGATE = new FenceGate_Kaede();
		ICHOH_FGATE = new FenceGate_Ichoh();

		TAKEFENCEGATE = new BambooFenceGate();
		TAKEFENCEGATE_Y = new BambooFenceGate_Y();
		TAKEFENCEGATE_K = new BambooFenceGate_K();

		TAKEDOOR = new Door_bamboo();
		TAKEDOOR_Y = new Door_bamboo_Y();
		TAKEDOOR_K = new Door_bamboo_K();

	}

}
