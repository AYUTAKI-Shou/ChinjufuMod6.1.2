package com.ayutaki.chinjufumod.blocks.wood;

import java.util.Random;

import com.ayutaki.chinjufumod.registry.Wood_Blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class Tree_AutumnOak extends Tree {

	private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState();
	private static final BlockState OAKKARE_LEAVES = Wood_Blocks.OAKKARE_leaf.getDefaultState();

	public static final TreeFeatureConfig OAKKARE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new BlobFoliagePlacer(2, 0)).baseHeight(4).heightRandA(3).foliageHeight(3).ignoreVines()
			.setSapling((IPlantable) Wood_Blocks.OAKKARE_nae).build();
	public static final TreeFeatureConfig OAKKARE_FANCY_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(OAK_LOG),
			new SimpleBlockStateProvider(OAKKARE_LEAVES),
			new BlobFoliagePlacer(0, 0)))
			.setSapling((IPlantable) Wood_Blocks.OAKKARE_nae).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		return randomIn.nextInt(20) == 0 ? TreeFeature.FANCY_TREE.withConfiguration(OAKKARE_FANCY_CONFIG) : TreeFeature.NORMAL_TREE.withConfiguration(OAKKARE_CONFIG);
	}

}
