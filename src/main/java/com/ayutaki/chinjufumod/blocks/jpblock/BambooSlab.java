package com.ayutaki.chinjufumod.blocks.jpblock;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BambooSlab extends BaseFacingSlab_Water {

	public BambooSlab(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }

}
