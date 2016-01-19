package com.black_dog20.tucs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryUpgradeTools implements IInventory {
	protected ItemStack[] inventory = new ItemStack[3];

	public int getSizeInventory() {
		return inventory.length;
	}

	public ItemStack getStackInSlot(int i) {
		return inventory[i];
	}

	public String getInventoryName() {
		return "Tool Upgrade";
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public ItemStack decrStackSize(int slot, int number) {
		if (this.inventory[slot] != null) {
			ItemStack itemstack = this.inventory[slot];
			this.inventory[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.inventory[i] != null) {
			ItemStack itemstack = this.inventory[i];
			this.inventory[i] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack stack) {
		this.inventory[i] = stack;
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void markDirty() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return false;
	}

}
