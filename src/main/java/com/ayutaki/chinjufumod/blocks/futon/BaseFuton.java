package com.ayutaki.chinjufumod.blocks.futon;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.entity.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BaseFuton extends BaseStage2_Face {

	/* Collision */
	protected static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);
	protected static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.34375, 0.0, 0.0, 1.0, 0.6875, 1.0);

	protected static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);
	protected static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -1.0, 0.0, 0.0, 1.0, 0.225, 1.0);

	protected BaseFuton(Material material) {
		super(material);
		setCreativeTab(ChinjufuModTabs.WADECO);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.CLOTH);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=Close、2=Open **/
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (i == 1) {
				if (playerIn.isSneaking()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(i + 1)), 3); }
				
				if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); } }
			
			if (i == 2) {
				if (playerIn.isSneaking()) {
					CMEvents.soundKinuzure(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(i - 1)), 3); }
				
				if (!playerIn.isSneaking() && SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 0 * 0.0625)) {
					worldIn.updateComparatorOutputLevel(pos, this);
					CMEvents.soundKinuzure(worldIn, pos);

					((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0)); } }
		}
		return true;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_1_SOUTH : AABB_2_SOUTH;

		case EAST:
			return (i == 1)? AABB_1_EAST : AABB_2_EAST;

		case WEST:
			return (i == 1)? AABB_1_WEST : AABB_2_WEST;

		case NORTH:
		default:
			return (i == 1)? AABB_1_NORTH : AABB_2_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_SOUTH : AABB_2_SOUTH);
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_EAST : AABB_2_EAST);
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_WEST : AABB_2_WEST);
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, (i == 1)? AABB_1_NORTH : AABB_2_NORTH);
			break;
		}
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
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

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_futon", meta));
	}

}
