package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.ToamiEntity;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToami extends Item {

	public ItemToami(String unlocalizedName) {
		super();
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));
		setCreativeTab(ChinjufuModTabs.TEATIME);

		setMaxStackSize(1);
		setMaxDamage(12);
	}

	/* 投げて使用 */
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);

		playerIn.playSound(SoundEvents_CM.THROW, 1.0F, 1.0F);
		
		if (!worldIn.isRemote) {
			/** Entity の速度≒飛距離 **/
			int j = 6;
			
			if (playerIn.capabilities.isCreativeMode) {
				ToamiEntity toami = new ToamiEntity(worldIn, playerIn, itemstack);
				toami.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.spawnEntity(toami);

				playerIn.inventory.deleteStack(itemstack); }

			if (!playerIn.capabilities.isCreativeMode) {

				/* 耐久不足による発艦失敗 */
				if (itemstack.getItemDamage() >= (itemstack.getMaxDamage() - 1)) {
					worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.MASTER, 1.0F, 1.0F);
					itemstack.shrink(1); }

				else {
					/** 発艦時に耐久消費 **/
					itemstack.damageItem(1, playerIn);

					ToamiEntity toami = new ToamiEntity(worldIn, playerIn, itemstack);
					toami.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
					worldIn.spawnEntity(toami);
					
					itemstack.shrink(1); } }
			}

		return ActionResult.newResult(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Item.getItemFromBlock(Blocks.WEB));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_toami", meta));
	}
}
