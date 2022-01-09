package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Gyorai61cm;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Ju87;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Ryusei;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Swordfish;
import com.ayutaki.chinjufumod.items.kansaiki.Item_TBF;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Tenzan;
import com.ayutaki.chinjufumod.items.kansaiki.Item_Type97;
import com.ayutaki.chinjufumod.items.shield.ItemShield_Kongou;
import com.ayutaki.chinjufumod.items.shield.ItemShield_Kuchiku;
import com.ayutaki.chinjufumod.items.shield.ItemShield_Mogami;
import com.ayutaki.chinjufumod.items.shield.ItemShield_Yura;
import com.ayutaki.chinjufumod.items.weapon.ItemAmmunition_KC;
import com.ayutaki.chinjufumod.items.weapon.ItemAmmunition_Medium;
import com.ayutaki.chinjufumod.items.weapon.ItemAmmunition_Small;
import com.ayutaki.chinjufumod.items.weapon.ItemKoukakuHou100;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou127;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou155;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou203;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou203SKC34;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou356;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou356S3;
import com.ayutaki.chinjufumod.items.weapon.ItemRensouHou380;
import com.ayutaki.chinjufumod.items.weapon.ItemShigureHou;
import com.ayutaki.chinjufumod.items.weapon.ItemSwordIchoh;
import com.ayutaki.chinjufumod.items.weapon.ItemSwordKaede;
import com.ayutaki.chinjufumod.items.weapon.ItemSwordSakura;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.client.model.ModelLoader;

public class Items_Weapon {

	public static Item AMMUNITION_KC, AMMUNITION_MEDIUM, AMMUNITION_SMALL;
	public static Item CARTRIDGE_KC, CARTRIDGE_MEDIUM, CARTRIDGE_SMALL;

	public static Item RENSOUHOU_127, SHIGUREHOU, KOUKAKUHOU_100;
	public static Item RENSOUHOU_155, RENSOUHOU_203, RENSOUHOU_SKC, RENSOUHOU_356, RENSOUHOU_356S3, RENSOUHOU_380;

	public static Item TYPE97KK, TENZAN, RYUSEI, JU87, TBF, SWORDFISH;
	public static Item GYORAI_61cm;
	public static Item SHIELD_kuchiku, SHIELD_yura, SHIELD_mogami, SHIELD_kongou;

	public static Item SWORD_sakura, SWORD_ichoh, SWORD_kaede;


	public static void init() {

		AMMUNITION_KC = new ItemAmmunition_KC().setRegistryName("item_ammunition_kc").setUnlocalizedName("item_ammunition_kc").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AMMUNITION_MEDIUM = new ItemAmmunition_Medium().setRegistryName("item_ammunition_medium").setUnlocalizedName("item_ammunition_medium").setCreativeTab(ChinjufuModTabs.CMARMOR);
		AMMUNITION_SMALL = new ItemAmmunition_Small().setRegistryName("item_ammunition_small").setUnlocalizedName("item_ammunition_small").setCreativeTab(ChinjufuModTabs.CMARMOR);

		CARTRIDGE_KC = new Item().setRegistryName("item_cartridge_kc").setUnlocalizedName("item_cartridge_kc");
		CARTRIDGE_MEDIUM = new Item().setRegistryName("item_cartridge_medium").setUnlocalizedName("item_cartridge_medium");
		CARTRIDGE_SMALL = new Item().setRegistryName("item_cartridge_small").setUnlocalizedName("item_cartridge_small");

		RENSOUHOU_127 = new ItemRensouHou127().setRegistryName("item_rensouhou127").setUnlocalizedName("item_rensouhou127").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIGUREHOU = new ItemShigureHou().setRegistryName("item_shigurehou").setUnlocalizedName("item_shigurehou").setCreativeTab(ChinjufuModTabs.CMARMOR);
		KOUKAKUHOU_100 = new ItemKoukakuHou100().setRegistryName("item_koukakuhou100").setUnlocalizedName("item_koukakuhou100").setCreativeTab(ChinjufuModTabs.CMARMOR);

		RENSOUHOU_155 = new ItemRensouHou155().setRegistryName("item_rensouhou155").setUnlocalizedName("item_rensouhou155").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RENSOUHOU_203 = new ItemRensouHou203().setRegistryName("item_rensouhou203").setUnlocalizedName("item_rensouhou203").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RENSOUHOU_SKC = new ItemRensouHou203SKC34().setRegistryName("item_rensouhou203_skc34").setUnlocalizedName("item_rensouhou203_skc34").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RENSOUHOU_356 = new ItemRensouHou356().setRegistryName("item_rensouhou356").setUnlocalizedName("item_rensouhou356").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RENSOUHOU_356S3 = new ItemRensouHou356S3().setRegistryName("item_rensouhou356_s3").setUnlocalizedName("item_rensouhou356_s3").setCreativeTab(ChinjufuModTabs.CMARMOR);
		RENSOUHOU_380 = new ItemRensouHou380().setRegistryName("item_rensouhou380").setUnlocalizedName("item_rensouhou380").setCreativeTab(ChinjufuModTabs.CMARMOR);

		TYPE97KK = new Item_Type97("item_kk_type97");
		TENZAN = new Item_Tenzan("item_kk_tenzan");
		RYUSEI = new Item_Ryusei("item_kk_ryusei");
		JU87 = new Item_Ju87("item_kk_ju87");
		TBF = new Item_TBF("item_kk_tbf");
		SWORDFISH = new Item_Swordfish("item_kk_swordfish");
		GYORAI_61cm = new Item_Gyorai61cm().setRegistryName("item_gyorai_61cm").setUnlocalizedName("item_gyorai_61cm");

		SHIELD_kuchiku = new ItemShield_Kuchiku().setRegistryName("item_shield_kuchiku").setUnlocalizedName("item_shield_kuchiku").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIELD_yura = new ItemShield_Yura().setRegistryName("item_shield_yura").setUnlocalizedName("item_shield_yura").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIELD_mogami = new ItemShield_Mogami().setRegistryName("item_shield_mogami").setUnlocalizedName("item_shield_mogami").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SHIELD_kongou = new ItemShield_Kongou().setRegistryName("item_shield_kongou").setUnlocalizedName("item_shield_kongou").setCreativeTab(ChinjufuModTabs.CMARMOR);

		SWORD_sakura = new ItemSwordSakura(ToolMaterial.WOOD).setRegistryName("item_sword_sakura").setUnlocalizedName("item_sword_sakura").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SWORD_ichoh = new ItemSwordIchoh(ToolMaterial.WOOD).setRegistryName("item_sword_ichoh").setUnlocalizedName("item_sword_ichoh").setCreativeTab(ChinjufuModTabs.CMARMOR);
		SWORD_kaede = new ItemSwordKaede(ToolMaterial.WOOD).setRegistryName("item_sword_kaede").setUnlocalizedName("item_sword_kaede").setCreativeTab(ChinjufuModTabs.CMARMOR);

	}

	public static void register() {

		registerItem(AMMUNITION_KC);
		registerItem(AMMUNITION_MEDIUM);
		registerItem(AMMUNITION_SMALL);
		registerItem(CARTRIDGE_KC);
		registerItem(CARTRIDGE_MEDIUM);
		registerItem(CARTRIDGE_SMALL);

		registerItem(RENSOUHOU_127);
		registerItem(SHIGUREHOU);
		registerItem(KOUKAKUHOU_100);

		registerItem(RENSOUHOU_155);
		registerItem(RENSOUHOU_203);
		registerItem(RENSOUHOU_SKC);
		registerItem(RENSOUHOU_356);
		registerItem(RENSOUHOU_356S3);
		registerItem(RENSOUHOU_380);

		registerItem(TYPE97KK);
		registerItem(TENZAN);
		registerItem(RYUSEI);
		registerItem(JU87);
		registerItem(TBF);
		registerItem(SWORDFISH);
		registerItem(GYORAI_61cm);

		registerItem(SHIELD_kuchiku);
		registerItem(SHIELD_yura);
		registerItem(SHIELD_mogami);
		registerItem(SHIELD_kongou);

		registerItem(SWORD_sakura);
		registerItem(SWORD_ichoh);
		registerItem(SWORD_kaede);

	}

	public static void registerItem(Item item) {
		RegisterHandler_CM.Items.ITEMS.add(item);
	}


	public static void registerRenders() {

		registerRender(AMMUNITION_KC);
		registerRender(AMMUNITION_MEDIUM);
		registerRender(AMMUNITION_SMALL);
		registerRender(CARTRIDGE_KC);
		registerRender(CARTRIDGE_MEDIUM);
		registerRender(CARTRIDGE_SMALL);

		registerRender(RENSOUHOU_127);
		registerRender(SHIGUREHOU);
		registerRender(KOUKAKUHOU_100);

		registerRender(RENSOUHOU_155);
		registerRender(RENSOUHOU_203);
		registerRender(RENSOUHOU_SKC);
		registerRender(RENSOUHOU_356);
		registerRender(RENSOUHOU_356S3);
		registerRender(RENSOUHOU_380);

		registerRender(TYPE97KK);
		registerRender(TENZAN);
		registerRender(RYUSEI);
		registerRender(JU87);
		registerRender(TBF);
		registerRender(SWORDFISH);
		registerRender(GYORAI_61cm);

		registerRender(SHIELD_kuchiku);
		registerRender(SHIELD_yura);
		registerRender(SHIELD_mogami);
		registerRender(SHIELD_kongou);

		registerRender(SWORD_sakura);
		registerRender(SWORD_ichoh);
		registerRender(SWORD_kaede);

	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}

}
