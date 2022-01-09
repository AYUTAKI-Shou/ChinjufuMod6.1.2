package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.particle.AutumnParticle;
import com.ayutaki.chinjufumod.particle.IchohParticle;
import com.ayutaki.chinjufumod.particle.KaedeParticle;
import com.ayutaki.chinjufumod.particle.SakuraParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleManager_CM {

	@SuppressWarnings("resource")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void registerFactories(ParticleFactoryRegisterEvent event) {
		ParticleManager particleManager = Minecraft.getInstance().particleEngine;
		particleManager.register(ParticleTypes_CM.FALLSAKURA, SakuraParticle.Factory::new);
		particleManager.register(ParticleTypes_CM.FALLKAEDE, KaedeParticle.Factory::new);
		particleManager.register(ParticleTypes_CM.FALLICHOH, IchohParticle.Factory::new);
		particleManager.register(ParticleTypes_CM.FALLKARE, AutumnParticle.Factory::new);
	}

}
