package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Grape_Nae_3 extends BaseStage4_Face {

	/** 苗1、2、3、4 **/
	public static final String ID = "block_wood_grape_3";

	private static final AxisAlignedBB AABB_1_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, 0.0, 0.625, 1.4375, 1.0);
	private static final AxisAlignedBB AABB_1_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, 0.0, 0.625, 1.4375, 1.0);
	private static final AxisAlignedBB AABB_1_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, 0.0, 0.625, 1.4375, 1.0);
	private static final AxisAlignedBB AABB_1_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, 0.0, 0.625, 1.4375, 1.0);

	private static final AxisAlignedBB AABB_2_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.40625, 0.0, 0.1875, 0.65625, 1.0625, 1.0);
	private static final AxisAlignedBB AABB_2_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.40625, 0.0, 0.1875, 0.65625, 1.0625, 1.0);
	private static final AxisAlignedBB AABB_2_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.40625, 0.0, 0.1875, 0.65625, 1.0625, 1.0);
	private static final AxisAlignedBB AABB_2_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.40625, 0.0, 0.1875, 0.65625, 1.0625, 1.0);

	private static final AxisAlignedBB AABB_3_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.375, 0.0, 0.125, 0.6875, 1.1875, 1.0);
	private static final AxisAlignedBB AABB_3_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.375, 0.0, 0.125, 0.6875, 1.1875, 1.0);
	private static final AxisAlignedBB AABB_3_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.375, 0.0, 0.125, 0.6875, 1.1875, 1.0);
	private static final AxisAlignedBB AABB_3_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.375, 0.0, 0.125, 0.6875, 1.1875, 1.0);

	private static final AxisAlignedBB AABB_4_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.3125, 0.0, 0.0, 0.75, 1.3125, 1.0);
	private static final AxisAlignedBB AABB_4_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.3125, 0.0, 0.0, 0.75, 1.3125, 1.0);
	private static final AxisAlignedBB AABB_4_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.3125, 0.0, 0.0, 0.75, 1.3125, 1.0);
	private static final AxisAlignedBB AABB_4_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.3125, 0.0, 0.0, 0.75, 1.3125, 1.0);

	/*苗木*/
	public Grape_Nae_3() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);

		setTickRandomly(true);
	}

	/* 成長 */
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		if (!worldIn.isAreaLoaded(pos, 1)) return;

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.DIRT && worldIn
				.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(8) == 0) {

			if (i != 4) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_nae.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 1))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Crop_Blocks.BUDOUNOKI_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
		}
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k;
		k = itemstack.getMetadata();

		/** 1 → 3 、2 → 4、3 → 5、4 → 6 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (item == Items.DYE && k == 15) {
			CMEvents.Consume_1Item(playerIn, hand);

			for(int n = 0; n < 15; ++n) {
				double d0 = worldIn.rand.nextGaussian() * 0.02D;
				double d1 = worldIn.rand.nextGaussian() * 0.02D;
				double d2 = worldIn.rand.nextGaussian() * 0.02D;
				worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
			
			if (i <= 2) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_nae.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(i + 2))); }
			
			if (i == 3) {
				worldIn.setBlockState(pos, Crop_Blocks.BUDOUNOKI_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1))); }
			
			if (i == 4) {
				worldIn.setBlockState(pos, Crop_Blocks.BUDOUNOKI_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.BUDOUTOP_B.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2))); }
		}
		
		if ((item == Items.DYE && k != 15) || item != Items.DYE) {
			if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			
			if (itemstack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		EnumFacing direction = state.getValue(H_FACING);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		switch (direction) {
		case SOUTH:
			return (i == 1)? AABB_1_SOUTH : ((i == 2)? AABB_2_SOUTH : ((i == 3)? AABB_3_SOUTH : AABB_4_SOUTH));

		case EAST:
			return (i == 1)? AABB_1_EAST : ((i == 2)? AABB_2_EAST : ((i == 3)? AABB_3_EAST : AABB_4_EAST));

		case WEST:
			return (i == 1)? AABB_1_WEST : ((i == 2)? AABB_2_WEST : ((i == 3)? AABB_3_WEST : AABB_4_WEST));

		case NORTH:
		default:
			return (i == 1)? AABB_1_NORTH : ((i == 2)? AABB_2_NORTH : ((i == 3)? AABB_3_NORTH : AABB_4_NORTH));
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* 土指定 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {

		if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos); }

		else { }
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** Top側のドロップは空気ブロックにしてある為、Bot側のドロップを有効にする **/
		if (worldIn.getBlockState(pos.up()).getBlock() == Crop_Blocks.BUDOUTOP_nae) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.setBlockToAir(pos); }
			worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Teatime.BUDOUNOKI, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.BUDOUNOKI, 1, 0);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
