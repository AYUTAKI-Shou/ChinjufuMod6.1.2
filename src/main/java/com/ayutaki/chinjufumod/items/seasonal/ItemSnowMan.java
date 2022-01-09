package com.ayutaki.chinjufumod.items.seasonal;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.season.Base_SnowManBot;
import com.ayutaki.chinjufumod.blocks.season.Base_SnowManTop;
import com.ayutaki.chinjufumod.blocks.season.SnowMan_Bot1;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class ItemSnowMan extends ItemBlockBace {

	public ItemSnowMan() {
		super(Seasonal_Blocks.SNOWMAN_BOT1);
		setUnlocalizedName(SnowMan_Bot1.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, SnowMan_Bot1.ID));

		setCreativeTab(ChinjufuModTabs.SEASONAL);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D を 4.0F / 360.0F) + 2.5D に変えて180度回転 */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack itemstack = playerIn.getHeldItem(hand);

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()
				&& worldIn.mayPlace(Seasonal_Blocks.SNOWMAN_BOT1, pos, false, facing, (Entity)null)) {

			if (block == Blocks.SNOW) {
				IBlockState downstate = Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, direction)
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1));
				IBlockState upstate = Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
						.withProperty(Base_SnowManTop.H_FACING, direction)
						.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, downstate, 10);
				worldIn.setBlockState(pos.up(), upstate, 10); }

			if (block != Blocks.SNOW) {
				IBlockState downstate = Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, direction)
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1));
				IBlockState upstate = Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
						.withProperty(Base_SnowManTop.H_FACING, direction)
						.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, downstate, 10);
				worldIn.setBlockState(pos.up(), upstate, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
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
		tooltip.add(I18n.format("tips.block_snowman", meta));
	}

}
