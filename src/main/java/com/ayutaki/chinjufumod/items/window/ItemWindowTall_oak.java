package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_oak;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_oak extends ItemBaseWindowTall {

	public ItemWindowTall_oak() {
		super(Window_Blocks.WINDOWTALL_oak);
		setUnlocalizedName(WindowTall_oak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_oak.ID));
	}

}
