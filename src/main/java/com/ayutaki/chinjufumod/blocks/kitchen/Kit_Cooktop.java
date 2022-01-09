package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kit_Cooktop extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape TOP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(TOP, Block.box(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(TOP, Block.box(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Cooktop(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.getValue(H_FACING);

		switch (direction) {
		case NORTH :
		default : return AABB_NORTH;
		case SOUTH : return AABB_SOUTH;
		case EAST : return AABB_EAST;
		case WEST : return AABB_WEST;
		} // switch
	}

	/* blockstate の更新 */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 10);
		
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		int i = state.getValue(STAGE_1_3);

		if (!state.getValue(WATERLOGGED)) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				if (i == 1) {
					if (playerIn.isCrouching()) {
						worldIn.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
						worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(2)), 3); }
					
					if (!playerIn.isCrouching()) { CMEvents.textNotSneak(worldIn, pos, playerIn); } }
				
				if (i == 2) {
					worldIn.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
					worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3); } }
			
			/** Hand is not empty. **/
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (state.getValue(WATERLOGGED)) {
			
			if (itemstack.isEmpty() && i == 2) {
				worldIn.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3); }
			
			else { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Play Sound */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.getValue(STAGE_1_3);

		if (i == 2) {
			double d0 = (double)pos.getX();
			double d1 = (double)pos.getY();
			double d2 = (double)pos.getZ();

			if (rand.nextDouble() < 0.1D) {
				worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
		}
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void stepOn(World worldIn, BlockPos pos, Entity entity) {

		int px = pos.getX();
		int py = pos.getY();
		int pz = pos.getZ();

		BlockState state = worldIn.getBlockState(new BlockPos(px, py, pz));
		int i = state.getValue(STAGE_1_3);

		if (i == 2) {
			if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
				entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
			}
			super.stepOn(worldIn, pos, entity);
		}
	}

	/*TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 10);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_3);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i == 2) {
			if (state.getValue(WATERLOGGED)) { 
				worldIn.getBlockTicks().scheduleTick(pos, this, 10);
				
				CMEvents.soundFireExting(worldIn, pos);
				worldIn.playSound(null, pos, SoundEvents.WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
				worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(3)), 3); }
			
			if (!state.getValue(WATERLOGGED)) { }
		}
		
		if (i == 3) {
			worldIn.getBlockTicks().scheduleTick(pos, this, 10);
			worldIn.setBlock(pos, state.setValue(STAGE_1_3, Integer.valueOf(1)), 3); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kit_stove")).withStyle(TextFormatting.GRAY));
	}

}
