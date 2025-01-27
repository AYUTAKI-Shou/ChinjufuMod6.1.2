package com.ayutaki.chinjufumod.blocks.amado;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class Tobukuro extends Base_Tobukuro {

	/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
	public Tobukuro(AbstractBlock.Properties properties) {
		super(properties);
	}

	/* RightClick Action */
	@Override
	public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand hand, BlockRayTraceResult hit) {

		/** 1=4枚、2=3枚、3=2枚、4=1枚、5=0枚 **/
		int i = state.getValue(STAGE_1_5);
		Direction direction = state.getValue(H_FACING);
		DoubleBlockHalf half = state.getValue(HALF);

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
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x - 1, y, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y + 1, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y + 1, z)).getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x + 1, y, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y + 1, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x + 1, y + 1, z)).getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z - 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y + 1, z - 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x, y + 1, z - 1)).getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.above(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z + 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y + 1, z + 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x, y + 1, z + 1)).getMaterial().isReplaceable()) { }
					break;
				} // switch
				break;


			case UPPER :

				switch (direction) {
				case NORTH :
				default :
					if (worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x - 1, y, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x - 1, y - 1, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x - 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x - 1, y - 1, z)).getMaterial().isReplaceable()) { }
					break;

				case SOUTH :
					if (worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x + 1, y, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x + 1, y - 1, z), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x + 1, y, z)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x + 1, y - 1, z)).getMaterial().isReplaceable()) { }
					break;

				case EAST :
					if (worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z - 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z - 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z - 1)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x, y - 1, z - 1)).getMaterial().isReplaceable()) { }
					break;
					
				case WEST :
					if (worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() &&
							worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) {
	
						CMEvents.soundFusumaS(worldIn, pos);
						worldIn.setBlock(pos, state.setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
						worldIn.setBlock(pos.below(), this.defaultBlockState()
								.setValue(H_FACING, state.getValue(H_FACING))
								.setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE_1_5, Integer.valueOf(i + 1)), 3);
	
						worldIn.setBlock(new BlockPos(x, y, z + 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.UPPER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlock(new BlockPos(x, y - 1, z + 1), AMADO.defaultBlockState()
								.setValue(Amado.H_FACING, state.getValue(H_FACING))
								.setValue(Amado.HALF, DoubleBlockHalf.LOWER).setValue(Amado.STAGE_1_4, Integer.valueOf(1)), 3); }
					
					if (!worldIn.getBlockState(new BlockPos(x, y, z + 1)).getMaterial().isReplaceable() ||
							!worldIn.getBlockState(new BlockPos(x, y - 1, z + 1)).getMaterial().isReplaceable()) { }
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
		FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
		PlayerEntity playerIn = context.getPlayer();
		BlockPos blockpos = context.getClickedPos();

		/** pos.up() = Replaceable block. **/
		if (blockpos.getY() < 255 && context.getLevel().getBlockState(blockpos.above()).canBeReplaced(context)) {
			if (playerIn.isCrouching()) {
				return Slidedoor_Blocks.TOBUKURO_L.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
						.setValue(STAGE_1_5, Integer.valueOf(1))
						.setValue(HALF, DoubleBlockHalf.LOWER)
						.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER)); }

			return this.defaultBlockState().setValue(H_FACING, context.getHorizontalDirection().getOpposite())
					.setValue(STAGE_1_5, Integer.valueOf(1))
					.setValue(HALF, DoubleBlockHalf.LOWER)
					.setValue(WATERLOGGED, Boolean.valueOf(fluid.getType() == Fluids.WATER));
		}

		else { return null; }
	}

	/* Add DoubleBlockHalf.UPPER on the Block. */
	@Override
	public void setPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		FluidState ifluidstateUp = worldIn.getFluidState(pos.above());

		worldIn.setBlock(pos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)
				.setValue(H_FACING, state.getValue(H_FACING))
				.setValue(STAGE_1_5, Integer.valueOf(1))
				.setValue(WATERLOGGED, Boolean.valueOf(ifluidstateUp.getType() == Fluids.WATER)), 3);
	}

	/* Clone Item in Creative. */
	@Override
	public ItemStack getCloneItemStack(IBlockReader worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(Items_Wadeco.TOBUKURO);
	}

}
