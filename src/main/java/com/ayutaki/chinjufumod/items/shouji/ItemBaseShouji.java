package com.ayutaki.chinjufumod.items.shouji;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.shouji.BaseShouji;
import com.ayutaki.chinjufumod.state.BlockStateHalf;
import com.ayutaki.chinjufumod.state.BlockStateHinge;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBaseShouji extends Item {

	private final Block block;

	public ItemBaseShouji(Block block) {
		this.block = block;
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (facing != EnumFacing.UP) {
			return EnumActionResult.FAIL;
		}

		else {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			Block block = iblockstate.getBlock();

			if (!block.isReplaceable(worldIn, pos)) {
				pos = pos.offset(facing);
			}

			ItemStack itemstack = playerIn.getHeldItem(hand);

			/** this.block を具体名にすることも可能？ **/
			if (playerIn.canPlayerEdit(pos, facing, itemstack) && this.block.canPlaceBlockAt(worldIn, pos)) {

				if (playerIn.isSneaking()) {
					EnumFacing direction = EnumFacing.fromAngle((double)playerIn.rotationYaw);
					int i = direction.getFrontOffsetX();
					int j = direction.getFrontOffsetZ();
					boolean flag = i < 0 && hitZ < 0.5F || i > 0 && hitZ > 0.5F || j < 0 && hitX > 0.5F || j > 0 && hitX < 0.5F;
					placeShouji_right(worldIn, pos, direction, this.block, flag);
					SoundType soundtype = worldIn.getBlockState(pos).getBlock().getSoundType(worldIn.getBlockState(pos), worldIn, pos, playerIn);
					worldIn.playSound(playerIn, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					itemstack.shrink(1);

					return EnumActionResult.SUCCESS;
				}

				/** デフォルトは left。右取手・左蝶番で開くのが hinge=left **/
				else {
					EnumFacing direction = EnumFacing.fromAngle((double)playerIn.rotationYaw);
					int i = direction.getFrontOffsetX();
					int j = direction.getFrontOffsetZ();
					boolean flag = i < 0 && hitZ < 0.5F || i > 0 && hitZ > 0.5F || j < 0 && hitX > 0.5F || j > 0 && hitX < 0.5F;
					placeShouji_left(worldIn, pos, direction, this.block, flag);
					SoundType soundtype = worldIn.getBlockState(pos).getBlock().getSoundType(worldIn.getBlockState(pos), worldIn, pos, playerIn);
					worldIn.playSound(playerIn, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
					itemstack.shrink(1);

					return EnumActionResult.SUCCESS;
				}
			}

			else {
				return EnumActionResult.FAIL;
			}
		}
	}

	public static void placeShouji_right(World worldIn, BlockPos pos, EnumFacing facing, Block door, boolean isRightHinge) {

		BlockPos blockpos2 = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos2);
		IBlockState iblockstate = door.getDefaultState().withProperty(BaseShouji.H_FACING, facing)
				.withProperty(BaseShouji.HINGE, BlockStateHinge.RIGHT)
				.withProperty(BaseShouji.POWERED, Boolean.valueOf(flag2))
				.withProperty(BaseShouji.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, iblockstate.withProperty(BaseShouji.HALF, BlockStateHalf.LOWER), 2);
		worldIn.setBlockState(blockpos2, iblockstate.withProperty(BaseShouji.HALF, BlockStateHalf.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(blockpos2, door, false);
	}

	public static void placeShouji_left(World worldIn, BlockPos pos, EnumFacing facing, Block door, boolean isRightHinge) {

		BlockPos blockpos2 = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos2);
		IBlockState iblockstate = door.getDefaultState().withProperty(BaseShouji.H_FACING, facing)
				.withProperty(BaseShouji.HINGE, BlockStateHinge.LEFT)
				.withProperty(BaseShouji.POWERED, Boolean.valueOf(flag2))
				.withProperty(BaseShouji.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, iblockstate.withProperty(BaseShouji.HALF, BlockStateHalf.LOWER), 2);
		worldIn.setBlockState(blockpos2, iblockstate.withProperty(BaseShouji.HALF, BlockStateHalf.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(blockpos2, door, false);
	}

	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_shouji", meta));
	}

}
