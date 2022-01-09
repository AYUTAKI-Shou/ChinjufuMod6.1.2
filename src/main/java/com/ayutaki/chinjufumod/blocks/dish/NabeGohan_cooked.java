package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NabeGohan_cooked extends BlockBeseNabe {

	public static final String ID = "block_food_nabegohan_1";

	public NabeGohan_cooked() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
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

		if (item == Items_Teatime.Item_DISH && k == 3) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);

			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.GOHAN)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.GOHAN))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.GOHAN), false); }

			if (i == 1) {
				/** 経験値取得 **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) { worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); }
		}

		if (item == Items_Teatime.Item_SARA) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundTake(worldIn, pos);

			if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RICE)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.RICE))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.RICE), false); }

			if (i == 1) {
				/** 経験値取得 **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) { worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
										.withProperty(H_FACING, state.getValue(H_FACING))
										.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); }
		}

		if (item == Items_Teatime.Item_DISH && k == 6) {
			if (i != 4) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DONBURI_MESHI)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.DONBURI_MESHI))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.DONBURI_MESHI), false); }
	
				if (i == 1) {
					/** 経験値取得 **/
					playerIn.addExperience(1);
					worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
				if (i == 2) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2)), 3); }
				if (i == 3) { worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
											.withProperty(H_FACING, state.getValue(H_FACING))
											.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); } }
			
			if (i == 4) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}

		if (item == Items.BOWL) {
			if (i == 1) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
	
				if (itemstack.isEmpty()) {
					playerIn.setHeldItem(hand, new ItemStack(Items_Teatime.MUSHIGOME)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MUSHIGOME))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MUSHIGOME), false); }
	
				/** 経験値取得 **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
	
				worldIn.setBlockState(pos, Dish_Blocks.NABE_kara.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown2.STAGE_1_4, Integer.valueOf(3))); }
			
			if (i != 1) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		}
		
		if ((item != Items_Teatime.Item_DISH || k != 3 || k != 6) && item != Items_Teatime.Item_SARA && item != Items.BOWL) {
			CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(new ItemStack(Items_Teatime.NABEGOHAN, 1, 0)); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.NABE_kara, 1, 0)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.NABEGOHAN, 1, 0);
	}

}
