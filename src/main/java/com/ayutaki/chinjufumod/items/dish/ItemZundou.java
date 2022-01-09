package com.ayutaki.chinjufumod.items.dish;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.blocks.dish.Zundou;
import com.ayutaki.chinjufumod.items.base.ItemBlockBace;
import com.ayutaki.chinjufumod.registry.Dish_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemZundou extends ItemBlockBace {

	public ItemZundou() {
		super(Dish_Blocks.ZUNDOU);
		setCreativeTab(ChinjufuModTabs.TEATIME);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, Zundou.ID));
		setUnlocalizedName(Zundou.ID);
	}

	/* 水を入れる ItemBucket 淡水を使う為、ヤカンと寸胴は適用外 */

	/* 牛乳を汲む ItemShears */
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.EntityPlayer playerIn, EntityLivingBase entity, net.minecraft.util.EnumHand hand) {

		if (entity.world.isRemote) { return false; }

		/* EntityCow */
		if (stack.getItem() == Items_Teatime.ZUNDOU) {

			if (entity instanceof EntityCow && !playerIn.capabilities.isCreativeMode && !entity.isChild()) {

				entity.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

				if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.ZUNDOUMILK)))
				{ playerIn.dropItem(new ItemStack(Items_Teatime.ZUNDOUMILK), false); }

				/* 消費を最後に回す */
				stack.shrink(1);
				return true;
			}
		}
		return false;
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

		if (!itemstack.isEmpty() && playerIn.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(Dish_Blocks.ZUNDOU, pos, false, facing, (Entity)null)) {

			/** 設置するブロックのクラス **/
			IBlockState iblockstate1 = Dish_Blocks.ZUNDOU.getDefaultState().withProperty(Zundou.H_FACING, direction)
					.withProperty(Zundou.STAGE_1_3, Integer.valueOf(1));
			worldIn.setBlockState(pos, iblockstate1, 10);

			worldIn.playSound(null, pos, SoundEvents.BLOCK_METAL_PLACE, SoundCategory.BLOCKS, 1.0F, 0.8F);
			itemstack.shrink(1);
			return EnumActionResult.SUCCESS;
		}

		else {
			return EnumActionResult.FAIL;
		}
	}

	/* ToolTip*/

}
