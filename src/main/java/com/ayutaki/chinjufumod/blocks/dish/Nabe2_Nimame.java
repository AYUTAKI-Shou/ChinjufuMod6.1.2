package com.ayutaki.chinjufumod.blocks.dish;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
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

public class Nabe2_Nimame extends BaseNabe_Stage2 {

	public Nabe2_Nimame(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_2);

		if (i != 1) {
			if (item == Items.BOWL) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.NIMAME)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.NIMAME))) {
					playerIn.drop(new ItemStack(Items_Teatime.NIMAME), false); }
	
				worldIn.setBlock(pos, Dish_Blocks.NABE_kara.defaultBlockState().setValue(Nabe_kara.H_FACING, state.getValue(H_FACING))
						.setValue(Nabe_kara.STAGE_1_4, Integer.valueOf(4)), 3); }
			
			if (item != Items.BOWL) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 1) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1200 + (20 * rand.nextInt(5)));
			worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.NABE_kara.defaultBlockState()
					.setValue(Nabe_kara.H_FACING, state.getValue(H_FACING))
					.setValue(Nabe_kara.STAGE_1_4, Integer.valueOf(4))
					.setValue(Nabe_kara.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_nabe")).withStyle(TextFormatting.GRAY));
		tooltip.add((new TranslationTextComponent("tips.block_food_nabenimame_b")).withStyle(TextFormatting.GRAY));
	}

}
