package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Large;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Medium;
import com.ayutaki.chinjufumod.entity.AmmoEntity_Small;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity2;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity3;
import com.ayutaki.chinjufumod.entity.Gyorai61cmEntity4;
import com.ayutaki.chinjufumod.entity.KK_Ju87Entity;
import com.ayutaki.chinjufumod.entity.KK_Ju87Entity2;
import com.ayutaki.chinjufumod.entity.KK_Ju87Entity3;
import com.ayutaki.chinjufumod.entity.KK_Ju87Entity4;
import com.ayutaki.chinjufumod.entity.KK_RyuseiEntity;
import com.ayutaki.chinjufumod.entity.KK_RyuseiEntity2;
import com.ayutaki.chinjufumod.entity.KK_RyuseiEntity3;
import com.ayutaki.chinjufumod.entity.KK_RyuseiEntity4;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity2;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity3;
import com.ayutaki.chinjufumod.entity.KK_SwordfishEntity4;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity2;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity3;
import com.ayutaki.chinjufumod.entity.KK_TBFEntity4;
import com.ayutaki.chinjufumod.entity.KK_TenzanEntity;
import com.ayutaki.chinjufumod.entity.KK_TenzanEntity2;
import com.ayutaki.chinjufumod.entity.KK_TenzanEntity3;
import com.ayutaki.chinjufumod.entity.KK_TenzanEntity4;
import com.ayutaki.chinjufumod.entity.KK_Type97Entity;
import com.ayutaki.chinjufumod.entity.KK_Type97Entity2;
import com.ayutaki.chinjufumod.entity.KK_Type97Entity3;
import com.ayutaki.chinjufumod.entity.KK_Type97Entity4;
import com.ayutaki.chinjufumod.entity.SitableEntity;
import com.ayutaki.chinjufumod.entity.ToamiEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypes_CM {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ChinjufuMod.MOD_ID);

	public static EntityType<SitableEntity> SITABLE = register("sitable", EntityType.Builder.of(SitableEntity::new, EntityClassification.MISC).sized(0.0F, 0.0F));

	/* Ammo ARROW.sized(0.5F, 0.5F) FIREBALL.sized(1.0F, 1.0F) SMALL_FIREBALL.sized(0.3125F, 0.3125F)*/
	public static EntityType<AmmoEntity_Small> AMMO_S = register("ammunition_small", EntityType.Builder.<AmmoEntity_Small>of(AmmoEntity_Small::new, EntityClassification.MISC).sized(0.5F, 0.5F));
	public static EntityType<AmmoEntity_Medium> AMMO_M = register("ammunition_medium", EntityType.Builder.<AmmoEntity_Medium>of(AmmoEntity_Medium::new, EntityClassification.MISC).sized(0.75F, 0.75F));
	public static EntityType<AmmoEntity_Large> AMMO_L = register("ammunition_large", EntityType.Builder.<AmmoEntity_Large>of(AmmoEntity_Large::new, EntityClassification.MISC).sized(1.0F, 1.0F));

	/* Aircraft */
	public static EntityType<KK_Type97Entity> TYPE97 = register("type97", EntityType.Builder.<KK_Type97Entity>of(KK_Type97Entity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Type97Entity2> TYPE97_2 = register("type97_2", EntityType.Builder.<KK_Type97Entity2>of(KK_Type97Entity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Type97Entity3> TYPE97_3 = register("type97_3", EntityType.Builder.<KK_Type97Entity3>of(KK_Type97Entity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Type97Entity4> TYPE97_4 = register("type97_4", EntityType.Builder.<KK_Type97Entity4>of(KK_Type97Entity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<KK_TenzanEntity> TENZAN = register("tenzan", EntityType.Builder.<KK_TenzanEntity>of(KK_TenzanEntity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TenzanEntity2> TENZAN2 = register("tenzan2", EntityType.Builder.<KK_TenzanEntity2>of(KK_TenzanEntity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TenzanEntity3> TENZAN3 = register("tenzan3", EntityType.Builder.<KK_TenzanEntity3>of(KK_TenzanEntity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TenzanEntity4> TENZAN4 = register("tenzan4", EntityType.Builder.<KK_TenzanEntity4>of(KK_TenzanEntity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<KK_RyuseiEntity> RYUSEI = register("ryusei", EntityType.Builder.<KK_RyuseiEntity>of(KK_RyuseiEntity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_RyuseiEntity2> RYUSEI2 = register("ryusei2", EntityType.Builder.<KK_RyuseiEntity2>of(KK_RyuseiEntity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_RyuseiEntity3> RYUSEI3 = register("ryusei3", EntityType.Builder.<KK_RyuseiEntity3>of(KK_RyuseiEntity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_RyuseiEntity4> RYUSEI4 = register("ryusei4", EntityType.Builder.<KK_RyuseiEntity4>of(KK_RyuseiEntity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<KK_Ju87Entity> JU87 = register("ju87", EntityType.Builder.<KK_Ju87Entity>of(KK_Ju87Entity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Ju87Entity2> JU87_2 = register("ju87_2", EntityType.Builder.<KK_Ju87Entity2>of(KK_Ju87Entity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Ju87Entity3> JU87_3 = register("ju87_3", EntityType.Builder.<KK_Ju87Entity3>of(KK_Ju87Entity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_Ju87Entity4> JU87_4 = register("ju87_4", EntityType.Builder.<KK_Ju87Entity4>of(KK_Ju87Entity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	public static EntityType<KK_TBFEntity> TBF = register("tbf", EntityType.Builder.<KK_TBFEntity>of(KK_TBFEntity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TBFEntity2> TBF2 = register("tbf2", EntityType.Builder.<KK_TBFEntity2>of(KK_TBFEntity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TBFEntity3> TBF3 = register("tbf3", EntityType.Builder.<KK_TBFEntity3>of(KK_TBFEntity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_TBFEntity4> TBF4 = register("tbf4", EntityType.Builder.<KK_TBFEntity4>of(KK_TBFEntity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));

	public static EntityType<KK_SwordfishEntity> SWORDFISH = register("swordfish", EntityType.Builder.<KK_SwordfishEntity>of(KK_SwordfishEntity::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_SwordfishEntity2> SWORDFISH2 = register("swordfish2", EntityType.Builder.<KK_SwordfishEntity2>of(KK_SwordfishEntity2::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_SwordfishEntity3> SWORDFISH3 = register("swordfish3", EntityType.Builder.<KK_SwordfishEntity3>of(KK_SwordfishEntity3::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<KK_SwordfishEntity4> SWORDFISH4 = register("swordfish4", EntityType.Builder.<KK_SwordfishEntity4>of(KK_SwordfishEntity4::new, EntityClassification.MISC)
			.sized(2.0F, 2.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));

	public static EntityType<Gyorai61cmEntity> GYORAI61 = register("gyorai", EntityType.Builder.<Gyorai61cmEntity>of(Gyorai61cmEntity::new, EntityClassification.MISC)
			.sized(1.0F, 1.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<Gyorai61cmEntity2> GYORAI61_2 = register("gyorai2", EntityType.Builder.<Gyorai61cmEntity2>of(Gyorai61cmEntity2::new, EntityClassification.MISC)
			.sized(1.0F, 1.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<Gyorai61cmEntity3> GYORAI61_3 = register("gyorai3", EntityType.Builder.<Gyorai61cmEntity3>of(Gyorai61cmEntity3::new, EntityClassification.MISC)
			.sized(1.0F, 1.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	public static EntityType<Gyorai61cmEntity4> GYORAI61_4 = register("gyorai4", EntityType.Builder.<Gyorai61cmEntity4>of(Gyorai61cmEntity4::new, EntityClassification.MISC)
			.sized(1.0F, 1.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));

	public static EntityType<ToamiEntity> TOAMI = register("toami", EntityType.Builder.<ToamiEntity>of(ToamiEntity::new, EntityClassification.MISC)
			.sized(3.0F, 3.0F).setTrackingRange(10).setUpdateInterval(10).setShouldReceiveVelocityUpdates(true));
	
	///* Register *///
	private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
		EntityType<T> type = builder.build(ChinjufuMod.MOD_ID + ":" + name);
		ENTITY_TYPES.register(name, () -> type);
		return type;
	}

}
