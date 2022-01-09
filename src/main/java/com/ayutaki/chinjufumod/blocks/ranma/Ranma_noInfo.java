package com.ayutaki.chinjufumod.blocks.ranma;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Ranma_noInfo extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty VER = IntegerProperty.create("ver", 1, 2);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape S1_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_WEST = Block.makeCuboidShape(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);
	protected static final VoxelShape S1_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 16.0D, 9.5D);
	protected static final VoxelShape S1_EAST = Block.makeCuboidShape(6.5D, 0.0D, 0.0D, 9.5D, 16.0D, 16.0D);

	protected static final VoxelShape S2_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_WEST = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
	protected static final VoxelShape S2_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
	protected static final VoxelShape S2_EAST = Block.makeCuboidShape(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Ranma_noInfo(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(TYPE, Type.DEFAULT)
				.with(VER, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* 影対策 */
	public int getLightValue(BlockState state) {
		return (Config_CM.getInstance().antiShadow() == true)? 1 : 0;
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);

		/** Hand is empty. **/
		if (itemstack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundWoodPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycle(VER));
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isSneaking()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		
		return ActionResultType.PASS;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
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

	/* Connect the blocks. */
	private boolean canConnectTo(IWorld worldIn, BlockPos source, Direction direction, Direction targetDirection) {
		BlockState state = worldIn.getBlockState(source.offset(direction));

		if(state.getBlock() == this) {
			Direction sofaDirection = state.get(H_FACING);
			return sofaDirection.equals(targetDirection);
		}
		return false;
	}

	private BlockState getConnectState(BlockState state, IWorld worldIn, BlockPos pos, Direction dir) {
		boolean left = canConnectTo(worldIn, pos, dir.rotateY(), dir) || canConnectTo(worldIn, pos, dir.rotateY(), dir.rotateY());
		boolean right = canConnectTo(worldIn, pos, dir.rotateYCCW(), dir) || canConnectTo(worldIn, pos, dir.rotateYCCW(), dir.rotateYCCW());

		if(left && right) {
			return state.with(TYPE, Type.BOTH);
		}

		else if(left) {
			return state.with(TYPE, Type.RIGHT);
		}

		else if(right) {
			return state.with(TYPE, Type.LEFT);
		}
		return state.with(TYPE, Type.DEFAULT);
	}

	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return this.getConnectState(stateIn, worldIn, pos, stateIn.get(H_FACING));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, VER, TYPE, WATERLOGGED);
	}

	public enum Type implements IStringSerializable {
		DEFAULT("default"),
		LEFT("left"),
		RIGHT("right"),
		BOTH("both");

		private final String id;

		Type(String id) { this.id = id; }

		@Override
		public String getName() { return id; }

		@Override
		public String toString() { return id; }
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

		int i = state.get(VER);
		Direction direction = state.get(H_FACING);

		switch(direction) {
		case SOUTH:
			return (i == 1)? S1_SOUTH : S2_SOUTH;
		case WEST:
			return (i == 1)? S1_WEST : S2_WEST;
		case NORTH:
		default:
			return (i == 1)? S1_NORTH : S2_NORTH;
		case EAST:
			return (i == 1)? S1_EAST : S2_EAST;
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.wp_stage2")).applyTextStyle(TextFormatting.GRAY));
	}

}
