package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCobbleCoal extends ItemTUCS {

	public ItemCobbleCoal() {

		super();
		this.setUnlocalizedName("cobbleCoal");

	}

	@Override
	public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player) {

		/*
		 * if(!Item.isItemEnchanted()){
		 * Item.addEnchantment(Enchantment.sharpness, 4); }
		 * 
		 * else if(Item.isItemEnchanted()){ if (Item.stackTagCompound == null) {
		 * Item.setTagCompound(new NBTTagCompound()); }
		 * 
		 * Item.stackTagCompound.removeTag("ench"); }
		 */
		return Item;

	}

}
