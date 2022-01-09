package com.ayutaki.chinjufumod.items.crops;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Nae;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemTest_1 extends ItemBlockBace {

	public ItemTest_1() {
		super(Crop_Blocks.MIKAN);
		setUnlocalizedName("1");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "0"));

		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "0";
		case 1:
			return "item." + "1";
		case 2:
			return "item." + "2";
		case 3:
			return "item." + "3";
		case 4:
			return "item." + "4";
		case 5:
			return "item." + "5";
		case 6:
			return "item." + "6";
		case 7:
			return "item." + "7";
		case 8:
			return "item." + "8";
		case 9:
			return "item." + "9";
		case 10:
			return "item." + "10";
		case 11:
			return "item." + "11";
		case 12:
			return "item." + "12";
		case 13:
			return "item." + "13";
		case 14:
			return "item." + "14";
		case 15:
			return "item." + "15";
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

		/** ブロック上で反応させる **/
		IBlockState iblockstate = worldIn.getBlockState(pos);

		/** 土ブロックの上面のみで使用 **/
		if (iblockstate.getBlock() == Blocks.DIRT && facing == EnumFacing.UP) {

			ItemStack itemstack = playerIn.getHeldItem(hand);
			int k;
			k = itemstack.getMetadata();

			if (playerIn.canPlayerEdit(pos, facing, itemstack)) {

				if (k == 0) {
					/** 設置するブロックのクラス **/
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(0));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 1) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(1));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 2) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(2));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 3) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(3));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 4) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(4));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 5) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(5));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 6) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(6));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 7) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(7));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 8) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(8));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 9) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(9));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 10) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(10));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 11) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(11));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 12) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(12));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 13) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(13));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 14) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(14));
					worldIn.setBlockState(pos, iblockstate1, 10); }
				if (k == 15) {
					IBlockState iblockstate1 = Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(15));
					worldIn.setBlockState(pos, iblockstate1, 10); }

				worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			}

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos.up(), itemstack);
			}
			/** 手に持っているアイテムを１個消費 **/
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_wood_chanoki_nae", meta));
	}

}
