package com.ayutaki.chinjufumod.items.teatime;

import javax.annotation.Nonnull;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemToami_Wide extends ItemBlock {

	public ItemToami_Wide(Block block, String unlocalizedName) {
		super(block);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		playerIn.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		if (!worldIn.isRemote) { playerIn.inventory.deleteStack(itemstack); }
		return ActionResult.newResult(EnumActionResult.PASS, itemstack);
	}
	
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		playerIn.playSound(SoundEvents.ENTITY_ITEM_BREAK, 1.0F, 1.0F);
		playerIn.inventory.deleteStack(itemstack);
		return EnumActionResult.PASS;
	}

}
