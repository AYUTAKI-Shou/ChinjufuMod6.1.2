package com.ayutaki.chinjufumod.blocks.window;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Window_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
	protected static final VoxelShape FRAME_SOUTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_WEST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	protected static final VoxelShape FRAME_NORTH = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 0.01D, 9.0D);
	protected static final VoxelShape FRAME_EAST = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 0.01D, 16.0D);
	
	protected static final VoxelShape CLOSE_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 0.0D, 8.0D, 16.0D, 17.0D, 9.5D));
	protected static final VoxelShape CLOSE_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 0.0D, 0.0D, 8.0D, 17.0D, 16.0D));
	protected static final VoxelShape CLOSE_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 0.0D, 6.5D, 16.0D, 17.0D, 8.0D));
	protected static final VoxelShape CLOSE_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 0.0D, 0.0D, 9.5D, 17.0D, 16.0D));

	protected static final VoxelShape OPEN2_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 8.0D, 8.0D, 16.0D, 25.0D, 9.5D));
	protected static final VoxelShape OPEN2_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 8.0D, 0.0D, 8.0D, 25.0D, 16.0D));
	protected static final VoxelShape OPEN2_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 8.0D, 6.5D, 16.0D, 25.0D, 8.0D));
	protected static final VoxelShape OPEN2_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 8.0D, 0.0D, 9.5D, 25.0D, 16.0D));

	protected static final VoxelShape OPEN3_SOUTH = VoxelShapes.or(FRAME_SOUTH, Block.box(0.0D, 14.0D, 8.0D, 16.0D, 31.0D, 9.5D));
	protected static final VoxelShape OPEN3_WEST = VoxelShapes.or(FRAME_WEST, Block.box(6.5D, 14.0D, 0.0D, 8.0D, 31.0D, 16.0D));
	protected static final VoxelShape OPEN3_NORTH = VoxelShapes.or(FRAME_NORTH, Block.box(0.0D, 14.0D, 6.5D, 16.0D, 31.0D, 8.0D));
	protected static final VoxelShape OPEN3_EAST = VoxelShapes.or(FRAME_EAST, Block.box(8.0D, 14.0D, 0.0D, 9.5D, 31.0D, 16.0D));

	public WindowTall_Bot(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_3);

		switch (direction) {
		case NORTH:
		default:
			return (i == 1)? CLOSE_NORTH : ((i == 2)? OPEN2_NORTH : OPEN3_NORTH);
		case SOUTH:
			return (i == 1)? CLOSE_SOUTH : ((i == 2)? OPEN2_SOUTH : OPEN3_SOUTH);
		case WEST:
			return (i == 1)? CLOSE_WEST : ((i == 2)? OPEN2_WEST : OPEN3_WEST);
		case EAST:
			return (i == 1)? CLOSE_EAST : ((i == 2)? OPEN2_EAST : OPEN3_EAST);
		}
	}

	@Override
	public BlockRenderType getRenderShape(BlockState state) {
		return BlockRenderType.MODEL;
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		if (hit.getLocation().y - (double)pos.getY() < 0.96875D) {
			worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_UD, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlock(pos, state.cycle(STAGE_1_3), 3);
		}
		return ActionResultType.SUCCESS;
	}


	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (this == Window_Blocks.WINDOWTALLBOT_oak) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_oak
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_spruce) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_spruce
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_birch) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_birch
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_jungle) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_jungle
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_acacia) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_acacia
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_darkoak) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_darkoak
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_sakura) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_sakura
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_kaede) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_kaede
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
		if (this == Window_Blocks.WINDOWTALLBOT_ichoh) { worldIn.setBlock(pos.above(), Window_Blocks.WINDOWTALLTOP_ichoh
				.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(worldIn.getFluidState(pos.above()).getType() == Fluids.WATER))
				.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();

		/** pos.up() = Replaceable block. **/
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
		}

		else { return null; }
	}

	/* Destroy at the same time. & Drop item. */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.above());

		if (upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_oak || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_spruce || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_birch || upstate
				.getBlock() == Window_Blocks.WINDOWTALLTOP_jungle || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_acacia || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_darkoak || upstate
				.getBlock() == Window_Blocks.WINDOWTALLTOP_sakura || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_kaede || upstate.getBlock() == Window_Blocks.WINDOWTALLTOP_ichoh) {
			worldIn.destroyBlock(pos.above(), false);
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_windowb")).withStyle(TextFormatting.GRAY));
	}

}
