package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
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

public class Amado_spruce extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final IntegerProperty STAGE_1_4 = IntegerProperty.create("stage", 1, 4);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.box(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.box(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public Amado_spruce(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(STAGE_1_4, Integer.valueOf(1))
				.setValue(HALF, DoubleBlockHalf.LOWER)
				.setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	/* RightClick Action ※TranslationTextComponent は呼び出した雨戸にも反応する為、断念 */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		int i = state.getValue(STAGE_1_4);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);
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
					if (westblock == TOBUKURO_L && weststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && weststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), weststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, weststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH :
					if (eastblock == TOBUKURO_L && eaststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eaststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eaststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, eaststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST :
					if (northblock == TOBUKURO_L && northstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, northstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST :
					if (southblock == TOBUKURO_L && southstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, southstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
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
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
				} // switch
			} // i < 4
			
			/** move to Left.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default :
					/** LEFT side is TOBUKURO. **/
					if (eastblock == TOBUKURO && eaststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && eaststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eaststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, eaststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH :
					if (westblock == TOBUKURO && weststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && weststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), weststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, weststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST :
					if (southblock == TOBUKURO && southstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && southstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, southstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST :
					if (northblock == TOBUKURO && northstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.LOWER && northstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, northstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.UPPER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y + 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y + 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z + 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.above(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y + 1, z - 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
				} // switch
			} // i > 1
			
			break;

		case UPPER :
			/** move to RIGHT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH :
				default :
					/** RIGHT side is TOBUKURO. **/
					if (westblock == TOBUKURO_L && weststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && weststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit RIGHT side. **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), weststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, weststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH :
					if (eastblock == TOBUKURO_L && eaststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eaststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eaststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, eaststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST :
					if (northblock == TOBUKURO_L && northstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */	
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, northstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST :
					if (southblock == TOBUKURO_L && southstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), TOBUKURO_L.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, southstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
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
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); } }
					break;
				} // switch
			} // i < 4
			
			/** move to LEFT.________________________________________________________________________________ **/
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default :
					/** LEFT side is TOBUKURO. **/
					if (eastblock == TOBUKURO && eaststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && eaststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						/** hit LEFT side **/
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), eaststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, eaststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(eaststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case SOUTH :
					if (westblock == TOBUKURO && weststate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && weststate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), weststate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, weststate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(weststate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;

				case EAST :
					if (southblock == TOBUKURO && southstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && southstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), southstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, southstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(southstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
					
				case WEST :
					if (northblock == TOBUKURO && northstate.getValue(Base_Tobukuro.HALF) == DoubleBlockHalf.UPPER && northstate.getValue(Base_Tobukuro.STAGE_1_5) > 1) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), northstate.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), TOBUKURO.defaultBlockState()
								.setValue(Base_Tobukuro.H_FACING, northstate.getValue(H_FACING))
								.setValue(Base_Tobukuro.HALF, DoubleBlockHalf.LOWER)
								.setValue(Base_Tobukuro.STAGE_1_5, Integer.valueOf(northstate.getValue(Base_Tobukuro.STAGE_1_5) - 1)), 3); } }
					break;
				} // switch
			} // i == 1

			/* move to LEFT. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x + 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x + 1, y - 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D)) || (facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x - 1, y, z), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x - 1, y - 1, z), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z + 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z + 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D)) || (facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D))) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlock(pos, AIRstate, 3);
							worldIn.setBlock(pos.below(), AIRstate, 3);

							worldIn.setBlock(new BlockPos(x, y, z - 1), state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3);
							worldIn.setBlock(new BlockPos(x, y - 1, z - 1), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER)
								.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
					break;
				} // switch
			} // i > 1
			
			break;
		} // switch LOWER-UPPER

		return ActionResultType.SUCCESS;
	}

	/* Destroy a DoubleBlock from DoublePlantBlock.class */
	@Override
	public void playerWillDestroy(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {

		if (!worldIn.isClientSide) {
			if (playerIn.isCreative()) { creativeDrop(worldIn, pos, state, playerIn); }
			else { notCreativeDrop(worldIn, pos, state, playerIn); }
		}
		super.playerWillDestroy(worldIn, pos, state, playerIn);
	}

	@Override
	public void playerDestroy(World worldIn, PlayerEntity playerIn, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
		super.playerDestroy(worldIn, playerIn, pos, Blocks.AIR.defaultBlockState(), te, stack);
	}

	protected static void creativeDrop(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downpos = pos.below();
			BlockState downstate = worldIn.getBlockState(downpos);

			if (downstate.getBlock() == state.getBlock() && downstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downpos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downpos, Block.getId(downstate));
			}
		}

		if (half != DoubleBlockHalf.UPPER) {
			BlockPos uppos = pos.above();
			BlockState upstate = worldIn.getBlockState(uppos);

			if (upstate.getBlock() == state.getBlock() && upstate.getValue(HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(uppos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, uppos, Block.getId(upstate));
			}
		}
	}

	protected static void notCreativeDrop(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn) {
		DoubleBlockHalf half = state.getValue(HALF);
		if (half == DoubleBlockHalf.UPPER) {
			BlockPos downpos = pos.below();
			BlockState downstate = worldIn.getBlockState(downpos);

			if (downstate.getBlock() == state.getBlock() && downstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
				worldIn.setBlock(downpos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, downpos, Block.getId(downstate));
			}
		}

		if (half != DoubleBlockHalf.UPPER) {
			BlockPos uppos = pos.above();
			BlockState upstate = worldIn.getBlockState(uppos);

			if (upstate.getBlock() == state.getBlock() && upstate.getValue(HALF) == DoubleBlockHalf.UPPER) {
				worldIn.setBlock(uppos, Blocks.AIR.defaultBlockState(), 35);
				worldIn.levelEvent(playerIn, 2001, uppos, Block.getId(upstate));
			}
		}
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite());
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(H_FACING, rotation.rotate(state.getValue(H_FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(H_FACING)));
	}

	/* Limit the place. */
	@Override
	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.below();
		BlockState downstate = worldIn.getBlockState(downpos);

		/** Lower part is true. **/
		if (state.getValue(HALF) == DoubleBlockHalf.LOWER) { return true; }

		/** Upper part is this block. **/
		else { return downstate.getBlock() == this; }
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

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, HALF, STAGE_1_4, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH:
		default:
			return AABB_NORTH;
		case SOUTH:
			return AABB_SOUTH;
		case WEST:
			return AABB_WEST;
		case EAST:
			return AABB_EAST;
		}
	}

}

/* net.minecraft.world.World.class
public boolean setBlockAndUpdate(BlockPos p_175656_1_, BlockState p_175656_2_) {
	return this.setBlock(p_175656_1_, p_175656_2_, 3);
}
*/