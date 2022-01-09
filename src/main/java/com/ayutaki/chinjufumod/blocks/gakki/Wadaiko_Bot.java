package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
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

public class Wadaiko_Bot extends BaseStage3_Face {

	public static final String ID = "block_wadaiko";

	private static final AxisAlignedBB BOT1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.15625, 0.78125, 0.953125, 0.84375);
	private static final AxisAlignedBB BOT1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.15625, 0.78125, 0.953125, 0.84375);
	private static final AxisAlignedBB BOT1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.15625, 0.78125, 0.953125, 0.84375);
	private static final AxisAlignedBB BOT1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.15625, 0.78125, 0.953125, 0.84375);
	private static final AxisAlignedBB[] BOT1 = { BOT1_SOUTH, BOT1_WEST, BOT1_NORTH, BOT1_EAST };

	private static final AxisAlignedBB BOT2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0625, 0.0, 0.203125, 0.96875, 0.96875, 0.796875);
	private static final AxisAlignedBB BOT2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0625, 0.0, 0.203125, 0.96875, 0.96875, 0.796875);
	private static final AxisAlignedBB BOT2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0625, 0.0, 0.203125, 0.96875, 0.96875, 0.796875);
	private static final AxisAlignedBB BOT2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0625, 0.0, 0.203125, 0.96875, 0.96875, 0.796875);
	private static final AxisAlignedBB[] BOT2 = { BOT2_SOUTH, BOT2_WEST, BOT2_NORTH, BOT2_EAST };

	private static final AxisAlignedBB BOT3_AABB = new AxisAlignedBB(0.203125, 0.0, 0.203125, 0.796875, 0.875, 0.796875);

	public Wadaiko_Bot() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*木製*/
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		switch (i) {
		case 1 :
		default :
			if (playerIn.isSneaking()) {
				if (itemstack.isEmpty()) {
					CMEvents.soundWoodPlace(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(2)));
					worldIn.setBlockState(pos.up(), JPDeco_Blocks.WADAIKO_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
			break;

		case 2 :
			if (playerIn.isSneaking()) {
				if (itemstack.isEmpty()) {
					CMEvents.soundWoodPlace(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(3)));
					worldIn.setBlockState(pos.up(), JPDeco_Blocks.WADAIKO_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
			break;
			
		case 3 :
			if (playerIn.isSneaking()) {
				if (itemstack.isEmpty()) {
					CMEvents.soundWoodPlace(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(1)));
					worldIn.setBlockState(pos.up(), JPDeco_Blocks.WADAIKO_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1))); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (!playerIn.isSneaking()) {
				if (hitY >= 0.86875D || hitY <= 0.01D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					else { this.playHand(worldIn, pos); } }

				if (hitY < 0.86875D && hitY > 0.01D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					else { this.sideHand(worldIn, pos); } } }
			break;
		} // switch

		return true;
	}

	/* Sound */
	private void playSound(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_TOP, SoundCategory.BLOCKS, 1.25F, 1.0F);
	}

	private void playHand(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_TOP, SoundCategory.BLOCKS, 0.2F, 1.0F);
	}

	private void sideSound(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_SIDE, SoundCategory.BLOCKS, 1.25F, 1.0F);
	}

	private void sideHand(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WADAIKO_SIDE, SoundCategory.BLOCKS, 0.2F, 1.0F);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing facing = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		return (i == 1)? BOT1[facing.getHorizontalIndex()] : ((i == 2)? BOT2[facing.getHorizontalIndex()] : BOT3_AABB);
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

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.up()).getBlock() == JPDeco_Blocks.WADAIKO_TOP) {
				worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Wadeco.WADAIKO, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Wadeco.WADAIKO, 1, 0);
	}

}
