package com.black_dog20.tucs.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.EnchantHelper;

public class SlotUpgradeTools extends Slot {
	
	public SlotUpgradeTools(IInventory inventory, int slotIndex,
			int x, int y) {
		super(inventory, slotIndex, x, y);
	}
	
	@Override
	   public boolean isItemValid(ItemStack itemstack) {
		return EnchantHelper.checkItem(itemstack);
	   }

	   @Override
	   public int getSlotStackLimit() {
	      return 1;
	   }


}
