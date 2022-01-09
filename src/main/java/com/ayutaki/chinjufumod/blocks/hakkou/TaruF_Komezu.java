package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
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
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TaruF_Komezu extends Block implements IWaterLoggable {

	/* プロパティの追加 */
	public static final IntegerProperty STAGE_0_8 = IntegerProperty.create("stage", 0, 8);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.25D, 8.0D, 0.25D, 15.75D, 12.0D, 15.75D),
			Block.box(0.5D, 4.0D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.box(0.75D, 0.0D, 0.75D, 15.25D, 4.0D, 15.25D));

	/** 0=未発酵の米酢、5=米酢、6=米酢、7=米酢、8=米酢 **/
	public TaruF_Komezu(AbstractBlock.Properties properties) {
		super(properties);
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_8, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}


	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_8);

		/** Too early to collect **/
		if (i <= 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 4) {
			if (item == Items.GLASS_BOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundBottleFill(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.KOMEZU_bot_1)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.KOMEZU_bot_1))) {
					playerIn.drop(new ItemStack(Items_Teatime.KOMEZU_bot_1), false); }
	
				if (i != 8) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_8, Integer.valueOf(i + 1)), 3); }
	
				if (i == 8) {
					worldIn.setBlock(pos, Hakkou_Blocks.HAKKOU_TARU.defaultBlockState()
							.setValue(Taru_Hakkou.STAGE_0_5, Integer.valueOf(0)), 3); }
			}
			
			if (item != Items.GLASS_BOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
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

		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_0_8);

		if (i < 4 && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_8, Integer.valueOf(i + 1)), 3); }

		if (i == 4 && rand.nextInt(4) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_0_8, Integer.valueOf(i + 1)), 3);
			/** Get EXP. **/
			worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1)); }

		else { }
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_8, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Flammable Block */
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return true; }

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 5; }

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) { return 20; }

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_taru_komezu")).withStyle(TextFormatting.GRAY));
	}

}
