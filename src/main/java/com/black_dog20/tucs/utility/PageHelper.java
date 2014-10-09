package com.black_dog20.tucs.utility;

import java.util.HashMap;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.tool.ItemCobblestoneiumLighter;
import com.black_dog20.tucs.reference.PageTypes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PageHelper {
	public static boolean check(ItemStack result , EntityPlayer player){
		
		HashMap<ItemStack,String> pageCraft= new HashMap<ItemStack,String>();
		pageCraft.put(new ItemStack(ModItems.cobblestonediumLighter), PageTypes.FLAME);
		pageCraft.put(new ItemStack(ModItems.cobblestoneiumLighter), PageTypes.FLAME);
		pageCraft.put(new ItemStack(ModItems.cobblestoneLighter), PageTypes.FLAME);
		
		String n = pageCraft.get(result);
		System.out.println(n);
		NBTTagCompound nbt = player.getEntityData();
		boolean test = nbt.getBoolean(n);
		return test;
	}
}
