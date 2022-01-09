package com.ayutaki.chinjufumod.items.jpblock;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_DirtWall;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

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
import net.minecraft.world.World;

public class ItemWall_DirtWall extends ItemBlockBace {

	public ItemWall_DirtWall() {
		super(JPBlock_Blocks.DIRTWALL_WALL);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Wall_DirtWall.ID));
		setUnlocalizedName(Wall_DirtWall.ID);
		setCreativeTab(ChinjufuModTabs.WABLOCK);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack itemstack = playerIn.getHeldItem(hand);

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(JPBlock_Blocks.DIRTWALL_WALL, pos, false, facing, (Entity)null)) {

			/** ブロックの設置 **/
			IBlockState iblockstate1 = JPBlock_Blocks.DIRTWALL_WALL.getDefaultState().withProperty(Wall_DirtWall.STAGE_0_1, Integer.valueOf(0));
			worldIn.setBlockState(pos, iblockstate1, 10);

			worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
