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

public class Tree_Kaede extends Tree {

	private static final BlockState KAEDE_LOG = Wood_Blocks.KAEDE_log.getDefaultState();
	private static final BlockState KAEDE_LEAVES = Wood_Blocks.KAEDE_leaf.getDefaultState();

	public static final TreeFeatureConfig KAEDE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.KAEDE_nae).build();

	public static final TreeFeatureConfig KAEDE_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(KAEDE_LOG),
			new SimpleBlockStateProvider(KAEDE_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.KAEDE_nae).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return randomIn.nextInt(50) == 0 ? TreeFeature.FANCY_TREE.withConfiguration(KAEDE_FANCY_CONFIG) : TreeFeature.NORMAL_TREE.withConfiguration(KAEDE_CONFIG);
	}

}
