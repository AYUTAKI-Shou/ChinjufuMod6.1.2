package com.ayutaki.chinjufumod.blocks.crop;

import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class Sakura_me extends BlockCrops {

	public static final String ID = "block_tree_sakura_me";

	private static final AxisAlignedBB[] CROPS_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.1875D, 0.6875D),
																				new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.5D, 0.6875D),
																				new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5D, 0.75D),
																				new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.625D, 0.75D),
																				new AxisAlignedBB(0.3125D, 0.0D, 0.3125D, 0.6875D, 0.75D, 0.6875D),
																				new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.5625D, 0.8125D),
																				new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.8D, 0.875D),
																				new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D)};

	public Sakura_me() {
		super();
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROPS_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
	}

	/* 育ちきったら苗木を回収できる */
	@Override
	protected Item getSeed() {
		return Item.getItemFromBlock(Blocks.AIR);
	}

	@Override
	protected Item getCrop() {
		return Item.getItemFromBlock(Seasonal_Blocks.SAKURA_nae);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 1;
	}

}
