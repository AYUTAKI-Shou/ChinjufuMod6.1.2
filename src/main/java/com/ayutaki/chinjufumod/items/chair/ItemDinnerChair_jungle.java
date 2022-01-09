package com.ayutaki.chinjufumod.items.chair;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.chair.Base_DiningChair;
import com.ayutaki.chinjufumod.blocks.chair.Base_DiningChair.Half;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDinnerChair_jungle extends ItemBlockBace {

	public ItemDinnerChair_jungle() {
		super(Furniture_Blocks.DININGCHAIR);
		setUnlocalizedName("block_diningchair_j");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "block_diningchair_j"));

		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 150;
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D を 4.0F / 360.0F) + 2.5D に変えて180度回転 */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack itemstack = playerIn.getHeldItem(hand);

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Furniture_Blocks.DININGCHAIR_j, pos, false, facing, (Entity)null)) {

			/** 設置するブロックのクラス **/
			worldIn.setBlockState(pos, Furniture_Blocks.DININGCHAIR_j.getDefaultState()
					.withProperty(Base_DiningChair.H_FACING, direction)
					.withProperty(Base_DiningChair.HALF, Half.LOWER), 10);
			worldIn.setBlockState(pos.up(), Furniture_Blocks.DININGCHAIR_j.getDefaultState()
					.withProperty(Base_DiningChair.H_FACING, direction)
					.withProperty(Base_DiningChair.HALF, Half.UPPER), 10);

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_isu", meta));
	}

}
