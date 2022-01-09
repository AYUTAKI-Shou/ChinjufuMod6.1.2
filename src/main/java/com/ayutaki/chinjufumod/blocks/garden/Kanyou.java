package com.ayutaki.chinjufumod.blocks.garden;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kanyou extends Block implements IWaterLoggable {

	/* Property */
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final IntegerProperty STAGE_1_2 = IntegerProperty.create("stage", 1, 2);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_TOP = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
	protected static final VoxelShape AABB_BOT = VoxelShapes.or(Block.makeCuboidShape(7.0D, 5.0D, 7.0D, 9.0D, 16.0D, 9.0D),
			Block.makeCuboidShape(4.5D, 5.0D, 4.5D, 11.5D, 6.0D, 5.0D),
			Block.makeCuboidShape(4.5D, 5.0D, 11.0D, 11.5D, 6.0D, 11.5D),
			Block.makeCuboidShape(4.5D, 5.0D, 4.5D, 5.0D, 6.0D, 11.5D),
			Block.makeCuboidShape(11.0D, 5.0D, 4.5D, 11.5D, 6.0D, 11.5D),
			Block.makeCuboidShape(4.5D, 0.0D, 4.5D, 11.5D, 5.0D, 11.5D));
	
	protected static final VoxelShape AABB_TOP2 = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	protected static final VoxelShape AABB_BOT2 = VoxelShapes.or(Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 14.0D, 9.0D),
			Block.makeCuboidShape(2.0D, 14.0D, 2.0D, 14.0D, 16.0D, 14.0D));
	
	public Kanyou(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER)
				.with(STAGE_1_2, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();
		PlayerEntity placer = context.getPlayer();
		
		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			if (placer.isCrouching()) { return this.getDefaultState().with(STAGE_1_2, Integer.valueOf(2))
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER); }
			
			else { return this.getDefaultState().with(STAGE_1_2, Integer.valueOf(1))
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER); }
		}
		
		/** それ以外の時 **/
		else { return null; }
	}

	/* 設置制限 isSolidSide → true */
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (state.get(HALF) == DoubleBlockHalf.LOWER) {
			return true;
		}
		else {
			return blockstate.getBlock() == this;
		}
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());
		
		if (placer.isCrouching()) {
			worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
					.with(STAGE_1_2, Integer.valueOf(2))
					.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3); }
		
		else { worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(STAGE_1_2, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3); }
	}

	/* 同時破壊とドロップの指定 1.16.5に合わせる */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);

		if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
			worldIn.playEvent(playerIn, 2001, blockpos, Block.getStateId(blockstate));

			ItemStack itemstack = playerIn.getHeldItemMainhand();
			if (!worldIn.isRemote && !playerIn.isCreative() && playerIn.canHarvestBlock(blockstate)) {
				Block.spawnDrops(state, worldIn, pos, (TileEntity)null, playerIn, itemstack);
				Block.spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, playerIn, itemstack);
			}
		}
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || facingState.getBlock() == this && facingState.get(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : state;
		}
		else {
			return Blocks.AIR.getDefaultState();
		}
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, STAGE_1_2, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.get(HALF);
		int i = state.get(STAGE_1_2);
		
		switch (half) {
		case LOWER :
		default :

			switch (i) {
			case 1 :
			default : return AABB_BOT;
			case 2 : return AABB_BOT2;
			}

		case UPPER :

			switch (i) {
			case 1 :
			default : return AABB_TOP;
			case 2 : return AABB_TOP2;
			}
		} // switch LOWER-UPPER
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
		tooltip.add((new TranslationTextComponent("tips.block_kanyou")).applyTextStyle(TextFormatting.GRAY));
	}

}
