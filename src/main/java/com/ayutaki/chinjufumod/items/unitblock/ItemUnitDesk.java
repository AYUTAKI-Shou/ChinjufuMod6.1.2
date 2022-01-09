package com.ayutaki.chinjufumod.items.unitblock;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.unitblock.UnitDesk;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

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

public class ItemUnitDesk extends ItemBlockBace {

	public ItemUnitDesk() {
		super(Unit_Blocks.UNITDESK);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, UnitDesk.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_unitdesk";
		case 1:
			return "item." + "block_unitdesk_spruce";
		case 2:
			return "item." + "block_unitdesk_birch";
		case 3:
			return "item." + "block_unitdesk_jungle";
		case 4:
			return "item." + "block_unitdesk_acacia";
		case 5:
			return "item." + "block_unitdesk_darkoak";
		case 6:
			return "item." + "block_unitdesk_sakura";
		case 7:
			return "item." + "block_unitdesk_kaede";
		case 8:
			return "item." + "block_unitdesk_ichoh";
		}
	}

	@Override
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
		}
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int k;
		k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Unit_Blocks.UNITDESK, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				/** ブロックの設置 **/
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(0));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 1) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 2) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 3) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 4) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 5) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(5));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 6) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(6));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 7) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(7));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 8) {
				IBlockState iblockstate1 = Unit_Blocks.UNITDESK.getDefaultState().withProperty(UnitDesk.STAGE_0_8, Integer.valueOf(8));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}

