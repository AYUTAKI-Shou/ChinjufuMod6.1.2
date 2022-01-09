package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

public class TeaPot extends BaseStage4_FaceDown {

	public static final String ID = "block_food_teapot_1";

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.375, 0.0, 0.375, 0.625, 0.25, 0.75);

	private static final AxisAlignedBB AABB_DOWN_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_DOWN_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_DOWN_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);
	private static final AxisAlignedBB AABB_DOWN_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.125, -0.5, 0.375, 0.375, 0.01, 0.75);

	public TeaPot() {
		super(Material.WOOD);

		setCreativeTab(ChinjufuModTabs.TEATIME);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*鍋・皿*/
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k;
		k = itemstack.getMetadata();

		if (item == Items_Teatime.Item_DISH && k == 2) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTeaFill(worldIn, pos);

			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.TEACUP)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.TEACUP))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.TEACUP), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) { worldIn.setBlockState(pos, Dish_Blocks.TEAPOT_kara.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(1))); }
		}
		
		if (item != Items_Teatime.Item_DISH || k != 2) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		state = state.getActualState(source, pos);
		EnumFacing direction = (EnumFacing)state.getValue(H_FACING);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		switch (direction) {
		case SOUTH:
			return flag? AABB_SOUTH : AABB_DOWN_SOUTH;

		case EAST:
			return flag? AABB_EAST : AABB_DOWN_EAST;

		case WEST:
			return flag? AABB_WEST : AABB_DOWN_WEST;

		case NORTH:
		default:
			/** !down= true : false **/
			return flag? AABB_NORTH : AABB_DOWN_NORTH;
		}
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.TEAPOT, 1, 0)); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.TEAPOT_kara, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.TEAPOT, 1, 0);
	}

}
