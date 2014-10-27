package com.black_dog20.tucs.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.init.ModItems;

public class SlotUpgradeTools extends Slot {
	
	public SlotUpgradeTools(IInventory inventory, int slotIndex,
			int x, int y) {
		super(inventory, slotIndex, x, y);
	}
	
	@Override
	   public boolean isItemValid(ItemStack itemstack) {
		if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting1Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting2Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting3Upgrade,1))){
			return true;
		}
		else{
			return false;
		}
	   }

	   @Override
	   public int getSlotStackLimit() {
	      return 1;
	   }


}
