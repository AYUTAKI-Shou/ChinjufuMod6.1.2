package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class Tree_Ichoh extends Tree {

	private static final BlockState ICHOH_LOG = Wood_Blocks.ICHOH_log.getDefaultState();
	private static final BlockState ICHOH_LEAVES = Wood_Blocks.ICHOH_leaf.getDefaultState();

	public static final TreeFeatureConfig ICHOH_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(5).heightRandA(3).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.ICHOH_nae).build();

	public static final TreeFeatureConfig ICHOH_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(ICHOH_LOG),
			new SimpleBlockStateProvider(ICHOH_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.ICHOH_nae).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return randomIn.nextInt(20) == 0 ? TreeFeature.FANCY_TREE.withConfiguration(ICHOH_FANCY_CONFIG) : TreeFeature.NORMAL_TREE.withConfiguration(ICHOH_CONFIG);
	}

}
