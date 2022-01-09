package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.GisouModel;
import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.ChinjufuModBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShiratsuyuArmor_Kai extends ArmorItem {

	public ShiratsuyuArmor_Kai(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
		super(material, slot, properties);
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entity, int slot, boolean selected) {

		if(entity instanceof PlayerEntity) {
			PlayerEntity playerIn = (PlayerEntity)entity;

			if(playerIn.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == Items_Armor.SHIRATSUYU_BOOTS_KAI) {

				/** 着水時の落下が多いため範囲を拡大 **/
				double x = (double) playerIn.prevPosX;
				double y = (double) playerIn.prevPosY;
				double z = (double) playerIn.prevPosZ;
				for(double i = -1.3D; i <= 1.3D; i++)
				for(double j = -1.3D; j <= 1.3D; j++)

					if (worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.WATER || worldIn
					.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.KELP || worldIn
					.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.SEAGRASS) {

						if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

							else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
							worldIn.setBlockState(new BlockPos(x - i, y, z -j), ChinjufuModBlocks.WAKE_WATER1.getDefaultState());
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@OnlyIn(Dist.CLIENT)
	@Override
	public <Armor extends BipedModel<?>> Armor getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, Armor _default) {

		GisouModel armorModel = new GisouModel(1.0F);
		GisouModel armorModelLegs = new GisouModel(0.5F);

		if (itemStack != null) {

			if (armorModel != null) {
				armorModel.bipedHead.showModel = armorSlot == EquipmentSlotType.HEAD;
				armorModel.bipedHeadwear.showModel = armorSlot == EquipmentSlotType.HEAD;
				armorModel.bipedBody.showModel = (armorSlot == EquipmentSlotType.CHEST) || (armorSlot == EquipmentSlotType.CHEST);
				armorModel.bipedRightArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				armorModel.bipedLeftArm.showModel = armorSlot == EquipmentSlotType.CHEST;
				armorModelLegs.bipedRightLeg.showModel = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);
				armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EquipmentSlotType.LEGS) || (armorSlot == EquipmentSlotType.FEET);

				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isChild = entityLiving.isChild();

				armorModelLegs.isSneak = entityLiving.isSneaking();
				armorModelLegs.isChild = entityLiving.isChild();
			}
			return (Armor)armorModel;
		}
		return null;
	}

	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag tipFlag) {
		super.addInformation(stack, worldIn, tooltip, tipFlag);
		tooltip.add((new TranslationTextComponent("tips.item_suijou_boots")).applyTextStyle(TextFormatting.GRAY));
	}

}
