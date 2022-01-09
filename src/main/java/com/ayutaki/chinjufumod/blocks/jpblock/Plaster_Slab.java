package com.ayutaki.chinjufumod.blocks.jpblock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Items_Wablock;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;

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

public class Plaster_Slab extends BaseSlabWType2 {

	public Plaster_Slab(String unlocalizedName) {
		super(unlocalizedName);

		setCreativeTab(ChinjufuModTabs.WABLOCK);

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

		if (item instanceof Base_ItemHake) { return false; }
		
		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != BaseSlabWType2.SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == JPBlock_Blocks.DIRTWALL_SH && item == Items_Wablock.DIRTWALL_SH) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_white && item == Items_Wablock.SHIKKUI_SH_white) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_orange && item == Items_Wablock.SHIKKUI_SH_orange) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_magenta && item == Items_Wablock.SHIKKUI_SH_magenta) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_yellow && item == Items_Wablock.SHIKKUI_SH_yellow) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lime && item == Items_Wablock.SHIKKUI_SH_lime) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_pink && item == Items_Wablock.SHIKKUI_SH_pink) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_gray && item == Items_Wablock.SHIKKUI_SH_gray) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lightb && item == Items_Wablock.SHIKKUI_SH_lightb) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lightg && item == Items_Wablock.SHIKKUI_SH_lightg) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_cyan && item == Items_Wablock.SHIKKUI_SH_cyan) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_purple && item == Items_Wablock.SHIKKUI_SH_purple) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_blue && item == Items_Wablock.SHIKKUI_SH_blue) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_brown && item == Items_Wablock.SHIKKUI_SH_brown) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_green && item == Items_Wablock.SHIKKUI_SH_green) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_red && item == Items_Wablock.SHIKKUI_SH_red) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_black && item == Items_Wablock.SHIKKUI_SH_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == BaseSlabWType2.SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == JPBlock_Blocks.DIRTWALL_SH && item == Items_Wablock.DIRTWALL_SH) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_white && item == Items_Wablock.SHIKKUI_SH_white) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_orange && item == Items_Wablock.SHIKKUI_SH_orange) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_magenta && item == Items_Wablock.SHIKKUI_SH_magenta) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_yellow && item == Items_Wablock.SHIKKUI_SH_yellow) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lime && item == Items_Wablock.SHIKKUI_SH_lime) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_pink && item == Items_Wablock.SHIKKUI_SH_pink) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_gray && item == Items_Wablock.SHIKKUI_SH_gray) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lightb && item == Items_Wablock.SHIKKUI_SH_lightb) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_lightg && item == Items_Wablock.SHIKKUI_SH_lightg) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_cyan && item == Items_Wablock.SHIKKUI_SH_cyan) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_purple && item == Items_Wablock.SHIKKUI_SH_purple) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_blue && item == Items_Wablock.SHIKKUI_SH_blue) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_brown && item == Items_Wablock.SHIKKUI_SH_brown) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_green && item == Items_Wablock.SHIKKUI_SH_green) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_red && item == Items_Wablock.SHIKKUI_SH_red) ||
					(this == JPBlock_Blocks.SHIKKUI_SH_black && item == Items_Wablock.SHIKKUI_SH_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundStonePlace(worldIn, pos);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		else {
			if (itemstack.isEmpty()) {
				/** スニーキング右クリックで CRA を往復 **/
				if (playerIn.isSneaking()) {
					CMEvents.soundStonePlace(worldIn, pos);
					worldIn.setBlockState(pos, state.cycleProperty(CRA), 2); }
				
				if (!playerIn.isSneaking()) {
					CMEvents.textNotSneak(worldIn, pos, playerIn); }
				return true; 
			}
		}
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
			if (this == JPBlock_Blocks.DIRTWALL_SH) { stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_white) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_white, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_orange) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_orange, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_magenta) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_magenta, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lightb) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightb, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_yellow) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_yellow, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lime) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lime, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_pink) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_pink, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_gray) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_gray, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lightg) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightg, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_cyan) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_cyan, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_purple) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_purple, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_blue) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_blue, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_brown) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_brown, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_green) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_green, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_red) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_red, 1, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_black) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_black, 1, 0)); }
		}


		/** Double **/
		if (state.getValue(DOUBLE) == true) {
			if (this == JPBlock_Blocks.DIRTWALL_SH) { stack.add(new ItemStack(Items_Wablock.DIRTWALL_SH, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_white) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_white, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_orange) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_orange, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_magenta) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_magenta, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lightb) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightb, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_yellow) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_yellow, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lime) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lime, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_pink) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_pink, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_gray) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_gray, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_lightg) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_lightg, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_cyan) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_cyan, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_purple) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_purple, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_blue) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_blue, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_brown) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_brown, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_green) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_green, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_red) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_red, 2, 0)); }
			if (this == JPBlock_Blocks.SHIKKUI_SH_black) { stack.add(new ItemStack(Items_Wablock.SHIKKUI_SH_black, 2, 0)); }
		}

		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn,
			BlockPos pos, EntityPlayer playerIn) {

		if (this == JPBlock_Blocks.DIRTWALL_SH) { return new ItemStack(Items_Wablock.DIRTWALL_SH); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_white) { return new ItemStack(Items_Wablock.SHIKKUI_SH_white); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_orange) { return new ItemStack(Items_Wablock.SHIKKUI_SH_orange); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_magenta) { return new ItemStack(Items_Wablock.SHIKKUI_SH_magenta); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_lightb) { return new ItemStack(Items_Wablock.SHIKKUI_SH_lightb); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_yellow) { return new ItemStack(Items_Wablock.SHIKKUI_SH_yellow); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_lime) { return new ItemStack(Items_Wablock.SHIKKUI_SH_lime); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_pink) { return new ItemStack(Items_Wablock.SHIKKUI_SH_pink); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_gray) { return new ItemStack(Items_Wablock.SHIKKUI_SH_gray); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_lightg) { return new ItemStack(Items_Wablock.SHIKKUI_SH_lightg); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_cyan) { return new ItemStack(Items_Wablock.SHIKKUI_SH_cyan); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_purple) { return new ItemStack(Items_Wablock.SHIKKUI_SH_purple); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_blue) { return new ItemStack(Items_Wablock.SHIKKUI_SH_blue); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_brown) { return new ItemStack(Items_Wablock.SHIKKUI_SH_brown); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_green) { return new ItemStack(Items_Wablock.SHIKKUI_SH_green); }
		if (this == JPBlock_Blocks.SHIKKUI_SH_red) { return new ItemStack(Items_Wablock.SHIKKUI_SH_red); }

		return new ItemStack(Items_Wablock.SHIKKUI_SH_black);
	}

}
