package com.black_dog20.tucs.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.black_dog20.tucs.reference.NBTTags;

public class TileEntitySoulForge extends TileEntity implements IInventory {

	private ItemStack slot;

	public TileEntitySoulForge() {

	}

	public int getSizeInventory() {
		return 1;
	}

	public ItemStack getStackInSlot(int par1) {
		return slot;
	}

	public ItemStack decrStackSize(int slot, int number) {
		if (this.slot != null) {
			ItemStack itemstack;

			if (this.slot.stackSize <= number) {
				itemstack = this.slot;
				this.slot = null;
				return itemstack;
			} else {
				itemstack = this.slot.splitStack(number);

				if (this.slot.stackSize == 0) {
					this.slot = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int slot, ItemStack item) {
		this.slot = item;

		if (item != null && item.stackSize > this.getInventoryStackLimit()) {

			item.stackSize = this.getInventoryStackLimit();
		}
		if (this.slot != null) {
			if (this.slot != null && !this.slot.hasTagCompound()) {
				this.slot.stackTagCompound = new NBTTagCompound();
			}
			if (this.slot != null && this.slot.hasTagCompound()) {
				NBTTagCompound NBT = this.slot.getTagCompound();
				NBT.setString(NBTTags.SOULBOUND_P, NBTTags.OK);
			}
		}
	}

	public String getInventoryName() {
		return "Soul Forge";
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(0);
		this.slot = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (slot != null) {
			NBTTagList nbttaglist = new NBTTagList();
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setByte("Slot", (byte) 1);
			this.slot.writeToNBT(nbttagcompound1);
			nbttaglist.appendTag(nbttagcompound1);
			nbt.setTag("Items", nbttaglist);
		}
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return slot;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
}
