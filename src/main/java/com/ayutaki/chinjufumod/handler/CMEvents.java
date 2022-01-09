package com.ayutaki.chinjufumod.handler;

import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CMEvents {

	/* Item Sound */
	public static void soundKKBreak(World worldIn, EntityPlayer playerIn) {
		worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.MASTER, 1.0F, 1.0F); }
	
	public static void textKKError(World worldIn, EntityPlayer playerIn) {
		worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.ERROR, SoundCategory.MASTER, 1.0F, 1.0F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.waterlogged", new Object[0]), true); }
	
	public static void soundPaint(World worldIn, EntityPlayer playerIn, BlockPos blockpos) {
		worldIn.playSound(playerIn, blockpos, SoundEvents_CM.PAINT, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundChisel(World worldIn, EntityPlayer playerIn, BlockPos blockpos) {
		worldIn.playSound(playerIn, blockpos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundWash(World worldIn, EntityPlayer playerIn, BlockPos blockpos) {
		worldIn.playSound(playerIn, blockpos, SoundEvents_CM.WATER_SPLASH, SoundCategory.BLOCKS, 0.5F, 1.2F); }
	
	
	/* Sound Only */
	public static void soundAmado(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.AMADO_CANCEL, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundAmadoWin(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.AMADO_CANCEL, SoundCategory.BLOCKS, 0.8F, 1.1F); }


	public static void soundBottleFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.7F, 1.0F); }
	
	public static void soundBowlFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 0.8F, 1.2F); }
	
	/*public static void soundBubble(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS, 2.0F, 0.8F); }*/
	
	public static void soundBucketFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 0.7F, 1.0F); }
	
	
	public static void soundCheesePlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 1.2F); }
	
	public static void soundDishPlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F); }
	
	public static void soundDrink(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.GOKU, SoundCategory.PLAYERS, 1.0F, 1.0F); }
	
	public static void soundEat(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.PAKU, SoundCategory.PLAYERS, 1.0F, 1.0F); }


	public static void soundFlint(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundFireExting(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.2F, 2.0F); }
	
	public static void soundFusumaL(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.FUSUMA, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundFusumaS(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.FUSUMA_SHORT, SoundCategory.BLOCKS, 1.0F, 1.0F); }


	public static void soundHikidoL(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.HIKIDO, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundHikidoS(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.HIKIDO_SHORT, SoundCategory.BLOCKS, 0.7F, 1.0F); }


	public static void soundItemPick(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F); }
	
	public static void soundKinuzure(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.KINUZURE, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundOpenOven(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.OPEN_OVEN, SoundCategory.BLOCKS, 0.8F, 1.0F); }
	
	
	public static void soundSakeBottleFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.7F, 0.8F); }
	
	public static void soundSakeGlassFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.SAKE, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundSitChair(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.SIT_CHAIR, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundSnowBreak(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); } //dropRottenfood

	public static void soundSnowPlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 0.8F, 1.2F); }
	
	public static void soundStoneButton_Off(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.8F, 0.65F); }
	
	public static void soundStoneButton_On(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundStoneBreak(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundStonePlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_STONE_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	
	public static void soundTakeSakeBottle(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F);
		worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 0.7F, 0.8F); }
	
	public static void soundTake(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F); }
	
	public static void soundTake_Pick(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F); }
	
	public static void soundTeaFill(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.TEA, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundTouchBlock(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F); }

	
	public static void soundWaterUse(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WATER_SPLASH, SoundCategory.BLOCKS, 0.5F, 1.2F); }
	
	public static void soundWin_Open(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_OPEN, SoundCategory.BLOCKS, 0.8F, 1.1F); }
	
	public static void soundWin_Close(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_CLOSE, SoundCategory.BLOCKS, 0.8F, 1.1F); }
	
	public static void soundWin_OpenL(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundWin_CloseL(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WINDOW_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void soundWoodenDishPlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 3.0F); }
	
	public static void soundWoodPlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F); }

	public static void soundWoolPlace(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_CLOTH_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F); }
	
	public static void soundWrite(World worldIn, BlockPos pos) {
		worldIn.playSound(null, pos, SoundEvents_CM.WRITE_REPORT, SoundCategory.BLOCKS, 1.0F, 1.0F); }

	
	/* Sound & Message */
	public static void textEarlyCollect(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.earlycollect", new Object[0]), true); }
	
	public static void textEarlyUse(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.earlyuse", new Object[0]), true); }
	
	public static void textFullItem(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.fullitem", new Object[0]), true); }
	
	public static void textNoPlace(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.noplace", new Object[0]), true); }
	
	public static void textNotEnough_Items(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.notenough_items", new Object[0]), true); }
	
	public static void textNotHave(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.nothave", new Object[0]), true); }
	
	public static void textNotSneak(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.notsneak", new Object[0]), true); }
	
	public static void textIsBlocked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.blocked", new Object[0]), true); }

	public static void textIsEmpty(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.empty", new Object[0]), true); }
	
	public static void textIsSleeping(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.sleeping", new Object[0]), true); }
	
	public static void textIsWaterlogged(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.waterlogged", new Object[0]), true); }
	
	public static void textRequestHeat(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.heat", new Object[0]), true); }
	
	public static void textRequestCool(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.cool", new Object[0]), true); }
	
	public static void textNotEnough_EXP(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents_CM.TOUCH_BLOCK, SoundCategory.BLOCKS, 1.0F, 0.75F);
		playerIn.sendStatusMessage(new TextComponentTranslation("text.chinjufumod.rightclick.notenough_exp", new Object[0]), true); }
	
	
	/** Sound & Message & add Item **/
	public static void takeKinoko(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F);
		playerIn.inventory.addItemStackToInventory(new ItemStack(Blocks.BROWN_MUSHROOM, 1)); }
	
	public static void takeSakana(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.BLOCKS, 0.8F, 1.2F);
		worldIn.playSound(null, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, 2.0F);
		playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KUSHI_SAKANA_C, 1)); }
	
	
	/** Item consumption by mode. **/
	public static void Consume_1Item(EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		if (!mode) { itemstack.shrink(1); }
		if (mode) { } }
	
	public static void Consume_4Item(EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		if (!mode) { itemstack.shrink(4); }
		if (mode) { } }
	
	public static void Consume_8Item(EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		if (!mode) { itemstack.shrink(8); }
		if (mode) { } }
	
	public static void WaterBucket_Empty(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BUCKET))) {
				playerIn.dropItem(new ItemStack(Items.BUCKET), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void MIZUOKEfull_Empty(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void Consume_SoundSnow(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		if (!mode) { itemstack.shrink(1); }
		if (mode) { }
		
		worldIn.playSound(null, pos, SoundEvents.BLOCK_SNOW_PLACE, SoundCategory.BLOCKS, 0.8F, 1.2F); }
	
	public static void SoysauceTo2(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_2)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_2))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SHOUYU_bot_2), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoysauceTo3(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_3)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_3))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SHOUYU_bot_3), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoysauceTo4(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_4)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.SHOUYU_bot_4))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.SHOUYU_bot_4), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
	public static void SoySauceToBottle(World worldIn, BlockPos pos, EntityPlayer playerIn, EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;
		
		if (!mode) { itemstack.shrink(1);
			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
				playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); } }
		if (mode) { } 
		
		worldIn.playSound(null, pos, SoundEvents_CM.SHOUYU, SoundCategory.BLOCKS, 1.0F, 1.0F); }
	
}
