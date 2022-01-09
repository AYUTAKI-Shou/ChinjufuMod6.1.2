package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Lit_Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_aida;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_off;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop_on;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu_sub;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk_sub;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Nabe_kara extends BaseStage4_FaceDown2 {

	public static final String ID = "block_food_karanabe";

	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);

	private static final AxisAlignedBB AABB_MISO_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	private static final AxisAlignedBB AABB_MISO_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	private static final AxisAlignedBB AABB_MISO_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);
	private static final AxisAlignedBB AABB_MISO_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.34375, 0.78125, 0.28125, 0.90625);

	private static final AxisAlignedBB AABB_MISOD_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_MISOD_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_MISOD_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);
	private static final AxisAlignedBB AABB_MISOD_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, 0.0, 0.21875, 0.78125, 0.25, 0.78125);

	private static final AxisAlignedBB AABB_MISODK_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	private static final AxisAlignedBB AABB_MISODK_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	private static final AxisAlignedBB AABB_MISODK_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);
	private static final AxisAlignedBB AABB_MISODK_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.21875, -0.5, 0.34375, 0.78125, 0.01, 0.90625);

	/** 1=鍋空、2=味噌鍋空、3=ご飯鍋空、4＝塩鍋空 **/
	public Nabe_kara() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*鍋・皿*/
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_4)).intValue() - 1 << 2;
		return i;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(STAGE_1_4, Integer.valueOf(1 + (meta >> 2)));
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (4 - ((Integer)blockState.getValue(STAGE_1_4)).intValue()) * 2;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = !((Boolean)state.getValue(DOWN)).booleanValue();
		boolean flag2 = !((Boolean)state.getValue(DOWN2)).booleanValue();
		/** 1=鍋空、2=味噌鍋空、3=ご飯鍋空、4＝塩鍋空 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			switch (direction) {
			case SOUTH:
				return AABB_SOUTH;

			case EAST:
				return AABB_EAST;

			case WEST:
				return AABB_WEST;

			case NORTH:
			default:
				return AABB_NORTH;
			}
		}

		if (i == 4) {
			switch (direction) {
			case SOUTH:
				return AABB_MISOD_SOUTH;

			case EAST:
				return AABB_MISOD_EAST;

			case WEST:
				return AABB_MISOD_WEST;

			case NORTH:
			default:
				return AABB_MISOD_NORTH;
			}
		}

		else {
			switch (direction) {
			case SOUTH:
				return flag? (flag2? AABB_MISO_SOUTH : AABB_MISODK_SOUTH): AABB_MISOD_SOUTH;

			case EAST:
				return flag? (flag2? AABB_MISO_EAST : AABB_MISODK_EAST): AABB_MISOD_EAST;

			case WEST:
				return flag? (flag2? AABB_MISO_WEST : AABB_MISODK_WEST): AABB_MISOD_WEST;

			case NORTH:
			default:
				/** !down= true : false **/
				return flag? (flag2? AABB_MISO_NORTH : AABB_MISODK_NORTH): AABB_MISOD_NORTH;
			}
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() instanceof Kitchen_Oven || worldIn
				.getBlockState(pos).getBlock() instanceof Irori || worldIn
				.getBlockState(pos).getBlock() instanceof Lit_Irori || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_on || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_off || worldIn
				.getBlockState(pos).getBlock() instanceof Kit_Cooktop_aida || worldIn
				.getBlockState(pos).getBlock() instanceof BlockFurnace;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo2(IBlockAccess worldIn, BlockPos pos) {
		IBlockState state = worldIn.getBlockState(pos);
		Block block = state.getBlock();

		return block instanceof Chabudai || block instanceof LowDesk || block instanceof Kotatsu ||
					block instanceof Chabudai_sub || block instanceof LowDesk_sub || block instanceof Kotatsu_sub ||
					(block instanceof BaseFacingSlabW && state.getValue(BaseFacingSlabW.HALF) == BaseFacingSlabW.SlabHalf.BOTTOM && state.getValue(BaseFacingSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabW && state.getValue(BaseSlabW.HALF) == BaseSlabW.SlabHalf.BOTTOM && state.getValue(BaseSlabW.DOUBLE) == false) ||
					(block instanceof BaseSlabWType2 && state.getValue(BaseSlabWType2.HALF) == BaseSlabWType2.SlabHalf.BOTTOM && state.getValue(BaseSlabWType2.DOUBLE) == false) ||
					(block instanceof BlockHalfWoodSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlab && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM) ||
					(block instanceof BlockHalfStoneSlabNew && state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()))
				.withProperty(DOWN2, this.canConnectTo2(worldIn, pos.down()));
	}

	/* 描画の設定 */
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

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return new ItemStack(Items_Teatime.NABE_kara).getItem();
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.NABE_kara);
	}

}
