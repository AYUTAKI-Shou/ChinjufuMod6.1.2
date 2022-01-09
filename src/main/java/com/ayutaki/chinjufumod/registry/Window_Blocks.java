package com.ayutaki.chinjufumod.registry;

import com.ayutaki.chinjufumod.RegisterHandler_CM;
import com.ayutaki.chinjufumod.blocks.window.WindowB_acacia;
import com.ayutaki.chinjufumod.blocks.window.WindowB_birch;
import com.ayutaki.chinjufumod.blocks.window.WindowB_darkoak;
import com.ayutaki.chinjufumod.blocks.window.WindowB_ichoh;
import com.ayutaki.chinjufumod.blocks.window.WindowB_jungle;
import com.ayutaki.chinjufumod.blocks.window.WindowB_kaede;
import com.ayutaki.chinjufumod.blocks.window.WindowB_oak;
import com.ayutaki.chinjufumod.blocks.window.WindowB_sakura;
import com.ayutaki.chinjufumod.blocks.window.WindowB_spruce;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_acacia;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_birch;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_darkoak;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_ichoh;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_jungle;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_kaede;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_oak;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_sakura;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_spruce;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_acacia;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_birch;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_darkoak;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_ichoh;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_jungle;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_kaede;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_oak;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_sakura;
import com.ayutaki.chinjufumod.blocks.window.WindowTallTop_spruce;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_acacia;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_birch;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_darkoak;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_ichoh;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_jungle;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_kaede;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_oak;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_sakura;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_spruce;
import com.ayutaki.chinjufumod.blocks.window.Window_acacia;
import com.ayutaki.chinjufumod.blocks.window.Window_birch;
import com.ayutaki.chinjufumod.blocks.window.Window_darkoak;
import com.ayutaki.chinjufumod.blocks.window.Window_ichoh;
import com.ayutaki.chinjufumod.blocks.window.Window_jungle;
import com.ayutaki.chinjufumod.blocks.window.Window_kaede;
import com.ayutaki.chinjufumod.blocks.window.Window_oak;
import com.ayutaki.chinjufumod.blocks.window.Window_sakura;
import com.ayutaki.chinjufumod.blocks.window.Window_spruce;

import net.minecraft.block.Block;

public class Window_Blocks {

	public static Block WINDOW_oak, WINDOW_acacia, WINDOW_birch,
								WINDOW_darkoak, WINDOW_jungle, WINDOW_spruce,
								WINDOW_sakura, WINDOW_kaede, WINDOW_ichoh;

	public static Block WINDOWB_oak, WINDOWB_acacia, WINDOWB_birch,
								WINDOWB_darkoak, WINDOWB_jungle, WINDOWB_spruce,
								WINDOWB_sakura, WINDOWB_kaede, WINDOWB_ichoh;

	public static Block WINDOWTALL_oak, WINDOWTALL_acacia, WINDOWTALL_birch,
								WINDOWTALL_darkoak, WINDOWTALL_jungle, WINDOWTALL_spruce,
								WINDOWTALL_sakura, WINDOWTALL_kaede, WINDOWTALL_ichoh;

	public static Block WINDOWTALLBOT_oak, WINDOWTALLBOT_acacia, WINDOWTALLBOT_birch,
								WINDOWTALLBOT_darkoak, WINDOWTALLBOT_jungle, WINDOWTALLBOT_spruce,
								WINDOWTALLBOT_sakura, WINDOWTALLBOT_kaede, WINDOWTALLBOT_ichoh;

	public static Block WINDOWTALLTOP_oak, WINDOWTALLTOP_acacia, WINDOWTALLTOP_birch,
								WINDOWTALLTOP_darkoak, WINDOWTALLTOP_jungle, WINDOWTALLTOP_spruce,
								WINDOWTALLTOP_sakura, WINDOWTALLTOP_kaede, WINDOWTALLTOP_ichoh;


	public static void init() {

		WINDOW_oak = new Window_oak();
		WINDOW_acacia = new Window_acacia();
		WINDOW_birch = new Window_birch();
		WINDOW_darkoak = new Window_darkoak();
		WINDOW_jungle = new Window_jungle();
		WINDOW_spruce = new Window_spruce();
		WINDOW_sakura = new Window_sakura();
		WINDOW_kaede = new Window_kaede();
		WINDOW_ichoh = new Window_ichoh();

		WINDOWB_oak = new WindowB_oak();
		WINDOWB_acacia = new WindowB_acacia();
		WINDOWB_birch = new WindowB_birch();
		WINDOWB_darkoak = new WindowB_darkoak();
		WINDOWB_jungle = new WindowB_jungle();
		WINDOWB_spruce = new WindowB_spruce();
		WINDOWB_sakura = new WindowB_sakura();
		WINDOWB_kaede = new WindowB_kaede();
		WINDOWB_ichoh = new WindowB_ichoh();

		WINDOWTALL_oak = new WindowTall_oak();
		WINDOWTALL_acacia = new WindowTall_acacia();
		WINDOWTALL_birch = new WindowTall_birch();
		WINDOWTALL_darkoak = new WindowTall_darkoak();
		WINDOWTALL_jungle = new WindowTall_jungle();
		WINDOWTALL_spruce = new WindowTall_spruce();
		WINDOWTALL_sakura = new WindowTall_sakura();
		WINDOWTALL_kaede = new WindowTall_kaede();
		WINDOWTALL_ichoh = new WindowTall_ichoh();

		WINDOWTALLBOT_oak = new WindowTallBot_oak();
		WINDOWTALLTOP_oak = new WindowTallTop_oak();
		WINDOWTALLBOT_acacia = new WindowTallBot_acacia();
		WINDOWTALLTOP_acacia = new WindowTallTop_acacia();
		WINDOWTALLBOT_birch = new WindowTallBot_birch();
		WINDOWTALLTOP_birch = new WindowTallTop_birch();
		WINDOWTALLBOT_darkoak = new WindowTallBot_darkoak();
		WINDOWTALLTOP_darkoak = new WindowTallTop_darkoak();
		WINDOWTALLBOT_jungle = new WindowTallBot_jungle();
		WINDOWTALLTOP_jungle = new WindowTallTop_jungle();
		WINDOWTALLBOT_spruce = new WindowTallBot_spruce();
		WINDOWTALLTOP_spruce = new WindowTallTop_spruce();
		WINDOWTALLBOT_sakura = new WindowTallBot_sakura();
		WINDOWTALLTOP_sakura = new WindowTallTop_sakura();
		WINDOWTALLBOT_kaede = new WindowTallBot_kaede();
		WINDOWTALLTOP_kaede = new WindowTallTop_kaede();
		WINDOWTALLBOT_ichoh = new WindowTallBot_ichoh();
		WINDOWTALLTOP_ichoh = new WindowTallTop_ichoh();


	}


	public static void register() {

		registerBlock(WINDOW_oak);
		registerBlock(WINDOW_acacia);
		registerBlock(WINDOW_birch);
		registerBlock(WINDOW_darkoak);
		registerBlock(WINDOW_jungle);
		registerBlock(WINDOW_spruce);
		registerBlock(WINDOW_sakura);
		registerBlock(WINDOW_kaede);
		registerBlock(WINDOW_ichoh);

		registerBlock(WINDOWB_oak);
		registerBlock(WINDOWB_acacia);
		registerBlock(WINDOWB_birch);
		registerBlock(WINDOWB_darkoak);
		registerBlock(WINDOWB_jungle);
		registerBlock(WINDOWB_spruce);
		registerBlock(WINDOWB_sakura);
		registerBlock(WINDOWB_kaede);
		registerBlock(WINDOWB_ichoh);

		registerBlock(WINDOWTALL_oak);
		registerBlock(WINDOWTALL_acacia);
		registerBlock(WINDOWTALL_birch);
		registerBlock(WINDOWTALL_darkoak);
		registerBlock(WINDOWTALL_jungle);
		registerBlock(WINDOWTALL_spruce);
		registerBlock(WINDOWTALL_sakura);
		registerBlock(WINDOWTALL_kaede);
		registerBlock(WINDOWTALL_ichoh);

		registerBlock(WINDOWTALLBOT_oak);
		registerBlock(WINDOWTALLBOT_acacia);
		registerBlock(WINDOWTALLBOT_birch);
		registerBlock(WINDOWTALLBOT_darkoak);
		registerBlock(WINDOWTALLBOT_jungle);
		registerBlock(WINDOWTALLBOT_spruce);
		registerBlock(WINDOWTALLBOT_sakura);
		registerBlock(WINDOWTALLBOT_kaede);
		registerBlock(WINDOWTALLBOT_ichoh);

		registerBlock(WINDOWTALLTOP_oak);
		registerBlock(WINDOWTALLTOP_acacia);
		registerBlock(WINDOWTALLTOP_birch);
		registerBlock(WINDOWTALLTOP_darkoak);
		registerBlock(WINDOWTALLTOP_jungle);
		registerBlock(WINDOWTALLTOP_spruce);
		registerBlock(WINDOWTALLTOP_sakura);
		registerBlock(WINDOWTALLTOP_kaede);
		registerBlock(WINDOWTALLTOP_ichoh);


	}

	public static void registerBlock(Block block) {
		RegisterHandler_CM.Blocks.BLOCKS.add(block);
	}

}
