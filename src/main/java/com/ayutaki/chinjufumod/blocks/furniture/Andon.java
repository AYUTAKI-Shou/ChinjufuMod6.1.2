package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
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
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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

public class Andon extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 12.0D, 11.0D);

	public Andon(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		boolean lit = state.getValue(LIT);

		if (item instanceof Base_ItemHake) { return ActionResultType.PASS; }

		else {
			if (lit == false) {
				
				if (!state.getValue(WATERLOGGED)) {
					
					if (item == Items.FLINT_AND_STEEL) {
						itemstack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );

						CMEvents.soundFlint(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
		
					if (item == Items_Teatime.MATCH) {
						CMEvents.Consume_1Item(playerIn, hand);						
						CMEvents.soundFlint(worldIn, pos);
						
						worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(true)), 3); }
					
					if (item != Items.FLINT_AND_STEEL && item != Items_Teatime.MATCH) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				}
				
				if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
			}
			
			if (lit == true) {
				if (itemstack.isEmpty()) {
					CMEvents.soundFireExting(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
			
			/** SUCCESS to not put anything on top. **/
			return ActionResultType.SUCCESS;
		}
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
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

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 10);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (state.getValue(LIT) == true && state.getValue(WATERLOGGED) == true) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 10);
			
			CMEvents.soundFireExting(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(LIT, Boolean.valueOf(false)), 3); }

		else { }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, LIT, WATERLOGGED);
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		boolean lit = state.getValue(LIT);

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.3D;
		double d2 = (double)pos.getZ() + 0.5D;

		if (lit == true) {

			if (rand.nextDouble() < 0.05D) {
					/** 種類, 座標x, y, z, 速度x, y, z **/
				worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D); }
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_andon")).withStyle(TextFormatting.GRAY));
	}

}
