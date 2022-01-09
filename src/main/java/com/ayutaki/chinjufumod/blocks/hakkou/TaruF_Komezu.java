package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
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

public class TaruF_Komezu extends Block implements IWaterLoggable {

	/* Property */
	public static final IntegerProperty STAGE_0_8 = IntegerProperty.create("stage", 0, 8);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	
	/* Collision */
	protected static final VoxelShape AABB_BOX = VoxelShapes.or(Block.makeCuboidShape(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
			Block.makeCuboidShape(0.25D, 8.0D, 0.25D, 15.75D, 12.0D, 15.75D),
			Block.makeCuboidShape(0.5D, 4.0D, 0.5D, 15.5D, 8.0D, 15.5D),
			Block.makeCuboidShape(0.75D, 0.0D, 0.75D, 15.25D, 4.0D, 15.25D));

	/** 0=未発酵の米酢、5=米酢、6=米酢、7=米酢、8=米酢 **/
	public TaruF_Komezu(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(STAGE_0_8, Integer.valueOf(0))
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}


	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = state.get(STAGE_0_8);

		/** Too early to collect **/
		if (i <= 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		
		/** Can harvest **/
		if (i > 4) {
			if (item == Items.GLASS_BOTTLE) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundBottleFill(worldIn, pos);

				if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KOMEZU_bot_1)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KOMEZU_bot_1))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.KOMEZU_bot_1), false); }
	
				if (i != 8) { worldIn.setBlockState(pos, state.with(STAGE_0_8, Integer.valueOf(i + 1))); }
				if (i == 8) {
					worldIn.setBlockState(pos, Hakkou_Blocks.HAKKOU_TARU.getDefaultState().with(Taru_Hakkou.STAGE_0_5, Integer.valueOf(0))); }
			}
			
			if (item != Items.GLASS_BOTTLE) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		/** SUCCESS to not put anything on top. **/
		return ActionResultType.SUCCESS;
	}

	/* Gives a value when placed. */
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	/* Update BlockState. */
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn)); }

		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		if (!worldIn.isAreaLoaded(pos, 2)) return;

		int i = state.get(STAGE_0_8);

		if (i < 4 && rand.nextInt(4) == 0) {
			worldIn.setBlockState(pos, state.with(STAGE_0_8, Integer.valueOf(i + 1))); }

		if (i == 4 && rand.nextInt(4) == 0) {
			worldIn.setBlockState(pos, state.with(STAGE_0_8, Integer.valueOf(i + 1)));
			/** Get EXP. **/
			worldIn.addEntity(new ExperienceOrbEntity(worldIn, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 1)); }

		else { }
	}

	/* Create Blockstate */
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(STAGE_0_8, WATERLOGGED);
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
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

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_taru_komezu")).applyTextStyle(TextFormatting.GRAY));
	}

}
