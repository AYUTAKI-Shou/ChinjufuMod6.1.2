package com.ayutaki.chinjufumod.items.kansaiki;

import com.ayutaki.chinjufumod.registry.Items_Chinjufu;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseKansaiki extends Item {

	public BaseKansaiki(Properties builder) {
		super(builder);
	}

	/* 手に持って使用 */
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		stack.hurtAndBreak(1, attacker, (user) -> {
			user.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
		});
		return true;
	}

	@Override
	public boolean canAttackBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn) {
		return !playerIn.isCreative();
	}

	@Override
	public boolean mineBlock(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity attacker) {
		if ((double)state.getDestroySpeed(worldIn, pos) != 0.0D) {
			stack.hurtAndBreak(2, attacker, (user) -> {
				user.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
			});
		}
		return true;
	}

	/* Return the enchantability factor of the item, most of the time is based on material. */
	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	/* 修理 燃料・弾薬は自動補給で耐久値は修理が必要 */
	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack material) {
		return material.getItem() == Items_Chinjufu.ALUMINUM;
	}

}
