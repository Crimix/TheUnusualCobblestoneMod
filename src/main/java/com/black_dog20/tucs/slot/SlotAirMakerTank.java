package com.black_dog20.tucs.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.item.armor.IScubaAirTank;

public class SlotAirMakerTank extends Slot {

	public SlotAirMakerTank(IInventory inventory, int slotIndex, int x, int y) {
		super(inventory, slotIndex, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return (itemstack.getItem() instanceof IScubaAirTank);
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

}
