package com.ayutaki.chinjufumod.items.garden;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.IkegakiLong_Top;
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

public class ItemSeason_IkegakiLong extends ItemBlockBace {

	public ItemSeason_IkegakiLong() {
		super(Garden_Blocks.IKEGAKI_L_BOT);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "block_longsakura_bot"));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_longsakura_bot";
		case 1:
			return "item." + "block_longkaede_bot";
		case 2:
			return "item." + "block_longichoh_bot";
		case 3:
			return "item." + "block_longoakkare_bot";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Garden_Blocks.IKEGAKI_L_BOT, pos, false, facing, (Entity)null)) {

			if (k == 0) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_L_BOT.getDefaultState().withProperty(IkegakiLong_Bottom.STAGE_0_9, Integer.valueOf(6));
				IBlockState iblockstate2 = Garden_Blocks.IKEGAKI_L_TOP.getDefaultState().withProperty(IkegakiLong_Top.STAGE_0_9, Integer.valueOf(6));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 1) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_L_BOT.getDefaultState().withProperty(IkegakiLong_Bottom.STAGE_0_9, Integer.valueOf(7));
				IBlockState iblockstate2 = Garden_Blocks.IKEGAKI_L_TOP.getDefaultState().withProperty(IkegakiLong_Top.STAGE_0_9, Integer.valueOf(7));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 2) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_L_BOT.getDefaultState().withProperty(IkegakiLong_Bottom.STAGE_0_9, Integer.valueOf(8));
				IBlockState iblockstate2 = Garden_Blocks.IKEGAKI_L_TOP.getDefaultState().withProperty(IkegakiLong_Top.STAGE_0_9, Integer.valueOf(8));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 3) {
				IBlockState iblockstate1 = Garden_Blocks.IKEGAKI_L_BOT.getDefaultState().withProperty(IkegakiLong_Bottom.STAGE_0_9, Integer.valueOf(9));
				IBlockState iblockstate2 = Garden_Blocks.IKEGAKI_L_TOP.getDefaultState().withProperty(IkegakiLong_Top.STAGE_0_9, Integer.valueOf(9));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
			}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
