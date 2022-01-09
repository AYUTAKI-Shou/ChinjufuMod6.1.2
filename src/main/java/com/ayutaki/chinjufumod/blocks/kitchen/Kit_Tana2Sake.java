package com.ayutaki.chinjufumod.blocks.kitchen;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Kit_Tana2Sake extends Base_WineTana {

	public Kit_Tana2Sake(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_4);

		if (item != Items_Teatime.SAKEBOT) {
			if (itemstack.isEmpty()) {
				playerIn.inventory.add(new ItemStack(Items_Teatime.SAKEBOT));
				CMEvents.soundTakeSakeBottle(worldIn, pos);
	
				if (i != 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i - 1)), 3); }
				if (i == 1) { worldIn.setBlock(pos, Kitchen_Blocks.WINE_TANA.defaultBlockState().setValue(H_FACING, state.getValue(H_FACING)), 3); } }

			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.SAKEBOT) {
			if (i != 4) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundDishPlace(worldIn, pos);
				
				worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 4) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.WINE_TANA);
	}

}
