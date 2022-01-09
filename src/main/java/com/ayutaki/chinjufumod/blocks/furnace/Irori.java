package com.ayutaki.chinjufumod.blocks.furnace;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.dish.BaseIrori_Sakana;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe_Stage2;
import com.ayutaki.chinjufumod.blocks.dish.BaseNabe_nama;
import com.ayutaki.chinjufumod.blocks.dish.Kettle_full;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
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
import net.minecraftforge.common.ToolType;

public class Irori extends Block implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_0_10 = IntegerProperty.create("stage", 0, 10);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final BooleanProperty LIT = BooleanProperty.create("lit");
	public static final BooleanProperty DONABE = BooleanProperty.create("donabe");

	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.box(0.0D, 11.0D, 0.0D, 16.0D, 15.0D, 0.5D),
			Block.box(0.0D, 11.0D, 15.5D, 16.0D, 15.0D, 16.0D),
			Block.box(0.0D, 11.0D, 0.0D, 0.5D, 15.0D, 16.0D),
			Block.box(15.5D, 11.0D, 0.0D, 16.0D, 15.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D));

	public Irori(AbstractBlock.Properties properties) {
		super(properties);

		/** Default blockstate **/
		registerDefaultState(this.defaultBlockState()
				.setValue(STAGE_0_10, Integer.valueOf(0))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(LIT, Boolean.valueOf(false))
				.setValue(DONABE, Boolean.valueOf(false)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getItemInHand(hand);
		Item item = itemstack.getItem();
		int i = state.getValue(STAGE_0_10);
		boolean mode = playerIn.abilities.instabuild;

		if (!state.getValue(WATERLOGGED)) {

			if (item == Items.CHARCOAL) {
				if (i == 0) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundSnowPlace(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(1)), 3); }
				
				if (i > 2 && i < 10) {
					if (!mode) { itemstack.shrink(1);
						InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BONE_MEAL)); }
					if (mode) { }
					
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); }
				
				if (i == 10) {
					if (!mode) { itemstack.shrink(1);
						InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.BONE_MEAL)); }
					if (mode) { }
					
					CMEvents.soundSnowPlace(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(1)), 3); } }


			if (item == Items.FLINT_AND_STEEL) {
				if (i == 1) {
					itemstack.hurtAndBreak(1, playerIn, user -> { user.broadcastBreakEvent(hand); } );
					
					CMEvents.soundFlint(worldIn, pos);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); } }


			if (item == Items_Teatime.MATCH) {
				if (i == 1) {
					CMEvents.Consume_1Item(playerIn, hand);
					CMEvents.soundFlint(worldIn, pos);
					
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(2)).setValue(LIT, Boolean.valueOf(true)), 3); } }
			
			/** 魚の串焼き **/
			boolean hitnorth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() < 0.3D);
			boolean hitsouth = (hit.getLocation().x - (double)pos.getX() > 0.3D) && (hit.getLocation().x - (double)pos.getX() < 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.7D);
			boolean hiteast = (hit.getLocation().x - (double)pos.getX() > 0.7D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);
			boolean hitwest = (hit.getLocation().x - (double)pos.getX() < 0.3D) && (hit.getLocation().z - (double)pos.getZ() > 0.3D) && (hit.getLocation().z - (double)pos.getZ() < 0.7D);

			if (item == Items_Teatime.KUSHI_SAKANA && worldIn.getBlockState(pos.above()).getMaterial().isReplaceable()) {

				if (hitnorth) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E2.defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(10)), 3); }

				if (hitsouth) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(2)), 3); }

				if (hiteast) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);	
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(8)), 3); }

				if (hitwest) {
					CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);	
					worldIn.setBlock(pos.above(), Dish_Blocks.IRORISAKANA_E1.defaultBlockState()
						.setValue(BaseIrori_Sakana.STAGE_0_15, Integer.valueOf(0)), 3); } }


			/** No usable items. **/
			if (item != Items.CHARCOAL && item != Items_Teatime.KUSHI_SAKANA && item != Items_Teatime.MATCH && item != Items.FLINT_AND_STEEL) {
				if (itemstack.isEmpty()) {
					if (i == 10) {
						CMEvents.soundTake_Pick(worldIn, pos);
						playerIn.inventory.add(new ItemStack(Items.BONE_MEAL));
						worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)), 3); }
					
					if (i != 10) { CMEvents.textNotHave(worldIn, pos, playerIn); } }
				
				if (!itemstack.isEmpty()) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			}
		} // It is not waterlogged.

		/** Waterlogged **/
		if (state.getValue(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
	}

	/* Connect the blocks. */
	protected boolean connectNabe(IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockPos newPos = pos.relative(face);
		BlockState state = worldIn.getBlockState(newPos);
		Block block = state.getBlock();

		return (block instanceof BaseNabe || block instanceof BaseNabe_Stage2 || block instanceof BaseNabe_nama ||
				block instanceof Nabe_kara || block instanceof Kettle_full);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public boolean canPlaceLiquid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluid) {
		return !state.getValue(BlockStateProperties.WATERLOGGED) && fluid == Fluids.WATER;
	}

	@Override
	public boolean placeLiquid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluid) {
		if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluid.getType() == Fluids.WATER) {
			if (!worldIn.isClientSide()) {
				worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(true)), 3);
				worldIn.getLiquidTicks().scheduleTick(pos, fluid.getType(), fluid.getType().getTickDelay(worldIn)); }
			return true;
		}
		else { return false; }
	}

	@Override
	public Fluid takeLiquid(IWorld worldIn, BlockPos pos, BlockState state) {
		if (state.getValue(BlockStateProperties.WATERLOGGED)) {
			worldIn.setBlock(pos, state.setValue(BlockStateProperties.WATERLOGGED, Boolean.valueOf(false)), 3);
			return Fluids.WATER; }
		else { return Fluids.EMPTY; }
	}

	/* Distinguish LOST from WATERLOGGED. */
	protected boolean inWater(BlockState state, IBlockReader worldIn, BlockPos pos) {
		if (state.getValue(WATERLOGGED)) { return true; }
		return false;
	}
	
	/* Update BlockState. */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn)); }

		int i = state.getValue(STAGE_0_10);
		if (i == 2) { worldIn.getBlockTicks().scheduleTick(pos, this, 120); }

		if (inWater(state, worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, this, 120); }

		boolean donabe = connectNabe(worldIn, pos, Direction.UP);
		return state.setValue(DONABE, donabe);
	}

	/* Create Blockstate */
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(DONABE, LIT, STAGE_0_10, WATERLOGGED);
	}

	/* TickRandom */
	@Override
	public void onPlace(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (inWater(state, worldIn, pos)) { worldIn.getBlockTicks().scheduleTick(pos, this, 120); }

		int i = state.getValue(STAGE_0_10);
		if (i == 2) { worldIn.getBlockTicks().scheduleTick(pos, this, 120); }
	}

	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_0_10);

		/** Nothing on the top. **/
		if (i == 0) { }

		/** Charcoal on the top. **/
		if (i == 1) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 120);
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)).setValue(LIT, Boolean.valueOf(false)), 3);
				this.dropCharcoal(worldIn, pos);
			}

			if (!inWater(state, worldIn, pos)) { }
		}

		/** Ash on the top. **/
		if (i == 10) {
			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 120);
				CMEvents.soundSnowPlace(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)).setValue(LIT, Boolean.valueOf(false)), 3);
				this.dropBonemeal(worldIn, pos);
			}

			if (!inWater(state, worldIn, pos)) { }
		}

		/** Charcoal is burning. **/
		if (i >= 2 && i <= 9) {

			if (inWater(state, worldIn, pos)) {
				worldIn.getBlockTicks().scheduleTick(pos, this, 120);
				
				CMEvents.soundFireExting(worldIn, pos);
				worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(0)).setValue(LIT, Boolean.valueOf(false)), 3);
				this.dropBonemeal(worldIn, pos);
			}

			if (!inWater(state, worldIn, pos)) {
				if (i == 2) {
					worldIn.getBlockTicks().scheduleTick(pos, this, 120);
					worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(3)).setValue(LIT, Boolean.valueOf(true)), 3); }
			}
		}

		else { }
	}

	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.getValue(STAGE_0_10);

		/** Charcoal is burning. **/
		if (i >= 3 && i <= 9) {

			if (!inWater(state, worldIn, pos)) {

				if (rand.nextInt(1) == 0) {
					if (i <= 6) { worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(i + 1))
							.setValue(LIT, Boolean.valueOf(true)), 3); }

					if (i >= 7) { worldIn.setBlock(pos, state.setValue(STAGE_0_10, Integer.valueOf(i + 1))
							.setValue(LIT, Boolean.valueOf(false)), 3); }
				}
			}
		}

		else { }
	}

	protected void dropBonemeal(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.BONE_MEAL);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	protected void dropCharcoal(ServerWorld worldIn, BlockPos pos) {
		ItemStack itemstack = new ItemStack(Items.CHARCOAL);
		InventoryHelper.dropItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), itemstack);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public int getHarvestLevel(BlockState state) {
		return 0;
	}

	/* 燃焼中に上を歩くとダメージを受ける */
	public void stepOn(World worldIn, BlockPos pos, Entity entity) {

		int px = pos.getX();
		int py = pos.getY();
		int pz = pos.getZ();

		BlockState state = worldIn.getBlockState(new BlockPos(px, py, pz));
		int i = state.getValue(STAGE_0_10);

		if (i > 1 && i < 10) {
			if (!entity.fireImmune() && entity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)entity)) {
				entity.hurt(DamageSource.HOT_FLOOR, 1.0F);
			}
			super.stepOn(worldIn, pos, entity);
		}
	}

	/* Play Sound・Particle */
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.8D;
		double d2 = (double)pos.getZ() + 0.5D;
		double d4 = rand.nextDouble() * 0.6D - 0.3D;
		double d6 = rand.nextDouble() * 6.0D / 16.0D;

		int i = state.getValue(STAGE_0_10);
		if (i != 0 && i != 1 && i != 10) {
				if (rand.nextDouble() < 0.1D) {
					worldIn.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false); }

				if (rand.nextDouble() < 0.25D) {
					/** 種類, 座標x, y, z, 速度x, y, z **/
					worldIn.addParticle(ParticleTypes.SMOKE, d0 + d4, d1 + d6, d2 + d4, 0.0D, 0.0D, 0.0D); }
		}
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.appendHoverText(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_irori")).withStyle(TextFormatting.GRAY));
	}

}
