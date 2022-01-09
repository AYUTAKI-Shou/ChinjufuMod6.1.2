package com.ayutaki.chinjufumod.blocks.kitchen;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.Block;
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

public class Kit_Tana2SakeJuku extends Base_WineTana {

	public Kit_Tana2SakeJuku(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_1_4);

		if (item != Items_Teatime.JUKUSAKEBOT) {
			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.JUKUSAKEBOT));
				CMEvents.soundTakeSakeBottle(worldIn, pos);
	
				if (i != 1) { worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i - 1))); }
				if (i == 1) { worldIn.setBlockState(pos, Kitchen_Blocks.WINE_TANA.getDefaultState().with(H_FACING, state.get(H_FACING))); } }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.JUKUSAKEBOT) {
			if (i != 4) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundDishPlace(worldIn, pos);
				
				worldIn.setBlockState(pos, state.with(STAGE_1_4, Integer.valueOf(i + 1))); }
			
			if (i == 4) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.WINE_TANA);
	}

}
