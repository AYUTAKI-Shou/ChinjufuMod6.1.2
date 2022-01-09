package com.ayutaki.chinjufumod.items.window;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Bottom;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Top;
import com.ayutaki.chinjufumod.blocks.window.WindowTallBot_sakura;
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

public class ItemWindowTallBot_sakura extends ItemBaseWindowTall_Bot {

	public ItemWindowTallBot_sakura() {
		super(Window_Blocks.WINDOWTALLBOT_sakura);
		setUnlocalizedName(WindowTallBot_sakura.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, WindowTallBot_sakura.ID));
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Window_Blocks.WINDOWTALLBOT_sakura, pos, false, facing, (Entity)null)) {

			/** 設置するブロックのクラス **/
			IBlockState iblockstate1 = Window_Blocks.WINDOWTALLBOT_sakura.getDefaultState()
					.withProperty(BaseWindowTall_Bottom.H_FACING, direction)
					.withProperty(BaseWindowTall_Bottom.STAGE_1_3, Integer.valueOf(1));
			IBlockState iblockstate2 = Window_Blocks.WINDOWTALLTOP_sakura.getDefaultState()
					.withProperty(BaseWindowTall_Top.H_FACING, direction)
					.withProperty(BaseWindowTall_Top.STAGE_1_3, Integer.valueOf(1));

			/** worldIn.setBlockState(pos, newState, flags) **/
			worldIn.setBlockState(pos, iblockstate1);
			worldIn.setBlockState(pos.up(), iblockstate2);

			SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
			worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}


}