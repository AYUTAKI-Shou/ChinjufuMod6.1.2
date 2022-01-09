package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Corn_Top extends BlockCrops {

	public static final String ID = "block_vege_corn_top";

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.499D, 0.0D, 0.499D, 0.501D, 0.01D, 0.501D),
			new AxisAlignedBB(0.499D, 0.0D, 0.499D, 0.501D, 0.01D, 0.501D),
			new AxisAlignedBB(0.499D, 0.0D, 0.499D, 0.501D, 0.01D, 0.501D),
			new AxisAlignedBB(0.499D, 0.0D, 0.499D, 0.501D, 0.01D, 0.501D),
			new AxisAlignedBB(0.499D, 0.0D, 0.499D, 0.501D, 0.01D, 0.501D),
			new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D),
			new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.75D, 0.9375D),
			new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 1.0D, 0.9375D)};

	public Corn_Top() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
		setSoundType(SoundType.PLANT);

		setTickRandomly(false);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return false;
	}

	protected boolean canSustainBush(IBlockState state) {
		return state.getBlock() == Crop_Blocks.CORN;
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_CORN;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.FOOD_CORN;
	}

	/*キャベツ1, とうもろこし1. 白菜1. たまねぎ4. 米1. 大豆2. ほうれん草1. トマト4*/
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state) {
		int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		int j = this.getMaxAge();

		if (i > j) { i = j; }

		worldIn.setBlockState(pos, this.withAge(i));
		worldIn.setBlockState(pos.down(), Crop_Blocks.CORN.getDefaultState().withProperty(Corn_Top.AGE, Integer.valueOf(i)));
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** Top側のドロップは空気ブロックにしてある為、Bot側のドロップを有効にする **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Crop_Blocks.CORN) {

			if (playerIn.capabilities.isCreativeMode) { worldIn.setBlockToAir(pos); }
			worldIn.destroyBlock(pos.down(), false);
		}
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
