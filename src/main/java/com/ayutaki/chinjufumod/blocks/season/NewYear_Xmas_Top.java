package com.ayutaki.chinjufumod.blocks.season;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NewYear_Xmas_Top extends BaseStage4_Face {

	/**1=門松、2=鏡もち、3=ノーマル、4=ホワイト **/
	public static final String ID = "block_kadomatsu_top";

	public NewYear_Xmas_Top() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		/**1=門松、2=鏡もち、3=ノーマル、4=ホワイト **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { return new AxisAlignedBB(0.28125D, 0.0D, 0.28125D, 0.71875D, 0.875D, 0.71875D); }
		if (i == 2) { return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.84375D, 0.8125D); }
		return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.96875D, 0.8125D);
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/*描画の処理*/
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Seasonal_Blocks.NEWYEAR_XMAS) {
				worldIn.destroyBlock(pos.down(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/**1=門松、2=鏡もち、3=ノーマル、4=ホワイト **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 4)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		/**1=門松、2=鏡もち、3=ノーマル、4=ホワイト **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2) { return new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 4); }
		return new ItemStack(Items_Seasonal.NEWYEAR_XMAS, 1, 1);
	}

}
