package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
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

public class Pasta extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D);
	protected static final VoxelShape AABB_DOWN = Block.box(4.0D, -8.0D, 4.0D, 12.0D, 0.1D, 12.0D);

	public Pasta(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_4);

		if (i != 4) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (i == 1) {
					/** 採掘3600 1秒＝20 満腹は2で肉メモリの1個分 **/
					playerIn.addEffect(new EffectInstance(Effects.DIG_SPEED, 3600, 0));
					playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				if (i == 2) {
					/** 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
					playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
					playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				if (i == 3) {
					/** リジェネは3600 即時回復は0,0でよい 満腹は2で肉メモリの1個分 **/
					playerIn.addEffect(new EffectInstance(Effects.HEAL, 0, 0));
					playerIn.addEffect(new EffectInstance(Effects.REGENERATION, 3600, 0));
					playerIn.addEffect(new EffectInstance(Effects.SATURATION, 4, 0)); }
	
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_4);

		if (this == Dish_Blocks.PASTACHEESE && i == 1) { return new ItemStack(Items_Teatime.PASTACHEESE); }
		if (this == Dish_Blocks.PASTAKINOKO && i == 1) { return new ItemStack(Items_Teatime.PASTAKINOKO); }
		if (this == Dish_Blocks.PASTATOMATO && i == 1) { return new ItemStack(Items_Teatime.PASTATOMATO); }
		return new ItemStack(Items_Teatime.SARA);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
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