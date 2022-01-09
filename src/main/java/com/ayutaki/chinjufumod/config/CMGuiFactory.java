package com.ayutaki.chinjufumod.config;

import java.util.Set;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;

public class CMGuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) { }

	@Override
	public boolean hasConfigGui() {
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		return new ChinjufuModConfigGui(parentScreen);
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	public static class ChinjufuModConfigGui extends GuiConfig {

		public boolean needsRefresh = true;

		public ChinjufuModConfigGui(GuiScreen parent) {

			super(parent, (new ConfigElement(CMConfig_Core.config.getCategory(CMConfig_Core.GENERAL)))
					.getChildElements(), ChinjufuMod.MOD_ID, false, false, ChinjufuMod.MOD_NAME);
		}
	}


}
