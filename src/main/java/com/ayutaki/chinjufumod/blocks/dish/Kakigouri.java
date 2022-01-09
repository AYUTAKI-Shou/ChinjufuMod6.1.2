package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kakigouri extends BaseFood_Stage4Water {

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(6.4D, 0.0D, 6.4D, 9.6D, 5.0D, 9.6D);
	protected static final VoxelShape AABB_DOWN = Block.makeCuboidShape(6.4D, -8.0D, 6.4D, 9.6D, 0.1D, 9.6D);

	public Kakigouri(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_4);

		if (i != 4) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				CMEvents.soundEat(worldIn, pos);
	
				if (i == 1) {
					if (this == Seasonal_Blocks.KAKIGOURI_block) { playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 400, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_pink) { playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 600, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_red) { playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 600, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_yellow) { playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 600, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_green) { playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 600, 0));} }
	
				if (i == 2) {
					if (this == Seasonal_Blocks.KAKIGOURI_block) { playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 500, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_pink) { playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 780, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_red) { playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 780, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_yellow) { playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 780, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_green) { playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 780, 0)); } }
	
				if (i == 3) {
					if (this == Seasonal_Blocks.KAKIGOURI_block) { playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 600, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_pink) { playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 900, 0));}
					if (this == Seasonal_Blocks.KAKIGOURI_red) { playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 900, 0)); }
					if (this == Seasonal_Blocks.KAKIGOURI_yellow) { playerIn.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 900, 0));}
					if (this == Seasonal_Blocks.KAKIGOURI_green) { playerIn.addPotionEffect(new EffectInstance(Effects.HASTE, 900, 0)); } }
	
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		boolean flag= !((Boolean)state.get(DOWN)).booleanValue();
		return flag? AABB_BOX : AABB_DOWN;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.get(STAGE_1_4);

		if (this == Seasonal_Blocks.KAKIGOURI_block && i == 1) { return new ItemStack(Items_Seasonal.KAKIGOURI_block); }
		if (this == Seasonal_Blocks.KAKIGOURI_pink && i == 1) { return new ItemStack(Items_Seasonal.KAKIGOURI_pink); }
		if (this == Seasonal_Blocks.KAKIGOURI_red && i == 1) { return new ItemStack(Items_Seasonal.KAKIGOURI_red); }
		if (this == Seasonal_Blocks.KAKIGOURI_yellow && i == 1) { return new ItemStack(Items_Seasonal.KAKIGOURI_yellow); }
		if (this == Seasonal_Blocks.KAKIGOURI_green && i == 1) { return new ItemStack(Items_Seasonal.KAKIGOURI_green); }
		return new ItemStack(Items_Teatime.DRINKGLASS);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (state.get(STAGE_1_4) != 4) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
				CMEvents.soundSnowBreak(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(4))); }
			
			else { }
		}
		
		if (state.get(STAGE_1_4) == 4) { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kakigouri")).applyTextStyle(TextFormatting.GRAY));
	}

}
