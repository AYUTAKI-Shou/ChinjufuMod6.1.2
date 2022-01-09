package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.Config_CM;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WindowTall_Bot extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape FRAME_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.makeCuboidShape(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 0.0D, 8.0D, 16.0D, 17.0D, 9.5D));
	protected static final VoxelShape CLOSE_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 0.0D, 0.0D, 8.0D, 17.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 0.0D, 6.5D, 16.0D, 17.0D, 8.0D));
	protected static final VoxelShape CLOSE_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 0.0D, 0.0D, 9.5D, 17.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 8.0D, 8.0D, 16.0D, 25.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 8.0D, 0.0D, 8.0D, 25.0D, 16.0D));
	protected static final VoxelShape OPEN2_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 8.0D, 6.5D, 16.0D, 25.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 8.0D, 0.0D, 9.5D, 25.0D, 16.0D));

	protected static final VoxelShape OPEN3_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.makeCuboidShape(0.0D, 14.0D, 8.0D, 16.0D, 31.0D, 9.5D));
	protected static final VoxelShape OPEN3_WEST = VoxelShapes.or(FRAME_WEST, Block.makeCuboidShape(6.5D, 14.0D, 0.0D, 8.0D, 31.0D, 16.0D));
	protected static final VoxelShape OPEN3_NORTH = VoxelShapes.or(FRAME_NORTH, Block.makeCuboidShape(0.0D, 14.0D, 6.5D, 16.0D, 31.0D, 8.0D));
	protected static final VoxelShape OPEN3_EAST = VoxelShapes.or(FRAME_EAST, Block.makeCuboidShape(8.0D, 14.0D, 0.0D, 9.5D, 31.0D, 16.0D));

	public WindowTall_Bot(Block.Properties properties) {
		super(properties);
	}

	/* 影対策 */
	public int getLightValue(BlockState state) {
		int i = state.get(STAGE_1_3);
		return (i == 3 && Config_CM.getInstance().antiShadow() == true)? 1 : 0;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		int i = state.get(STAGE_1_3);

		switch(direction) {
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPEN2_SOUTH : OPEN3_SOUTH);
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPEN2_WEST : OPEN3_WEST);
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPEN2_NORTH : OPEN3_NORTH);
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPEN2_EAST : OPEN3_EAST);
		}
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		if (hit.getHitVec().y - (double)pos.getY() < 0.96875D) {
			worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos, state.cycle(STAGE_1_3));
		}
		return ActionResultType.SUCCESS;
	}


	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (this == Window_Blocks.WINDOWTALLBOT_oak) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_oak
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_spruce) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_spruce
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_birch) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_birch
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_jungle) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_jungle
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_acacia) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_acacia
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_darkoak) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_darkoak
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_sakura) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_sakura
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_kaede) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_kaede
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
		if (this == Window_Blocks.WINDOWTALLBOT_ichoh) { worldIn.setBlockState(pos.up(), Window_Blocks.WINDOWTALLTOP_ichoh
				.getDefaultState().with(H_FACING, state.get(H_FACING)).with(WATERLOGGED, worldIn.getFluidState(pos.up()).getFluid() == Fluids.WATER)
				.with(STAGE_1_3, Integer.valueOf(1))); }
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* Destroy at the same time. & Drop item. */
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.up());

		if (upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_oak || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_spruce || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_birch || upstate
				.getBlock() == Window_Blocks.WINDOWTALLTOP_jungle || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_acacia || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_darkoak || upstate
				.getBlock() == Window_Blocks.WINDOWTALLTOP_sakura || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_kaede || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_ichoh) {
			worldIn.destroyBlock(pos.up(), false);
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
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

	public boolean isOpaqueCube(IBlockReader worldIn, BlockPos pos) {
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
		tooltip.add((new TranslationTextComponent("tips.block_windowb")).applyTextStyle(TextFormatting.GRAY));
	}

}
