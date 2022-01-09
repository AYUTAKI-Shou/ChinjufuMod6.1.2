package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Large;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Medium;
import com.ayutaki.chinjufumod.entity.render.RenderAmmo_Small;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm2;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm3;
import com.ayutaki.chinjufumod.entity.render.RenderGyorai61cm4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ju87;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ju87_2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ju87_3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ju87_4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Ryusei4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Swordfish4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_TBF4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Tenzan4;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97_2;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97_3;
import com.ayutaki.chinjufumod.entity.render.RenderKK_Type97_4;
import com.ayutaki.chinjufumod.entity.render.SitableRenderer;
import com.ayutaki.chinjufumod.entity.render.ToamiRenderer;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EntityRender_CM {

	public static void register() {

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SITABLE, SitableRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_L, RenderAmmo_Large::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_M, RenderAmmo_Medium::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.AMMO_S, RenderAmmo_Small::new);

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE97, renderManager -> new RenderKK_Type97(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE97_2, renderManager -> new RenderKK_Type97_2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE97_3, renderManager -> new RenderKK_Type97_3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TYPE97_4, renderManager -> new RenderKK_Type97_4(renderManager, Minecraft.getInstance().getItemRenderer()));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TENZAN, renderManager -> new RenderKK_Tenzan(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TENZAN2, renderManager -> new RenderKK_Tenzan2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TENZAN3, renderManager -> new RenderKK_Tenzan3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TENZAN4, renderManager -> new RenderKK_Tenzan4(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RYUSEI, renderManager -> new RenderKK_Ryusei(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RYUSEI2, renderManager -> new RenderKK_Ryusei2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RYUSEI3, renderManager -> new RenderKK_Ryusei3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.RYUSEI4, renderManager -> new RenderKK_Ryusei4(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.JU87, renderManager -> new RenderKK_Ju87(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.JU87_2, renderManager -> new RenderKK_Ju87_2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.JU87_3, renderManager -> new RenderKK_Ju87_3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.JU87_4, renderManager -> new RenderKK_Ju87_4(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TBF, renderManager -> new RenderKK_TBF(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TBF2, renderManager -> new RenderKK_TBF2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TBF3, renderManager -> new RenderKK_TBF3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TBF4, renderManager -> new RenderKK_TBF4(renderManager, Minecraft.getInstance().getItemRenderer()));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SWORDFISH, renderManager -> new RenderKK_Swordfish(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SWORDFISH2, renderManager -> new RenderKK_Swordfish2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SWORDFISH3, renderManager -> new RenderKK_Swordfish3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.SWORDFISH4, renderManager -> new RenderKK_Swordfish4(renderManager, Minecraft.getInstance().getItemRenderer()));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.GYORAI61, renderManager -> new RenderGyorai61cm(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.GYORAI61_2, renderManager -> new RenderGyorai61cm2(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.GYORAI61_3, renderManager -> new RenderGyorai61cm3(renderManager, Minecraft.getInstance().getItemRenderer()));
		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.GYORAI61_4, renderManager -> new RenderGyorai61cm4(renderManager, Minecraft.getInstance().getItemRenderer()));

		RenderingRegistry.registerEntityRenderingHandler(EntityTypes_CM.TOAMI, renderManager -> new ToamiRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
	}

}
