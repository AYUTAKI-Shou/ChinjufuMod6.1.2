package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_acacia;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_acacia extends ItemBaseWindowTall {

	public ItemWindowTall_acacia() {
		super(Window_Blocks.WINDOWTALL_acacia);
		setUnlocalizedName(WindowTall_acacia.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_acacia.ID));
	}

}
