package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Tana_Konbu extends BaseTana_Stage05 {

	/* Collision */
	protected static final VoxelShape AABB_TANA = VoxelShapes.or(Block.box(0.0D, 2.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 2.0D, 2.0D, 2.0D),
			Block.box(0.0D, 0.0D, 14.0D, 2.0D, 2.0D, 16.0D),
			Block.box(14.0D, 0.0D, 0.0D, 16.0D, 2.0D, 2.0D),
			Block.box(14.0D, 0.0D, 14.0D, 16.0D, 2.0D, 16.0D));

	public Tana_Konbu(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_5);

		/** Too early to collect **/
		if (i != 5) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i == 5) {
			if (item == Items.GLASS_BOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.DASHI_bot_1)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.DASHI_bot_1))) {
					playerIn.drop(new ItemStack(Items_Teatime.DASHI_bot_1), false); }
	
				worldIn.setBlock(pos, Hakkou_Blocks.HAKKOU_TARU.defaultBlockState().setValue(Taru_Hakkou.STAGE_0_5, Integer.valueOf(3)), 3); }
			
			if (item != Items.GLASS_BOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_TANA;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Hakkou_Blocks.HAKKOU_TARU.defaultBlockState()
					.setValue(Taru_Hakkou.STAGE_0_5, Integer.valueOf(3))
					.setValue(Taru_Hakkou.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }

		else { }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.getValue(STAGE_0_5);

		if (i < 5 && !hasWater(worldIn, pos) && rand.nextInt(4) == 0) {
				worldIn.setBlock(pos, state.setValue(STAGE_0_5, Integer.valueOf(i + 1)), 3); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_taru_konbu")).withStyle(TextFormatting.GRAY));
	}

}
