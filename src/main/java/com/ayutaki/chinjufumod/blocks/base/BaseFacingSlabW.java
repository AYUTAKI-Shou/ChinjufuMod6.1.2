package com.ayutaki.chinjufumod.blocks.base;

import com.ayutaki.chinjufumod.ChinjufuMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseFacingSlabW extends Block {

	/** 上下と方角、変化のあるブロックであるトラップドアを応用(パントリー、畳) **/
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOUBLE = PropertyBool.create("double");
	public static final PropertyEnum<BaseFacingSlabW.SlabHalf> HALF = PropertyEnum.<BaseFacingSlabW.SlabHalf>create("half", BaseFacingSlabW.SlabHalf.class);

	/* Collision…パントリーと畳で別々 */

	public BaseFacingSlabW(String unlocalizedName) {
		super(Material.WOOD);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));

		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(DOUBLE, Boolean.valueOf(false))
				.withProperty(HALF, BaseFacingSlabW.SlabHalf.BOTTOM));
	}

	/* RightClick Action */


	/** Called by ItemBlocks just before a block is actually set in the world, to allow for adjustments to the IBlockstate */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		IBlockState iblockstate = this.getDefaultState();

		if (facing.getAxis().isHorizontal()) {
			iblockstate = iblockstate.withProperty(H_FACING, facing).withProperty(DOUBLE, Boolean.valueOf(false));
			iblockstate = iblockstate.withProperty(HALF, (hitY > 0.6F)? BaseFacingSlabW.SlabHalf.TOP : BaseFacingSlabW.SlabHalf.BOTTOM);
		}

		else {
			iblockstate = iblockstate.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(DOUBLE, Boolean.valueOf(false));
			iblockstate = iblockstate.withProperty(HALF, (facing == EnumFacing.UP)? BaseFacingSlabW.SlabHalf.BOTTOM : BaseFacingSlabW.SlabHalf.TOP);
		}

		return iblockstate;
	}

	/* 隣接ブロックへのチェック */
	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}

	/* トラップドアのData value */
	public static EnumFacing getFacing(int meta) {
		switch (meta & 3) {
		case 0:
			return EnumFacing.NORTH;
		case 1:
			return EnumFacing.SOUTH;
		case 2:
			return EnumFacing.WEST;
		case 3:
		default:
			return EnumFacing.EAST;
		}
	}

	public static int getMetaForFacing(EnumFacing facing) {
		switch (facing) {
		case NORTH:
			return 0;
		case SOUTH:
			return 1;
		case WEST:
			return 2;
		case EAST:
		default:
			return 3;
		}
	}

	/* Data valueをBlockstate に変換…トラップドアの OPEN(t/f) を DOUBLE(t/f) で使う */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, getFacing(meta))
				.withProperty(DOUBLE, Boolean.valueOf((meta & 4) != 0))
				.withProperty(HALF, (meta & 8) == 0 ? BaseFacingSlabW.SlabHalf.BOTTOM : BaseFacingSlabW.SlabHalf.TOP);
	}

	/* Data valueの変換 */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | getMetaForFacing((EnumFacing)state.getValue(H_FACING));
		if (state.getValue(DOUBLE) == true) { i |= 4; }
		if (state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP) { i |= 8; }

		return i;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DOUBLE, H_FACING, HALF });
	}

	public static enum SlabHalf implements IStringSerializable {
		TOP("top"),
		BOTTOM("bottom");

		private final String name;
		private SlabHalf(String name) { this.name = name; }
		public String toString() { return this.name; }
		public String getName() { return this.name; }
	}

	/* Collision */

	/* 上面に植木鉢やレッドストーンを置けるようにする…パントリーと畳で別々 */

	/* 側面に松明などを置けるようにする…パントリーと畳で別々 */

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

}
