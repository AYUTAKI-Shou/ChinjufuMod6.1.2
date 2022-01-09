package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_birch;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_birch extends ItemBaseWindowTall {

	public ItemWindowTall_birch() {
		super(Window_Blocks.WINDOWTALL_birch);
		setUnlocalizedName(WindowTall_birch.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_birch.ID));
	}

}
