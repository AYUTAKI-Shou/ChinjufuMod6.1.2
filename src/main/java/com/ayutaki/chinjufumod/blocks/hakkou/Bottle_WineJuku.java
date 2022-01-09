package com.ayutaki.chinjufumod.blocks.hakkou;

import java.util.ArrayList;
import java.util.List;

import com.ayutaki.chinjufumod.ChinjufuMod;
import com.ayutaki.chinjufumod.handler.CMEvents;
import com.ayutaki.chinjufumod.registry.Hakkou_Blocks;
import com.ayutaki.chinjufumod.registry.Items_Teatime;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Bottle_WineJuku extends BaseBlock_SakeBottle {

	public static final String ID = "block_bot_winejuku_1";

	public Bottle_WineJuku() {
		super(Material.WOOD);
		setRegistryName(new ResourceLocation(ChinjufuMod.MOD_ID, ID));
		setUnlocalizedName(ID);
	}

	/* RightClick Action */
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();

		ItemStack itemstack = playerIn.getHeldItem(hand);
		Item item = itemstack.getItem();
		int k;
		k = itemstack.getMetadata();

		if (item == Items_Teatime.Item_DISH && k == 7) {
			/** Collect with an Item **/
			CMEvents.Consume_1Item(playerIn, hand);
			CMEvents.soundSakeGlassFill(worldIn, pos);

			/** インベントリが満杯でドロップさせるには if (itemstack.isEmpty()) を使う **/
			if (itemstack.isEmpty()) {
				playerIn.inventory
						.addItemStackToInventory(new ItemStack(Items_Teatime.WINEGLASS, 1, 2)); }
			else if (!playerIn.inventory.addItemStackToInventory(new ItemStack(Items_Teatime.WINEGLASS, 1, 2))) {
				playerIn.dropItem(new ItemStack(Items_Teatime.WINEGLASS, 1, 2), false); }

			if (i != 4) { worldIn.setBlockState(pos, state.withProperty(STAGE_1_4, Integer.valueOf(i + 1)), 3); }
			if (i == 4) {
				worldIn.setBlockState(pos, Hakkou_Blocks.KARABOT.getDefaultState()
						.withProperty(H_FACING, state.getValue(H_FACING))
						.withProperty(BaseBlock_SakeBottle.STAGE_1_4, Integer.valueOf(2))
						.withProperty(BaseBlock_SakeBottle.DOWN, state.getValue(DOWN))); } }
		
		if (item != Items_Teatime.Item_DISH || k != 7) { CMEvents.textNotHave(worldIn, pos, playerIn); }
		
		/** 'true' to not put anything on top. **/
		return true;
	}


	/*Drop Item and Clone Item.*/
	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> stack = new ArrayList<ItemStack>();

		int i = ((Integer)state.getValue(STAGE_1_4)).intValue();
		if (i == 1) { stack.add(new ItemStack(Items_Teatime.JUKUWINEBOT, 1, 0)); }
		if (i != 1) { stack.add(new ItemStack(Items_Teatime.Item_DISH, 1, 8)); }
		return stack;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World worldIn, BlockPos pos, EntityPlayer playerIn) {
		return new ItemStack(Items_Teatime.JUKUWINEBOT, 1, 0);
	}

}
