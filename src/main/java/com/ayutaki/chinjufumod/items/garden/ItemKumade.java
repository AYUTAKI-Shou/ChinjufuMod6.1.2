package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.garden.Samon;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKumade extends Item {

	public ItemKumade(String unlocalizedName) {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setUnlocalizedName(unlocalizedName);
		setCreativeTab(ChinjufuModTabs.WADECO);

		this.maxStackSize = 1;
		setMaxDamage(128);
	}

	/* FlintAndSteel */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		ItemStack itemstack = playerIn.getHeldItem(hand);

		if (iblockstate.getBlock() instanceof BlockSand && iblockstate.getValue(BlockSand.VARIANT) == BlockSand.EnumType.SAND) {

			worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			worldIn.setBlockState(pos, Garden_Blocks.SAMON.getDefaultState().withProperty(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			itemstack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS; }
		
		if (iblockstate.getBlock() instanceof BlockGravel) {

			worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			worldIn.setBlockState(pos, Garden_Blocks.SAMON_B.getDefaultState().withProperty(Samon.STAGE_0_7, Integer.valueOf(0)), 3);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			itemstack.damageItem(1, playerIn);
			return EnumActionResult.SUCCESS; }

		return EnumActionResult.FAIL;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.STICK);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_kumade", meta));
	}

}
