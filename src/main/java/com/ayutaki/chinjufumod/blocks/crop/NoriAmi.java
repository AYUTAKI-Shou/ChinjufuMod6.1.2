package com.ayutaki.chinjufumod.blocks.crop;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NoriAmi extends Block implements IGrowable {

	/* Property */
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 7);

	/* Collision */
	protected static final VoxelShape AABB_BOX = Block.makeCuboidShape(0.0D, -5.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public NoriAmi(Block.Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = state.get(AGE);

		/** Too early to collect **/
		if (i < 5) {
			if (!itemstack.isEmpty()) { return ActionResultType.PASS; }
			
			if (itemstack.isEmpty()) {
				CMEvents.textEarlyCollect(worldIn, pos, playerIn);
				return ActionResultType.SUCCESS; }
		}
		
		/** Can harvest **/
		if (i >= 5) {
			if (itemstack.isEmpty()) {
				
				CMEvents.soundTake_Pick(worldIn, pos);				
				if (i == 5 || i == 6) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NORI_N, 1)); }
				if (i == 7) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NORI_N, 2)); }
		
				worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			return ActionResultType.SUCCESS;
		}
		
		/* 側面に置きたいから PASS */
		return ActionResultType.PASS;
	}

	/* 設置制限 */
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return state.getBlock() == Blocks.WATER;
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		return facing == Direction.DOWN && !state.isValidPosition(worldIn, pos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos downpos = pos.down();
		if (worldIn.getLightSubtracted(pos, 0) >= 8 || worldIn.canSeeSky(pos)) {
			return this.isValidGround(worldIn.getBlockState(downpos), worldIn, downpos);
		}
		return false;
	}

	/* Collisions for each property. */
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return AABB_BOX;
	}

	/* TickRandom */
	@Override
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		int i = state.get(AGE);

		if (!worldIn.isAreaLoaded(pos, 2)) { return; }

		if (i < 7 && worldIn.getLightSubtracted(pos, 0) >= 9 && rand.nextInt(6) == 0) {
			worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1))); }

		else { }
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Teatime.NORIAMI);
	}

	/* Create Blockstate */
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	/* 骨粉を使う */
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 7;
	}

	protected int getAge(BlockState state) {
		return state.get(this.getAgeProperty());
	}

	public BlockState withAge(int age) {
		return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= this.getMaxAge();
	}

	public void grow(World worldIn, BlockPos pos, BlockState state) {
		int i = this.getAge(state);
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}
		worldIn.setBlockState(pos, this.withAge(i), 2);
	}


	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}

	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		this.grow(worldIn, pos, state);
	}

	/* ToolTip */
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_noriami")).applyTextStyle(TextFormatting.GRAY));
	}

}
