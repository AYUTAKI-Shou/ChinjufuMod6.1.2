package com.ayutaki.chinjufumod.blocks.pantry;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Box_HCM extends BaseFacingSlabW {

	/* Collision */
	private static final AxisAlignedBB DOUBLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	private static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB TOP_COLL = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	public Box_HCM(String unlocalizedName) {
		super(unlocalizedName);
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != BaseFacingSlabW.SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == Kitchen_Blocks.BOX_H_CABBAGE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CABBAGE)) ||
					(this == Kitchen_Blocks.BOX_H_HAKUSAI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_HAKUSAI)) ||
					(this == Kitchen_Blocks.BOX_H_CHERRY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHERRY)) ||
					(this == Kitchen_Blocks.BOX_H_CITRUS && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CITRUS)) ||
					(this == Kitchen_Blocks.BOX_H_CORN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CORN)) ||
					(this == Kitchen_Blocks.BOX_H_GRAPE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_GRAPE)) ||
					(this == Kitchen_Blocks.BOX_H_ONION && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_ONION)) ||
					(this == Kitchen_Blocks.BOX_H_SPINACH && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SPINACH)) ||
					(this == Kitchen_Blocks.BOX_H_TOMATO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TOMATO))) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == Kitchen_Blocks.BOX_H_CABBAGE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CABBAGE)) ||
					(this == Kitchen_Blocks.BOX_H_HAKUSAI && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_HAKUSAI)) ||
					(this == Kitchen_Blocks.BOX_H_CHERRY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHERRY)) ||
					(this == Kitchen_Blocks.BOX_H_CITRUS && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CITRUS)) ||
					(this == Kitchen_Blocks.BOX_H_CORN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CORN)) ||
					(this == Kitchen_Blocks.BOX_H_GRAPE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_GRAPE)) ||
					(this == Kitchen_Blocks.BOX_H_ONION && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_ONION)) ||
					(this == Kitchen_Blocks.BOX_H_SPINACH && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SPINACH)) ||
					(this == Kitchen_Blocks.BOX_H_TOMATO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_TOMATO))) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** Slab は素手で回収可能 **/
		if (state.getValue(DOUBLE) != true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_CABBAGE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CABBAGE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_HAKUSAI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_HAKUSAI, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHERRY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHERRY, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CITRUS) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CITRUS, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CORN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CORN, 1)); }

			if (this == Kitchen_Blocks.BOX_H_GRAPE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_GRAPE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_ONION) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_ONION, 1)); }

			if (this == Kitchen_Blocks.BOX_H_SPINACH) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SPINACH, 1)); }

			if (this == Kitchen_Blocks.BOX_H_TOMATO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TOMATO, 1)); }

			CMEvents.soundItemPick(worldIn, pos);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return true; }


		/* Double */
		/** Double は素手で回収可能 **/
		if (state.getValue(DOUBLE) == true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_CABBAGE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CABBAGE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_HAKUSAI) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_HAKUSAI, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHERRY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHERRY, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CITRUS) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CITRUS, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CORN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CORN, 1)); }

			if (this == Kitchen_Blocks.BOX_H_GRAPE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_GRAPE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_ONION) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_ONION, 1)); }

			if (this == Kitchen_Blocks.BOX_H_SPINACH) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SPINACH, 1)); }

			if (this == Kitchen_Blocks.BOX_H_TOMATO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_TOMATO, 1)); }

			CMEvents.soundItemPick(worldIn, pos);
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(DOUBLE, Boolean.valueOf(false)).withProperty(BaseFacingSlabW.HALF, BaseFacingSlabW.SlabHalf.BOTTOM));
			return true; }

		/** 側面で設置可能にするため false **/
		return false;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		if (state.getValue(DOUBLE) == true) {
			return DOUBLE_AABB;
		}

		else {
			return (state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP)? TOP_AABB : BOTTOM_AABB;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = (state.getValue(DOUBLE) == true);
		BaseFacingSlabW.SlabHalf blockhalf = state.getValue(HALF);

		switch(blockhalf) {
		case TOP :
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : TOP_COLL); /** flag? true : false; **/
			break;
			
		case BOTTOM :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : BOTTOM_AABB);
			break;
		}
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/** Slab **/
		if (state.getValue(DOUBLE) != true) {
			if (this == Kitchen_Blocks.BOX_H_CABBAGE) { stack.add(new ItemStack(Items_Teatime.FOOD_CABBAGE, 4, 0)); }
			if (this == Kitchen_Blocks.BOX_H_HAKUSAI) { stack.add(new ItemStack(Items_Teatime.FOOD_HAKUSAI, 2, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHERRY) { stack.add(new ItemStack(Items_Teatime.FOOD_CHERRY, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CITRUS) { stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CORN) { stack.add(new ItemStack(Items_Teatime.FOOD_CORN, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_GRAPE) { stack.add(new ItemStack(Items_Teatime.FOOD_GRAPE, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_ONION) { stack.add(new ItemStack(Items_Teatime.FOOD_ONION, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_SPINACH) { stack.add(new ItemStack(Items_Teatime.FOOD_SPINACH, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_TOMATO) { stack.add(new ItemStack(Items_Teatime.FOOD_TOMATO, 8, 0)); }
			stack.add(new ItemStack(Items_Teatime.BOX_H_EMPTY, 1, 0));
		}


		/** Double **/
		if (state.getValue(DOUBLE) == true) {
			if (this == Kitchen_Blocks.BOX_H_CABBAGE) { stack.add(new ItemStack(Items_Teatime.FOOD_CABBAGE, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_HAKUSAI) { stack.add(new ItemStack(Items_Teatime.FOOD_HAKUSAI, 4, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHERRY) { stack.add(new ItemStack(Items_Teatime.FOOD_CHERRY, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CITRUS) { stack.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CORN) { stack.add(new ItemStack(Items_Teatime.FOOD_CORN, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_GRAPE) { stack.add(new ItemStack(Items_Teatime.FOOD_GRAPE, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_ONION) { stack.add(new ItemStack(Items_Teatime.FOOD_ONION, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_SPINACH) { stack.add(new ItemStack(Items_Teatime.FOOD_SPINACH, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_TOMATO) { stack.add(new ItemStack(Items_Teatime.FOOD_TOMATO, 16, 0)); }
			stack.add(new ItemStack(Items_Teatime.BOX_H_EMPTY, 2, 0));
		}
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == Kitchen_Blocks.BOX_H_CABBAGE) { return new ItemStack(Items_Teatime.BOX_H_CABBAGE); }
		if (this == Kitchen_Blocks.BOX_H_HAKUSAI) { return new ItemStack(Items_Teatime.BOX_H_HAKUSAI); }
		if (this == Kitchen_Blocks.BOX_H_CHERRY) { return new ItemStack(Items_Teatime.BOX_H_CHERRY); }
		if (this == Kitchen_Blocks.BOX_H_CITRUS) { return new ItemStack(Items_Teatime.BOX_H_CITRUS); }
		if (this == Kitchen_Blocks.BOX_H_CORN) { return new ItemStack(Items_Teatime.BOX_H_CORN); }
		if (this == Kitchen_Blocks.BOX_H_GRAPE) { return new ItemStack(Items_Teatime.BOX_H_GRAPE); }
		if (this == Kitchen_Blocks.BOX_H_ONION) { return new ItemStack(Items_Teatime.BOX_H_ONION); }
		if (this == Kitchen_Blocks.BOX_H_SPINACH) { return new ItemStack(Items_Teatime.BOX_H_SPINACH); }
		if (this == Kitchen_Blocks.BOX_H_TOMATO) { return new ItemStack(Items_Teatime.BOX_H_TOMATO); }
		return new ItemStack(Items_Teatime.BOX_H_EMPTY);
	}

}
