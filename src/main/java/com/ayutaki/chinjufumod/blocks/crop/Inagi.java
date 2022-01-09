package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Inagi extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision 1=空、2=生、3=生、4=乾 */
	protected static final VoxelShape BOT_SOUTH = Block.box(2.0D, 7.0D, 7.25D, 14.0D, 16.0D, 8.75D);
	protected static final VoxelShape BOT_WEST = Block.box(7.25D, 7.0D, 2.0D, 8.75D, 16.0D, 14.0D);
	protected static final VoxelShape BOT_NORTH = Block.box(2.0D, 7.0D, 7.25D, 14.0D, 16.0D, 8.75D);
	protected static final VoxelShape BOT_EAST = Block.box(7.25D, 7.0D, 2.0D, 8.75D, 16.0D, 14.0D);

	protected static final VoxelShape TOP_SOUTH = Block.box(2.0D, 0.0D, 7.25D, 14.0D, 5.5D, 8.75D);
	protected static final VoxelShape TOP_WEST = Block.box(7.25D, 0.0D, 2.0D, 8.75D, 5.5D, 14.0D);
	protected static final VoxelShape TOP_NORTH = Block.box(2.0D, 0.0D, 7.25D, 14.0D, 5.5D, 8.75D);
	protected static final VoxelShape TOP_EAST = Block.box(7.25D, 0.0D, 2.0D, 8.75D, 5.5D, 14.0D);

	protected static final VoxelShape S4_SOUTH = Block.box(0.0D, 3.0D, 7.25D, 16.0D, 4.5D, 8.75D);
	protected static final VoxelShape S4_WEST = Block.box(7.25D, 3.0D, 0.0D, 8.75D, 4.5D, 16.0D);
	protected static final VoxelShape S4_NORTH = Block.box(0.0D, 3.0D, 7.25D, 16.0D, 4.5D, 8.75D);
	protected static final VoxelShape S4_EAST = Block.box(7.25D, 3.0D, 0.0D, 8.75D, 4.5D, 16.0D);

	public Inagi(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();

		/** pos.up() = Replaceable block. **/
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
					.setValue(STAGE_1_4, Integer.valueOf(1)).setValue(HALF, DoubleBlockHalf.LOWER);
		}

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(H_FACING, state.getValue(H_FACING))
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_4);
	
		BlockState upstate = worldIn.getBlockState(pos.above());
		BlockState downstate = worldIn.getBlockState(pos.below());
		/* Collision 1=空、2=生、3=生、4=乾 */
		
		int gc = itemstack.getCount();

		if (!state.getValue(WATERLOGGED)) { 
			/** Set rice plant **/
			if (i == 1) {
				if (item == Items_Teatime.INE && gc >= 8) {
					/* Consume 8 Items. */
					CMEvents.Consume_8Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					
					if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlock(pos.below(), downstate.setValue(STAGE_1_4, Integer.valueOf(2)), 3); } }
				
				if (item == Items_Teatime.INE && gc < 8) { CMEvents.textNotEnough_Items(worldIn, pos, playerIn); }
				
				if (item != Items_Teatime.INE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
			
			/** Too early to collect **/
			if (i == 2 || i == 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			
			/** Can harvest **/
			if (i == 4) {
				if (itemstack.isEmpty() && item != Items_Teatime.INE) {
					
					CMEvents.soundTake_Pick(worldIn, pos);
					playerIn.inventory.add(new ItemStack(Items_Teatime.INE_D, 8));
		
					/** Get EXP. **/
					worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), 2));
		
					if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(pos.below(), downstate.setValue(STAGE_1_4, Integer.valueOf(1)), 3); }
		
					if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
						worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(pos.above(), upstate.setValue(STAGE_1_4, Integer.valueOf(1)), 3); } }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			}
		}
		
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Limit the place. */
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true;
	}

	@SuppressWarnings("deprecation")
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
			BlockPos blockpos = pos.below();
			return this.mayPlaceOn(worldIn.getBlockState(blockpos), worldIn, blockpos);
		}

		else {
			BlockState blockstate = worldIn.getBlockState(pos.below());
			if (state.getBlock() != this) return super.canSurvive(state, worldIn, pos);
			return blockstate.getBlock() == this && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
		}
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

		BlockState blockstate = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return (facingState.getBlock() == Crop_Blocks.INAGI) &&
					facingState.getValue(HALF) != half ? state.setValue(H_FACING, facingState.getValue(H_FACING)).setValue(STAGE_1_4, facingState.getValue(STAGE_1_4)) : Blocks.AIR.defaultBlockState(); }

		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR
					.defaultBlockState() : super.updateShape(state, facing, facingState, worldIn, pos, facingPos); }
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

	/* Only for INAGI. */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.above());
		BlockState downstate = worldIn.getBlockState(pos.below());
		int i = state.getValue(STAGE_1_4);

		if (downstate.getBlock() == this && !playerIn.isCreative()) {
			worldIn.destroyBlock(pos.below(), false);
			if (i == 4) { worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), 2)); }
		}

		if (upstate.getBlock() == this && !playerIn.isCreative()) {
			worldIn.destroyBlock(pos.above(), false);
			if (i == 4) { worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY(), pos.getZ(), 2)); }
		}

		if (playerIn.isCreative()) { worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 35); }
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_4);
		BlockState upstate = worldIn.getBlockState(pos.above());
		BlockState downstate = worldIn.getBlockState(pos.below());
		DoubleBlockHalf half = state.getValue(HALF);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER :
		default :
			if (state.getValue(WATERLOGGED) && rand.nextInt(4) == 0) {
				
				if (i == 1) { }
	
				if (i != 1) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					this.dropRottenfood(worldIn, pos); } }
			
			if (!state.getValue(WATERLOGGED)) { }
			break;

		case UPPER :
			if (!state.getValue(WATERLOGGED) && !worldIn.isRainingAt(pos.above()) && rand.nextInt(4) == 0) {
				
				if (i == 1 || i == 4) { }
	
				if (i != 1 && i != 4) {
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.below(), downstate.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
	
			/** WATERLOGGED **/
			if (state.getValue(WATERLOGGED) && rand.nextInt(4) == 0) {
	
				if (i == 1) { }
	
				if (i != 1) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					worldIn.setBlock(pos.below(), downstate.setValue(STAGE_1_4, Integer.valueOf(1)), 3);
					this.dropRottenfood(worldIn, pos); } }
			break;
		} // switch
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.INAGI);
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		Direction direction = state.getValue(H_FACING);
		int i = state.getValue(STAGE_1_4);

		switch (direction) {
		case NORTH:
		default:
			return (state.getValue(HALF) != DoubleBlockHalf.UPPER && i == 1)? VoxelShapes.empty() :
							((state.getValue(HALF) != DoubleBlockHalf.UPPER && i != 1)? BOT_NORTH :
							((state.getValue(HALF) == DoubleBlockHalf.UPPER && i == 1)? S4_NORTH : TOP_NORTH));
		case SOUTH:
			return (state.getValue(HALF) != DoubleBlockHalf.UPPER && i == 1)? VoxelShapes.empty() :
							((state.getValue(HALF) != DoubleBlockHalf.UPPER && i != 1)? BOT_SOUTH :
							((state.getValue(HALF) == DoubleBlockHalf.UPPER && i == 1)? S4_SOUTH : TOP_SOUTH));
		case WEST:
			return (state.getValue(HALF) != DoubleBlockHalf.UPPER && i == 1)? VoxelShapes.empty() :
							((state.getValue(HALF) != DoubleBlockHalf.UPPER && i != 1)? BOT_WEST :
							((state.getValue(HALF) == DoubleBlockHalf.UPPER && i == 1)? S4_WEST : TOP_WEST));
		case EAST:
			return (state.getValue(HALF) != DoubleBlockHalf.UPPER && i == 1)? VoxelShapes.empty() :
							((state.getValue(HALF) != DoubleBlockHalf.UPPER && i != 1)? BOT_EAST :
							((state.getValue(HALF) == DoubleBlockHalf.UPPER && i == 1)? S4_EAST : TOP_EAST));
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_inagi")).withStyle(TextFormatting.GRAY));
	}

}
