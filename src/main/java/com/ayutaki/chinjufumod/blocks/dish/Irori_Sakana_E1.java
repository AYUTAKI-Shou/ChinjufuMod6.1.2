package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Irori_Sakana_E1 extends BaseIrori_Sakana {

	public Irori_Sakana_E1(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_15);
		boolean waterlogged = state.getValue(WATERLOGGED);

		boolean hitnorth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() < 0.3D);
		boolean hitsouth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.7D);
		boolean hiteast = (hit.getLocation().x - (double)pos.getX() > 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);
		boolean hitwest = (hit.getLocation().x - (double)pos.getX() < 0.3D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);

		switch (i) {
		case 0 : //00 EEER 北東南西
		default :
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 1 : //01 EEEC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(12)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(10)), 3); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 2 : //02 EERE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(3)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 3 : //03 EERR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } } 
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); }
					
					if (hitsouth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 4 : //04 EERC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(2)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(13)), 3); }
					
					if (hitsouth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 5 : //05 EECE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, Blocks.AIR.defaultBlockState(), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(14)), 3); }
					
					if (hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }

					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(6)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 6 : //06 EECR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(15)), 3); }
					
					if (hitsouth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 7 : //07 EECC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(1)), 3); }

				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(5)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
								.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
					
					if (hitsouth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 8 : //08 EREE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hiteast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } } 
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
					
					if (hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 9 : //09 ERER 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hiteast || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hiteast || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 10 : //10 EREC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hiteast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(8)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }
					
					if (hiteast || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); }

					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(13)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 11 : //11 ERRE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hiteast || hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitnorth || hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }
					
					if (hiteast || hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(12)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 12 : //12 ERRR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (!hitnorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }
					
					if (!hitnorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 13 : //13 ERRC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hiteast || hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(11)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }
					
					if (!hitnorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 14 : //14 ERCE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hiteast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(8)), 3); }
				
				if (hitnorth || hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }
					
					if (hiteast || hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(15)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 15 : //15 ERCR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hiteast || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				
				if (!waterlogged) {
					if (hitnorth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_R1.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }
					
					if (!hitnorth) { CMEvents.soundTouchBlock(worldIn, pos); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
		} // switch
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_0_15);

		if (!inWater(state, worldIn, pos)) {
			if (isCooking(worldIn, pos, Direction.DOWN)) {
	
				if (i == 0) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(1)), 3); }//1 EEEC
	
				if (i == 2) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(5)), 3); }//5 EECE
	
				if (i == 3 || i == 4 || i == 6) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, state.setValue(STAGE_0_15, Integer.valueOf(7)), 3); }//7 EECC
	
				if (i == 8) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }//1 ECEE
	
				if (i == 9 || i == 10) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }//3 ECEC
	
				if (i == 11 || i == 14) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }//7 ECCE
	
				if (i == 12 || i == 13 || i == 15) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 1000);
					worldIn.setBlock(pos, Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
							.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }//9 ECCC
	
				else { }
			}
	
			if (!isCooking(worldIn, pos, Direction.DOWN)) { }
		}
		
		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			
			if (i == 12 || i == 13 ||i == 15) {
				this.dropRottenfood3(worldIn, pos);
				this.dropStick3(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 3 || i == 4 || i == 6 || i == 7 || i == 9 || i == 10 || i == 11 || i == 14) {
				this.dropRottenfood2(worldIn, pos);
				this.dropStick2(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 0 || i == 1 || i == 2 || i == 5 || i == 8) {
				this.dropRottenfood1(worldIn, pos);
				this.dropStick1(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
		}
	}
	
	protected void dropRottenfood1(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 1);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick1(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 1);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropRottenfood2(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 2);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick2(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 2);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropRottenfood3(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 3);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick3(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 3);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
}
