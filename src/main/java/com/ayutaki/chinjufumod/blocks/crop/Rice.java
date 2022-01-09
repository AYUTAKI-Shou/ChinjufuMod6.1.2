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

public class Rice extends BlockCrops {

	public static final String ID = "block_vege_rice";

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.125D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.3125D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.4375D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.625D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.75D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.9375D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.9375D, 0.875D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.9375D, 0.875D)};

	public Rice() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	@Override
	protected Item getSeed() {
		return Items_Teatime.SEEDS_RICE;
	}

	@Override
	protected Item getCrop() {
		return Items_Teatime.INE;
	}

	/*キャベツ1, とうもろこし1. 白菜1. たまねぎ4. 米1. 大豆2. ほうれん草1. トマト4*/
	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

}
