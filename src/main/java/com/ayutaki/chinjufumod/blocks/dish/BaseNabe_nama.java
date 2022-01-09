package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven;
import com.ayutaki.chinjufumod.blocks.furnace.Kitchen_Oven_B;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.blocks.unitblock.Chabudai;
import com.ayutaki.chinjufumod.blocks.unitblock.Kotatsu;
import com.ayutaki.chinjufumod.blocks.unitblock.LowDesk;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.SlabType;
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
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BaseNabe_nama extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty COOK = BooleanProperty.create("cook");
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 4.0D, 12.5D);

	public BaseNabe_nama(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(COOK, Boolean.valueOf(false))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		CMEvents.textRequestHeat(worldIn, pos, playerIn);
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(COOK, this.connectCook(worldIn, pos, Direction.DOWN))
				.setValue(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	protected boolean connectCook(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return (block instanceof FurnaceBlock || block instanceof Kitchen_Oven || block instanceof Kitchen_Oven_B ||
				block instanceof Irori || block instanceof Kit_Cooktop);
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
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if (isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1200 + (20 * worldIn.getRandom().nextInt(5))); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }

		boolean cook = connectCook(worldIn, pos, Direction.DOWN);
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.setValue(COOK, cook).setValue(DOWN, down);
	}

	/* TickRandom and Conditions for TickRandom. */
	protected boolean isCooking(IBlockReader worldIn, BlockPos pos) {
		BlockState downstate = worldIn.getBlockState(pos.below());
		Block downblock = downstate.getBlock();
		return (downblock == Blocks.FURNACE && downstate.getValue(FurnaceBlock.LIT) == true) ||
				(downblock == Kitchen_Blocks.KIT_OVEN && downstate.getValue(Kitchen_Oven.LIT) == true) ||
				(downblock == Kitchen_Blocks.KIT_OVEN_B && downstate.getValue(Kitchen_Oven_B.LIT) == true) ||
				(downblock == Kitchen_Blocks.IRORI && downstate.getValue(Irori.LIT) == true) ||
				(downblock == Kitchen_Blocks.KIT_COOKTOP && downstate.getValue(Kit_Cooktop.STAGE_1_3) == 2);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1200 + (20 * worldIn.random.nextInt(5))); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60); }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
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

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(COOK, DOWN, H_FACING, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_nabe")).withStyle(TextFormatting.GRAY));
	}

}
