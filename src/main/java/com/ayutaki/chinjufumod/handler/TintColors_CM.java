package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.world.ColorizerFoliage;
import net.minecraftforge.fml.client.FMLClientHandler;

public class TintColors_CM {

	public static void registerColorHandlers() {

		/* 木の葉 */
		IItemColor leafItemColor = (stack, tint) -> {
			/** 1=オーク, 2=マツ, 3=シラカバ, 4=ジャングル, 5=アカシア, 6=ダークオーク
			 * 7=楓 226,66,31=14828063, 8=枯れオーク 175,105,15=11495695, #7cbd6b=7060860**/
			return (tint == 1)? ColorizerFoliage.getFoliageColor(0.7F, 0.6F) :
						((tint == 2)? ColorizerFoliage.getFoliageColorPine() :
						((tint == 3)? ColorizerFoliage.getFoliageColorBirch() :
						((tint == 4)? ColorizerFoliage.getFoliageColor(0.9F, 0.9F) :
						((tint == 5)? ColorizerFoliage.getFoliageColor(0.9F, 0.0F) :
						((tint == 6)? ColorizerFoliage.getFoliageColor(0.7F, 0.8F) :
						((tint == 7)? 14828063 :
						((tint == 8)? 11495695 : -1)))))));
			};

			registerColorHandlerForItem(Items_Wadeco.BONSAI_oak, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.BONSAI_spru, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.BONSAI_bir, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.BONSAI_jun, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.BONSAI_doak, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.BONSAI_aca, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.KANYOU_BOT, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.IKEGAKILONG_BOT, leafItemColor);
			registerColorHandlerForItem(Items_Wadeco.IKEGAKI, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.SKANYOU_BOT, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.SIKEGAKI, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.SIKEGAKILONG_BOT, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.KAEDE_leaf, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.OAKKARE_leaf, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.BONSAI_kaede, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.BONSAI_kare, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.KAEDE_carpet, leafItemColor);
			registerColorHandlerForItem(Items_Seasonal.OCHIBA_carpet, leafItemColor);


		IBlockColor leafBlockColor = (state, worldIn, pos, tint) -> {
			/** BiomeColors.class 設置場所の色を拾う BiomeColors.getFoliageColor(worldIn, pos)
			 ** Biome.class 気温と降雨量から色指定 FoliageColors.get(Temperature, Downfall) 1.0F以上はクラッシュする **/
			return (tint == 1)? ColorizerFoliage.getFoliageColor(0.7F, 0.6F) :
						((tint == 2)? ColorizerFoliage.getFoliageColorPine() :
						((tint == 3)? ColorizerFoliage.getFoliageColorBirch() :
						((tint == 4)? ColorizerFoliage.getFoliageColor(0.9F, 0.9F) :
						((tint == 5)? ColorizerFoliage.getFoliageColor(0.9F, 0.0F) :
						((tint == 6)? ColorizerFoliage.getFoliageColor(0.7F, 0.8F) :
						((tint == 7)? 14828063 :
						((tint == 8)? 11495695 : -1)))))));
			};

			registerColorHandlerForBlock(Garden_Blocks.BONSAI_oak, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_spru, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_bir, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_jun, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_doak, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.BONSAI_aca, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU_TOP, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU_BOT, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU2_TOP, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.KANYOU2_BOT, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_L_TOP, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_L_BOT, leafBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.IKEGAKI_S, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.KAEDE_leaf, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.OAKKARE_leaf, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.BONSAI_kaede, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.BONSAI_kare, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.KAEDE_carpet, leafBlockColor);
			registerColorHandlerForBlock(Seasonal_Blocks.OCHIBA_carpet, leafBlockColor);


		/* 水と紅茶 -30,-30,-30 */
		IItemColor soupItemColor = (stack, tint) -> {
			return (tint == 20)? 2185414 :
						((tint == 21)? 9217455 :
						((tint == 22)? 6589590 :
						((tint == 23)? 8208705 :
						((tint == 24)? 10852705 :
						((tint == 25)? 10645571 :
						((tint == 26)? 6102315 :
						((tint == 27)? 4072747 :
						((tint == 28)? 9874065 :
						((tint == 29)? 9863775 :

						((tint == 30)? 16777053 :
						((tint == 31)? 13505566 :
						((tint == 32)? 11174450 :
						((tint == 33)? 3297410 :
						((tint == 34)? 13806240 :
						((tint == 35)? 11838790 :
						((tint == 40)? 6587090 : -1))))))))))))))));
			};

			registerColorHandlerForItem(Items_Teatime.ENDEN, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.MIZUOKE_full, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.ZUNDOUMIZU, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.ZUNDOUSHIO, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.ZUNDOU, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.ZUNDOU_NAMA, soupItemColor); //カレー生・シチュー生
			registerColorHandlerForItem(Items_Teatime.DASHINABE, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.CURRY, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.CURRYSET, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.NABETORI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.NABEMISO, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.NABE_NAMA_1, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.NABECORNSOUP, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.NABE_KAISUI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.NABE_NAMA_2, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.KEIRYO_CUP_F, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.UDON_SU, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.UDON_NIKU, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.UDON_TSUKIMI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.TONSUITORI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.MISOSOUP, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.TAMAGOYAKITEI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.YAKIZAKANATEI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.YAKIJYAKETEI, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.CORNSOUP, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.EGGBURGSET, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.SUSHISET_salmon, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_fish, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_beef, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_tamago, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.SUSHISET_4shoku, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.KETTLE_full, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.Item_YAKAN_boil, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.KYUSU, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.JPTEACUP, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.JPTEASET, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.TEAPOT, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.TEACUP, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.TEASET, soupItemColor);

			registerColorHandlerForItem(Items_Teatime.NABEAMAZAKE, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.SAKEGLASS, soupItemColor);
			registerColorHandlerForItem(Items_Teatime.WINEGLASS, soupItemColor);

			registerColorHandlerForItem(Items_Seasonal.FALL_LEAF, soupItemColor);
			registerColorHandlerForItem(Items_Seasonal.AKUNABE, soupItemColor);
			registerColorHandlerForItem(Items_Seasonal.SUIDEN, soupItemColor);

		IBlockColor soupBlockColor = (state, worldIn, pos, tint) -> {
			return (tint == 20)? 4159204 :
						((tint == 21)? 12509680 :
						((tint == 22)? 9223890 :
						((tint == 23)? 11164250 :
						((tint == 24)? 15127945 :
						((tint == 25)? 14588001 :
						((tint == 26)? 8398655 :
						((tint == 27)? 5715258 :
						((tint == 28)? 13821640 :
						((tint == 29)? 13808770 :

						((tint == 30)? 16775010 :
						((tint == 31)? 14493736 :
						((tint == 32)? 15772230 :
						((tint == 33)? 3297410 :
						((tint == 34)? 16443100 :
						((tint == 35)? 16441700 :
						((tint == 40)? 6587090 :
						((tint == 41)? 8560880 : -1)))))))))))))))));
			};
			registerColorHandlerForBlock(Crop_Blocks.ENDEN, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.MIZUMILKNABE, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.ZUNDOU, soupBlockColor); //カレー生・シチュー生
			registerColorHandlerForBlock(Dish_Blocks.FISH_ZUNDOU, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.DASHINABE, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.UDONNABE, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.PASTANABE, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.SHIOAKUNABE, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.ORIITONABE, soupBlockColor);

			registerColorHandlerForBlock(Dish_Blocks.CURRY, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.CURRYSET, soupBlockColor);

			registerColorHandlerForBlock(Dish_Blocks.NABETORI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.NABEMISO, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.NABE_nama, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.NABECORNSOUP, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.NABE_nama_2, soupBlockColor);

			registerColorHandlerForBlock(Dish_Blocks.UDON_SU, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.UDON_NIKU, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.UDON_TSUKIMI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.TONSUITORI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.MISOSOUP, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.TAMAGOYAKITEI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.YAKIZAKANATEI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.YAKIJYAKETEI, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.CORNSOUP, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.EGGBURGSET, soupBlockColor);

			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_salmon, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_fish, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_beef, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_tamago, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.SUSHISET_4shoku, soupBlockColor);

			registerColorHandlerForBlock(Dish_Blocks.KETTLE_full, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.KYUSU, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.JPTEACUP, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.JPTEASET, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.TEAPOT, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.TEACUP, soupBlockColor);
			registerColorHandlerForBlock(Dish_Blocks.TEASET, soupBlockColor);

			registerColorHandlerForBlock(Hakkou_Blocks.HAKUSAITARU, soupBlockColor);
			registerColorHandlerForBlock(Hakkou_Blocks.MIZUOKE, soupBlockColor);
			registerColorHandlerForBlock(Hakkou_Blocks.MIZUOKE_full, soupBlockColor);
			registerColorHandlerForBlock(Hakkou_Blocks.NABEAMAZAKE, soupBlockColor);
			registerColorHandlerForBlock(Hakkou_Blocks.SAKEGLASS, soupBlockColor);
			registerColorHandlerForBlock(Hakkou_Blocks.WINEGLASS, soupBlockColor);

			registerColorHandlerForBlock(Garden_Blocks.CHOUZUBACHI, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI2, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHIB, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHIB2, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_T, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_T2, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_TB, soupBlockColor);
			registerColorHandlerForBlock(Garden_Blocks.SHISHIODOSHI_TB2, soupBlockColor);

			registerColorHandlerForBlock(Kitchen_Blocks.KIT_SINK_TOP, soupBlockColor);
			registerColorHandlerForBlock(Kitchen_Blocks.KIT_SINK_BOT, soupBlockColor);

	}

	public static void registerColorHandlerForBlock(Block block, IBlockColor blockColor) {
		FMLClientHandler.instance().getClient().getBlockColors().registerBlockColorHandler(blockColor, block);
	}

	public static void registerColorHandlerForItem(Item item, IItemColor itemColor) {
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(itemColor, item);
	}

}
