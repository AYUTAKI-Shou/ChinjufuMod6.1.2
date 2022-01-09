package com.ayutaki.chinjufumod.blocks.gate;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.state.BlockStateHalf;
import com.ayutaki.chinjufumod.state.BlockStateHinge;

import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BaseGate extends Block {

	/* Property */
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyEnum<BlockStateHinge> HINGE = PropertyEnum.<BlockStateHinge>create("hinge", BlockStateHinge.class);
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	public static final PropertyEnum<BlockStateHalf> HALF = PropertyEnum.<BlockStateHalf>create("half", BlockStateHalf.class);

	/* Collisionの数値 */

	protected BaseGate(Material materialIn) {
		super(materialIn);

		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
			.withProperty(OPEN, Boolean.valueOf(false))
			.withProperty(HINGE, BlockStateHinge.LEFT)
			.withProperty(POWERED, Boolean.valueOf(false))
			.withProperty(HALF, BlockStateHalf.LOWER));
	}

	/* Collision */


	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public static boolean isOpen(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos) {
		return getFacing(combineMetadata(worldIn, pos));
	}

	public static int combineMetadata(IBlockAccess worldIn, BlockPos pos) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		int i = iblockstate.getBlock().getMetaFromState(iblockstate);
		boolean flag = isTop(i);
		IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
		int j = iblockstate1.getBlock().getMetaFromState(iblockstate1);
		int k = flag ? j : i;
		IBlockState iblockstate2 = worldIn.getBlockState(pos.up());
		int l = iblockstate2.getBlock().getMetaFromState(iblockstate2);
		int i1 = flag ? i : l;
		boolean flag1 = (i1 & 1) != 0;
		boolean flag2 = (i1 & 2) != 0;
		return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
	}

	protected static boolean isOpen(int combinedMeta) {
		return (combinedMeta & 4) != 0;
	}

	public static EnumFacing getFacing(int combinedMeta) {
		return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
	}

	protected static boolean isTop(int meta) {
		return (meta & 8) != 0;
	}

	protected static int removeHalfBit(int meta) {
		return meta & 7;
	}

	/* Sound */
	private SoundEvent getCloseSound() {
		return SoundEvents_CM.FUSUMA;
	}

	private SoundEvent getOpenSound() {
		return SoundEvents_CM.FUSUMA;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (this.blockMaterial == Material.IRON) {
			return false;
		}

		else {

			BlockPos blockpos = state.getValue(HALF) == BlockStateHalf.LOWER ? pos : pos.down();
			IBlockState iblockstate = pos.equals(blockpos) ? state : worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this) {
				return false;
			}

			else {
				state = iblockstate.cycleProperty(OPEN);
				worldIn.setBlockState(blockpos, state, 10);
				worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
				worldIn.playSound(null, pos, state.getValue(OPEN) ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
				return true;
			}
		}
	}

	/* 留め釘 村人AIが参照 他に参照がなく、無くてもドアは動く？
	public void toggleDoor(World worldIn, BlockPos pos, boolean open) {

		IBlockState iblockstate = worldIn.getBlockState(pos);

		if (iblockstate.getBlock() == this) {

			BlockPos blockpos = iblockstate.getValue(HALF) == BlockBlockStateHalf.LOWER ? pos : pos.down();
			IBlockState iblockstate1 = pos == blockpos ? iblockstate : worldIn.getBlockState(blockpos);

			if (iblockstate1.getBlock() == this && ((Boolean)iblockstate1.getValue(OPEN)).booleanValue() != open) {

				worldIn.setBlockState(blockpos, iblockstate1.withProperty(OPEN, Boolean.valueOf(open)), 10);
				worldIn.markBlockRangeForRenderUpdate(blockpos, pos);
				worldIn.playSound(null, pos, open ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
		}
	} */

	/* 隣接ブロックによる変化 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		if (state.getValue(HALF) == BlockStateHalf.UPPER) {

			BlockPos blockpos = pos.down();
			IBlockState iblockstate = worldIn.getBlockState(blockpos);

			if (iblockstate.getBlock() != this) {
				worldIn.setBlockToAir(pos);
			}
			else if (blockIn != this) {
				iblockstate.neighborChanged(worldIn, blockpos, blockIn, fromPos);
			}
		}

		else {

			boolean flag1 = false;
			BlockPos blockpos1 = pos.up();
			IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

			if (iblockstate1.getBlock() != this) {
				worldIn.setBlockToAir(pos);
				flag1 = true;
			}

			if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)) {
				worldIn.setBlockToAir(pos);
				flag1 = true;

				if (iblockstate1.getBlock() == this) {
					worldIn.setBlockToAir(blockpos1);
				}
			}

			if (flag1) {

				if (!worldIn.isRemote) {
					this.dropBlockAsItem(worldIn, pos, state, 0);
				}
			}

			else {
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean)iblockstate1.getValue(POWERED)).booleanValue()) {
					worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

					if (flag != ((Boolean)state.getValue(OPEN)).booleanValue()) {

						worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
						worldIn.markBlockRangeForRenderUpdate(pos, pos);
						worldIn.playSound(null, pos, flag ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {

		if (pos.getY() >= worldIn.getHeight() - 1) {
			return false;
		}

		else {
			IBlockState state = worldIn.getBlockState(pos.down());
			return (state.isTopSolid() || state.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID) && super
					.canPlaceBlockAt(worldIn, pos) && super.canPlaceBlockAt(worldIn, pos.up());
		}
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	/* Drop Item */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		BlockPos blockpos = pos.down();
		BlockPos blockpos1 = pos.up();

		if (playerIn.capabilities.isCreativeMode && state.getValue(HALF) == BlockStateHalf.UPPER && worldIn.getBlockState(blockpos).getBlock() == this) {
			worldIn.setBlockToAir(blockpos);
		}

		if (state.getValue(HALF) == BlockStateHalf.LOWER && worldIn.getBlockState(blockpos1).getBlock() == this) {

			if (playerIn.capabilities.isCreativeMode) {
				worldIn.setBlockToAir(pos);
			}
			worldIn.setBlockToAir(blockpos1);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(HALF) == BlockStateHalf.UPPER ? Items.AIR : this.getItem();
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getItem());
	}

	private Item getItem() {
		return null;
	}

	/* BlockState関連 */
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		if (state.getValue(HALF) == BlockStateHalf.LOWER) {

			IBlockState iblockstate = worldIn.getBlockState(pos.up());

			if (iblockstate.getBlock() == this) {
				state = state.withProperty(HINGE, iblockstate.getValue(HINGE)).withProperty(POWERED, iblockstate.getValue(POWERED));
			}
		}

		else {
			IBlockState iblockstate1 = worldIn.getBlockState(pos.down());

			if (iblockstate1.getBlock() == this) {
				state = state.withProperty(H_FACING, iblockstate1.getValue(H_FACING)).withProperty(OPEN, iblockstate1.getValue(OPEN));
			}
		}
		return state;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {

		return state.getValue(HALF) != BlockStateHalf.LOWER ? state : state
				.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state : state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING))).cycleProperty(HINGE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return (meta & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockStateHalf.UPPER)
				.withProperty(HINGE, (meta & 1) > 0 ? BlockStateHinge.RIGHT : BlockStateHinge.LEFT)
				.withProperty(POWERED, Boolean.valueOf((meta & 2) > 0)) : this.getDefaultState()
				.withProperty(HALF, BlockStateHalf.LOWER)
				.withProperty(H_FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW())
				.withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;

		if (state.getValue(HALF) == BlockStateHalf.UPPER) {
			i = i | 8;

			if (state.getValue(HINGE) == BlockStateHinge.RIGHT) {
				i |= 1;
			}

			if (((Boolean)state.getValue(POWERED)).booleanValue()) {
				i |= 2;
			}
		}

		else {
			i = i | ((EnumFacing)state.getValue(H_FACING)).rotateY().getHorizontalIndex();

			if (((Boolean)state.getValue(OPEN)).booleanValue()) {
				i |= 4;
			}
		}
		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { HALF, H_FACING, OPEN, HINGE, POWERED });
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

}
