package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_ichoh;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_ichoh extends ItemBaseWindowTall {

	public ItemWindowTall_ichoh() {
		super(Window_Blocks.WINDOWTALL_ichoh);
		setUnlocalizedName(WindowTall_ichoh.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_ichoh.ID));
	}

}
