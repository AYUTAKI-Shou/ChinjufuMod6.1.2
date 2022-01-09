package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BlockBeseNabe;
import com.ayutaki.chinjufumod.blocks.dish.Nabe_kara;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemNabe_kara extends ItemBlockBace {

	private final Block containedBlock;

	public ItemNabe_kara(Block containedBlockIn) {
		super(Dish_Blocks.NABE_kara);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setUnlocalizedName(Nabe_kara.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Nabe_kara.ID));

		this.containedBlock = containedBlockIn;
	}

	/* 水を入れる ItemBucket */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		boolean flag = this.containedBlock == Blocks.AIR;
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, flag);
		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemstack, raytraceresult);
		if (ret != null) return ret;

		if (raytraceresult == null) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack); }

		else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK) {
			return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack); }

		else {
			BlockPos blockpos = raytraceresult.getBlockPos();

			if (!worldIn.isBlockModifiable(playerIn, blockpos)) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
			}

			else if (flag) {

				if (!playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack)) {
					return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
				}

				else {
					IBlockState iblockstate = worldIn.getBlockState(blockpos);
					Material material = iblockstate.getMaterial();

					if (material == Material.WATER && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

						worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 11);
						playerIn.addStat(StatList.getObjectUseStats(this));
						playerIn.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0F, 1.0F);

						/** アイテムを返す **/
						if (itemstack.isEmpty()) { playerIn.setHeldItem(handIn, new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0)); }
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items_Teatime.NABE_KAISUI, 1, 0), false); }

						/* 消費を最後に回す */
						if (playerIn == null || !playerIn.capabilities.isCreativeMode) { itemstack.shrink(1); }
						if (playerIn.capabilities.isCreativeMode) { }

						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack); }

					else if (material == Material.LAVA && ((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() == 0) {

						playerIn.playSound(SoundEvents.ENTITY_GENERIC_BURN, 1.0F, 1.0F);
						playerIn.addPotionEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 0));
						playerIn.addStat(StatList.getObjectUseStats(this));

						/** アイテムを返す **/
						if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items.AIR, 1, 0))) {
							playerIn.dropItem(new ItemStack(Items.AIR, 1, 0), false); }

						/* 消費を最後に回す */
						if (playerIn == null || !playerIn.capabilities.isCreativeMode) { itemstack.shrink(1); }
						if (playerIn.capabilities.isCreativeMode) { }

						return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack); }

					else {
						return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
					}
				}
			}

			else {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
			}
		}
	}


	/* Place block */
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D を 4.0F / 360.0F) + 2.5D に変えて180度回転 */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack itemstack = playerIn.getHeldItem(hand);

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Dish_Blocks.NABE_kara, pos, false, facing, (Entity)null)) {

			/** 設置するブロックのクラス **/
			IBlockState iblockstate1 = Dish_Blocks.NABE_kara.getDefaultState()
					.withProperty(BlockBeseNabe.H_FACING, direction)
					.withProperty(BlockBeseNabe.STAGE_1_4, Integer.valueOf(1));
			worldIn.setBlockState(pos, iblockstate1, 10);

			SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, playerIn);
			worldIn.playSound((EntityPlayer)null, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);

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
		tooltip.add(I18n.format("tips.block_food_karanabe", meta));
	}

}
