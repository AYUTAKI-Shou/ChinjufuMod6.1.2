package com.ayutaki.chinjufumod.blocks.garden;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Base_Niwaishi extends Block implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	public Base_Niwaishi(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_15, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_15);

		boolean mode = playerIn.abilities.isCreativeMode;
		
		if (itemstack.isEmpty()) {
			if (playerIn.isSneaking()) {
				if (i == 0 || i == 2 || i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 1)), 3); }

				if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 13 || i == 15) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i - 1)), 3); }
			}
		
			if (!playerIn.isSneaking()) { CMEvents.textNotSneak(worldIn, pos, playerIn); }
		}
		
		
		if (!itemstack.isEmpty()) {
			if (item == Items_Wadeco.NOMI) {
				if (i <= 13) {
					itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
					
					CMEvents.soundStoneBreak(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 2)), 3); }

				if (i == 14 || i == 15) {
					itemstack.damageItem(1, playerIn, user -> { user.sendBreakAnimation(hand); } );
					
					CMEvents.soundStoneBreak(worldIn, pos);
					if (!mode) { worldIn.destroyBlock(pos, true); }
					if (mode) { worldIn.destroyBlock(pos, false); } }
			}
			
			if (item != Items_Wadeco.NOMI) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
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

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(STAGE_0_15, WATERLOGGED);
	}

}
