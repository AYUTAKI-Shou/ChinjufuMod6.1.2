package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma;
import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma_B;
import com.ayutaki.chinjufumod.blocks.glassdoor.Base_GlassDoor;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorHalf;
import com.ayutaki.chinjufumod.blocks.glassdoor.GlassDoorHalf_seasonal;
import com.ayutaki.chinjufumod.blocks.shouji.BaseShouji;
import com.ayutaki.chinjufumod.blocks.shoujih.BaseShouji_Win;
import com.ayutaki.chinjufumod.blocks.shoujih.ShoujiHalf;
import com.ayutaki.chinjufumod.blocks.shoujih.ShoujiHalf_seasonal;
import com.ayutaki.chinjufumod.blocks.window.BaseWindow;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowB;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Bottom;
import com.ayutaki.chinjufumod.blocks.window.BaseWindowTall_Top;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wablock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPane;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Wall_DirtWall extends Block {

	public static final String ID = "block_dirtwall_wall";
	
	/* Property */
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool WEST = PropertyBool.create("west");
	public static final PropertyInteger STAGE_0_1 = PropertyInteger.create("stage", 0, 1);

	/* Collision ...Based on the value of WallBlock.*/
	protected static final AxisAlignedBB[] BOUNDING_BOXES = new AxisAlignedBB[] {
			new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 0.6875D, 1.0D, 1.0D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.6875D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.6875D, 1.0D, 1.0D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 1.0D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.6875D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D) };
	
	private static final AxisAlignedBB AABB_CENTER = new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 1.0D, 0.6875D);
	private static final AxisAlignedBB AABB_NORTH = new AxisAlignedBB(0.3125D, 0.0D, 0.0D, 0.6875D, 1.0D, 0.3125D);
	private static final AxisAlignedBB AABB_EAST = new AxisAlignedBB(0.6875D, 0.0D, 0.3125D, 1.0D, 1.0D, 0.6875D);
	private static final AxisAlignedBB AABB_SOUTH = new AxisAlignedBB(0.3125D, 0.0D, 0.6875D, 0.6875D, 1.0D, 1.0D);
	private static final AxisAlignedBB AABB_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.3125D, 0.3125D, 1.0D, 0.6875D);
	
	public Wall_DirtWall() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
		
		setHardness(2.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);

		setDefaultState(this.blockState.getBaseState()
				.withProperty(NORTH, false)
				.withProperty(EAST, false)
				.withProperty(SOUTH, false)
				.withProperty(WEST, false)
				.withProperty(STAGE_0_1, Integer.valueOf(0)));
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);

		if (itemstack.isEmpty()) {
			if (playerIn.isSneaking()) {
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(STAGE_0_1), 3); }
			
			if (!playerIn.isSneaking()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn); }
			return true;
		}
		return false;
	}
	
	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = this.getActualState(state, source, pos);
		return BOUNDING_BOXES[getBoundingBoxIdx(state)];
	}

	private static int getBoundingBoxIdx(IBlockState state) {
		int i = 0;
		if (((Boolean)state.getValue(NORTH)).booleanValue()) { i |= 1 << EnumFacing.NORTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(EAST)).booleanValue()) { i |= 1 << EnumFacing.EAST.getHorizontalIndex(); }
		if (((Boolean)state.getValue(SOUTH)).booleanValue()) { i |= 1 << EnumFacing.SOUTH.getHorizontalIndex(); }
		if (((Boolean)state.getValue(WEST)).booleanValue()) { i |= 1 << EnumFacing.WEST.getHorizontalIndex(); }
		
		return i;
	}
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, 
			@Nullable Entity entityIn, boolean isActualState) {
		
		if (!isActualState) { state = state.getActualState(worldIn, pos); }

		addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_CENTER);

		if (((Boolean)state.getValue(NORTH)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_NORTH); }

		if (((Boolean)state.getValue(EAST)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_EAST); }

		if (((Boolean)state.getValue(SOUTH)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_SOUTH); }

		if (((Boolean)state.getValue(WEST)).booleanValue()) {
			addCollisionBoxToList(pos, entityBox, collidingBoxes, AABB_WEST); }
	}
	
	
	/* Connect the blocks. */
	public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, pos, facing);
		Block block = iblockstate.getBlock();
		boolean flag = (block instanceof Base_Wall || block instanceof Wall_DirtWall || block instanceof Base_WallKawara || block instanceof Wall_Sama ||
				block instanceof Base_GlassDoor || block instanceof GlassDoorHalf || block instanceof GlassDoorHalf_seasonal || block instanceof BlockWall ||
				block instanceof BaseShouji || block instanceof BaseShouji_Win || block instanceof ShoujiHalf || block instanceof ShoujiHalf_seasonal ||
				block instanceof BaseFusuma || block instanceof BaseFusuma_B || block instanceof BaseWindow || block instanceof BaseWindowB ||
				block instanceof BaseWindowTall_Bottom || block instanceof BaseWindowTall_Top ||block instanceof BaseWindowTall ||
				block instanceof BlockFenceGate || block instanceof BlockWall || block instanceof BlockPane);
		return !isExcepBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID || flag;
	}
	
	protected static boolean isExcepBlockForAttachWithPiston(Block blockIn) {
		return Block.isExceptBlockForAttachWithPiston(blockIn) || blockIn == Blocks.BARRIER || 
				blockIn == Blocks.MELON_BLOCK || blockIn == Blocks.PUMPKIN || blockIn == Blocks.LIT_PUMPKIN;
	}
	
	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return canConnectTo(world, pos.offset(facing), facing.getOpposite());
	}

	private boolean canWallConnectTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		BlockPos other = pos.offset(facing);
		Block block = world.getBlockState(other).getBlock();
		return block.canBeConnectedTo(world, other, facing.getOpposite()) || canConnectTo(world, other, facing.getOpposite());
	}
	
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, canWallConnectTo(worldIn, pos, EnumFacing.NORTH))
					.withProperty(EAST, canWallConnectTo(worldIn, pos, EnumFacing.EAST))
					.withProperty(SOUTH, canWallConnectTo(worldIn, pos, EnumFacing.SOUTH))
					.withProperty(WEST, canWallConnectTo(worldIn, pos, EnumFacing.WEST));
	}
	
	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_1, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_1)).intValue();
	}

	@Override
	public boolean isSideSolid(IBlockState baseState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		if (side == EnumFacing.UP) { return true; }
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, SOUTH, WEST, STAGE_0_1 });
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
		stack.add(new ItemStack(Items_Wablock.DIRTWALL_WALL, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Wablock.DIRTWALL_WALL, 1, 0);
	}
	
}
