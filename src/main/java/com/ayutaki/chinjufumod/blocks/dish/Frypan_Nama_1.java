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
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Frypan_Nama_1 extends BaseStage4_Face {

	/**1=玉子焼き、2=ハンバーグ、3=トマトソース、4=きのこソース**/
	public static final String ID = "block_food_frypan_n1";

	public Frypan_Nama_1() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		/*寸胴・フライパン*/
		setSoundType(SoundType.METAL);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		CMEvents.textEarlyCollect(worldIn, pos, playerIn);
		/** 'true' to not put anything on top. **/
		return true;
	}
	
	/*効果音*/
	@Override
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		/**1=玉子焼き、2=ハンバーグ、3=トマトソース、4=きのこソース**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		/* ジュー音 */
		if (i == 1 || i == 2) {

			if (rand.nextDouble() < 0.1D) {

				if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {
					worldIn.playSound(x, y, z, SoundEvents_CM.JUU, SoundCategory.BLOCKS, 0.2F, 1.0F, false);
				}
			}
		}

		/* グツグツ音 */
		else {

			if (rand.nextDouble() < 0.1D) {

				if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
						.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {
					worldIn.playSound(x, y, z, SoundEvents_CM.GUTSUGUTSU, SoundCategory.BLOCKS, 0.2F, 1.0F, false);
				}
			}
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

		/**1=玉子焼き、2=ハンバーグ、3=トマトソース、4=きのこソース**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {

				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_BAKE_1.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
			}
		}

		if (i == 2) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {

				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_BAKE_1.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)));
			}
		}

		if (i == 3) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {

				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_BAKE_1.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(3)));
			}
		}

		if (i == 4) {
			if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.LIT_FURNACE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITSTOVE || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN || worldIn
					.getBlockState(pos.down()).getBlock() == Kitchen_Blocks.LIT_KITOVEN_B ) {

				worldIn.setBlockState(pos, Dish_Blocks.FRYPAN_BAKE_1.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(4)));
			}
		}

		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public int tickRate(World worldIn) {
		/** 1000tick = Minecraft内 1h = リアル時間 50秒 **/
		return 600;
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.125D, 0.75D);
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		/** Have no collision. **/
		return NULL_AABB;
	}

	/* Rendering */
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
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		/**1=玉子焼き、2=ハンバーグ、3=トマトソース、4=きのこソース**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 4)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		/**1=玉子焼き、2=ハンバーグ、3=トマトソース、4=きのこソース**/
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 4); }
		return new ItemStack(Items_Teatime.FRYPAN_NAMA_1, 1, 1);
	}

	/* フェンスとの接続拒否 */
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

}
