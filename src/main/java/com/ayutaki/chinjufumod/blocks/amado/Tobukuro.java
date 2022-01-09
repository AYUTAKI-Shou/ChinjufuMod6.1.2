package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Tobukuro extends Base_Tobukuro {

	/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
	public Tobukuro(Block.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
		int i = state.get(STAGE_1_5);
		Direction direction = state.get(H_FACING);
		DoubleBlockHalf half = state.get(HALF);

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		Block AMADO = Slidedoor_Blocks.AMADO;

		if (i != 5) {
			CMEvents.soundAmado(worldIn, pos);
			
			switch (half) {
			case LOWER :
			default :

				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x - 1, y, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x + 1, y, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z - 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.UPPER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z + 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;
				} // switch
				break;

			case UPPER :

				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x - 1, y, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x - 1, y - 1, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x + 1, y, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x + 1, y - 1, z), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z - 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x, y - 1, z - 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() && worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
						
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlockState(pos, state.with(STAGE_1_5, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.down(), this.getDefaultState()
								.with(H_FACING, state.get(H_FACING))
								.with(HALF, DoubleBlockHalf.LOWER).with(STAGE_1_5, Integer.valueOf(i + 1)));
	
						worldIn.setBlockState(new BlockPos(x, y, z + 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.UPPER).with(Amado.STAGE_1_4, Integer.valueOf(1)));
						worldIn.setBlockState(new BlockPos(x, y - 1, z + 1), AMADO.getDefaultState()
								.with(Amado.H_FACING, state.get(H_FACING))
								.with(Amado.HALF, DoubleBlockHalf.LOWER).with(Amado.STAGE_1_4, Integer.valueOf(1))); }
					break;
				} // switch
				break;
			} // switch LOWER-UPPER
		} // i != 5
	
		if (i == 5) { CMEvents.textIsEmpty(worldIn, pos, playerIn); }
		
		return ActionResultType.SUCCESS;
	}


	/* Gives a value when placed. */
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		PlayerEntity playerIn = context.getPlayer();
		BlockPos blockpos = context.getPos();

		/** 直上が置き換え可能なブロックの時 **/
		if (blockpos.getY() < 255 && context.getWorld().getBlockState(blockpos.up()).isReplaceable(context)) {
			if (playerIn.isSneaking()) {
				return Slidedoor_Blocks.TOBUKURO_L.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
						.with(STAGE_1_5, Integer.valueOf(1))
						.with(HALF, DoubleBlockHalf.LOWER)
						.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER); }

			return this.getDefaultState().with(H_FACING, context.getPlacementHorizontalFacing().getOpposite())
					.with(STAGE_1_5, Integer.valueOf(1))
					.with(HALF, DoubleBlockHalf.LOWER)
					.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
		}

		/** それ以外の時 **/
		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		IFluidState ifluidstateUp = worldIn.getFluidState(pos.up());

		worldIn.setBlockState(pos.up(), this.getDefaultState().with(HALF, DoubleBlockHalf.UPPER)
				.with(H_FACING, state.get(H_FACING))
				.with(STAGE_1_5, Integer.valueOf(1))
				.with(WATERLOGGED, Boolean.valueOf(ifluidstateUp.isTagged(FluidTags.WATER))), 3);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.TOBUKURO);
	}

}
