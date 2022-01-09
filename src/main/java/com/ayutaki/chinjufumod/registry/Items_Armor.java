package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.armor.ItemAkagiArmor;
import com.ayutaki.chinjufumod.items.armor.ItemAkagiArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemFubukiArmor;
import com.ayutaki.chinjufumod.items.armor.ItemFubukiArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemKagaArmor;
import com.ayutaki.chinjufumod.items.armor.ItemKagaArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemKasumiArmor;
import com.ayutaki.chinjufumod.items.armor.ItemKasumiArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemKongouArmor;
import com.ayutaki.chinjufumod.items.armor.ItemKongouArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemMogamiArmor;
import com.ayutaki.chinjufumod.items.armor.ItemMogamiArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemRyujouArmor;
import com.ayutaki.chinjufumod.items.armor.ItemRyujouArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemSendaiArmor;
import com.ayutaki.chinjufumod.items.armor.ItemSendaiArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemShigureArmor;
import com.ayutaki.chinjufumod.items.armor.ItemShigureArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemShiratsuyuArmor;
import com.ayutaki.chinjufumod.items.armor.ItemShiratsuyuArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemToneArmor;
import com.ayutaki.chinjufumod.items.armor.ItemToneArmor_kai;
import com.ayutaki.chinjufumod.items.armor.ItemYuraArmor;
import com.ayutaki.chinjufumod.items.armor.ItemYuraArmor_kai;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Armor {

	public static Item FUBUKI_HELMET, FUBUKI_CHESTPLATE, FUBUKI_LEGGINGS, FUBUKI_BOOTS, FUBUKI_BOOTS_KAI;
	public static Item KASUMI_HELMET, KASUMI_CHESTPLATE, KASUMI_LEGGINGS, KASUMI_BOOTS, KASUMI_BOOTS_KAI;
	public static Item SHIGURE_HELMET, SHIGURE_CHESTPLATE, SHIGURE_LEGGINGS, SHIGURE_BOOTS, SHIGURE_BOOTS_KAI;
	public static Item SHIRATSUYU_HELMET, SHIRATSUYU_CHESTPLATE, SHIRATSUYU_LEGGINGS, SHIRATSUYU_BOOTS, SHIRATSUYU_BOOTS_KAI;

	public static Item SENDAI_HELMET, SENDAI_CHESTPLATE, SENDAI_LEGGINGS, SENDAI_BOOTS, SENDAI_BOOTS_KAI;
	public static Item YURA_HELMET, YURA_CHESTPLATE, YURA_LEGGINGS, YURA_BOOTS, YURA_BOOTS_KAI;
	public static Item MOGAMI_HELMET, MOGAMI_CHESTPLATE, MOGAMI_LEGGINGS, MOGAMI_BOOTS, MOGAMI_BOOTS_KAI;
	public static Item TONE_HELMET, TONE_CHESTPLATE, TONE_LEGGINGS, TONE_BOOTS, TONE_BOOTS_KAI;

	public static Item KONGOU_HELMET, KONGOU_CHESTPLATE, KONGOU_LEGGINGS, KONGOU_BOOTS, KONGOU_BOOTS_KAI;
	public static Item RJ_HELMET, RJ_CHESTPLATE, RJ_LEGGINGS, RJ_BOOTS, RJ_BOOTS_KAI;
	public static Item AKAGI_HELMET, AKAGI_CHESTPLATE, AKAGI_LEGGINGS, AKAGI_BOOTS, AKAGI_BOOTS_KAI;
	public static Item KAGA_HELMET, KAGA_CHESTPLATE, KAGA_LEGGINGS, KAGA_BOOTS, KAGA_BOOTS_KAI;



	public static void init() {
		/* 駆逐艦 */
		FUBUKI_HELMET = new ItemFubukiArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_fubuki_helmet").setUnlocalizedName("item_fubuki_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		FUBUKI_CHESTPLATE = new ItemFubukiArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_fubuki_chestplate").setUnlocalizedName("item_fubuki_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		FUBUKI_LEGGINGS = new ItemFubukiArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_fubuki_leggings").setUnlocalizedName("item_fubuki_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		FUBUKI_BOOTS = new ItemFubukiArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_fubuki_boots").setUnlocalizedName("item_fubuki_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		FUBUKI_BOOTS_KAI = new ItemFubukiArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_fubuki_bootskai").setUnlocalizedName("item_fubuki_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		KASUMI_HELMET = new ItemKasumiArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_kasumi_helmet").setUnlocalizedName("item_kasumi_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KASUMI_CHESTPLATE = new ItemKasumiArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_kasumi_chestplate").setUnlocalizedName("item_kasumi_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KASUMI_LEGGINGS = new ItemKasumiArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_kasumi_leggings").setUnlocalizedName("item_kasumi_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KASUMI_BOOTS = new ItemKasumiArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_kasumi_boots").setUnlocalizedName("item_kasumi_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KASUMI_BOOTS_KAI = new ItemKasumiArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_kasumi_bootskai").setUnlocalizedName("item_kasumi_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		SHIGURE_HELMET = new ItemShigureArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_shigure_helmet").setUnlocalizedName("item_shigure_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIGURE_CHESTPLATE = new ItemShigureArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_shigure_chestplate").setUnlocalizedName("item_shigure_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIGURE_LEGGINGS = new ItemShigureArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_shigure_leggings").setUnlocalizedName("item_shigure_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIGURE_BOOTS = new ItemShigureArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_shigure_boots").setUnlocalizedName("item_shigure_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIGURE_BOOTS_KAI = new ItemShigureArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_shigure_bootskai").setUnlocalizedName("item_shigure_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		SHIRATSUYU_HELMET = new ItemShiratsuyuArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_shiratsuyu_helmet").setUnlocalizedName("item_shiratsuyu_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIRATSUYU_CHESTPLATE = new ItemShiratsuyuArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_shiratsuyu_chestplate").setUnlocalizedName("item_shiratsuyu_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIRATSUYU_LEGGINGS = new ItemShiratsuyuArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_shiratsuyu_leggings").setUnlocalizedName("item_shiratsuyu_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIRATSUYU_BOOTS = new ItemShiratsuyuArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_shiratsuyu_boots").setUnlocalizedName("item_shiratsuyu_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIRATSUYU_BOOTS_KAI = new ItemShiratsuyuArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_shiratsuyu_bootskai").setUnlocalizedName("item_shiratsuyu_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		/* 軽巡洋艦 */
		SENDAI_HELMET = new ItemSendaiArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_sendai_helmet").setUnlocalizedName("item_sendai_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SENDAI_CHESTPLATE = new ItemSendaiArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_sendai_chestplate").setUnlocalizedName("item_sendai_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SENDAI_LEGGINGS = new ItemSendaiArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_sendai_leggings").setUnlocalizedName("item_sendai_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SENDAI_BOOTS = new ItemSendaiArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_sendai_boots").setUnlocalizedName("item_sendai_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SENDAI_BOOTS_KAI = new ItemSendaiArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_sendai_bootskai").setUnlocalizedName("item_sendai_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		YURA_HELMET = new ItemYuraArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_yura_helmet").setUnlocalizedName("item_yura_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		YURA_CHESTPLATE = new ItemYuraArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_yura_chestplate").setUnlocalizedName("item_yura_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		YURA_LEGGINGS = new ItemYuraArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_yura_leggings").setUnlocalizedName("item_yura_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		YURA_BOOTS = new ItemYuraArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_yura_boots").setUnlocalizedName("item_yura_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		YURA_BOOTS_KAI = new ItemYuraArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_yura_bootskai").setUnlocalizedName("item_yura_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		/* 重巡洋艦 */
		MOGAMI_HELMET = new ItemMogamiArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_mogami_helmet").setUnlocalizedName("item_mogami_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		MOGAMI_CHESTPLATE = new ItemMogamiArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_mogami_chestplate").setUnlocalizedName("item_mogami_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		MOGAMI_LEGGINGS = new ItemMogamiArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_mogami_leggings").setUnlocalizedName("item_mogami_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		MOGAMI_BOOTS = new ItemMogamiArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_mogami_boots").setUnlocalizedName("item_mogami_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		MOGAMI_BOOTS_KAI = new ItemMogamiArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_mogami_bootskai").setUnlocalizedName("item_mogami_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		TONE_HELMET = new ItemToneArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_tone_helmet").setUnlocalizedName("item_tone_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		TONE_CHESTPLATE = new ItemToneArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_tone_chestplate").setUnlocalizedName("item_tone_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		TONE_LEGGINGS = new ItemToneArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_tone_leggings").setUnlocalizedName("item_tone_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		TONE_BOOTS = new ItemToneArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_tone_boots").setUnlocalizedName("item_tone_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		TONE_BOOTS_KAI = new ItemToneArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_tone_bootskai").setUnlocalizedName("item_tone_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		/* 戦艦 */
		KONGOU_HELMET = new ItemKongouArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_kongou_helmet").setUnlocalizedName("item_kongou_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KONGOU_CHESTPLATE = new ItemKongouArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_kongou_chestplate").setUnlocalizedName("item_kongou_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KONGOU_LEGGINGS = new ItemKongouArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_kongou_leggings").setUnlocalizedName("item_kongou_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KONGOU_BOOTS = new ItemKongouArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_kongou_boots").setUnlocalizedName("item_kongou_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KONGOU_BOOTS_KAI = new ItemKongouArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_kongou_bootskai").setUnlocalizedName("item_kongou_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		/* 空母 */
		RJ_HELMET = new ItemRyujouArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_ryujou_helmet").setUnlocalizedName("item_ryujou_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RJ_CHESTPLATE = new ItemRyujouArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_ryujou_chestplate").setUnlocalizedName("item_ryujou_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RJ_LEGGINGS = new ItemRyujouArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_ryujou_leggings").setUnlocalizedName("item_ryujou_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RJ_BOOTS = new ItemRyujouArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_ryujou_boots").setUnlocalizedName("item_ryujou_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RJ_BOOTS_KAI = new ItemRyujouArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_ryujou_bootskai").setUnlocalizedName("item_ryujou_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		AKAGI_HELMET = new ItemAkagiArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_akagi_helmet").setUnlocalizedName("item_akagi_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AKAGI_CHESTPLATE = new ItemAkagiArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_akagi_chestplate").setUnlocalizedName("item_akagi_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AKAGI_LEGGINGS = new ItemAkagiArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_akagi_leggings").setUnlocalizedName("item_akagi_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AKAGI_BOOTS = new ItemAkagiArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_akagi_boots").setUnlocalizedName("item_akagi_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AKAGI_BOOTS_KAI = new ItemAkagiArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_akagi_bootskai").setUnlocalizedName("item_akagi_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);

		KAGA_HELMET = new ItemKagaArmor(1, EntityEquipmentSlot.HEAD).setRegistryName("item_kaga_helmet").setUnlocalizedName("item_kaga_helmet").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KAGA_CHESTPLATE = new ItemKagaArmor(1,EntityEquipmentSlot.CHEST).setRegistryName("item_kaga_chestplate").setUnlocalizedName("item_kaga_chestplate").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KAGA_LEGGINGS = new ItemKagaArmor(2, EntityEquipmentSlot.LEGS).setRegistryName("item_kaga_leggings").setUnlocalizedName("item_kaga_leggings").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KAGA_BOOTS = new ItemKagaArmor(1,EntityEquipmentSlot.FEET).setRegistryName("item_kaga_boots").setUnlocalizedName("item_kaga_boots").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KAGA_BOOTS_KAI = new ItemKagaArmor_kai(1,EntityEquipmentSlot.FEET).setRegistryName("item_kaga_bootskai").setUnlocalizedName("item_kaga_bootskai").setCreativeTab(ChinjufuModTabs.CMARMOR);


	}

	public static void register() {

		registerItem(FUBUKI_HELMET);
		registerItem(FUBUKI_CHESTPLATE);
		registerItem(FUBUKI_LEGGINGS);
		registerItem(FUBUKI_BOOTS);
		registerItem(FUBUKI_BOOTS_KAI);
		registerItem(KASUMI_HELMET);
		registerItem(KASUMI_CHESTPLATE);
		registerItem(KASUMI_LEGGINGS);
		registerItem(KASUMI_BOOTS);
		registerItem(KASUMI_BOOTS_KAI);
		registerItem(SHIGURE_HELMET);
		registerItem(SHIGURE_CHESTPLATE);
		registerItem(SHIGURE_LEGGINGS);
		registerItem(SHIGURE_BOOTS);
		registerItem(SHIGURE_BOOTS_KAI);
		registerItem(SHIRATSUYU_HELMET);
		registerItem(SHIRATSUYU_CHESTPLATE);
		registerItem(SHIRATSUYU_LEGGINGS);
		registerItem(SHIRATSUYU_BOOTS);
		registerItem(SHIRATSUYU_BOOTS_KAI);

		registerItem(SENDAI_HELMET);
		registerItem(SENDAI_CHESTPLATE);
		registerItem(SENDAI_LEGGINGS);
		registerItem(SENDAI_BOOTS);
		registerItem(SENDAI_BOOTS_KAI);
		registerItem(YURA_HELMET);
		registerItem(YURA_CHESTPLATE);
		registerItem(YURA_LEGGINGS);
		registerItem(YURA_BOOTS);
		registerItem(YURA_BOOTS_KAI);
		registerItem(MOGAMI_HELMET);
		registerItem(MOGAMI_CHESTPLATE);
		registerItem(MOGAMI_LEGGINGS);
		registerItem(MOGAMI_BOOTS);
		registerItem(MOGAMI_BOOTS_KAI);
		registerItem(TONE_HELMET);
		registerItem(TONE_CHESTPLATE);
		registerItem(TONE_LEGGINGS);
		registerItem(TONE_BOOTS);
		registerItem(TONE_BOOTS_KAI);

		registerItem(KONGOU_HELMET);
		registerItem(KONGOU_CHESTPLATE);
		registerItem(KONGOU_LEGGINGS);
		registerItem(KONGOU_BOOTS);
		registerItem(KONGOU_BOOTS_KAI);

		registerItem(RJ_HELMET);
		registerItem(RJ_CHESTPLATE);
		registerItem(RJ_LEGGINGS);
		registerItem(RJ_BOOTS);
		registerItem(RJ_BOOTS_KAI);
		registerItem(AKAGI_HELMET);
		registerItem(AKAGI_CHESTPLATE);
		registerItem(AKAGI_LEGGINGS);
		registerItem(AKAGI_BOOTS);
		registerItem(AKAGI_BOOTS_KAI);
		registerItem(KAGA_HELMET);
		registerItem(KAGA_CHESTPLATE);
		registerItem(KAGA_LEGGINGS);
		registerItem(KAGA_BOOTS);
		registerItem(KAGA_BOOTS_KAI);

	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(FUBUKI_HELMET);
		registerRender(FUBUKI_CHESTPLATE);
		registerRender(FUBUKI_LEGGINGS);
		registerRender(FUBUKI_BOOTS);
		registerRender(FUBUKI_BOOTS_KAI);
		registerRender(KASUMI_HELMET);
		registerRender(KASUMI_CHESTPLATE);
		registerRender(KASUMI_LEGGINGS);
		registerRender(KASUMI_BOOTS);
		registerRender(KASUMI_BOOTS_KAI);
		registerRender(SHIGURE_HELMET);
		registerRender(SHIGURE_CHESTPLATE);
		registerRender(SHIGURE_LEGGINGS);
		registerRender(SHIGURE_BOOTS);
		registerRender(SHIGURE_BOOTS_KAI);
		registerRender(SHIRATSUYU_HELMET);
		registerRender(SHIRATSUYU_CHESTPLATE);
		registerRender(SHIRATSUYU_LEGGINGS);
		registerRender(SHIRATSUYU_BOOTS);
		registerRender(SHIRATSUYU_BOOTS_KAI);

		registerRender(SENDAI_HELMET);
		registerRender(SENDAI_CHESTPLATE);
		registerRender(SENDAI_LEGGINGS);
		registerRender(SENDAI_BOOTS);
		registerRender(SENDAI_BOOTS_KAI);
		registerRender(YURA_HELMET);
		registerRender(YURA_CHESTPLATE);
		registerRender(YURA_LEGGINGS);
		registerRender(YURA_BOOTS);
		registerRender(YURA_BOOTS_KAI);

		registerRender(MOGAMI_HELMET);
		registerRender(MOGAMI_CHESTPLATE);
		registerRender(MOGAMI_LEGGINGS);
		registerRender(MOGAMI_BOOTS);
		registerRender(MOGAMI_BOOTS_KAI);
		registerRender(TONE_HELMET);
		registerRender(TONE_CHESTPLATE);
		registerRender(TONE_LEGGINGS);
		registerRender(TONE_BOOTS);
		registerRender(TONE_BOOTS_KAI);

		registerRender(KONGOU_HELMET);
		registerRender(KONGOU_CHESTPLATE);
		registerRender(KONGOU_LEGGINGS);
		registerRender(KONGOU_BOOTS);
		registerRender(KONGOU_BOOTS_KAI);

		registerRender(RJ_HELMET);
		registerRender(RJ_CHESTPLATE);
		registerRender(RJ_LEGGINGS);
		registerRender(RJ_BOOTS);
		registerRender(RJ_BOOTS_KAI);
		registerRender(AKAGI_HELMET);
		registerRender(AKAGI_CHESTPLATE);
		registerRender(AKAGI_LEGGINGS);
		registerRender(AKAGI_BOOTS);
		registerRender(AKAGI_BOOTS_KAI);
		registerRender(KAGA_HELMET);
		registerRender(KAGA_CHESTPLATE);
		registerRender(KAGA_LEGGINGS);
		registerRender(KAGA_BOOTS);
		registerRender(KAGA_BOOTS_KAI);


	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
