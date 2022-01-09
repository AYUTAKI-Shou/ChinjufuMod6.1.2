package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_darkoak;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_darkoak extends ItemBaseWindowTall {

	public ItemWindowTall_darkoak() {
		super(Window_Blocks.WINDOWTALL_darkoak);
		setUnlocalizedName(WindowTall_darkoak.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_darkoak.ID));
	}

}
