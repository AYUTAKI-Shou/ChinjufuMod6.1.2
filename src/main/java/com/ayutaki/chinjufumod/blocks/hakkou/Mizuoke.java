package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.items.color.Base_ItemHake;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Mizuoke extends BaseStage4_Face {

	public static final String ID = "block_mizuoke";

	/* Property 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
	public Mizuoke() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.WOOD);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		boolean mode = playerIn.capabilities.isCreativeMode;

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/* 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/** バケツ **/
		if (item == Items.WATER_BUCKET) {

			CMEvents.WaterBucket_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(2))); }
			return true;
		}

		if (item == Items_Teatime.MIZUOKE_full) {

			CMEvents.MIZUOKEfull_Empty(worldIn, pos, playerIn, hand);
			if (i == 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }

			if (i != 1) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(2))); }
			return true;
		}


		/** ガラス瓶 **/
		else if (i >= 3 && item == Items.GLASS_BOTTLE) {

			if (!mode) {
				itemstack.shrink(1);
				ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
				if (!playerIn.inventory.addItemStackToInventory(itemstack3)) { playerIn.dropItem(itemstack3, false); }
				else if (playerIn instanceof EntityPlayerMP) {
					((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); } }
			if (mode) { }

			CMEvents.soundBottleFill(worldIn, pos);

			worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)));
			return true;
		}

		/** 水入りガラス瓶 **/
		else if (item == Items.POTIONITEM && PotionUtils.getPotionFromItem(itemstack) == PotionTypes.WATER) {

			if (!mode) {
				itemstack.shrink(1);
				if (itemstack.isEmpty()) { playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
					playerIn.dropItem(new ItemStack(Items.GLASS_BOTTLE), false); } }
			if (mode) { }

			worldIn.playSound(null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

			if (i <= 2) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 2))); }
			if (i == 3) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
			if (i == 4) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(2))); }
			return true;
		}


		/** 洗う **/
		else {
			if (i >= 3 && item instanceof ItemArmor) {

				ItemArmor itemarmor = (ItemArmor)item;
				if (itemarmor.getArmorMaterial() == ItemArmor.ArmorMaterial.LEATHER && itemarmor.hasColor(itemstack) && !worldIn.isRemote) {
					itemarmor.removeColor(itemstack);

					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)));
					playerIn.addStat(StatList.ARMOR_CLEANED);
					return true;
				}
			} //鎧

			if (i >= 3 && item instanceof ItemBanner) {

				if (TileEntityBanner.getPatterns(itemstack) > 0 && !worldIn.isRemote) {
					ItemStack itemstack1 = itemstack.copy();
					itemstack1.setCount(1);
					TileEntityBanner.removeBannerData(itemstack1);
					playerIn.addStat(StatList.BANNER_CLEANED);

					if (!mode) { itemstack.shrink(1); }

					CMEvents.soundWaterUse(worldIn, pos);
					worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)));

					if (itemstack.isEmpty()) { playerIn.setHeldItem(hand, itemstack1); }
					else if (!playerIn.inventory.addItemStackToInventory(itemstack1)) { playerIn.dropItem(itemstack1, false); }
					else if (playerIn instanceof EntityPlayerMP) {
						((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); }
				}
				return true;
			} //旗

			if (i >= 3 && item instanceof Base_ItemHake) {

				if (!mode) { itemstack.shrink(1); }

				CMEvents.soundWaterUse(worldIn, pos);
				worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i - 2)));
				/** アイテムを返す **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }

				return true;
			}//色筆
		}

		/** 'true' to not put anything on top. **/
		return true;
	}


	/* TickRandom */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		/* 空=1, 2=1.7, 3=3.4, 4=5.1, 水入り5=6.8, 水入り6=8.5 */
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (worldIn.isRainingAt(pos.up())) {
			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); }
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 300;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5625D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		stack.add(new ItemStack(Items_Teatime.MIZUOKE, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.MIZUOKE, 1, 0);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
