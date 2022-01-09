package com.ayutaki.chinjufumod.items.armor;

import java.util.List;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.items.armor.model.ModelGisouBody;
import com.ayutaki.chinjufumod.registry.Chinjufu_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Armor;
import com.ayutaki.chinjufumod.registry.Items_ArmorMaterial;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShigureArmor_kai extends ItemArmor {

	public ItemShigureArmor_kai(int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(Items_ArmorMaterial.SHIGURE, renderIndexIn, equipmentSlotIn);

	}

	/* 水上航行 */
	public void onArmorTick(World worldIn, EntityPlayer playerIn, ItemStack armor) {

		if (this != Items_Armor.SHIGURE_BOOTS_KAI) {}

			int x = (int) playerIn.posX;
			int y = (int) playerIn.posY;
			int z = (int) playerIn.posZ;

		if (this == Items_Armor.SHIGURE_BOOTS_KAI) {

			for(int i = -1; i <= 1; i++)
			for(int j = -1; j <= 1; j++)
			for(int k = -2; k <= 0; k++)

			if (worldIn.getBlockState(new BlockPos(x - i, y - 1.0D, z -j)).getBlock() == Blocks.WATER){

				if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() != Blocks.AIR) { }

				else if (worldIn.getBlockState(new BlockPos(x - i, y, z -j)).getBlock() == Blocks.AIR) {
					worldIn.setBlockState(new BlockPos(x - i, y, z -j), Chinjufu_Blocks.WAKE_WATER1.getDefaultState());

				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag advanced) {
		int meta = stack.getMetadata();

		if (this != Items_Armor.SHIGURE_BOOTS_KAI) {}

		if (this == Items_Armor.SHIGURE_BOOTS_KAI) {
			tooltip.add(I18n.format("tips.item_suijou_boots", meta));
		}
	}

	/* アーマーモデル */
	@Override
	@SideOnly(Side.CLIENT) /* ←サーバーで処理されないように、Side.CLIENTを入れる */
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

		if (!itemStack.isEmpty()) {

			if (itemStack.getItem() instanceof ItemArmor) {

				ModelGisouBody armorModel = new ModelGisouBody(1.0f);
				ModelGisouBody armorModelLegs = new ModelGisouBody(0.5f);

				armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);
				armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);

				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();

				armorModelLegs.isSneak = entityLiving.isSneaking();
				armorModelLegs.isRiding = entityLiving.isRiding();
				armorModelLegs.isChild = entityLiving.isChild();

				return armorModel;
			}
		}
		return null;
	}

	/* Items needed for repair. */
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return (repair.getItem() == Items.IRON_INGOT);
	}

}
