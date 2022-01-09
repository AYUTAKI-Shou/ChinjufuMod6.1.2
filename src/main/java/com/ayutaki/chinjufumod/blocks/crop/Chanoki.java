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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
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

public class Chanoki extends Block implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_0_4 = IntegerProperty.create("stage", 0, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BASE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 0.1D, 14.0D);
	
	protected static final VoxelShape AABB_0 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 12.0D, 9.0D));
	protected static final VoxelShape AABB_1 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(2.0D, 4.0D, 2.0D, 14.0D, 14.0D, 14.0D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_2 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(1.0D, 4.0D, 1.0D, 15.0D, 15.0D, 15.0D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 4.0D, 9.0D));
	protected static final VoxelShape AABB_3 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(0.5D, 3.5D, 0.5D, 15.5D, 15.5D, 15.5D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));
	protected static final VoxelShape AABB_4 = VoxelShapes.or(AABB_BASE, Block.makeCuboidShape(0.0D, 3.5D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(7.0D, 0.1D, 7.0D, 9.0D, 3.5D, 9.0D));

	public Chanoki(Block.Properties properties) {
		super(properties);

		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_4, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
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

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }
		
		return facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
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

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_4);

		/** Too early to collect **/
		if (i != 4) {
			
			if (item == Items.BONE_MEAL) {
				CMEvents.Consume_1Item(playerIn, hand);
	
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
				
				if (i < 3) { worldIn.setBlockState(pos, state.with(STAGE_0_4, Integer.valueOf(i + 2)), 3); }
				if (i == 3) { worldIn.setBlockState(pos, state.with(STAGE_0_4, Integer.valueOf(i + 1)), 3); }
			}
			
			if (item != Items.BONE_MEAL) {
				if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (itemstack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }	
			}
		}
		
		/** Can harvest **/
		if (i == 4) {
			if (itemstack.isEmpty()) {
				CMEvents.soundTake_Pick(worldIn, pos);
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.CHABA, 4));
	
				worldIn.setBlockState(pos, state.with(STAGE_0_4, Integer.valueOf(i - 1)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* 時間経過 成長段階が少ないため rand.nextInt(12) == 0 */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_0_4);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 4 && worldIn.getLightSubtracted(pos, 0) >= 9 && !state.get(WATERLOGGED) && rand.nextInt(12) == 0) {
			worldIn.setBlockState(pos, state.with(STAGE_0_4, Integer.valueOf(i + 1)), 2); }

		else { }
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.get(STAGE_0_4);
		switch (i) {
		case 0 :
		default :
			return AABB_0;
		case 1 :
			return AABB_1;
		case 2 :
			return AABB_2;
		case 3 :
			return AABB_3;
		case 4 :
			return AABB_4;
		} // switch
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.CHANOKI);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_4, WATERLOGGED);
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
		tooltip.add((new TranslationTextComponent("tips.block_wood_chanoki_nae")).applyTextStyle(TextFormatting.GRAY));
	}

}
