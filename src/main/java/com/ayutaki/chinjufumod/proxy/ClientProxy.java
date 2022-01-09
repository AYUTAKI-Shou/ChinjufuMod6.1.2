package com.ayutaki.chinjufumod.proxy;

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
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Swordfish2;
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
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Gyorai61cm;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Gyorai61cm2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Gyorai61cm3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Gyorai61cm4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ju87;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ju87_2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ju87_3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ju87_4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ryusei;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ryusei2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ryusei3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Ryusei4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Swordfish;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Swordfish2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Swordfish3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Swordfish4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_TBF;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_TBF2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_TBF3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_TBF4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Tenzan;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Tenzan2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Tenzan3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Tenzan4;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Type97;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Type97_2;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Type97_3;
import com.ayutaki.chinjufumod.entity.kansaiki.render.Render_Type97_4;
import com.ayutaki.chinjufumod.entity.render.RenderAmmunition_KC;
import com.ayutaki.chinjufumod.entity.render.RenderAmmunition_Medium;
import com.ayutaki.chinjufumod.entity.render.RenderAmmunition_Small;
import com.ayutaki.chinjufumod.entity.render.ToamiRender;
import com.ayutaki.chinjufumod.handler.ParticleFactory_CM;
import com.ayutaki.chinjufumod.handler.ParticleTypes_CM;
import com.ayutaki.chinjufumod.handler.TintColors_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Weapon;
import com.ayutaki.chinjufumod.registry.doors.Door_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Garasudo_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Gate_BlockModels;
import com.ayutaki.chinjufumod.registry.doors.Shouji_BlockModels;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

/* クライアントプロキシはコモンプロキシを拡張するクラス
* Client proxy is a class that extends common proxy. */
public class ClientProxy extends CommonProxy {

	public static boolean rendering = false;
	public static Entity renderEntity = null;
	public static Entity backupEntity = null;

	/* エンティティの登録、コンフィグ読込など
	* Register Entity and Config. */
	@Override
	public void preInit() {
		//TileEntityItemStackRenderer.instance = new RenderShield(TileEntityItemStackRenderer.instance);
	}

	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@Override
	public void init() {
		TintColors_CM.registerColorHandlers();
	}

	/* 他Modとの連携 Cooperation with other Mod. */
	@Override
	public void postInit() { }

	/* シングルプレイかどうか Single play or not? */
	@Override
	public boolean isSinglePlayer() {
		return Minecraft.getMinecraft().isSingleplayer();
	}

	/* サーバープレイかどうか Sever play or not? */
	@Override
	public boolean isDedicatedServer() {
		return false;
	}

	/* 赤石が影響するブロック */
	public void registerModels() {
		Garasudo_BlockModels.registerRender();
		Door_BlockModels.registerRender();
		Shouji_BlockModels.registerRender();
		Fusuma_BlockModels.registerRender();
		Gate_BlockModels.registerRender();
	}

	@Override
	public ModelBiped getArmorModel(int id) {
		return null;
	}

	/* エンティティのレンダリング */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerEntityRender() {

		RenderingRegistry.registerEntityRenderingHandler(Entity_AmmoKC.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmunition_KC(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Entity_AmmoMedium.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmunition_Medium(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Entity_AmmoSmall.class, new IRenderFactory() {
			@Override
			public Render createRenderFor(RenderManager manager) {
				 return new RenderAmmunition_Small(manager);
			}
		});

		/* 艦載機 → 雪玉の応用でアイテムモデルを投げる */
		RenderingRegistry.registerEntityRenderingHandler(Entity_Type97.class, renderManager ->
		new Render_Type97(renderManager, Items_Weapon.TYPE97KK, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Tenzan.class, renderManager ->
		new Render_Tenzan(renderManager, Items_Weapon.TENZAN, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ryusei.class, renderManager ->
		new Render_Ryusei(renderManager, Items_Weapon.RYUSEI, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ju87.class, renderManager ->
		new Render_Ju87(renderManager, Items_Weapon.JU87, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_TBF.class, renderManager ->
		new Render_TBF(renderManager, Items_Weapon.TBF, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Swordfish.class, renderManager ->
		new Render_Swordfish(renderManager, Items_Weapon.SWORDFISH, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Type97_2.class, renderManager ->
		new Render_Type97_2(renderManager, Items_Weapon.TYPE97KK, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Tenzan2.class, renderManager ->
		new Render_Tenzan2(renderManager, Items_Weapon.TENZAN, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ryusei2.class, renderManager ->
		new Render_Ryusei2(renderManager, Items_Weapon.RYUSEI, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ju87_2.class, renderManager ->
		new Render_Ju87_2(renderManager, Items_Weapon.JU87, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_TBF2.class, renderManager ->
		new Render_TBF2(renderManager, Items_Weapon.TBF, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Swordfish2.class, renderManager ->
		new Render_Swordfish2(renderManager, Items_Weapon.SWORDFISH, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Type97_3.class, renderManager ->
		new Render_Type97_3(renderManager, Items_Weapon.TYPE97KK, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Tenzan3.class, renderManager ->
		new Render_Tenzan3(renderManager, Items_Weapon.TENZAN, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ryusei3.class, renderManager ->
		new Render_Ryusei3(renderManager, Items_Weapon.RYUSEI, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ju87_3.class, renderManager ->
		new Render_Ju87_3(renderManager, Items_Weapon.JU87, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_TBF3.class, renderManager ->
		new Render_TBF3(renderManager, Items_Weapon.TBF, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Swordfish3.class, renderManager ->
		new Render_Swordfish3(renderManager, Items_Weapon.SWORDFISH, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Type97_4.class, renderManager ->
		new Render_Type97_4(renderManager, Items_Weapon.TYPE97KK, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Tenzan4.class, renderManager ->
		new Render_Tenzan4(renderManager, Items_Weapon.TENZAN, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ryusei4.class, renderManager ->
		new Render_Ryusei4(renderManager, Items_Weapon.RYUSEI, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Ju87_4.class, renderManager ->
		new Render_Ju87_4(renderManager, Items_Weapon.JU87, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_TBF4.class, renderManager ->
		new Render_TBF4(renderManager, Items_Weapon.TBF, Minecraft.getMinecraft().getRenderItem()));

		RenderingRegistry.registerEntityRenderingHandler(Entity_Swordfish4.class, renderManager ->
		new Render_Swordfish4(renderManager, Items_Weapon.SWORDFISH, Minecraft.getMinecraft().getRenderItem()));

		/* 魚雷*/
		RenderingRegistry.registerEntityRenderingHandler(Entity_Gyorai61cm.class, renderManager ->
		new Render_Gyorai61cm(renderManager, Items_Weapon.GYORAI_61cm, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Gyorai61cm2.class, renderManager ->
		new Render_Gyorai61cm2(renderManager, Items_Weapon.GYORAI_61cm, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Gyorai61cm3.class, renderManager ->
		new Render_Gyorai61cm3(renderManager, Items_Weapon.GYORAI_61cm, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(Entity_Gyorai61cm4.class, renderManager ->
		new Render_Gyorai61cm4(renderManager, Items_Weapon.GYORAI_61cm, Minecraft.getMinecraft().getRenderItem()));
		
		RenderingRegistry.registerEntityRenderingHandler(ToamiEntity.class, renderManager ->
		new ToamiRender(renderManager, Items_Teatime.TOAMI_W, Minecraft.getMinecraft().getRenderItem()));
	}

	/* 落葉 → パーティクルに変更 */
	@Override
	public void spawnParticle(ParticleTypes_CM particleType, double x, double y, double z, double vx, double vy, double vz) {

		Minecraft mc = Minecraft.getMinecraft();
		Entity entity = mc.getRenderViewEntity();
		World world = mc.world;

		if (entity != null && mc.effectRenderer != null) {

			int i = mc.gameSettings.particleSetting;

			if (i == 1 && world.rand.nextInt(3) == 0) {
				i = 2;
			}

			if (i > 1) return;

			double dx = entity.posX - x;
			double dy = entity.posY - y;
			double dz = entity.posZ - z;

			if (dx * dx + dy * dy + dz * dz > 1024.0D) return;

			Particle particle = ParticleFactory_CM.createParticle(particleType, world, x, y, z, vx, vy, vz);
			if (particle != null) {
				mc.effectRenderer.addEffect(particle);
			}
		}
	}

}
