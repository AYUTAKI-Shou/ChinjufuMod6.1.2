package com.ayutaki.chinjufumod.blocks.dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;
import com.ayutaki.chinjufumod.registry.Kitchen_Blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Zundou_Udon extends BaseStage4_Face {

	/** 1=生うどん水、2=生うどん湯、3＝茹でうどん水、4=茹でうどん湯 **/
	public static final String ID = "block_zundou_udon";

	public Zundou_Udon() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*寸胴・フライパン*/
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/*湯気のエフェクト*/
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

		/** 1=生うどん水、2=生うどん湯、3＝茹でうどん水、4=茹でうどん湯 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2 || i == 4) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B) {

				for (int la = 0; la < 1; ++la) {
					double d0 = (double) ((float) par2 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d1 = ((double) ((float) par3 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D) + 0.5D;
					double d2 = (double) ((float) par4 + 0.5F) + (double) (par5Random.nextFloat() - 0.5F) * 0.01D;
					double d3 = 0.12D;
					double d4 = 0.17D;
					par1World.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, d0 - d4 + 0.25, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/** 効果音 **/
		if (rand.nextDouble() < 0.1D) {

			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.5F, 0.7F, false);
			}
		}
	}

	/*TickRandom*/
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		/** 1=生うどん水、2=生うどん湯、3＝茹でうどん水、4=茹でうどん湯 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			/* ON */
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
			}
		}

		if (i == 2) {
			/* ON */
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)));
			}

			/** OFF **/
			if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.LIT_FURNACE && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITSTOVE && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITOVEN && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
			}
		}

		if (i == 3) {
			/* ON */
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)));
			}
		}

		if (i == 4) {
			/** OFF **/
			if (worldIn.getBlockState(pos.down()).getBlock() != Blocks.LIT_FURNACE && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITSTOVE && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITOVEN && worldIn
					.getBlockState(pos.down()).getBlock() != Kitchen_Blocks.LIT_KITOVEN_B) {

				worldIn.setBlockState(pos, this.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)));
			}
		}
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 1000;
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=生うどん水、2=生うどん湯、3＝茹でうどん水、4=茹でうどん湯 **/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k;
		k = itemstack.getMetadata();

		if (item == Items_Teatime.PASTA && k == 5) {
			
			if (i == 3) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
				/** Get EXP directly. **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
	
				if (itemstack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.UDON_SU), false); }
				
				worldIn.setBlockState(pos, Dish_Blocks.MIZUMILKNABE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
						/** 1=水、2=湯、3=牛乳、4=ホットミルク **/ }
	
			if (i == 4) {
				/** Collect with an Item **/
				CMEvents.Consume_1Item(playerIn, hand);
				CMEvents.soundTake(worldIn, pos);
				/** Get EXP directly. **/
				playerIn.addExperience(1);
				worldIn.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.5F, 0.75F);
	
				if (itemstack.isEmpty()) {
					playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU)); }
				else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.UDON_SU))) {
					playerIn.dropItem(new ItemStack(Items_Teatime.UDON_SU), false); }
				
				worldIn.setBlockState(pos, Dish_Blocks.MIZUMILKNABE.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
						/** 1=水、2=湯、3=牛乳、4=ホットミルク **/ }
			
			if (i != 3 && i != 4) { CMEvents.textEarlyCollect(worldIn, pos, playerIn); }
		}
		
		if (item != Items_Teatime.PASTA || k != 5) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public boolean canSilkHarvest(World worldIn, EntityPlayer playerIn, int x, int y, int z, int metadata) {
		return false;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();
		/** drop は寸胴に戻して回収 **/
		stack.add(new ItemStack(Items_Teatime.ZUNDOU, 1, 0));
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		/** pick は水入り寸胴 **/
		return new ItemStack(Items_Teatime.ZUNDOUMIZU, 1, 0);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
