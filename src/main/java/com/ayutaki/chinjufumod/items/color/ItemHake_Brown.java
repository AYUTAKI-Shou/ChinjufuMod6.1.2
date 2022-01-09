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
import com.ayutaki.chinjufumod.registry.JPDeco_Blocks;
import com.ayutaki.chinjufumod.registry.JP_Blocks;
import com.ayutaki.chinjufumod.registry.KamoiPlaster_Blocks;
import com.ayutaki.chinjufumod.registry.Ranma_Blocks;
import com.ayutaki.chinjufumod.registry.Slidedoor_Blocks;
import com.ayutaki.chinjufumod.registry.Unit_Blocks;
import com.ayutaki.chinjufumod.registry.WallPanel_Blocks;

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

public class ItemHake_Brown extends Base_ItemHake {

	public ItemHake_Brown(Properties builder) {
		super(builder);
	}

	/* FlintAndSteel */
	@Override
	public ActionResultType useOn(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = iworld.getBlockState(blockpos);
		Block block = blockstate.getBlock();

		ItemStack itemstack = context.getItemInHand();
		boolean mode = playerIn.abilities.instabuild;

		/** other Blocks **/
		if (block == Blocks.WHITE_WOOL || block == Blocks.ORANGE_WOOL || block == Blocks.MAGENTA_WOOL ||
				block == Blocks.LIGHT_BLUE_WOOL || block == Blocks.YELLOW_WOOL || block == Blocks.LIME_WOOL ||
				block == Blocks.PINK_WOOL || block == Blocks.GRAY_WOOL || block == Blocks.LIGHT_GRAY_WOOL ||
				block == Blocks.CYAN_WOOL || block == Blocks.PURPLE_WOOL || block == Blocks.BLUE_WOOL ||
				block == Blocks.GREEN_WOOL || block == Blocks.RED_WOOL || block == Blocks.BLACK_WOOL) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_WOOL.defaultBlockState(), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } ); //BreakAnimation 無しで筆を返すことも可能

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_CONCRETE || block == Blocks.ORANGE_CONCRETE || block == Blocks.MAGENTA_CONCRETE ||
				block == Blocks.LIGHT_BLUE_CONCRETE || block == Blocks.YELLOW_CONCRETE || block == Blocks.LIME_CONCRETE ||
				block == Blocks.PINK_CONCRETE || block == Blocks.GRAY_CONCRETE || block == Blocks.LIGHT_GRAY_CONCRETE ||
				block == Blocks.CYAN_CONCRETE || block == Blocks.PURPLE_CONCRETE || block == Blocks.BLUE_CONCRETE ||
				block == Blocks.GREEN_CONCRETE || block == Blocks.RED_CONCRETE || block == Blocks.BLACK_CONCRETE) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_CONCRETE.defaultBlockState(), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA ||
				block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA ||
				block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA ||
				block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA ||
				block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA ||
				block == Blocks.TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_TERRACOTTA.defaultBlockState(), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof ConcretePowderBlock && block != Blocks.BROWN_CONCRETE_POWDER) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_CONCRETE_POWDER.defaultBlockState(), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if ((block instanceof StainedGlassBlock && block != Blocks.BROWN_STAINED_GLASS) || block == Blocks.GLASS) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_STAINED_GLASS.defaultBlockState(), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** テラコッタ **/
		if (block instanceof GlazedTerracottaBlock && block != Blocks.BROWN_GLAZED_TERRACOTTA) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_GLAZED_TERRACOTTA.defaultBlockState()
					.setValue(GlazedTerracottaBlock.FACING, blockstate.getValue(GlazedTerracottaBlock.FACING)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 板ガラス **/
		if ((block instanceof StainedGlassPaneBlock && block != Blocks.BROWN_STAINED_GLASS_PANE) || block == Blocks.GLASS_PANE) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_STAINED_GLASS_PANE.defaultBlockState()
					.setValue(PaneBlock.NORTH, blockstate.getValue(PaneBlock.NORTH))
					.setValue(PaneBlock.EAST, blockstate.getValue(PaneBlock.EAST))
					.setValue(PaneBlock.SOUTH, blockstate.getValue(PaneBlock.SOUTH))
					.setValue(PaneBlock.WEST, blockstate.getValue(PaneBlock.WEST))
					.setValue(PaneBlock.WATERLOGGED, blockstate.getValue(PaneBlock.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/**カーペット **/
		if (block instanceof CarpetBlock && block != Blocks.BROWN_CARPET) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Blocks.BROWN_CARPET.defaultBlockState(), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		/** 瓦・漆喰・なまこ壁 **/
		if (block instanceof Full_Kawara && block != JP_Blocks.KAWARA_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.KAWARA_brown.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, blockstate.getValue(Base_Full_JP.CRACK)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Plaster && block != JP_Blocks.SHIKKUI_brown && block != JP_Blocks.DIRTWALL) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.SHIKKUI_brown.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, blockstate.getValue(Base_Full_JP.CRACK)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako && block != JP_Blocks.NAMAKO_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKO_brown.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, blockstate.getValue(Base_Full_JP.CRACK)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Full_Namako_B && block != JP_Blocks.NAMAKOB_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKOB_brown.defaultBlockState()
					.setValue(Base_Full_JP.CRACK, blockstate.getValue(Base_Full_JP.CRACK)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 階段 **/
		if (block instanceof Stairs_Kawara && block != JP_Blocks.KAWARA_ST_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.KAWARA_ST_brown.defaultBlockState()
					.setValue(StairsBlock.FACING, blockstate.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, blockstate.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, blockstate.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, blockstate.getValue(StairsBlock.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Plaster && block != JP_Blocks.SHIKKUI_ST_brown && block != JP_Blocks.DIRTWALL_stairs) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.SHIKKUI_ST_brown.defaultBlockState()
					.setValue(StairsBlock.FACING, blockstate.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, blockstate.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, blockstate.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, blockstate.getValue(StairsBlock.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako && block != JP_Blocks.NAMAKO_ST_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKO_ST_brown.defaultBlockState()
					.setValue(StairsBlock.FACING, blockstate.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, blockstate.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, blockstate.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, blockstate.getValue(StairsBlock.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Stairs_Namako_B && block != JP_Blocks.NAMAKOB_ST_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKOB_ST_brown.defaultBlockState()
					.setValue(StairsBlock.FACING, blockstate.getValue(StairsBlock.FACING))
					.setValue(StairsBlock.HALF, blockstate.getValue(StairsBlock.HALF))
					.setValue(StairsBlock.SHAPE, blockstate.getValue(StairsBlock.SHAPE))
					.setValue(StairsBlock.WATERLOGGED, blockstate.getValue(StairsBlock.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ハーフブロック **/
		if (block instanceof Slab_Kawara && block != JP_Blocks.KAWARA_SH_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.KAWARA_SH_brown.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, blockstate.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, blockstate.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, blockstate.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (blockstate.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Plaster && block != JP_Blocks.SHIKKUI_SH_brown && block != JP_Blocks.DIRTWALL_SH) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.SHIKKUI_SH_brown.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, blockstate.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, blockstate.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, blockstate.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (blockstate.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako && block != JP_Blocks.NAMAKO_SH_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKO_SH_brown.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, blockstate.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, blockstate.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, blockstate.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (blockstate.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		if (block instanceof Slab_Namako_B && block != JP_Blocks.NAMAKOB_SH_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKOB_SH_brown.defaultBlockState()
					.setValue(Base_Slab_JP.TYPE, blockstate.getValue(Base_Slab_JP.TYPE))
					.setValue(Base_Slab_JP.CRACK, blockstate.getValue(Base_Slab_JP.CRACK))
					.setValue(Base_Slab_JP.WATERLOGGED, blockstate.getValue(Base_Slab_JP.WATERLOGGED)), 3);

			if (blockstate.getValue(Base_Slab_JP.TYPE) == SlabType.DOUBLE) {
				itemstack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			if (blockstate.getValue(Base_Slab_JP.TYPE) != SlabType.DOUBLE) {
				itemstack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** トラス **/
		if (block instanceof CTruss && block != Harbor_Blocks.TRUSS_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Harbor_Blocks.TRUSS_brown.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, blockstate.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, blockstate.getValue(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 椅子・座布団・キャンドル **/
		if (block instanceof CafeChair && block != Chair_Blocks.CAFECHAIR_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Chair_Blocks.CAFECHAIR_brown.defaultBlockState(), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Zabuton && block != JPChair_Blocks.ZABUTON_brown && block != JPChair_Blocks.WARAZABUTON) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPChair_Blocks.ZABUTON_brown.defaultBlockState(), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Candle && block != Furniture_Blocks.CANDLE_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Furniture_Blocks.CANDLE_brown.defaultBlockState()
					.setValue(Candle.LIT, blockstate.getValue(Candle.LIT))
					.setValue(Candle.DOWN, blockstate.getValue(Candle.DOWN))
					.setValue(Candle.WATERLOGGED, blockstate.getValue(Candle.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 行灯 **/
		if (block instanceof Andon && block != JPDeco_Blocks.ANDON_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPDeco_Blocks.ANDON_brown.defaultBlockState()
					.setValue(Andon.LIT, blockstate.getValue(Andon.LIT))
					.setValue(Andon.H_FACING, blockstate.getValue(Andon.H_FACING))
					.setValue(Andon.WATERLOGGED, blockstate.getValue(Andon.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ソファ **/
		if (block instanceof Sofa && block != Chair_Blocks.SOFA_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Chair_Blocks.SOFA_brown.defaultBlockState()
					.setValue(BaseSofa.TYPE, blockstate.getValue(BaseSofa.TYPE))
					.setValue(BaseSofa.H_FACING, blockstate.getValue(BaseSofa.H_FACING))
					.setValue(BaseSofa.WATERLOGGED, blockstate.getValue(BaseSofa.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(2, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 座椅子 **/
		if (block instanceof Zaisu && block != JPChair_Blocks.ZAISU_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPChair_Blocks.ZAISU_brown.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, blockstate.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, blockstate.getValue(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** のれん **/
		if (block instanceof Noren && block != Ranma_Blocks.NOREN_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Ranma_Blocks.NOREN_brown.defaultBlockState()
					.setValue(Noren.TYPE, blockstate.getValue(Noren.TYPE))
					.setValue(Noren.H_FACING, blockstate.getValue(Noren.H_FACING))
					.setValue(Noren.WATERLOGGED, blockstate.getValue(Noren.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 布団 **/
		if (block instanceof Futon && block != JPDeco_Blocks.FUTON_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPDeco_Blocks.FUTON_brown.defaultBlockState()
					.setValue(BaseStage2_FaceWater.STAGE_1_2, blockstate.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.H_FACING, blockstate.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, blockstate.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 畳 **/
		if (block instanceof Tatami && block != JPDeco_Blocks.TATAMI_H_brown && block != JPDeco_Blocks.TATAMI_H) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPDeco_Blocks.TATAMI_H_brown.defaultBlockState()
					.setValue(BaseFacingSlab_Water.TYPE, blockstate.getValue(BaseFacingSlab_Water.TYPE))
					.setValue(BaseFacingSlab_Water.H_FACING, blockstate.getValue(BaseFacingSlab_Water.H_FACING))
					.setValue(BaseFacingSlab_Water.WATERLOGGED, blockstate.getValue(BaseFacingSlab_Water.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Tatami_Y && block != JPDeco_Blocks.TATAMI_HY_brown && block != JPDeco_Blocks.TATAMI_HY) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JPDeco_Blocks.TATAMI_HY_brown.defaultBlockState()
					.setValue(BaseFacingSlab_Water.TYPE, blockstate.getValue(BaseFacingSlab_Water.TYPE))
					.setValue(BaseFacingSlab_Water.H_FACING, blockstate.getValue(BaseFacingSlab_Water.H_FACING))
					.setValue(BaseFacingSlab_Water.WATERLOGGED, blockstate.getValue(BaseFacingSlab_Water.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** 傘 **/
		if (block instanceof Wagasa && block != Unit_Blocks.KASA_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, Unit_Blocks.KASA_brown.defaultBlockState()
					.setValue(Wagasa.NORTH, blockstate.getValue(Wagasa.NORTH))
					.setValue(Wagasa.EAST, blockstate.getValue(Wagasa.EAST))
					.setValue(Wagasa.SOUTH, blockstate.getValue(Wagasa.SOUTH))
					.setValue(Wagasa.WEST, blockstate.getValue(Wagasa.WEST))
					.setValue(Wagasa.WHICH, Boolean.valueOf(false))
					.setValue(Wagasa.WATERLOGGED, blockstate.getValue(Wagasa.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** ふすま **/
		if (block instanceof Fusuma && block != Slidedoor_Blocks.FUSUMA_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);

			if (blockstate.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlock(blockpos, Slidedoor_Blocks.FUSUMA_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(blockpos.above(), Slidedoor_Blocks.FUSUMA_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (blockstate.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlock(blockpos, Slidedoor_Blocks.FUSUMA_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(blockpos.below(), Slidedoor_Blocks.FUSUMA_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Fusuma_B && block != Slidedoor_Blocks.FUSUMAB_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);

			if (blockstate.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.LOWER) {
				iworld.setBlock(blockpos, Slidedoor_Blocks.FUSUMAB_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(blockpos.above(), Slidedoor_Blocks.FUSUMAB_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			if (blockstate.getValue(BaseSlidedoor.HALF) == DoubleBlockHalf.UPPER) {
				iworld.setBlock(blockpos, Slidedoor_Blocks.FUSUMAB_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.UPPER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3);
				iworld.setBlock(blockpos.below(), Slidedoor_Blocks.FUSUMAB_brown.defaultBlockState()
						.setValue(BaseSlidedoor.H_FACING, blockstate.getValue(BaseSlidedoor.H_FACING))
						.setValue(BaseSlidedoor.OPEN, blockstate.getValue(BaseSlidedoor.OPEN))
						.setValue(BaseSlidedoor.HINGE, blockstate.getValue(BaseSlidedoor.HINGE))
						.setValue(BaseSlidedoor.POWERED, blockstate.getValue(BaseSlidedoor.POWERED))
						.setValue(BaseSlidedoor.HALF, DoubleBlockHalf.LOWER)
						.setValue(BaseSlidedoor.WATERLOGGED, blockstate.getValue(BaseSlidedoor.WATERLOGGED)), 3); }

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///////////////////////
		/** 鴨居 **/
		if (block instanceof KamoiPlaster_Oak && block != KamoiPlaster_Blocks.KAMOI_brown_oak) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_oak.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Spruce && block != KamoiPlaster_Blocks.KAMOI_brown_spru) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_spru.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Birch && block != KamoiPlaster_Blocks.KAMOI_brown_bir) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_bir.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Jungle && block != KamoiPlaster_Blocks.KAMOI_brown_jun) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_jun.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Acacia && block != KamoiPlaster_Blocks.KAMOI_brown_aca) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_aca.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_DarkOak && block != KamoiPlaster_Blocks.KAMOI_brown_doak) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_doak.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Sakura && block != KamoiPlaster_Blocks.KAMOI_brown_sakura) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_sakura.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Kaede && block != KamoiPlaster_Blocks.KAMOI_brown_kaede) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_kaede.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof KamoiPlaster_Ichoh && block != KamoiPlaster_Blocks.KAMOI_brown_ichoh) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, KamoiPlaster_Blocks.KAMOI_brown_ichoh.defaultBlockState()
					.setValue(Base_KamoiPlaster.H_FACING, blockstate.getValue(Base_KamoiPlaster.H_FACING))
					.setValue(Base_KamoiPlaster.STAGE_1_4, blockstate.getValue(Base_KamoiPlaster.STAGE_1_4)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}


		///////////////////////
		/** 粘土 **/
		if (block instanceof WallPane_Clay && block != WallPanel_Blocks.WP_CLAY_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, WallPanel_Blocks.WP_CLAY_brown.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, blockstate.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, blockstate.getValue(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** ガラス **/
		if (block instanceof WallPane_Glass && block != WallPanel_Blocks.WP_GLASS_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, WallPanel_Blocks.WP_GLASS_brown.defaultBlockState()
					.setValue(BaseFacingWater.H_FACING, blockstate.getValue(BaseFacingWater.H_FACING))
					.setValue(BaseFacingWater.WATERLOGGED, blockstate.getValue(BaseFacingWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** しっくい **/
		if (block instanceof WallPane_Plaster && block != WallPanel_Blocks.WP_PLASTER_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, WallPanel_Blocks.WP_PLASTER_brown.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, blockstate.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, blockstate.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, blockstate.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		/** なまこ **/
		if (block instanceof WallPane_Namako && block != WallPanel_Blocks.WP_NAMAKO_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, WallPanel_Blocks.WP_NAMAKO_brown.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, blockstate.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, blockstate.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, blockstate.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		if (block instanceof WallPane_Namako_B && block != WallPanel_Blocks.WP_NAMAKOB_brown) {

			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, WallPanel_Blocks.WP_NAMAKOB_brown.defaultBlockState()
					.setValue(BaseStage2_FaceWater.H_FACING, blockstate.getValue(BaseStage2_FaceWater.H_FACING))
					.setValue(BaseStage2_FaceWater.STAGE_1_2, blockstate.getValue(BaseStage2_FaceWater.STAGE_1_2))
					.setValue(BaseStage2_FaceWater.WATERLOGGED, blockstate.getValue(BaseStage2_FaceWater.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}

		///6.1.2////////////////////
		if (block instanceof Wall_Plaster && block != JP_Blocks.SHIKKUI_WALL_brown && block != JP_Blocks.DIRTWALL_WALL) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.SHIKKUI_WALL_brown.defaultBlockState()
					.setValue(Wall_Plaster.NORTH, blockstate.getValue(Wall_Plaster.NORTH))
					.setValue(Wall_Plaster.SOUTH, blockstate.getValue(Wall_Plaster.SOUTH))
					.setValue(Wall_Plaster.EAST, blockstate.getValue(Wall_Plaster.EAST))
					.setValue(Wall_Plaster.WEST, blockstate.getValue(Wall_Plaster.WEST))
					.setValue(Wall_Plaster.CRACK, blockstate.getValue(Wall_Plaster.CRACK))
					.setValue(Wall_Plaster.WATERLOGGED, blockstate.getValue(Wall_Plaster.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Sama && block != JP_Blocks.SHIKKUI_SAMA_brown && block != JP_Blocks.DIRTWALL_SAMA) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.SHIKKUI_SAMA_brown.defaultBlockState()
					.setValue(Wall_Sama.H_FACING, blockstate.getValue(Wall_Sama.H_FACING))
					.setValue(Wall_Sama.STAGE_1_4, blockstate.getValue(Wall_Sama.STAGE_1_4))
					.setValue(Wall_Sama.WATERLOGGED, blockstate.getValue(Wall_Sama.WATERLOGGED)), 3);
			
			if (blockstate.getValue(Wall_Sama.STAGE_1_4) <= 2) {
				itemstack.hurtAndBreak(1, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}
			
			if (blockstate.getValue(Wall_Sama.STAGE_1_4) >= 3) {
				itemstack.hurtAndBreak(2, playerIn, user -> {
					if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
						playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
					user.broadcastBreakEvent(context.getHand()); } );
			}

			return ActionResultType.SUCCESS;
		}

		if (block instanceof Wall_Kawara && block != JP_Blocks.KAWARA_WALL_brown) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.KAWARA_WALL_brown.defaultBlockState()
					.setValue(Wall_Kawara.NORTH, blockstate.getValue(Wall_Kawara.NORTH))
					.setValue(Wall_Kawara.SOUTH, blockstate.getValue(Wall_Kawara.SOUTH))
					.setValue(Wall_Kawara.EAST, blockstate.getValue(Wall_Kawara.EAST))
					.setValue(Wall_Kawara.WEST, blockstate.getValue(Wall_Kawara.WEST))
					.setValue(Wall_Kawara.WATERLOGGED, blockstate.getValue(Wall_Kawara.WATERLOGGED)), 3);
			
			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_Namako && block != JP_Blocks.NAMAKO_WALL_brown) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKO_WALL_brown.defaultBlockState()
					.setValue(Wall_Namako.NORTH, blockstate.getValue(Wall_Namako.NORTH))
					.setValue(Wall_Namako.SOUTH, blockstate.getValue(Wall_Namako.SOUTH))
					.setValue(Wall_Namako.EAST, blockstate.getValue(Wall_Namako.EAST))
					.setValue(Wall_Namako.WEST, blockstate.getValue(Wall_Namako.WEST))
					.setValue(Wall_Namako.CRACK, blockstate.getValue(Wall_Namako.CRACK))
					.setValue(Wall_Namako.WATERLOGGED, blockstate.getValue(Wall_Namako.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		if (block instanceof Wall_NamakoB && block != JP_Blocks.NAMAKOB_WALL_brown) {
			
			CMEvents.soundPaint(iworld, playerIn, blockpos);
			iworld.setBlock(blockpos, JP_Blocks.NAMAKOB_WALL_brown.defaultBlockState()
					.setValue(Wall_NamakoB.NORTH, blockstate.getValue(Wall_NamakoB.NORTH))
					.setValue(Wall_NamakoB.SOUTH, blockstate.getValue(Wall_NamakoB.SOUTH))
					.setValue(Wall_NamakoB.EAST, blockstate.getValue(Wall_NamakoB.EAST))
					.setValue(Wall_NamakoB.WEST, blockstate.getValue(Wall_NamakoB.WEST))
					.setValue(Wall_NamakoB.CRACK, blockstate.getValue(Wall_NamakoB.CRACK))
					.setValue(Wall_NamakoB.WATERLOGGED, blockstate.getValue(Wall_NamakoB.WATERLOGGED)), 3);

			itemstack.hurtAndBreak(1, playerIn, user -> {
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }
				user.broadcastBreakEvent(context.getHand()); } );

			return ActionResultType.SUCCESS;
		}
		
		
		/* Wash the brush. MIZUOKE work is in the block. */
		if (block == Blocks.CAULDRON) {
			int level = blockstate.getValue(CauldronBlock.LEVEL);
			if (level != 0) {
				CMEvents.soundWash(iworld, playerIn, blockpos);
				iworld.setBlock(blockpos, blockstate.setValue(CauldronBlock.LEVEL, Integer.valueOf(level - 1)), 3);

				/** Return the Item. **/
				if (!playerIn.inventory.add(new ItemStack(Items_Wadeco.HAKE))) {
					playerIn.drop(new ItemStack(Items_Wadeco.HAKE), false); }

				if (!mode) { itemstack.shrink(1); }
				return ActionResultType.SUCCESS;
			}
		}

		return ActionResultType.FAIL;
	}

}
