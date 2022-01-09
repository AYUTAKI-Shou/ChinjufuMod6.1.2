package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
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

public class SushiMeshi extends Block implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_0_15 = IntegerProperty.create("stage", 0, 15);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.5D, 15.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(1.0D, -8.0D, 1.0D, 15.0D, 0.1D, 15.0D);

	public SushiMeshi(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState()
				.setValue(STAGE_0_15, Integer.valueOf(0))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_15);

		if (item == Items_Teatime.KIRIMI_S) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_S)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_S))) {
				playerIn.drop(new ItemStack(Items_Teatime.SUSHI_S), false); }

			if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }

			if (i == 15) {
				worldIn.setBlock(pos, Dish_Blocks.PIZZA.defaultBlockState().setValue(Pizza.DOWN, state.getValue(DOWN))
						.setValue(Pizza.STAGE_1_6, Integer.valueOf(6)), 3); }
		}

		if (item == Items_Teatime.KIRIMI_F) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_F)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_F))) {
				playerIn.drop(new ItemStack(Items_Teatime.SUSHI_F), false); }

			if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }

			if (i == 15) {
				worldIn.setBlock(pos, Dish_Blocks.PIZZA.defaultBlockState().setValue(Pizza.DOWN, state.getValue(DOWN))
						.setValue(Pizza.STAGE_1_6, Integer.valueOf(6)), 3); }
		}

		if (item == Items_Teatime.KIRIMI_B) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_B)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_B))) {
				playerIn.drop(new ItemStack(Items_Teatime.SUSHI_B), false); }

			if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }

			if (i == 15) {
				worldIn.setBlock(pos, Dish_Blocks.PIZZA.defaultBlockState().setValue(Pizza.DOWN, state.getValue(DOWN))
						.setValue(Pizza.STAGE_1_6, Integer.valueOf(6)), 3); }
		}

		if (item == Items_Teatime.KIRIMI_T) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_T)); }
			else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.SUSHI_T))) {
				playerIn.drop(new ItemStack(Items_Teatime.SUSHI_T), false); }

			if (i != 15) { worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(i + 1)), 3); }

			if (i == 15) {
				worldIn.setBlock(pos, Dish_Blocks.PIZZA.defaultBlockState().setValue(Pizza.DOWN, state.getValue(DOWN))
						.setValue(Pizza.STAGE_1_6, Integer.valueOf(6)), 3); }
		}
		
		if (item != Items_Teatime.KIRIMI_S && item != Items_Teatime.KIRIMI_F && item != Items_Teatime.KIRIMI_B && item != Items_Teatime.KIRIMI_T) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN));
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlabWater_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlabWater_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.getValue(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.getValue(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.getValue(Kotatsu.WATERLOGGED)));
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

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, Fluids.WATER.getTickDelay(worldIn)); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }

		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, STAGE_0_15, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_0_15);
		return (i == 0)? new ItemStack(Items_Teatime.SUSHIMESHI) : new ItemStack(Items.BOWL);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 60);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.PIZZA.defaultBlockState()
					.setValue(Pizza.DOWN, state.getValue(DOWN))
					.setValue(Pizza.STAGE_1_6, Integer.valueOf(6))
					.setValue(Pizza.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_food_sushimeshi")).withStyle(TextFormatting.GRAY));
	}

}
