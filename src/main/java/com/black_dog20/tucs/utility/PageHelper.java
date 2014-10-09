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
		
		HashMap<String,String> pageCraft= new HashMap<String,String>();
		pageCraft.put(new ItemStack(ModItems.cobblestonediumLighter).getDisplayName(), PageTypes.FLAME);
		pageCraft.put(new ItemStack(ModItems.cobblestoneiumLighter).getDisplayName(), PageTypes.FLAME);
		pageCraft.put(new ItemStack(ModItems.cobblestoneLighter).getDisplayName(), PageTypes.FLAME);
		
		if(result != null){
			String n = pageCraft.get(result.getDisplayName());
			NBTTagCompound nbt = player.getEntityData();
			boolean test = nbt.getBoolean(n);
			return test;
		}
		return false;
	}
}
