package com.ayutaki.chinjufumod.blocks.kamoislab;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage4_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_WallPanel;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Kamoi_DirtWall extends BaseStage4_FaceWater {

	public Kamoi_DirtWall(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		
		if (itemstack.isEmpty()) {
			if (playerIn.isCrouching()) {
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlock(pos, state.cycle(STAGE_1_4), 3);
				return ActionResultType.SUCCESS; }
			
			if (!playerIn.isCrouching()) {
				CMEvents.textNotSneak(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}

		return ActionResultType.PASS;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* Clone Item in Creative.*/
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {

		if (this == KamoiPlaster_Blocks.KAMOI_dirt_spru) { return new ItemStack(Items_WallPanel.PILLARSLAB_spru); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_bir) { return new ItemStack(Items_WallPanel.PILLARSLAB_bir); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_jun) { return new ItemStack(Items_WallPanel.PILLARSLAB_jun); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_aca) { return new ItemStack(Items_WallPanel.PILLARSLAB_aca); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_doak) { return new ItemStack(Items_WallPanel.PILLARSLAB_doak); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_sakura) { return new ItemStack(Items_Seasonal.PILLARSLAB_saku); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_kaede) { return new ItemStack(Items_Seasonal.PILLARSLAB_kae); }
		if (this == KamoiPlaster_Blocks.KAMOI_dirt_ichoh) { return new ItemStack(Items_Seasonal.PILLARSLAB_ich); }
		return new ItemStack(Items_WallPanel.PILLARSLAB_oak);
	}

}
