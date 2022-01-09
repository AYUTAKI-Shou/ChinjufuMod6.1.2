package com.ayutaki.chinjufumod.items.garden;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiSmall;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

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

public class ItemIkegakiSmall extends ItemBlockBace {

	public ItemIkegakiSmall() {
		super(Garden_Blocks.IKEGAKI_S);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, IkegakiSmall.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.WADECO);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_low_oak";
		case 1:
			return "item." + "block_low_spruce";
		case 2:
			return "item." + "block_low_birch";
		case 3:
			return "item." + "block_low_jungle";
		case 4:
			return "item." + "block_low_acacia";
		case 5:
			return "item." + "block_low_darkoak";
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
		}
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 100;
	}

	/* アイテム使用時の処理 */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int k;
		k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Garden_Blocks.IKEGAKI_S, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				/** ブロックの設置 **/
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(0));
				worldIn.setBlockState(pos, iblockstate1); }

			if (k == 1) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1); }

			if (k == 2) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1); }

			if (k == 3) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1); }

			if (k == 4) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1); }

			if (k == 5) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_S.getDefaultState().withProperty(IkegakiSmall.STAGE_0_9, Integer.valueOf(5));
				worldIn.setBlockState(pos, iblockstate1); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
