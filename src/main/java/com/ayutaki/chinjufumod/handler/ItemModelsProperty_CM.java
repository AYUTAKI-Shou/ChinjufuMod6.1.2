package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Weapon;

import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ItemModelsProperty_CM {

	///* Register *///
	public static void register() {

		ItemModelsProperties.register(Items_Teatime.CURRY, new ResourceLocation("eat"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Teatime.TEACUP, new ResourceLocation("drink"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
		
		/* ItemModelsProperties.register(Items_Teatime.TOAMI, new ResourceLocation("throw"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } ); */

		/* Small */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_127, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_127, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIGUREHOU, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.SHIGUREHOU, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );


		ItemModelsProperties.register(Items_Weapon.KOUKAKUHOU_100, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.KOUKAKUHOU_100, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Middle */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_155, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_155, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_203, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_203, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );


		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_SKC, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_SKC, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Large */
		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356S3, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_356S3, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );


		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_380, new ResourceLocation("pull"), (stack, worldIn, entity) -> {
		if (entity == null) {
			return 0.0F;
		}
		else {
			return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
		} } );

		ItemModelsProperties.register(Items_Weapon.RENSOUHOU_380, new ResourceLocation("pulling"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		/* Shield */
		ItemModelsProperties.register(Items_Weapon.SHIELD_kuchiku, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_yura, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_mogami, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );

		ItemModelsProperties.register(Items_Weapon.SHIELD_kongou, new ResourceLocation("blocking"), (stack, worldIn, entity) -> {
			return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F; } );
	}

}
