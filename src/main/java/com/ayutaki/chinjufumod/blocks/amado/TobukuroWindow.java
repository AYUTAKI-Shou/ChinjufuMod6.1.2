package com.ayutaki.chinjufumod.blocks.amado;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

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
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
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

public class TobukuroWindow extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_3 = IntegerProperty.create("stage", 1, 3);
	public static final BooleanProperty WHICH = BooleanProperty.create("which");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(-0.5D, -0.5D, 0.0D, 16.5D, 16.5D, 3.0D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(13.0D, -0.5D, -0.5D, 16.0D, 16.5D, 16.5D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(-0.5D, -0.5D, 13.0D, 16.5D, 16.5D, 16.0D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(0.0D, -0.5D, -0.5D, 3.0D, 16.5D, 16.5D);

	/** 1=2枚、2=1枚、3=0枚 **/
	public TobukuroWindow(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_3, Integer.valueOf(1))
				.with(WHICH, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=2枚、2=1枚、3=0枚 **/
		int i = state.get(STAGE_1_3);
		Direction direction = state.get(H_FACING);
		boolean which = state.get(WHICH);

		BlockState northstate = worldIn.getBlockState(pos.north());
		BlockState southstate = worldIn.getBlockState(pos.south());
		BlockState eaststate = worldIn.getBlockState(pos.east());
		BlockState weststate = worldIn.getBlockState(pos.west());

		if (i != 3) {
			CMEvents.soundAmadoWin(worldIn, pos);
			
			/** DarkOak **/
			if (this == Slidedoor_Blocks.TOBUKUROWIN && which != true) {

				switch (direction) {
				case NORTH :
				default :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}

			if (this == Slidedoor_Blocks.TOBUKUROWIN && which == true) {

				switch (direction) {
				case NORTH :
				default :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidedoor_Blocks.AMADOWIN.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}

			
			/** Spruce **/
			if (this == Slidedoor_Blocks.TOBUKUROWIN_S && which != true) {

				switch (direction) {
				case NORTH :
				default :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(1))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}

			if (this == Slidedoor_Blocks.TOBUKUROWIN_S && which == true) {

				switch (direction) {
				case NORTH :
				default :
					if (eaststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.east(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!eaststate.getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (weststate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.west(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!weststate.getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (southstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.south(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!southstate.getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (northstate.getMaterial().isReplaceable()) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.north(), Slidedoor_Blocks.AMADOWIN_S.getDefaultState()
								.with(H_FACING, state.get(H_FACING)).with(BaseStage2_FaceWater.STAGE_1_2, Integer.valueOf(2))); }
					
					if (!northstate.getMaterial().isReplaceable()) { }
					break;
				} // switch
			}
		} // i != 3
	
		if (i == 3) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}


	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		PlayerEntity playerIn = context.getPlayer();

		if (playerIn.isSneaking()) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(STAGE_1_3, Integer.valueOf(1))
					.with(WHICH, Boolean.valueOf(true))
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER); }

		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(STAGE_1_3, Integer.valueOf(1))
				.with(WHICH, Boolean.valueOf(false))
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
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

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, STAGE_1_3, WHICH, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch(direction) {
			case SOUTH:
				return AABB_SOUTH;
			case WEST:
				return AABB_WEST;
			case NORTH:
			default:
				return AABB_NORTH;
			case EAST:
				return AABB_EAST;
		}
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_tobukuro")).applyTextStyle(TextFormatting.GRAY));
	}

}
