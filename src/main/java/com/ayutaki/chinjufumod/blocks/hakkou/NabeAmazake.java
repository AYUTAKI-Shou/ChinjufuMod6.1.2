package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

public class NabeAmazake extends BaseNabe {

	public NabeAmazake(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_1_4);

		if (item == Items_Teatime.YUNOMI) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTeaFill(worldIn, pos);

			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.AMAZAKEGLASS)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.AMAZAKEGLASS))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.AMAZAKEGLASS), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.with(BaseNabe.STAGE_1_4, Integer.valueOf(i + 1))); }
			if (i == 4) {
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState().with(H_FACING, state.get(H_FACING))
						.with(COOK, state.get(COOK)).with(DOWN, state.get(DOWN))
						.with(Nabe_kara.STAGE_1_4, Integer.valueOf(2))); } }
		
		if (item != Items_Teatime.YUNOMI) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.get(STAGE_1_4);
		return (i == 1)? new ItemStack(Items_Teatime.NABEAMAZAKE) : new ItemStack(Items_Teatime.NABE_kara);
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (inWater(state, worldIn, pos)) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
					.with(H_FACING, state.get(H_FACING))
					.with(COOK, state.get(COOK))
					.with(DOWN, state.get(DOWN))
					.with(Nabe_kara.STAGE_1_4, Integer.valueOf(2))
					.with(Nabe_kara.WATERLOGGED, state.get(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_food_nabeaz_1")).applyTextStyle(TextFormatting.GRAY));
	}

}
