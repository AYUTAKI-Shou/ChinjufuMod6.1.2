package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.ExperienceOrbEntity;
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

public class TaruY_Budoushu extends BaseTaru_Yoh {

	/* 1,2,3=未発酵、4,5=ワイン、6=熟成ワイン 進行が早いため6段階へ */
	public TaruY_Budoushu(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_6);

		/** Too early to collect **/
		if (i <= 3) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 3) {
			if (item == Items_Teatime.SAKEBOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundSakeBottleFill(worldIn, pos);
				
				if (i == 4 || i == 5) {
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.WINEBOT)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.WINEBOT))) {
						playerIn.drop(new ItemStack(Items_Teatime.WINEBOT), false); } }
		
				if (i == 6) {
					if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.JUKUWINEBOT)); }
					else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.JUKUWINEBOT))) {
						playerIn.drop(new ItemStack(Items_Teatime.JUKUWINEBOT), false); } }
				
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
				worldIn.setBlock(pos, Hakkou_Blocks.COCOA_TARU.defaultBlockState()
						.setValue(AXIS, state.getValue(AXIS)).setValue(BaseTaru_Yoh.STAGE_1_6, Integer.valueOf(6)), 3);
			}
			
			if (item != Items_Teatime.SAKEBOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_1_6);

		if (i != 6 && rand.nextInt(6) == 0) {
			worldIn.setBlock(pos, state.setValue(STAGE_1_6, Integer.valueOf(i + 1)), 3); }

		else { }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.BUDOUSHU_TARU);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_taru_budoushu")).withStyle(TextFormatting.GRAY));
	}

}
