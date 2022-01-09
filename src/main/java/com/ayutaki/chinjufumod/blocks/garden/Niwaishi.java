package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.registry.Garden_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Niwaishi extends Base_Niwaishi {

	private static final AxisAlignedBB AABB_0 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 1.0, 0.84375);
	private static final AxisAlignedBB AABB_2 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.875, 0.84375);
	private static final AxisAlignedBB AABB_4 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.75, 0.84375);
	private static final AxisAlignedBB AABB_6 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.625, 0.84375);
	private static final AxisAlignedBB AABB_8 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.5, 0.84375);
	private static final AxisAlignedBB AABB_10 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.375, 0.84375);
	private static final AxisAlignedBB AABB_12 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.25, 0.84375);
	private static final AxisAlignedBB AABB_14 = new AxisAlignedBB(0.15625, 0.0D, 0.15625, 0.84375, 0.125, 0.84375);

	public Niwaishi() {
		super();

		setHardness(2.0F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		int i = ((Integer)state.getValue(STAGE_0_15)).intValue();

		switch (i) {
		case 0 :
		case 1 :
		default :
			return AABB_0;
			
		case 2 :
		case 3 :
			return AABB_2;
			
		case 4 :
		case 5 :
			return AABB_4;
			
		case 6 :
		case 7 :
			return AABB_6;

		case 8 :
		case 9 :
			return AABB_8;
			
		case 10 :
		case 11 :
			return AABB_10;

		case 12 :
		case 13 :
			return AABB_12;

		case 14 :
		case 15 :
			return AABB_14;
		} // switch
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		if (this == Garden_Blocks.NIWAISHI) { stack.add(new ItemStack(Blocks.STONE, 1, 0)); }
		if (this == Garden_Blocks.NIWAISHI_gra) { stack.add(new ItemStack(Blocks.STONE, 1, 1)); }
		if (this == Garden_Blocks.NIWAISHI_dio) { stack.add(new ItemStack(Blocks.STONE, 1, 3)); }
		if (this == Garden_Blocks.NIWAISHI_and) { stack.add(new ItemStack(Blocks.STONE, 1, 5)); }

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == Garden_Blocks.NIWAISHI_gra) { return new ItemStack(Blocks.STONE, 1, 1); }
		if (this == Garden_Blocks.NIWAISHI_dio) { return new ItemStack(Blocks.STONE, 1, 3); }
		if (this == Garden_Blocks.NIWAISHI_and) { return new ItemStack(Blocks.STONE, 1, 5); }
		return new ItemStack(Blocks.STONE, 1, 0);
	}

}
