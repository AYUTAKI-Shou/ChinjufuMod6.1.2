package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.futon.Futon_black;
import com.ayutaki.chinjufumod.blocks.futon.Futon_blue;
import com.ayutaki.chinjufumod.blocks.futon.Futon_brown;
import com.ayutaki.chinjufumod.blocks.futon.Futon_cyan;
import com.ayutaki.chinjufumod.blocks.futon.Futon_gray;
import com.ayutaki.chinjufumod.blocks.futon.Futon_green;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lightb;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lightg;
import com.ayutaki.chinjufumod.blocks.futon.Futon_lime;
import com.ayutaki.chinjufumod.blocks.futon.Futon_magenta;
import com.ayutaki.chinjufumod.blocks.futon.Futon_orange;
import com.ayutaki.chinjufumod.blocks.futon.Futon_pink;
import com.ayutaki.chinjufumod.blocks.futon.Futon_purple;
import com.ayutaki.chinjufumod.blocks.futon.Futon_red;
import com.ayutaki.chinjufumod.blocks.futon.Futon_white;
import com.ayutaki.chinjufumod.blocks.futon.Futon_yellow;

import net.minecraft.block.Block;

public final class Futon_Blocks {

	public static Block FUTON_black, FUTON_blue, FUTON_brown, FUTON_cyan;
	public static Block FUTON_gray, FUTON_green, FUTON_lightb, FUTON_lightg;
	public static Block FUTON_lime, FUTON_magenta, FUTON_orange, FUTON_pink;
	public static Block FUTON_purple, FUTON_red, FUTON_white, FUTON_yellow;


	public static void init() {

		FUTON_black = new Futon_black();
		FUTON_blue = new Futon_blue();
		FUTON_brown = new Futon_brown();
		FUTON_cyan = new Futon_cyan();
		FUTON_gray = new Futon_gray();
		FUTON_green = new Futon_green();
		FUTON_lightb = new Futon_lightb();
		FUTON_lightg = new Futon_lightg();
		FUTON_lime = new Futon_lime();
		FUTON_magenta = new Futon_magenta();
		FUTON_orange = new Futon_orange();
		FUTON_pink = new Futon_pink();
		FUTON_purple = new Futon_purple();
		FUTON_red = new Futon_red();
		FUTON_white = new Futon_white();
		FUTON_yellow = new Futon_yellow();

	}

	public static void register() {

		registerBlock(FUTON_black);
		registerBlock(FUTON_blue);
		registerBlock(FUTON_brown);
		registerBlock(FUTON_cyan);
		registerBlock(FUTON_gray);
		registerBlock(FUTON_green);
		registerBlock(FUTON_lightb);
		registerBlock(FUTON_lightg);
		registerBlock(FUTON_lime);
		registerBlock(FUTON_magenta);
		registerBlock(FUTON_orange);
		registerBlock(FUTON_pink);
		registerBlock(FUTON_purple);
		registerBlock(FUTON_red);
		registerBlock(FUTON_white);
		registerBlock(FUTON_yellow);
	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
