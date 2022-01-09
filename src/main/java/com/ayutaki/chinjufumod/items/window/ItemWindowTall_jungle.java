package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_jungle;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_jungle extends ItemBaseWindowTall {

	public ItemWindowTall_jungle() {
		super(Window_Blocks.WINDOWTALL_jungle);
		setUnlocalizedName(WindowTall_jungle.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_jungle.ID));
	}

}
