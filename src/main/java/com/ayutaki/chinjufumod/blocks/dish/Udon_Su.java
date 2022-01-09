package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Udon_Su extends BaseStage4_FaceDown {

	public static final String ID = "block_food_udonsu_1";

	private static final AxisAlignedBB AABB = new AxisAlignedBB(0.3625D, 0.0D, 0.3625D, 0.6375D, 0.1875D, 0.6375D);
	private static final AxisAlignedBB AABB_DOWN = new AxisAlignedBB(0.3625D, -0.5D, 0.3625D, 0.6375D, 0.01D, 0.6375D);

	public Udon_Su() {
		super(Material.WOOD);
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

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** 肉うどん **/
		if (item == Items.COOKED_BEEF) {
			if (i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlockState(pos, Dish_Blocks.UDON_NIKU.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(1))); }
			
			if (i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** 月見うどん **/
		if (item == Items.EGG) {
			if (i == 1) {
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundWaterUse(worldIn, pos);
				
				worldIn.setBlockState(pos, Dish_Blocks.UDON_TSUKIMI.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_FaceDown.STAGE_1_4, Integer.valueOf(1))); }
			
			if (i != 1) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		if (item != Items.COOKED_BEEF && item != Items.EGG) {
			/** Hand is Empty. **/
			if (itemstack.isEmpty()) {
			
				if (i != 4) {
					CMEvents.soundEat(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3);
		
					if (i == 1) {
						/** 満腹は2で肉メモリの1個分 **/
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0)); }
		
					if (i == 2) {
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0)); }
		
					if (i == 3) {
						((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.SATURATION, 2, 0)); } }
				
				if (i == 4) { CMEvents.textIsEmpty(worldIn, pos, playerIn); } }
			
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/*Collision*/
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		boolean flag= !((Boolean)state.getValue(DOWN)).booleanValue();

		/** !down= true : false **/
		return flag? AABB : AABB_DOWN;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.UDON_SU, 1, 0)); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 6)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.UDON_SU, 1, 0);
	}

}
