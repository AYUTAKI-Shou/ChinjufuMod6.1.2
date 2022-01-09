package com.ayutaki.chinjufumod.blocks.unitblock;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfStoneSlab;
import net.minecraft.block.BlockHalfStoneSlabNew;
import net.minecraft.block.BlockHalfWoodSlab;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

public class WrittenMakimono5 extends Block {

	public static final String ID = "block_written_makimono5";
	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	private static final AxisAlignedBB AABB_1S = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_1W = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_1N = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	private static final AxisAlignedBB AABB_1E = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, 0.0, 0.265625, 0.75, 0.3125, 0.734375);
	
	private static final AxisAlignedBB DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);
	private static final AxisAlignedBB DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.25, -0.5, 0.265625, 0.75, 0.01, 0.734375);

	
	public WrittenMakimono5() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.WADECO);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(0.5F);
		setResistance(0.5F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
		
		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(H_FACING)).getHorizontalIndex();
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta));
	}

	/*Collision*/
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
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
		return state.withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down())));
	}

	/*初期BlockStateContainerの生成 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOWN, H_FACING });
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

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}
 
	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		return true;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {

		if (worldIn instanceof World) {
			LootTable table = null;
			table = ((World) worldIn).getLootTableManager()
					.getLootTableFromLocation(new ResourceLocation(ChinjufuMod.MOD_ID, "blocks/block_written_book5")); 
			
			LootContext context = new LootContext.Builder(((WorldServer) worldIn)).build();
			drops.addAll(table.generateLootForPools(((World) worldIn).rand, context)); }
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items.BOOK, 1, 0);
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
			case SOUTH:
				return flag? AABB_1S : DOWN_SOUTH;
			case WEST:
				return flag? AABB_1W : DOWN_WEST;
			case NORTH:
			default:
				return flag? AABB_1N : DOWN_NORTH;
			case EAST:
				return flag? AABB_1E : DOWN_EAST;
		}
	}
	
}