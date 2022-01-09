package com.ayutaki.chinjufumod.blocks.season;

import java.util.Random;

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
import net.minecraft.block.FallingBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SoulFireBlock;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* FallingBlock. When this falls, the only drop is this ItemBlock. */
public class SnowCore extends FallingBlock implements IWaterLoggable {
	
	public static final IntegerProperty STAGE_0_9 = IntegerProperty.create("stage", 0, 9);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

	/* Collision */
	protected static final VoxelShape AABB_01 = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 5.0D, 10.0D);
	protected static final VoxelShape AABB_23 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 7.0D, 11.0D);
	protected static final VoxelShape AABB_45 = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D);
	protected static final VoxelShape AABB_67 = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 11.0D, 12.0D);
	protected static final VoxelShape AABB_89 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D);
	protected static final VoxelShape COLL_89 = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
	
	private final int dustColor;
	
	public SnowCore(int value, AbstractBlock.Properties properties) {
		super(properties);
		
		this.dustColor = value;
		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState()
				.setValue(STAGE_0_9, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState stateIn, IBlockReader worldIn, BlockPos posIn) {
		return this.dustColor;
	}
	
	/* RightClick Action */
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		
		ItemStack itemstack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_0_9);
		Direction facing = playerIn.getDirection();
		
		BlockState northstate = worldIn.getBlockState(pos.north());
		BlockState southstate = worldIn.getBlockState(pos.south());
		BlockState eaststate = worldIn.getBlockState(pos.east());
		BlockState weststate = worldIn.getBlockState(pos.west());
		
		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();
		
		Block northblock = northstate.getBlock();
		Block southblock = southstate.getBlock();
		Block eastblock = eaststate.getBlock();
		Block westblock = weststate.getBlock();
		
		Block AIR = Blocks.AIR;
		BlockState AIRstate = AIR.defaultBlockState();
		Block SNOW = Blocks.SNOW;
		BlockState placeSNOW = SNOW.defaultBlockState().setValue(SnowBlock.LAYERS, Integer.valueOf(1));
		Block SNOWCORE = Seasonal_Blocks.SNOWCORE;
		
		/** Hand is empty. **/
		if (itemstack.isEmpty()) {

			if (i <= 7) {
				switch (facing) {
				case NORTH :
				default :
					if (northblock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (northblock != SNOW) {
						if (northstate.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!northstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
		
				case SOUTH :
					if (southblock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (southblock != SNOW) {
						if (southstate.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!southstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
		
				case EAST :
					if (eastblock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (eastblock != SNOW) {
						if (eaststate.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!eaststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
					
				case WEST :
					if (westblock == SNOW) {
						CMEvents.soundSnowPlace(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(i + 1)), 3); }
					
					if (westblock != SNOW) {
						if (weststate.getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(i)), 3); }
						 
						if (!weststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					break;
				} // switch facing
			} //i <= 7
			
			
			if (i == 8) {
				switch (facing) {
				case NORTH :
				default :
					if (northblock == SNOWCORE) {
						if (northstate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (northstate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northblock != SNOWCORE) {
						if (northblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northblock != SNOW) {
							if (northstate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, AIRstate, 3);
								worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case SOUTH :
					if (southblock == SNOWCORE) {
						if (southstate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (southstate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southblock != SNOWCORE) {
						if (southblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southblock != SNOW) {
							if (southstate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, AIRstate, 3);
								worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case EAST :
					if (eastblock == SNOWCORE) {
						if (eaststate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (eaststate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastblock != SNOWCORE) {
						if (eastblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastblock != SNOW) {
							if (eaststate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, AIRstate, 3);
								worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eaststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST :
					if (westblock == SNOWCORE) {
						if (weststate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (weststate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westblock != SNOWCORE) {
						if (westblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westblock != SNOW) {
							if (weststate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, AIRstate, 3);
								worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!weststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch
			} //i == 8
	
			
			if (i == 9) {
				switch (facing) {
				case NORTH :
				default :
					if (northblock == SNOWCORE) {
						if (northstate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (northstate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.SOUTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (northblock != SNOWCORE) {
						if (northblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (northblock != SNOW) {
							if (northstate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.north(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!northstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case SOUTH :
					if (southblock == SNOWCORE) {
						if (southstate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (southstate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x, y, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.NORTH)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (southblock != SNOWCORE) {
						if (southblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (southblock != SNOW) {
							if (southstate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.south(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!southstate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
	
				case EAST :
					if (eastblock == SNOWCORE) {
						if (eaststate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (eaststate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x + 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.WEST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (eastblock != SNOWCORE) {
						if (eastblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (eastblock != SNOW) {
							if (eaststate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.east(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!eaststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
					
				case WEST :
					if (westblock == SNOWCORE) {
						if (weststate.getValue(SnowCore.STAGE_0_9) == 8 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(false))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
						
						if (weststate.getValue(SnowCore.STAGE_0_9) == 9 && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(new BlockPos(x - 1, y, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), Seasonal_Blocks.SNOWMAN.defaultBlockState()
									.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
									.setValue(SnowMan.H_FACING, Direction.EAST)
									.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
									.setValue(SnowMan.DOWN, Boolean.valueOf(true))
									.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
					} // make SNOUMAN
					
					if (westblock != SNOWCORE) {
						if (westblock == SNOW) {
							CMEvents.soundSnowPlace(worldIn, pos);
							worldIn.setBlock(pos, placeSNOW, 3);
							worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(9)), 3); }
						
						if (westblock != SNOW) {
							if (weststate.getMaterial().isReplaceable()) {
								CMEvents.soundSnowPlace(worldIn, pos);
								worldIn.setBlock(pos, placeSNOW, 3);
								worldIn.setBlock(pos.west(), state.setValue(STAGE_0_9, Integer.valueOf(8)), 3); }
							
							if (!weststate.getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); } }
					} // not make SNOUMAN
					break;
				} // switch
			} //i == 9
		}/** Hand is empty. **/
		
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}
	
	
	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos = context.getClickedPos();
		Block blockIn = context.getLevel().getBlockState(blockpos).getBlock();
		
		if (blockIn == Blocks.SNOW) {
			return this.defaultBlockState().setValue(STAGE_0_9, Integer.valueOf(1))
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
		
		else { return this.defaultBlockState().setValue(STAGE_0_9, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }
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
	protected boolean inWater(BlockState state, IWorld worldIn, BlockPos pos) {
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
	
	private boolean hasAtama(IWorld worldIn, BlockPos pos) {
		BlockState upstate = worldIn.getBlockState(pos.above());
		Block upblock = upstate.getBlock();
		return (upblock instanceof SnowCore && upstate.getValue(STAGE_0_9) >= 8);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		if ((worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, this.getDelayAfterPlace()); }
		
		else{ worldIn.getBlockTicks().scheduleTick(pos, this, 200); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	/* TickRandom */
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if ((worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= 0) || hasAtama(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, this.getDelayAfterPlace()); }
		
		else { worldIn.getBlockTicks().scheduleTick(pos, this, 200); }
	}

	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_0_9);
		Block downblock = worldIn.getBlockState(pos.below()).getBlock();

		if (worldIn.isEmptyBlock(pos.below()) || isFree(worldIn.getBlockState(pos.below())) && pos.getY() >= 0) {
			FallingBlockEntity fallingblockentity = new FallingBlockEntity(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
			this.falling(fallingblockentity);
			worldIn.addFreshEntity(fallingblockentity); }
		
		if (hasAtama(worldIn, pos)) {
			if (i <= 7) { }
			
			if (i == 8) {
				worldIn.getBlockTicks().scheduleTick(pos, this, this.getDelayAfterPlace());
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(false))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(false))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
		
			if (i == 9) {
				worldIn.getBlockTicks().scheduleTick(pos, this, this.getDelayAfterPlace());
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.LOWER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(true))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3);
				worldIn.setBlock(pos.above(), Seasonal_Blocks.SNOWMAN.defaultBlockState()
						.setValue(SnowMan.HALF, DoubleBlockHalf.UPPER)
						.setValue(SnowMan.H_FACING, Direction.SOUTH)
						.setValue(SnowMan.STAGE_1_4, Integer.valueOf(1))
						.setValue(SnowMan.DOWN, Boolean.valueOf(true))
						.setValue(SnowMan.WATERLOGGED, state.getValue(SnowMan.WATERLOGGED)), 3); }
		} //upblock SnowCore
		
		if (inWater(state, worldIn, pos)) { 
			worldIn.getBlockTicks().scheduleTick(pos, this, 200);
			breakBlock(state, worldIn, pos); }
		
		if (!inWater(state, worldIn, pos)) {
			if (downblock == Blocks.ICE || downblock == Blocks.PACKED_ICE ||
					downblock == Blocks.BLUE_ICE || downblock == Blocks.SNOW_BLOCK) { }
			
			if (downblock != Blocks.ICE && downblock != Blocks.PACKED_ICE &&
					downblock != Blocks.BLUE_ICE && downblock != Blocks.SNOW_BLOCK) {
				
				if (hasHeat(worldIn, pos)) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 200);
					breakBlock(state, worldIn, pos); }
				
				if (!hasHeat(worldIn, pos)) {
					/** Plain 0.8F, Jungle 0.9F, Desert 2.0F **/
					if (worldIn.getBiome(pos).getTemperature(pos) > 0.85F) {
						worldIn.getBlockTicks().scheduleTick(pos, this, 200);
						breakBlock(state, worldIn, pos); }
					
					if (worldIn.getBiome(pos).getTemperature(pos) <= 0.85F) { }
				} //!hasHeat
			} //!ICE
		} //!WATERLOGGED
	}

	private void breakBlock(BlockState state, World worldIn, BlockPos pos) {
		int i = state.getValue(STAGE_0_9);
		if (i != 0) { 
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, state.setValue(STAGE_0_9, Integer.valueOf(i - 1)), 3); }
		if (i == 0) { worldIn.destroyBlock(pos, true); }
	}
	
	
	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_9, WATERLOGGED);
	}
	
	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_0_9);
		
		switch (i) {
		case 0 :
		default :
		case 1 : return AABB_01;
		case 2 :
		case 3 : return AABB_23;
		case 4 :
		case 5 : return AABB_45;
		case 6 :
		case 7 : return AABB_67;
		case 8 :
		case 9 : return AABB_89;
		} // switch STAGE_0_9
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		int i = state.getValue(STAGE_0_9);
		
		switch (i) {
		case 0 :
		default :
		case 1 :
		case 2 :
		case 3 :
		case 4 :
		case 5 : return VoxelShapes.empty();
		case 6 :
		case 7 : return AABB_67;
		case 8 :
		case 9 : return COLL_89;
		} // switch STAGE_0_9
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Seasonal.SNOWCORE);
	}
	
}
