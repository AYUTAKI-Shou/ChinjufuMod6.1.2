package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.furnace.Irori;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BaseIrori_Sakana extends Block implements IWaterLoggable {

	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(6.0D, -5.0D, 10.75D, 10.0D, 3.5D, 14.5D),
			Block.box(6.0D, -5.0D, 1.5D, 10.0D, 3.5D, 5.25D),
			Block.box(1.5D, -5.0D, 6.0D, 5.25D, 3.5D, 10.0D),
			Block.box(10.5D, -5.0D, 6.0D, 14.75D, 3.5D, 10.0D));

	public BaseIrori_Sakana(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState()
				.setValue(STAGE_0_15, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	protected boolean isCooking(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();
		return (block instanceof Irori && state.getValue(Irori.LIT));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.getLiquidTicks().scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true; }
		
		else { return false; }
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		
		else { return Fluids.EMPTY; }
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (isCooking(worldIn, pos, Direction.DOWN)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1000); }
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }

		return !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockState downstate = worldIn.getBlockState(pos.below());
		Block downblock = downstate.getBlock();
		return downblock instanceof Irori;
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_15, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (isCooking(worldIn, pos, Direction.DOWN)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1000); }
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (isCooking(worldIn, pos, Direction.DOWN)) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false); }

			if (rand.nextDouble() < 0.1D) {
				/** 種類, 座標x, y, z, 速度x, y, z **/
				worldIn.addParticle(ParticleTypes.SMOKE, d0 + d4, d1 + d6 - 0.3D, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}

}
