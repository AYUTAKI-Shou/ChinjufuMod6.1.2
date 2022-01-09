package com.ayutaki.chinjufumod.handler;

import java.util.EnumMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.particle.AutumnParticle;
import com.ayutaki.chinjufumod.particle.IchohParticle;
import com.ayutaki.chinjufumod.particle.KaedeParticle;
import com.ayutaki.chinjufumod.particle.SakuraParticle;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class ParticleFactory_CM {

	private static final Map<ParticleTypes_CM, IParticleFactory> factories = new EnumMap<>(ParticleTypes_CM.class);

	static {
		factories.put(ParticleTypes_CM.FALLSAKURA, SakuraParticle::new);
		factories.put(ParticleTypes_CM.FALLKAEDE, KaedeParticle::new);
		factories.put(ParticleTypes_CM.FALLICHOH, IchohParticle::new);
		factories.put(ParticleTypes_CM.FALLKARE, AutumnParticle::new);
	}

	@Nullable
	public static Particle createParticle(ParticleTypes_CM particleType, World world, double x, double y, double z, double vx, double vy, double vz) {
		IParticleFactory factory = factories.get(particleType);
		return factory != null ? factory.createParticle(world, x, y, z, vx, vy, vz) : null;
	}

	@FunctionalInterface
	private interface IParticleFactory {
		Particle createParticle(World world, double x, double y, double z, double vx, double vy, double vz);
	}

}
