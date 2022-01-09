package com.ayutaki.chinjufumod.blocks.glassdoor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GlassDoorHalf extends BaseStage4_Face {

	/* Collision */
	private static final AxisAlignedBB CLOSE1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.0, 0.59375, 1.0, 1.0);
	private static final AxisAlignedBB[] CLOSE1 = { CLOSE1_SOUTH, CLOSE1_WEST, CLOSE1_NORTH, CLOSE1_EAST };

	private static final AxisAlignedBB OPEN2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB OPEN2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.875, 0.59375, 1.0, 1.875);
	private static final AxisAlignedBB[] OPEN2 = { OPEN2_SOUTH, OPEN2_WEST, OPEN2_NORTH, OPEN2_EAST };

	private static final AxisAlignedBB CLOSE3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB CLOSE3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, 0.0, 0.5, 1.0, 1.0);
	private static final AxisAlignedBB[] CLOSE3 = { CLOSE3_SOUTH, CLOSE3_WEST, CLOSE3_NORTH, CLOSE3_EAST };

	private static final AxisAlignedBB OPEN4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB OPEN4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, -0.875, 0.5, 1.0, 0.125);
	private static final AxisAlignedBB[] OPEN4 = { OPEN4_SOUTH, OPEN4_WEST, OPEN4_NORTH, OPEN4_EAST };


	public GlassDoorHalf() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WADECO);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}


	/* 影対策
	public int getLightValue(BlockState state) {
		return (AntiShadow.antiShadow.get() == true)? 1 : 0;
	} */

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=Close、2=Open、3=Close、4=Open **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1 || i == 3) {
			CMEvents.soundHikidoS(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); }

		if (i == 2 || i == 4) {
			CMEvents.soundHikidoS(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); }

		return true;
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		if (placer.isSneaking()) {
			return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(STAGE_1_4, Integer.valueOf(3));
		}
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(STAGE_1_4, Integer.valueOf(1));
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing facing = state.getValue(H_FACING);

		return (i == 1)? CLOSE1[facing.getHorizontalIndex()] : ((i == 2)? OPEN2[facing.getHorizontalIndex()] :
			((i == 3)? CLOSE3[facing.getHorizontalIndex()] : OPEN4[facing.getHorizontalIndex()]));

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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == Slidingdoor_Blocks.GARASUDOH) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH, 1, 0)); }
		if (this == Slidingdoor_Blocks.GARASUDOH_SPRU) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH_SPRU, 1, 0)); }
		if (this == Slidingdoor_Blocks.GARASUDOH_BIR) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH_BIR, 1, 0)); }
		if (this == Slidingdoor_Blocks.GARASUDOH_JUN) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH_JUN, 1, 0)); }
		if (this == Slidingdoor_Blocks.GARASUDOH_ACA) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH_ACA, 1, 0)); }
		if (this == Slidingdoor_Blocks.GARASUDOH_DOAK) { stack.add(new ItemStack(Items_Wadeco.GARASUDOH_DOAK, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == Slidingdoor_Blocks.GARASUDOH_SPRU) { return new ItemStack(Items_Wadeco.GARASUDOH_SPRU, 1, 0); }
		if (this == Slidingdoor_Blocks.GARASUDOH_BIR) { return new ItemStack(Items_Wadeco.GARASUDOH_BIR, 1, 0); }
		if (this == Slidingdoor_Blocks.GARASUDOH_JUN) { return new ItemStack(Items_Wadeco.GARASUDOH_JUN, 1, 0); }
		if (this == Slidingdoor_Blocks.GARASUDOH_ACA) { return new ItemStack(Items_Wadeco.GARASUDOH_ACA, 1, 0); }
		if (this == Slidingdoor_Blocks.GARASUDOH_DOAK) { return new ItemStack(Items_Wadeco.GARASUDOH_DOAK, 1, 0); }
		return new ItemStack(Items_Wadeco.GARASUDOH, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_shoujihalf", meta));
	}

}
