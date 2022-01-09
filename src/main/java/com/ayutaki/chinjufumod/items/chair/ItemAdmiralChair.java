package com.ayutaki.chinjufumod.items.chair;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.chair.AdmiralChair;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAdmiralChair extends ItemBlockBace {

	public ItemAdmiralChair() {
		super(Chinjufu_Blocks.ADMIRALCHAIR);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, AdmiralChair.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);
	}

	/* Sub item meta and name. */
	@Override
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_admiralchair";
		case 2:
			return "item." + "block_admiralchair_red";
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
		}
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
			int k;
			k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Chinjufu_Blocks.ADMIRALCHAIR, pos, false, facing, (Entity)null)) {

			if (k == 1) {
				/** 設置するブロックのクラス **/
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRALCHAIR.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, direction)
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)), 10);
				worldIn.setBlockState(pos.up(), Chinjufu_Blocks.ADMIRALCHAIR_TOP.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, direction)
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)), 10);
			}

			if (k == 2) {
				worldIn.setBlockState(pos, Chinjufu_Blocks.ADMIRALCHAIR.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, direction)
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(2)), 10);
				worldIn.setBlockState(pos.up(), Chinjufu_Blocks.ADMIRALCHAIR_TOP.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, direction)
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(2)), 10);
			}

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_isu", meta));
	}

}
