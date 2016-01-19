package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;

public class ContainerSoulForge extends Container {

	private int x, y, z;
	private World world;
	private TileEntitySoulForge tileSoulForge;

	public ContainerSoulForge(InventoryPlayer IPlayer, TileEntitySoulForge tileSoulForge) {
		this.addSlotToContainer(new Slot(tileSoulForge, 0, 75, 37));
		bindPlayerInventory(IPlayer);
		this.x = tileSoulForge.xCoord;
		this.y = tileSoulForge.yCoord;
		this.z = tileSoulForge.zCoord;
		this.world = tileSoulForge.getWorldObj();
		this.tileSoulForge = tileSoulForge;
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

	@Override public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			ItemStack stack = stackInSlot.copy();
			if (slot <= 1) {
				if (!mergeItemStack(stackInSlot, 2, tileSoulForge.getSizeInventory(), true))
					return null;
			} else if (slot != 1 && !getSlot(0).getHasStack()) {
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
		world.markBlockForUpdate(x, y, z);
		return null;
	}

	@Override public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
