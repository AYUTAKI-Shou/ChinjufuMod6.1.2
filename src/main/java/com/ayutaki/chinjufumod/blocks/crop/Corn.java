package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Corn extends BushBlock implements IGrowable {

	/* Property DoubleBlock を使う為 Crop ではなく Bush */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty AGE_0_7 = IntegerProperty.create("age", 0, 7);
	/* Collision */
	protected static final VoxelShape AABB_BOT_0 = Block.makeCuboidShape(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_1 = Block.makeCuboidShape(1.0D, -1.0D, 1.0D, 15.0D, 1.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_2 = Block.makeCuboidShape(1.0D, -1.0D, 1.0D, 15.0D, 7.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_3 = Block.makeCuboidShape(1.0D, -1.0D, 1.0D, 15.0D, 11.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_4 = Block.makeCuboidShape(1.0D, -1.0D, 1.0D, 15.0D, 18.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_5 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 24.0D, 15.0D);
	protected static final VoxelShape AABB_BOT_6 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 28.0D, 15.0D);

	protected static final VoxelShape AABB_BOT_7 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	protected static final VoxelShape AABB_TOP_7 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	public Corn(Block.Properties properties) {
		super(properties);

		setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER)
				.with(AGE_0_7, Integer.valueOf(0)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		return blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context) ?
				 super.getStateForPlacement(context) : null;
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(AGE_0_7, Integer.valueOf(0)), 3);
	}

	/* blockstate の更新 */
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		DoubleBlockHalf half = stateIn.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.CORN) &&
					facingState.get(HALF) != half ? stateIn.with(AGE_0_7, facingState.get(AGE_0_7)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* 設置制限 */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return (block != Blocks.GRASS_BLOCK && block != Blocks.DIRT && block != Blocks.COARSE_DIRT && block != Blocks.PODZOL) && block == Blocks.FARMLAND;
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if (state.get(HALF) != DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pos.down();
			return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
		}

		else {
			BlockState blockstate = worldIn.getBlockState(pos.down());
			if (state.getBlock() != this) return super.isValidPosition(state, worldIn, pos);
			return blockstate.getBlock() == this && blockstate.get(HALF) == DoubleBlockHalf.LOWER;
		}
	}

	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		return false;
	}

	/* TickRandom */
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(AGE_0_7);
		BlockState upstate = worldIn.getBlockState(pos.up());
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		float f = getGrowthChance(this, worldIn, pos);
		if (state.get(HALF) == DoubleBlockHalf.LOWER) {
			if (i < 7 && worldIn.getLightSubtracted(pos.up(), 0) >= 9 &&
						net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {
	
				worldIn.setBlockState(pos, state.with(AGE_0_7, Integer.valueOf(i + 1)), 2);
				worldIn.setBlockState(pos.up(), upstate.with(AGE_0_7, Integer.valueOf(i + 1)), 2);
				net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
			}
		}
	}

	protected static float getGrowthChance(Block blockIn, IBlockReader worldIn, BlockPos pos) {
		float f = 1.0F;
		BlockPos blockpos = pos.down();

		for(int i = -1; i <= 1; ++i) {
			for(int j = -1; j <= 1; ++j) {
				float f1 = 0.0F;
				BlockState blockstate = worldIn.getBlockState(blockpos.add(i, 0, j));
				if (blockstate.canSustainPlant(worldIn, blockpos.add(i, 0, j), net.minecraft.util.Direction.UP, (net.minecraftforge.common.IPlantable)blockIn)) {
					f1 = 1.0F;
					if (blockstate.isFertile(worldIn, blockpos.add(i, 0, j))) {
						f1 = 3.0F;
					}
				}

				if (i != 0 || j != 0) {
					f1 /= 4.0F;
				}

				f += f1;
			}
		}

		BlockPos blockpos1 = pos.north();
		BlockPos blockpos2 = pos.south();
		BlockPos blockpos3 = pos.west();
		BlockPos blockpos4 = pos.east();
		boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
		boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();
		if (flag && flag1) {
			f /= 2.0F;
		} else {
			boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();
			if (flag2) {
				f /= 2.0F;
			}
		}

		return f;
	}

	/* 必要項目 */
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return state.get(AGE_0_7) < 7;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.rand, 2, 5);
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		BlockState upstate = worldIn.getBlockState(pos.up());
		int i = state.get(AGE_0_7) + this.getBonemealAgeIncrease(worldIn);
		int j = 7;
		if (i > j) {
			i = j;
		}
		
		if (state.get(HALF) == DoubleBlockHalf.LOWER) {
			worldIn.setBlockState(pos, state.with(AGE_0_7, Integer.valueOf(i)), 2);
			worldIn.setBlockState(pos.up(), upstate.with(AGE_0_7, Integer.valueOf(i)), 2);
		}
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.get(HALF);
		int i = state.get(AGE_0_7);

		switch(i) {
		default:
		case 0:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_0;
		case 1:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_1;
		case 2:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty(): AABB_BOT_2;
		case 3:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_3;
		case 4:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_4;
		case 5:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_5;
		case 6:
			return (half == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : AABB_BOT_6;
		case 7:
			return (half == DoubleBlockHalf.UPPER)? AABB_TOP_7 : AABB_BOT_7;
		}
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE_0_7, HALF);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.SEEDS_CORN);
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.up());
		BlockState downstate = worldIn.getBlockState(pos.down());

		if (downstate.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.down(), false); }
		if (upstate.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.up(), true); }
		if (playerIn.isCreative()) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

}
