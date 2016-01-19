package com.black_dog20.tucs.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.black_dog20.tucs.item.armor.IScubaAirTank;

public class TileEntityAirMaker extends TileEntity implements ISidedInventory {
	private ItemStack[] airMakerItemStacks = new ItemStack[2];
	private String display;
	public ItemStack AirTankForModel = null;

	public int getSizeInventory() {
		return 2;
	}

	public ItemStack getStackInSlot(int par1) {
		return this.airMakerItemStacks[par1];
	}

	public ItemStack decrStackSize(int slot, int number) {
		if (this.airMakerItemStacks[slot] != null) {
			ItemStack itemstack;

			if (this.airMakerItemStacks[slot].stackSize <= number) {
				itemstack = this.airMakerItemStacks[slot];
				this.airMakerItemStacks[slot] = null;
				return itemstack;
			} else {
				itemstack = this.airMakerItemStacks[slot].splitStack(number);

				if (this.airMakerItemStacks[slot].stackSize == 0) {
					this.airMakerItemStacks[slot] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.airMakerItemStacks[par1] != null) {
			ItemStack itemstack = this.airMakerItemStacks[par1];
			this.airMakerItemStacks[par1] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int slot, ItemStack item) {
		this.airMakerItemStacks[slot] = item;

		if (item != null && item.stackSize > this.getInventoryStackLimit()) {
			item.stackSize = this.getInventoryStackLimit();
		}
	}

	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.display : "Air Refiler";
	}

	public boolean hasCustomInventoryName() {
		return this.display != null && this.display.length() > 0;
	}

	public void setDisplayName(String displayName) {
		this.display = displayName;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.airMakerItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.airMakerItemStacks.length) {
				this.airMakerItemStacks[b0] = ItemStack
						.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		if (nbt.hasKey("CustomName", 8)) {
			this.display = nbt.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.airMakerItemStacks.length; ++i) {
			if (this.airMakerItemStacks[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.airMakerItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			nbt.setString("CustomName", this.display);
		}
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void updateEntity() {
		boolean flag1 = false;
		if (canAddAir()) {
			this.addAir();
			flag1 = true;
		}

		if (airMakerItemStacks[0] != null
				&& airMakerItemStacks[0].getItem() instanceof IScubaAirTank) {
			AirTankForModel = airMakerItemStacks[0];
		} else {
			AirTankForModel = null;
		}

		if (flag1) {
			this.markDirty();
		}
	}

	private boolean canAddAir() {
		if (this.airMakerItemStacks[0] == null) {
			return false;
		} else {
			if ((this.airMakerItemStacks[0].getItem() instanceof IScubaAirTank)
					&& isItemAir(this.airMakerItemStacks[1])) {
				IScubaAirTank item = (IScubaAirTank) this.airMakerItemStacks[0]
						.getItem();
				if (item.getAir(this.airMakerItemStacks[0]) < item.getMaxAir()) {
					return true;
				}
			}
		}
		return false;
	}

	public void addAir() {
		if (this.canAddAir()) {

			ItemStack airtank = this.airMakerItemStacks[0];
			if (airtank.getItem() instanceof IScubaAirTank) {
				IScubaAirTank tank = (IScubaAirTank) airtank.getItem();

				tank.addAir(airtank, 3000);
				decrStackSize(1, 1);
			}
		}
	}

	public static int getItemConvertTime(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		} else {
			if (itemstack.getItem() instanceof ItemBlock
					&& ((ItemBlock) itemstack.getItem()).field_150939_a == Blocks.sapling) {
				return 1;
			}
		}
		return 0;
	}

	public static boolean isItemAir(ItemStack itemstack) {
		return getItemConvertTime(itemstack) > 0;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord,
				this.zCoord) != this ? false : player.getDistanceSq(
				(double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
				(double) this.zCoord + 0.5D) <= 64.0D;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if (slot == 0 && itemstack != null
				&& itemstack.getItem() instanceof IScubaAirTank) {
			return true;
		} else if (slot == 1 && isItemAir(itemstack)) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[0];
	}

	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		return this.isItemValidForSlot(slot, itemstack);
	}

	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		return false;
	}
}