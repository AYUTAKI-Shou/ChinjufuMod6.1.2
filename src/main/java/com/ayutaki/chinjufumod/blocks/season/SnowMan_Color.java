package com.ayutaki.chinjufumod.blocks.season;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furnace.AbstractOvenBlock;
import com.ayutaki.chinjufumod.blocks.furnace.AbstractStoveBlock;
import com.ayutaki.chinjufumod.blocks.furnace.Irori;
import com.ayutaki.chinjufumod.blocks.kitchen.Kit_Cooktop;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
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
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SnowMan_Color extends Block implements IWaterLoggable {

	/* Property */
	/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
	/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_16 = IntegerProperty.create("stage", 1, 16);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_BOT = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape AABB_TOP = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);

	public SnowMan_Color(Block.Properties properties) {
		super(properties);
		
		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(STAGE_1_16, Integer.valueOf(1))
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, false));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		
		int i = state.get(STAGE_1_16);
		DoubleBlockHalf half = state.get(HALF);
		BlockState upstate = worldIn.getBlockState(pos.up());
		
		boolean mode = playerIn.abilities.isCreativeMode;
		
		switch (half) {
		case LOWER :
		default :
			if (!state.get(DOWN)) {
				if (item == Items.SNOW) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos.up(), upstate.with(DOWN, Boolean.valueOf(true)), 3);
					worldIn.setBlockState(pos, state.with(DOWN, Boolean.valueOf(true)), 3); }
				
				if (item != Items.SNOW) { CMEvents.textNotHave(worldIn, pos, playerIn); } }

			if (state.get(DOWN)) { }
			break;

		/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
		/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
		case UPPER :
			if (itemstack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.H_FACING, state.get(H_FACING))
						.with(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.with(SnowMan.DOWN, state.get(DOWN))
						.with(SnowMan.WATERLOGGED, state.get(WATERLOGGED))
						.with(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN.getDefaultState()
						.with(SnowMan.H_FACING, state.get(H_FACING))
						.with(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.with(SnowMan.DOWN, state.get(DOWN))
						.with(SnowMan.WATERLOGGED, state.get(WATERLOGGED))
						.with(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
	
				if (mode) { } 
				if (!mode) {
					switch (i) {
					case 1 :
					default :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WHITE_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WHITE_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.WHITE_WOOL), false); }
						break;
		
					case 2 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.ORANGE_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.ORANGE_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.ORANGE_WOOL), false); }
						break;
						
					case 3 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.MAGENTA_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.MAGENTA_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.MAGENTA_WOOL), false); }
						break;
						
					case 4 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIGHT_BLUE_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIGHT_BLUE_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.LIGHT_BLUE_WOOL), false); }
						break;
		
					case 5 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.YELLOW_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.YELLOW_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.YELLOW_WOOL), false); }
						break;
						
					case 6 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIME_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIME_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.LIME_WOOL), false); }
						break;
						
					case 7 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.PINK_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.PINK_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.PINK_WOOL), false); }
						break;
		
					case 8 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GRAY_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GRAY_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.GRAY_WOOL), false); }
						break;
						
					case 9 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIGHT_GRAY_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.LIGHT_GRAY_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.LIGHT_GRAY_WOOL), false); }
						break;
						
					case 10 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.CYAN_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.CYAN_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.CYAN_WOOL), false); }
						break;
						
					case 11 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.PURPLE_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.PURPLE_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.PURPLE_WOOL), false); }
						break;
		
					case 12 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BLUE_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BLUE_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.BLUE_WOOL), false); }
						break;
						
					case 13 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BROWN_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BROWN_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.BROWN_WOOL), false); }
						break;
		
					case 14 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GREEN_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GREEN_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.GREEN_WOOL), false); }
						break;
		
					case 15 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.RED_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.RED_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.RED_WOOL), false); }
						break;
						
					case 16 :
						if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BLACK_WOOL)); }
						else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BLACK_WOOL))) {
							playerIn.dropItem(new ItemStack(Items.BLACK_WOOL), false); }
						break;
					} // switch STAGE_0_16
				} //!mode
			} //itemstack.isEmpty()
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // switch LOWER-UPPER
		
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.down();
		BlockState downstate = worldIn.getBlockState(downpos);

		/** Lower part is true. **/
		if (state.get(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downstate.getBlock() instanceof SnowMan || downstate.getBlock() instanceof SnowMan_Color; }
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
	
	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Update BlockState. */
	protected boolean inWater(BlockState state, IWorld worldIn, BlockPos pos) {
		return state.get(WATERLOGGED);
	}
	
	private boolean hasHeat(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos nearpos : BlockPos.getAllInBoxMutable(pos.add(-2, -1, -2), pos.add(2, 1, 2))) {
			BlockState nearstate = worldIn.getBlockState(nearpos);
			Block nearblock = nearstate.getBlock();

			if (nearblock == Blocks.LAVA || nearblock == Blocks.MAGMA_BLOCK ||
					nearblock instanceof FireBlock ||
					(nearblock instanceof CampfireBlock && nearstate.get(CampfireBlock.LIT)) ||
					(nearblock instanceof AbstractFurnaceBlock && nearstate.get(AbstractFurnaceBlock.LIT)) ||
					(nearblock instanceof AbstractOvenBlock && nearstate.get(AbstractOvenBlock.LIT)) ||
					(nearblock instanceof AbstractStoveBlock && nearstate.get(AbstractStoveBlock.LIT)) ||
					(nearblock instanceof Irori && nearstate.get(Irori.LIT)) ||
					(nearblock instanceof Kit_Cooktop && nearstate.get(Kit_Cooktop.STAGE_1_3) == 2) ) {
				return true; }
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		if (inWater(state, worldIn, pos) || hasHeat(worldIn, pos) || worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200); }
		
		DoubleBlockHalf half = state.get(HALF);
		if (facing.getAxis() == Direction.Axis.Y && half == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
			return facingState.getBlock() instanceof SnowMan || facingState.getBlock() instanceof SnowMan_Color &&
					facingState.get(HALF) != half ? state.with(H_FACING, facingState.get(H_FACING)) : Blocks.AIR.getDefaultState();
		}
		else {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR
					.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
		}
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		DoubleBlockHalf half = state.get(HALF);
		Block downblock = worldIn.getBlockState(pos.down()).getBlock();
		
		switch (half) {
		case LOWER :
		default :
			if (inWater(state, worldIn, pos)) { 
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
				worldIn.destroyBlock(pos, true); }
			
			if (!inWater(state, worldIn, pos)) {
				if (downblock == Blocks.ICE || downblock == Blocks.PACKED_ICE ||
						downblock == Blocks.BLUE_ICE || downblock == Blocks.SNOW_BLOCK) { }
				
				if (downblock != Blocks.ICE && downblock != Blocks.PACKED_ICE &&
						downblock != Blocks.BLUE_ICE && downblock != Blocks.SNOW_BLOCK) {
					
					if (this.hasHeat(worldIn, pos)) {
						worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
						worldIn.destroyBlock(pos, true); }
					
					if (!this.hasHeat(worldIn, pos)) {
						/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
						if (worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
							worldIn.getPendingBlockTicks().scheduleTick(pos, this, 200);
							worldIn.destroyBlock(pos, true); }
						
						if (worldIn.getBiome(pos).getTemperature(pos) <= 0.85F) { }
					} //!hasHeat
				} //!ICE
			} //!WATERLOGGED
			break;

		case UPPER :
			break;
		} // switch LOWER-UPPER
	}
	

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_16, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return (state.get(HALF) == DoubleBlockHalf.LOWER)? AABB_BOT : AABB_TOP;
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

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.SNOWMAN);
	}
	
}
