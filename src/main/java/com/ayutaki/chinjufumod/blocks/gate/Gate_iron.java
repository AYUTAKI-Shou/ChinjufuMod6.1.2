package com.ayutaki.chinjufumod.blocks.gate;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.state.BlockStateHalf;
import com.ayutaki.chinjufumod.state.BlockStateHinge;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Gate_iron extends BaseGate {

	public static final String ID = "block_gate_iron";

	/* Collisionの数値 */
	private static final AxisAlignedBB SOUTH_AABB_LEFT_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB SOUTH_AABB_LEFT_OPEN = new AxisAlignedBB( 1.25D, 0.0D, 0.25D, 2.0D, 2.0D, 2.0D);
	private static final AxisAlignedBB SOUTH_AABB_RIGHT_CLOSE = new AxisAlignedBB( -1.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB SOUTH_AABB_RIGHT_OPEN = new AxisAlignedBB( -1.0D, 0.0D, 0.25D, -0.25D, 2.0D, 2.0D);

	private static final AxisAlignedBB EAST_AABB_LEFT_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, -1.0D, 1.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB EAST_AABB_LEFT_OPEN = new AxisAlignedBB( 0.25D, 0.0D, -1.0D, 2.0D, 2.0D, -0.25D);
	private static final AxisAlignedBB EAST_AABB_RIGHT_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 2.0D);
	private static final AxisAlignedBB EAST_AABB_RIGHT_OPEN = new AxisAlignedBB( 0.25D, 0.0D, 1.25D, 2.0D, 2.0D, 2.0D);

	private static final AxisAlignedBB WEST_AABB_LEFT_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.0D, 1.0D, 2.0D, 2.0D);
	private static final AxisAlignedBB WEST_AABB_LEFT_OPEN = new AxisAlignedBB( -1.0D, 0.0D, 1.25D, 0.75D, 2.0D, 2.0D);
	private static final AxisAlignedBB WEST_AABB_RIGHT_CLOSE= new AxisAlignedBB( 0.0D, 0.0D, -1.0D, 1.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB WEST_AABB_RIGHT_OPEN = new AxisAlignedBB( -1.0D, 0.0D, -1.0D, 0.75D, 2.0D, -0.25D);

	private static final AxisAlignedBB NORTH_AABB_LEFT_CLOSE = new AxisAlignedBB( -1.0D, 0.0D, 0.0D, 1.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB NORTH_AABB_LEFT_OPEN = new AxisAlignedBB( -1.0D, 0.0D, -1.0D, -0.25D, 2.0D, 0.75D);
	private static final AxisAlignedBB NORTH_AABB_RIGHT_CLOSE = new AxisAlignedBB( 0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 1.0D);
	private static final AxisAlignedBB NORTH_AABB_RIGHT_OPEN = new AxisAlignedBB( 1.25D, 0.0D, -1.0D, 2.0D, 2.0D, 0.75D);

	public Gate_iron() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setHardness(1.0F);
		setResistance(20.0F);
		setSoundType(SoundType.METAL);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/

		/** Registry **/
		ForgeRegistries.BLOCKS.register(this);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flagopen = (state.getValue(OPEN) == true);
		boolean flagright = (state.getValue(HINGE) == BlockStateHinge.RIGHT);

		switch (direction) {
		case SOUTH:
			return flagopen? (flagright? SOUTH_AABB_RIGHT_OPEN : SOUTH_AABB_LEFT_OPEN) : (flagright? SOUTH_AABB_RIGHT_CLOSE : SOUTH_AABB_LEFT_CLOSE);

		case EAST:
			return flagopen? (flagright? EAST_AABB_RIGHT_OPEN : EAST_AABB_LEFT_OPEN) : (flagright? EAST_AABB_RIGHT_CLOSE : EAST_AABB_LEFT_CLOSE);

		case WEST:
			return flagopen? (flagright? WEST_AABB_RIGHT_OPEN : WEST_AABB_LEFT_OPEN) : (flagright? WEST_AABB_RIGHT_CLOSE : WEST_AABB_LEFT_CLOSE);

		case NORTH:
		default:
			return flagopen? (flagright? NORTH_AABB_RIGHT_OPEN : NORTH_AABB_LEFT_OPEN) : (flagright? NORTH_AABB_RIGHT_CLOSE : NORTH_AABB_LEFT_CLOSE);
		}
	}

	/* int → SoundEvent */
	private SoundEvent getCloseSound() {
		return SoundEvents_CM.GATE_IRON_CLOSE;
	}

	private SoundEvent getOpenSound() {
		return SoundEvents_CM.GATE_IRON_OPEN;
	}

	/* 右クリックでは開閉させない */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return false;
	}

	/* 隣接ブロックへの反応 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {

		/** ドア上部が壊れたら、下部も壊れる **/
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

			/** 隣接ブロックが壊れたときの反応 **/
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

			/** レッドストーンで開閉 **/
			else {
				boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(blockpos1);

				if (blockIn != this && (flag || blockIn.getDefaultState().canProvidePower()) && flag != ((Boolean)iblockstate1.getValue(POWERED)).booleanValue()) {
					worldIn.setBlockState(blockpos1, iblockstate1.withProperty(POWERED, Boolean.valueOf(flag)), 2);

					if (flag != ((Boolean)state.getValue(OPEN)).booleanValue()) {
						worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
						worldIn.markBlockRangeForRenderUpdate(pos, pos);
						worldIn.playSound(null, pos, flag ? this.getOpenSound() : this.getCloseSound(), SoundCategory.BLOCKS, 1.0F, 0.9F);
					}
				}
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(HALF) == BlockStateHalf.UPPER ? Items.AIR : Items_Wadeco.GATE_IRON;
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(Items_Wadeco.GATE_IRON);
	}

}
