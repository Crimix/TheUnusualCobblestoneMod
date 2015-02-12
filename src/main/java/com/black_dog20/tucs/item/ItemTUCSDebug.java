package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.utility.NBTHelper;

public class ItemTUCSDebug extends ItemTUCS{
	public ItemTUCSDebug(){
		super();
		this.setUnlocalizedName("TUCSDebug");
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
}
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		NBTTagCompound nbt = NBTHelper.getPlayerNBT(player);
		nbt.removeTag("TUCSBook");
		nbt.removeTag("TUCSBook_open");
		return Item;
		
	    }
}
