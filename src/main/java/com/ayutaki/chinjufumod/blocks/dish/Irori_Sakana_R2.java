package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
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

public class Irori_Sakana_R2 extends BaseIrori_Sakana {

	public Irori_Sakana_R2(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_15);
		boolean waterlogged = state.get(WATERLOGGED);

		boolean hitnorth = (hit.getHitVec().x - (double)pos.getX() > 0.3D) && (hit.getHitVec().x - (double)pos.getX() < 0.7D) && (hit.getHitVec().z - (double)pos.getZ() < 0.3D);
		boolean hitsouth = (hit.getHitVec().x - (double)pos.getX() > 0.3D) && (hit.getHitVec().x - (double)pos.getX() < 0.7D) && (hit.getHitVec().z - (double)pos.getZ() > 0.7D);
		boolean hiteast = (hit.getHitVec().x - (double)pos.getX() > 0.7D) && (hit.getHitVec().z - (double)pos.getZ() > 0.3D) && (hit.getHitVec().z - (double)pos.getZ() < 0.7D);
		boolean hitwest = (hit.getHitVec().x - (double)pos.getX() < 0.3D) && (hit.getHitVec().z - (double)pos.getZ() > 0.3D) && (hit.getHitVec().z - (double)pos.getZ() < 0.7D);

		switch (i) {
		case 0 : //00 RCRR 北東南西
		default :
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (!hiteast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hiteast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (!waterlogged) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 1 : //01 RCRC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hiteast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E2.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); }

				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (!waterlogged) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 2 : //02 RCCE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hiteast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }

				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(12)), 3); }
				
				if (hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hitwest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(3)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 3 : //03 RCCR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hiteast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }

				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (!waterlogged) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 4 : //04 RCCC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hiteast) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }

				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_R1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(14)), 3); }

				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(2)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
				if (!waterlogged) { CMEvents.soundTouchBlock(worldIn, pos); }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 5 : //05 CEEE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3); }
				
				if (!hitnorth) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (hitnorth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(14)), 3); }

					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(8)), 3); }

					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(6)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 6 : //06 CEER 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }
				
				if (hiteast || hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (hitnorth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(15)), 3); }

					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(9)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 7 : //07 CEEC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
				
				if (hiteast || hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(5)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (hitnorth || hitwest) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); }

					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(10)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 8 : //08 CERE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }
				
				if (hiteast || hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (hitnorth || hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }
						
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(9)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 9 : //09 CERR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); }
				
				if (hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 10 : //10 CERC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
				
				if (hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(8)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(3)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 11 : //11 CECE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); }
				
				if (hiteast || hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(5)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
	
				if (!waterlogged) {
					if (hitnorth || hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(4)), 3); }
					
					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(12)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 12 : //12 CECR 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); }
				
				if (hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }
				
				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(6)), 3); }
				
				if (hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(5)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;
			
		case 13 : //13 CECC 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7)), 3); }
				
				if (hiteast) { CMEvents.textNotHave(worldIn, pos, playerIn); }

				if (hitsouth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(7)), 3); }

				if (hitwest) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(11)), 3); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hiteast) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(6)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 14 : //14 CREE 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }
				
				if (hiteast) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitsouth || hitwest) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {
	
				if (!waterlogged) {
					if (hitnorth || hiteast) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(1)), 3); }

					if (hitwest) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(15)), 3); } }
				
				if (waterlogged) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		case 15 : //15 CRER 北東南西
			/** Take it. **/
			if (itemstack.isEmpty() && item != Items_Teatime.KUSHI_SAKANA) {
				if (hitnorth) {
					CMEvents.takeSakana(worldIn, pos, playerIn);
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_E1.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9)), 3); }
				
				if (hiteast || hitwest) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
				
				if (hitsouth) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
			
			/** Place it. **/
			if (!itemstack.isEmpty() && item == Items_Teatime.KUSHI_SAKANA) {

				if (!waterlogged) {
					if (!hitsouth) { CMEvents.soundTouchBlock(worldIn, pos); }
					
					if (hitsouth) {
						CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
						worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
								.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); } }
				
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

		int i = state.get(STAGE_0_15);

		if (!inWater(state, worldIn, pos)) {
			if (connectLitIrori(worldIn, pos, Direction.DOWN)) {
	
				if (i == 0 || i == 1 || i == 3 || i == 4) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(15))); } //15 CCCC
	
				if (i == 2) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(13))); } //13 CCCE
	
				if (i == 6) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(7))); } //7 CEEC
	
				if (i == 8) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(11))); } //11 CECE
	
				if (i == 9 || i == 10 || i == 12) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, state.with(STAGE_0_15, Integer.valueOf(13))); } //13 CECC
	
				if (i == 14) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(7))); } //7 CCEE
	
				if (i == 15) {
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, Dish_Blocks.IRORISAKANA_C.getDefaultState()
							.with(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(9))); } //9 CCEC
	
				else { }
			}
	
			if (!connectLitIrori(worldIn, pos, Direction.DOWN)) { }
		}
		
		if (inWater(state, worldIn, pos)) { 
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos); 
			
			if (i == 0 || i == 1 || i == 3 || i == 4) {
				this.dropRottenfood4(worldIn, pos);
				this.dropStick4(worldIn, pos);
				worldIn.destroyBlock(pos, false); }

			if (i == 2 || i == 9 || i == 10 || i == 12 || i == 13 || i == 15) {
				this.dropRottenfood3(worldIn, pos);
				this.dropStick3(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 6 || i == 7 || i == 8 || i == 11 || i == 14) {
				this.dropRottenfood2(worldIn, pos);
				this.dropStick2(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
			
			if (i == 5) {
				this.dropRottenfood1(worldIn, pos);
				this.dropStick1(worldIn, pos);
				worldIn.destroyBlock(pos, false); }
		}
	}

	protected void dropRottenfood1(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 1);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick1(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 1);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropRottenfood2(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 2);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick2(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 2);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropRottenfood3(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 3);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick3(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 3);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropRottenfood4(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items_Teatime.ROTTEN_FOOD, 4);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
	protected void dropStick4(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.STICK, 4);
		InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}
	
}
