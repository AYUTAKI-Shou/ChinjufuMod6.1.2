package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.shouji.BaseShouji;

import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/* Shouji_Blocks内 に置きたいが、マルチでの読み込みでクラッシュするため分離 */
public final class Shouji_BlockModels {

	/* → clientproxy registerModels() */
	@SubscribeEvent
	public static void registerRender() {

		StateMap ignorePowered = new StateMap.Builder().ignore(BaseShouji.POWERED).build();
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_ACA, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_BIR, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_DOAK, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_JUN, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_SPRU, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_SAKU, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_ICH, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJI_KAE, ignorePowered);

		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_ACA, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_BIR, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_DOAK, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_JUN, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_SPRU, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_SAKU, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_ICH, ignorePowered);
		ModelLoader.setCustomStateMapper(Shouji_Blocks.SHOUJIA_KAE, ignorePowered);


	}

}
