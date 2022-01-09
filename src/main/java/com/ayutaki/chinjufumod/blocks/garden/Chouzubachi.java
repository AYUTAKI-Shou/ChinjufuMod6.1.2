package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Chouzubachi extends Block {

	public static final String ID = "block_chouzubachi_kara";

	/* Property */
	/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 空スタートで確定 **/
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	public Chouzubachi() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(STAGE_0_15, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 **/
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		
		if (i >= 0 && i <= 3) {
			if (i != 0) {
				if (itemstack.isEmpty() && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i - 1)), 3); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (i != 3) {
				if (item == Items.WATER_BUCKET) {
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {
					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(3))); }
				
				if (i == 0 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); } }
		}
		
		if (i >= 4 && i <= 7) {
			if (i != 4) {
				if (itemstack.isEmpty() && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i - 1)), 3); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (i != 7) {
				if (item == Items.WATER_BUCKET) {
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {
					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(7))); }
				
				if (i == 4 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); } }
		}
		
		
		if (i >= 8 && i <= 11) {
			if (i != 8) {
				if (itemstack.isEmpty() && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i - 1)), 3); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (i != 11) {
				if (item == Items.WATER_BUCKET) {
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {
					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(11))); }
				
				if (i == 8 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); } }
		}
		
		if (i >= 12 && i <= 15) {
			if (i != 12) {
				if (itemstack.isEmpty() && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) {
					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i - 1)), 3); }
				
				if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); } }
			
			if (i != 15) {
				if (item == Items.WATER_BUCKET) {
					CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				
				if (item == Items_Teatime.MIZUOKE_full) {
					CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
					worldIn.setBlockState(pos, this.getDefaultState().withProperty(Chouzubachi.STAGE_0_15, Integer.valueOf(15))); }
				
				if (i == 12 && item != Items.WATER_BUCKET && item != Items_Teatime.MIZUOKE_full) { 
					CMEvents.textNotHave(worldIn, pos, playerIn); } }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* TickRandom */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 **/
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (worldIn.isRainingAt(pos.up())) {

			if (i == 3 || i ==7 || i == 11 || i == 15) { }

			else { worldIn.setBlockState(pos, state.withProperty(STAGE_0_15, Integer.valueOf(i + 1))); }
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 300;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.625D, 0.9375D);
	}

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_15 });
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (15 - ((Integer)blockState.getValue(STAGE_0_15)).intValue()) * 2;
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

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();
		/** 石=空0,1,2,3 GRA=空4,5,6,7 DIO=空8,9,10,11 AND=空12,13,14,15 空スタートで確定 **/
		if (i <= 3) { stack.add(new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 0)); }
		if (i >= 4 && i <= 7) { stack.add(new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 1)); }
		if (i >= 8 && i <= 11) { stack.add(new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 2)); }
		if (i >= 12) { stack.add(new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 3)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i >= 4 && i <= 7) { return new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 1); }
		if (i >= 8 && i <= 11) { return new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 2); }
		if (i >= 12) { return new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 3); }
		return new ItemStack(Items_Wadeco.CHOUZUBACHI, 1, 0);
	}

}
