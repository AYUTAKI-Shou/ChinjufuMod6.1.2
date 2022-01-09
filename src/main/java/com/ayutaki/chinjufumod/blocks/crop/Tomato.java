package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Tomato extends BlockCrops {

	public static final String ID = "block_vege_tomato";

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.0625D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.125D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.1875D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.3125D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.4375D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.5625D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.6875D, 0.9375D),
																				new AxisAlignedBB(0.0625D, -0.0625D, 0.0625D, 0.9375D, 0.875D, 0.9375D)};

	public Tomato() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_TOMATO;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.FOOD_TOMATO;
	}

	/*キャベツ1, とうもろこし1. 白菜1. たまねぎ4. 米1. 大豆2. ほうれん草1. トマト4*/
	@Override
	public int quantityDropped(Random rand) {
		return 4;
	}

}
