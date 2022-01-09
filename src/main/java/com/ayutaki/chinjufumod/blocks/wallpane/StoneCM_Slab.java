package com.ayutaki.chinjufumod.blocks.wallpane;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_WallPane;
import com.ayutaki.chinjufumod.registry.WallBrick_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class StoneCM_Slab extends BaseSlabW {

	public StoneCM_Slab(String unlocalizedName) {
		super(unlocalizedName);

		setCreativeTab(ChinjufuModTabs.WALLPANEL);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != BaseSlabW.SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == WallBrick_Blocks.RGRA_slabhalf && item == Items_WallPane.RGRA_slabhalf) ||
					(this == WallBrick_Blocks.RDIO_slabhalf && item == Items_WallPane.RDIO_slabhalf) ||
					(this == WallBrick_Blocks.RAND_slabhalf && item == Items_WallPane.RAND_slabhalf) ||
					(this == WallBrick_Blocks.BGC_slabhalf && item == Items_WallPane.BGC_slabhalf) ||
					(this == WallBrick_Blocks.BDC_slabhalf && item == Items_WallPane.BDC_slabhalf) ||
					(this == WallBrick_Blocks.BAC_slabhalf && item == Items_WallPane.BAC_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == BaseSlabW.SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == WallBrick_Blocks.RGRA_slabhalf && item == Items_WallPane.RGRA_slabhalf) ||
					(this == WallBrick_Blocks.RDIO_slabhalf && item == Items_WallPane.RDIO_slabhalf) ||
					(this == WallBrick_Blocks.RAND_slabhalf && item == Items_WallPane.RAND_slabhalf) ||
					(this == WallBrick_Blocks.BGC_slabhalf && item == Items_WallPane.BGC_slabhalf) ||
					(this == WallBrick_Blocks.BDC_slabhalf && item == Items_WallPane.BDC_slabhalf) ||
					(this == WallBrick_Blocks.BAC_slabhalf && item == Items_WallPane.BAC_slabhalf)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** スニーキング右クリックで CRA を往復 **/


		/** 側面で設置可能にするため false **/
		return false;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/** Slab **/
		if (state.getValue(DOUBLE) != true) {
			if (this == WallBrick_Blocks.RGRA_slabhalf) { stack.add(new ItemStack(Items_WallPane.RGRA_slabhalf, 1, 0)); }
			if (this == WallBrick_Blocks.RDIO_slabhalf) { stack.add(new ItemStack(Items_WallPane.RDIO_slabhalf, 1, 0)); }
			if (this == WallBrick_Blocks.RAND_slabhalf) { stack.add(new ItemStack(Items_WallPane.RAND_slabhalf, 1, 0)); }
			if (this == WallBrick_Blocks.BGC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BGC_slabhalf, 1, 0)); }
			if (this == WallBrick_Blocks.BDC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BDC_slabhalf, 1, 0)); }
			if (this == WallBrick_Blocks.BAC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BAC_slabhalf, 1, 0)); }
		}


		/** Double **/
		if (state.getValue(DOUBLE) == true) {
			if (this == WallBrick_Blocks.RGRA_slabhalf) { stack.add(new ItemStack(Items_WallPane.RGRA_slabhalf, 2, 0)); }
			if (this == WallBrick_Blocks.RDIO_slabhalf) { stack.add(new ItemStack(Items_WallPane.RDIO_slabhalf, 2, 0)); }
			if (this == WallBrick_Blocks.RAND_slabhalf) { stack.add(new ItemStack(Items_WallPane.RAND_slabhalf, 2, 0)); }
			if (this == WallBrick_Blocks.BGC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BGC_slabhalf, 2, 0)); }
			if (this == WallBrick_Blocks.BDC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BDC_slabhalf, 2, 0)); }
			if (this == WallBrick_Blocks.BAC_slabhalf) { stack.add(new ItemStack(Items_WallPane.BAC_slabhalf, 2, 0)); }
		}
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {

		if (this == WallBrick_Blocks.RDIO_slabhalf) { return new ItemStack(Items_WallPane.RDIO_slabhalf); }
		if (this == WallBrick_Blocks.RAND_slabhalf) { return new ItemStack(Items_WallPane.RAND_slabhalf); }
		if (this == WallBrick_Blocks.BGC_slabhalf) { return new ItemStack(Items_WallPane.BGC_slabhalf); }
		if (this == WallBrick_Blocks.BDC_slabhalf) { return new ItemStack(Items_WallPane.BDC_slabhalf); }
		if (this == WallBrick_Blocks.BAC_slabhalf) { return new ItemStack(Items_WallPane.BAC_slabhalf); }
		return new ItemStack(Items_WallPane.RGRA_slabhalf);
	}

}
