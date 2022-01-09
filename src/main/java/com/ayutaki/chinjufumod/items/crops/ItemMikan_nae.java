package com.ayutaki.chinjufumod.items.crops;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Nae;
import com.ayutaki.chinjufumod.blocks.crop.Mikan_Top;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMikan_nae extends ItemBlockBace {

	public ItemMikan_nae() {
		super(Crop_Blocks.MIKAN);
		setUnlocalizedName(Mikan_Nae.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Mikan_Nae.ID));
		setCreativeTab(ChinjufuModTabs.TEATIME);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);

		/** 土ブロックの上面のみで使用 **/
		if (iblockstate.getBlock() == Blocks.DIRT && facing == EnumFacing.UP) {

			ItemStack itemstack = playerIn.getHeldItem(hand);

			if (playerIn.canPlayerEdit(pos, facing, itemstack)) {

				/** pos.up() で土ブロックの上にブロックを生成 **/
				worldIn.setBlockState(pos.up(1), Crop_Blocks.MIKAN.getDefaultState().withProperty(Mikan_Nae.STAGE_0_11, Integer.valueOf(0)), 10);
				worldIn.setBlockState(pos.up(2), Crop_Blocks.MIKAN_TOP.getDefaultState().withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(0)), 10);

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
		tooltip.add(I18n.format("tips.block_wood_mikan", meta));
	}

}
