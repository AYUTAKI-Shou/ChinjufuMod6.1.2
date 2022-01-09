package com.ayutaki.chinjufumod.blocks.bamboo;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BambooTrapDoor extends BlockTrapDoor {

	public BambooTrapDoor() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WADECO);

		setSoundType(SoundType.WOOD);
		setHardness(2.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == JPDeco_Blocks.TAKE_TRAPDOOR) { stack.add(new ItemStack(Items_Wadeco.TAKE_TRAPDOOR, 1, 0)); }
		if (this == JPDeco_Blocks.TAKE_TRAPDOOR_Y) { stack.add(new ItemStack(Items_Wadeco.TAKE_TRAPDOOR_Y, 1, 0)); }
		if (this == JPDeco_Blocks.TAKE_TRAPDOOR_K) { stack.add(new ItemStack(Items_Wadeco.TAKE_TRAPDOOR_K, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == JPDeco_Blocks.TAKE_TRAPDOOR_Y) { return new ItemStack(Items_Wadeco.TAKE_TRAPDOOR_Y); }
		if (this == JPDeco_Blocks.TAKE_TRAPDOOR_K) { return new ItemStack(Items_Wadeco.TAKE_TRAPDOOR_K); }
		return new ItemStack(Items_Wadeco.TAKE_TRAPDOOR);
	}

}
