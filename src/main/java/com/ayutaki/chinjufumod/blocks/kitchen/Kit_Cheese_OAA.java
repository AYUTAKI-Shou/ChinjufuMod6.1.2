package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kit_Cheese_OAA extends BaseStage3_Face {

	public static final String ID = "block_kit_cheese_oaa";

	/* Collision */
	protected static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
	protected static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, 0.0, 0.0, 0.75, 1.0, 1.0);
	protected static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	/* stage1=OAA, stage2=OBA, stage3=OBB */
	public Kit_Cheese_OAA() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		/** Hand is empty. **/
		if (itemstack.isEmpty() && item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) {
			/** stage1=OAA **/
			if (i == 1) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE_CURD));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); } /* → OOA */
			
			/** stage2=OBA **/
			if (i == 2) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); } /* → OOA */
			
			/** stage3=OBB **/
			if (i == 3) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHEESE));

				worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); } /* → OOB */

		}
		
		/** Hand is not empty. **/
		if (!itemstack.isEmpty()) {
			if (item == Items_Teatime.CHEESE_CURD) {
				if (i == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); } /* → AAA */
				
				if (i == 2) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); } /* → BAA */
				
				if (i == 3) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); } /* → BBA */
			}
			
			if (item == Items_Teatime.CHEESE) {
				if (i == 1 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); } /* → BAA */
				
				if (i == 2 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); } /* → BBA */
				
				if (i == 3 && item == Items_Teatime.CHEESE) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundCheesePlace(worldIn, pos);
					worldIn.setBlockState(pos, Kitchen_Blocks.CHEESE_AAA.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); } /* → BBB */
			}
			
			if (item != Items_Teatime.CHEESE_CURD && item != Items_Teatime.CHEESE) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** 'true' to not put anything on top. **/
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes,
			@Nullable Entity entityIn, boolean t_f) {

		EnumFacing facing = state.getValue(H_FACING);
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB[facing.getHorizontalIndex()]);
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		/* stage1=OAA, stage2=OBA, stage3=OBB */
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i != 3) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }
		if (i == 3) { }

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn) + (200 * rand.nextInt(3)));
	}

	@Override
	public int tickRate(World worldIn) {
		return 5000;
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

	/* Drop Item and Clone Item. */
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/* Drop Item and Clone Item. */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/* stage1=OAA, stage2=OBA, stage3=OBB */
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE_CURD, 2, 0)); }

		if (i == 2) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE_CURD, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE, 1, 0)); }

		if (i == 3) { stack.add(new ItemStack(Items_Teatime.CHEESE_TANA, 1, 0));
							stack.add(new ItemStack(Items_Teatime.CHEESE, 2, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.CHEESE_TANA);
	}

}
