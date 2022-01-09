package com.ayutaki.chinjufumod.blocks.shoujih;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ShoujiWin_jungle extends BaseShouji_Win {

	public ShoujiWin_jungle() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WADECO);
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if (placer.isSneaking()) {
			return Slidingdoor_Blocks.SHOUJIWINR_jungle.getDefaultState()
						.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite())
						.withProperty(STAGE_1_3, Integer.valueOf(1));
		}
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite())
					.withProperty(STAGE_1_3, Integer.valueOf(1));
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		stack.add(new ItemStack(Items_Wadeco.SHOUJIWIN_jungle, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Wadeco.SHOUJIWIN_jungle);
	}

}
