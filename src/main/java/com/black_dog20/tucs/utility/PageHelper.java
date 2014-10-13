package com.black_dog20.tucs.utility;

import java.util.HashMap;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.tool.ItemCobblestoneiumLighter;
import com.black_dog20.tucs.reference.PageTypes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PageHelper {
	static NBTTagCompound nbt;
	public static boolean check(ItemStack result , EntityPlayer player){
		
		nbt = NBTHelper.getPlayerNBT(player);
		HashMap<String,String> pageCraft= new HashMap<String,String>();
		pageCraft.put(new ItemStack(ModItems.cobblestonediumLighter).getDisplayName(), PageTypes.LIGHTERS);
		pageCraft.put(new ItemStack(ModItems.cobblestoneiumLighter).getDisplayName(), PageTypes.LIGHTERS);
		pageCraft.put(new ItemStack(ModItems.cobblestoneLighter).getDisplayName(), PageTypes.LIGHTERS);
		
		if(result != null){
		String n = pageCraft.get(result.getDisplayName());
			if(nbt.getBoolean(PageTypes.LIGHTERS)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
		return false;
		}
	}
	
	public static boolean myItem(ItemStack result){
		
		HashMap<String,Boolean> pageCraft= new HashMap<String,Boolean>();
		pageCraft.put(new ItemStack(ModItems.cobblestonediumLighter).getDisplayName(), true);
		pageCraft.put(new ItemStack(ModItems.cobblestoneiumLighter).getDisplayName(), true);
		pageCraft.put(new ItemStack(ModItems.cobblestoneLighter).getDisplayName(), true);
		
		if(pageCraft.get(result.getDisplayName())){
			return true;
		}
		else{
		return false;
		}
	}
}
