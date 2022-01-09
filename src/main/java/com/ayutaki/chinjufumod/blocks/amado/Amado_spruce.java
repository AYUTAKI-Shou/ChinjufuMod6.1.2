package com.ayutaki.chinjufumod.blocks.amado;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.DoubleBlockHalf;
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
import net.minecraft.world.World;

public class Amado_spruce extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public Amado_spruce(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(STAGE_1_4, Integer.valueOf(1))
				.with(HALF, DoubleBlockHalf.LOWER)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		int i = state.get(STAGE_1_4);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);
		Direction facing = playerIn.getHorizontalFacing();

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
		BlockState AIRstate = AIR.getDefaultState();

		Block TOBUKURO = Slidedoor_Blocks.TOBUKURO_S;
		Block TOBUKURO_L = Slidedoor_Blocks.TOBUKURO_SL;

		CMEvents.soundAmado(worldIn, pos);

		switch (half) {
		case LOWER :
		default :
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH :
				default :
					/** RIGHT side is TOBUKURO. **/
					if (westblock == TOBUKURO_L && weststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && weststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), weststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, weststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH :
					if (eastblock == TOBUKURO_L && eaststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eaststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eaststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, eaststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST :
					if (northblock == TOBUKURO_L && northstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, northstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST :
					if (southblock == TOBUKURO_L && southstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, southstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH :
				default :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} // i < 4
			
			/** move to Left.________________________________________________________________________________ **/
			/* Stored in TOBUKURO.  */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default :
					/** LEFT side is TOBUKURO. **/
					if (eastblock == TOBUKURO && eaststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eaststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eaststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, eaststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH :
					if (westblock == TOBUKURO && weststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && weststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), weststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, weststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST :
					if (southblock == TOBUKURO && southstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, southstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST :
					if (northblock == TOBUKURO && northstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, northstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.up(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			}
			break;

		case UPPER :
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH :
				default :
					/** RIGHT side is TOBUKURO. **/
					if (westblock == TOBUKURO_L && weststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && weststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), weststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, weststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH :
					if (eastblock == TOBUKURO_L && eaststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eaststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eaststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, eaststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST :
					if (northblock == TOBUKURO_L && northstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, northstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST :
					if (southblock == TOBUKURO_L && southstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), TOBUKURO_L.getDefaultState()
								.with(Base_Tobukuro.H_FACING, southstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 4

			/* move to RIGHT. */
			if (i < 4) {
				switch (direction) {
				case NORTH :
				default :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} // i < 4
			
			/** move to LEFT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO.  */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default :
					/** LEFT side is TOBUKURO. **/
					if (eastblock == TOBUKURO && eaststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eaststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), eaststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, eaststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case SOUTH :
					if (westblock == TOBUKURO && weststate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && weststate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), weststate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, weststate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;

				case EAST :
					if (southblock == TOBUKURO && southstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), southstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, southstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
					
				case WEST :
					if (northblock == TOBUKURO && northstate.get(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northstate.get(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), northstate.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), TOBUKURO.getDefaultState()
								.with(Base_Tobukuro.H_FACING, northstate.get(H_FACING))
								.with(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.with(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.get(Base_Tobukuro.STAGE_1_5) - 1))); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default :
					/** LEFT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x + 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x - 1, y, z), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z + 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, AIRstate);
							worldIn.setBlockState(pos.down(), AIRstate);

							worldIn.setBlockState(new BlockPos(x, y, z - 1), state.with(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER)
								.with(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			}
			break;
		} // switch LOWER-UPPER

		return ActionResultType.SUCCESS;
	}

	/* Destroy at the same time. & Drop item. */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		BlockState upstate = worldIn.getBlockState(pos.up());
		BlockState downstate = worldIn.getBlockState(pos.down());
		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (upstate.getBlock() == this) { worldIn.destroyBlock(pos.up(), false); }
		if (downstate.getBlock() == this) { worldIn.destroyBlock(pos.down(), false); }
		super.onBlockHarvested(worldIn, pos, state, playerIn);
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
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

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch(direction) {
			case SOUTH:
				return AABB_SOUTH;
			case WEST:
				return AABB_WEST;
			case NORTH:
			default:
				return AABB_NORTH;
			case EAST:
				return AABB_EAST;
		}
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

}
