package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.hakkou.Taru_HakusaiDuke;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHakkouTaru_Hakusai extends ItemBlockBace {

	public ItemHakkouTaru_Hakusai() {
		super(Hakkou_Blocks.HAKUSAITARU);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Taru_HakusaiDuke.ID));
		setCreativeTab(ChinjufuModTabs.TEATIME);

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {

		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_taru_hakusai_f";
		case 2:
			return "item." + "block_taru_hakusai_f2";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
		}
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int k;
		k = itemstack.getMetadata();

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Hakkou_Blocks.HAKUSAITARU, pos, false, facing, (Entity)null)) {

			if (k == 1) {
				/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Hakkou_Blocks.HAKUSAITARU.getDefaultState().withProperty(Taru_HakusaiDuke.STAGE_0_9, Integer.valueOf(0));
				worldIn.setBlockState(pos, iblockstate1, 10); }
			if (k == 2) {
				IBlockState iblockstate1 = Hakkou_Blocks.HAKUSAITARU.getDefaultState().withProperty(Taru_HakusaiDuke.STAGE_0_9, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		if (stack.getMetadata() == 1) { tooltip.add(I18n.format("tips.block_taru_hakusai_f")); }
		if (stack.getMetadata() == 2) { tooltip.add(I18n.format("tips.block_taru_hakusai_f2")); }
	}

}
