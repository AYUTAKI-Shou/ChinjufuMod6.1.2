package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.items.armor.AkagiArmor;
import com.ayutaki.chinjufumod.items.armor.AkagiArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.CMArmorMaterial;
import com.ayutaki.chinjufumod.items.armor.FubukiArmor;
import com.ayutaki.chinjufumod.items.armor.FubukiArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.KagaArmor;
import com.ayutaki.chinjufumod.items.armor.KagaArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.KasumiArmor;
import com.ayutaki.chinjufumod.items.armor.KasumiArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.KongouArmor;
import com.ayutaki.chinjufumod.items.armor.KongouArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.MogamiArmor;
import com.ayutaki.chinjufumod.items.armor.MogamiArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.RyujouArmor;
import com.ayutaki.chinjufumod.items.armor.RyujouArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.SendaiArmor;
import com.ayutaki.chinjufumod.items.armor.SendaiArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.ShigureArmor;
import com.ayutaki.chinjufumod.items.armor.ShigureArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.ShiratsuyuArmor;
import com.ayutaki.chinjufumod.items.armor.ShiratsuyuArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.ToneArmor;
import com.ayutaki.chinjufumod.items.armor.ToneArmor_Kai;
import com.ayutaki.chinjufumod.items.armor.YuraArmor;
import com.ayutaki.chinjufumod.items.armor.YuraArmor_Kai;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Armor {

	@SuppressWarnings("deprecation")
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	/* Destroyer */
	public static Item FUBUKI_HELMET = register("item_fubuki_helmet", new FubukiArmor(CMArmorMaterial.FUBUKI, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item FUBUKI_CHESTPLATE = register("item_fubuki_chestplate", new FubukiArmor(CMArmorMaterial.FUBUKI, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item FUBUKI_LEGGINGS = register("item_fubuki_leggings", new FubukiArmor(CMArmorMaterial.FUBUKI, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item FUBUKI_BOOTS = register("item_fubuki_boots", new FubukiArmor(CMArmorMaterial.FUBUKI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item FUBUKI_BOOTS_KAI = register("item_fubuki_bootskai", new FubukiArmor_Kai(CMArmorMaterial.FUBUKI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item KASUMI_HELMET = register("item_kasumi_helmet", new KasumiArmor(CMArmorMaterial.KASUMI, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KASUMI_CHESTPLATE = register("item_kasumi_chestplate", new KasumiArmor(CMArmorMaterial.KASUMI, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KASUMI_LEGGINGS = register("item_kasumi_leggings", new KasumiArmor(CMArmorMaterial.KASUMI, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KASUMI_BOOTS = register("item_kasumi_boots", new KasumiArmor(CMArmorMaterial.KASUMI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KASUMI_BOOTS_KAI = register("item_kasumi_bootskai", new KasumiArmor_Kai(CMArmorMaterial.KASUMI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item SHIRATSUYU_HELMET = register("item_shiratsuyu_helmet", new ShiratsuyuArmor(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIRATSUYU_CHESTPLATE = register("item_shiratsuyu_chestplate", new ShiratsuyuArmor(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIRATSUYU_LEGGINGS = register("item_shiratsuyu_leggings", new ShiratsuyuArmor(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIRATSUYU_BOOTS = register("item_shiratsuyu_boots", new ShiratsuyuArmor(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIRATSUYU_BOOTS_KAI = register("item_shiratsuyu_bootskai", new ShiratsuyuArmor_Kai(CMArmorMaterial.SHIRATSUYU, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item SHIGURE_HELMET = register("item_shigure_helmet", new ShigureArmor(CMArmorMaterial.SHIGURE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIGURE_CHESTPLATE = register("item_shigure_chestplate", new ShigureArmor(CMArmorMaterial.SHIGURE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIGURE_LEGGINGS = register("item_shigure_leggings", new ShigureArmor(CMArmorMaterial.SHIGURE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIGURE_BOOTS = register("item_shigure_boots", new ShigureArmor(CMArmorMaterial.SHIGURE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SHIGURE_BOOTS_KAI = register("item_shigure_bootskai", new ShigureArmor_Kai(CMArmorMaterial.SHIGURE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));


	/* Cruiser */
	public static Item SENDAI_HELMET = register("item_sendai_helmet", new SendaiArmor(CMArmorMaterial.SENDAI, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SENDAI_CHESTPLATE = register("item_sendai_chestplate", new SendaiArmor(CMArmorMaterial.SENDAI, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SENDAI_LEGGINGS = register("item_sendai_leggings", new SendaiArmor(CMArmorMaterial.SENDAI, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SENDAI_BOOTS = register("item_sendai_boots", new SendaiArmor(CMArmorMaterial.SENDAI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item SENDAI_BOOTS_KAI = register("item_sendai_bootskai", new SendaiArmor_Kai(CMArmorMaterial.SENDAI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item YURA_HELMET = register("item_yura_helmet", new YuraArmor(CMArmorMaterial.YURA, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item YURA_CHESTPLATE = register("item_yura_chestplate", new YuraArmor(CMArmorMaterial.YURA, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item YURA_LEGGINGS = register("item_yura_leggings", new YuraArmor(CMArmorMaterial.YURA, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item YURA_BOOTS = register("item_yura_boots", new YuraArmor(CMArmorMaterial.YURA, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item YURA_BOOTS_KAI = register("item_yura_bootskai", new YuraArmor_Kai(CMArmorMaterial.YURA, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	/* Heavy Cruiser */
	public static Item MOGAMI_HELMET = register("item_mogami_helmet", new MogamiArmor(CMArmorMaterial.MOGAMI, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item MOGAMI_CHESTPLATE = register("item_mogami_chestplate", new MogamiArmor(CMArmorMaterial.MOGAMI, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item MOGAMI_LEGGINGS = register("item_mogami_leggings", new MogamiArmor(CMArmorMaterial.MOGAMI, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item MOGAMI_BOOTS = register("item_mogami_boots", new MogamiArmor(CMArmorMaterial.MOGAMI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item MOGAMI_BOOTS_KAI = register("item_mogami_bootskai", new MogamiArmor_Kai(CMArmorMaterial.MOGAMI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item TONE_HELMET = register("item_tone_helmet", new ToneArmor(CMArmorMaterial.TONE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item TONE_CHESTPLATE = register("item_tone_chestplate", new ToneArmor(CMArmorMaterial.TONE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item TONE_LEGGINGS = register("item_tone_leggings", new ToneArmor(CMArmorMaterial.TONE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item TONE_BOOTS = register("item_tone_boots", new ToneArmor(CMArmorMaterial.TONE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item TONE_BOOTS_KAI = register("item_tone_bootskai", new ToneArmor_Kai(CMArmorMaterial.TONE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	/* Aircraft carrier */
	public static Item RJ_HELMET = register("item_ryujou_helmet", new RyujouArmor(CMArmorMaterial.RJ, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item RJ_CHESTPLATE = register("item_ryujou_chestplate", new RyujouArmor(CMArmorMaterial.RJ, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item RJ_LEGGINGS = register("item_ryujou_leggings", new RyujouArmor(CMArmorMaterial.RJ, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item RJ_BOOTS = register("item_ryujou_boots", new RyujouArmor(CMArmorMaterial.RJ, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item RJ_BOOTS_KAI = register("item_ryujou_bootskai", new RyujouArmor_Kai(CMArmorMaterial.RJ, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item AKAGI_HELMET = register("item_akagi_helmet", new AkagiArmor(CMArmorMaterial.AKAGI, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item AKAGI_CHESTPLATE = register("item_akagi_chestplate", new AkagiArmor(CMArmorMaterial.AKAGI, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item AKAGI_LEGGINGS = register("item_akagi_leggings", new AkagiArmor(CMArmorMaterial.AKAGI, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item AKAGI_BOOTS = register("item_akagi_boots", new AkagiArmor(CMArmorMaterial.AKAGI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item AKAGI_BOOTS_KAI = register("item_akagi_bootskai", new AkagiArmor_Kai(CMArmorMaterial.AKAGI, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	public static Item KAGA_HELMET = register("item_kaga_helmet", new KagaArmor(CMArmorMaterial.KAGA, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KAGA_CHESTPLATE = register("item_kaga_chestplate", new KagaArmor(CMArmorMaterial.KAGA, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KAGA_LEGGINGS = register("item_kaga_leggings", new KagaArmor(CMArmorMaterial.KAGA, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KAGA_BOOTS = register("item_kaga_boots", new KagaArmor(CMArmorMaterial.KAGA, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KAGA_BOOTS_KAI = register("item_kaga_bootskai", new KagaArmor_Kai(CMArmorMaterial.KAGA, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	/* Battleship */
	public static Item KONGOU_HELMET = register("item_kongou_helmet", new KongouArmor(CMArmorMaterial.KONGOU, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KONGOU_CHESTPLATE = register("item_kongou_chestplate", new KongouArmor(CMArmorMaterial.KONGOU, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KONGOU_LEGGINGS = register("item_kongou_leggings", new KongouArmor(CMArmorMaterial.KONGOU, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KONGOU_BOOTS = register("item_kongou_boots", new KongouArmor(CMArmorMaterial.KONGOU, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));
	public static Item KONGOU_BOOTS_KAI = register("item_kongou_bootskai", new KongouArmor_Kai(CMArmorMaterial.KONGOU, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroups_CM.CMARMOR)));

	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}

}
