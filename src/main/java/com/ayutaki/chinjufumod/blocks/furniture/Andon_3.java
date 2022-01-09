package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Andon_3 extends BaseStage4_Face {

	public static final String ID = "block_andon_3";

	public Andon_3() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(1.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.75D, 0.6875D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (item == Items.FLINT_AND_STEEL) {
				CMEvents.soundFlint(worldIn, pos);
	
				if (i == 1) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
				if (i == 3) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
				if (i == 4) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); }
	
				itemstack.damageItem(1, playerIn); }
	
			if (item == Items_Teatime.Item_MATCH) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundFlint(worldIn, pos);
	
				if (i == 1) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
				if (i == 2) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
				if (i == 3) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3))); }
				if (i == 4) { worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_3
						.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4))); } }
			
			if (item != Items.FLINT_AND_STEEL && item != Items_Teatime.Item_MATCH) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.ANDON_3, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Wadeco.ANDON_3, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Wadeco.ANDON_3, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Wadeco.ANDON_3, 1, 4)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2) { return new ItemStack(Items_Wadeco.ANDON_3, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Wadeco.ANDON_3, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Wadeco.ANDON_3, 1, 4); }
		return new ItemStack(Items_Wadeco.ANDON_3, 1, 1);
	}

}
