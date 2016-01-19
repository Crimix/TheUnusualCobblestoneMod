package com.black_dog20.tucs.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.init.ModItems;

public class SlotFlightTalisman extends Slot {

	public SlotFlightTalisman(IInventory inventory, int par1, int par2, int par3) {
		super(inventory, par1, par2, par3);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return ItemStack.areItemStacksEqual(itemstack, new ItemStack(
				ModItems.soulboundUpgrade));
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}

}
