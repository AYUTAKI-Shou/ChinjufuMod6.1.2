package com.ayutaki.chinjufumod.blocks.garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Lit_Longtourou extends BaseStage4_Face {

	/* Property */

	public static final String ID = "lit_longtourou_top";

	public Lit_Longtourou() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);

		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(5.0F);
		/** ハーフ・椅子・机=2, 障子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(0);

		/* グロウストーン=1.0F 松明=0.9375F */
		setLightLevel(1.0F);
	}

	/* 煙 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.7D;
		double d2 = (double)pos.getZ() + 0.5D;

		if (rand.nextDouble() < 0.05D) {
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1 - 0.2D, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	/* 素手で消火 */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack itemstack = playerIn.getHeldItem(hand);
		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (itemstack.isEmpty()) {
			CMEvents.soundFireExting(worldIn, pos);

			if (i == 1) {
				worldIn.setBlockState(pos, Garden_Blocks.LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Longtourou_Top.STAGE_1_4, Integer.valueOf(1))); }

			if (i == 2) {
				worldIn.setBlockState(pos, Garden_Blocks.LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Longtourou_Top.STAGE_1_4, Integer.valueOf(2))); }

			if (i == 3) {
				worldIn.setBlockState(pos, Garden_Blocks.LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Longtourou_Top.STAGE_1_4, Integer.valueOf(3))); }

			if (i == 4) {
				worldIn.setBlockState(pos, Garden_Blocks.LONGTOUROU_TOP.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(Longtourou_Top.STAGE_1_4, Integer.valueOf(4))); }
		}
		/** 'true' to not put anything on top. **/
		return true;
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (worldIn.getBlockState(pos.down()).getBlock() == Garden_Blocks.LONGTOUROU_BOT) {
				worldIn.destroyBlock(pos.down(), false);
		}
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.875D, 0.875D);
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

	/* Rendering */
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/* Harvest by Pickaxe. */
	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return 0;
	}

	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 1) { stack.add(new ItemStack(Items_Wadeco.LONGTOUROU, 1, 1)); }
		if (i == 2) { stack.add(new ItemStack(Items_Wadeco.LONGTOUROU, 1, 2)); }
		if (i == 3) { stack.add(new ItemStack(Items_Wadeco.LONGTOUROU, 1, 3)); }
		if (i == 4) { stack.add(new ItemStack(Items_Wadeco.LONGTOUROU, 1, 4)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		if (i == 2) { return new ItemStack(Items_Wadeco.LONGTOUROU, 1, 2); }
		if (i == 3) { return new ItemStack(Items_Wadeco.LONGTOUROU, 1, 3); }
		if (i == 4) { return new ItemStack(Items_Wadeco.LONGTOUROU, 1, 4); }
		return new ItemStack(Items_Wadeco.LONGTOUROU, 1, 1);
	}

}
