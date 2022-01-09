package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

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
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Sudare extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_3 = IntegerProperty.create("stage", 1, 3);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.box(0.0D, -16.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S1_WEST = Block.box(15.5D, -16.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.box(0.0D, -16.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S1_EAST = Block.box(0.0D, -16.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S2_WEST = Block.box(15.5D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.box(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_EAST = Block.box(0.0D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	protected static final VoxelShape S3_SOUTH = Block.box(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape S3_WEST = Block.box(15.5D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S3_NORTH = Block.box(0.0D, 14.0D, 15.5D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S3_EAST = Block.box(0.0D, 14.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public Sudare(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_3, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Limit the place. ...Unused */


	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_3);

		if (itemstack.isEmpty()) {
			if (playerIn.isCrouching() && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
				CMEvents.soundWoolPlace(worldIn, pos);
	
				if (i == 1) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.below(), Blocks.AIR.defaultBlockState(), 3); }
	
				if (i == 2) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(i + 1)), 3); }
	
				if (i == 3 && worldIn.getBlockState(pos.below()).getMaterial().isReplaceable()) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3);
					worldIn.setBlock(pos.below(), this.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
							.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
			}
			
			if (!playerIn.isCrouching()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();

		/** pos.up() = Replaceable block. **/
		if (context.getLevel().getBlockState(blockpos.below()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(STAGE_1_3, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.UPPER);
		}

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.below(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
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
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
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

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }

			else {
				dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem());
				worldIn.destroyBlock(pos.below(), false); }
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

	@OnlyIn(Dist.CLIENT)
	public long getSeed(BlockState state, BlockPos pos) {
		return MathHelper.getSeed(pos.getX(), pos.below(state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_3, WATERLOGGED);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		int i = state.getValue(STAGE_1_3);
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_NORTH : ((i == 2)? S2_NORTH : S3_NORTH));
		case SOUTH:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_SOUTH : ((i == 2)? S2_SOUTH : S3_SOUTH));
		case WEST:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_WEST : ((i == 2)? S2_WEST : S3_WEST));
		case EAST:
			return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? VoxelShapes.empty() : ((i == 1)? S1_EAST : ((i == 2)? S2_EAST : S3_EAST));
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.SUDARE);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_sudare")).withStyle(TextFormatting.GRAY));
	}

}
