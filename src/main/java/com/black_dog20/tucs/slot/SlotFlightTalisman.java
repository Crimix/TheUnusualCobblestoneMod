package com.black_dog20.tucs.slot;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotFlightTalisman extends Slot {

	public SlotFlightTalisman(IInventory inventory, int par1,
			int par2, int par3) {
		super(inventory, par1, par2, par3);
	}
	
	@Override
	   public boolean isItemValid(ItemStack itemstack) {
	      return ItemStack.areItemStacksEqual(itemstack, new ItemStack(Blocks.stone));
	   }

	   @Override
	   public int getSlotStackLimit() {
	      return 1;
	   }

}
