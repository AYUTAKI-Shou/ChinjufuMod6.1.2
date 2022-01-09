package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Corn extends BlockCrops {

	public static final String ID = "block_vege_corn";

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.0625D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.0625D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.4375D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.6875D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 1.0D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 1.0D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 1.0D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 1.0D, 0.9375D)};

	public Corn() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	@Override
	protected Item getSeed() {
		return Items.AIR;
	}

	@Override
	protected Item getCrop() {
		return Items.AIR;
	}

	/*キャベツ1, とうもろこし1. 白菜1. たまねぎ4. 米1. 大豆2. ほうれん草1. トマト4*/
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);

		if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
			int i = this.getAge(state);

			if (i < this.getMaxAge()) {
				float f = getGrowthChance(this, worldIn, pos);

				if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0)) {

					worldIn.setBlockState(pos, this.withAge(i + 1));
					worldIn.setBlockState(pos.up(), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i + 1)));

					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
				}
			}
		}
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();

		if (i > j) { i = j; }

		worldIn.setBlockState(pos, this.withAge(i));
		worldIn.setBlockState(pos.up(), Crop_Blocks.CORN_TOP.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i)));
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** Top側のドロップは空気ブロックにしてある為、Bot側のドロップを有効にする **/
		if (worldIn.getBlockState(pos.up()).getBlock() == Crop_Blocks.CORN_TOP) {

			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.up(), false); }
			worldIn.destroyBlock(pos.up(), true);
		}
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
