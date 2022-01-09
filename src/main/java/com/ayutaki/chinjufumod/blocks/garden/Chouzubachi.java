package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
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
import net.minecraft.world.IWorldReader;
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
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D);

	public Chouzubachi(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_3, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_3);

		if (!state.get(WATERLOGGED)) {
			if (i > 0) {
				if (itemstack.isEmpty()) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(i - 1))); }
				
				if (!itemstack.isEmpty()) {
					CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			if (i < 3) {
				if (item == Items.WATER_BUCKET) {

					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {

					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3))); }
				
				if (i == 0 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		}
		
		if (state.get(WATERLOGGED)) { 
			CMEvents.textIsWaterlogged(worldIn, pos, playerIn);
			return ActionResultType.SUCCESS;
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
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

	/* 採取適正ツール */
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
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public int tickRate(IWorldReader world) {
		return 300;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_0_3);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i < 3 && !state.get(WATERLOGGED) && worldIn.isRainingAt(pos.up())) {
			worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(i + 1)));
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
		}

		if (i < 3 && state.get(WATERLOGGED)) {
			worldIn.setBlockState(pos, state.with(STAGE_0_3, Integer.valueOf(3)));
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
		}

		else { }
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_0_3, WATERLOGGED);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_chouzubachi")).applyTextStyle(TextFormatting.GRAY));
	}

}
