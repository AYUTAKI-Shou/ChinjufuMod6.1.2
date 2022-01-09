package com.ayutaki.chinjufumod.items.cmblock;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.cmblock.AlumiBlock;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Item_AlumiBlock extends ItemBlockBace {

	public Item_AlumiBlock() {
		super(Chinjufu_Blocks.ALUMI);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, AlumiBlock.ID));
		setCreativeTab(ChinjufuModTabs.CHINJUFU);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_alumi_block";
		case 2:
			return "item." + "block_steel_block";
		case 3:
			return "item." + "block_gold_block";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
		}
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
			int k;
			k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Chinjufu_Blocks.ALUMI, pos, false, facing, (Entity)null)) {

			if (k == 1) {
			/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Chinjufu_Blocks.ALUMI.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 2) {
				IBlockState iblockstate1 = Chinjufu_Blocks.ALUMI.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 3) {
				IBlockState iblockstate1 = Chinjufu_Blocks.ALUMI.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

}