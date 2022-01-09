package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.dish.NabeNama_1_TMGC;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;

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

public class ItemNabeNama_1 extends ItemBlockBace {

	public ItemNabeNama_1() {
		super(Dish_Blocks.NABE_nama);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, NabeNama_1_TMGC.ID));

		/** Have sub items. **/
		setHasSubtypes(true);
	}

	/* Sub item meta and name. */
	public String getUnlocalizedName(ItemStack stack) {
		/** 1=鶏鍋、2=味噌、3=ご飯、4=コーンスープ **/
		switch (stack.getMetadata()) {
		case 1:
		default:
			return "item." + "block_food_nabe_n";
		case 2:
			return "item." + "block_food_nabemiso_n";
		case 3:
			return "item." + "block_food_nabegohan_n";
		case 4:
			return "item." + "block_food_nabecorns_n";
		}
	}

	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (this.isInCreativeTab(tab)) {
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Dish_Blocks.NABE_nama, pos, false, facing, (Entity)null)) {

			if (k == 1) {
				/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Dish_Blocks.NABE_nama.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 2) {
				IBlockState iblockstate1 = Dish_Blocks.NABE_nama.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 3) {
				IBlockState iblockstate1 = Dish_Blocks.NABE_nama.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			if (k == 4) {
				IBlockState iblockstate1 = Dish_Blocks.NABE_nama.getDefaultState().withProperty(BaseStage4_Face.H_FACING, direction)
					.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4));
				worldIn.setBlockState(pos, iblockstate1, 10); }

			worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
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
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_nabe", meta));
	}

}
