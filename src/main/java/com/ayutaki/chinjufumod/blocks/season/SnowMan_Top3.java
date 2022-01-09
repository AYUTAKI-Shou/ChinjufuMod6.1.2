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

public class SnowMan_Top3 extends Base_SnowManTop {

	/* Property */
	/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
	public static final String ID = "block_snowman_top3";

	public SnowMan_Top3() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack itemstack = playerIn.getHeldItem(hand);
		
		/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		IBlockState downstate = worldIn.getBlockState(pos.down());
		Block downblock = downstate.getBlock();
		
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (itemstack.isEmpty()) {
			CMEvents.soundSnowBreak(worldIn, pos);
			worldIn.setBlockState(pos, Seasonal_Blocks.SNOWMAN_TOP1.getDefaultState()
					.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING))
					.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
			
			if (downblock != Seasonal_Blocks.SNOWMAN_BOT3D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); } 
			if (downblock == Seasonal_Blocks.SNOWMAN_BOT3D) {
				worldIn.setBlockState(pos.down(), Seasonal_Blocks.SNOWMAN_BOT1D.getDefaultState()
						.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING))
						.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (mode) { }
			
			if (!mode) {
				switch (i) {
				case 1 :
				default :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4), false); }
					break;

				case 2 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5), false); }
					break;

				case 3 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6), false); }
					break;
					
				case 4 :
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7))) {
						playerIn.dropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7), false); }
					break;
				} // switch
			} //!mode
		}
		
		if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}

}
