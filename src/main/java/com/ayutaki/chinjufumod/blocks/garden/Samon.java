package com.ayutaki.chinjufumod.blocks.garden;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Samon extends Block {

	/* Property */
	public static final IntegerProperty STAGE_0_7 = IntegerProperty.create("stage", 0, 7);

	public Samon(AbstractBlock.Properties properties) {
		super(properties);
		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState().setValue(STAGE_0_7, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		
		if (item == Items_Wadeco.KUMADE) {
			worldIn.playSound(playerIn, pos, SoundEvents.SAND_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			worldIn.setBlock(pos, state.cycle(Samon.STAGE_0_7), 3); }
		
		if (item != Items_Wadeco.KUMADE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.SHOVEL;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		if (this == Garden_Blocks.SAMON_B) { return new ItemStack(Items.GRAVEL); }
		return new ItemStack(Items.SAND);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_7);
	}

}
