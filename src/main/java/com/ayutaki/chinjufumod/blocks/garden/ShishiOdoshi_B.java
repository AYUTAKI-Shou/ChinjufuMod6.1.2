package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
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

public class ShishiOdoshi_B extends BaseStage4_Face {

	/* Property */
	/** 空、水1、水2、水3 **/
	public static final String ID = "block_shishiodoshi_b";

	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, 0.0, 0.125, 0.875, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, 0.0, 0.125, 0.875, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, 0.0, 0.125, 0.875, 1.0, 0.9375);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, 0.0, 0.125, 0.875, 1.0, 0.9375);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public ShishiOdoshi_B() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		switch (i) {
		case 1 :
		default :
			break;

		case 2 :
		case 3 :
			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_TB.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 1))); 
			
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			break;
			
		case 4 :
			worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHIB2.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
			worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_TB2.getDefaultState()
					.withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
			
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
			break;
		} // switch
	}

	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 150;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { }
		else { worldIn.playSound(x, y, z, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, 0.25F, rand.nextFloat() + 0.75F, false); }
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** Hand is Empty. **/
		if (itemstack.isEmpty()) {

			if (i == 1) {
				CMEvents.soundStoneButton_On(worldIn, pos);

				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHIB.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_TB.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }

			if (i != 1) {
				CMEvents.soundStoneButton_Off(worldIn, pos);

				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHIB.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_TB.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); } }
		
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
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

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.up()).getBlock() == Garden_Blocks.SHISHIODOSHI_T ||
				worldIn.getBlockState(pos.up()).getBlock() == Garden_Blocks.SHISHIODOSHI_T2||
				worldIn.getBlockState(pos.up()).getBlock() == Garden_Blocks.SHISHIODOSHI_TB||
				worldIn.getBlockState(pos.up()).getBlock() == Garden_Blocks.SHISHIODOSHI_TB2) {
				worldIn.destroyBlock(pos.up(), false);
		}
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Wadeco.SHISHIODOSHI, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Wadeco.SHISHIODOSHI, 1, 0);
	}

}
