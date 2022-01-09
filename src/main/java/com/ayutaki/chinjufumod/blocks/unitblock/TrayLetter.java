package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.SlabType;
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
import net.minecraft.world.server.ServerWorld;

public class TrayLetter extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty LOST = BooleanProperty.create("lost");
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(0.0D, -8.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public TrayLetter(Block.Properties properties) {
		super(properties);

		/** Default blockstate **/
		setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(DOWN, Boolean.valueOf(false))
				.with(WATERLOGGED, Boolean.valueOf(false))
				.with(LOST, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		Direction direction = state.get(H_FACING);
		
		if (state.get(LOST) != true) {
			
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty) {
				
				if (playerIn.experienceTotal >= 100) {
					CMEvents.Consume_1Item(playerIn, hand);					
					CMEvents.soundWrite(worldIn, pos);
					
					playerIn.giveExperiencePoints(-100);
					
					if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU))) {
						playerIn.dropItem(new ItemStack(Items_Chinjufu.SHOUHOU), false); }
				}

				/** Not enough EXP **/
				if (playerIn.experienceTotal < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook 5 times */
			if (item == Items.BOOK) {
				
				if (playerIn.experienceTotal >= 50) {
					
					BlockState northstate = worldIn.getBlockState(pos.north());
					BlockState southstate = worldIn.getBlockState(pos.south());
					BlockState eaststate = worldIn.getBlockState(pos.east());
					BlockState weststate = worldIn.getBlockState(pos.west());
					Block northblock = northstate.getBlock();
					Block southblock = southstate.getBlock();
					Block eastblock = eaststate.getBlock();
					Block westblock = weststate.getBlock();
					
					switch (direction) {
					case NORTH :
					default :
						/** left **/
						if (eaststate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.NORTH)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(eaststate.getMaterial().isReplaceable())) {
							if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), eaststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
									(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.get(WrittenBook.STAGE_1_4) == 4)) {
								if (southstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.NORTH)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(southstate.getMaterial().isReplaceable())) {
									if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), southstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (southblock != Unit_Blocks.WRITTEN_BOOK ||
											(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.get(WrittenBook.STAGE_1_4) == 4)) {
										if (weststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.NORTH)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(weststate.getMaterial().isReplaceable())) {
											if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), weststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;

					case SOUTH :
						/** left **/
						if (weststate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.SOUTH)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(weststate.getMaterial().isReplaceable())) {
							if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), weststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (westblock != Unit_Blocks.WRITTEN_BOOK ||
									(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.get(WrittenBook.STAGE_1_4) == 4)) {
								if (northstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.SOUTH)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(northstate.getMaterial().isReplaceable())) {
									if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), northstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (northblock != Unit_Blocks.WRITTEN_BOOK ||
											(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.get(WrittenBook.STAGE_1_4) == 4)) {
										if (eaststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.SOUTH)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(eaststate.getMaterial().isReplaceable())) {
											if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), eaststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;

					case EAST :
						/** left **/
						if (southstate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.EAST)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(southstate.getMaterial().isReplaceable())) {
							if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), southstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (southblock != Unit_Blocks.WRITTEN_BOOK ||
									(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.get(WrittenBook.STAGE_1_4) == 4)) {
								if (weststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.EAST)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(weststate.getMaterial().isReplaceable())) {
									if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), weststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (westblock != Unit_Blocks.WRITTEN_BOOK ||
											(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.get(WrittenBook.STAGE_1_4) == 4)) {
										if (northstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.EAST)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(northstate.getMaterial().isReplaceable())) {
											if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), northstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;
						
					case WEST :
						/** left **/
						if (northstate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.with(WrittenBook.H_FACING, Direction.WEST)
									.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
									.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(northstate.getMaterial().isReplaceable())) {
							if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.get(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), northstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (northblock != Unit_Blocks.WRITTEN_BOOK ||
									(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.get(WrittenBook.STAGE_1_4) == 4)) {
								if (eaststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.with(WrittenBook.H_FACING, Direction.WEST)
											.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
											.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(eaststate.getMaterial().isReplaceable())) {
									if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.get(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), eaststate.with(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
											(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.get(WrittenBook.STAGE_1_4) == 4)) {
										if (southstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.with(WrittenBook.H_FACING, Direction.WEST)
													.with(WrittenBook.DOWN, state.get(WrittenBook.DOWN))
													.with(WrittenBook.WATERLOGGED, state.get(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(southstate.getMaterial().isReplaceable())) {
											if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.get(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), southstate.with(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.get(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); }
										}
									}
								}
							}
						}
						break;
					} // switch direction
				} // totalExperience >= 50
				
				/** Not enough EXP **/
				if (playerIn.experienceTotal < 50) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items.BOOK
			
			if (item != Items_Chinjufu.SHOUHOU_empty && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
		} //get(LOST) != true
		
		/** Waterlogged **/
		if (state.get(LOST) == true) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}
	
	/* Write Book */
	private void writebook(World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand) {
		CMEvents.Consume_1Item(playerIn, hand);
		CMEvents.soundWrite(worldIn, pos);
		playerIn.giveExperiencePoints(-10); //戦闘詳報1冊=10連
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IBlockReader worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
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
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 300); }
		
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.with(DOWN, down);
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, 300);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	
		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 300);
			worldIn.setBlockState(pos, state.with(LOST, Boolean.valueOf(true)), 3); }
		
		if (!inWater(state, worldIn, pos)) { }
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

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		super.fillStateContainer(builder);
		builder.add(DOWN, H_FACING, WATERLOGGED, LOST);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
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
