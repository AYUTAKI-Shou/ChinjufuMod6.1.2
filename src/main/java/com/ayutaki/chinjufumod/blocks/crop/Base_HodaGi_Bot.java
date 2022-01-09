package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Base_HodaGi_Bot extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(5.0D, 0.0D, 4.0D, 11.0D, 12.0D, 15.0D);
	protected static final VoxelShape AABB_WEST = Block.box(1.0D, 0.0D, 5.0D, 12.0D, 12.0D, 11.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(5.0D, 0.0D, 1.0D, 11.0D, 12.0D, 12.0D);
	protected static final VoxelShape AABB_EAST = Block.box(4.0D, 0.0D, 5.0D, 15.0D, 12.0D, 11.0D);
	
	public Base_HodaGi_Bot(AbstractBlock.Properties properties) {
		super(properties);
		
		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
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

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, STAGE_1_4, WATERLOGGED);
	}

	/* TickRandom */
	private boolean inShade(ServerWorld worldIn, BlockPos pos) {
		return ((worldIn.canSeeSky(pos) && !worldIn.isDay()) || (!worldIn.canSeeSky(pos) && worldIn.getRawBrightness(pos, 0) <= 11));
	}

	/* 個体差は大きいが簡易な .tickRandomly() 一晩当たりの成長速度から rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_4);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (state.getValue(WATERLOGGED) == false) {
			if (i != 4) {
				if (inShade(worldIn, pos) && rand.nextInt(8) == 0) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
			
			if (i == 4) { }
		}
		
		if (state.getValue(WATERLOGGED) != false) {
			if (i != 1) {
				if (rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					this.dropRottenfood(worldIn, pos); } }
			
			if (i == 1) { }
		}
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		switch (direction) {
		case NORTH:
		default:
			return AABB_NORTH;
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case EAST:
			return AABB_EAST;
		}
	}
	
	/* Destroy at the same time. & Drop item. */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.above());
		/** False is not Drop. **/
		if (upstate.getBlock() instanceof Base_HodaGi_Top) {
			worldIn.destroyBlock(pos.above(), false); }
		
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.HODAGI);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_hodagi_a_bot")).withStyle(TextFormatting.GRAY));
	}

}
