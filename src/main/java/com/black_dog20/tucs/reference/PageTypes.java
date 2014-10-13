package com.black_dog20.tucs.reference;

import java.util.LinkedHashMap;

import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;

import net.minecraft.item.ItemStack;

public class PageTypes {
	
	public static final int PAGES = 1;
	public static final String BASIC = "TucsBasic";
	public static final String LIGHTERS = "TucsCobblestone Lighters";
	public static final String OK_TAG = "ok";

	
	
	
	
	public static String getPageType(ItemStack item){

		if(item != null){
			String itemString = item.getDisplayName(); 
			if(itemString.equalsIgnoreCase(new ItemStack(ModBlocks.ancientTable).getDisplayName())){
				return BASIC;
			}
			else if(itemString.equalsIgnoreCase(new ItemStack(ModBlocks.blockAncientForge).getDisplayName())){
				return BASIC;
			}
			else if(itemString.equalsIgnoreCase(new ItemStack(ModItems.cobblestoneLighter).getDisplayName())){
				return BASIC;
			}
			else if(itemString.equalsIgnoreCase(new ItemStack(ModItems.cobblestonediumLighter).getDisplayName())){
				return LIGHTERS;
			}
			else if(itemString.equalsIgnoreCase(new ItemStack(ModItems.cobblestoneiumLighter).getDisplayName())){
				return LIGHTERS;
			}
			/*else if(itemString.equalsIgnoreCase(new ItemStack(ModBlocks.ancientTable).getDisplayName())){
				return OK_TAG;
			}
			else if(itemString.equalsIgnoreCase(new ItemStack(ModBlocks.ancientTable).getDisplayName())){
				return OK_TAG;
			}*/
			else{
				return null;
			}
			
		}
		else{
		return null;
		}
	}
}
