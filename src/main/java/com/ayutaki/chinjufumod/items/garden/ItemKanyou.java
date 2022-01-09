package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou2_Top;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Bottom;
import com.ayutaki.chinjufumod.blocks.garden.Kanyou_Top;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKanyou extends ItemBlockBace {

	public ItemKanyou() {
		super(Garden_Blocks.KANYOU_BOT);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Kanyou_Bottom.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.WADECO);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 0:
		default:
			return "item." + "block_kanyouoak_bot";
		case 1:
			return "item." + "block_kanyouspruce_bot";
		case 2:
			return "item." + "block_kanyoubirch_bot";
		case 3:
			return "item." + "block_kanyoujungle_bot";
		case 4:
			return "item." + "block_kanyouacacia_bot";
		case 5:
			return "item." + "block_kanyoudarkoak_bot";
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

		if (!playerIn.isSneaking() && !itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Garden_Blocks.KANYOU_BOT, pos, false, facing, (Entity)null)) {
	
			if (k == 0) {
					/** ブロックの設置 **/
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(0));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(0));
				/** worldIn.setBlockState(pos, newState, flags) **/
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 1) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(1));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 2) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(2));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 3) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(3));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 4) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(4));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 5) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU_BOT.getDefaultState().withProperty(Kanyou_Bottom.STAGE_0_9, Integer.valueOf(5));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU_TOP.getDefaultState().withProperty(Kanyou_Top.STAGE_0_9, Integer.valueOf(5));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }
			
			worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}
		
		if (playerIn.isSneaking() && !itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Garden_Blocks.KANYOU2_BOT, pos, false, facing, (Entity)null)) {
	
			if (k == 0) {
					/** ブロックの設置 **/
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(0));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(0));
				/** worldIn.setBlockState(pos, newState, flags) **/
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 1) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(1));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 2) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(2));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 3) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(3));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 4) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(4));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1);
				worldIn.setBlockState(pos.up(), iblockstate2); }

			if (k == 5) {
				IBlockState iblockstate1 = Garden_Blocks.KANYOU2_BOT.getDefaultState().withProperty(Kanyou2_Bottom.STAGE_0_9, Integer.valueOf(5));
				IBlockState iblockstate2 = Garden_Blocks.KANYOU2_TOP.getDefaultState().withProperty(Kanyou2_Top.STAGE_0_9, Integer.valueOf(5));
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

	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kanyou", meta));
	}
	
}
