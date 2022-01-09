package com.ayutaki.chinjufumod.blocks.wood;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Rice_8;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Suiden extends Block {

	public static final String ID = "block_suiden";

	/* Property */
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyBool EAST = PropertyBool.create("east");
	/* 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 */
	public static final PropertyInteger WET_1_7 = PropertyInteger.create("wet", 1, 7);

	public Suiden() {
		super(Material.GROUND);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
		setCreativeTab(ChinjufuModTabs.SEASONAL);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(SOUTH, false)
				.withProperty(NORTH, false)
				.withProperty(WEST, false)
				.withProperty(EAST, false)
				.withProperty(WET_1_7, Integer.valueOf(1)));

		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
		setHardness(2.0F);
		setResistance(10.0F);

		setSoundType(SoundType.GROUND);

		setTickRandomly(true);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		boolean mode = playerIn.capabilities.isCreativeMode;
		/* 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 */
		int wet = ((Integer)state.getValue(WET_1_7)).intValue();
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k;
		k = itemstack.getMetadata();

		if (wet == 1 && (item == Items.DIAMOND_HOE || item == Items.GOLDEN_HOE || item == Items.IRON_HOE || item == Items
				.STONE_HOE || item == Items.WOODEN_HOE)) {

			((EntityLivingBase) playerIn).playSound(SoundEvents.ITEM_HOE_TILL, 1.0F, 1.0F);
			worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(2)));

			if (!mode) { itemstack.damageItem(1, playerIn); }
			if (mode) { }
			return true; }


		/** 田植え **/
		if (wet != 2 && item == Items_Teatime.SEEDS_RICE) { return true; }

		if (wet == 2 && item == Items_Teatime.SEEDS_RICE && worldIn.getBlockState(pos.up()).getMaterial().isReplaceable()) {

			CMEvents.Consume_1Item(playerIn, hand);
			worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 1.0F);
			worldIn.setBlockState(pos.up(), Crop_Blocks.RICE_8.getDefaultState().withProperty(Rice_8.AGE, Integer.valueOf(0)));
			return true; }


		/** 土壌調整 **/
		if (wet == 4 && worldIn.isAirBlock(pos.up()) && (item == Items_Teatime.INEWARA || item == Items_Seasonal.WARAHAI ||
				item == Items_Seasonal.OCHIBA_carpet || item == Items_Seasonal.KAEDE_carpet || (item == Items.DYE && k == 15))) {

			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundSnowPlace(worldIn, pos);
			worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(5)));
			return true; }


		/** 田起こし **/
		if (wet >= 5 && (item == Items.DIAMOND_HOE || item == Items.GOLDEN_HOE || item == Items.IRON_HOE || item == Items
				.STONE_HOE || item == Items.WOODEN_HOE)) {

			((EntityLivingBase) playerIn).playSound(SoundEvents.ITEM_HOE_TILL, 1.0F, 1.0F);
			worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(1)));

			if (!mode) { itemstack.damageItem(1, playerIn); }
			if (mode) { }
			return true; }

		return false;
	}


	/* 隣接ブロック */
	private boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing, int wet) {
		IBlockState state = worldIn.getBlockState(pos.offset(facing));
		return state.getBlock() == this && state.getValue(WET_1_7) == wet;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

		int wet = ((Integer)state.getValue(WET_1_7)).intValue();

		boolean south = canConnectTo(worldIn, pos, EnumFacing.SOUTH, wet);
		boolean north = canConnectTo(worldIn, pos, EnumFacing.NORTH, wet);
		boolean west = canConnectTo(worldIn, pos, EnumFacing.WEST, wet);
		boolean east = canConnectTo(worldIn, pos, EnumFacing.EAST, wet);
		return state.withProperty(SOUTH, south)
				.withProperty(NORTH, north)
				.withProperty(WEST, west)
				.withProperty(EAST, east);
	}


	/* TickRandomと変化条件 */
	public static void turnToDirt(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
	}

	private boolean upAir(World worldIn, BlockPos pos) {
		IBlockState upstate = worldIn.getBlockState(pos.up());
		Block upblock = upstate.getBlock();
		return (upblock == Blocks.AIR);
	}

	private static boolean hasWater(World worldIn, BlockPos pos) {
		for (BlockPos.MutableBlockPos nearpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (worldIn.getBlockState(nearpos).getMaterial() == Material.WATER) {
				return true;
			}
		}
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) { turnToDirt(worldIn, pos); }

		else {
			/** 1=耕した、2=水を張った、3=水を抜く、4=乾く、5=土作り、6=分解、7=浸透 **/
			int wet = ((Integer)state.getValue(WET_1_7)).intValue();

			if (wet == 1 && rand.nextInt(1) == 0) {
				worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(2))); }

			if (wet == 2) { }

			if (wet == 3 && upAir(worldIn, pos) && rand.nextInt(1) == 0) {
				worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(4))); }

			if (wet == 4) { }

			if (wet == 5 && rand.nextInt(3) == 0) {
				worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(6))); }

			if (wet == 6 && rand.nextInt(3) == 0) {
				worldIn.setBlockState(pos, state.withProperty(WET_1_7, Integer.valueOf(7))); }
		}

	}

	@SuppressWarnings("deprecation")
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);

		if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
			turnToDirt(worldIn, pos); }
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.9375D, 1.0D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D);
	}

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(WET_1_7, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(WET_1_7)).intValue();
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (7 - ((Integer)blockState.getValue(WET_1_7)).intValue()) * 2;
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP) { return true; }
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { SOUTH, NORTH, WEST, EAST, WET_1_7 });
	}

	/* モンスターをSpawnするようにする */
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess worldIn, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
		int wet = ((Integer)state.getValue(WET_1_7)).intValue();
		if (wet == 2) { return false; }
		return true;
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

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Item.getItemFromBlock(Blocks.DIRT)));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Item.getItemFromBlock(Blocks.DIRT));
	}

}
