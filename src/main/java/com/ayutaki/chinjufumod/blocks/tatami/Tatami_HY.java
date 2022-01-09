package com.ayutaki.chinjufumod.blocks.tatami;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tatami_HY extends BaseFacingSlabW {

	/* Collision */
	private static final AxisAlignedBB DOUBLE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final AxisAlignedBB BOTTOM_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	private static final AxisAlignedBB TOP_AABB = new AxisAlignedBB(0.0D, 0.5D, 0.0D, 1.0D, 1.0D, 1.0D);

	public Tatami_HY(String unlocalizedName) {
		super(unlocalizedName);
		setCreativeTab(ChinjufuModTabs.WADECO);

		setHardness(1.0F);
		setResistance(5.0F);
		setSoundType(SoundType.PLANT);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/* Slab */
		/** BOTTOM はブロック上面から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) != BaseFacingSlabW.SlabHalf.TOP && facing == EnumFacing.UP) {

			if ((this == JPDeco_Blocks.TATAMI_HY && item == Items_Wadeco.TATAMI_HY) ||
					(this == JPDeco_Blocks.TATAMI_HY_white && item == Items_Wadeco.TATAMI_HY_white) ||
					(this == JPDeco_Blocks.TATAMI_HY_orange && item == Items_Wadeco.TATAMI_HY_orange) ||
					(this == JPDeco_Blocks.TATAMI_HY_magenta && item == Items_Wadeco.TATAMI_HY_magenta) ||
					(this == JPDeco_Blocks.TATAMI_HY_yellow && item == Items_Wadeco.TATAMI_HY_yellow) ||
					(this == JPDeco_Blocks.TATAMI_HY_lime && item == Items_Wadeco.TATAMI_HY_lime) ||
					(this == JPDeco_Blocks.TATAMI_HY_pink && item == Items_Wadeco.TATAMI_HY_pink) ||
					(this == JPDeco_Blocks.TATAMI_HY_gray && item == Items_Wadeco.TATAMI_HY_gray) ||
					(this == JPDeco_Blocks.TATAMI_HY_lightb && item == Items_Wadeco.TATAMI_HY_lightb) ||
					(this == JPDeco_Blocks.TATAMI_HY_lightg && item == Items_Wadeco.TATAMI_HY_lightg) ||
					(this == JPDeco_Blocks.TATAMI_HY_cyan && item == Items_Wadeco.TATAMI_HY_cyan) ||
					(this == JPDeco_Blocks.TATAMI_HY_purple && item == Items_Wadeco.TATAMI_HY_purple) ||
					(this == JPDeco_Blocks.TATAMI_HY_blue && item == Items_Wadeco.TATAMI_HY_blue) ||
					(this == JPDeco_Blocks.TATAMI_HY_brown && item == Items_Wadeco.TATAMI_HY_brown) ||
					(this == JPDeco_Blocks.TATAMI_HY_green && item == Items_Wadeco.TATAMI_HY_green) ||
					(this == JPDeco_Blocks.TATAMI_HY_red && item == Items_Wadeco.TATAMI_HY_red) ||
					(this == JPDeco_Blocks.TATAMI_HY_black && item == Items_Wadeco.TATAMI_HY_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** TOP はブロック下端から Double にできる **/
		if (state.getValue(DOUBLE) != true && state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP && (double)hitY <= 0.6D) {

			if ((this == JPDeco_Blocks.TATAMI_HY && item == Items_Wadeco.TATAMI_HY) ||
					(this == JPDeco_Blocks.TATAMI_HY_white && item == Items_Wadeco.TATAMI_HY_white) ||
					(this == JPDeco_Blocks.TATAMI_HY_orange && item == Items_Wadeco.TATAMI_HY_orange) ||
					(this == JPDeco_Blocks.TATAMI_HY_magenta && item == Items_Wadeco.TATAMI_HY_magenta) ||
					(this == JPDeco_Blocks.TATAMI_HY_yellow && item == Items_Wadeco.TATAMI_HY_yellow) ||
					(this == JPDeco_Blocks.TATAMI_HY_lime && item == Items_Wadeco.TATAMI_HY_lime) ||
					(this == JPDeco_Blocks.TATAMI_HY_pink && item == Items_Wadeco.TATAMI_HY_pink) ||
					(this == JPDeco_Blocks.TATAMI_HY_gray && item == Items_Wadeco.TATAMI_HY_gray) ||
					(this == JPDeco_Blocks.TATAMI_HY_lightb && item == Items_Wadeco.TATAMI_HY_lightb) ||
					(this == JPDeco_Blocks.TATAMI_HY_lightg && item == Items_Wadeco.TATAMI_HY_lightg) ||
					(this == JPDeco_Blocks.TATAMI_HY_cyan && item == Items_Wadeco.TATAMI_HY_cyan) ||
					(this == JPDeco_Blocks.TATAMI_HY_purple && item == Items_Wadeco.TATAMI_HY_purple) ||
					(this == JPDeco_Blocks.TATAMI_HY_blue && item == Items_Wadeco.TATAMI_HY_blue) ||
					(this == JPDeco_Blocks.TATAMI_HY_brown && item == Items_Wadeco.TATAMI_HY_brown) ||
					(this == JPDeco_Blocks.TATAMI_HY_green && item == Items_Wadeco.TATAMI_HY_green) ||
					(this == JPDeco_Blocks.TATAMI_HY_red && item == Items_Wadeco.TATAMI_HY_red) ||
					(this == JPDeco_Blocks.TATAMI_HY_black && item == Items_Wadeco.TATAMI_HY_black)) {

				CMEvents.Consume_1Item(playerIn, hand);
				worldIn.playSound(null, pos, SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
				worldIn.setBlockState(pos, state.cycleProperty(DOUBLE), 2);
				return true; }
		}

		/** 素手回収は、誤回収が多いため却下
		if (state.getValue(DOUBLE) != true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == JPDeco_Blocks.TATAMI_HY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(JPDeco_Blocks.TATAMI_HY, 1)); }

			CMEvents.soundItemPick(worldIn, pos);
			return worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		Double
		Double は素手で回収可能
		if (state.getValue(DOUBLE) == true && itemstack.isEmpty() && facing == EnumFacing.UP) {

			if (this == JPDeco_Blocks.TATAMI_HY) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(JPDeco_Blocks.TATAMI_HY, 1)); }

			CMEvents.soundItemPick(worldIn, pos);
			return worldIn.setBlockState(pos, this.getDefaultState().withProperty(H_FACING, state.getValue(H_FACING))
					.withProperty(DOUBLE, Boolean.valueOf(false)).withProperty(BaseFacingSlabW.HALF, BaseFacingSlabW.SlabHalf.BOTTOM));
		} **/

		/** 側面で設置可能にするため false **/
		return false;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		if (state.getValue(DOUBLE) == true) {
			return DOUBLE_AABB;
		}

		else {
			return (state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP)? TOP_AABB : BOTTOM_AABB;
		}
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean t_f) {

		boolean flag = (state.getValue(DOUBLE) == true);
		BaseFacingSlabW.SlabHalf enumhalf = state.getValue(HALF);

		switch(enumhalf) {

			case TOP :
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : TOP_AABB); /** flag? true : false; **/
				break;
			case BOTTOM :
			default:
				super.addCollisionBoxToList(pos, entityBox, collidingBoxes, flag? DOUBLE_AABB : BOTTOM_AABB);
				break;
		}
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	public boolean isTopSolid(IBlockState state) {
		return (state.getValue(DOUBLE) == true || state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP);
	}

	/* 側面に松明などを置けるようにする */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {

		if (state.getValue(DOUBLE) == true || (face == EnumFacing.UP && state.getValue(HALF) == BaseFacingSlabW.SlabHalf.TOP)) {
			return BlockFaceShape.SOLID;
		}

		else {
			return (face == EnumFacing.DOWN && state.getValue(HALF) == BaseFacingSlabW.SlabHalf.BOTTOM)? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
		}
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
			if (this == JPDeco_Blocks.TATAMI_HY) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_white) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_white, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_orange) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_orange, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_magenta) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_magenta, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lightb) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lightb, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_yellow) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_yellow, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lime) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lime, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_pink) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_pink, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_gray) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_gray, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lightg) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lightg, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_cyan) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_cyan, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_purple) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_purple, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_blue) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_blue, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_brown) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_brown, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_green) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_green, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_red) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_red, 1, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_black) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_black, 1, 0)); }
		}


		/** Double **/
		if (state.getValue(DOUBLE) == true) {
			if (this == JPDeco_Blocks.TATAMI_HY) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_white) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_white, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_orange) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_orange, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_magenta) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_magenta, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lightb) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lightb, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_yellow) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_yellow, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lime) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lime, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_pink) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_pink, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_gray) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_gray, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_lightg) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_lightg, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_cyan) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_cyan, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_purple) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_purple, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_blue) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_blue, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_brown) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_brown, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_green) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_green, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_red) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_red, 2, 0)); }
			if (this == JPDeco_Blocks.TATAMI_HY_black) { stack.add(new ItemStack(Items_Wadeco.TATAMI_HY_black, 2, 0)); }
		}
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		if (this == JPDeco_Blocks.TATAMI_HY_white) { return new ItemStack(Items_Wadeco.TATAMI_HY_white); }
		if (this == JPDeco_Blocks.TATAMI_HY_orange) { return new ItemStack(Items_Wadeco.TATAMI_HY_orange); }
		if (this == JPDeco_Blocks.TATAMI_HY_magenta) { return new ItemStack(Items_Wadeco.TATAMI_HY_magenta); }
		if (this == JPDeco_Blocks.TATAMI_HY_lightb) { return new ItemStack(Items_Wadeco.TATAMI_HY_lightb); }
		if (this == JPDeco_Blocks.TATAMI_HY_yellow) { return new ItemStack(Items_Wadeco.TATAMI_HY_yellow); }
		if (this == JPDeco_Blocks.TATAMI_HY_lime) { return new ItemStack(Items_Wadeco.TATAMI_HY_lime); }
		if (this == JPDeco_Blocks.TATAMI_HY_pink) { return new ItemStack(Items_Wadeco.TATAMI_HY_pink); }
		if (this == JPDeco_Blocks.TATAMI_HY_gray) { return new ItemStack(Items_Wadeco.TATAMI_HY_gray); }
		if (this == JPDeco_Blocks.TATAMI_HY_lightg) { return new ItemStack(Items_Wadeco.TATAMI_HY_lightg); }
		if (this == JPDeco_Blocks.TATAMI_HY_cyan) { return new ItemStack(Items_Wadeco.TATAMI_HY_cyan); }
		if (this == JPDeco_Blocks.TATAMI_HY_purple) { return new ItemStack(Items_Wadeco.TATAMI_HY_purple); }
		if (this == JPDeco_Blocks.TATAMI_HY_blue) { return new ItemStack(Items_Wadeco.TATAMI_HY_blue); }
		if (this == JPDeco_Blocks.TATAMI_HY_brown) { return new ItemStack(Items_Wadeco.TATAMI_HY_brown); }
		if (this == JPDeco_Blocks.TATAMI_HY_green) { return new ItemStack(Items_Wadeco.TATAMI_HY_green); }
		if (this == JPDeco_Blocks.TATAMI_HY_red) { return new ItemStack(Items_Wadeco.TATAMI_HY_red); }
		if (this == JPDeco_Blocks.TATAMI_HY_black) { return new ItemStack(Items_Wadeco.TATAMI_HY_black); }
		return new ItemStack(Items_Wadeco.TATAMI_HY);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_tatami", meta));
	}

}
