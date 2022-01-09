package com.ayutaki.chinjufumod.blocks.cmblock;

import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WakeWater2 extends Block {

	public static final String ID = "block_wake_water2";

	public WakeWater2() {
		super(Material.GLASS);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setHardness(0.1F);
		setResistance(500.0F);

		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.00625D, 1.0D);
	}

	/* TickRandomで消える */
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		if (true) { worldIn.setBlockState(pos, Chinjufu_Blocks.WAKE_WATER3.getDefaultState()); }
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		/* 0.5秒 */
		return 10;
	}

	/* tick処理で消せなかった時の保険。再ログイン時に消去する */
	public void onChunkLoad(World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
	}

	/* 航跡エフェクト */
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		World par1World = worldIn;
		int par2 = x;
		int par3 = y;
		int par4 = z;
		Random par5Random = rand;
		if (true)
			/*la < 4 量*/
			for (int la = 0; la < 10; ++la) {
				/* 1.5F 消える速度？ 0.5D 範囲*/
				double d0 = (double) ((float) par2) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;
				double d1 = (double) ((float) par3) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;
				double d2 = (double) ((float) par4) + (double) (par5Random.nextFloat() - 1.5F) * 0.4D;

				par1World.spawnParticle(EnumParticleTypes.CLOUD, d0 + 0.9D, d1 - 0.14D, d2 + 0.9D, 0.0D, 0.0D, 0.0D);
		}

		if (rand.nextDouble() < 0.1D) {
			/* 音源座標、音源名、音声カテゴリー、音が聞こえる半径、音の高さ */
			worldIn.playSound(x, y, z, SoundEvents_CM.WATER_WAKE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
		}
	}

	/*水を汲む邪魔をしないための措置*/
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();

		/* 水を汲む WATERブロックは、クリエティブで汲めなくしているが保留 */
		if (item == Items.BUCKET) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBucketFill(worldIn, pos);

			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.WATER_BUCKET))) {
				playerIn.dropItem(new ItemStack(Items.WATER_BUCKET), false); }
		}

		/* 大釜(Cauldron)から引用 */
		if (item == Items.GLASS_BOTTLE) {

			ItemStack itemstack3 = PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBottleFill(worldIn, pos);

			if (!playerIn.inventory.addItemStackToInventory(itemstack3)) {
				playerIn.dropItem(itemstack3, false); }
			else if (playerIn instanceof EntityPlayerMP) {
				((EntityPlayerMP)playerIn).sendContainerToPlayer(playerIn.inventoryContainer); }
		}

		/* TTimeItems 海水OKの水桶と土鍋のみ */
		if (item == Items_Teatime.MIZUOKE) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBucketFill(worldIn, pos);

			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE_full))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE_full), false); }
		}

		if (item == Items_Teatime.NABE_kara) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundBucketFill(worldIn, pos);

			if (itemstack.isEmpty()) {
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.NABE_KAISUI), false); }
		}
		
		/** 'true' to not put anything on top. **/
		return true;
	}

	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Items.AIR;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	public SoundType getSoundType(IBlockState state, World worldIn, BlockPos pos, @Nullable Entity entity) {
		return super.getSoundType(state, worldIn, pos, entity);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
