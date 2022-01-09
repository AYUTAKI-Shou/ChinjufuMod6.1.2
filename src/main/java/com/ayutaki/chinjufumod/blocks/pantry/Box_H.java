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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Box_H extends BaseFacingSlabW {

	/* Collision */
	private static final AxisAlignedBB DOUBLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	private static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB TOP_COLL = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	public Box_H(String unlocalizedName) {
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

			if ((this == Kitchen_Blocks.BOX_H_EMPTY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_EMPTY)) ||
					(this == Kitchen_Blocks.BOX_H_APPLE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_APPLE)) ||
					(this == Kitchen_Blocks.BOX_H_BEEF && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BEEF)) ||
					(this == Kitchen_Blocks.BOX_H_BEETROOT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BEETROOT)) ||
					(this == Kitchen_Blocks.BOX_H_BREAD && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BREAD)) ||
					(this == Kitchen_Blocks.BOX_H_CARROT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CARROT)) ||
					(this == Kitchen_Blocks.BOX_H_CHICKEN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHICKEN)) ||
					(this == Kitchen_Blocks.BOX_H_CHORUS && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHORUS)) ||
					(this == Kitchen_Blocks.BOX_H_EGG && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_EGG)) ||
					(this == Kitchen_Blocks.BOX_H_FISH && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_FISH)) ||
					(this == Kitchen_Blocks.BOX_H_MUTTON && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_MUTTON)) ||
					(this == Kitchen_Blocks.BOX_H_PORK && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_PORK)) ||
					(this == Kitchen_Blocks.BOX_H_POTATO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_POTATO)) ||
					(this == Kitchen_Blocks.BOX_H_RABBIT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_RABBIT)) ||
					(this == Kitchen_Blocks.BOX_H_SALMON && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SALMON))) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == Kitchen_Blocks.BOX_H_EMPTY && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_EMPTY)) ||
					(this == Kitchen_Blocks.BOX_H_APPLE && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_APPLE)) ||
					(this == Kitchen_Blocks.BOX_H_BEEF && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BEEF)) ||
					(this == Kitchen_Blocks.BOX_H_BEETROOT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BEETROOT)) ||
					(this == Kitchen_Blocks.BOX_H_BREAD && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_BREAD)) ||
					(this == Kitchen_Blocks.BOX_H_CARROT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CARROT)) ||
					(this == Kitchen_Blocks.BOX_H_CHICKEN && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHICKEN)) ||
					(this == Kitchen_Blocks.BOX_H_CHORUS && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_CHORUS)) ||
					(this == Kitchen_Blocks.BOX_H_EGG && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_EGG)) ||
					(this == Kitchen_Blocks.BOX_H_FISH && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_FISH)) ||
					(this == Kitchen_Blocks.BOX_H_MUTTON && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_MUTTON)) ||
					(this == Kitchen_Blocks.BOX_H_PORK && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_PORK)) ||
					(this == Kitchen_Blocks.BOX_H_POTATO && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_POTATO)) ||
					(this == Kitchen_Blocks.BOX_H_RABBIT && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_RABBIT)) ||
					(this == Kitchen_Blocks.BOX_H_SALMON && item == Item.getItemFromBlock(Kitchen_Blocks.BOX_H_SALMON))) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** Slab は素手で回収可能 **/
		if (state.getValue(DOUBLE) != true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_EMPTY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_EMPTY, 1)); }

			if (this == Kitchen_Blocks.BOX_H_APPLE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_APPLE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BEEF) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BEEF, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BEETROOT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BEETROOT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BREAD) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BREAD, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CARROT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CARROT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHICKEN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHICKEN, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHORUS) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHORUS, 1)); }

			if (this == Kitchen_Blocks.BOX_H_EGG) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_EGG, 1)); }

			if (this == Kitchen_Blocks.BOX_H_FISH) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_FISH, 1)); }

			if (this == Kitchen_Blocks.BOX_H_MUTTON) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_MUTTON, 1)); }

			if (this == Kitchen_Blocks.BOX_H_PORK) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_PORK, 1)); }

			if (this == Kitchen_Blocks.BOX_H_POTATO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_POTATO, 1)); }

			if (this == Kitchen_Blocks.BOX_H_RABBIT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_RABBIT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_SALMON) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SALMON, 1)); }

			CMEvents.soundItemPick(worldIn, pos);
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			return true; }


		/* Double */
		/** Double は素手で回収可能 **/
		if (state.getValue(DOUBLE) == true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == Kitchen_Blocks.BOX_H_EMPTY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_EMPTY, 1)); }

			if (this == Kitchen_Blocks.BOX_H_APPLE) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_APPLE, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BEEF) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BEEF, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BEETROOT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BEETROOT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_BREAD) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_BREAD, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CARROT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CARROT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHICKEN) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHICKEN, 1)); }

			if (this == Kitchen_Blocks.BOX_H_CHORUS) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_CHORUS, 1)); }

			if (this == Kitchen_Blocks.BOX_H_EGG) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_EGG, 1)); }

			if (this == Kitchen_Blocks.BOX_H_FISH) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_FISH, 1)); }

			if (this == Kitchen_Blocks.BOX_H_MUTTON) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_MUTTON, 1)); }

			if (this == Kitchen_Blocks.BOX_H_PORK) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_PORK, 1)); }

			if (this == Kitchen_Blocks.BOX_H_POTATO) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_POTATO, 1)); }

			if (this == Kitchen_Blocks.BOX_H_RABBIT) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_RABBIT, 1)); }

			if (this == Kitchen_Blocks.BOX_H_SALMON) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.BOX_H_SALMON, 1)); }

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
			if (this == Kitchen_Blocks.BOX_H_EMPTY) { }
			if (this == Kitchen_Blocks.BOX_H_APPLE) { stack.add(new ItemStack(Items.APPLE, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BEEF) { stack.add(new ItemStack(Items.BEEF, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BEETROOT) { stack.add(new ItemStack(Items.BEETROOT, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BREAD) { stack.add(new ItemStack(Items.BREAD, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CARROT) { stack.add(new ItemStack(Items.CARROT, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHICKEN) { stack.add(new ItemStack(Items.CHICKEN, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHORUS) { stack.add(new ItemStack(Items.CHORUS_FRUIT, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_EGG) { stack.add(new ItemStack(Items.EGG, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_FISH) { stack.add(new ItemStack(Items.FISH, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_MUTTON) { stack.add(new ItemStack(Items.MUTTON, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_PORK) { stack.add(new ItemStack(Items.PORKCHOP, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_POTATO) { stack.add(new ItemStack(Items.POTATO, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_RABBIT) { stack.add(new ItemStack(Items.RABBIT, 8, 0)); }
			if (this == Kitchen_Blocks.BOX_H_SALMON) { stack.add(new ItemStack(Items.FISH, 8, 1)); }
			stack.add(new ItemStack(Items_Teatime.BOX_H_EMPTY, 1, 0));
		}


		/** Double **/
		if (state.getValue(DOUBLE) == true) {
			if (this == Kitchen_Blocks.BOX_H_EMPTY) { }
			if (this == Kitchen_Blocks.BOX_H_APPLE) { stack.add(new ItemStack(Items.APPLE, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BEEF) { stack.add(new ItemStack(Items.BEEF, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BEETROOT) { stack.add(new ItemStack(Items.BEETROOT, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_BREAD) { stack.add(new ItemStack(Items.BREAD, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CARROT) { stack.add(new ItemStack(Items.CARROT, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHICKEN) { stack.add(new ItemStack(Items.CHICKEN, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_CHORUS) { stack.add(new ItemStack(Items.CHORUS_FRUIT, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_EGG) { stack.add(new ItemStack(Items.EGG, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_FISH) { stack.add(new ItemStack(Items.FISH, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_MUTTON) { stack.add(new ItemStack(Items.MUTTON, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_PORK) { stack.add(new ItemStack(Items.PORKCHOP, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_POTATO) { stack.add(new ItemStack(Items.POTATO, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_RABBIT) { stack.add(new ItemStack(Items.RABBIT, 16, 0)); }
			if (this == Kitchen_Blocks.BOX_H_SALMON) { stack.add(new ItemStack(Items.FISH, 16, 1)); }
			stack.add(new ItemStack(Items_Teatime.BOX_H_EMPTY, 2, 0));
		}
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == Kitchen_Blocks.BOX_H_EMPTY) { return new ItemStack(Items_Teatime.BOX_H_EMPTY); }
		if (this == Kitchen_Blocks.BOX_H_APPLE) { return new ItemStack(Items_Teatime.BOX_H_APPLE); }
		if (this == Kitchen_Blocks.BOX_H_BEEF) { return new ItemStack(Items_Teatime.BOX_H_BEEF); }
		if (this == Kitchen_Blocks.BOX_H_BEETROOT) { return new ItemStack(Items_Teatime.BOX_H_BEETROOT); }
		if (this == Kitchen_Blocks.BOX_H_BREAD) { return new ItemStack(Items_Teatime.BOX_H_BREAD); }
		if (this == Kitchen_Blocks.BOX_H_CARROT) { return new ItemStack(Items_Teatime.BOX_H_CARROT); }
		if (this == Kitchen_Blocks.BOX_H_CHICKEN) { return new ItemStack(Items_Teatime.BOX_H_CHICKEN); }
		if (this == Kitchen_Blocks.BOX_H_CHORUS) { return new ItemStack(Items_Teatime.BOX_H_CHORUS); }
		if (this == Kitchen_Blocks.BOX_H_EGG) { return new ItemStack(Items_Teatime.BOX_H_EGG); }
		if (this == Kitchen_Blocks.BOX_H_FISH) { return new ItemStack(Items_Teatime.BOX_H_FISH); }
		if (this == Kitchen_Blocks.BOX_H_MUTTON) { return new ItemStack(Items_Teatime.BOX_H_MUTTON); }
		if (this == Kitchen_Blocks.BOX_H_PORK) { return new ItemStack(Items_Teatime.BOX_H_PORK); }
		if (this == Kitchen_Blocks.BOX_H_POTATO) { return new ItemStack(Items_Teatime.BOX_H_POTATO); }
		if (this == Kitchen_Blocks.BOX_H_RABBIT) { return new ItemStack(Items_Teatime.BOX_H_RABBIT); }
		if (this == Kitchen_Blocks.BOX_H_SALMON) { return new ItemStack(Items_Teatime.BOX_H_SALMON); }
		return new ItemStack(Items_Teatime.BOX_H_EMPTY);
	}

}
