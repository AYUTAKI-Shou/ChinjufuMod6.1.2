package com.ayutaki.chinjufumod.blocks.garden;

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
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class Chouzubachi extends Block implements IWaterLoggable {

	/* Property 空=0,1,2,3=満,4=溢 */
	public static final IntegerProperty STAGE_0_3 = IntegerProperty.create("stage", 0, 3);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);

	public Chouzubachi(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_3, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_3);

		if (!state.getValue(WATERLOGGED)) {
			if (i > 0) {
				if (itemstack.isEmpty()) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_3, Integer.valueOf(i - 1)), 3);}
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
	
			if (i < 3) {
				if (item == Items.WATER_BUCKET) {
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_0_3, Integer.valueOf(3)), 3); }
		
				if (item == Items_Teatime.MIZUOKE_full) {
					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos, state.setValue(STAGE_0_3, Integer.valueOf(3)), 3); }
				
				if (i == 0 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
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
			return true;
		}
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
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (true) { worldIn.getBlockTicks().scheduleTick(pos, this, 300); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 300);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_0_3);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!state.getValue(WATERLOGGED)) {
			
			if (rain(worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 300); 
				
					if (i < 3) { worldIn.setBlock(pos, state.setValue(STAGE_0_3, Integer.valueOf(i + 1)), 3); }
					else { } }
			
			if (!rain(worldIn, pos)) { }
		}

		if (state.getValue(WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_3, Integer.valueOf(3)), 3);
			worldIn.getBlockTicks().scheduleTick(pos, this, 300);
		}
	}

	protected boolean rain(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos.above());
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_3, WATERLOGGED);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_chouzubachi")).withStyle(TextFormatting.GRAY));
	}

}
