package com.ayutaki.chinjufumod.blocks.unitblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.config.CMConfig_Core;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TrayLetter extends Block {

	public static final String ID = "block_lettertray_c";

	/* Property */
	public static final PropertyInteger STAGE_1_2 = PropertyInteger.create("stage", 1, 2);
	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool DOWN = PropertyBool.create("down");

	/* Collision */
	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.03125D, 1.0D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.0D, -0.5D, 0.0D, 1.0D, 0.01D, 1.0D);

	public TrayLetter() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(H_FACING, EnumFacing.NORTH)
				.withProperty(STAGE_1_2, Integer.valueOf(1))
				.withProperty(DOWN, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		EnumFacing direction = state.getValue(H_FACING);
		
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();
		
		if (playerIn.experienceTotal >= 100) {
			/* Battle report */
			if (item == Items_Chinjufu.SHOUHOU_empty) {
				CMEvents.Consume_1Item(playerIn, hand);	
				CMEvents.soundWrite(worldIn, pos);
				//playerIn.addExperience(-100);
				
				if (itemstack.isEmpty()) { 
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Chinjufu.SHOUHOU))) {
					playerIn.dropItem(new ItemStack(Items_Chinjufu.SHOUHOU), false); }
			} // item == Items_Chinjufu.SHOUHOU_empty
			
			
			/* Enchantbook */
			if (item == Items.BOOK) {
				
				IBlockState northstate = worldIn.getBlockState(pos.north());
				IBlockState southstate = worldIn.getBlockState(pos.south());
				IBlockState eaststate = worldIn.getBlockState(pos.east());
				IBlockState weststate = worldIn.getBlockState(pos.west());
				Block northblock = northstate.getBlock();
				Block southblock = southstate.getBlock();
				Block eastblock = eaststate.getBlock();
				Block westblock = weststate.getBlock();
				
				switch (i) {
				case 1 :
				default :
					
					switch (direction) {
					case NORTH :
					default:
						/** left **/
						if (eaststate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(eaststate.getMaterial().isReplaceable())) {
							if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
									(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (southstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(southstate.getMaterial().isReplaceable())) {
									if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (southblock != Unit_Blocks.WRITTEN_BOOK ||
											(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (weststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(weststate.getMaterial().isReplaceable())) {
											if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
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
									.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(weststate.getMaterial().isReplaceable())) {
							if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (westblock != Unit_Blocks.WRITTEN_BOOK ||
									(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (northstate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(northstate.getMaterial().isReplaceable())) {
									if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (northblock != Unit_Blocks.WRITTEN_BOOK ||
											(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (eaststate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(eaststate.getMaterial().isReplaceable())) {
											if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									} /** right **/
								}
							} /** front **/
						} /** left **/
						break;
					
					case EAST :
						/** left **/
						if (southstate.getMaterial().isReplaceable()) {
							this.writebook(worldIn, pos, playerIn, hand);
							worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
									.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(southstate.getMaterial().isReplaceable())) {
							if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (southblock != Unit_Blocks.WRITTEN_BOOK ||
									(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (weststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(weststate.getMaterial().isReplaceable())) {
									if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (westblock != Unit_Blocks.WRITTEN_BOOK ||
											(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (northstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(northstate.getMaterial().isReplaceable())) {
											if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
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
									.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
									.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
						
						if (!(northstate.getMaterial().isReplaceable())) {
							if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
							
							/** front **/
							if (northblock != Unit_Blocks.WRITTEN_BOOK ||
									(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
								if (eaststate.getMaterial().isReplaceable()) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								if (!(eaststate.getMaterial().isReplaceable())) {
									if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
									
									/** right **/
									if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
											(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
										if (southstate.getMaterial().isReplaceable()) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										if (!(southstate.getMaterial().isReplaceable())) {
											if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
											
											else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
									}
								}
							}
						}
						break;
					} // direction
					
					break;

				///// Fude Tray ////////////////////////////////////////////////////////////////////////////////////////////////////
				case 2 :
					if (!CMConfig_Core.useMAKIMONO) {
						switch (direction) {
						case NORTH :
						default:
							/** left **/
							if (eaststate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(eaststate.getMaterial().isReplaceable())) {
								if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
										(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (southstate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(southstate.getMaterial().isReplaceable())) {
										if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (southblock != Unit_Blocks.WRITTEN_BOOK ||
												(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (weststate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(weststate.getMaterial().isReplaceable())) {
												if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
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
										.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(weststate.getMaterial().isReplaceable())) {
								if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (westblock != Unit_Blocks.WRITTEN_BOOK ||
										(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (northstate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(northstate.getMaterial().isReplaceable())) {
										if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (northblock != Unit_Blocks.WRITTEN_BOOK ||
												(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (eaststate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(eaststate.getMaterial().isReplaceable())) {
												if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										} /** right **/
									}
								} /** front **/
							} /** left **/
							break;
						
						case EAST :
							/** left **/
							if (southstate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(southstate.getMaterial().isReplaceable())) {
								if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (southblock != Unit_Blocks.WRITTEN_BOOK ||
										(southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (weststate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(weststate.getMaterial().isReplaceable())) {
										if (westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (westblock != Unit_Blocks.WRITTEN_BOOK ||
												(westblock == Unit_Blocks.WRITTEN_BOOK && weststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (northstate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(northstate.getMaterial().isReplaceable())) {
												if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
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
										.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(northstate.getMaterial().isReplaceable())) {
								if (northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								/** front **/
								if (northblock != Unit_Blocks.WRITTEN_BOOK ||
										(northblock == Unit_Blocks.WRITTEN_BOOK && northstate.getValue(WrittenBook.STAGE_1_4) == 4)) {
									if (eaststate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(eaststate.getMaterial().isReplaceable())) {
										if (eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										/** right **/
										if (eastblock != Unit_Blocks.WRITTEN_BOOK ||
												(eastblock == Unit_Blocks.WRITTEN_BOOK && eaststate.getValue(WrittenBook.STAGE_1_4) == 4)) {
											if (southstate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_BOOK.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(southstate.getMaterial().isReplaceable())) {
												if (southblock == Unit_Blocks.WRITTEN_BOOK && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												else { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						} // direction
					} // useMAKIMONO == false
					
					///// use MAKIMONO ////////////////////////////////////////////////////////////////////////////////////////////////////
					if (CMConfig_Core.useMAKIMONO) {
						switch (direction) {
						case NORTH :
						default:
							/** left **/
							if (eaststate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(eaststate.getMaterial().isReplaceable())) {
								if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (eastblock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (southstate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(southstate.getMaterial().isReplaceable())) {
										if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (southblock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (weststate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(weststate.getMaterial().isReplaceable())) {
												if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.NORTH)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (westblock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						
						case SOUTH :
							/** left **/
							if (weststate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(weststate.getMaterial().isReplaceable())) {
								if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (westblock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (northstate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(northstate.getMaterial().isReplaceable())) {
										if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (northblock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (eaststate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(eaststate.getMaterial().isReplaceable())) {
												if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.SOUTH)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (eastblock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										} /** right **/
									}
								} /** front **/
							} /** left **/
							break;
						
						case EAST :
							/** left **/
							if (southstate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(southstate.getMaterial().isReplaceable())) {
								if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (southblock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (weststate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(weststate.getMaterial().isReplaceable())) {
										if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), weststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(weststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (westblock == Unit_Blocks.WRITTEN_MAKIMONO && weststate.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.west(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (westblock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (northstate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(northstate.getMaterial().isReplaceable())) {
												if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.EAST)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (northblock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
							
						case WEST :
							/** left **/
							if (northstate.getMaterial().isReplaceable()) {
								this.writebook(worldIn, pos, playerIn, hand);
								worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
										.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
										.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
							
							if (!(northstate.getMaterial().isReplaceable())) {
								if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) != 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), northstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(northstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
								
								if (northblock == Unit_Blocks.WRITTEN_MAKIMONO && northstate.getValue(WrittenBook.STAGE_1_4) == 4) {
									this.writebook(worldIn, pos, playerIn, hand);
									worldIn.setBlockState(pos.north(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
											.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
											.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
								
								/** front **/
								if (northblock != Unit_Blocks.WRITTEN_MAKIMONO) {
									if (eaststate.getMaterial().isReplaceable()) {
										this.writebook(worldIn, pos, playerIn, hand);
										worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
												.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
												.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
									
									if (!(eaststate.getMaterial().isReplaceable())) {
										if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) != 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), eaststate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(eaststate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
										
										if (eastblock == Unit_Blocks.WRITTEN_MAKIMONO && eaststate.getValue(WrittenBook.STAGE_1_4) == 4) {
											this.writebook(worldIn, pos, playerIn, hand);
											worldIn.setBlockState(pos.east(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
													.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
													.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
										
										/** right **/
										if (eastblock != Unit_Blocks.WRITTEN_MAKIMONO) {
											if (southstate.getMaterial().isReplaceable()) {
												this.writebook(worldIn, pos, playerIn, hand);
												worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO.getDefaultState()
														.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
														.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
											
											if (!(southstate.getMaterial().isReplaceable())) {
												if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) != 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), southstate.withProperty(WrittenBook.STAGE_1_4, Integer.valueOf(southstate.getValue(WrittenBook.STAGE_1_4) + 1)), 3); }
												
												if (southblock == Unit_Blocks.WRITTEN_MAKIMONO && southstate.getValue(WrittenBook.STAGE_1_4) == 4) {
													this.writebook(worldIn, pos, playerIn, hand);
													worldIn.setBlockState(pos.south(), Unit_Blocks.WRITTEN_MAKIMONO5.getDefaultState()
															.withProperty(WrittenBook.H_FACING, EnumFacing.WEST)
															.withProperty(WrittenBook.DOWN, state.getValue(WrittenBook.DOWN)), 3); }
												
												if (southblock != Unit_Blocks.WRITTEN_MAKIMONO) { CMEvents.textNoPlace(worldIn, pos, playerIn); } }
										}
									}
								}
							}
							break;
						} // direction
					} // useMAKIMONO == true
					
					break;
				} // STAGE_1_2
				

			} // item == Items.BOOK
			
			if (item != Items_Chinjufu.SHOUHOU_empty && item != Items.BOOK) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** Not enough EXP **/
		if (playerIn.experienceTotal < 100) { CMEvents.textNotEnough_EXP(worldIn, pos, playerIn); }
		
		return true;
	}
	
	/* Write Book */
	private void writebook(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		CMEvents.Consume_1Item(playerIn, hand);	
		CMEvents.soundWrite(worldIn, pos);
		playerIn.addExperience(-10); //戦闘詳報1冊=10連
	}
	
	/* getOppositeでプレイヤーの向きを取得 */
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing,
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/* IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる */
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing)state.getValue(H_FACING)).getHorizontalIndex();
		i = i | ((Integer)state.getValue(STAGE_1_2)).intValue() - 1 << 2;
		return i;
	}

	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(H_FACING, rot.rotate((EnumFacing)state.getValue(H_FACING)));
	}

	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(H_FACING)));
	}

	/* ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta))
				.withProperty(STAGE_1_2, Integer.valueOf(1 + (meta >> 2)));
	}

	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down = true : false **/
		return flag? AABB : AABB_DOWN;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** ぶつからないブロックになる **/
		return NULL_AABB;
	}

	/* 直下ブロックに対する返し */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getBlock() instanceof LowDesk || worldIn
				.getBlockState(pos).getBlock() instanceof LowDesk_sub;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(DOWN, this.canConnectTo(worldIn, pos.down()));
	}

	/*初期BlockStateContainerの生成 */
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING, DOWN, STAGE_1_2 });
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* 描画の設定 */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 2)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		if (i == 2) { return new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 2); }
		return new ItemStack(Items_Chinjufu.LETTERTRAY, 1, 1);
	}

}
