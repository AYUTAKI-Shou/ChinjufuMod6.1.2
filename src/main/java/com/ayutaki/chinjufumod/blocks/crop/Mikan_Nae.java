package com.ayutaki.chinjufumod.blocks.crop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
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

public class Mikan_Nae extends Block {

	public static final String ID = "block_wood_mikan";

	/* Property 0 1 2 3 4、5 6 7 8 (9) 10 11 */
	public static final PropertyInteger STAGE_0_11 = PropertyInteger.create("stage", 0, 11);

	/*木完成*/
	public Mikan_Nae() {
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
		
		int i = ((Integer)state.getValue(STAGE_0_11)).intValue();

		if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.DIRT && worldIn
				.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(8) == 0) {

			if (i <= 8) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_11, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState()
						.withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(i + 1))); }

			if (i == 9) { }

			if (i == 10) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_11, Integer.valueOf(i + 1)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState()
						.withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(i + 1))); }

			if (i == 11) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_0_11, Integer.valueOf(6)));
				worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState()
						.withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(6))); }
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

		int i = ((Integer)state.getValue(STAGE_0_11)).intValue();

		/* Property 0 1 2 3 4、5 6 7 8 (9) 10 11 */
		
		/** Too early to collect **/
		if (i < 9) {
			if (item == Items.DYE && k == 15) {
				CMEvents.Consume_1Item(playerIn, hand);
				
				for(int n = 0; n < 15; ++n) {
					double d0 = worldIn.rand.nextGaussian() * 0.02D;
					double d1 = worldIn.rand.nextGaussian() * 0.02D;
					double d2 = worldIn.rand.nextGaussian() * 0.02D;
					worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + worldIn.rand.nextFloat(), pos.getY() +worldIn.rand.nextFloat(), pos.getZ() + worldIn.rand.nextFloat(), d0, d1, d2); }
				
				if (i < 8) {
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_11, Integer.valueOf(i + 2)));
					worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState()
							.withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(i + 2))); }
				
				if (i == 8) {
					worldIn.setBlockState(pos, state.withProperty(STAGE_0_11, Integer.valueOf(i + 1)));
					worldIn.setBlockState(pos.up(), Crop_Blocks.MIKAN_TOP.getDefaultState()
							.withProperty(Mikan_Top.STAGE_0_11, Integer.valueOf(i + 1))); }
			}
			
			if ((item == Items.DYE && k != 15) || item != Items.DYE) {
				if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (itemstack.isEmpty()) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
			}
		}
		
		if (i == 9) { CMEvents.soundTouchBlock(worldIn, pos); }

		/** Sleeping **/
		if (i > 9) { CMEvents.textIsSleeping(worldIn, pos, playerIn); }

		/** 'true' to not put anything on top. **/
		return true;
	}


	/* 土指定 */
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos fromPos) {

		if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.DIRT) {
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos); }

		else { }
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_0_11)).intValue();

		if (i == 0) { return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.75D, 0.8125D); }
		if (i == 1) { return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 1.0D, 0.8125D); }
		if (i == 2) { return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.25D, 0.875D); }
		if (i == 3) { return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.5D, 0.875D); }
		if (i == 4) { return new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.75D, 0.9375D); }
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Data value */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_11, Integer.valueOf(meta));
	}

	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_11)).intValue();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_11 });
	}

	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return (11 - ((Integer)blockState.getValue(STAGE_0_11)).intValue()) * 2;
	}

	/* 描写指定 */
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
		if (worldIn.getBlockState(pos.up()).getBlock() == Crop_Blocks.MIKAN_TOP) {
			worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/* Property 0 1 2 3 4、5 6 7 8 (9) 10 11 */
		int i = ((Integer)state.getValue(STAGE_0_11)).intValue();

		if (i == 9 || i == 10) { stack.add(new ItemStack(Items_Teatime.MIKAN, 3, 0)); }
		if (i != 9 && i != 10) { stack.add(new ItemStack(Items_Teatime.MIKAN, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.MIKAN, 1, 0);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
