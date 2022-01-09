package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BaseShishiOdoshi extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WHICH = BooleanProperty.create("which");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 15.0D, 10.0D, 14.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 15.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(1.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(2.0D, 0.0D, 1.0D, 14.0D, 10.0D, 14.0D);

	public BaseShishiOdoshi(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WHICH, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* 影対策では消えないため、形状変更 */

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		PlayerEntity playerIn = context.getPlayer();
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			if (playerIn.isSneaking()) {
				return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
						.with(WHICH, Boolean.valueOf(true))
						.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite()); }

			return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
					.with(WHICH, Boolean.valueOf(false))
					.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(H_FACING, state.get(H_FACING))
				.with(WHICH, state.get(WHICH))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* 設置制限 */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	@SuppressWarnings("deprecation")
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

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Garden_Blocks.SHISHIODOSHI || facingState.getBlock() == Garden_Blocks.SHISHIODOSHI2) &&
					facingState.get(HALF) != half ? state.with(H_FACING, facingState.get(H_FACING)).with(STAGE_1_4, facingState.get(STAGE_1_4)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* 同時破壊とドロップの指定 1.16.5に合わせる */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, blockpos, Block.getStateId(blockstate));

			ItemStack itemstack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(blockstate)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, itemstack);
				Block.spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, playerIn, itemstack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	/* 窒息 */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* 立方体 */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.get(H_FACING);
		boolean which = state.get(WHICH);

		switch(direction) {
		case SOUTH:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : (which != true? AABB_SOUTH : AABB_NORTH);
		case WEST:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : (which != true? AABB_WEST : AABB_EAST);
		case NORTH:
		default:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : (which != true? AABB_NORTH : AABB_SOUTH);
		case EAST:
			return (state.get(HALF) == DoubleBlockHalf.UPPER)? VoxelShapes.empty() : (which != true? AABB_EAST : AABB_WEST);
		}
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, HALF, STAGE_1_4, WHICH, WATERLOGGED);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.SHISHIODOSHI);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_shishiodoshi")).applyTextStyle(TextFormatting.GRAY));
	}

}
