package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Bottle_SakeJuku extends Base_Bottle {

	public Bottle_SakeJuku(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_5);

		if (i != 5) {
			if (item == Items_Teatime.DRINKGLASS) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundSakeGlassFill(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.JUKUSAKEGLASS)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.JUKUSAKEGLASS))) {
					playerIn.drop(new ItemStack(Items_Teatime.JUKUSAKEGLASS), false); }
	
				worldIn.setBlock(pos, state.setValue(Base_Bottle.STAGE_1_5, Integer.valueOf(i + 1)), 3); }
			
			if (item != Items_Teatime.DRINKGLASS) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}


	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		int i = state.getValue(STAGE_1_5);
		return (i == 1)? new ItemStack(Items_Teatime.JUKUSAKEBOT) : new ItemStack(Items_Teatime.SAKEBOTTLE);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_bot_sake")).withStyle(TextFormatting.GRAY));
	}

}
