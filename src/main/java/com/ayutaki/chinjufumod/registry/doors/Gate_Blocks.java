package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.gate.Gate_iron;
import com.ayutaki.chinjufumod.blocks.gate.Gate_irongrill;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce;
import com.ayutaki.chinjufumod.blocks.gate.Gate_spruce_B;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Gate_Blocks {

	public static Gate_spruce GATE_SPRUCE;
	public static Gate_spruce_B GATE_SPRUCE_B;
	public static Gate_iron GATE_IRON;
	public static Gate_irongrill GATE_IRONGRILL;


	/* → main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		GATE_SPRUCE = new Gate_spruce();
		GATE_SPRUCE_B = new Gate_spruce_B();
		GATE_IRON = new Gate_iron();
		GATE_IRONGRILL = new Gate_irongrill();

	}


}
