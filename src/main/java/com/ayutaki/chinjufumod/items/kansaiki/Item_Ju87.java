package com.ayutaki.chinjufumod.items.kansaiki;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_2;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_3;
import com.ayutaki.chinjufumod.entity.kansaiki.Entity_Ju87_4;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.google.common.collect.Multimap;

import net.minecraft.block.material.Material;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Item_Ju87 extends Item_BaseKansaiki {

	private final float attackDamage = 9.0F - 1.0F;
	private final float attackSpeed = -2.4F;

	public Item_Ju87(String unlocalizedName) {
		super(unlocalizedName);
		setMaxDamage(1200);
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
		int j = 6;

		if (!worldIn.isRemote) {
			/** 水中では発艦不可 **/
			if (playerIn.isInsideOfMaterial(Material.WATER)) { CMEvents.textKKError(worldIn, playerIn); }
			
			if (!playerIn.isInsideOfMaterial(Material.WATER)) {
				/** クリエイティブモード **/
				if (playerIn.capabilities.isCreativeMode) {
					/** レベルに応じた Entity発艦 **/
					if (playerIn.experienceLevel < 12) {
						Entity_Ju87 kansaiki = new Entity_Ju87(worldIn, playerIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
						worldIn.spawnEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
						Entity_Ju87_2 kansaiki = new Entity_Ju87_2(worldIn, playerIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
						worldIn.spawnEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
						Entity_Ju87_3 kansaiki = new Entity_Ju87_3(worldIn, playerIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
						worldIn.spawnEntity(kansaiki); }
					
					if (playerIn.experienceLevel >= 25) {
						Entity_Ju87_4 kansaiki = new Entity_Ju87_4(worldIn, playerIn, itemstack);
						kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
						worldIn.spawnEntity(kansaiki); }
					
					playerIn.inventory.deleteStack(itemstack);
				}
	
				if (!playerIn.capabilities.isCreativeMode) {
	
					/* 耐久不足による発艦失敗 */
					if (itemstack.getItemDamage() >= (itemstack.getMaxDamage() - 1)) {
						worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.MASTER, 1.0F, 1.0F);
						itemstack.shrink(1); }
	
					else {
						/** 発艦時に耐久消費 **/
						itemstack.damageItem(1, playerIn);
						/** レベルに応じた Entity発艦 **/
						if (playerIn.experienceLevel < 12) {
							Entity_Ju87 kansaiki = new Entity_Ju87(worldIn, playerIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
							worldIn.spawnEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 12 && playerIn.experienceLevel < 19) {
							Entity_Ju87_2 kansaiki = new Entity_Ju87_2(worldIn, playerIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
							worldIn.spawnEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 19 && playerIn.experienceLevel < 25) {
							Entity_Ju87_3 kansaiki = new Entity_Ju87_3(worldIn, playerIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
							worldIn.spawnEntity(kansaiki); }
						
						if (playerIn.experienceLevel >= 25) {
							Entity_Ju87_4 kansaiki = new Entity_Ju87_4(worldIn, playerIn, itemstack);
							kansaiki.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 0.25F * j, 1.0F);						
							worldIn.spawnEntity(kansaiki); }

						itemstack.shrink(1); }
				}
			}
		}
		return ActionResult.newResult(EnumActionResult.SUCCESS, itemstack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();
		tooltip.add(I18n.format("tips.item_kk", meta));
		tooltip.add(TextFormatting.DARK_GREEN + I18n.format("tips.item_kk_ju87", meta));
	}
}
