package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Kitchen extends BaseStage3_Face {

	/** 1=キッチン、2=やかん、3=寸胴 **/
	public static final String ID = "block_kitchen";

	public Kitchen() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setCreativeTab(ChinjufuModTabs.TEATIME);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side,
			float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		/** 1=キッチン、2=やかん、3=寸胴 **/
		if (!itemstack.isEmpty()) {
			if (i == 1) {
				if (item == Items_Teatime.NABE_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(pos, Kitchen_Blocks.KIT_DONABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }

				if (item == Items_Teatime.FRYPAN_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlockState(pos, Kitchen_Blocks.KIT_DONABE.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }

				if (item == Items_Teatime.Item_YAKAN_kara) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(2))); }

				if (item == Items_Teatime.ZUNDOU) {
					CMEvents.Consume_1Item(playerIn, hand);
					worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
				
				if (item != Items_Teatime.NABE_kara && item != Items_Teatime.FRYPAN_kara &&
						item != Items_Teatime.Item_YAKAN_kara && item != Items_Teatime.ZUNDOU) {
					CMEvents.textNotHave(worldIn, pos, playerIn); }				
			}
			
			if (i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}


		/** 1=キッチン、2=やかん、3=寸胴 **/
		if (itemstack.isEmpty()) {
			if (i == 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (i == 2) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_YAKAN_kara, 1, 0));
				CMEvents.soundItemPick(worldIn, pos);

				worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1))); }
	
			if (i == 3) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOU, 1, 1));
				CMEvents.soundItemPick(worldIn, pos);

				worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(1))); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* ドロップ */
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0)); }

		if (i == 2) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.Item_YAKAN_kara, 1, 0)); }

		if (i == 3) {
			stack.add(new ItemStack(Items_Teatime.KITCHEN, 1, 0));
			stack.add(new ItemStack(Items_Teatime.ZUNDOU, 1, 1)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.KITCHEN, 1, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_kitchen", meta));
	}

}
