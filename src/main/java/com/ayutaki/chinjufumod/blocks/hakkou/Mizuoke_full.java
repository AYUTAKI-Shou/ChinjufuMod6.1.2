package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.Random;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
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
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Mizuoke_full extends BaseStage2_FaceWater {

	/* Collision */
	protected static final VoxelShape BASE = Block.makeCuboidShape(5.0D, 0.5D, 5.0D, 11.0D, 1.5D, 11.0D);
	protected static final VoxelShape BODY = VoxelShapes.or(BASE, 
			Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 5.0D),
			Block.makeCuboidShape(4.0D, 0.0D, 11.0D, 12.0D, 9.0D, 12.0D),
			Block.makeCuboidShape(4.0D, 0.0D, 5.0D, 5.0D, 9.0D, 11.0D),
			Block.makeCuboidShape(11.0D, 0.0D, 5.0D, 12.0D, 9.0D, 11.0D));
	
	protected static final VoxelShape AABB_SOUTH = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.makeCuboidShape(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.makeCuboidShape(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_WEST = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.makeCuboidShape(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.makeCuboidShape(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));
	protected static final VoxelShape AABB_NORTH = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(3.5D, 13.0D, 7.5D, 12.5D, 14.0D, 8.5D),
			Block.makeCuboidShape(4.0D, 9.0D, 7.0D, 5.0D, 15.0D, 9.0D),
			Block.makeCuboidShape(11.0D, 9.0D, 7.0D, 12.0D, 15.0D, 9.0D));
	protected static final VoxelShape AABB_EAST = VoxelShapes.or(BODY, 
			Block.makeCuboidShape(7.5D, 13.0D, 3.5D, 8.5D, 14.0D, 12.5D),
			Block.makeCuboidShape(7.0D, 9.0D, 4.0D, 9.0D, 15.0D, 5.0D),
			Block.makeCuboidShape(7.0D, 9.0D, 11.0D, 9.0D, 15.0D, 12.0D));

	public Mizuoke_full(Block.Properties properties) {
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

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
				.with(STAGE_1_2, Integer.valueOf(1));
	}

	/* 右クリック操作 Cauldron */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_1_2);
		boolean mode = playerIn.abilities.isCreativeMode;

		/** バケツ **/
		if (item == Items.BUCKET && !state.get(WATERLOGGED)) {
			if (!mode) {
				itemstack.shrink(1);
				if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(2))); }

			return ActionResultType.SUCCESS;
		}

		else if (item == Items_Teatime.MIZUOKE && !state.get(WATERLOGGED)) {
			if (!mode) {
				itemstack.shrink(1);
				if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); } }
			if (mode) { }

			CMEvents.soundBucketFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(2))); }

			return ActionResultType.SUCCESS;
		}

		/** ガラス瓶 **/
		else if (item == Items.GLASS_BOTTLE && !state.get(WATERLOGGED)) {

			if (!mode) {
				itemstack.shrink(1);

				ItemStack itemstack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
				if (itemstack.isEmpty()) { playerIn.setHeldItem(hand, itemstack4); }
				else if (!playerIn.inventory.addItemStackToInventory(itemstack4)) { playerIn.dropItem(itemstack4, false); }
				else if (playerIn instanceof ServerPlayerEntity) {
					((ServerPlayerEntity)playerIn).sendContainerToPlayer(playerIn.container); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(3))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
						.with(H_FACING, state.get(H_FACING))
						.with(Mizuoke.STAGE_1_4, Integer.valueOf(4))); }

			return ActionResultType.SUCCESS;
		}

		/** 洗う **/
		else {

			if (item instanceof IDyeableArmorItem) {
				IDyeableArmorItem idyeablearmoritem = (IDyeableArmorItem)item;
				if (idyeablearmoritem.hasColor(itemstack) && !worldIn.isRemote) {
					idyeablearmoritem.removeColor(itemstack);

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(3))); }

					if (i != 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(4))); }

					playerIn.addStat(Stats.CLEAN_ARMOR);
				}
				return ActionResultType.SUCCESS;
			} //鎧

			if (item instanceof BannerItem) {
				if (BannerTileEntity.getPatterns(itemstack) > 0 && !worldIn.isRemote) {
					ItemStack itemstack2 = itemstack.copy();
					itemstack2.setCount(1);
					BannerTileEntity.removeBannerData(itemstack2);
					playerIn.addStat(Stats.CLEAN_BANNER);
					if (!mode) { itemstack.shrink(1); }

					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(3))); }

					if (i != 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(4))); }

					if (itemstack.isEmpty()) { playerIn.setHeldItem(hand, itemstack2); }
					else if (!playerIn.inventory.addItemStackToInventory(itemstack2)) { playerIn.dropItem(itemstack2, false); }
					else if (playerIn instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)playerIn).sendContainerToPlayer(playerIn.container); }
				}
				return ActionResultType.SUCCESS;
			} //旗

			if (item instanceof BlockItem) {
				Block block = ((BlockItem)item).getBlock();
				if (block instanceof ShulkerBoxBlock && !worldIn.isRemote()) {
					ItemStack itemstack1 = new ItemStack(Blocks.SHULKER_BOX, 1);
					if (itemstack.hasTag()) { itemstack1.setTag(itemstack.getTag().copy()); }

					playerIn.setHeldItem(hand, itemstack1);
					CMEvents.soundWaterUse(worldIn, pos);

					if (i == 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(3))); }

					if (i != 1) {
						worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(Mizuoke.STAGE_1_4, Integer.valueOf(4))); }

					playerIn.addStat(Stats.CLEAN_SHULKER_BOX);
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
					worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(Mizuoke.STAGE_1_4, Integer.valueOf(3))); }

				if (i != 1) {
					worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE.getDefaultState()
							.with(H_FACING, state.get(H_FACING))
							.with(Mizuoke.STAGE_1_4, Integer.valueOf(4))); }

				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }

				return ActionResultType.SUCCESS;
			} //色筆

		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}


	/* TickRandom */
	@Override
	public int tickRate(IWorldReader world) {
		return 300;
	}

	@Override
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(STAGE_1_2);

		if (!worldIn.isAreaLoaded(pos, 1)) { return; }

		if (!state.get(WATERLOGGED)) {
			
			if (rain(worldIn, pos)) {
				if (i == 1) { 
					worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
					worldIn.setBlockState(pos, state.with(STAGE_1_2, Integer.valueOf(i + 1))); }
				
				if (i != 1) { } }
			
			if (!rain(worldIn, pos)) { }
		}
		
		if (state.get(WATERLOGGED)) {
			if (i == 1) { 
				worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
				CMEvents.soundBubble(worldIn, pos);
				worldIn.setBlockState(pos, state.with(STAGE_1_2, Integer.valueOf(2))); }
			
			if (i != 1) { }
		}
	}

	protected boolean rain(World worldIn, BlockPos pos) {
		return worldIn.isRainingAt(pos.up());
	}
	
	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.MIZUOKE_full);
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

}
