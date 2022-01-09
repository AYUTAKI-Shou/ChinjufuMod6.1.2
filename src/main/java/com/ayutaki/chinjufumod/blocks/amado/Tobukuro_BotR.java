package com.ayutaki.chinjufumod.blocks.amado;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage3_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.base.CollisionHelper;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.Slidingdoor_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Tobukuro_BotR extends BaseStage3_Face {

	/* Collision */
	private static final AxisAlignedBB AABB_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.0, -0.03125, -0.03125, 0.3125, 1.0, 1.03125);
	private static final AxisAlignedBB AABB_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.0, -0.03125, -0.03125, 0.3125, 1.0, 1.03125);
	private static final AxisAlignedBB AABB_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.0, -0.03125, -0.03125, 0.3125, 1.0, 1.03125);
	private static final AxisAlignedBB AABB_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.0, -0.03125, -0.03125, 0.3125, 1.0, 1.03125);
	private static final AxisAlignedBB[] AABB = { AABB_SOUTH, AABB_WEST, AABB_NORTH, AABB_EAST };

	/** 1=4枚、2=3枚、3=2枚 **/
	public Tobukuro_BotR() {
		super(Material.WOOD);

		setHardness(2.0F);
		setResistance(5.0F);
		setSoundType(SoundType.WOOD);
		/** ハーフ・机=2, 障子・椅子=1, ガラス戸・窓=0, web=1, ice=3 **/
		setLightOpacity(1);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		/** 1=4枚、2=3枚、3=2枚 **/
		int i = ((Integer)state.getValue(STAGE_1_3)).intValue();
		EnumFacing direction = state.getValue(H_FACING);

		IBlockState northstate = worldIn.getBlockState(pos.north());
		IBlockState southstate = worldIn.getBlockState(pos.south());
		IBlockState eaststate = worldIn.getBlockState(pos.east());
		IBlockState weststate = worldIn.getBlockState(pos.west());

		double x = (double) pos.getX();
		double y = (double) pos.getY();
		double z = (double) pos.getZ();

		CMEvents.soundAmado(worldIn, pos);

		if (this == Slidingdoor_Blocks.TOBUKURO_BOTR) {

			Block tobuBotR2 = Slidingdoor_Blocks.TOBUKURO_BOTR2;
			Block tobuTopR2 = Slidingdoor_Blocks.TOBUKURO_TOPR2;
			Block tobuTopR = Slidingdoor_Blocks.TOBUKURO_TOPR;

			Block amadoBot = Slidingdoor_Blocks.AMADO_BOT;
			Block amadoTop = Slidingdoor_Blocks.AMADO_TOP;

			switch (direction) {
			case NORTH :
			default :
				if (weststate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x - 1, y, z), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!weststate.getMaterial().isReplaceable()) { }
				break;

			case SOUTH :
				if (eaststate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x + 1, y, z), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!eaststate.getMaterial().isReplaceable()) { }
				break;

			case EAST :
				if (northstate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x, y, z - 1), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!northstate.getMaterial().isReplaceable()) { }
				break;
				
			case WEST :
				if (southstate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x, y, z + 1), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!southstate.getMaterial().isReplaceable()) { }
				break;
			} // switch
		} // DarkOak

		if (this == Slidingdoor_Blocks.TOBUKUROS_BOTR) {

			Block tobuBotR2 = Slidingdoor_Blocks.TOBUKUROS_BOTR2;
			Block tobuTopR2 = Slidingdoor_Blocks.TOBUKUROS_TOPR2;
			Block tobuTopR = Slidingdoor_Blocks.TOBUKUROS_TOPR;

			Block amadoBot = Slidingdoor_Blocks.AMADOS_BOT;
			Block amadoTop = Slidingdoor_Blocks.AMADOS_TOP;

			switch (direction) {
			case NORTH :
			default :
				if (weststate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x - 1, y, z), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x - 1, y + 1, z), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!weststate.getMaterial().isReplaceable()) { }
				break;

			case SOUTH :
				if (eaststate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x + 1, y, z), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x + 1, y + 1, z), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!eaststate.getMaterial().isReplaceable()) { }
				break;

			case EAST :
				if (northstate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x, y, z - 1), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x, y + 1, z - 1), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!northstate.getMaterial().isReplaceable()) { }
				break;
				
			case WEST :
				if (southstate.getMaterial().isReplaceable()) {
					CMEvents.soundFusumaS(worldIn, pos);

					worldIn.setBlockState(new BlockPos(x, y, z + 1), amadoBot.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));
					worldIn.setBlockState(new BlockPos(x, y + 1, z + 1), amadoTop.getDefaultState()
							.withProperty(H_FACING, state.getValue(H_FACING))
							.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(1)));

					if (i != 3) {
						worldIn.setBlockState(pos, state.withProperty(STAGE_1_3, Integer.valueOf(i + 1)));
						worldIn.setBlockState(pos.up(), tobuTopR.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(STAGE_1_3, Integer.valueOf(i + 1))); }

					if (i == 3) {
						worldIn.setBlockState(pos, tobuBotR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1)));
						worldIn.setBlockState(pos.up(), tobuTopR2.getDefaultState()
								.withProperty(H_FACING, state.getValue(H_FACING))
								.withProperty(BaseStage2_Face.STAGE_1_2, Integer.valueOf(1))); } }
				
				if (!southstate.getMaterial().isReplaceable()) { }
				break;
			} // switch
		} // Spruce

		return true;
	}


	/* 設置制限 */
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos).getMaterial().isReplaceable() &&
				worldIn.getBlockState(pos.up()).getMaterial().isReplaceable();
	}

	/* 同時破壊とドロップの指定 */
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {

		IBlockState blockstate = worldIn.getBlockState(pos.up());
		/** if 内のブロックを同時に破壊。false だと同時破壊側のドロップは無し **/
		if (blockstate.getBlock() == Slidingdoor_Blocks.TOBUKURO_TOPR || blockstate.getBlock() == Slidingdoor_Blocks.TOBUKUROS_TOPR) {
			if (playerIn.capabilities.isCreativeMode) { worldIn.destroyBlock(pos.up(), false); }
			worldIn.destroyBlock(pos.up(), false);
		}
	}

	/* Collision */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		EnumFacing facing = state.getValue(H_FACING);
		return AABB[facing.getHorizontalIndex()];
	}

	/* 上面に植木鉢やレッドストーンを置けるようにする */
	public boolean isTopSolid(IBlockState state) {
		return false;
	}

	/* 側面に松明などを置けるようにする */
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	/* Rendering */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
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

		if (this == Slidingdoor_Blocks.TOBUKURO_BOTR) { stack.add(new ItemStack(Items_Wadeco.TOBUKURO_BOTR)); }
		if (this == Slidingdoor_Blocks.TOBUKUROS_BOTR) { stack.add(new ItemStack(Items_Wadeco.TOBUKUROS_BOTR)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if (this == Slidingdoor_Blocks.TOBUKUROS_BOTR) { return new ItemStack(Items_Wadeco.TOBUKUROS_BOTR); }
		return new ItemStack(Items_Wadeco.TOBUKURO_BOTR);
	}

}
