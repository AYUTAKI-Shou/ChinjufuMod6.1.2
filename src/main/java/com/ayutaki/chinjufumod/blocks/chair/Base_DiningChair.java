package com.ayutaki.chinjufumod.blocks.chair;

import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Base_DiningChair extends Block {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum<Half> HALF = PropertyEnum.create("half", Half.class);
	
	private static final AxisAlignedBB AABB_BASE = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.5625, 0.875);
	private static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 0.25, 0.1875);
	private static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.125, 0.0, 0.125, 0.1875, 0.25, 0.875);
	private static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.8125, 0.0, 0.125, 0.875, 0.25, 0.875);
	private static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.125, 0.0, 0.8125, 0.875, 0.25, 0.875);

	public Base_DiningChair() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);

		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(HALF, Half.LOWER));
		
		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (state.getValue(HALF) == Half.LOWER) {
			if (SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 6 * 0.0625)) {
				worldIn.updateComparatorOutputLevel(pos, this);
				CMEvents.soundSitChair(worldIn, pos);
				return true;
			}
		}
		return false;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag = state.getValue(HALF) == Half.LOWER;

		switch (direction) {
		case SOUTH:
			return flag ? AABB_BASE : AABB_SOUTH;
			
		case EAST:
			return flag ? AABB_BASE : AABB_EAST;
			
		case WEST:
			return flag ? AABB_BASE : AABB_WEST;
			
		case NORTH:
		default:
			return flag ? AABB_BASE : AABB_NORTH;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = state.getValue(HALF) == Half.LOWER;
		EnumFacing direction = state.getValue(H_FACING);

		switch (direction) {
		case SOUTH:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_SOUTH);
			break;

		case EAST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_EAST);
			break;

		case WEST:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_WEST);
			break;

		case NORTH :
		default:
			super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag ? AABB_BASE : AABB_NORTH);
			break;
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (state.getValue(HALF) == Half.UPPER) {
			BlockPos down = pos.down();
			IBlockState downState = world.getBlockState(down);
			if (downState.getBlock() != this) {
				world.setBlockToAir(pos);
			}
			else if (block != this) {
				downState.neighborChanged(world, down, block, fromPos);
			}
		}
		
		else {
			BlockPos up = pos.up();
			IBlockState upState = world.getBlockState(up);
			if (upState.getBlock() != this) {
				world.setBlockToAir(pos);
				if (!world.isRemote) {
					this.dropBlockAsItem(world, pos, state, 0);
				}
			}
			if (!world.getBlockState(pos.down()).isSideSolid(world, pos.down(), EnumFacing.UP)) {
				world.setBlockToAir(pos);
				if (!world.isRemote) {
					this.dropBlockAsItem(world, pos, state, 0);
				}
				if (upState.getBlock() == this) {
					world.setBlockToAir(up);
				}
			}
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		BlockPos down = pos.down();
		BlockPos up = pos.up();
		if (playerIn.capabilities.isCreativeMode && state.getValue(HALF) == Half.UPPER && world.getBlockState(down).getBlock() == this) {
			world.setBlockToAir(down);
		}
		if (state.getValue(HALF) == Half.LOWER && world.getBlockState(up).getBlock() == this) {
			if (playerIn.capabilities.isCreativeMode) {
				world.setBlockToAir(pos);
			}
			world.setBlockToAir(up);
		}
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HALF, H_FACING);
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate(state.getValue(H_FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirror) {
		return state.withProperty(H_FACING, mirror.mirror(state.getValue(H_FACING)));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		Half half = Half.fromMetadata(meta & 1);
		EnumFacing facing = EnumFacing.getHorizontal((meta >> 1) & 3);
		if (facing.getAxis() == Axis.Y) {
			facing = EnumFacing.NORTH;
		}
		return this.getDefaultState().withProperty(HALF, half).withProperty(H_FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(HALF).getMetadata() | (state.getValue(H_FACING).getIndex() << 1);
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return state.getValue(HALF) == Half.LOWER;
	}

	public enum Half implements IStringSerializable {
		LOWER("lower", 0),
		UPPER("upper", 1);

		private String name;
		private int metadata;

		Half(String name, int metadata) {
			this.name = name;
			this.metadata = metadata;
		}

		public String toString() {
			return this.getName();
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getMetadata() {
			return this.metadata;
		}

		public static Half fromMetadata(int metadata) {
			if (metadata == 1) {
				return UPPER;
			}
			return LOWER;
		}
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
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

}
