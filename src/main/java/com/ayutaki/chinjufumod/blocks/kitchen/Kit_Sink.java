package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
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

public class Kit_Sink extends Block implements IWaterLoggable, IBucketPickupHandler, ILiquidContainer {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape TOP_SOUTH = VoxelShapes.or(Block.makeCuboidShape(3.5D, 0.0D, 2.5D, 5.5D, 1.0D, 4.5D), 
			Block.makeCuboidShape(10.5D, 0.0D, 2.5D, 12.5D, 1.0D, 4.5D));
	protected static final VoxelShape TOP_WEST = VoxelShapes.or(Block.makeCuboidShape(11.5D, 0.0D, 3.5D, 13.5D, 1.0D, 5.5D), 
			Block.makeCuboidShape(11.5D, 0.0D, 10.5D, 13.5D, 1.0D, 12.5D));
	protected static final VoxelShape TOP_NORTH = VoxelShapes.or(Block.makeCuboidShape(3.5D, 0.0D, 11.5D, 5.5D, 1.0D, 13.5D), 
			Block.makeCuboidShape(10.5D, 0.0D, 11.5D, 12.5D, 1.0D, 13.5D));
	protected static final VoxelShape TOP_EAST = VoxelShapes.or(Block.makeCuboidShape(2.5D, 0.0D, 3.5D, 4.5D, 1.0D, 5.5D), 
			Block.makeCuboidShape(2.5D, 0.0D, 10.5D, 4.5D, 1.0D, 12.5D));

	protected static final VoxelShape BASE = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	protected static final VoxelShape BOT_SOUTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_WEST = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape BOT_NORTH = VoxelShapes.or(BASE, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape BOT_EAST = VoxelShapes.or(BASE, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Sink(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(LIT, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		
		switch (half) {
		case LOWER :
		default :
			
			switch (direction) {
			case NORTH :
			default : return BOT_NORTH;
			case SOUTH : return BOT_SOUTH;
			case EAST : return BOT_EAST;
			case WEST : return BOT_WEST;
			} // switch

		case UPPER :
			
			switch (direction) {
			case NORTH :
			default : return TOP_NORTH;
			case SOUTH : return TOP_SOUTH;
			case EAST : return TOP_EAST;
			case WEST : return TOP_WEST;
			} // switch
		} // switch LOWER-UPPER
	}

	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
					.with(LIT, Boolean.valueOf(false)).with(HALF, DoubleBlockHalf.LOWER);
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER).with(H_FACING, state.get(H_FACING))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3);
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

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (!hasWater2(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1); }
		if (!hasWater3(worldIn, pos)) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1); }

		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() == this && facingState.get(HALF) != half ? state.with(H_FACING, facingState.get(H_FACING))
					.with(LIT, facingState.get(LIT)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		boolean lit = state.get(LIT);

		BlockState downstate2 = worldIn.getBlockState(pos.down(2));
		Block downblock2 = downstate2.getBlock();
		BlockState downstate3 = worldIn.getBlockState(pos.down(3));
		Block downblock3 = downstate3.getBlock();

		if (lit != true) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				if (state.get(HALF) == DoubleBlockHalf.LOWER) {
					if (downblock2 == Blocks.WATER && state.get(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }
					
					if (downblock2 != Blocks.WATER || state.get(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (state.get(HALF) == DoubleBlockHalf.UPPER) {
					if (downblock3 == Blocks.WATER && state.get(WATERLOGGED) != true) {
						worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
						worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(true))); }
					
					if (downblock3 != Blocks.WATER || state.get(WATERLOGGED) == true) {
						CMEvents.soundTouchBlock(worldIn, pos); } }
			}
			
			/** Hand is not empty. **/
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS;
		}
		

		if (lit == true) {
			/*水を止める*/
			if (itemstack.isEmpty()) {
				worldIn.playSound(null, pos, SoundEvents_CM.WATER_STOP, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false)));
				return ActionResultType.SUCCESS; }

			if (!itemstack.isEmpty()) {
				/*水を汲む */
				if (item == Items.GLASS_BOTTLE) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundBottleFill(worldIn, pos);
					
					ItemStack itemstack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
					if (itemstack.isEmpty()) { playerIn.setHeldItem(hand, itemstack4); }
					else if (!playerIn.inventory.addItemStackToInventory(itemstack4)) {
						playerIn.dropItem(itemstack4, false); }
					
					return ActionResultType.SUCCESS; }
	
				/* TTimeItems シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.MIZUOKE) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundBucketFill(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KETTLE_kara) {
					CMEvents.Consume_1Item(playerIn, hand);		
					CMEvents.soundBucketFill(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.KETTLE_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.ZUNDOU) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundBucketFill(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOU_MIZU)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOU_MIZU))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.ZUNDOU_MIZU), false); }
					
					return ActionResultType.SUCCESS; }
	
				if (item == Items_Teatime.KEIRYO_CUP) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundBottleFill(worldIn, pos);
					
					if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_full))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_full), false); }
					
					return ActionResultType.SUCCESS; }
	
				/* シンク台は真水のため土鍋は除外 */
				if (item == Items_Teatime.NABE_kara) {
					CMEvents.textNotHave(worldIn, pos, playerIn);
					return ActionResultType.SUCCESS; }
			}
		}

		/* Items.BUCKET で水を汲むため、上記以外は PASS */
		return ActionResultType.PASS;
	}

	/* Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	@Override
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		boolean lit = state.get(LIT);
		boolean water = state.get(BlockStateProperties.WATERLOGGED);

		if (lit == true && water == true) { return Fluids.WATER; }
		if (lit == true && water != true) { return Fluids.WATER; }
		if (lit != true && water == true) {
			worldIn.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		else { return Fluids.EMPTY; }
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	private static boolean hasWater2(IBlockReader worldIn, BlockPos pos) {
		BlockState downstate2 = worldIn.getBlockState(pos.down(2));
		Block downblock2 = downstate2.getBlock();
		return (downblock2 == Blocks.WATER);
	}

	private static boolean hasWater3(IBlockReader worldIn, BlockPos pos) {
		BlockState downstate3 = worldIn.getBlockState(pos.down(3));
		Block downblock3 = downstate3.getBlock();
		return (downblock3 == Blocks.WATER);
	}

	/* TickRandom and Conditions for TickRandom. */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 1)) { worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false))); }

		if (state.get(LIT) == true && !hasWater2(worldIn, pos) && !hasWater3(worldIn, pos)) {
			worldIn.setBlockState(pos, state.with(LIT, Boolean.valueOf(false)));
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 1);
		}
		else { }
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

	public PushReaction getPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		return MathHelper.getCoordinateRandom(pos.getX(), pos.down(state.get(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HALF, H_FACING, LIT, WATERLOGGED);
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
		tooltip.add((new TranslationTextComponent("tips.block_kit_sink")).applyTextStyle(TextFormatting.GRAY));
	}

}
