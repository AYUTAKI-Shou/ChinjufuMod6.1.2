package com.ayutaki.chinjufumod.blocks.dish;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Zundou4_Pasta extends BaseZundou_4Stage {

	/** 1=生パスタ水、2=生パスタ湯、3＝茹でパスタ水、4=茹でパスタ湯 **/
	public Zundou4_Pasta(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();

		int i = state.getValue(STAGE_1_4);
		/** 1=生パスタ水、2=生パスタ湯、3＝茹でパスタ水、4=茹でパスタ湯 **/
		
		if (item == Items_Teatime.SARA) {
			if (i == 3) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.PASTA_sara)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.PASTA_sara))) {
					playerIn.drop(new ItemStack(Items_Teatime.PASTA_sara), false); }
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_2Stage.STAGE_1_2, Integer.valueOf(1)), 3); }
	
			if (i == 4) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				/** Get EXP. **/
				worldIn.addFreshEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1));
	
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.PASTA_sara)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.PASTA_sara))) {
					playerIn.drop(new ItemStack(Items_Teatime.PASTA_sara), false); }
	
				worldIn.setBlock(pos, Dish_Blocks.ZUNDOU_SHIO.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(BaseZundou_2Stage.STAGE_1_2, Integer.valueOf(2)), 3); }
			
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.SARA) { CMEvents.textNotHave(worldIn, pos, playerIn); }

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* TickRandom */
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_4);
		/** 1=生パスタ水、2=生パスタ湯、3＝茹でパスタ水、4=茹でパスタ湯 **/

		if (isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 1200 + (20 * rand.nextInt(5)));
			
			if (i == 1) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(2)), 3); }
			if (i == 2 || i == 3) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(4)), 3); }
			if (i == 4) { } }

		if (!isCooking(worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 100);
			
			if (i == 1 || i == 3) { }
			if (i == 2) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(1)), 3); }
			if (i == 4) { worldIn.setBlock(pos, state.setValue(STAGE_1_4, Integer.valueOf(3)), 3); } }

		if (inWater(state, worldIn, pos)) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 60);
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlock(pos, Dish_Blocks.ZUNDOU.defaultBlockState()
					.setValue(H_FACING, state.getValue(H_FACING))
					.setValue(Zundou.STAGE_1_2, Integer.valueOf(2))
					.setValue(Zundou.WATERLOGGED, state.getValue(WATERLOGGED)), 3);
			this.dropRottenfood(worldIn, pos); }

		else { }
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_4);

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		if (isCooking(worldIn, pos)) {

			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.5F, 0.7F, false); }
		}

		if (i == 2 || i == 4) {
			if (rand.nextDouble() < 0.25D) {
				/** 種類, 座標x, y, z, 速度x, y, z **/
				worldIn.addParticle(ParticleTypes.POOF, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.ZUNDOU);
	}

}
