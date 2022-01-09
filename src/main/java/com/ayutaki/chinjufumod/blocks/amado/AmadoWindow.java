package com.ayutaki.chinjufumod.blocks.amado;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
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

public class AmadoWindow extends BaseStage2_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, -0.03125, 0.0, 0.0, 0.03125, 1.0, 1.0);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };


	public AmadoWindow() {
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

		/** 1=左、2=右 **/
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		EnumFacing direction = state.getValue(H_FACING);
		EnumFacing playerfacing = playerIn.getHorizontalFacing();

		IBlockState northstate = worldIn.getBlockState(pos.north());
		IBlockState southstate = worldIn.getBlockState(pos.south());
		IBlockState eaststate = worldIn.getBlockState(pos.east());
		IBlockState weststate = worldIn.getBlockState(pos.west());

		Block northblock = northstate.getBlock();
		Block southblock = southstate.getBlock();
		Block eastblock = eaststate.getBlock();
		Block westblock = weststate.getBlock();

		Block air = Blocks.AIR;
		IBlockState airstate = air.getDefaultState();

		CMEvents.soundAmadoWin(worldIn, pos);
		
		if (this == Slidingdoor_Blocks.AMADO_WIN) {
			Block tobukuroR = Slidingdoor_Blocks.TOBUKURO_WINR;
			Block tobukuroL = Slidingdoor_Blocks.TOBUKURO_WINL;

			if (i == 1) {
				/* i == 1, ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/** プレイヤーの向きと叩く位置 **/
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }

					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }

					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }
					break;
				} // switch
			} // i == 1

			
			if (i == 2) {
				/* i == 2, ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }

					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }

					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
	
					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }

					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
				} // switch
			} // i == 2
		}/** DarkOak **/
		

		if (this == Slidingdoor_Blocks.AMADOS_WIN) {
			Block tobukuroR = Slidingdoor_Blocks.TOBUKUROS_WINR;
			Block tobukuroL = Slidingdoor_Blocks.TOBUKUROS_WINL;

			if (i == 1) {
				/* i == 1, ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					/** プレイヤーの向きと叩く位置 **/
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }

					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroR && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroR && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }

					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroR && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroR && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), tobukuroR.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable())) {
						/* Delete it. */	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(2))); }
					break;
				} // switch
			} // i == 1

			
			if (i == 2) {
				/* i == 2, ブロックの向き */
				switch (direction) {
				case NORTH :
				default:
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) &&
							!weststate.getMaterial().isReplaceable() && westblock == tobukuroL && weststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(weststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) && eaststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }
					break;
	
				case SOUTH :
					if ((playerfacing == EnumFacing.NORTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.SOUTH && (hitX < 0.45D) && weststate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.west(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }

					if ((playerfacing == EnumFacing.NORTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.SOUTH && (hitX > 0.55D) &&
							!eaststate.getMaterial().isReplaceable() && eastblock == tobukuroL && eaststate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.east(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(eaststate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
	
				case EAST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) &&
							!northstate.getMaterial().isReplaceable() && northblock == tobukuroL && northstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(northstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
	
	
					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) && southstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if ((playerfacing == EnumFacing.EAST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable()) ||
							(playerfacing == EnumFacing.WEST && (hitZ < 0.45D) && northstate.getMaterial().isReplaceable())) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.north(), this.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_2, Integer.valueOf(1))); }

					if ((playerfacing == EnumFacing.EAST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1) ||
							(playerfacing == EnumFacing.WEST && (hitZ > 0.55D) &&
							!southstate.getMaterial().isReplaceable() && southblock == tobukuroL && southstate.getValue(BaseStage3_Face.STAGE_1_3) > 1)) {
						/* Delete it. */
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, airstate);
						
						worldIn.setBlockState(pos.south(), tobukuroL.getDefaultState()
								.withProperty(BaseStage3_Face.H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage3_Face.STAGE_1_3, Integer.valueOf(southstate.getValue(BaseStage3_Face.STAGE_1_3) - 1))); }
					break;
				} // switch
			} // i == 2
		}
		return true;
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
