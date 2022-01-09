package com.ayutaki.chinjufumod.blocks.season;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Door_CM extends DoorBlock {

	public Door_CM(Block.Properties properties) {
		super(properties);
	}

	/* 同時破壊とドロップの指定 1.16.5に合わせる */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, blockpos, Block.getStateId(blockstate));

			ItemStack itemstack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(blockstate)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, itemstack);
				Block.spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, playerIn, itemstack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

}
