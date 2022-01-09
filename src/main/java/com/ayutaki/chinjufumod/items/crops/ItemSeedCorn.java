package com.ayutaki.chinjufumod.items.crops;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSeedCorn extends ItemBlockBace {

	public ItemSeedCorn() {
		super(Crop_Blocks.CORN);
		setUnlocalizedName("item_seeds_corn");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "item_seeds_corn"));
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);

		/** 耕地の上面のみで使用 **/
		if (iblockstate.getBlock() == Blocks.FARMLAND && facing == EnumFacing.UP) {

			ItemStack itemstack = playerIn.getHeldItem(hand);

			if (playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

				/** pos.up() で耕地の上にブロックを生成 **/
				worldIn.setBlockState(pos.up(1), Crop_Blocks.CORN.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);
				worldIn.setBlockState(pos.up(2), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(BlockCrops.AGE, Integer.valueOf(0)), 10);

				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
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

}
