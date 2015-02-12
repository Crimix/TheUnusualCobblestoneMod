package com.black_dog20.tucs.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.reference.NBTTags;

public class ItemTorchTalisman extends ItemTUCS{

	public ItemTorchTalisman(){
		super();
		this.setUnlocalizedName("torchTalisman");
		this.setMaxStackSize(1);


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
