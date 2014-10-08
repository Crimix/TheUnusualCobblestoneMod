package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.creativetab.CreativeTabTUCSPages;
import com.black_dog20.tucs.reference.PageTypes;

public class ItemTUCSPageDebug extends ItemTUCS{
	public ItemTUCSPageDebug(){
		super();
		this.setUnlocalizedName("TUCSDebug");
		this.setCreativeTab(CreativeTabTUCSPages.TUCSPages_TAB);
}
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		NBTTagCompound nbt =player.getEntityData();
		nbt.removeTag(PageTypes.FLAME);
		return Item;
		
	    }
}
