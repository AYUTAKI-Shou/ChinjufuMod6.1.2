package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Base_Niwaishi;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemChisel extends Item {

	public ItemChisel(String unlocalizedName) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(ChinjufuModTabs.WADECO);

		this.maxStackSize = 1;
		setMaxDamage(256);
	}

	/* FlintAndSteel */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		ItemStack itemstack = playerIn.getHeldItem(hand);

		/** Stone **/
		if (iblockstate.getBlock() instanceof BlockStone) {
			if (iblockstate.getValue(BlockStone.VARIANT) == BlockStone.EnumType.STONE) {
				CMEvents.soundChisel(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				itemstack.damageItem(1, playerIn);
				return EnumActionResult.SUCCESS;
			}

			if (iblockstate.getValue(BlockStone.VARIANT) == BlockStone.EnumType.GRANITE) {
				CMEvents.soundChisel(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_gra.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				itemstack.damageItem(1, playerIn);
				return EnumActionResult.SUCCESS;
			}

			if (iblockstate.getValue(BlockStone.VARIANT) == BlockStone.EnumType.DIORITE) {
				CMEvents.soundChisel(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_dio.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				itemstack.damageItem(1, playerIn);
				return EnumActionResult.SUCCESS;
			}

			if (iblockstate.getValue(BlockStone.VARIANT) == BlockStone.EnumType.ANDESITE) {
				CMEvents.soundChisel(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_and.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				itemstack.damageItem(1, playerIn);
				return EnumActionResult.SUCCESS;
			}
		}

		/** Slab **/
		if (iblockstate.getBlock() instanceof BlockStoneSlab) {
			if (iblockstate.getValue(BlockStoneSlab.VARIANT) == BlockStoneSlab.EnumType.STONE) {
				CMEvents.soundChisel(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_slab.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				itemstack.damageItem(1, playerIn);
				return EnumActionResult.SUCCESS;
			}
		}
		
		if (iblockstate.getBlock() == WallBrick_Blocks.RGRA_slabhalf) {
			CMEvents.soundChisel(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_gra.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			itemstack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS;
		}
		
		if (iblockstate.getBlock() == WallBrick_Blocks.RDIO_slabhalf) {
			CMEvents.soundChisel(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_dio.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			itemstack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS;
		}
		
		if (iblockstate.getBlock() == WallBrick_Blocks.RAND_slabhalf) {
			CMEvents.soundChisel(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Garden_Blocks.NIWAISHI_slab_and.getDefaultState().withProperty(Base_Niwaishi.STAGE_0_15, Integer.valueOf(0)), 3);
			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			itemstack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS;
		}

		return EnumActionResult.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_chisel", meta));
	}

}
