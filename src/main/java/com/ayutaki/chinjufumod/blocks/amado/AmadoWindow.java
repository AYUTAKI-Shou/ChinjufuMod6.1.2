package com.ayutaki.chinjufumod.blocks.amado;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
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
	protected static final VoxelShape AABB_SOUTH = Block.makeCuboidShape(0.0D, 0.0D, -0.5D, 16.0D, 16.0D, 0.5D);
	protected static final VoxelShape AABB_WEST = Block.makeCuboidShape(15.5D, 0.0D, 0.0D, 16.5D, 16.0D, 16.0D);
	protected static final VoxelShape AABB_NORTH = Block.makeCuboidShape(0.0D, 0.0D, 15.5D, 16.0D, 16.0D, 16.5D);
	protected static final VoxelShape AABB_EAST = Block.makeCuboidShape(-0.5D, 0.0D, 0.0D, 0.5D, 16.0D, 16.0D);

	public AmadoWindow(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=左、2=右 **/
		int i = state.get(STAGE_1_2);
		Direction direction = state.get(H_FACING);
		Direction facing = playerIn.getHorizontalFacing();

		BlockState northstate = worldIn.getBlockState(pos.north());
		BlockState southstate = worldIn.getBlockState(pos.south());
		BlockState eaststate = worldIn.getBlockState(pos.east());
		BlockState weststate = worldIn.getBlockState(pos.west());

		Block northblock = northstate.getBlock();
		Block southblock = southstate.getBlock();
		Block eastblock = eaststate.getBlock();
		Block westblock = weststate.getBlock();

		Block air = Blocks.AIR;
		BlockState airstate = air.getDefaultState();

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
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }

					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) != true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) != true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), eaststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) != true && weststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) != true && weststate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), weststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }

					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) != true && southstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) != true && southstate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), southstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) != true && northstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) != true && northstate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), northstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }
					break;
				} // switch
				break;

			case 2 :
				switch (direction) {
				case NORTH :
				default :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) == true && weststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) == true && weststate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), weststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }

					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) == true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) == true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), eaststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) == true && northstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) == true && northstate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), northstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }

					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) == true && southstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) == true && southstate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), southstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
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
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }


					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) != true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) != true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), eaststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) != true && weststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) != true && weststate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), weststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }

					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) != true && southstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) != true && southstate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), southstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) != true && northstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) != true && northstate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), northstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(2))); }
					break;
				} // switch
				break;

			case 2 :
				switch (direction) {
				case NORTH :
				default :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) == true && weststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuro &&
							weststate.get(TobukuroWindow.WHICH) == true && weststate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), weststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(weststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) && eaststate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }
					break;

				case SOUTH :
					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() < 0.45D) && weststate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }

					if ((facing == Direction.NORTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) == true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.SOUTH && (hit.getHitVec().x - (double)pos.getX() > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuro &&
							eaststate.get(TobukuroWindow.WHICH) == true && eaststate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.east(), eaststate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(eaststate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;

				case EAST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) == true && northstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuro &&
							northstate.get(TobukuroWindow.WHICH) == true && northstate.get(TobukuroWindow.STAGE_1_3) > 1)) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), northstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(northstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
		
		
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) && southstate.getMaterial().isReplaceable())) {
		
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() < 0.45D) && northstate.getMaterial().isReplaceable())) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(STAGE_1_2, Integer.valueOf(1))); }

					if ((facing == Direction.EAST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) == true && southstate.get(TobukuroWindow.STAGE_1_3) > 1) ||
							(facing == Direction.WEST && (hit.getHitVec().z - (double)pos.getZ() > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuro &&
							southstate.get(TobukuroWindow.WHICH) == true && southstate.get(TobukuroWindow.STAGE_1_3) > 1)) {

						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						worldIn.setBlockState(pos.south(), southstate.with(TobukuroWindow.STAGE_1_3, Integer.valueOf(southstate.get(TobukuroWindow.STAGE_1_3) - 1))); }
					break;
				} // switch
				break;
			} // switch STAGE_1_2
		} /** Spruce **/
		
		return ActionResultType.SUCCESS;
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

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
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
