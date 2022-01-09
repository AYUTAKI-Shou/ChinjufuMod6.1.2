package com.ayutaki.chinjufumod.items.glassdoor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.glassdoor.Base_GlassDoor;

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

public class ItemBaseGarasudo extends Item {

	private final Block block;

	public ItemBaseGarasudo(Block block) {
		this.block = block;
	}

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
					placeGarasudo_right(worldIn, pos, direction, this.block, flag);
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
					placeGarasudo_left(worldIn, pos, direction, this.block, flag);
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

	public static void placeGarasudo_right(World worldIn, BlockPos pos, EnumFacing facing, Block door, boolean isRightHinge) {

		BlockPos blockpos2 = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos2);
		IBlockState iblockstate = door.getDefaultState().withProperty(Base_GlassDoor.H_FACING, facing)
				.withProperty(Base_GlassDoor.HINGE, Base_GlassDoor.EnumHingePosition.RIGHT)
				.withProperty(Base_GlassDoor.POWERED, Boolean.valueOf(flag2))
				.withProperty(Base_GlassDoor.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, iblockstate.withProperty(Base_GlassDoor.HALF, Base_GlassDoor.EnumGarasudoHalf.LOWER), 2);
		worldIn.setBlockState(blockpos2, iblockstate.withProperty(Base_GlassDoor.HALF, Base_GlassDoor.EnumGarasudoHalf.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(blockpos2, door, false);
	}

	public static void placeGarasudo_left(World worldIn, BlockPos pos, EnumFacing facing, Block door, boolean isRightHinge) {

		BlockPos blockpos2 = pos.up();
		boolean flag2 = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos2);
		IBlockState iblockstate = door.getDefaultState().withProperty(Base_GlassDoor.H_FACING, facing)
				.withProperty(Base_GlassDoor.HINGE, Base_GlassDoor.EnumHingePosition.LEFT)
				.withProperty(Base_GlassDoor.POWERED, Boolean.valueOf(flag2))
				.withProperty(Base_GlassDoor.OPEN, Boolean.valueOf(flag2));
		worldIn.setBlockState(pos, iblockstate.withProperty(Base_GlassDoor.HALF, Base_GlassDoor.EnumGarasudoHalf.LOWER), 2);
		worldIn.setBlockState(blockpos2, iblockstate.withProperty(Base_GlassDoor.HALF, Base_GlassDoor.EnumGarasudoHalf.UPPER), 2);
		worldIn.notifyNeighborsOfStateChange(pos, door, false);
		worldIn.notifyNeighborsOfStateChange(blockpos2, door, false);
	}

	/* tips */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_garasudo", meta));
	}

}
