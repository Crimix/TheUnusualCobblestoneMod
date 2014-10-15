package com.black_dog20.tucs.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;

public class ItemCraftingTalisman extends ItemTUCS{
	
	NBTTagCompound nbt;
	public ItemCraftingTalisman(){
		super();
		this.setUnlocalizedName("craftingTalisman");
		this.setMaxStackSize(1);
	    
	}
	
	
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		
				player.openGui(tucs.instance, tucs.guiIDAncientTable, world, (int)player.posX, (int)player.posY, (int)player.posZ);
			
		return Item;
		
	    }
}
