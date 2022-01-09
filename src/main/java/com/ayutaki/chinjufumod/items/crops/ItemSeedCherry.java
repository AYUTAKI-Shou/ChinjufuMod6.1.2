package com.ayutaki.chinjufumod.items.crops;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSeedCherry extends ItemBlockBace {

	public ItemSeedCherry() {
		super(Crop_Blocks.SAKURA);
		setUnlocalizedName("item_seeds_cherry");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "item_seeds_cherry"));
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

				/** 生成するブロック **/
				IBlockState iblockstate1 = Crop_Blocks.SAKURA.getDefaultState()
						.withProperty(BlockCrops.AGE, Integer.valueOf(0));

				/** pos.up() で耕地の上にブロックを生成 **/
				worldIn.setBlockState(pos.up(), iblockstate1, 10);

				SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
				worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
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
