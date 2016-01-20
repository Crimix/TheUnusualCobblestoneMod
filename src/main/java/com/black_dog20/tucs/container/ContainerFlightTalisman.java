package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.inventory.InventoryTalisman;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotFlightTalisman;

public class ContainerFlightTalisman extends Container {

	public IInventory slot = new InventoryTalisman();
	private final ItemStack invItem = new ItemStack(ModItems.FlightTalisman);

	public ContainerFlightTalisman(World world, int x, int y, int z, EntityPlayer player, ItemStack item) {

		this.addSlotToContainer(new SlotFlightTalisman(slot, 0, 75, 37));

		if (!item.hasTagCompound()) {
			item.stackTagCompound = new NBTTagCompound();
		}
		if (item.hasTagCompound()) {
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagList nbttaglist = nbt.getTagList("TalismanItems", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i <= nbttaglist.tagCount(); i++) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				byte b0 = nbttagcompound1.getByte("Slot");
				ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
				if (slotItem != null) {
					this.slot.setInventorySlotContents(0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
					nbttaglist.removeTag(i);
				}
			}
		}

		bindPlayerInventory(player.inventory);

	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			ItemStack stack = stackInSlot.copy();
			if (slot <= 1) {
				if (!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
					return null;
			} else if (slot != 1 && stack.isItemEqual(new ItemStack(ModItems.soulboundUpgrade)) && !getSlot(0).getHasStack()) {
				ItemStack copy = slotObject.decrStackSize(1);
				getSlot(0).putStack(copy);
				return null;

			} else {
				return null;
			}

			if (stackInSlot.stackSize == 0)
				slotObject.putStack(null);
			else
				slotObject.onSlotChanged();

			return stack;
		}
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (player.getHeldItem() != null) {
			boolean test = player.getHeldItem().isItemEqual(invItem);

			return test;
		} else {
			return false;
		}
	}

	@Override
	public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
		// this will prevent the player from interacting with the item that
		// opened the inventory:
		if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
			return null;
		}
		return super.slotClick(slot, button, flag, player);
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {

		super.onContainerClosed(player);
		ItemStack itemstack = this.slot.getStackInSlotOnClosing(0);
		if (itemstack != null && ItemStack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade, 1))) {
			ItemStack stack = player.getHeldItem();
			if (stack != null && !stack.hasTagCompound()) {
				stack.stackTagCompound = new NBTTagCompound();
			}
			if (stack != null && stack.hasTagCompound()) {
				NBTTagCompound NBT = stack.getTagCompound();
				NBTTagList nbttaglist = new NBTTagList();
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) 1);
				itemstack.writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
				NBT.setTag("TalismanItems", nbttaglist);

				NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
			}
		} else {
			if (itemstack == null) {
				ItemStack stack = player.getHeldItem();
				if (stack != null && !stack.hasTagCompound()) {
					stack.stackTagCompound = new NBTTagCompound();
				}
				if (stack != null && stack.hasTagCompound()) {
					NBTTagCompound NBT = stack.getTagCompound();
					NBT.removeTag(NBTTags.SOULBOUND);
					player.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}

		}
	}

	public boolean isItemValid(ItemStack itemstack) {
		return ItemStack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade));
	}

}
