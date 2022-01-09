package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.state.BlockStateType;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Roof_Base extends Block {

	/** 上下と方角、変化のあるブロックであるトラップドアを応用 **/
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool COR = PropertyBool.create("cor");
	public static final PropertyEnum<BlockStateType> HALF = PropertyEnum.<BlockStateType>create("half", BlockStateType.class);

	protected static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	protected static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	protected Roof_Base(String unlocalizedName) {
		super(Material.PLANTS);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, unlocalizedName));

		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.PLANT);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(COR, Boolean.valueOf(false))
				.withProperty(HALF, BlockStateType.BOTTOM));
	}

	/* RightClick Action */


	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {

		IBlockState iblockstate = this.getDefaultState();

		if (facing.getAxis().isHorizontal()) {
			iblockstate = iblockstate.withProperty(H_FACING, facing).withProperty(COR, Boolean.valueOf(false));
			iblockstate = iblockstate.withProperty(HALF, (hitY > 0.5F)? BlockStateType.TOP : BlockStateType.BOTTOM);
		}

		else {
			iblockstate = iblockstate.withProperty(H_FACING, placer.getHorizontalFacing().getOpposite()).withProperty(COR, Boolean.valueOf(false));
			iblockstate = iblockstate.withProperty(HALF, (facing == EnumFacing.UP)? BlockStateType.BOTTOM : BlockStateType.TOP);
		}

		return iblockstate;
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side) {
		return true;
	}

	protected static EnumFacing getFacing(int meta) {
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

	protected static int getMetaForFacing(EnumFacing facing) {
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

	/* Data valueをBlockstate に変換…トラップドアの OPEN(t/f) を COR(t/f) で使う */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, getFacing(meta))
				.withProperty(COR, Boolean.valueOf((meta & 4) != 0))
				.withProperty(HALF, (meta & 8) == 0 ? BlockStateType.BOTTOM : BlockStateType.TOP);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | getMetaForFacing((EnumFacing)state.getValue(H_FACING));
		if (((Boolean)state.getValue(COR)).booleanValue()) { i |= 4; }
		if (state.getValue(HALF) == BlockStateType.TOP) { i |= 8; }

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
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COR, H_FACING, HALF });
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return (face == EnumFacing.UP && state.getValue(HALF) == BlockStateType.TOP || face == EnumFacing
				.DOWN && state.getValue(HALF) == BlockStateType.BOTTOM) && !((Boolean)state.getValue(COR))
				.booleanValue() ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		AxisAlignedBB axisalignedbb;

		if (state.getValue(HALF) == BlockStateType.TOP) { axisalignedbb = TOP_AABB; }
		else { axisalignedbb = BOTTOM_AABB; }

		return axisalignedbb;
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return state.getValue(HALF) == BlockStateType.TOP;
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

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_tabakusa_roof", meta));
	}

}
