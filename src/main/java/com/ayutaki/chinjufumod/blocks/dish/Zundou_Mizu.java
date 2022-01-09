package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Seasonal;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou_Mizu extends BaseZundou_2Stage {

	/** 1=水、2=湯 **/
	public Zundou_Mizu(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		int i = state.getValue(STAGE_1_2);
		/** 1=水、2=湯 **/

		/** 1=塩水、2=塩湯 **/
		if (item == Items_Teatime.SHIO) {
			if (i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 2) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		/** 1=灰汁水、2=灰汁湯 **/
		if (item == Items_Seasonal.WARAHAI) {
			if (i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 2) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_AKU.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
		}
		
		/** 出汁へ **/
		if (item == Items_Teatime.DASHI_bot_1) {
			if (i == 2) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.add(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.drop(new ItemStack(Items.GLASS_BOTTLE), false); }
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_DASHI.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(1)), 3); }
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		/** うどん **/
		if (item == Items_Teatime.UDON_nama) {
			if (i == 2) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_UDON.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_4Stage.STAGE_1_4, Integer.valueOf(2)), 3);
						/** 1=生うどん水、2=生うどん湯、3＝茹でうどん水、4=茹でうどん湯 **/ }
			
			/** Too early to use **/
			if (i != 2) { CMEvents.textEarlyUse(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.SHIO && item != Items_Seasonal.WARAHAI && item != Items_Teatime.DASHI_bot_1 && item != Items_Teatime.UDON_nama) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_2);

		if (isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1200 + (20 * rand.nextInt(5)));

			if (i == 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
			if (i != 1) { } }

		if (!isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100);

			if (i == 2) { worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(1)), 3); }
			if (i != 2) { } }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundBubble(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2))
					.setValue(Zundou.WATERLOGGED, state.getValue(WATERLOGGED)), 3); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_frypan")).withStyle(TextFormatting.GRAY));
	}

}
