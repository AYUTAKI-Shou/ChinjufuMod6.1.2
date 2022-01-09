package com.ayutaki.chinjufumod.items.teatime;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* FlintAndSteelItem 参照*/
public class Match_Item extends Item {

	public Match_Item(Item.Properties builder) {
		super(builder.group(ItemGroups_CM.TEATIME));
	}

	/* FlintAndSteel */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		IWorld iworld = context.getWorld();
		BlockPos blockpos = context.getPos();
		BlockState blockstate = iworld.getBlockState(blockpos);
		ItemStack itemstack = context.getItem();
		boolean mode = playerIn.abilities.isCreativeMode;

		if (isUnlitCampfire(blockstate)) {
			iworld.playSound(playerIn, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
			iworld.setBlockState(blockpos, blockstate.with(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);

			if (!mode) { itemstack.shrink(1); }
			if (mode) { }

			return ActionResultType.SUCCESS;
		}

		else {
			BlockPos blockpos1 = blockpos.offset(context.getFace());

			if (canSetFire(iworld.getBlockState(blockpos1), iworld, blockpos1)) {
				iworld.playSound(playerIn, blockpos1, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
				BlockState blockstate1 = ((FireBlock)Blocks.FIRE).getStateForPlacement(iworld, blockpos1);
				iworld.setBlockState(blockpos1, blockstate1, 11);

				if (playerIn instanceof ServerPlayerEntity) {
					CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity)playerIn, blockpos1, itemstack);

					if (!mode) { itemstack.shrink(1); }
					if (mode) { }
				}

				return ActionResultType.SUCCESS;
			}
			else {
				return ActionResultType.FAIL;
			}
		}
	}

	public static boolean isUnlitCampfire(BlockState state) {
		return state.getBlock() == Blocks.CAMPFIRE && !state.get(BlockStateProperties.WATERLOGGED) && !state.get(BlockStateProperties.LIT);
	}

	@SuppressWarnings("deprecation")
	public static boolean canSetFire(BlockState existingState, IWorld worldIn, BlockPos posIn) {
		BlockState blockstate = ((FireBlock)Blocks.FIRE).getStateForPlacement(worldIn, posIn);
		boolean flag = false;

		for(Direction direction : Direction.Plane.HORIZONTAL) {
		BlockPos framePos = posIn.offset(direction);
			if (worldIn.getBlockState(framePos).isPortalFrame(worldIn, framePos) && ((NetherPortalBlock)Blocks.NETHER_PORTAL).isPortal(worldIn, posIn) != null) {
				flag = true;
			}
		}

		return existingState.isAir() && (blockstate.isValidPosition(worldIn, posIn) || flag);
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_match_cm")).applyTextStyle(TextFormatting.GRAY));
	}

}
