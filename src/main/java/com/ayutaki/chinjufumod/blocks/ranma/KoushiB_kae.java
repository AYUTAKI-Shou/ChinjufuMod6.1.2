package com.ayutaki.chinjufumod.blocks.ranma;

import com.ayutaki.chinjufumod.ChinjufuModTabs;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class KoushiB_kae extends BaseKoushiB {

	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool UP = PropertyBool.create("up");

	public KoushiB_kae(Material material, String unlocalizedName) {
		super(material, unlocalizedName);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	/* 接続するブロック */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() instanceof KoushiB_kae;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()))
				.withProperty(UP, this.canConnectTo(worldIn, pos.up()));
	}

}
