package com.ayutaki.chinjufumod.blocks.amado;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TobukuroWindowR extends BaseStage3_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, -0.03125, -0.03125, 0.1875, 1.03125, 1.03125);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	/** 1=2枚、2=1枚、3=0枚 **/
	public TobukuroWindowR() {
		super(Material.WOOD);

		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=2枚、2=1枚、3=0枚 **/
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northstate = worldIn.getBlockState(pos.north());
		IBlockState southstate = worldIn.getBlockState(pos.south());
		IBlockState eaststate = worldIn.getBlockState(pos.east());
		IBlockState weststate = worldIn.getBlockState(pos.west());

		if (i != 3) {
			CMEvents.soundAmadoWin(worldIn, pos);
			
			if (this == Slidingdoor_Blocks.TOBUKURO_WINR) {
				switch (direction) {
				case NORTH :
				default :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidingdoor_Blocks.AMADO_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidingdoor_Blocks.AMADO_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidingdoor_Blocks.AMADO_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidingdoor_Blocks.AMADO_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			} // DarkOak


			if (this == Slidingdoor_Blocks.TOBUKUROS_WINR) {
				switch (direction) {
				case NORTH :
				default :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidingdoor_Blocks.AMADOS_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidingdoor_Blocks.AMADOS_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidingdoor_Blocks.AMADOS_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidingdoor_Blocks.AMADOS_WIN.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING)).withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			} // Spruce
		}
		
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
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

		if (this == Slidingdoor_Blocks.TOBUKURO_WINR) { stack.add(new ItemStack(Items_Wadeco.TOBUKURO_WINR)); }
		if (this == Slidingdoor_Blocks.TOBUKUROS_WINR) { stack.add(new ItemStack(Items_Wadeco.TOBUKUROS_WINR)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == Slidingdoor_Blocks.TOBUKUROS_WINR) { return new ItemStack(Items_Wadeco.TOBUKUROS_WINR); }
		return new ItemStack(Items_Wadeco.TOBUKURO_WINR);
	}

}
