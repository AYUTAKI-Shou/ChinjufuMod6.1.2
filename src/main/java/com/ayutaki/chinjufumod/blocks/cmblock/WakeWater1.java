package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.ChinjufuModBlocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class WakeWater1 extends Block implements IBucketPickupHandler {

	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.1D, 16.0D);

	public WakeWater1(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/*水を汲む*/
		if (item == Items.GLASS_BOTTLE) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBottleFill(worldIn, pos);

			ItemStack itemstack4 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), Potions.WATER);
			if (itemstack.isEmpty()) { playerIn.setHeldItem(hand, itemstack4); }
			else if (!playerIn.inventory.addItemStackToInventory(itemstack4)) {
				playerIn.dropItem(itemstack4, false); }
		}

		/* TTimeItems 海水OKの水桶と土鍋のみ */
		if (item == Items_Teatime.MIZUOKE) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBucketFill(worldIn, pos);

			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
		}

		if (item == Items_Teatime.NABE_kara) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBucketFill(worldIn, pos);

			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABESHIO_nama)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABESHIO_nama))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.NABESHIO_nama), false); }
		}
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if (true) { worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn)); }
		
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
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
		if (!worldIn.isAreaLoaded(pos, 1)) { worldIn.setBlockState(pos, Blocks.AIR.getDefaultState()); }

		worldIn.getPendingBlockTicks().scheduleTick(pos, this, this.tickRate(worldIn));
		worldIn.setBlockState(pos, ChinjufuModBlocks.WAKE_WATER2.getDefaultState());
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items.AIR);
	}

	/* 効果音・パーティクル */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		if (true)
			for(int i = 0; i < 10; ++i) {
				double d0 = (double)pos.getX() + (rand.nextDouble() - 1.0F) * 0.3D;
				double d1 = (double)pos.getY() + (rand.nextDouble() - 1.0F) * 0.3D;
				double d2 = (double)pos.getZ() + (rand.nextDouble() - 1.0F) * 0.3D;

				worldIn.addParticle(ParticleTypes.CLOUD, d0 + 0.7D, d1 - 0.2, d2 + 0.7D, 0.0D, 0.0D, 0.0D);
		}
	}

	/* Items.BUCKET など Fluids.WATER の有るアイテムで水を汲む */
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		return Fluids.WATER;
	}

}
