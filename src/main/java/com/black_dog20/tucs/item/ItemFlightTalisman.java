package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;

public class ItemFlightTalisman extends ItemTUCS{
	
	NBTTagCompound nbt;
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
	@Override
	public boolean hasEffect(ItemStack stack){
		
		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
		}
		if(stack.hasTagCompound()){
			NBTTagCompound nbt= stack.getTagCompound();
			
			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
