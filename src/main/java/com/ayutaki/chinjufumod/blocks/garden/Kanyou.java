package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
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

public class Kanyou extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	/* Collision */
	protected static final VoxelShape AABB_TOP = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	protected static final VoxelShape AABB_BOT = VoxelShapes.or(Block.box(7.0D, 5.0D, 7.0D, 9.0D, 16.0D, 9.0D),
			Block.box(4.5D, 5.0D, 4.5D, 11.5D, 6.0D, 5.0D),
			Block.box(4.5D, 5.0D, 11.0D, 11.5D, 6.0D, 11.5D),
			Block.box(4.5D, 5.0D, 4.5D, 5.0D, 6.0D, 11.5D),
			Block.box(11.0D, 5.0D, 4.5D, 11.5D, 6.0D, 11.5D),
			Block.box(4.5D, 0.0D, 4.5D, 11.5D, 5.0D, 11.5D));
	
	protected static final VoxelShape AABB_TOP2 = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	protected static final VoxelShape AABB_BOT2 = VoxelShapes.or(Block.box(7.0D, 0.0D, 7.0D, 9.0D, 14.0D, 9.0D),
			Block.box(2.0D, 14.0D, 2.0D, 14.0D, 16.0D, 14.0D));

	public Kanyou(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(STAGE_1_2, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();
		PlayerEntity placer = context.getPlayer();
		
		/** pos.up() = Replaceable block. **/
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			if (placer.isCrouching()) { return this.defaultBlockState().setValue(STAGE_1_2, Integer.valueOf(2))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
			
			else { return this.defaultBlockState().setValue(STAGE_1_2, Integer.valueOf(1))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
		}

		else { return null; }
	}

	/* Limit the place. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.below();
		BlockState downstate = worldIn.getBlockState(downpos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downstate.getBlock() == this; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		if (placer.isCrouching()) {
			worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
					.setValue(STAGE_1_2, Integer.valueOf(2))
					.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3); }
		
		else { worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(STAGE_1_2, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3); }
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void breakLowerPart(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downpos = pos.below();
			BlockState downstate = worldIn.getBlockState(downpos);

			if (downstate.getBlock() == state.getBlock() && downstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downpos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downpos, Block.getId(downstate));
			}
		}
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

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.getValue(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : state;
		}
		else {
			return Blocks.AIR.defaultBlockState();
		}
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, STAGE_1_2, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(STAGE_1_2);
		
		switch (half) {
		case LOWER :
		default :
			switch (i) {
			case 1 :
			default : return AABB_BOT;
			case 2 : return AABB_BOT2;
			}

		case UPPER :
			switch (i) {
			case 1 :
			default : return AABB_TOP;
			case 2 : return AABB_TOP2;
			}
		} // switch LOWER-UPPER
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kanyou")).withStyle(TextFormatting.GRAY));
	}

}
