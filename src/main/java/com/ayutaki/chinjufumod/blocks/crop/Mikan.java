package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

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
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
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
	protected static final VoxelShape AABB_BASE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 0.1D, 14.0D);
	
	protected static final VoxelShape BOT_0 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(7.5D, 0.1D, 7.5D, 8.5D, 12.0D, 8.5D));
	protected static final VoxelShape BOT_1 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(3.0D, 8.0D, 3.0D, 13.0D, 16.0D, 13.0D),
			Block.makeCuboidShape(7.25D, 0.1D, 7.25D, 8.75D, 8.0D, 8.75D));
	protected static final VoxelShape BOT_2 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(2.0D, 9.0D, 2.0D, 14.0D, 20.0D, 14.0D),
			Block.makeCuboidShape(7.25D, 0.1D, 7.25D, 8.75D, 9.0D, 8.75D));
	protected static final VoxelShape BOT_3 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(2.0D, 12.0D, 2.0D, 14.0D, 24.0D, 14.0D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 12.0D, 9.0D));
	protected static final VoxelShape BOT_4 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(1.0D, 14.0D, 1.0D, 15.0D, 28.0D, 15.0D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 14.0D, 9.0D));

	protected static final VoxelShape BOT_5 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 16.0D, 9.0D));
	protected static final VoxelShape TOP_5 = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public Mikan(Block.Properties properties) {
		super(properties);

		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_11, Integer.valueOf(0))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3);
	}

	/* 設置制限 */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		Block block = state.getBlock();
		return block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.down();
		return this.isValidGround(worldIn.getBlockState(downpos), worldIn, downpos);
	}

	/* blockstate の更新 */
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}

		DoubleBlockHalf doubleblockhalf = stateIn.get(HALF);
		if (facing.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (facing == Direction.UP) ||
				 facingState.getBlock() == this && facingState.get(HALF) != doubleblockhalf) {
			return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !stateIn.isValidPosition(worldIn, pos) ?
					 Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, pos, facingPos);
		}

		else {
			return Blocks.AIR.getDefaultState();
		}
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
		}

		/** それ以外の時 **/
		else { return null; }
	}

	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		return false;
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_11);

		BlockState upstate = worldIn.getBlockState(pos.up());
		BlockState downstate = worldIn.getBlockState(pos.down());
		
		/** Too early to collect **/
		if (i < 9 && state.get(HALF) == DoubleBlockHalf.LOWER) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }

				if (i < 8) {
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(i + 2)), 3);
					worldIn.setBlockState(pos.up(), upstate.with(STAGE_0_11, Integer.valueOf(i + 2)), 3); }

				if (i == 8) {
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(9)), 3);
					worldIn.setBlockState(pos.up(), upstate.with(STAGE_0_11, Integer.valueOf(9)), 3); }
			}
			
			if (item != Items.BONE_MEAL) {
				if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (itemstack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 9 && state.get(HALF) == DoubleBlockHalf.UPPER) {
			
			if (itemstack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_MIKAN, 4));

				worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(i + 1)), 3);
				worldIn.setBlockState(pos.down(), downstate.with(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** Sleeping **/
		if (i > 9) { CMEvents.textIsSleeping(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* 時間経過 小麦の最遅並みで rand.nextInt(8) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		/** Property 0 1 2 3 4、5 6 7 8 (9) 10 11 **/
		int i = state.get(STAGE_0_11);
		BlockState upstate = worldIn.getBlockState(pos.up());
		BlockState downstate = worldIn.getBlockState(pos.down());
		DoubleBlockHalf half = state.get(HALF);
		
		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		switch (half) {
		case LOWER :
		default :
			if (!state.get(WATERLOGGED) && !upstate.get(WATERLOGGED)) {
				if (i < 9 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlockState(pos.up(), upstate.with(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 9) { }
		
				if (i == 10 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(i + 1)), 3);
					worldIn.setBlockState(pos.up(), upstate.with(STAGE_0_11, Integer.valueOf(i + 1)), 3); }
		
				if (i == 11 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(8) == 0) {
		
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(6)), 3);
					worldIn.setBlockState(pos.up(), upstate.with(STAGE_0_11, Integer.valueOf(6)), 3); } }
			
			if (state.get(WATERLOGGED) || upstate.get(WATERLOGGED)) { }
			break;

		case UPPER :
			if (state.get(WATERLOGGED)) {
				if (i == 6 && rand.nextInt(2) == 0) {
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(10)), 3);
					worldIn.setBlockState(pos.down(), downstate.with(STAGE_0_11, Integer.valueOf(10)), 3); }
				
				if (i >= 7 && i <= 9 && rand.nextInt(2) == 0) {
					CMEvents.soundSnowBreak(worldIn, pos);
					worldIn.setBlockState(pos, state.with(STAGE_0_11, Integer.valueOf(10)), 3);
					worldIn.setBlockState(pos.down(), downstate.with(STAGE_0_11, Integer.valueOf(10)), 3);
					this.dropRottenfood(worldIn, pos); } }
			
			if (!state.get(WATERLOGGED)) { }
			break;
		} // switch LOWER-UPPER
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		DoubleBlockHalf half = state.get(HALF);
		int i = state.get(STAGE_0_11);

		switch(half) {
		default:
		case LOWER:
			return (i == 0)? BOT_0 : ((i == 1)? BOT_1 : ((i == 2)? BOT_2 : ((i == 3)? BOT_3 : ((i == 4)? BOT_4 : BOT_5))));
		case UPPER:
			return (i < 5)? VoxelShapes.empty() : TOP_5;
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIKAN);
	}

		/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_11, HALF, WATERLOGGED);
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

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.up());
		BlockState downstate = worldIn.getBlockState(pos.down());

		if (downstate.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.down(), true); }
		if (upstate.getBlock() == this && !playerIn.isCreative()) { worldIn.destroyBlock(pos.up(), false); }
		if (playerIn.isCreative()) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 35); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	@Override
	public void harvestBlock(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.harvestBlock(worldIn, playerIn, pos, Blocks.AIR.getDefaultState(), te, stack);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_wood_mikan")).applyTextStyle(TextFormatting.GRAY));
	}

}
