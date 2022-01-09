package com.ayutaki.chinjufumod.blocks.bamboo;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BambooButton extends BlockButtonWood {

	public BambooButton() {
		super();
		setCreativeTab(ChinjufuModTabs.WADECO);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == JPDeco_Blocks.TAKE_BUTTON) { stack.add(new ItemStack(Items_Wadeco.TAKE_BUTTON, 1, 0)); }
		if (this == JPDeco_Blocks.TAKE_BUTTON_Y) { stack.add(new ItemStack(Items_Wadeco.TAKE_BUTTON_Y, 1, 0)); }
		if (this == JPDeco_Blocks.TAKE_BUTTON_K) { stack.add(new ItemStack(Items_Wadeco.TAKE_BUTTON_K, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == JPDeco_Blocks.TAKE_BUTTON_Y) { return new ItemStack(Items_Wadeco.TAKE_BUTTON_Y); }
		if (this == JPDeco_Blocks.TAKE_BUTTON_K) { return new ItemStack(Items_Wadeco.TAKE_BUTTON_K); }
		return new ItemStack(Items_Wadeco.TAKE_BUTTON);
	}

}
