package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Mikan extends Block implements IWaterLoggable {

	/* Property 0 1 2 3 4、5 6 7 8 (9) 10 11 */
	public static final IntegerProperty STAGE_0_11 = IntegerProperty.create("stage", 0, 11);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BASE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 0.1D, 14.0D);
	
	protected static final VoxelShape BOT_0 = VoxelShapes.or(AABB_BASE, Block.box(7.5D, 0.1D, 7.5D, 8.5D, 12.0D, 8.5D));
	protected static final VoxelShape BOT_1 = VoxelShapes.or(AABB_BASE, Block.box(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.box(7.25D, 0.1D, 7.25D, 8.75D, 8.0D, 8.75D));
	protected static final VoxelShape BOT_2 = VoxelShapes.or(AABB_BASE, Block.box(2.0D, 9.0D, 2.0D, 14.0D, 20.0D, 14.0D),
			Block.box(7.25D, 0.1D, 7.25D, 8.75D, 9.0D, 8.75D));
	protected static final VoxelShape BOT_3 = VoxelShapes.or(AABB_BASE, Block.box(2.0D, 12.0D, 2.0D, 14.0D, 24.0D, 14.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 12.0D, 9.0D));
	protected static final VoxelShape BOT_4 = VoxelShapes.or(AABB_BASE, Block.box(1.0D, 14.0D, 1.0D, 15.0D, 28.0D, 15.0D),
			Block.box(7.0D, 0.1D, 7.0D, 9.0D, 14.0D, 9.0D));

	protected static final VoxelShape BOT_5 = VoxelShapes.or(AABB_BASE, Block.box(7.0D, 0.1D, 7.0D, 9.0D, 16.0D, 9.0D));
	protected static final VoxelShape TOP_5 = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Mikan(AbstractBlock.Properties properties) {
		super(properties);

		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_11, Integer.valueOf(0))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState fluidUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(WATERLOGGED, Boolean.valueOf(fluidUp.getType() == Fluids.WATER)), 3);
	}

	/* Limit the place. */
	protected boolean mayPlaceOn(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL;
	}

	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.below();
		return this.mayPlaceOn(worldIn.getBlockState(downpos), worldIn, downpos);
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
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		DoubleBlockHalf doubleblockhalf = stateIn.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) ||
				 facingState.getBlock() == this && facingState.getValue(HALF) != doubleblockhalf) {
			return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.canSurvive(worldIn, pos) ?
					 Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, worldIn, pos, facingPos); }

		else { return Blocks.AIR.defaultBlockState(); }
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();

		/** pos.up() = Replaceable block. **/
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

		else { return null; }
	}

	public boolean canBeReplaced(BlockState state, BlockItemUseContext context) {
		return false;
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_11);

		BlockState upstate = worldIn.getBlockState(pos.above());
		BlockState downstate = worldIn.getBlockState(pos.below());
		/** Property 0 1 2 3 4、5 6 7 8 (9) 10 11 **/
		
		/** Too early to collect **/
		if (i < 9 && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.random.nextGaussian() * 0.02D;
					double d1 = worldIn.random.nextGaussian() * 0.02D;
					double d2 = worldIn.random.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.random.nextFloat(), pos.getY() +worldIn.random.nextFloat(), pos.getZ() + worldIn.random.nextFloat(), d0, d1, d2); }
				
				if (i < 8) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(i + 2)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_0_11, Integer.valueOf(i + 2)), 3); }
				
				if (i == 8) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(9)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_0_11, Integer.valueOf(9)), 3); }
			}
			
			if (item != Items.BONE_MEAL) {
				if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (itemstack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
	
		/** Can harvest **/
		if (i == 9 && state.getValue(HALF) == DoubleBlockHalf.UPPER) {
			if (itemstack.isEmpty()) {

				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.add(new ItemStack(Items_Teatime.FOOD_MIKAN, 4));
	
				worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3);
				worldIn.setBlock(pos.below(), downstate.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** Sleeping **/
		if (i > 9) { CMEvents.textIsSleeping(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom 小麦の最遅並みで rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/** Property 0 1 2 3 4、5 6 7 8 (9) 10 11 **/
		int i = state.getValue(STAGE_0_11);
		BlockState upstate = worldIn.getBlockState(pos.above());
		BlockState downstate = worldIn.getBlockState(pos.below());
		DoubleBlockHalf half = state.getValue(HALF);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER :
		default :
			if (!state.getValue(WATERLOGGED) && !upstate.getValue(WATERLOGGED)) {
				
				if (i < 9 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 9) { }
		
				if (i == 10 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 11 && worldIn.getRawBrightness(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(6)), 3);
					worldIn.setBlock(pos.above(), upstate.setValue(STAGE_0_11, Integer.valueOf(6)), 3); }
			}//It is not Waterlogged.
			
			if (state.getValue(WATERLOGGED) || upstate.getValue(WATERLOGGED)) { }
			break;

		case UPPER :
			if (state.getValue(WATERLOGGED)) {
				if (i == 6 && rand.nextInt(2) == 0) {
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(10)), 3);
					worldIn.setBlock(pos.below(), downstate.setValue(STAGE_0_11, Integer.valueOf(10)), 3); }
				
				if (i >= 7 && i <= 9 && rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_11, Integer.valueOf(10)), 3);
					worldIn.setBlock(pos.below(), downstate.setValue(STAGE_0_11, Integer.valueOf(10)), 3);
					this.dropRottenfood(worldIn, pos); }
			}//It is Waterlogged.
			
			if (!state.getValue(WATERLOGGED)) { }
			break;
		} // switch
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.getValue(HALF);
		int i = state.getValue(STAGE_0_11);

		switch (half) {
		default:
		case LOWER:
			return (i == 0)? BOT_0 : ((i == 1)? BOT_1 : ((i == 2)? BOT_2 : ((i == 3)? BOT_3 : ((i == 4)? BOT_4 : BOT_5))));
		case UPPER:
			return (i < 5)? VoxelShapes.empty() : TOP_5;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIKAN);
	}

		/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_11, HALF, WATERLOGGED);
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { breakLowerPart(worldIn, pos, state, playerIn); }
			else { dropResources(state, worldIn, pos, (TileEntity)null, playerIn, playerIn.getMainHandItem()); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void breakLowerPart(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downpos = pos.below();
			BlockState downstate = worldIn.getBlockState(downpos);

			if (downstate.getBlock() == state.getBlock() && downstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downpos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downpos, Block.getId(downstate));
			}
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_wood_mikan")).withStyle(TextFormatting.GRAY));
	}

}
