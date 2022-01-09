package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.gate.BaseGate;

import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class Gate_BlockModels {

	/* → clientproxy registerModels() */
	@SubscribeEvent
	public static void registerRender() {

		StateMap ignorePowered = new StateMap.Builder().ignore(BaseGate.POWERED).build();
		ModelLoader.setCustomStateMapper(Gate_Blocks.GATE_SPRUCE, ignorePowered);
		ModelLoader.setCustomStateMapper(Gate_Blocks.GATE_SPRUCE_B, ignorePowered);
		ModelLoader.setCustomStateMapper(Gate_Blocks.GATE_IRON, ignorePowered);
		ModelLoader.setCustomStateMapper(Gate_Blocks.GATE_IRONGRILL, ignorePowered);


	}

}
