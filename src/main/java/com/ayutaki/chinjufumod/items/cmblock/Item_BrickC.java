package com.ayutaki.chinjufumod.items.cmblock;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.wallpane.Bricks_CM;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

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

public class Item_BrickC extends ItemBlockBace {

	public Item_BrickC() {
		super(WallBrick_Blocks.ROCK);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Bricks_CM.ID));
		setCreativeTab(ChinjufuModTabs.WALLPANEL);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_brick_gra_c";
		case 2:
			return "item." + "block_brick_dio_c";
		case 3:
			return "item." + "block_brick_and_c";
		case 4:
			return "item." + "block_brick_gra_ch_c";
		case 5:
			return "item." + "block_brick_dio_ch_c";
		case 6:
			return "item." + "block_brick_and_ch_c";
		case 7:
			return "item." + "block_brick_dio_cr_c";
		case 8:
			return "item." + "block_brick_gra_cr_c";
		case 9:
			return "item." + "block_brick_and_cr_c";
		case 10:
			return "item." + "block_brick_gra_mos_c";
		case 11:
			return "item." + "block_brick_dio_mos_c";
		case 12:
			return "item." + "block_brick_and_mos_c";

		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(WallBrick_Blocks.ROCK, pos, false, facing, (Entity)null)) {

			if (k == 1) {
				/** ブロックの設置 **/
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 2) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 3) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 4) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 5) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(5));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 6) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(6));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 7) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(7));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 8) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(8));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 9) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(9));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 10) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(10));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 11) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(11));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 12) {
				IBlockState iblockstate1 = WallBrick_Blocks.ROCK.getDefaultState().withProperty(Bricks_CM.STAGE_1_14, Integer.valueOf(12));
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
