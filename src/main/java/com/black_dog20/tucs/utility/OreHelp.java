package com.black_dog20.tucs.utility;

import net.minecraft.item.ItemStack;

public class OreHelp {

	public static boolean ore(ItemStack input, ItemStack item){

		if(input.getDisplayName().contains("Ore")){
			if(item.getDisplayName().contains("Gold Ingot")){
				return true;
			}
			else if(item.getDisplayName().contains("Iron Ingot")){
				return true;
			}
			else if(item.getDisplayName().contains("Copper Ingot")){
				return true;
			}
			else if(item.getDisplayName().contains("Tin Ingot")){
				return true;
			}
			else if(item.getDisplayName().contains("Lead Ingot")){
				return true;
			}
			else if(item.getDisplayName().contains("Silver Ingot")){
				return true;
			}
		}
		else if(item.getDisplayName().contains("Steak")){
			return true;
		}
		else if(item.getDisplayName().contains("Porkchop")){
			return true;
		}
		else if(item.getDisplayName().contains("Fish")){
			return true;
		}
		else if(item.getDisplayName().contains("Salmon")){
			return true;
		}
		else if(item.getDisplayName().contains("Potato")){
			return true;
		}
		return false;
	}
}
