package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BannerItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.BannerTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Mizuoke_full extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.box(5.0D, 0.5D, 5.0D, 11.0D, 1.5D, 11.0D);
	protected static final VoxelShape BODY = VoxelShapes.or(BASE, 
			Block.box(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 5.0D),
			Block.box(4.0D, 0.0D, 11.0D, 12.0D, 9.0D, 12.0D),
			Block.box(4.0D, 0.0D, 5.0D, 5.0D, 9.0D, 11.0D),
			Block.box(11.0D, 0.0D, 5.0D, 12.0D, 9.0D, 11.0D));
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BODY, 
			Block.box(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.box(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.box(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BODY, 
			Block.box(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.box(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.box(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));

	public Mizuoke_full(AbstractBlock.Properties properties) {
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

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER))
				.setValue(H_FACING, context.getHorizontalDirection().getOpposite())
				.setValue(STAGE_1_2, Integer.valueOf(1));
	}

	/* RightClick Action Cauldron */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_1_2);
		boolean mode = playerIn.abilities.instabuild;

		/** バケツ **/
		if (item == Items.BUCKET && !state.getValue(WATERLOGGED)) {
			
			if (!mode) { itemstack.shrink(1);
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items.WATER_BUCKET)); }
				else if (!playerIn.inventory.add(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.drop(new ItemStack(Items.WATER_BUCKET), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(2)), 3); }

			return ActionResultType.SUCCESS;
		}

		else if (item == Items_Teatime.MIZUOKE && !state.getValue(WATERLOGGED)) {
			
			if (!mode) { itemstack.shrink(1);
				if (itemstack.isEmpty()) { playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full)); }
				else if (!playerIn.inventory.add(new ItemStack(Items_Teatime.MIZUOKE_full))) {
					playerIn.drop(new ItemStack(Items_Teatime.MIZUOKE_full), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(1)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(2)), 3); }

			return ActionResultType.SUCCESS;
		}

		/** ガラス瓶 **/
		else if (item == Items.GLASS_BOTTLE && !state.getValue(WATERLOGGED)) {

			if (!mode) {
				itemstack.shrink(1);
				ItemStack itemstack4 = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
				if (itemstack.isEmpty()) { playerIn.setItemInHand(hand, itemstack4); }
				else if (!playerIn.inventory.add(itemstack4)) { playerIn.drop(itemstack4, false); }
				else if (playerIn instanceof ServerPlayerEntity) {
					((ServerPlayerEntity)playerIn).refreshContainer(playerIn.inventoryMenu); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

			if (i != 1) {
				worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
						.setValue(H_FACING, state.getValue(H_FACING))
						.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

			return ActionResultType.SUCCESS;
		}

		/** 洗う **/
		else {

			if (item instanceof IDyeableArmorItem) {
				IDyeableArmorItem idyeablearmoritem = (IDyeableArmorItem)item;
				if (idyeablearmoritem.hasCustomColor(itemstack) && !worldIn.isClientSide) {
					idyeablearmoritem.clearColor(itemstack);

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					playerIn.awardStat(Stats.CLEAN_ARMOR);
				}
				return ActionResultType.SUCCESS;
			} //鎧

			if (item instanceof BannerItem) {
				if (BannerTileEntity.getPatternCount(itemstack) > 0 && !worldIn.isClientSide) {
					ItemStack itemstack2 = itemstack.copy();
					itemstack2.setCount(1);
					BannerTileEntity.removeLastPattern(itemstack2);
					playerIn.awardStat(Stats.CLEAN_BANNER);
					
					if (!mode) { itemstack.shrink(1); }
					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					if (itemstack.isEmpty()) { playerIn.setItemInHand(hand, itemstack2); }
					else if (!playerIn.inventory.add(itemstack2)) { playerIn.drop(itemstack2, false); }
					else if (playerIn instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)playerIn).refreshContainer(playerIn.inventoryMenu); }
				}
				return ActionResultType.SUCCESS;
			} //旗

			if (item instanceof BlockItem) {
				Block block = ((BlockItem)item).getBlock();
				if (block instanceof ShulkerBoxBlock && !worldIn.isClientSide()) {
					ItemStack itemstack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
					if (itemstack.hasTag()) { itemstack1.setTag(itemstack.getTag().copy()); }

					playerIn.setItemInHand(hand, itemstack1);
					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

					if (i != 1) {
						worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

					playerIn.awardStat(Stats.CLEAN_SHULKER_BOX);
					return ActionResultType.SUCCESS;
				}
				else {
					return ActionResultType.CONSUME;
				}
			} //シェルカー

			if (item instanceof Base_ItemHake) {

				if (!mode) { itemstack.shrink(1); }
				CMEvents.soundWaterUse(worldIn, pos);

				if (i == 1) {
					worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(3)), 3); }

				if (i != 1) {
					worldIn.setBlock(pos, Hakkou_Blocks.MIZUOKE.defaultBlockState()
							.setValue(H_FACING, state.getValue(H_FACING))
							.setValue(Mizuoke.STAGE_1_4, Integer.valueOf(4)), 3); }

				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }

				return ActionResultType.SUCCESS;
			} //色筆

		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}


	/* TickRandom */
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }
		
		if (true) { worldIn.getBlockTicks().scheduleTick(pos, this, 300); }
		
		return super.updateShape(state, facing, facingState, worldIn, pos, facingPos);
	}
	
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getBlockTicks().scheduleTick(pos, this, 300);
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_1_2);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!state.getValue(WATERLOGGED)) {
			
			if (rain(worldIn, pos)) {
				if (i == 1) { 
					worldIn.getBlockTicks().scheduleTick(pos, this, 300);
					worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(i + 1)), 3); }
				
				if (i != 1) { } }
			
			if (!rain(worldIn, pos)) { }
		}

		if (state.getValue(WATERLOGGED)) {
			
			if (i == 1) { 
				worldIn.getBlockTicks().scheduleTick(pos, this, 300);
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_1_2, Integer.valueOf(2)), 3); }
			
			if (i != 1) { } }
	}

	protected boolean rain(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos.above());
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIZUOKE_full);
	}

}
