package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_kaede;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_kaede extends ItemBaseWindowTall {

	public ItemWindowTall_kaede() {
		super(Window_Blocks.WINDOWTALL_kaede);
		setUnlocalizedName(WindowTall_kaede.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_kaede.ID));
	}

}
