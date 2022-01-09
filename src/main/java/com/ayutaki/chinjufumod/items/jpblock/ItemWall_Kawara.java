package com.ayutaki.chinjufumod.items.jpblock;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_WallKawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemWall_Kawara extends ItemBlockBace {

	public ItemWall_Kawara() {
		super(JPBlock_Blocks.KAWARA_WALL);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Wall_Kawara.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.WABLOCK);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_kwall_white";
		case 1:
			return "item." + "block_kwall_orange";
		case 2:
			return "item." + "block_kwall_magenta";
		case 3:
			return "item." + "block_kwall_lightb";
		case 4:
			return "item." + "block_kwall_yellow";
		case 5:
			return "item." + "block_kwall_lime";
		case 6:
			return "item." + "block_kwall_pink";
		case 7:
			return "item." + "block_kwall_gray";
		case 8:
			return "item." + "block_kwall_lightg";
		case 9:
			return "item." + "block_kwall_cyan";
		case 10:
			return "item." + "block_kwall_purple";
		case 11:
			return "item." + "block_kwall_blue";
		case 12:
			return "item." + "block_kwall_brown";
		case 13:
			return "item." + "block_kwall_green";
		case 14:
			return "item." + "block_kwall_red";
		case 15:
			return "item." + "block_kwall_black";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
			items.add(new ItemStack(this, 1, 6));
			items.add(new ItemStack(this, 1, 7));
			items.add(new ItemStack(this, 1, 8));
			items.add(new ItemStack(this, 1, 9));
			items.add(new ItemStack(this, 1, 10));
			items.add(new ItemStack(this, 1, 11));
			items.add(new ItemStack(this, 1, 12));
			items.add(new ItemStack(this, 1, 13));
			items.add(new ItemStack(this, 1, 14));
			items.add(new ItemStack(this, 1, 15));
		}
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int k;
		k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(JPBlock_Blocks.KAWARA_WALL, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				/** ブロックの設置 **/
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(0));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 1) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 2) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 3) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 4) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 5) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(5));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 6) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(6));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 7) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(7));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 8) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(8));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 9) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(9));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 10) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(10));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 11) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(11));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 12) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(12));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 13) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(13));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 14) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(14));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 15) {
				IBlockState iblockstate1 = JPBlock_Blocks.KAWARA_WALL.getDefaultState().withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(15));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
