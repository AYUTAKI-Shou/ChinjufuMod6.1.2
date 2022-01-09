package com.ayutaki.chinjufumod.blocks.chair;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.entity.SittableUtil;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CafeChair extends Block {

	public static final String ID = "block_cafechair";

	/* Property */
	public static final PropertyInteger STAGE_0_15 = PropertyInteger.create("stage", 0, 15);

	public CafeChair() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*鍋・皿*/
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);

		setDefaultState(this.blockState.getBaseState().withProperty(STAGE_0_15, Integer.valueOf(0)));
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (item instanceof Base_ItemHake) { return false; }

		else {
			if (SittableUtil.sitOnBlock(worldIn, pos.getX(), pos.getY(), pos.getZ(), playerIn, 6 * 0.0625)) {
				worldIn.updateComparatorOutputLevel(pos, this);
				CMEvents.soundKinuzure(worldIn, pos);
				return true; }
		}
		return false;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.625D, 0.8125D);
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return SittableUtil.isSomeoneSitting(worldIn, pos.getX(), pos.getY(), pos.getZ()) ? 1 : 0;
	}

	/* Data value */
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE_0_15, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer)state.getValue(STAGE_0_15)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { STAGE_0_15 });
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 0) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 0)); }
		if (i == 1) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 4)); }
		if (i == 5) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 5)); }
		if (i == 6) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 6)); }
		if (i == 7) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 7)); }
		if (i == 8) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 8)); }
		if (i == 9) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 9)); }
		if (i == 10) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 10)); }
		if (i == 11) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 11)); }
		if (i == 12) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 12)); }
		if (i == 13) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 13)); }
		if (i == 14) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 14)); }
		if (i == 15) { stack.add(new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 15)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		if (i == 1) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 1); }
		if (i == 2) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 4); }
		if (i == 5) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 5); }
		if (i == 6) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 6); }
		if (i == 7) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 7); }
		if (i == 8) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 8); }
		if (i == 9) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 9); }
		if (i == 10) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 10); }
		if (i == 11) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 11); }
		if (i == 12) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 12); }
		if (i == 13) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 13); }
		if (i == 14) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 14); }
		if (i == 15) { return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 15); }
		return new ItemStack(Items_Chinjufu.CAFECHAIR, 1, 0);
	}

}
