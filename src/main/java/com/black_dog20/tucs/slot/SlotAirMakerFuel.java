package com.black_dog20.tucs.slot;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SlotAirMakerFuel extends Slot {

	public SlotAirMakerFuel(IInventory inventory, int slotIndex, int x, int y) {
		super(inventory, slotIndex, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		if (itemstack.getItem() instanceof ItemBlock
				&& ((ItemBlock) itemstack.getItem()).field_150939_a == Blocks.sapling) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSlotStackLimit() {
		return 64;
	}

}
