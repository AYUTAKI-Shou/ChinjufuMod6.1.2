package com.ayutaki.chinjufumod.items.color;

import com.ayutaki.chinjufumod.blocks.base.BaseFacingSlab_Water;
import com.ayutaki.chinjufumod.blocks.base.BaseFacingWater;
import com.ayutaki.chinjufumod.blocks.base.BaseStage2_FaceWater;
import com.ayutaki.chinjufumod.blocks.chair.BaseSofa;
import com.ayutaki.chinjufumod.blocks.chair.CafeChair;
import com.ayutaki.chinjufumod.blocks.chair.Sofa;
import com.ayutaki.chinjufumod.blocks.chair.Zabuton;
import com.ayutaki.chinjufumod.blocks.chair.Zaisu;
import com.ayutaki.chinjufumod.blocks.furniture.Andon;
import com.ayutaki.chinjufumod.blocks.furniture.Candle;
import com.ayutaki.chinjufumod.blocks.futon.Futon;
import com.ayutaki.chinjufumod.blocks.harbor.CTruss;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Full_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Base_Slab_JP;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Full_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Slab_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Namako_B;
import com.ayutaki.chinjufumod.blocks.jpblock.Stairs_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Tatami;
import com.ayutaki.chinjufumod.blocks.jpblock.Tatami_Y;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Kawara;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Namako;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_NamakoB;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Plaster;
import com.ayutaki.chinjufumod.blocks.jpblock.Wall_Sama;
import com.ayutaki.chinjufumod.blocks.kamoislab.Base_KamoiPlaster;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Acacia;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Birch;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_DarkOak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Ichoh;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Jungle;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Kaede;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Oak;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Sakura;
import com.ayutaki.chinjufumod.blocks.kamoislab.KamoiPlaster_Spruce;
import com.ayutaki.chinjufumod.blocks.ranma.Noren;
import com.ayutaki.chinjufumod.blocks.slidedoor.BaseSlidedoor;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma;
import com.ayutaki.chinjufumod.blocks.slidedoor.Fusuma_B;
import com.ayutaki.chinjufumod.blocks.unitblock.Wagasa;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Clay;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Glass;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Namako_B;
import com.ayutaki.chinjufumod.blocks.wallpane.WallPane_Plaster;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Chair_Blocks;
import com.ayutaki.chinjufumod.registry.Furniture_Blocks;
import com.ayutaki.chinjufumod.registry.Harbor_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Wadeco;
import com.ayutaki.chinjufumod.registry.JPChair_Blocks;
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.JPdeco_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPane_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.CauldronBlock;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ItemHake_Green extends Base_ItemHake {

	public ItemHake_Green(Properties builder) {
		super(builder);
	}

	/* FlintAndSteel */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = iworld.getBlockState(blockpos);
		Block block = blockstate.getBlock();

		ItemStack itemstack = context.getItem();
		boolean mode = playerIn.abilities.isCreativeMode;

		/** 木材 採用見送り **/

		/** 羊毛・コンクリート **/
		if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.MAGENTA_WOOL ||
				block == Blocks.LIGHT_BLUE_WOOL || block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL ||
				block == Blocks.PINK_WOOL || block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL ||
				block == Blocks.CYAN_WOOL || block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL ||
				block == Blocks.BROWN_WOOL || block == Blocks.RED_WOOL || block == Blocks.BLACK_WOOL) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_WOOL.getDefaultState(), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } ); //BreakAnimation 無しで筆を返すことも可能

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_CONCRETE || block == Blocks.ORANGE_CONCRETE || block == Blocks.MAGENTA_CONCRETE ||
				block == Blocks.LIGHT_BLUE_CONCRETE || block == Blocks.YELLOW_CONCRETE || block == Blocks.LIME_CONCRETE ||
				block == Blocks.PINK_CONCRETE || block == Blocks.GRAY_CONCRETE || block == Blocks.LIGHT_GRAY_CONCRETE ||
				block == Blocks.CYAN_CONCRETE || block == Blocks.PURPLE_CONCRETE || block == Blocks.BLUE_CONCRETE ||
				block == Blocks.BROWN_CONCRETE || block == Blocks.RED_CONCRETE || block == Blocks.BLACK_CONCRETE) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_CONCRETE.getDefaultState(), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA ||
				block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA ||
				block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA ||
				block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA ||
				block == Blocks.BROWN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA ||
				block == Blocks.TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_TERRACOTTA.getDefaultState(), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof ConcretePowderBlock && block != Blocks.GREEN_CONCRETE_POWDER) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_CONCRETE_POWDER.getDefaultState(), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if ((block instanceof StainedGlassBlock && block != Blocks.GREEN_STAINED_GLASS) || block == Blocks.GLASS) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_STAINED_GLASS.getDefaultState(), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** テラコッタ **/
		if (block instanceof GlazedTerracottaBlock && block != Blocks.GREEN_GLAZED_TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState()
					.with(GlazedTerracottaBlock.HORIZONTAL_FACING, blockstate.get(GlazedTerracottaBlock.HORIZONTAL_FACING)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 板ガラス **/
		if ((block instanceof StainedGlassPaneBlock && block != Blocks.GREEN_STAINED_GLASS_PANE) || block == Blocks.GLASS_PANE) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_STAINED_GLASS_PANE.getDefaultState()
					.with(PaneBlock.NORTH, blockstate.get(PaneBlock.NORTH))
					.with(PaneBlock.EAST, blockstate.get(PaneBlock.EAST))
					.with(PaneBlock.SOUTH, blockstate.get(PaneBlock.SOUTH))
					.with(PaneBlock.WEST, blockstate.get(PaneBlock.WEST))
					.with(PaneBlock.WATERLOGGED, blockstate.get(PaneBlock.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/**カーペット **/
		if (block instanceof CarpetBlock && block != Blocks.GREEN_CARPET) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Blocks.GREEN_CARPET.getDefaultState(), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (block instanceof Full_Kawara && block != JP_Blocks.KAWARA_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.KAWARA_green.getDefaultState()
					.with(Base_Full_JP.CRACK, blockstate.get(Base_Full_JP.CRACK)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Plaster && block != JP_Blocks.SHIKKUI_green && block != JP_Blocks.DIRTWALL) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.SHIKKUI_green.getDefaultState()
					.with(Base_Full_JP.CRACK, blockstate.get(Base_Full_JP.CRACK)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako && block != JP_Blocks.NAMAKO_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKO_green.getDefaultState()
					.with(Base_Full_JP.CRACK, blockstate.get(Base_Full_JP.CRACK)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako_B && block != JP_Blocks.NAMAKOB_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKOB_green.getDefaultState()
					.with(Base_Full_JP.CRACK, blockstate.get(Base_Full_JP.CRACK)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 階段 **/
		if (block instanceof Stairs_Kawara && block != JP_Blocks.KAWARA_ST_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.KAWARA_ST_green.getDefaultState()
					.with(StairsBlock.FACING, blockstate.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, blockstate.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, blockstate.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, blockstate.get(StairsBlock.WATERLOGGED)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Plaster && block != JP_Blocks.SHIKKUI_ST_green && block != JP_Blocks.DIRTWALL_stairs) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.SHIKKUI_ST_green.getDefaultState()
					.with(StairsBlock.FACING, blockstate.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, blockstate.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, blockstate.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, blockstate.get(StairsBlock.WATERLOGGED)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako && block != JP_Blocks.NAMAKO_ST_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKO_ST_green.getDefaultState()
					.with(StairsBlock.FACING, blockstate.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, blockstate.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, blockstate.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, blockstate.get(StairsBlock.WATERLOGGED)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako_B && block != JP_Blocks.NAMAKOB_ST_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKOB_ST_green.getDefaultState()
					.with(StairsBlock.FACING, blockstate.get(StairsBlock.FACING))
					.with(StairsBlock.HALF, blockstate.get(StairsBlock.HALF))
					.with(StairsBlock.SHAPE, blockstate.get(StairsBlock.SHAPE))
					.with(StairsBlock.WATERLOGGED, blockstate.get(StairsBlock.WATERLOGGED)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ハーフブロック **/
		if (block instanceof Slab_Kawara && block != JP_Blocks.KAWARA_SH_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.KAWARA_SH_green.getDefaultState()
					.with(Base_Slab_JP.TYPE, blockstate.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, blockstate.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, blockstate.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (blockstate.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Plaster && block != JP_Blocks.SHIKKUI_SH_green && block != JP_Blocks.DIRTWALL_SH) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.SHIKKUI_SH_green.getDefaultState()
					.with(Base_Slab_JP.TYPE, blockstate.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, blockstate.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, blockstate.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (blockstate.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako && block != JP_Blocks.NAMAKO_SH_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKO_SH_green.getDefaultState()
					.with(Base_Slab_JP.TYPE, blockstate.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, blockstate.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, blockstate.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (blockstate.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako_B && block != JP_Blocks.NAMAKOB_SH_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKOB_SH_green.getDefaultState()
					.with(Base_Slab_JP.TYPE, blockstate.get(Base_Slab_JP.TYPE))
					.with(Base_Slab_JP.CRACK, blockstate.get(Base_Slab_JP.CRACK))
					.with(Base_Slab_JP.WATERLOGGED, blockstate.get(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.get(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			if (blockstate.get(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** トラス **/
		if (block instanceof CTruss && block != Harbor_Blocks.TRUSS_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Harbor_Blocks.TRUSS_green.getDefaultState()
					.with(BaseFacingWater.H_FACING, blockstate.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, blockstate.get(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 椅子・座布団・キャンドル **/
		if (block instanceof CafeChair && block != Chair_Blocks.CAFECHAIR_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Chair_Blocks.CAFECHAIR_green.getDefaultState(), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Zabuton && block != JPChair_Blocks.ZABUTON_green && block != JPChair_Blocks.WARAZABUTON) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPChair_Blocks.ZABUTON_green.getDefaultState(), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Candle && block != Furniture_Blocks.CANDLE_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Furniture_Blocks.CANDLE_green.getDefaultState()
					.with(Candle.LIT, blockstate.get(Candle.LIT))
					.with(Candle.DOWN, blockstate.get(Candle.DOWN))
					.with(Candle.WATERLOGGED, blockstate.get(Candle.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 行灯 **/
		if (block instanceof Andon && block != JPdeco_Blocks.ANDON_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPdeco_Blocks.ANDON_green.getDefaultState()
					.with(Andon.LIT, blockstate.get(Andon.LIT))
					.with(Andon.H_FACING, blockstate.get(Andon.H_FACING))
					.with(Andon.WATERLOGGED, blockstate.get(Andon.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ソファ **/
		if (block instanceof Sofa && block != Chair_Blocks.SOFA_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Chair_Blocks.SOFA_green.getDefaultState()
					.with(BaseSofa.TYPE, blockstate.get(BaseSofa.TYPE))
					.with(BaseSofa.H_FACING, blockstate.get(BaseSofa.H_FACING))
					.with(BaseSofa.WATERLOGGED, blockstate.get(BaseSofa.WATERLOGGED)), 3);

			itemstack.damageItem(2, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 座椅子 **/
		if (block instanceof Zaisu && block != JPChair_Blocks.ZAISU_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPChair_Blocks.ZAISU_green.getDefaultState()
					.with(BaseFacingWater.H_FACING, blockstate.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, blockstate.get(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** のれん **/
		if (block instanceof Noren && block != Ranma_Blocks.NOREN_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Ranma_Blocks.NOREN_green.getDefaultState()
					.with(Noren.TYPE, blockstate.get(Noren.TYPE))
					.with(Noren.H_FACING, blockstate.get(Noren.H_FACING))
					.with(Noren.WATERLOGGED, blockstate.get(Noren.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 布団 **/
		if (block instanceof Futon && block != JPdeco_Blocks.FUTON_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPdeco_Blocks.FUTON_green.getDefaultState()
					.with(BaseStage2_FaceWater.STAGE_1_2, blockstate.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.H_FACING, blockstate.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.WATERLOGGED, blockstate.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 畳 **/
		if (block instanceof Tatami && block != JPdeco_Blocks.TATAMI_H_green && block != JPdeco_Blocks.TATAMI_H) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPdeco_Blocks.TATAMI_H_green.getDefaultState()
					.with(BaseFacingSlab_Water.TYPE, blockstate.get(BaseFacingSlab_Water.TYPE))
					.with(BaseFacingSlab_Water.H_FACING, blockstate.get(BaseFacingSlab_Water.H_FACING))
					.with(BaseFacingSlab_Water.WATERLOGGED, blockstate.get(BaseFacingSlab_Water.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Tatami_Y && block != JPdeco_Blocks.TATAMI_HY_green && block != JPdeco_Blocks.TATAMI_HY) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JPdeco_Blocks.TATAMI_HY_green.getDefaultState()
					.with(BaseFacingSlab_Water.TYPE, blockstate.get(BaseFacingSlab_Water.TYPE))
					.with(BaseFacingSlab_Water.H_FACING, blockstate.get(BaseFacingSlab_Water.H_FACING))
					.with(BaseFacingSlab_Water.WATERLOGGED, blockstate.get(BaseFacingSlab_Water.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 傘 **/
		if (block instanceof Wagasa && block != Unit_Blocks.KASA_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, Unit_Blocks.KASA_green.getDefaultState()
					.with(Wagasa.NORTH, blockstate.get(Wagasa.NORTH))
					.with(Wagasa.EAST, blockstate.get(Wagasa.EAST))
					.with(Wagasa.SOUTH, blockstate.get(Wagasa.SOUTH))
					.with(Wagasa.WEST, blockstate.get(Wagasa.WEST))
					.with(Wagasa.WHICH, Boolean.valueOf(false))
					.with(Wagasa.WATERLOGGED, blockstate.get(Wagasa.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** ふすま **/
		if (block instanceof Fusuma && block != Slidedoor_Blocks.FUSUMA_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);

			if (blockstate.get(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlockState(blockpos, Slidedoor_Blocks.FUSUMA_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(blockpos.up(), Slidedoor_Blocks.FUSUMA_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3); }

			if (blockstate.get(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlockState(blockpos, Slidedoor_Blocks.FUSUMA_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(blockpos.down(), Slidedoor_Blocks.FUSUMA_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3); }

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Fusuma_B && block != Slidedoor_Blocks.FUSUMAB_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);

			if (blockstate.get(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlockState(blockpos, Slidedoor_Blocks.FUSUMAB_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(blockpos.up(), Slidedoor_Blocks.FUSUMAB_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3); }

			if (blockstate.get(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlockState(blockpos, Slidedoor_Blocks.FUSUMAB_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlockState(blockpos.down(), Slidedoor_Blocks.FUSUMAB_green.getDefaultState()
						.with(BaseSlidedoor.H_FACING, blockstate.get(BaseSlidedoor.H_FACING))
						.with(BaseSlidedoor.OPEN, blockstate.get(BaseSlidedoor.OPEN))
						.with(BaseSlidedoor.HINGE, blockstate.get(BaseSlidedoor.HINGE))
						.with(BaseSlidedoor.POWERED, blockstate.get(BaseSlidedoor.POWERED))
						.with(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.with(BaseSlidedoor.WATERLOGGED, blockstate.get(BaseSlidedoor.WATERLOGGED)), 3); }

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** 鴨居 **/
		if (block instanceof KamoiPlaster_Oak && block != KamoiPlaster_Blocks.KAMOI_green_oak) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_oak.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Spruce && block != KamoiPlaster_Blocks.KAMOI_green_spru) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_spru.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Birch && block != KamoiPlaster_Blocks.KAMOI_green_bir) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_bir.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Jungle && block != KamoiPlaster_Blocks.KAMOI_green_jun) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_jun.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Acacia && block != KamoiPlaster_Blocks.KAMOI_green_aca) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_aca.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_DarkOak && block != KamoiPlaster_Blocks.KAMOI_green_doak) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_doak.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Sakura && block != KamoiPlaster_Blocks.KAMOI_green_sakura) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_sakura.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Kaede && block != KamoiPlaster_Blocks.KAMOI_green_kaede) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_kaede.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Ichoh && block != KamoiPlaster_Blocks.KAMOI_green_ichoh) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, KamoiPlaster_Blocks.KAMOI_green_ichoh.getDefaultState()
					.with(Base_KamoiPlaster.H_FACING, blockstate.get(Base_KamoiPlaster.H_FACING))
					.with(Base_KamoiPlaster.STAGE_1_4, blockstate.get(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** 粘土 **/
		if (block instanceof WallPane_Clay && block != WallPane_Blocks.WP_CLAY_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, WallPane_Blocks.WP_CLAY_green.getDefaultState()
					.with(BaseFacingWater.H_FACING, blockstate.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, blockstate.get(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ガラス **/
		if (block instanceof WallPane_Glass && block != WallPane_Blocks.WP_GLASS_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, WallPane_Blocks.WP_GLASS_green.getDefaultState()
					.with(BaseFacingWater.H_FACING, blockstate.get(BaseFacingWater.H_FACING))
					.with(BaseFacingWater.WATERLOGGED, blockstate.get(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** しっくい **/
		if (block instanceof WallPane_Plaster && block != WallPane_Blocks.WP_PLASTER_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, WallPane_Blocks.WP_PLASTER_green.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, blockstate.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, blockstate.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, blockstate.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** なまこ **/
		if (block instanceof WallPane_Namako && block != WallPane_Blocks.WP_NAMAKO_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, WallPane_Blocks.WP_NAMAKO_green.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, blockstate.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, blockstate.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, blockstate.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof WallPane_Namako_B && block != WallPane_Blocks.WP_NAMAKOB_green) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, WallPane_Blocks.WP_NAMAKOB_green.getDefaultState()
					.with(BaseStage2_FaceWater.H_FACING, blockstate.get(BaseStage2_FaceWater.H_FACING))
					.with(BaseStage2_FaceWater.STAGE_1_2, blockstate.get(BaseStage2_FaceWater.STAGE_1_2))
					.with(BaseStage2_FaceWater.WATERLOGGED, blockstate.get(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///6.1.2////////////////////
		if (block instanceof Wall_Plaster && block != JP_Blocks.SHIKKUI_WALL_green && block != JP_Blocks.DIRTWALL_WALL) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.SHIKKUI_WALL_green.getDefaultState()
					.with(Wall_Plaster.NORTH, blockstate.get(Wall_Plaster.NORTH))
					.with(Wall_Plaster.SOUTH, blockstate.get(Wall_Plaster.SOUTH))
					.with(Wall_Plaster.EAST, blockstate.get(Wall_Plaster.EAST))
					.with(Wall_Plaster.WEST, blockstate.get(Wall_Plaster.WEST))
					.with(Wall_Plaster.CRACK, blockstate.get(Wall_Plaster.CRACK))
					.with(Wall_Plaster.WATERLOGGED, blockstate.get(Wall_Plaster.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Sama && block != JP_Blocks.SHIKKUI_SAMA_green && block != JP_Blocks.DIRTWALL_SAMA) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.SHIKKUI_SAMA_green.getDefaultState()
					.with(Wall_Sama.H_FACING, blockstate.get(Wall_Sama.H_FACING))
					.with(Wall_Sama.STAGE_1_4, blockstate.get(Wall_Sama.STAGE_1_4))
					.with(Wall_Sama.WATERLOGGED, blockstate.get(Wall_Sama.WATERLOGGED)), 3);
			
			if (blockstate.get(Wall_Sama.STAGE_1_4) <= 2) {
				itemstack.damageItem(1, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}
			
			if (blockstate.get(Wall_Sama.STAGE_1_4) >= 3) {
				itemstack.damageItem(2, playerIn, user -> {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
					user.sendBreakAnimation(context.getHand()); } );
			}

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Wall_Kawara && block != JP_Blocks.KAWARA_WALL_green) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.KAWARA_WALL_green.getDefaultState()
					.with(Wall_Kawara.NORTH, blockstate.get(Wall_Kawara.NORTH))
					.with(Wall_Kawara.SOUTH, blockstate.get(Wall_Kawara.SOUTH))
					.with(Wall_Kawara.EAST, blockstate.get(Wall_Kawara.EAST))
					.with(Wall_Kawara.WEST, blockstate.get(Wall_Kawara.WEST))
					.with(Wall_Kawara.WATERLOGGED, blockstate.get(Wall_Kawara.WATERLOGGED)), 3);
			
			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Namako && block != JP_Blocks.NAMAKO_WALL_green) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKO_WALL_green.getDefaultState()
					.with(Wall_Namako.NORTH, blockstate.get(Wall_Namako.NORTH))
					.with(Wall_Namako.SOUTH, blockstate.get(Wall_Namako.SOUTH))
					.with(Wall_Namako.EAST, blockstate.get(Wall_Namako.EAST))
					.with(Wall_Namako.WEST, blockstate.get(Wall_Namako.WEST))
					.with(Wall_Namako.CRACK, blockstate.get(Wall_Namako.CRACK))
					.with(Wall_Namako.WATERLOGGED, blockstate.get(Wall_Namako.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_NamakoB && block != JP_Blocks.NAMAKOB_WALL_green) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlockState(blockpos, JP_Blocks.NAMAKOB_WALL_green.getDefaultState()
					.with(Wall_NamakoB.NORTH, blockstate.get(Wall_NamakoB.NORTH))
					.with(Wall_NamakoB.SOUTH, blockstate.get(Wall_NamakoB.SOUTH))
					.with(Wall_NamakoB.EAST, blockstate.get(Wall_NamakoB.EAST))
					.with(Wall_NamakoB.WEST, blockstate.get(Wall_NamakoB.WEST))
					.with(Wall_NamakoB.CRACK, blockstate.get(Wall_NamakoB.CRACK))
					.with(Wall_NamakoB.WATERLOGGED, blockstate.get(Wall_NamakoB.WATERLOGGED)), 3);

			itemstack.damageItem(1, playerIn, user -> {
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }
				user.sendBreakAnimation(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		/* Wash the brush. MIZUOKE work is in the block. */
		if (block == Blocks.CAULDRON) {
			int level = blockstate.get(CauldronBlock.LEVEL);
			if (level != 0) {
				CMEvents.soundWash(iworld, playerIn, blockpos);
				iworld.setBlockState(blockpos, blockstate.with(CauldronBlock.LEVEL, Integer.valueOf(level - 1)), 3);

				/** アイテムを返す **/
				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.dropItem(new ItemStack(Items_Wadeco.HAKE), false); }

				if (!mode) { itemstack.shrink(1); }
				return ActionResultType.SUCCESS;
			}
		}

		return ActionResultType.FAIL;
	}

}
