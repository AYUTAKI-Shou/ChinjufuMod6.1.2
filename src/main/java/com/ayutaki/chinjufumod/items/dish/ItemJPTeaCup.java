package com.ayutaki.chinjufumod.items.dish;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.BaseStage3_FaceDown;
import com.ayutaki.chinjufumod.blocks.dish.JPTeaCup;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemJPTeaCup extends ItemBlockBace {

	public ItemJPTeaCup() {
		super(Dish_Blocks.JPTEACUP);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setUnlocalizedName(JPTeaCup.ID);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, JPTeaCup.ID));
	}

	/* 飲み終わった時の処理 */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

		if (!worldIn.isRemote) {
			entityLiving.addPotionEffect(new PotionEffect(MobEffects.HASTE, 2000, 0));
		}

		if (entityLiving instanceof EntityPlayerMP) {
			EntityPlayerMP playermp = (EntityPlayerMP)entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(playermp, stack);
			playermp.addStat(StatList.getObjectUseStats(this));
		}

		EntityPlayer playerIn = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;
		if (playerIn == null || !playerIn.capabilities.isCreativeMode) {
			if (stack.isEmpty()) { return new ItemStack(Items_Teatime.Item_DISH, 1, 1); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.Item_DISH, 1, 1))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.Item_DISH, 1, 1), false); }

			stack.shrink(1);
		}
		return stack;
	}

	/* 飲むのにかかる時間 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 32;
	}

	/* 飲むアクションをさせる */
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	/* 右クリックで飲むアクション */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	/* Place block */
	@Override
	public EnumActionResult onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {

		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) { pos = pos.offset(facing); }

			/* 4.0F / 360.0F) + 0.5D を 4.0F / 360.0F) + 2.5D に変えて180度回転 */
			int i = MathHelper.floor((double)(playerIn.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
			EnumFacing direction = EnumFacing.getHorizontal(i);
			ItemStack itemstack = playerIn.getHeldItem(hand);

			if (!itemstack.isEmpty() && facing == EnumFacing.UP && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn
					.mayPlace(Dish_Blocks.JPTEACUP, pos, false, facing, (Entity)null) && (playerIn.isSneaking() || playerIn.isRiding())) {

				/** 設置するブロックのクラス **/
				IBlockState iblockstate1 = Dish_Blocks.JPTEACUP.getDefaultState()
						.withProperty(BaseStage3_FaceDown.H_FACING, direction)
						.withProperty(BaseStage3_FaceDown.STAGE_1_3, Integer.valueOf(1));
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
		tooltip.add(I18n.format("tips.block_simpledish", meta));
	}

/* ItemFood の継承では、空腹度による制約が掛かり飲み物らしくない
 * 性質としては、飲めるアクションを付けた ItemBlock
 * onItemUseFinish では return にしないと食器が返らずに消える */
}
