package com.ayutaki.chinjufumod.blocks.furniture;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.tileentity.TileEntityTansu;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tansu extends BlockContainer {

	public static final PropertyDirection H_FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	public Tansu() {
		super(Material.WOOD);
		setCreativeTab(ChinjufuModTabs.CHINJUFU);

		setHardness(1.0F);
		setResistance(10.0F);
		setDefaultState(this.blockState.getBaseState().withProperty(H_FACING, EnumFacing.NORTH));

		setSoundType(SoundType.WOOD);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}

	/* チェストに使うRenderType */
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {}

	/* チェストとの隣接 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return true;
	}

	/* TileEntityを返す */
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTansu();
	}

	/* 右クリックをした時の処理 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ILockableContainer ilockablecontainer = (TileEntityTansu)worldIn.getTileEntity(pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);

		switch (direction) {
		case NORTH :
		default:
			if (!worldIn.getBlockState(pos.north()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (worldIn.getBlockState(pos.north()).getMaterial().isReplaceable()) { playerIn.displayGUIChest(ilockablecontainer); }
			break;
	
		case SOUTH :
			if (!worldIn.getBlockState(pos.south()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (worldIn.getBlockState(pos.south()).getMaterial().isReplaceable()) { playerIn.displayGUIChest(ilockablecontainer); }
			break;
	
		case EAST :
			if (!worldIn.getBlockState(pos.east()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (worldIn.getBlockState(pos.east()).getMaterial().isReplaceable()) { playerIn.displayGUIChest(ilockablecontainer); }
			break;
			
		case WEST :
			if (!worldIn.getBlockState(pos.west()).getMaterial().isReplaceable()) { CMEvents.textIsBlocked(worldIn, pos, playerIn); }
			
			if (worldIn.getBlockState(pos.west()).getMaterial().isReplaceable()) { playerIn.displayGUIChest(ilockablecontainer); }
			break;
		} // switch

		return true;
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	/* チェストを壊した時の処理 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasCustomBreakingProgress(IBlockState state) {
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		super.breakBlock(worldIn, pos, state);
	}

	/*getOppositeでプレイヤーの向きを取得*/
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(H_FACING, placer.getHorizontalFacing().getOpposite());
	}

	/*IBlockStateからItemStackのmetadataを生成。ドロップ時とテクスチャ・モデル参照時に呼ばれる。*/
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(H_FACING)).getHorizontalIndex();
	}

	/*ItemStackのmetadataからIBlockStateを生成。設置時に呼ばれる。*/
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(H_FACING, EnumFacing.getHorizontal(meta));
	}

	/*初期BlockStateContainerの生成。*/
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { H_FACING });
	}
}
