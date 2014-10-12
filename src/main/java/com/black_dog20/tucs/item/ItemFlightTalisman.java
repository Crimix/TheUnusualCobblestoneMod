package com.black_dog20.tucs.item;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.utility.NBTHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemFlightTalisman extends ItemTUCS{
	
	public ItemFlightTalisman(){
		super();
		this.setUnlocalizedName("flightTalisman");
		this.setMaxStackSize(1);
	    
	}
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		
			if(player.isSneaking()){
				player.openGui(tucs.instance, tucs.guiIDFlightTalisman, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			}
			
		return Item;
		
	    }
}
