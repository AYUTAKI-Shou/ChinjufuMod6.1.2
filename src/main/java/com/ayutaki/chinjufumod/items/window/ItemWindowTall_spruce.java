package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_spruce;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_spruce extends ItemBaseWindowTall {

	public ItemWindowTall_spruce() {
		super(Window_Blocks.WINDOWTALL_spruce);
		setUnlocalizedName(WindowTall_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_spruce.ID));
	}

}
