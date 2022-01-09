package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Udon extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(5.8D, 0.0D, 5.8D, 10.2D, 3.0D, 10.2D);
	protected static final VoxelShape AABB_DOWN = Block.box(5.8D, -8.0D, 5.8D, 10.2D, 0.1D, 10.2D);

	public Udon(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		int i = state.getValue(STAGE_1_4);

		/** 肉うどん **/
		if (item == Items.COOKED_BEEF) {
			if (this == Dish_Blocks.UDON_SU && i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.UDON_NIKU.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(STAGE_1_4, Integer.valueOf(1)), 3); }
			
			if (this != Dish_Blocks.UDON_SU || i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** 月見うどん **/
		if (item == Items.EGG) {
			if (this == Dish_Blocks.UDON_SU && i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.UDON_TSUKIMI.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(DOWN, state.getValue(DOWN))
						.setValue(STAGE_1_4, Integer.valueOf(1)), 3); }
			
			if (this != Dish_Blocks.UDON_SU || i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item != Items.COOKED_BEEF && item != Items.EGG) {

			if (itemstack.isEmpty()) {
				if (i != 4) {
					
					CMEvents.soundEat(worldIn, pos);
					if (i == 1) {
						if (this == Dish_Blocks.UDON_SU) {
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
						if (this == Dish_Blocks.UDON_NIKU || this == Dish_Blocks.UDON_TSUKIMI) {
							/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 **/
							playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 3600, 0));
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); } }
		
					if (i == 2) {
						if (this == Dish_Blocks.UDON_SU) {
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
						if (this == Dish_Blocks.UDON_NIKU || this == Dish_Blocks.UDON_TSUKIMI) {
							/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
							playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); } }
		
					if (i == 3) {
						if (this == Dish_Blocks.UDON_SU) {
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 2, 0)); }
		
						if (this == Dish_Blocks.UDON_NIKU || this == Dish_Blocks.UDON_TSUKIMI) {
							/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
							playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
							playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0));
							playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 3600, 0)); } }
		
					worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
				
				if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_4);

		if (this == Dish_Blocks.UDON_SU && i == 1) { return new ItemStack(Items_Teatime.UDON_SU); }
		if (this == Dish_Blocks.UDON_NIKU && i == 1) { return new ItemStack(Items_Teatime.UDON_NIKU); }
		if (this == Dish_Blocks.UDON_TSUKIMI && i == 1) { return new ItemStack(Items_Teatime.UDON_TSUKIMI); }
		return new ItemStack(Items_Teatime.DONBURI);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);
		
		if (i != 4) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 60);
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3);
				this.dropRottenfood(worldIn, pos); }
			
			else { } }
		
		if (i == 4) { }
	}

}
