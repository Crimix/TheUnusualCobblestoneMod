package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;

public class ItemTorchTalisman extends ItemTUCS{
	
	public ItemTorchTalisman(){
		super();
		this.setUnlocalizedName("torchTalisman");
		this.setMaxStackSize(1);
	    
	
	}
	
	
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		
			world.setBlock(p_147449_1_, p_147449_2_, p_147449_3_, p_147449_4_)
			
		return Item;
		
	    }

}
