package com.ayutaki.chinjufumod.tileentity;

import javax.annotation.Nullable;

import com.ayutaki.chinjufumod.blocks.furniture.Tansu;
import com.ayutaki.chinjufumod.handler.SoundEvents_CM;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.BlockPos;

public class TileEntityTansu extends TileEntityLockableLoot implements ITickable {

	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(27, ItemStack.EMPTY);

	/* 開閉の管理用 */
	private boolean openHiki;
	private boolean closeHiki;

	public int numPlayersUsing;
	private BlockChest.Type cachedChestType;

	public TileEntityTansu() { }

	public TileEntityTansu(BlockChest.Type typeIn) {
		this.cachedChestType = typeIn;
	}

	/*	 インベントリーの数 */
	public int getSizeInventory() {
		return 27;
	}

	public boolean isEmpty() {
		for (ItemStack itemstack : this.chestContents) {

			if (!itemstack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/* Get the name of this object. For players this returns their username */
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.chest";
	}

	/* 収納したアイテムの処理 */
	public static void registerFixesChest(DataFixer fixer) {
		fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityTansu.class, new String[] {"Items"}));
	}

	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);

		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}

		if (compound.hasKey("CustomName", 8)) {
			this.customName = compound.getString("CustomName");
		}
	}

	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}

		if (this.hasCustomName()) {
			compound.setString("CustomName", this.customName);
		}
		return compound;
	}

	/* インベントリにおけるスタックの最大値 */
	public int getInventoryStackLimit() {
		return 64;
	}

	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	@Nullable
	protected TileEntityTansu getAdjacentChest(EnumFacing side) {
		BlockPos blockpos = this.pos.offset(side);

		if (this.isChestAt(blockpos)) {
			TileEntity tileentity = this.world.getTileEntity(blockpos);

			if (tileentity instanceof TileEntityTansu) {
				TileEntityTansu tileentitychest = (TileEntityTansu)tileentity;
				return tileentitychest;
			}
		}
		return null;
	}

	private boolean isChestAt(BlockPos posIn) {

		if (this.world == null) {
			return false;
		}
		else {
			Block block = this.world.getBlockState(posIn).getBlock();
			return block instanceof BlockChest && ((BlockChest)block).chestType == this.getChestType();
		}
	}

	/*	 クライアントイベントの受信 */
	public boolean receiveClientEvent(int id, int type) {

		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		}
		else {
			return super.receiveClientEvent(id, type);
		}
	}

	/*	 チェストの開閉処理 */
	public void openInventory(EntityPlayer playerIn) {

		if (!playerIn.isSpectator()) {

			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}

			this.openHiki = true;
			this.closeHiki = false;

			++this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);

		}
	}

	public void closeInventory(EntityPlayer playerIn) {

		if (!playerIn.isSpectator() && this.getBlockType() instanceof Tansu) {

			this.openHiki = false;
			this.closeHiki = true;

			--this.numPlayersUsing;
			this.world.addBlockEvent(this.pos, getBlockType(), 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
		}
	}

	/*	 チェストの開閉時の効果音 */
	public void update() {

		if (this.openHiki == true) {
			this.world.playSound((EntityPlayer)null, this.pos.getX(), this.pos.getY(), this.pos.getZ(),
					SoundEvents_CM.TANSU_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
			this.openHiki = false;
		}

		if (this.closeHiki == true) {
			this.world.playSound((EntityPlayer)null, this.pos.getX(), this.pos.getY(), this.pos.getZ(),
					SoundEvents_CM.TANSU_CLOSE, SoundCategory.BLOCKS, 1.0F, 1.0F);

			this.closeHiki = false;
		}
	}

	/* シングルチェストの容量を拾う */
	public net.minecraftforge.items.IItemHandler getSingleChestHandler() {
		return super.getCapability(net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
	}

	/* タイルエンティを無効化 */
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	/* チェストのタイプ */
	public BlockChest.Type getChestType() {

		if (this.cachedChestType == null) {

			if (this.world == null || !(this.getBlockType() instanceof BlockChest)) {
				return BlockChest.Type.BASIC;
			}
		}
		return this.cachedChestType;
	}

	/* GUIのID */
	public String getGuiID() {
		return "minecraft:chest";
	}

	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerChest(playerInventory, this, playerIn);
	}

	protected NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}


}

