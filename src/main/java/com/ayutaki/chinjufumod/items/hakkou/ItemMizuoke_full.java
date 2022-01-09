package com.ayutaki.chinjufumod.items.hakkou;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.crop.Enden;
import com.ayutaki.chinjufumod.blocks.hakkou.Mizuoke_full;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Crop_Blocks;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMizuoke_full extends ItemBlockBace {

	public ItemMizuoke_full() {
		super(Hakkou_Blocks.MIZUOKE_full);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setUnlocalizedName(Mizuoke_full.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Mizuoke_full.ID));

		setContainerItem(Items_Teatime.MIZUOKE);
	}

	/* 素材として使った時に特定のアイテムを返す */
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		return new ItemStack(Items_Teatime.MIZUOKE);
	}

	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos posIn, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(posIn);
		Block block = iblockstate.getBlock();
		ItemStack itemstack = playerIn.getHeldItem(hand);
		boolean mode = playerIn.capabilities.isCreativeMode;

		if (!playerIn.isSneaking() && playerIn.canPlayerEdit(posIn, facing, itemstack)) {

			/** 砂を塩田に変える **/
			if (iblockstate.getBlock() == Blocks.SAND && iblockstate.getValue(BlockSand.VARIANT) != EnumType.RED_SAND &&
					facing == EnumFacing.UP) {

				/** 生成するブロック **/
				IBlockState iblockstate1 = Crop_Blocks.ENDEN.getDefaultState().withProperty(Enden.STAGE_1_9, Integer.valueOf(1));
				worldIn.setBlockState(posIn, iblockstate1, 10);
				worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

				if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, itemstack); }

				/** アイテムを返す **/
				if (playerIn == null || !mode) {
					if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
						playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
					/* 消費を最後に回す */
					itemstack.shrink(1);
				}

				return EnumActionResult.SUCCESS;
			}

			/** 大釜への注水 **/
			if (iblockstate.getBlock() == Blocks.CAULDRON) {

				int level = iblockstate.getValue(BlockCauldron.LEVEL);

				if (level < 3) {
					worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

					if (level == 2) { ((BlockCauldron)block).setWaterLevel(worldIn, posIn, iblockstate, 3); }
					if (level < 2) { ((BlockCauldron)block).setWaterLevel(worldIn, posIn, iblockstate, level + 2); }

					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, itemstack); }

					/** アイテムを返す **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						itemstack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}
				return EnumActionResult.PASS;
			}

			else {
				if (worldIn.provider.doesWaterVaporize()) {

					int l = posIn.getX();
					int i = posIn.getY();
					int j = posIn.getZ();
					worldIn.playSound(playerIn, posIn, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

					for (int k = 0; k < 8; ++k) {
						worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0D, 0.0D, 0.0D); }

					/** アイテムを返す **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						itemstack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}

				if (!worldIn.provider.doesWaterVaporize()) {
					/** 生成するブロック 流れない Blocks.WATER とは別 **/
					IBlockState iblockstate1 = Blocks.FLOWING_WATER.getDefaultState();
					worldIn.setBlockState(posIn.offset(facing), iblockstate1, 11);
					worldIn.playSound(null, posIn, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);

					if (playerIn instanceof EntityPlayerMP) { CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)playerIn, posIn, itemstack); }

					/** アイテムを返す **/
					if (playerIn == null || !mode) {
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.MIZUOKE, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.MIZUOKE, 1, 0), false); }
						/* 消費を最後に回す */
						itemstack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}
			}
		}

		/** 水桶の設置 **/
		if (playerIn.isSneaking()) {

			if (!block.isReplaceable(worldIn, posIn)) { posIn = posIn.offset(facing); }
			/* 4.0F / 360.0F) + 0.5D を 4.0F / 360.0F) + 2.5D に変えて180度回転 */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);

			if (!itemstack.isEmpty() && playerIn.canPlayerEdit(posIn, facing, itemstack) && worldIn.mayPlace(Hakkou_Blocks.MIZUOKE_full, posIn, false, facing, (Entity)null)) {
				/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Hakkou_Blocks.MIZUOKE_full.getDefaultState()
						.withProperty(Mizuoke_full.H_FACING, direction)
						.withProperty(Mizuoke_full.STAGE_1_2, Integer.valueOf(1));
				worldIn.setBlockState(posIn, iblockstate1, 10);

				SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, posIn, playerIn);
				worldIn.playSound((EntityPlayer)null, posIn, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F); }

			/** 手に持っているアイテムを１個消費 **/
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip*/
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.block_mizuoke_full", meta));
		tooltip.add(I18n.format("tips.block_simpledish", meta));
	}

}
