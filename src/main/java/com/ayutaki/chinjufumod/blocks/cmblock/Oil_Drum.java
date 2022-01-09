package com.ayutaki.chinjufumod.blocks.cmblock;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Oil_Drum extends BaseFacingWater {

	/* Collision */
	protected static final VoxelShape AABB_FUEL = Block.makeCuboidShape(1.0D, 0.0, 1.0D, 15.0D, 15.99D, 15.0D);

	public Oil_Drum(Block.Properties properties) {
		super(properties);
	}

	/* プロパティに合わせて当たり判定 */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_FUEL;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

}
