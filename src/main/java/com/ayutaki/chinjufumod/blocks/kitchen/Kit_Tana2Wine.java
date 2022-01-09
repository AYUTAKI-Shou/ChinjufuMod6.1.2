package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kit_Tana2Wine extends BaseKit_TanaWine {

	public static final String ID = "block_kit2_wine";

	public Kit_Tana2Wine() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		if (item != Items_Teatime.WINEBOT) {
			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.WINEBOT));
				CMEvents.soundTakeSakeBottle(worldIn, pos);
	
				if (i == 1) { worldIn.setBlockState(pos, Kitchen_Blocks.WINE_TANA.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))); }
				if (i != 1) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 1)), 3); } }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item == Items_Teatime.WINEBOT) {
			if (i != 4) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundDishPlace(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			
			if (i == 4) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Drop Item and Clone Item. */
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(Items_Teatime.WINEBOT, 1)); }

		if (i == 2) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(Items_Teatime.WINEBOT, 2)); }

		if (i == 3) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(Items_Teatime.WINEBOT, 3)); }

		if (i == 4) {
			stack.add(new ItemStack(Items_Teatime.WINE_TANA, 1, 0));
			stack.add(new ItemStack(Items_Teatime.WINEBOT, 4)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.WINE_TANA);
	}

}
