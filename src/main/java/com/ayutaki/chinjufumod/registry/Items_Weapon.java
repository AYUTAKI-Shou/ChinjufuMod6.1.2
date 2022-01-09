package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.items.kansaiki.Gyorai61cm;
import com.ayutaki.chinjufumod.items.kansaiki.Ju87;
import com.ayutaki.chinjufumod.items.kansaiki.Ryusei;
import com.ayutaki.chinjufumod.items.kansaiki.Swordfish;
import com.ayutaki.chinjufumod.items.kansaiki.TBF;
import com.ayutaki.chinjufumod.items.kansaiki.Tenzan;
import com.ayutaki.chinjufumod.items.kansaiki.Type97;
import com.ayutaki.chinjufumod.items.shield.Shield_CM;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Large;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Medium;
import com.ayutaki.chinjufumod.items.weapon.Ammo_Small;
import com.ayutaki.chinjufumod.items.weapon.KoukakuHou100;
import com.ayutaki.chinjufumod.items.weapon.RensouHou127;
import com.ayutaki.chinjufumod.items.weapon.RensouHou155;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203;
import com.ayutaki.chinjufumod.items.weapon.RensouHou203SKC34;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356;
import com.ayutaki.chinjufumod.items.weapon.RensouHou356S3;
import com.ayutaki.chinjufumod.items.weapon.RensouHou380;
import com.ayutaki.chinjufumod.items.weapon.ShigureHou;
import com.ayutaki.chinjufumod.items.weapon.Sword_CM;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ChinjufuMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Items_Weapon {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChinjufuMod.MOD_ID);

	public static Item AMMUNITION_L = register("item_ammunition_kc", new Ammo_Large(new Item.Properties().tab(ItemGroups_CM.CMARMOR)));
	public static Item AMMUNITION_M = register("item_ammunition_medium", new Ammo_Medium(new Item.Properties().tab(ItemGroups_CM.CMARMOR)));
	public static Item AMMUNITION_S = register("item_ammunition_small", new Ammo_Small(new Item.Properties().tab(ItemGroups_CM.CMARMOR)));
	public static Item CARTRIDGE_L = register("item_cartridge_kc", new Item(new Item.Properties()));
	public static Item CARTRIDGE_M = register("item_cartridge_medium", new Item(new Item.Properties()));
	public static Item CARTRIDGE_S = register("item_cartridge_small", new Item(new Item.Properties()));

	/* durability + 100 */
	public static Item RENSOUHOU_127 = register("item_rensouhou127", new RensouHou127(new Item.Properties().durability(1100).tab(ItemGroups_CM.CMARMOR)));
	public static Item SHIGUREHOU = register("item_shigurehou", new ShigureHou(new Item.Properties().durability(1100).tab(ItemGroups_CM.CMARMOR)));
	public static Item KOUKAKUHOU_100 = register("item_koukakuhou100", new KoukakuHou100(new Item.Properties().durability(1100).tab(ItemGroups_CM.CMARMOR)));

	public static Item RENSOUHOU_155 = register("item_rensouhou155", new RensouHou155(new Item.Properties().durability(2960).tab(ItemGroups_CM.CMARMOR)));
	public static Item RENSOUHOU_203 = register("item_rensouhou203", new RensouHou203(new Item.Properties().durability(2600).tab(ItemGroups_CM.CMARMOR)));
	public static Item RENSOUHOU_SKC = register("item_rensouhou203_skc34", new RensouHou203SKC34(new Item.Properties().durability(2100).tab(ItemGroups_CM.CMARMOR)));

	public static Item RENSOUHOU_356 = register("item_rensouhou356", new RensouHou356(new Item.Properties().durability(5100).tab(ItemGroups_CM.CMARMOR)));
	public static Item RENSOUHOU_356S3 = register("item_rensouhou356_s3", new RensouHou356S3(new Item.Properties().durability(4850).tab(ItemGroups_CM.CMARMOR)));
	public static Item RENSOUHOU_380 = register("item_rensouhou380", new RensouHou380(new Item.Properties().durability(4600).tab(ItemGroups_CM.CMARMOR)));

	public static Item TYPE97KK = register("item_kk_type97", new Type97(new Item.Properties().durability(1100).tab(ItemGroups_CM.CMARMOR)));
	public static Item TENZAN = register("item_kk_tenzan", new Tenzan(new Item.Properties().durability(1600).tab(ItemGroups_CM.CMARMOR)));
	public static Item RYUSEI = register("item_kk_ryusei", new Ryusei(new Item.Properties().durability(2100).tab(ItemGroups_CM.CMARMOR)));
	public static Item JU87 = register("item_kk_ju87", new Ju87(new Item.Properties().durability(1300).tab(ItemGroups_CM.CMARMOR))); //1200
	public static Item TBF = register("item_kk_tbf", new TBF(new Item.Properties().durability(1900).tab(ItemGroups_CM.CMARMOR)));
	public static Item SWORDFISH = register("item_kk_swordfish", new Swordfish(new Item.Properties().durability(1100).tab(ItemGroups_CM.CMARMOR)));

	public static Item GYORAI_61cm = register("item_gyorai_61cm", new Gyorai61cm(new Item.Properties().tab(ItemGroups_CM.CMARMOR)));

	public static Item SHIELD_kuchiku = register("item_shield_kuchiku", new Shield_CM(new Item.Properties().durability(1108).tab(ItemGroups_CM.CMARMOR)));
	public static Item SHIELD_yura = register("item_shield_yura", new Shield_CM(new Item.Properties().durability(1780).tab(ItemGroups_CM.CMARMOR)));
	public static Item SHIELD_mogami = register("item_shield_mogami", new Shield_CM(new Item.Properties().durability(2452).tab(ItemGroups_CM.CMARMOR)));
	public static Item SHIELD_kongou = register("item_shield_kongou", new Shield_CM(new Item.Properties().durability(3124).tab(ItemGroups_CM.CMARMOR)));

	public static Item SWORD_sakura = register("item_sword_sakura", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties()).tab(ItemGroups_CM.CMARMOR)));
	public static Item SWORD_ichoh = register("item_sword_ichoh", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties()).tab(ItemGroups_CM.CMARMOR)));
	public static Item SWORD_kaede = register("item_sword_kaede", new Sword_CM(ItemTier.WOOD,3, -2.4F, (new Item.Properties()).tab(ItemGroups_CM.CMARMOR)));

	///* Register *///
	private static Item register(String name, Item item) {
		ITEMS.register(name, () -> item);
		return item;
	}

}
