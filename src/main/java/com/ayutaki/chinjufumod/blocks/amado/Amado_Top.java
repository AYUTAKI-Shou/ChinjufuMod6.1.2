package com.ayutaki.chinjufumod.blocks.amado;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Amado_Top extends BaseStage4_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	public Amado_Top() {
		super(Material.WOOD);

		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		EnumFacing direction = state.getValue(H_FACING);
		EnumFacing playerfacing = playerIn.getHorizontalFacing();

		IBlockState northstate = worldIn.getBlockState(pos.north());
		IBlockState southstate = worldIn.getBlockState(pos.south());
		IBlockState eaststate = worldIn.getBlockState(pos.east());
		IBlockState weststate = worldIn.getBlockState(pos.west());

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		Block northblock = northstate.getBlock();
		Block southblock = southstate.getBlock();
		Block eastblock = eaststate.getBlock();
		Block westblock = weststate.getBlock();

		Block air = Blocks.AIR;
		IBlockState airstate = air.getDefaultState();

		CMEvents.soundAmado(worldIn, pos);
		
		/** DarkOak **/
		if (this == Slidingdoor_Blocks.AMADO_TOP) {
			Block tobuBotL2 = Slidingdoor_Blocks.TOBUKURO_BOTL2;
			Block tobuBotL = Slidingdoor_Blocks.TOBUKURO_BOTL;
			Block tobuBotR2 = Slidingdoor_Blocks.TOBUKURO_BOTR2;
			Block tobuBotR = Slidingdoor_Blocks.TOBUKURO_BOTR;

			Block tobuTopL2 = Slidingdoor_Blocks.TOBUKURO_TOPL2;
			Block tobuTopL = Slidingdoor_Blocks.TOBUKURO_TOPL;
			Block tobuTopR2 = Slidingdoor_Blocks.TOBUKURO_TOPR2;
			Block tobuTopR = Slidingdoor_Blocks.TOBUKURO_TOPR;

			Block amadoBot = Slidingdoor_Blocks.AMADO_BOT;

			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH :
				default:
					/** RIGHT side is TOBUKURO. **/
					if (westblock == tobuTopL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (westblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case SOUTH :
					/** RIGHT side is TOBUKURO. **/
					if (eastblock == tobuTopL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (eastblock == tobuTopL2) { 
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case EAST :
					/** RIGHT side is TOBUKURO. **/
					if (northblock == tobuTopL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (northblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
					
				case WEST :
					/** RIGHT side is TOBUKURO. **/
					if (southblock == tobuTopL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (southblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
				} // switch
			} //i == 4
			
			
			/* move to Right. */
			if (i < 4) {
				switch (direction) {
				case NORTH :
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
	
				case SOUTH :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
	
				case EAST :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} //i < 4
			
			
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastblock == tobuTopR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					else if (eastblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case SOUTH :
					/** LEFT side is TOBUKURO. **/
					if (westblock == tobuTopR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					else if (westblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case EAST :
					/** LEFT side is TOBUKURO. **/
					if (southblock == tobuTopR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					if (southblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
					
				case WEST :
					/** LEFT side is TOBUKURO. **/
					if (northblock == tobuTopR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					if (northblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
				} // switch
			} //i == 1
			
			
			/* move to Left. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default:
					/** LEFT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
	
				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
	
				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			} //i > 1
		}/** DarkOak **/

		
		if (this == Slidingdoor_Blocks.AMADOS_TOP) {
			Block tobuBotL2 = Slidingdoor_Blocks.TOBUKUROS_BOTL2;
			Block tobuBotL = Slidingdoor_Blocks.TOBUKUROS_BOTL;
			Block tobuBotR2 = Slidingdoor_Blocks.TOBUKUROS_BOTR2;
			Block tobuBotR = Slidingdoor_Blocks.TOBUKUROS_BOTR;

			Block tobuTopL2 = Slidingdoor_Blocks.TOBUKUROS_TOPL2;
			Block tobuTopL = Slidingdoor_Blocks.TOBUKUROS_TOPL;
			Block tobuTopR2 = Slidingdoor_Blocks.TOBUKUROS_TOPR2;
			Block tobuTopR = Slidingdoor_Blocks.TOBUKUROS_TOPR;

			Block amadoBot = Slidingdoor_Blocks.AMADOS_BOT;

			/* Stored in TOBUKURO. */
			if (i == 4) {
				switch (direction) {
				case NORTH :
				default:
					/** RIGHT side is TOBUKURO. **/
					if (westblock == tobuTopL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (westblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case SOUTH :
					/** RIGHT side is TOBUKURO. **/
					if (eastblock == tobuTopL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (eastblock == tobuTopL2) { 
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case EAST :
					/** RIGHT side is TOBUKURO. **/
					if (northblock == tobuTopL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (northblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
					
				case WEST :
					/** RIGHT side is TOBUKURO. **/
					if (southblock == tobuTopL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** RIGHT side is TOBUKURO.2 **/
					else if (southblock == tobuTopL2) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopL2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
				} // switch
			} //i == 4
			
			
			/* move to Right. */
			if (i < 4) {
				switch (direction) {
				case NORTH :
				default:
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
	
				case SOUTH :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
	
				case EAST :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
					
				case WEST :
					/** RIGHT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable()) {
						/** hit RIGHT side. **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); } }
					break;
				} // switch
			} //i < 4
			
			
			/* Stored in TOBUKURO. */
			if (i == 1) {
				switch (direction) {
				case NORTH :
				default:
					/** LEFT side is TOBUKURO. **/
					if (eastblock == tobuTopR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					else if (eastblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (eaststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x + 1, y, z), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case SOUTH :
					/** LEFT side is TOBUKURO. **/
					if (westblock == tobuTopR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					else if (westblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (weststate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x - 1, y, z), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
	
				case EAST :
					/** LEFT side is TOBUKURO. **/
					if (southblock == tobuTopR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					if (southblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (southstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z + 1), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
					
				case WEST :
					/** LEFT side is TOBUKURO. **/
					if (northblock == tobuTopR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); } }
					
					/** LEFT side is TOBUKURO.2 **/
					if (northblock == tobuTopR2) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) == 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(3))); }
							
							if (northstate.getValue(BaseStage2_Face.STAGE_1_2) != 1) {
								worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), tobuBotR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
								worldIn.setBlockState(new BlockPos(x, y, z - 1), tobuTopR2.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } } }
					break;
				} // switch
			} //i == 1
			
			
			/* move to Left. */
			if (i > 1) {
				switch (direction) {
				case NORTH :
				default:
					/** LEFT side is Empty. **/
					if (worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX > 0.55D) || (playerfacing == EnumFacing.SOUTH && hitX > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x + 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
	
				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.NORTH && hitX < 0.45D) || (playerfacing == EnumFacing.SOUTH && hitX < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x - 1, y, z), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
	
				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ > 0.55D) || (playerfacing == EnumFacing.WEST && hitZ > 0.55D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z + 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable() && 
							worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable()) {
						/** hit LEFT side **/
						if ((playerfacing == EnumFacing.EAST && hitZ < 0.45D) || (playerfacing == EnumFacing.WEST && hitZ < 0.45D)) {
							/* Delete it. */
							CMEvents.soundFusumaS(worldIn, pos);
							worldIn.setBlockState(pos, airstate);
							worldIn.setBlockState(pos.down(), airstate);

							worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), amadoBot.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1)));
							worldIn.setBlockState(new BlockPos(x, y, z - 1), this.getDefaultState()
									.withProperty(H_FACING, state.getValue(H_FACING))
									.withProperty(STAGE_1_4, Integer.valueOf(i - 1))); } }
					break;
				} // switch
			} //i > 1
		}

		return true;
	}


	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		IBlockState blockstate = worldIn.getBlockState(pos.down());
		if (blockstate.getBlock() == Slidingdoor_Blocks.AMADO_BOT || blockstate.getBlock() == Slidingdoor_Blocks.AMADOS_BOT) {

			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.down(), false); }
			else { worldIn.destroyBlock(pos.down(), false); }
		}
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items.AIR));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items.AIR);
	}

}
