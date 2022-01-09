package com.ayutaki.chinjufumod.blocks.amado;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class AmadoWindow extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape AABB_SOUTH = Block.box(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.box(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.box(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.box(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public AmadoWindow(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=左、2=右 **/
		int i = state.getValue(STAGE_1_2);
		Direction direction = state.getValue(H_FACING);
		Direction facing = playerIn.getDirection();

		BlockState northstate = worldIn.getBlockState(pos.north());
		BlockState southstate = worldIn.getBlockState(pos.south());
		BlockState eaststate = worldIn.getBlockState(pos.east());
		BlockState weststate = worldIn.getBlockState(pos.west());

		Block northblock = northstate.getBlock();
		Block southblock = southstate.getBlock();
		Block eastblock = eaststate.getBlock();
		Block westblock = weststate.getBlock();

		Block AIR = Blocks.AIR;
		BlockState AIRstate = AIR.defaultBlockState();
		
		CMEvents.soundAmadoWin(worldIn, pos);

		if (this == Slidedoor_Blocks.AMADOWIN) {
			Block tobukuro = Slidedoor_Blocks.TOBUKUROWIN;

			switch (i) {
			case 1 :
			default :
				
				switch (direction) {
				case NORTH :
				default :
					/** プレイヤーの向きと叩く位置 **/
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }

					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) != true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) != true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), eaststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) != true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) != true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), weststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }

					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) != true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) != true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), southstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) != true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) != true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), northstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
					break;
				} // switch
				break;

			case 2 :
				
				switch (direction) {
				case NORTH :
				default :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) == true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) == true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), weststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }

					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) == true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) == true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), eaststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) == true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) == true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), northstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }

					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) == true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) == true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), southstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;
				} // switch
				break;
			} // switch STAGE_1_2
		} /** DarkOak **/

		
		if (this == Slidedoor_Blocks.AMADOWIN_S) {
			Block tobukuro = Slidedoor_Blocks.TOBUKUROWIN_S;

			switch (i) {
			case 1 :
			default :

				switch (direction) {
				case NORTH :
				default :
					/** プレイヤーの向きと叩く位置 **/
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }


					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) != true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) != true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), eaststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) != true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) != true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), weststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }

					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) != true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) != true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), southstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) != true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) != true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), northstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
					break;
				} // switch
				break;

			case 2 :
				
				switch (direction) {
				case NORTH :
				default :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) == true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.getValue(TobukuroWindow.WHICH) == true && weststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), weststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.west(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }

					if ((facing == Direction.NORTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) == true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getLocation().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.getValue(TobukuroWindow.WHICH) == true && eaststate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.east(), eaststate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) == true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.getValue(TobukuroWindow.WHICH) == true && northstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), northstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
		
		
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.north(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }

					if ((facing == Direction.EAST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) == true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getLocation().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.getValue(TobukuroWindow.WHICH) == true && southstate.getValue(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, AIRstate, 3);
						worldIn.setBlock(pos.south(), southstate.setValue(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.getValue(TobukuroWindow.STAGE_1_3) - 1)), 3); }
					break;
				} // switch
				break;
			} // switch STAGE_1_2
		} /** Spruce **/
		
		return ActionResultType.SUCCESS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
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
