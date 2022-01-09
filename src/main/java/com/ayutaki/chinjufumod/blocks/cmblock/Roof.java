package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Roof extends Roof_Base {

	public Roof(String unlocalizedName) {
		super(unlocalizedName);
	}

	/* ブロック遷移 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		
		if (itemstack.isEmpty()) {
			if (playerIn.isSneaking()) {
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(COR), 2);
			return true; }
			
		if (!playerIn.isSneaking()) {
			CMEvents.textNotSneak(worldIn, pos, playerIn);
			return true; }
	}
	return false;
}


	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == Seasonal_Blocks.KAYATABA_RF) { stack.add(new ItemStack(Items_Seasonal.KAYATABA_RF, 1, 0)); }
		if (this == Seasonal_Blocks.KUSATABA_RF) { stack.add(new ItemStack(Items_Seasonal.KUSATABA_RF, 1, 0)); }
		if (this == Seasonal_Blocks.WARATABA_RF) { stack.add(new ItemStack(Items_Seasonal.WARATABA_RF, 1, 0)); }
		return stack;

	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {

		if (this == Seasonal_Blocks.KUSATABA_RF) { return new ItemStack(Items_Seasonal.KUSATABA_RF, 1, 0); }
		if (this == Seasonal_Blocks.WARATABA_RF) { return new ItemStack(Items_Seasonal.WARATABA_RF, 1, 0); }
		return new ItemStack(Items_Seasonal.KAYATABA_RF, 1, 0);
	}

}
