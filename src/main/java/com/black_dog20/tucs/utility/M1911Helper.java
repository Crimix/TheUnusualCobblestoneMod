package com.black_dog20.tucs.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.init.ModItems;

public class M1911Helper {
	
	 public static int getAmmo(ItemStack item){
	    	int ammo = 0;
	    	if(!item.hasTagCompound()){
	    		item.stackTagCompound = new NBTTagCompound();
	    	}
	    	else{
	    		for(int i = 0; i < 7; i++){
	    			if(item.getTagCompound().hasKey("TUCSAmmo"+Integer.toString(i))){
	    				ammo++;
	    			}
	    		}
	    	}
	    	return ammo;
	    }
	    
	    public static void shoot(ItemStack item){
	    	if(!item.hasTagCompound()){
	    		item.stackTagCompound = new NBTTagCompound();
	    	}
	    	else{
	    		for(int i = 0; i < 7; i++){
	    			if(item.getTagCompound().hasKey("TUCSAmmo"+Integer.toString(i))){
	    				item.getTagCompound().removeTag("TUCSAmmo"+Integer.toString(i));
	    				break;
	    			}
	    		}
	    	}
	    }
	    
	    public static void reload(EntityPlayer player,ItemStack item){
	    	
	    	if(!item.hasTagCompound()){
        		item.stackTagCompound = new NBTTagCompound();
        	}
	    	
	    	if(player.inventory.hasItem(ModItems.ammo)){
	    		player.inventory.consumeInventoryItem(ModItems.ammo);
	    		for(int i = 0; i < 7; i++){
	    			item.getTagCompound().setBoolean("TUCSAmmo"+Integer.toString(i), true);
	        	}
	    	}
	    }

}
