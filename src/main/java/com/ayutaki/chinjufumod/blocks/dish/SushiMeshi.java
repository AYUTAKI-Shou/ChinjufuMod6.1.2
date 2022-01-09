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

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
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
import net.minecraft.world.IWorldReader;
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
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.5D, 15.0D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(1.0D, -8.0D, 1.0D, 15.0D, 0.1D, 15.0D);

	public SushiMeshi(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState()
				.with(STAGE_0_15, Integer.valueOf(0))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_15);

		if (item == Items_Teatime.KIRIMI_S) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_S))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SUSHI_S), false); }

			if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 1))); }

			if (i == 15) {
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().with(Pizza.DOWN, state.get(DOWN))
						.with(Pizza.STAGE_1_6, Integer.valueOf(6))); }
		}

		if (item == Items_Teatime.KIRIMI_F) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_F))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SUSHI_F), false); }

			if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 1))); }

			if (i == 15) {
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().with(Pizza.DOWN, state.get(DOWN))
						.with(Pizza.STAGE_1_6, Integer.valueOf(6))); }
		}

		if (item == Items_Teatime.KIRIMI_B) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_B))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SUSHI_B), false); }

			if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 1))); }

			if (i == 15) {
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().with(Pizza.DOWN, state.get(DOWN))
						.with(Pizza.STAGE_1_6, Integer.valueOf(6))); }
		}

		if (item == Items_Teatime.KIRIMI_T) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);
			
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SUSHI_T))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SUSHI_T), false); }

			if (i != 15) { worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(i + 1))); }

			if (i == 15) {
				worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().with(Pizza.DOWN, state.get(DOWN))
						.with(Pizza.STAGE_1_6, Integer.valueOf(6))); }
		}
		
		if (item != Items_Teatime.KIRIMI_S && item != Items_Teatime.KIRIMI_F && 
				item != Items_Teatime.KIRIMI_B && item != Items_Teatime.KIRIMI_T) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN));
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlabWater_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.offset(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlabWater_CM && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.get(SlabBlock.TYPE) == SlabType.BOTTOM && state.get(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.get(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.get(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.get(Kotatsu.WATERLOGGED)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.get(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn)); }

		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DOWN, STAGE_0_15, WATERLOGGED);
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

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.get(STAGE_0_15);
		return (i == 0)? new ItemStack(Items_Teatime.SUSHIMESHI) : new ItemStack(Items.BOWL);
	}

	/* TickRandom */
	@Override
	public int tickRate(IWorldReader world) {
		return 60;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.PIZZA.getDefaultState().with(Pizza.DOWN, state.get(DOWN))
					.with(Pizza.STAGE_1_6, Integer.valueOf(6))
					.with(Pizza.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }
		
		else { }
	}

	protected void dropRottenfood(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_food_sushimeshi")).applyTextStyle(TextFormatting.GRAY));
	}

}
