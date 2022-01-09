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

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
	protected static final VoxelShape AABB_BOT = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape AABB_TOP = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D);

	public SnowMan_Color(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(STAGE_1_16, Integer.valueOf(1))
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, false));
	}

	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		int i = state.getValue(STAGE_1_16);
		DoubleBlockHalf half = state.getValue(HALF);
		BlockState upstate = worldIn.getBlockState(pos.above());
		
		boolean mode = playerIn.abilities.instabuild;
		
		switch (half) {
		case LOWER :
		default :
			if (!state.getValue(DOWN)) {
				if (item == Items.SNOW) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), upstate.setValue(DOWN, Boolean.valueOf(true)), 3);
					worldIn.setBlock(pos, state.setValue(DOWN, Boolean.valueOf(true)), 3); }
				
				if (item != Items.SNOW) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			if (state.getValue(DOWN)) { }
			break;

		/** White=1, Orange=2, Magenta=3, LightBlue=4, Yellow=5, Lime=6, Pink=7, Gray=8, **/
		/** LightGray=9, Cyan=10, Purple=11, Blue=12, Brown=13, Green=14, Red=15, Black=16 **/
		case UPPER :
			if (itemstack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.H_FACING, state.getValue(H_FACING))
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.DOWN, state.getValue(DOWN))
						.setValue(SnowMan.WATERLOGGED, state.getValue(WATERLOGGED))
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlock(pos.below(), Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.H_FACING, state.getValue(H_FACING))
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.DOWN, state.getValue(DOWN))
						.setValue(SnowMan.WATERLOGGED, state.getValue(WATERLOGGED))
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(2)), 3);
	
				if (mode) { } 
				if (!mode) {
					switch (i) {
					case 1 :
					default :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.WHITE_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.WHITE_WOOL))) {
							playerIn.drop(new ItemStack(Items.WHITE_WOOL), false); }
						break;
		
					case 2 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.ORANGE_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.ORANGE_WOOL))) {
							playerIn.drop(new ItemStack(Items.ORANGE_WOOL), false); }
						break;
						
					case 3 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.MAGENTA_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.MAGENTA_WOOL))) {
							playerIn.drop(new ItemStack(Items.MAGENTA_WOOL), false); }
						break;
						
					case 4 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.LIGHT_BLUE_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.LIGHT_BLUE_WOOL))) {
							playerIn.drop(new ItemStack(Items.LIGHT_BLUE_WOOL), false); }
						break;
		
					case 5 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.YELLOW_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.YELLOW_WOOL))) {
							playerIn.drop(new ItemStack(Items.YELLOW_WOOL), false); }
						break;
						
					case 6 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.LIME_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.LIME_WOOL))) {
							playerIn.drop(new ItemStack(Items.LIME_WOOL), false); }
						break;
						
					case 7 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.PINK_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.PINK_WOOL))) {
							playerIn.drop(new ItemStack(Items.PINK_WOOL), false); }
						break;
		
					case 8 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.GRAY_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.GRAY_WOOL))) {
							playerIn.drop(new ItemStack(Items.GRAY_WOOL), false); }
						break;
						
					case 9 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.LIGHT_GRAY_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.LIGHT_GRAY_WOOL))) {
							playerIn.drop(new ItemStack(Items.LIGHT_GRAY_WOOL), false); }
						break;
						
					case 10 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.CYAN_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.CYAN_WOOL))) {
							playerIn.drop(new ItemStack(Items.CYAN_WOOL), false); }
						break;
						
					case 11 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.PURPLE_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.PURPLE_WOOL))) {
							playerIn.drop(new ItemStack(Items.PURPLE_WOOL), false); }
						break;
		
					case 12 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.BLUE_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.BLUE_WOOL))) {
							playerIn.drop(new ItemStack(Items.BLUE_WOOL), false); }
						break;
						
					case 13 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.BROWN_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.BROWN_WOOL))) {
							playerIn.drop(new ItemStack(Items.BROWN_WOOL), false); }
						break;
		
					case 14 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.GREEN_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.GREEN_WOOL))) {
							playerIn.drop(new ItemStack(Items.GREEN_WOOL), false); }
						break;
		
					case 15 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.RED_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.RED_WOOL))) {
							playerIn.drop(new ItemStack(Items.RED_WOOL), false); }
						break;
						
					case 16 :
						if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.BLACK_WOOL)); }
						else if (!playerIn.inventory.add(new ItemStack(Items.BLACK_WOOL))) {
							playerIn.drop(new ItemStack(Items.BLACK_WOOL), false); }
						break;
					} // switch STAGE_0_16
				} //!mode
			} //itemstack.isEmpty()
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		} // switch LOWER-UPPER
		
		return ActionResultType.SUCCESS;
	}

	/* Limit the place. */
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.below();
		BlockState downstate = worldIn.getBlockState(downpos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downstate.getBlock() instanceof SnowMan || downstate.getBlock() instanceof SnowMan_Color; }
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
			return true;
		}
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
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getValue(WATERLOGGED);
	}
	
	private boolean hasHeat(IWorld worldIn, BlockPos pos) {
		for(BlockPos nearpos : BlockPos.betweenClosed(pos.offset(-2, -1, -2), pos.offset(2, 1, 2))) {
			BlockState nearstate = worldIn.getBlockState(nearpos);
			Block nearblock = nearstate.getBlock();

			if (nearblock == Blocks.LAVA || nearblock == Blocks.MAGMA_BLOCK ||
					nearblock instanceof FireBlock || nearblock instanceof SoulFireBlock || 
					(nearblock instanceof CampfireBlock && nearstate.getValue(CampfireBlock.LIT)) ||
					(nearblock instanceof AbstractFurnaceBlock && nearstate.getValue(AbstractFurnaceBlock.LIT)) ||
					(nearblock instanceof AbstractOvenBlock && nearstate.getValue(AbstractOvenBlock.LIT)) ||
					(nearblock instanceof AbstractStoveBlock && nearstate.getValue(AbstractStoveBlock.LIT)) ||
					(nearblock instanceof Irori && nearstate.getValue(Irori.LIT)) ||
					(nearblock instanceof Kit_Cooktop && nearstate.getValue(Kit_Cooktop.STAGE_1_3) == 2) ) {
				return true; }
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {

		BlockState blockstate = super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
		if (!blockstate.isAir(worldIn, pos)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (inWater(state, worldIn, pos) || hasHeat(worldIn, pos) || worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 200); }
		
		DoubleBlockHalf half = state.getValue(HALF);
		if (facing.getAxis() != Direction.Axis.Y || half == DoubleBlockHalf.LOWER != (facing == Direction.UP) || 
				facingState.getBlock() instanceof SnowMan || facingState.getBlock() instanceof SnowMan_Color && facingState.getValue(HALF) != half) {
			return half == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(worldIn, pos) ? Blocks.AIR.defaultBlockState() : state;
		}
		else {
			return Blocks.AIR.defaultBlockState();
		}
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 200);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		DoubleBlockHalf half = state.getValue(HALF);
		Block downblock = worldIn.getBlockState(pos.below()).getBlock();
		
		switch (half) {
		case LOWER :
		default :
			if (inWater(state, worldIn, pos)) { 
				worldIn.getBlockTicks().scheduleTick(pos, this, 200);
				worldIn.destroyBlock(pos, true); }
			
			if (!inWater(state, worldIn, pos)) {
				if (downblock == Blocks.ICE || downblock == Blocks.PACKED_ICE ||
						downblock == Blocks.BLUE_ICE || downblock == Blocks.SNOW_BLOCK) { }
				
				if (downblock != Blocks.ICE && downblock != Blocks.PACKED_ICE &&
						downblock != Blocks.BLUE_ICE && downblock != Blocks.SNOW_BLOCK) {
					
					if (this.hasHeat(worldIn, pos)) {
						worldIn.getBlockTicks().scheduleTick(pos, this, 200);
						worldIn.destroyBlock(pos, true); }
					
					if (!this.hasHeat(worldIn, pos)) {
						/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
						if (worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
							worldIn.getBlockTicks().scheduleTick(pos, this, 200);
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
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, HALF, STAGE_1_16, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return (state.getValue(HALF) == DoubleBlockHalf.LOWER)? AABB_BOT : AABB_TOP;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.SNOWMAN);
	}
	
}
