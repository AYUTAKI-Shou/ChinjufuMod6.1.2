package com.ayutaki.chinjufumod.blocks.kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Kit_sink_bot extends BaseStage2_Face {

	public static final String ID = "block_kit_sink1";

	public Kit_sink_bot() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*木製*/
		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(10.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		if (i == 1) {
			/** Hand is empty. **/
			if (itemstack.isEmpty()) {
				if (worldIn.getBlockState(new BlockPos(x, y - 2, z)).getBlock() == Blocks.WATER) {
					worldIn.playSound(null, pos, SoundEvents_CM.WATER_START, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(2)));
					worldIn.setBlockState(pos.up(), Kitchen_Blocks.KIT_SINK_TOP.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(STAGE_1_2, Integer.valueOf(2))); }
				
				if (worldIn.getBlockState(new BlockPos(x, y - 2, z)).getBlock() != Blocks.WATER) {
					CMEvents.soundTouchBlock(worldIn, pos); } }
			
			/** Hand is not empty. **/
			if (!itemstack.isEmpty()) { CMEvents.textFullItem(worldIn, pos, playerIn); }
			
			return true;
		}


		if (i != 1) {
			/*水を止める*/
			if (itemstack.isEmpty()) {
				worldIn.playSound(null, pos, SoundEvents_CM.WATER_STOP, SoundCategory.BLOCKS, 1.0F, 1.0F);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Kitchen_Blocks.KIT_SINK_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_2, Integer.valueOf(1)));
				return true;
			}

			/*水を汲む*/
			if (item == Items.BUCKET) {
				CMEvents.Consume_1Item(playerIn, hand);			
				CMEvents.soundBucketFill(worldIn, pos);
				
				if (itemstack.isEmpty()) {
					((EntityPlayer) playerIn).inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
					playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false); }
				return true;
			}

			/*大釜(Cauldron)から引用*/
			if (item == Items.GLASS_BOTTLE) {
				ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundBottleFill(worldIn, pos);
				
				if (!playerIn.inventory.addItemStackToInventory(itemstack3)) {
					playerIn.dropItem(itemstack3, false); }
				else if (playerIn instanceof EntityPlayerMP) {
					((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); }
				return true;
			}

			/* TTimeItems */
			if (item == Items_Teatime.MIZUOKE) {
				CMEvents.Consume_1Item(playerIn, hand);		
				CMEvents.soundBucketFill(worldIn, pos);
				
				if (itemstack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
				return true;
			}

			if (item == Items_Teatime.Item_YAKAN_kara) {
				CMEvents.Consume_1Item(playerIn, hand);	
				CMEvents.soundBucketFill(worldIn, pos);
				
				if (itemstack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KETTLE_full))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.KETTLE_full), false); }
				return true;
			}

			/* シンク台は真水のため除外 */
			if (item == Items_Teatime.NABE_kara) { 
				CMEvents.textNotHave(worldIn, pos, playerIn);
				return true; }

			if (item == Items_Teatime.ZUNDOU) {
				CMEvents.Consume_1Item(playerIn, hand);		
				CMEvents.soundBucketFill(worldIn, pos);
				
				if (itemstack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOUMIZU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOUMIZU))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.ZUNDOUMIZU), false); }
				return true;
			}

			if (item == Items_Teatime.KEIRYO_CUP) {
				CMEvents.Consume_1Item(playerIn, hand);		
				CMEvents.soundBottleFill(worldIn, pos);
				
				if (itemstack.isEmpty()) {
					((EntityPlayer) playerIn).inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_F)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.KEIRYO_CUP_F))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.KEIRYO_CUP_F), false); }
				return true;
			}

		}
		/* 1.15.2 に合わせて false */
		return false;
	}


	/*2ブロック下が水ブロックではなくなると、水が止まる*/
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		int i = ((Integer)state.getValue(STAGE_1_2)).intValue();

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		/*「!=」がノットイコール*/
		if (i != 1) {
			if (worldIn.getBlockState(new BlockPos(x, y - 2, z)).getBlock() != Blocks.WATER) {
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_2, Integer.valueOf(1)));
				worldIn.setBlockState(pos.up(), Kitchen_Blocks.KIT_SINK_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(STAGE_1_2, Integer.valueOf(1))); }
		}

		if (i == 1) { }

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		return 20;
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	@Override
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.up()).getBlock() == Kitchen_Blocks.KIT_SINK_TOP) {
				worldIn.destroyBlock(pos.up(), false);
		}
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Teatime.KIT_SINK1, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.KIT_SINK1, 1, 0);
	}

}
