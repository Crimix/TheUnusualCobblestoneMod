package com.black_dog20.tucs.item;

import java.util.List;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemFlightTalisman extends ItemTUCS{
	
	NBTTagCompound nbt;
	public ItemFlightTalisman(){
		super();
		this.setUnlocalizedName("flightTalisman");
		this.setMaxStackSize(1);
	    
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		
		list.add("Shift right click to upgrade");
		list.add("");
		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
		}
		if(stack.hasTagCompound()){
			NBTTagCompound nbt= stack.getTagCompound();
			
			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)){
				list.add("Soulbound");
			}
			else{
				list.remove("Soulbound");
			}
		}
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
