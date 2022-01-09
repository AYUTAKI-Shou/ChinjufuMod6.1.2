package com.ayutaki.chinjufumod.items.furniture;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;

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

public class ItemDressingTable_ich extends ItemBlockBace {

	public ItemDressingTable_ich() {
		super(Furniture_Blocks.DRESSINGTABLE_ich);
		setUnlocalizedName("block_dressingtable_ich");
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, "block_dressingtable_ich"));

		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	@Override
	public int getItemBurnTime(ItemStack itemstack) {
		return 200;
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Furniture_Blocks.DRESSINGTABLE_ich, pos, false, facing, (Entity)null)) {

			/** 設置するブロックのクラス **/
			worldIn.setBlockState(pos, Furniture_Blocks.DRESSINGTABLE_ich.getDefaultState()
					.withProperty(BaseFacingSapo.H_FACING, direction), 10);
			worldIn.setBlockState(pos.up(), Furniture_Blocks.DRESSINGTABLE_TOP3.getDefaultState()
					.withProperty(BaseStage3_Face.H_FACING, direction)
					.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)), 10);
			/*1-1=オーク,2=マツ,3=シラカバ, 2-1=ジャングル,2=アカシア,3=Dオーク, 3-1=サクラ,2=カエデ,3=イチョウ */

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}
