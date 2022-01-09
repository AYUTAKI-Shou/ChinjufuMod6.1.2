package com.ayutaki.chinjufumod.blocks.season;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Seasonal_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SnowMan_Top1 extends Base_SnowManTop {

	/* Property */
	/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
	public static final String ID = "block_snowman_top1";

	public SnowMan_Top1() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k = itemstack.getMetadata();
		
		/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		IBlockState downstate = worldIn.getBlockState(pos.down());
		Block downblock = downstate.getBlock();
		
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		IBlockState colorup2 = Seasonal_Blocks.SNOWMAN_TOP2.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorup3 = Seasonal_Blocks.SNOWMAN_TOP3.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorup4 = Seasonal_Blocks.SNOWMAN_TOP4.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		IBlockState colorup5 = Seasonal_Blocks.SNOWMAN_TOP5.getDefaultState()
				.withProperty(Base_SnowManTop.H_FACING, state.getValue(H_FACING));
		
		IBlockState colordown2 = Seasonal_Blocks.SNOWMAN_BOT2.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown3 = Seasonal_Blocks.SNOWMAN_BOT3.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown4 = Seasonal_Blocks.SNOWMAN_BOT4.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown5 = Seasonal_Blocks.SNOWMAN_BOT5.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		
		IBlockState colordown2d = Seasonal_Blocks.SNOWMAN_BOT2D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown3d = Seasonal_Blocks.SNOWMAN_BOT3D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown4d = Seasonal_Blocks.SNOWMAN_BOT4D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		IBlockState colordown5d = Seasonal_Blocks.SNOWMAN_BOT5D.getDefaultState()
				.withProperty(Base_SnowManBot.H_FACING, state.getValue(H_FACING));
		
		switch (i) {
		case 1 :
		default :
			if (item == Items.CARROT) {
				CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlockState(pos.down(), downstate.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (item != Items.CARROT) { CMEvents.textNotHave(worldIn, pos, playerIn); }
			break;

		/** TOP1 1=normai, 2=carrot, 3=Roma, 4=blank **/
		/** TOP2 White=1, Orange=2, Magenta=3, LightBlue=4 **/
		/** TOP3 Yellow=5, Lime=6, Pink=7, Gray=8, **/
		/** TOP4 LightGray=9, Cyan=10, Purple=11, Blue=12 **/
		/** TOP5 Brown=13, Green=14, Red=15, Black=16 **/
		case 2 :
			if (item == Items_Teatime.FOOD_TOMATO) {
				CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(3)), 3);
				worldIn.setBlockState(pos.down(), downstate.withProperty(STAGE_1_4, Integer.valueOf(3)), 3); }
			
			if (item == Items.BUCKET) {
				CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(4)), 3);
				worldIn.setBlockState(pos.down(), downstate.withProperty(STAGE_1_4, Integer.valueOf(4)), 3); }
			
			if (item == Item.getItemFromBlock(Blocks.WOOL)) {
				CMEvents.Consume_SoundSnow(worldIn, pos, playerIn, hand);
				
				if (downblock != Seasonal_Blocks.SNOWMAN_BOT1D) {
					switch (k) {
					case 0 :
					default :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 1 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 2 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 3 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown2.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
						
					case 4 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 5 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 6 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 7 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown3.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 8 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 9 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 10 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 11 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown4.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 12 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 13 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 14 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;

					case 15 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown5.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
					} // switch k=0-15
				}
				
				if (downblock == Seasonal_Blocks.SNOWMAN_BOT1D) {
					switch (k) {
					case 0 :
					default :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 1 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 2 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 3 :
						worldIn.setBlockState(pos, colorup2.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown2d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
						
					case 4 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;

					case 5 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 6 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 7 :
						worldIn.setBlockState(pos, colorup3.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown3d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 8 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 9 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;
						
					case 10 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;
						
					case 11 :
						worldIn.setBlockState(pos, colorup4.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown4d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;

					case 12 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(1)), 3);
						worldIn.setBlockState(pos.down(), colordown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(1)), 3);
						break;
						
					case 13 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(2)), 3);
						worldIn.setBlockState(pos.down(), colordown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(2)), 3);
						break;

					case 14 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(3)), 3);
						worldIn.setBlockState(pos.down(), colordown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(3)), 3);
						break;

					case 15 :
						worldIn.setBlockState(pos, colorup5.withProperty(Base_SnowManTop.STAGE_1_4, Integer.valueOf(4)), 3);
						worldIn.setBlockState(pos.down(), colordown5d.withProperty(Base_SnowManBot.STAGE_1_4, Integer.valueOf(4)), 3);
						break;
					} // switch k=0-15
				}

			}

			if (item != Items_Teatime.FOOD_TOMATO && item != Items.BUCKET && item != Item.getItemFromBlock(Blocks.WOOL)) {
				CMEvents.textNotHave(worldIn, pos, playerIn); }

			break;

		case 3 :
			if (itemstack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				
				if (!mode) {
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.FOOD_TOMATO))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.FOOD_TOMATO), false); } }
				if (mode) { } 
			
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlockState(pos.down(), downstate.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			break;
			
		case 4 :
			if (itemstack.isEmpty()) {
				CMEvents.soundSnowBreak(worldIn, pos);
				
				if (!mode) {
					if (itemstack.isEmpty()) { 
						playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET)); }
					else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
						playerIn.dropItem(new ItemStack(Items.BUCKET), false); } }
				if (mode) { } 
			
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(2)), 3);
				worldIn.setBlockState(pos.down(), downstate.withProperty(STAGE_1_4, Integer.valueOf(2)), 3); }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			break;
		} // switch
		
		/** 'true' to not put anything on top. **/
		return true;
	}

}
