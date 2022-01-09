package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.ChinjufuModTabs;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Gyorai61cm4;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item_Gyorai61cm extends Item {

	private final float attackDamage = 11.0F - 1.0F;
	private final float attackSpeed = -2.4F;

	public Item_Gyorai61cm() {
		super();

		setCreativeTab(ChinjufuModTabs.CMARMOR);
	}


	/* 手に持って使用 */
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.shrink(1);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		stack.shrink(1);
		return true;
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	@SuppressWarnings("deprecation")
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.attackDamage, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.attackSpeed, 0));
		}
		return multimap;
	}

	/* 投げて使用 */
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, @Nonnull EnumHand hand) {
		ItemStack itemstack = playerIn.getHeldItem(hand);

		/** Entity の速度≒飛距離 **/
		int j = 8;

		worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents_CM.GYORAI, SoundCategory.MASTER, 1.0F, 1.0F);

		if (!worldIn.isRemote) {
			
			/** レベルに応じた Entity発艦 **/
			if (playerIn.experienceLevel < 12) {
				Entity_Gyorai61cm kansaiki = new Entity_Gyorai61cm(worldIn, playerIn, itemstack);
				kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.spawnEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
				Entity_Gyorai61cm2 kansaiki = new Entity_Gyorai61cm2(worldIn, playerIn, itemstack);
				kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.spawnEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
				Entity_Gyorai61cm3 kansaiki = new Entity_Gyorai61cm3(worldIn, playerIn, itemstack);
				kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.spawnEntity(kansaiki); }
			
			if (playerIn.experienceLevel >= 25) {
				Entity_Gyorai61cm4 kansaiki = new Entity_Gyorai61cm4(worldIn, playerIn, itemstack);
				kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);
				worldIn.spawnEntity(kansaiki); }
		}

		if (!playerIn.capabilities.isCreativeMode) { itemstack.shrink(1); }

		return ActionResult.newResult(EnumActionResult.SUCCESS, itemstack);
	}

	public int getItemEnchantability() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_gyorai", meta));
		tooltip.add(TextFormatting.DARK_GREEN + I18n.format("tips.item_gyorai2", meta));
	}
}
