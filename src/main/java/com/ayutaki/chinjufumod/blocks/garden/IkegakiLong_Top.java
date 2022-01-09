package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
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

public class IkegakiLong_Top extends Block {

	/* Property */
	public static final PropertyInteger STAGE_0_9 = PropertyInteger.create("stage", 0, 9);

	public static final String ID = "block_ikegakilong_top";

	public IkegakiLong_Top() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(STAGE_0_9, Integer.valueOf(0)));
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Garden_Blocks.IKEGAKI_L_BOT) {
				worldIn.destroyBlock(pos.down(), false);
		}
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	}

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_9, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_9)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_9 });
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (9 - ((Integer)blockState.getValue(STAGE_0_9)).intValue()) * 2;
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

	/* Rendering */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		if (i == 0) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 0)); }
		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 4)); }
		if (i == 5) { stack.add(new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 5)); }
		if (i == 6) { stack.add(new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 0)); }
		if (i == 7) { stack.add(new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 1)); }
		if (i == 8) { stack.add(new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 2)); }
		if (i == 9) { stack.add(new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 3)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_9)).intValue();

		if (i == 1) { return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 0); }
		if (i == 7) { return new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 1); }
		if (i == 8) { return new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 2); }
		if (i == 9) { return new ItemStack(Items_Seasonal.SIKEGAKILONG_BOT, 1, 3); }
		return new ItemStack(Items_Wadeco.IKEGAKILONG_BOT, 1, 0);
	}

}
