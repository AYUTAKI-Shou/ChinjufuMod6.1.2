package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ItemGroups_CM;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/* BucketItem を参照。extends は BlockNamedItem とする */
public class DonabeKara_Item extends BlockNamedItem {
	private final Fluid containedBlock;

	public DonabeKara_Item(Fluid containedFluidIn, Block block, Item.Properties builder) {
		super(block, builder.group(ItemGroups_CM.TEATIME));

		this.containedBlock = containedFluidIn;
	}

	/* 水を入れる BucketItem */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = rayTrace(worldIn, playerIn, this.containedBlock == Fluids.EMPTY ? RayTraceContext.FluidMode.SOURCE_ONLY : RayTraceContext.FluidMode.NONE);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);

		boolean mode = playerIn.abilities.isCreativeMode;

		if (ret != null) return ret;

		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return ActionResult.resultPass(itemstack);
		}

		else if (raytraceresult.getType() != RayTraceResult.Type.BLOCK) {
			return ActionResult.resultPass(itemstack);
		}

		else {
			BlockRayTraceResult blockraytraceresult = (BlockRayTraceResult)raytraceresult;
			BlockPos blockpos = blockraytraceresult.getPos();
			Direction direction = blockraytraceresult.getFace();
			BlockPos blockpos1 = blockpos.offset(direction);

			if (worldIn.isBlockModifiable(playerIn, blockpos) && playerIn.canPlayerEdit(blockpos1, direction, itemstack)) {

				if (this.containedBlock == Fluids.EMPTY) {
					BlockState blockstate1 = worldIn.getBlockState(blockpos);

					if (blockstate1.getBlock() instanceof IBucketPickupHandler) {
						Fluid fluid = ((IBucketPickupHandler)blockstate1.getBlock()).pickupFluid(worldIn, blockpos, blockstate1);

						if (fluid != Fluids.EMPTY) {
							playerIn.addStat(Stats.ITEM_USED.get(this));

							SoundEvent soundevent = this.containedBlock.getAttributes().getEmptySound();
							if (soundevent == null) soundevent = fluid.isIn(FluidTags.LAVA) ? SoundEvents.ITEM_BUCKET_FILL_LAVA : SoundEvents.ITEM_BUCKET_FILL;
								playerIn.playSound(soundevent, 1.0F, 1.0F);

								if (fluid == Fluids.LAVA) {

									worldIn.playSound(null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.PLAYERS, 0.8F, 1.0F);
									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.AIR))) {
										playerIn.dropItem(new ItemStack(Items.AIR), false); }

									if (!mode) { itemstack.shrink(1); }
									if (mode) { }
								}

								else {
									if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABESHIO_nama))) {
										playerIn.dropItem(new ItemStack(Items_Teatime.NABESHIO_nama), false); }

									if (!mode) { itemstack.shrink(1); }
									if (mode) { }
								}

								return ActionResult.resultSuccess(itemstack);
							}
						}

					return ActionResult.resultFail(itemstack);
				}
			}
		}
		return ActionResult.resultFail(itemstack);
	}

	/* 設置処理の分岐 スニーク時 playerIn.isSneaking() 座っている時 playerIn.isPassenger() */
	public ActionResultType onItemUse(ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();

		if (context.getFace() == Direction.UP && (playerIn.isSneaking()) ) {
			return this.tryPlace(new BlockItemUseContext(context)); }

		else {
			return this.onItemRightClick(context.getWorld(), context.getPlayer(), context.getHand()).getType(); }
	}

	/* アイテムは @Nullable World worldIn、ブロックは @Nullable IBlockReader worldIn*/
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.block_simpledish")).applyTextStyle(TextFormatting.GRAY));
	}

}
