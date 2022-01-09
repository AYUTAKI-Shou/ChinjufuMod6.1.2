package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.WindowTall_sakura;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.util.ResourceLocation;

public class ItemWindowTall_sakura extends ItemBaseWindowTall {

	public ItemWindowTall_sakura() {
		super(Window_Blocks.WINDOWTALL_sakura);
		setUnlocalizedName(WindowTall_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTall_sakura.ID));
	}

}
