package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.BaseWindow;
import com.ayutaki.chinjufumod.blocks.window.Window_spruce;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemWindow_spruce extends ItemBaceWindow {

	public ItemWindow_spruce() {
		super(Window_Blocks.WINDOW_spruce);
		setUnlocalizedName(Window_spruce.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Window_spruce.ID));
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Window_Blocks.WINDOW_spruce, pos, false, facing, (Entity)null)) {

			if (playerIn.isSneaking()) {
				/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Window_Blocks.WINDOW_spruce.getDefaultState()
						.withProperty(BaseWindow.H_FACING, direction)
						.withProperty(BaseWindow.STAGE_1_4, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10);

				SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
				worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

				itemstack.shrink(1);
				return EnumActionResult.SUCCESS; }

			else {
				IBlockState iblockstate1 = Window_Blocks.WINDOW_spruce.getDefaultState()
						.withProperty(BaseWindow.H_FACING, direction)
						.withProperty(BaseWindow.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10);

				SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
				worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

				itemstack.shrink(1);
				return EnumActionResult.SUCCESS; }
			}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
