package com.ayutaki.chinjufumod.blocks.gakki;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
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

public class Wadaiko_Top extends BaseStage3_Face {

	public static final String ID = "block_wadaiko_top";

	private static final AxisAlignedBB TOP1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB TOP1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0625, 0.0, 0.203125, 0.9375, 0.59375, 0.796875);
	private static final AxisAlignedBB[] TOP1 = { TOP1_SOUTH, TOP1_WEST, TOP1_NORTH, TOP1_EAST };

	private static final AxisAlignedBB TOP2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB TOP2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.5, 0.0, 0.234375, 0.96875, 0.4375, 0.765625);
	private static final AxisAlignedBB[] TOP2 = { TOP2_SOUTH, TOP2_WEST, TOP2_NORTH, TOP2_EAST };

	private static final AxisAlignedBB TOP3_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.01, 0.01, 0.01);

	public Wadaiko_Top() {
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

		EnumFacing direction = state.getValue(H_FACING);

		switch (i) {
		case 1 :
		default :
			switch (direction) {
			case NORTH :
			default :
			case SOUTH :
				if (hitZ >= 0.9375D || hitZ <= 0.0625D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitZ < 0.9375D && hitZ > 0.0625D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;

			case EAST :
			case WEST :
				if (hitX >= 0.9375D || hitX <= 0.0625D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitX < 0.9375D && hitX > 0.0625D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;
			} // switch
			break;

		case 2 :
			switch (direction) {
			case NORTH :
			default :
				if (hitZ <= 0.03125D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitZ > 0.03125D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;

			case SOUTH :
				if (hitZ >= 0.96875D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitZ < 0.96875D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;

			case EAST :
				if (hitX >= 0.96875D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitX < 0.96875D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;
				
			case WEST :
				if (hitX <= 0.03125D) {
					if (item == Items.STICK) { this.playSound(worldIn, pos); }
					if (item != Items.STICK) { this.playHand(worldIn, pos); } }

				if (hitX > 0.03125D) {
					if (item == Items.STICK) { this.sideSound(worldIn, pos); }
					if (item != Items.STICK) { this.sideHand(worldIn, pos); } }
				break;
			} // switch
			break;
			
		case 3 :
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

		return (i == 1)? TOP1[facing.getHorizontalIndex()] : ((i == 2)? TOP2[facing.getHorizontalIndex()] : TOP3_AABB);
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
		if (worldIn.getBlockState(pos.down()).getBlock() == JPDeco_Blocks.WADAIKO_BOT) {
				worldIn.destroyBlock(pos.down(), false);
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
