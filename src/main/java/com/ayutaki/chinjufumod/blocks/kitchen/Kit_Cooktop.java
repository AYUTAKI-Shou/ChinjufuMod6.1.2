package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.base.BaseStage3_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Kit_Cooktop extends BaseStage3_FaceWater {

	/* Collision */
	protected static final VoxelShape TOP = Block.makeCuboidShape(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(TOP, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(TOP, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(TOP, Block.makeCuboidShape(0.0D, 0.0D, 1.0D, 16.0D, 15.0D, 15.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(TOP, Block.makeCuboidShape(1.0D, 0.0D, 0.0D, 15.0D, 15.0D, 16.0D));

	public Kit_Cooktop(Block.Properties properties) {
		super(properties);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		Direction direction = state.get(H_FACING);

		switch (direction) {
		case NORTH :
		default : return AABB_NORTH;
		case SOUTH : return AABB_SOUTH;
		case EAST : return AABB_EAST;
		case WEST : return AABB_WEST;
		} // switch
	}

	/* 明るさの変化 */
	public int getLightValue(BlockState state) {
		int i = state.get(STAGE_1_3);
		return (i == 2)? 14 : 0;
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(STAGE_1_3);

		if (!state.get(WATERLOGGED)) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				if (i == 1) {
					if (playerIn.isSneaking()) {
						worldIn.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
						worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(2))); }
					
					if (!playerIn.isSneaking()) {
						CMEvents.textNotSneak(worldIn, pos, playerIn); } }
				
				if (i == 2) {
					worldIn.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
					worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(3))); }
			}
			
			/** Hand is not empty. **/
			if (!itemstack.isEmpty()) {
				CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (state.get(WATERLOGGED)) {
			
			if (itemstack.isEmpty() && i == 2) {
				worldIn.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
				worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(3)), 3); }
			
			else { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		}

		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Play Sound */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
		int i = state.get(STAGE_1_3);

		if (i == 2) {
			double d0 = (double)pos.getX();
			double d1 = (double)pos.getY();
			double d2 = (double)pos.getZ();

			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
		}
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entity) {

		int px = pos.getX();
		int py = pos.getY();
		int pz = pos.getZ();

		BlockState state = worldIn.getBlockState(new BlockPos(px, py, pz));
		int i = state.get(STAGE_1_3);

		if (i == 2) {
			if (!entity.isImmuneToFire() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
				entity.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
			}
			super.onEntityWalk(worldIn, pos, entity);
		}
	}

	/* 窒息 */
	@Override
	public boolean causesSuffocation(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* 立方体 */
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	/* モブ湧き */
	@Override
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
		return false;
	}

	/*時間経過 */
	@Override
	public int tickRate(IWorldReader world) {
		return 10;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_3);
		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (i == 2) {
			if (state.get(WATERLOGGED)) {
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
				
				CMEvents.soundFireExting(worldIn, pos);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.8F);
				worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(3))); }
			
			if (!state.get(WATERLOGGED)) { }
		}
				
		if (i == 3) {
			worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
			worldIn.setBlockState(pos, state.with(STAGE_1_3, Integer.valueOf(1))); }

		else { }
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_kit_stove")).applyTextStyle(TextFormatting.GRAY));
	}

}
