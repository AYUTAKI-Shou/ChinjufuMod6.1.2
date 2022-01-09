package com.ayutaki.chinjufumod.blocks.furniture;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.tileentity.Tansu_TileEntity;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.ChestType;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Tansu extends AbstractTansu<Tansu_TileEntity> {

	public static final DirectionProperty H_FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);
	public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");
	public static final EnumProperty<ChestType> TYPE = BlockStateProperties.CHEST_TYPE;

	public Tansu(Block.Properties builder, Supplier<TileEntityType<? extends Tansu_TileEntity>> entityType) {
		super(builder, entityType);
		this.setDefaultState(this.stateContainer.getBaseState().with(H_FACING, Direction.NORTH)
				.with(TYPE, ChestType.SINGLE)
				.with(WATERLOGGED, Boolean.valueOf(false)));
	}

	public static TileEntityMerger.Type func_226919_h_(BlockState state) {
		return TileEntityMerger.Type.SINGLE;
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL; // BlockRenderType.MODEL でブロックのモデルを表示
	}

	/* Gives a value when placed. +180 .getOpposite() */
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		IFluidState fluidState = context.getWorld().getFluidState(context.getPos());
		return this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER)
				.with(H_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	/* HORIZONTAL Property */
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.with(H_FACING, rotation.rotate(state.get(H_FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.toRotation(state.get(H_FACING)));
	}

	/* Waterlogged */
	@SuppressWarnings("deprecation")
	public IFluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld worldIn, BlockPos pos, BlockPos facingPos) {
		if ((Boolean)state.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		return super.updatePostPlacement(state, facing, facingState, worldIn, pos, facingPos);
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return VoxelShapes.fullCube();
	}

	@Nullable
	private Direction candidatePartnerFacing(BlockItemUseContext context, Direction direct) {
		BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direct));
		return blockstate.getBlock() == this && blockstate.get(TYPE) == ChestType.SINGLE ? blockstate.get(H_FACING) : null;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof Tansu_TileEntity) {
			((Tansu_TileEntity)tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof Tansu_TileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((Tansu_TileEntity) tileentity).getItems());
			}
		}
	}

	/* RightClick Action */
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult hit) {

		if (worldIn.isRemote) { return ActionResultType.SUCCESS; }

		if (!worldIn.isRemote) {

			if (!state.get(WATERLOGGED)) {
				INamedContainerProvider inamedcontainerprovider = this.getContainer(state, worldIn, pos);
				Direction direction = state.get(H_FACING);

				switch (direction) {
				case NORTH :
				default :
					if (!worldIn.getBlockState(pos.north()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (worldIn.getBlockState(pos.north()).getMaterial().isReplaceable()) {
						if (inamedcontainerprovider != null) {
							playerIn.openContainer(inamedcontainerprovider);
							playerIn.addStat(this.getOpenStat()); } }
					break;

				case SOUTH :
					if (!worldIn.getBlockState(pos.south()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }

					if (worldIn.getBlockState(pos.south()).getMaterial().isReplaceable()) {
						if (inamedcontainerprovider != null) {
							playerIn.openContainer(inamedcontainerprovider);
							playerIn.addStat(this.getOpenStat()); } }
					break;

				case EAST :
					if (!worldIn.getBlockState(pos.east()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (worldIn.getBlockState(pos.east()).getMaterial().isReplaceable()) {
						if (inamedcontainerprovider != null) {
							playerIn.openContainer(inamedcontainerprovider);
							playerIn.addStat(this.getOpenStat()); } }
					break;
					
				case WEST :
					if (!worldIn.getBlockState(pos.west()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
					
					if (worldIn.getBlockState(pos.west()).getMaterial().isReplaceable()) {
						if (inamedcontainerprovider != null) {
							playerIn.openContainer(inamedcontainerprovider);
							playerIn.addStat(this.getOpenStat()); } }
					break;
				} // switch
			} // !state.get(WATERLOGGED)
			
			if (state.get(WATERLOGGED)) { CMEvents.textIsWaterlogged(worldIn, pos, playerIn); }
		}
		
		return ActionResultType.SUCCESS;
	}

	protected Stat<ResourceLocation> getOpenStat() {
		return Stats.CUSTOM.get(Stats.OPEN_CHEST);
	}

	@Nullable
	public static IInventory getContainer(Tansu block, BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return (IInventory)worldIn.getTileEntity(pos);
	}

	public TileEntityMerger.ICallbackWrapper<? extends Tansu_TileEntity> combine(BlockState state, World worldIn, BlockPos pos, boolean flag) {
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public static TileEntityMerger.ICallback<Tansu_TileEntity, Float2FloatFunction> opennessCombiner(final IChestLid lis) {
		return new TileEntityMerger.ICallback<Tansu_TileEntity, Float2FloatFunction>() {
			public Float2FloatFunction func_225539_a_(Tansu_TileEntity tileEntity_1, Tansu_TileEntity tileEntity_2) {
				return (p_226921_2_) -> {
					return Math.max(tileEntity_1.getLidAngle(p_226921_2_), tileEntity_2.getLidAngle(p_226921_2_));
				};
			}

			public Float2FloatFunction func_225538_a_(Tansu_TileEntity tileEntity) {
				return tileEntity::getLidAngle;
			}

			public Float2FloatFunction func_225537_b_() {
				return lis::getLidAngle;
			}
		};
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new Tansu_TileEntity();
	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(BlockState state, World worldIn, BlockPos pos) {
		return Container.calcRedstoneFromInventory(getContainer(this, state, worldIn, pos, false));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(H_FACING, TYPE, WATERLOGGED);
	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType path) {
		return false;
	}

}
