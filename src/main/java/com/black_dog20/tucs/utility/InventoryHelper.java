package com.black_dog20.tucs.utility;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryHelper {
	
	
	public static int findItem(Item item, InventoryPlayer iplayer){
		int res = 0;
		for(int i = 0; i < 36; i++){
			ItemStack testItem = iplayer.getStackInSlot(i);
			if(testItem !=null && testItem.getItem() == item){
				res += iplayer.getStackInSlot(i).stackSize;
			}
		}
		
		return res;
	}

}
