package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowMan_Top5 extends Base_SnowManTop {

	/* Property */
	/** TOP5 Brown=13, Green=14, Red=15, Black=16 **/
	public static final String ID = "block_snowman_top5";

	public SnowMan_Top5() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack itemstack = playerIn.getHeldItem(hand);
		
		/** TOP5 Brown=13, Green=14, Red=15, Black=16 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		IBlockState downstate = worldIn.getBlockState(pos.down());
		Block downblock = downstate.getBlock();
		
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (itemstack.isEmpty()) {
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
					.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING))
					.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
			
			if (downblock != Seasonal_Blocks.SNOWMAN_BOT5D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); } 
			if (downblock == Seasonal_Blocks.SNOWMAN_BOT5D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (mode) { }
			
			if (!mode) {
				switch (i) {
				case 1 :
				default :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 12)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 12))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 12), false); }
					break;

				case 2 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 13)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 13))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 13), false); }
					break;

				case 3 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 14)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 14))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 14), false); }
					break;
					
				case 4 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 15)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 15))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 15), false); }
					break;
				} // switch
			} //!mode
		}
		
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

}
