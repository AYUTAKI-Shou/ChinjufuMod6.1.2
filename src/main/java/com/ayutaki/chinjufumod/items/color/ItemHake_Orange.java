package com.ayutaki.chinjufumod.items.color;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSapo;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlabW;
import com.ayutaki.chinjufumod.blocks.base.BaseSlabWType2;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_Face;
import com.ayutaki.chinjufumod.blocks.base.BaseStage4_Face;
import com.ayutaki.chinjufumod.blocks.chair.BaseSofa;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_1;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_2;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_3;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Andon_4;
import com.ayutaki.chinjufumod.blocks.furniture.Lit_Candle;
import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma;
import com.ayutaki.chinjufumod.blocks.fusuma.BaseFusuma_B;
import com.ayutaki.chinjufumod.blocks.futon.BaseFuton;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_JpFull;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Wall;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_WallKawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Kawara_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoB_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.NamakoStairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Namako_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Crash;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Slab;
import com.ayutaki.chinjufumod.blocks.jpblock.Plaster_Stairs;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoBCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_PlasterCrash;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;
import com.ayutaki.chinjufumod.blocks.jpkasa.BaseMKasa;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.noren.BaseNoren;
import com.ayutaki.chinjufumod.blocks.tatami.Tatami_H;
import com.ayutaki.chinjufumod.blocks.tatami.Tatami_HY;
import com.ayutaki.chinjufumod.blocks.wallpane.BaseStage2_WP;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_clay_color;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_glass_stained;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WP_plaster;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Futon_Blocks;
import com.ayutaki.chinjufumod.registry.Garden_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPBlock_Blocks;
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiShikkui_Blocks;
import com.ayutaki.chinjufumod.registry.Lamp_Blocks;
import com.ayutaki.chinjufumod.registry.WallPaneJP_Blocks;
import com.ayutaki.chinjufumod.registry.WallPane_Blocks;
import com.ayutaki.chinjufumod.registry.doors.Fusuma_Blocks;
import com.ayutaki.chinjufumod.state.BlockStateHalf;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockConcretePowder;
import net.minecraft.block.BlockGlazedTerracotta;
import net.minecraft.block.BlockHardenedClay;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.block.BlockStainedHardenedClay;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHake_Orange extends Base_ItemHake {

	public ItemHake_Orange(String unlocalizedName) {
		super(unlocalizedName);
	}

	/* FlintAndSteel */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState stateIn = worldIn.getBlockState(pos);
		ItemStack itemstack = playerIn.getHeldItem(hand);
		Block blockIn = stateIn.getBlock();
		
		/** 羊毛・コンクリート **/
		if (blockIn instanceof BlockColored || blockIn instanceof BlockConcretePowder ||
				blockIn instanceof BlockStainedGlass || blockIn instanceof BlockStainedHardenedClay) {
			int color = ((EnumDyeColor)stateIn.getValue(BlockColored.COLOR)).getMetadata();

			if (color != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** ガラスブロック **/
		if (blockIn == Blocks.GLASS) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_GLASS.getDefaultState()
					.withProperty(BlockStainedGlass.COLOR, EnumDyeColor.ORANGE), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
			if (itemstack.getMaxDamage() <= 2) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				itemstack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** 板ガラス, カーペット **/
		if (blockIn instanceof BlockStainedGlassPane || blockIn instanceof BlockCarpet) {
			int color = ((EnumDyeColor)stateIn.getValue(BlockColored.COLOR)).getMetadata();

			if (color != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(BlockColored.COLOR, EnumDyeColor.ORANGE), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn == Blocks.GLASS_PANE) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_GLASS_PANE.getDefaultState()
					.withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.ORANGE), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
			if (itemstack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				itemstack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** 堅焼き粘土 **/
		if (blockIn instanceof BlockHardenedClay) {
			CMEvents.soundPaint(worldIn, playerIn, pos);
			worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState()
					.withProperty(BlockStainedHardenedClay.COLOR, EnumDyeColor.ORANGE), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
			if (itemstack.getMaxDamage() <= 2) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				itemstack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}


		/** テラコッタ **/
		if (blockIn instanceof BlockGlazedTerracotta) {
			if (blockIn != Blocks.ORANGE_GLAZED_TERRACOTTA) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState()
						.withProperty(BlockGlazedTerracotta.FACING, stateIn.getValue(BlockGlazedTerracotta.FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (blockIn instanceof Plaster || blockIn instanceof Plaster_Crash ||
				blockIn instanceof Kawara || blockIn instanceof Kawara_Crash ||
				blockIn instanceof Namako || blockIn instanceof Namako_Crash ||
				blockIn instanceof NamakoB || blockIn instanceof NamakoB_Crash) {
			int color = ((Integer)stateIn.getValue(Base_JpFull.STAGE_0_15)).intValue();

			if (color != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_JpFull.STAGE_0_15, Integer.valueOf(1)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}


		/** ハーフブロック **/
		if (blockIn instanceof Kawara_Slab) {
			if (blockIn != JPBlock_Blocks.KAWARA_SH_orange) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.KAWARA_SH_orange.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
					if (itemstack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
					if (itemstack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Plaster_Slab) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_SH_orange) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_SH_orange.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
					if (itemstack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
					if (itemstack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Namako_Slab) {
			if (blockIn != JPBlock_Blocks.NAMAKO_SH_orange) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKO_SH_orange.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
					if (itemstack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
					if (itemstack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof NamakoB_Slab) {
			if (blockIn != JPBlock_Blocks.NAMAKOB_SH_orange) {

				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_SH_orange.getDefaultState()
						.withProperty(BaseSlabWType2.CRA, stateIn.getValue(BaseSlabWType2.CRA))
						.withProperty(BaseSlabWType2.DOUBLE, stateIn.getValue(BaseSlabWType2.DOUBLE))
						.withProperty(BaseSlabWType2.HALF, stateIn.getValue(BaseSlabWType2.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) != true) {
					if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
					if (itemstack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				if (stateIn.getValue(BaseSlabWType2.DOUBLE) == true) {
					if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
					if (itemstack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}


		/** 階段 **/
		if (blockIn instanceof Kawara_Stairs) {
			if (blockIn != JPBlock_Blocks.KAWARA_ST_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.KAWARA_ST_orange.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Plaster_Stairs) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_ST_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_ST_orange.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof NamakoStairs) {
			if (blockIn != JPBlock_Blocks.NAMAKO_ST_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKO_ST_orange.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof NamakoB_Stairs) {
			if (blockIn != JPBlock_Blocks.NAMAKOB_ST_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPBlock_Blocks.NAMAKOB_ST_orange.getDefaultState()
						.withProperty(BlockStairs.FACING, stateIn.getValue(BlockStairs.FACING))
						.withProperty(BlockStairs.HALF, stateIn.getValue(BlockStairs.HALF))
						.withProperty(BlockStairs.SHAPE, stateIn.getValue(BlockStairs.SHAPE)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** トラス **/
		if (blockIn instanceof CTruss) {
			if (blockIn != Harbor_Blocks.TRUSS_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Harbor_Blocks.TRUSS_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 椅子・座布団・キャンドル **/
		if (blockIn instanceof CafeChair || blockIn instanceof Zabuton ||
				blockIn instanceof Candle || blockIn instanceof Lit_Candle) {
			int stage = ((Integer)stateIn.getValue(CafeChair.STAGE_0_15)).intValue();

			if (stage != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, stateIn.withProperty(CafeChair.STAGE_0_15, Integer.valueOf(1)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 行灯 **/
		if (blockIn instanceof Andon_1 || blockIn instanceof Andon_2 ||
				blockIn instanceof Andon_3 || blockIn instanceof Andon_4) {
			int stage = ((Integer)stateIn.getValue(BaseStage4_Face.STAGE_1_4)).intValue();

			if (!(blockIn == Lamp_Blocks.ANDON_1 && stage == 2)) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Lamp_Blocks.ANDON_1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Lit_Andon_1 || blockIn instanceof Lit_Andon_2 ||
				blockIn instanceof Lit_Andon_3 || blockIn instanceof Lit_Andon_4) {
			int stage = ((Integer)stateIn.getValue(BaseStage4_Face.STAGE_1_4)).intValue();

			if (!(blockIn == Lamp_Blocks.LIT_ANDON_1 && stage == 2)) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Lamp_Blocks.LIT_ANDON_1.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, Integer.valueOf(2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** ソファ **/
		if (blockIn instanceof BaseSofa) {
			if (blockIn != Furniture_Blocks.SOFA_orange && blockIn != Furniture_Blocks.SOFA_leather) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Furniture_Blocks.SOFA_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
				if (itemstack.getMaxDamage() <= 2) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 座椅子 **/
		if (blockIn instanceof Zaisu) {
			if (blockIn != JPDeco_Blocks.ZAISU_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.ZAISU_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** のれん **/
		if (blockIn instanceof BaseNoren) {
			if (blockIn != JPDeco_Blocks.NOREN_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.NOREN_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 布団 **/
		if (blockIn instanceof BaseFuton) {
			if (blockIn != Futon_Blocks.FUTON_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Futon_Blocks.FUTON_orange.getDefaultState()
						.withProperty(BaseStage2_Face.H_FACING, stateIn.getValue(BaseStage2_Face.H_FACING))
						.withProperty(BaseStage2_Face.STAGE_1_2, stateIn.getValue(BaseStage2_Face.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 畳 **/
		if (blockIn instanceof Tatami_H) {
			if (blockIn != JPDeco_Blocks.TATAMI_H_orange && blockIn != JPDeco_Blocks.TATAMI_H) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_H_orange.getDefaultState()
						.withProperty(BaseFacingSlabW.H_FACING, stateIn.getValue(BaseFacingSlabW.H_FACING))
						.withProperty(BaseFacingSlabW.DOUBLE, stateIn.getValue(BaseFacingSlabW.DOUBLE))
						.withProperty(BaseFacingSlabW.HALF, stateIn.getValue(BaseFacingSlabW.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof Tatami_HY) {
			if (blockIn != JPDeco_Blocks.TATAMI_HY_orange && blockIn != JPDeco_Blocks.TATAMI_HY) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, JPDeco_Blocks.TATAMI_HY_orange.getDefaultState()
						.withProperty(BaseFacingSlabW.H_FACING, stateIn.getValue(BaseFacingSlabW.H_FACING))
						.withProperty(BaseFacingSlabW.DOUBLE, stateIn.getValue(BaseFacingSlabW.DOUBLE))
						.withProperty(BaseFacingSlabW.HALF, stateIn.getValue(BaseFacingSlabW.HALF)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** 傘 **/
		if (blockIn instanceof BaseMKasa) {
			if (blockIn != Garden_Blocks.KASA_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, Garden_Blocks.KASA_orange.getDefaultState(), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** ふすま HINGEはUPPERから H_FACINGはLOWERから **/
		IBlockState upstate = worldIn.getBlockState(pos.up());
		IBlockState downstate = worldIn.getBlockState(pos.down());

		if (blockIn instanceof BaseFusuma) {
			if (blockIn != Fusuma_Blocks.FUSUMA_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				if (stateIn.getValue(BaseFusuma.HALF) == BlockStateHalf.LOWER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMA_orange.getDefaultState()
							.withProperty(BaseFusuma.H_FACING, stateIn.getValue(BaseFusuma.H_FACING))
							.withProperty(BaseFusuma.OPEN, stateIn.getValue(BaseFusuma.OPEN))
							.withProperty(BaseFusuma.HINGE, upstate.getValue(BaseFusuma.HINGE))
							.withProperty(BaseFusuma.POWERED, upstate.getValue(BaseFusuma.POWERED))
							.withProperty(BaseFusuma.HALF, BlockStateHalf.LOWER), 11);
					worldIn.setBlockState(pos.up(), Fusuma_Blocks.FUSUMA_orange.getDefaultState()
							.withProperty(BaseFusuma.H_FACING, stateIn.getValue(BaseFusuma.H_FACING))
							.withProperty(BaseFusuma.OPEN, stateIn.getValue(BaseFusuma.OPEN))
							.withProperty(BaseFusuma.HINGE, upstate.getValue(BaseFusuma.HINGE))
							.withProperty(BaseFusuma.POWERED, upstate.getValue(BaseFusuma.POWERED))
							.withProperty(BaseFusuma.HALF, BlockStateHalf.UPPER), 11); }

				if (stateIn.getValue(BaseFusuma.HALF) == BlockStateHalf.UPPER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMA_orange.getDefaultState()
							.withProperty(BaseFusuma.H_FACING, downstate.getValue(BaseFusuma.H_FACING))
							.withProperty(BaseFusuma.OPEN, downstate.getValue(BaseFusuma.OPEN))
							.withProperty(BaseFusuma.HINGE, stateIn.getValue(BaseFusuma.HINGE))
							.withProperty(BaseFusuma.POWERED, stateIn.getValue(BaseFusuma.POWERED))
							.withProperty(BaseFusuma.HALF, BlockStateHalf.UPPER), 11);
					worldIn.setBlockState(pos.down(), Fusuma_Blocks.FUSUMA_orange.getDefaultState()
							.withProperty(BaseFusuma.H_FACING, downstate.getValue(BaseFusuma.H_FACING))
							.withProperty(BaseFusuma.OPEN, downstate.getValue(BaseFusuma.OPEN))
							.withProperty(BaseFusuma.HINGE, stateIn.getValue(BaseFusuma.HINGE))
							.withProperty(BaseFusuma.POWERED, stateIn.getValue(BaseFusuma.POWERED))
							.withProperty(BaseFusuma.HALF, BlockStateHalf.LOWER), 11); }

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof BaseFusuma_B) {
			if (blockIn != Fusuma_Blocks.FUSUMAB_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				if (stateIn.getValue(BaseFusuma_B.HALF) == BlockStateHalf.LOWER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMAB_orange.getDefaultState()
							.withProperty(BaseFusuma_B.H_FACING, stateIn.getValue(BaseFusuma_B.H_FACING))
							.withProperty(BaseFusuma_B.OPEN, stateIn.getValue(BaseFusuma_B.OPEN))
							.withProperty(BaseFusuma_B.HINGE, upstate.getValue(BaseFusuma_B.HINGE))
							.withProperty(BaseFusuma_B.POWERED, upstate.getValue(BaseFusuma_B.POWERED))
							.withProperty(BaseFusuma_B.HALF, BlockStateHalf.LOWER), 11);
					worldIn.setBlockState(pos.up(), Fusuma_Blocks.FUSUMAB_orange.getDefaultState()
							.withProperty(BaseFusuma_B.H_FACING, stateIn.getValue(BaseFusuma_B.H_FACING))
							.withProperty(BaseFusuma_B.OPEN, stateIn.getValue(BaseFusuma_B.OPEN))
							.withProperty(BaseFusuma_B.HINGE, upstate.getValue(BaseFusuma_B.HINGE))
							.withProperty(BaseFusuma_B.POWERED, upstate.getValue(BaseFusuma_B.POWERED))
							.withProperty(BaseFusuma_B.HALF, BlockStateHalf.UPPER), 11); }

				if (stateIn.getValue(BaseFusuma_B.HALF) == BlockStateHalf.UPPER) {
					worldIn.setBlockState(pos, Fusuma_Blocks.FUSUMAB_orange.getDefaultState()
							.withProperty(BaseFusuma_B.H_FACING, downstate.getValue(BaseFusuma_B.H_FACING))
							.withProperty(BaseFusuma_B.OPEN, downstate.getValue(BaseFusuma_B.OPEN))
							.withProperty(BaseFusuma_B.HINGE, stateIn.getValue(BaseFusuma_B.HINGE))
							.withProperty(BaseFusuma_B.POWERED, stateIn.getValue(BaseFusuma_B.POWERED))
							.withProperty(BaseFusuma_B.HALF, BlockStateHalf.UPPER), 11);
					worldIn.setBlockState(pos.down(), Fusuma_Blocks.FUSUMAB_orange.getDefaultState()
							.withProperty(BaseFusuma_B.H_FACING, downstate.getValue(BaseFusuma_B.H_FACING))
							.withProperty(BaseFusuma_B.OPEN, downstate.getValue(BaseFusuma_B.OPEN))
							.withProperty(BaseFusuma_B.HINGE, stateIn.getValue(BaseFusuma_B.HINGE))
							.withProperty(BaseFusuma_B.POWERED, stateIn.getValue(BaseFusuma_B.POWERED))
							.withProperty(BaseFusuma_B.HALF, BlockStateHalf.LOWER), 11); }

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** 鴨居 **/
		if (blockIn instanceof KamoiPlaster_Oak) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_o) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_o.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Spruce) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_s) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_s.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Birch) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_b) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_b.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Jungle) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_j) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_j.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Acacia) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_a) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_a.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_DarkOak) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_d) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_d.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Sakura) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_saku) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_saku.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Kaede) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_kae) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_kae.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof KamoiPlaster_Ichoh) {
			if (blockIn != KamoiShikkui_Blocks.KAMOI_orange_ich) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, KamoiShikkui_Blocks.KAMOI_orange_ich.getDefaultState()
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING))
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///////////////////////
		/** 粘土 **/
		if (blockIn instanceof WP_clay_color) {
			if (blockIn != WallPane_Blocks.WP_CLAY_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPane_Blocks.WP_CLAY_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_clay) {
			CMEvents.soundPaint(worldIn, playerIn, pos);

			worldIn.setBlockState(pos, WallPane_Blocks.WP_CLAY_orange.getDefaultState()
					.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
			if (itemstack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				itemstack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}

		/** ガラス **/
		if (blockIn instanceof WP_glass_stained) {
			if (blockIn != WallPane_Blocks.WP_GLASS_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPane_Blocks.WP_GLASS_orange.getDefaultState()
						.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_glass) {
			CMEvents.soundPaint(worldIn, playerIn, pos);

			worldIn.setBlockState(pos, WallPane_Blocks.WP_GLASS_orange.getDefaultState()
					.withProperty(BaseFacingSapo.H_FACING, stateIn.getValue(BaseFacingSapo.H_FACING)), 11);

			if (playerIn instanceof EntityPlayerMP) {
				CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

			if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
			if (itemstack.getMaxDamage() <= 1) {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
				itemstack.shrink(1); }

			return EnumActionResult.SUCCESS;
		}

		/** しっくい **/
		if (blockIn instanceof WP_plaster) {
			if (blockIn != WallPaneJP_Blocks.WP_PLASTER_orange && blockIn != WallPaneJP_Blocks.WP_DIRTWALL) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_PLASTER_orange.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		/** なまこ **/
		if (blockIn instanceof WP_namako) {
			if (blockIn != WallPaneJP_Blocks.WP_NAMAKO_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_NAMAKO_orange.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		if (blockIn instanceof WP_namako_B) {
			if (blockIn != WallPaneJP_Blocks.WP_NAMAKOB_orange) {
				CMEvents.soundPaint(worldIn, playerIn, pos);

				worldIn.setBlockState(pos, WallPaneJP_Blocks.WP_NAMAKOB_orange.getDefaultState()
						.withProperty(BaseStage2_WP.H_FACING, stateIn.getValue(BaseStage2_WP.H_FACING))
						.withProperty(BaseStage2_WP.STAGE_1_2, stateIn.getValue(BaseStage2_WP.STAGE_1_2)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		///6.1.2////////////////////
		if (blockIn instanceof Wall_Plaster || blockIn instanceof Wall_PlasterCrash ||
				blockIn instanceof Wall_Namako || blockIn instanceof Wall_NamakoCrash ||
				blockIn instanceof Wall_NamakoB || blockIn instanceof Wall_NamakoBCrash) {
			int color = ((Integer)stateIn.getValue(Base_Wall.STAGE_0_15)).intValue();

			if (color != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_Wall.STAGE_0_15, Integer.valueOf(1))
						.withProperty(Base_Wall.NORTH, stateIn.getValue(Base_Wall.NORTH))
						.withProperty(Base_Wall.EAST, stateIn.getValue(Base_Wall.EAST))
						.withProperty(Base_Wall.SOUTH, stateIn.getValue(Base_Wall.SOUTH))
						.withProperty(Base_Wall.WEST, stateIn.getValue(Base_Wall.WEST)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		if (blockIn instanceof Wall_Kawara) {
			int color = ((Integer)stateIn.getValue(Base_WallKawara.STAGE_0_15)).intValue();

			if (color != 1) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, stateIn.withProperty(Base_WallKawara.STAGE_0_15, Integer.valueOf(1))
						.withProperty(Base_WallKawara.NORTH, stateIn.getValue(Base_WallKawara.NORTH))
						.withProperty(Base_WallKawara.EAST, stateIn.getValue(Base_WallKawara.EAST))
						.withProperty(Base_WallKawara.SOUTH, stateIn.getValue(Base_WallKawara.SOUTH))
						.withProperty(Base_WallKawara.WEST, stateIn.getValue(Base_WallKawara.WEST)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
				if (itemstack.getMaxDamage() <= 1) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
					itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}
		
		if (blockIn instanceof Wall_Sama) {
			if (blockIn != JPBlock_Blocks.SHIKKUI_SAMA_orange && blockIn != JPBlock_Blocks.DIRTWALL_SAMA) {
				CMEvents.soundPaint(worldIn, playerIn, pos);
				worldIn.setBlockState(pos, JPBlock_Blocks.SHIKKUI_SAMA_orange.getDefaultState()
						.withProperty(BaseStage4_Face.STAGE_1_4, stateIn.getValue(BaseStage4_Face.STAGE_1_4))
						.withProperty(BaseStage4_Face.H_FACING, stateIn.getValue(BaseStage4_Face.H_FACING)), 11);

				if (playerIn instanceof EntityPlayerMP) {
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, pos, itemstack); }

				if (stateIn.getValue(BaseStage4_Face.STAGE_1_4) == 1 || stateIn.getValue(BaseStage4_Face.STAGE_1_4) == 2) {
					if (itemstack.getMaxDamage() > 1) { itemstack.damageItem(1, playerIn); }
					if (itemstack.getMaxDamage() <= 1) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				if (stateIn.getValue(BaseStage4_Face.STAGE_1_4) != 1 && stateIn.getValue(BaseStage4_Face.STAGE_1_4) != 2) {
					if (itemstack.getMaxDamage() > 2) { itemstack.damageItem(2, playerIn); }
					if (itemstack.getMaxDamage() <= 2) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }
						itemstack.shrink(1); } }

				return EnumActionResult.SUCCESS;
			}
		}
		
		
		/* 洗浄 → 水桶はブロックで処理 */
		boolean mode = playerIn.capabilities.isCreativeMode;

		if (blockIn == Blocks.CAULDRON) {
			int level = stateIn.getValue(BlockCauldron.LEVEL);
			if (level != 0) {
				((BlockCauldron)blockIn).setWaterLevel(worldIn, pos, stateIn, level - 1);
				CMEvents.soundWash(worldIn, playerIn, pos);

				/** アイテムを返す **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE, 1, 0))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE, 1, 0), false); }

				if (!mode) { itemstack.shrink(1); }

				return EnumActionResult.SUCCESS;
			}
		}

		return EnumActionResult.PASS;
	}

}
