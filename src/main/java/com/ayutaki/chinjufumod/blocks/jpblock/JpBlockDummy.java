package com.ayutaki.chinjufumod.blocks.jpblock;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraftforge.common.ToolType;

public class JpBlockDummy extends Block {

	public JpBlockDummy(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

}
