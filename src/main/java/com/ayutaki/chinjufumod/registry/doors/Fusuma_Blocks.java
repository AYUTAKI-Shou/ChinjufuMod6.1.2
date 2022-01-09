package com.ayutaki.chinjufumod.registry.doors;

import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_black;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_blue;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_brown;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_cyan;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_gray;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_green;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lightblue;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lightgray;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_lime;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_magenta;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_orange;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_pink;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_purple;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_red;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_white;
import com.ayutaki.chinjufumod.blocks.fusuma.FusumaB_yellow;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_black;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_blue;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_brown;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_cyan;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_gray;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_green;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lightblue;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lightgray;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_lime;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_magenta;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_orange;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_pink;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_purple;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_red;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_white;
import com.ayutaki.chinjufumod.blocks.fusuma.Fusuma_yellow;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class Fusuma_Blocks {

	public static Fusuma_black FUSUMA_black;
	public static Fusuma_blue FUSUMA_blue;
	public static Fusuma_brown FUSUMA_brown;
	public static Fusuma_cyan FUSUMA_cyan;
	public static Fusuma_gray FUSUMA_gray;
	public static Fusuma_green FUSUMA_green;
	public static Fusuma_lightblue FUSUMA_lightblue;
	public static Fusuma_lightgray FUSUMA_lightgray;
	public static Fusuma_lime FUSUMA_lime;
	public static Fusuma_magenta FUSUMA_magenta;
	public static Fusuma_orange FUSUMA_orange;
	public static Fusuma_pink FUSUMA_pink;
	public static Fusuma_purple FUSUMA_purple;
	public static Fusuma_red FUSUMA_red;
	public static Fusuma_white FUSUMA_white;
	public static Fusuma_yellow FUSUMA_yellow;

	public static FusumaB_black FUSUMAB_black;
	public static FusumaB_blue FUSUMAB_blue;
	public static FusumaB_brown FUSUMAB_brown;
	public static FusumaB_cyan FUSUMAB_cyan;
	public static FusumaB_gray FUSUMAB_gray;
	public static FusumaB_green FUSUMAB_green;
	public static FusumaB_lightblue FUSUMAB_lightblue;
	public static FusumaB_lightgray FUSUMAB_lightgray;
	public static FusumaB_lime FUSUMAB_lime;
	public static FusumaB_magenta FUSUMAB_magenta;
	public static FusumaB_orange FUSUMAB_orange;
	public static FusumaB_pink FUSUMAB_pink;
	public static FusumaB_purple FUSUMAB_purple;
	public static FusumaB_red FUSUMAB_red;
	public static FusumaB_white FUSUMAB_white;
	public static FusumaB_yellow FUSUMAB_yellow;



	/* → main preinit() クラスを走らせて登録 */
	public static void load(FMLPreInitializationEvent event) {

		FUSUMA_black = new Fusuma_black();
		FUSUMA_blue = new Fusuma_blue();
		FUSUMA_brown = new Fusuma_brown();
		FUSUMA_cyan = new Fusuma_cyan();
		FUSUMA_gray = new Fusuma_gray();
		FUSUMA_green = new Fusuma_green();
		FUSUMA_lightblue = new Fusuma_lightblue();
		FUSUMA_lightgray = new Fusuma_lightgray();
		FUSUMA_lime = new Fusuma_lime();
		FUSUMA_magenta = new Fusuma_magenta();
		FUSUMA_orange = new Fusuma_orange();
		FUSUMA_pink = new Fusuma_pink();
		FUSUMA_purple = new Fusuma_purple();
		FUSUMA_red = new Fusuma_red();
		FUSUMA_white = new Fusuma_white();
		FUSUMA_yellow = new Fusuma_yellow();

		FUSUMAB_black = new FusumaB_black();
		FUSUMAB_blue = new FusumaB_blue();
		FUSUMAB_brown = new FusumaB_brown();
		FUSUMAB_cyan = new FusumaB_cyan();
		FUSUMAB_gray = new FusumaB_gray();
		FUSUMAB_green = new FusumaB_green();
		FUSUMAB_lightblue = new FusumaB_lightblue();
		FUSUMAB_lightgray = new FusumaB_lightgray();
		FUSUMAB_lime = new FusumaB_lime();
		FUSUMAB_magenta = new FusumaB_magenta();
		FUSUMAB_orange = new FusumaB_orange();
		FUSUMAB_pink = new FusumaB_pink();
		FUSUMAB_purple = new FusumaB_purple();
		FUSUMAB_red = new FusumaB_red();
		FUSUMAB_white = new FusumaB_white();
		FUSUMAB_yellow = new FusumaB_yellow();


	}


}
