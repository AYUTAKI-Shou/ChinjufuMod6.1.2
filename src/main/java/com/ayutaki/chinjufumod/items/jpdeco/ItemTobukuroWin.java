package com.ayutaki.chinjufumod.items.jpdeco;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
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

public class ItemTobukuroWin extends ItemBaceTobukuro {

	public ItemTobukuroWin() {
		super(Slidingdoor_Blocks.TOBUKURO_WINR);
		setUnlocalizedName("block_tobukurowin");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "block_tobukurowin"));
		setCreativeTab(ChinjufuModTabs.WADECO);
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 150;
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Slidingdoor_Blocks.TOBUKURO_WINR, pos, false, facing, (Entity)null)) {

			if (playerIn.isSneaking()) {
				worldIn.setBlockState(pos, Slidingdoor_Blocks.TOBUKURO_WINL.getDefaultState()
						.withProperty(BaseStage3_Face.H_FACING, direction).withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10);
			}

			else { worldIn.setBlockState(pos, Slidingdoor_Blocks.TOBUKURO_WINR.getDefaultState()
					.withProperty(BaseStage3_Face.H_FACING, direction).withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1)), 10); }

			worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);

			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
