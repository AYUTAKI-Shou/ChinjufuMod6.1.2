package com.ayutaki.chinjufumod.blocks.bamboo;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BambooCube extends BlockRotatedPillar {

	public BambooCube() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WADECO);

		setHardness(2.0F);
		setResistance(5.0F);

		setSoundType(SoundType.WOOD);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == JPDeco_Blocks.TAKECUBE) { stack.add(new ItemStack(Items_Wadeco.TAKECUBE, 1, 0)); }
		if (this == JPDeco_Blocks.TAKECUBE_Y) { stack.add(new ItemStack(Items_Wadeco.TAKECUBE_Y, 1, 0)); }
		if (this == JPDeco_Blocks.TAKECUBE_K) { stack.add(new ItemStack(Items_Wadeco.TAKECUBE_K, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == JPDeco_Blocks.TAKECUBE_Y) { return new ItemStack(Items_Wadeco.TAKECUBE_Y); }
		if (this == JPDeco_Blocks.TAKECUBE_K) { return new ItemStack(Items_Wadeco.TAKECUBE_K); }
		return new ItemStack(Items_Wadeco.TAKECUBE);
	}

}
