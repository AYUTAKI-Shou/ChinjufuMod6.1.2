package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.wood.WoodSlabWater_CM;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.SlabBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TrayLetter extends Block implements IWaterLoggable {

	/* Property */
	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty DOWN = BooleanProperty.create("down");
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty LOST = BooleanProperty.create("lost");
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(0.0D, -8.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public TrayLetter(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(H_FACING, Direction.NORTH)
				.setValue(DOWN, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(LOST, Boolean.valueOf(false)));
	}
	
	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {
		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		Direction direction = state.getValue(H_FACING);
		
		if (state.getValue(LOST) != true) {
	
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty) {
				
				if (playerIn.totalExperience >= 100) {
					CMEvents.Consume_1Item(playerIn, hand);					
					CMEvents.soundWrite(worldIn, pos);
					playerIn.giveExperiencePoints(-100);
					
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Chinjufu.SHOUHOU)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Chinjufu.SHOUHOU))) {
						playerIn.drop(new ItemStack(Items_Chinjufu.SHOUHOU), false); } }
				
				/** Not enough EXP **/
				if (playerIn.totalExperience < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook 5 times */
			if (item == Items.BOOK) {
				
				if (playerIn.totalExperience >= 50) {
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
							worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
									.setValue(WrittenBook.H_FACING, Direction.NORTH)
									.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
									.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(eaststate.getMaterial().isReplaceable())) {
							if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.east(), eaststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
									(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (southstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
											.setValue(WrittenBook.H_FACING, Direction.NORTH)
											.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
											.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(southstate.getMaterial().isReplaceable())) {
									if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.south(), southstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (southblock != Unit_Blocks.WRITTEN_BOOK ||
											(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (weststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
													.setValue(WrittenBook.H_FACING, Direction.NORTH)
													.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
													.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(weststate.getMaterial().isReplaceable())) {
											if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.west(), weststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
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
							worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
									.setValue(WrittenBook.H_FACING, Direction.SOUTH)
									.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
									.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(weststate.getMaterial().isReplaceable())) {
							if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.west(), weststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (westblock != Unit_Blocks.WRITTEN_BOOK ||
									(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (northstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
											.setValue(WrittenBook.H_FACING, Direction.SOUTH)
											.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
											.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(northstate.getMaterial().isReplaceable())) {
									if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.north(), northstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (northblock != Unit_Blocks.WRITTEN_BOOK ||
											(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (eaststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
													.setValue(WrittenBook.H_FACING, Direction.SOUTH)
													.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
													.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(eaststate.getMaterial().isReplaceable())) {
											if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.east(), eaststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
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
							worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
									.setValue(WrittenBook.H_FACING, Direction.EAST)
									.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
									.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(southstate.getMaterial().isReplaceable())) {
							if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.south(), southstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (southblock != Unit_Blocks.WRITTEN_BOOK ||
									(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (weststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.west(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
											.setValue(WrittenBook.H_FACING, Direction.EAST)
											.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
											.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(weststate.getMaterial().isReplaceable())) {
									if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.west(), weststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (westblock != Unit_Blocks.WRITTEN_BOOK ||
											(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (northstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
													.setValue(WrittenBook.H_FACING, Direction.EAST)
													.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
													.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(northstate.getMaterial().isReplaceable())) {
											if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.north(), northstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
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
							worldIn.setBlock(pos.north(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
									.setValue(WrittenBook.H_FACING, Direction.WEST)
									.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
									.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
						
						if (!(northstate.getMaterial().isReplaceable())) {
							if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlock(pos.north(), northstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (northblock != Unit_Blocks.WRITTEN_BOOK ||
									(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (eaststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlock(pos.east(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
											.setValue(WrittenBook.H_FACING, Direction.WEST)
											.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
											.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
								
								if (!(eaststate.getMaterial().isReplaceable())) {
									if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlock(pos.east(), eaststate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
											(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (southstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlock(pos.south(), Unit_Blocks.WRITTEN_BOOK.defaultBlockState()
													.setValue(WrittenBook.H_FACING, Direction.WEST)
													.setValue(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN))
													.setValue(WrittenBook.WATERLOGGED, state.getValue(WrittenBook.WATERLOGGED)), 3); }
										
										if (!(southstate.getMaterial().isReplaceable())) {
											if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlock(pos.south(), southstate.setValue(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
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
				if (playerIn.totalExperience < 50) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
			} // item == Items.BOOK
			
			
			if (item != Items_Chinjufu.SHOUHOU_empty && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		} //getValue(LOST) != true


		/** Waterlogged **/
		if (state.getValue(LOST) == true) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
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
		IBlockReader worldIn = context.getLevel();
		BlockPos pos = context.getClickedPos();
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(DOWN, this.connectHalf(worldIn, pos, Direction.DOWN))
				.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	protected boolean connectHalf(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof WoodSlabWater_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) ||
				block instanceof LowDesk || block instanceof Chabudai || block instanceof Kotatsu);
	}

	protected boolean connectWater(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return ((block instanceof SlabBlock && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof WoodSlabWater_CM && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof BaseFacingSlab_Water && state.getValue(SlabBlock.TYPE) == SlabType.BOTTOM && state.getValue(SlabBlock.WATERLOGGED)) ||
				(block instanceof LowDesk && state.getValue(LowDesk.WATERLOGGED)) ||
				(block instanceof Chabudai && state.getValue(Chabudai.WATERLOGGED)) ||
				(block instanceof Kotatsu && state.getValue(Kotatsu.WATERLOGGED)));
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
	
	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED) || connectWater(worldIn, pos, Direction.DOWN)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (connectWater(worldIn, pos, Direction.DOWN)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 300); }
		
		boolean down = connectHalf(worldIn, pos, Direction.DOWN);
		return state.setValue(DOWN, down);
	}

	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 300);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
	
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 300);
			worldIn.setBlock(pos, state.setValue(LOST, Boolean.valueOf(true)), 3); }
		
		else { }
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

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DOWN, H_FACING, WATERLOGGED, LOST);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_lettertray")).withStyle(TextFormatting.GRAY));
	}
	
}
