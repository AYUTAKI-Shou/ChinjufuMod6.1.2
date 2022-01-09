package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleTypes_CM {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChinjufuMod.MOD_ID);

	public static BasicParticleType FALLSAKURA = register("fallsakura", new BasicParticleType(false));
	public static BasicParticleType FALLKAEDE = register("fallkaede", new BasicParticleType(false));
	public static BasicParticleType FALLICHOH = register("fallichoh", new BasicParticleType(false));
	public static BasicParticleType FALLKARE = register("fallkare", new BasicParticleType(false));

	///* Register *///
	private static BasicParticleType register(String name, BasicParticleType type) {
		PARTICLE_TYPES.register(name, () -> type);
		return type;
	}

}
