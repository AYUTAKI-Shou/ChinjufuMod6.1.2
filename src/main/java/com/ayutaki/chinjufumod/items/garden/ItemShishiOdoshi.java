package com.ayutaki.chinjufumod.items.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.garden.ShishiOdoshi;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;

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

public class ItemShishiOdoshi extends ItemBlockBace {

	public ItemShishiOdoshi() {
		super(Garden_Blocks.SHISHIODOSHI);
		setUnlocalizedName(ShishiOdoshi.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ShishiOdoshi.ID));

		setCreativeTab(ChinjufuModTabs.WADECO);
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Garden_Blocks.SHISHIODOSHI, pos, false, facing, (Entity)null)) {

			if (playerIn.isSneaking()) {
				/** ブロックの設置 **/
				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHIB.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10);
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_TB.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10);

				worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				itemstack.shrink(1);
				return EnumActionResult.SUCCESS; }

			else {
				/** ブロックの設置 **/
				worldIn.setBlockState(pos, Garden_Blocks.SHISHIODOSHI.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10);
				worldIn.setBlockState(pos.up(), Garden_Blocks.SHISHIODOSHI_T.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)), 10);

				worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				itemstack.shrink(1);
				return EnumActionResult.SUCCESS; }
		}

		else {
			return EnumActionResult.FAIL;
		}
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_shishiodoshi", meta));
	}

}
