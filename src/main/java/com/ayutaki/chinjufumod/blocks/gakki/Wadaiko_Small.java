package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Wadaiko_Small extends BaseStage2_Face {

	public static final String ID = "block_wadaiko_small";

	private static final AxisAlignedBB BOT1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0625, 0.25, 0.8125, 0.40625, 0.75);
	private static final AxisAlignedBB BOT1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0625, 0.25, 0.8125, 0.40625, 0.75);
	private static final AxisAlignedBB BOT1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0625, 0.25, 0.8125, 0.40625, 0.75);
	private static final AxisAlignedBB BOT1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0625, 0.25, 0.8125, 0.40625, 0.75);
	private static final AxisAlignedBB[] BOT1 = { BOT1_SOUTH, BOT1_WEST, BOT1_NORTH, BOT1_EAST };

	private static final AxisAlignedBB BOT2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.6875, 0.25, 0.8125, 1.0, 0.75);
	private static final AxisAlignedBB BOT2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.6875, 0.25, 0.8125, 1.0, 0.75);
	private static final AxisAlignedBB BOT2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.6875, 0.25, 0.8125, 1.0, 0.75);
	private static final AxisAlignedBB BOT2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.6875, 0.25, 0.8125, 1.0, 0.75);
	private static final AxisAlignedBB[] BOT2 = { BOT2_SOUTH, BOT2_WEST, BOT2_NORTH, BOT2_EAST };

	public Wadaiko_Small() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
		setCreativeTab(ChinjufuModTabs.WADECO);

		/*木製*/
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		if (playerIn.isSneaking() && itemstack.isEmpty()) {
			CMEvents.soundWoodPlace(worldIn, pos);
			worldIn.setBlockState(pos, state.cycleProperty(STAGE_1_2)); }

		if (!playerIn.isSneaking()) {
			switch (i) {
			case 1 :
			default :
				if (hitY >= 0.40625D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitY < 0.40625D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;

			case 2 :
				if (hitY >= 1.0D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitY < 1.0D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;
			} // switch
		}
		return true;
	}

	/* Sound */
	private void playSound(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_TOP, SoundCategory.BLOCKS, 0.8F, 1.4F);
	}

	private void playHand(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_TOP, SoundCategory.BLOCKS, 0.2F, 1.4F);
	}

	private void sideSound(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_SIDE, SoundCategory.BLOCKS, 0.8F, 1.3F);
	}

	private void sideHand(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_SIDE, SoundCategory.BLOCKS, 0.2F, 1.3F);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing facing = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		return (i == 1)? BOT1[facing.getHorizontalIndex()] : BOT2[facing.getHorizontalIndex()];
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

	/*Rendering */
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
		stack.add(new ItemStack(Items_Wadeco.WADAIKO_small, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Wadeco.WADAIKO_small, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_wadaiko", meta));
	}

}
