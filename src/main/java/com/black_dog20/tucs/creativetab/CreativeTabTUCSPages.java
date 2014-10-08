package com.black_dog20.tucs.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.Reference;

public class CreativeTabTUCSPages {
	
	public static final  CreativeTabs TUCSPages_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()){
	
	 @Override
     public Item getTabIconItem()
     {
         return ModItems.page;
     }

     @Override
     public String getTranslatedTabLabel()
     {
         return Reference.MOD_NAME + " Pages";
     }
 };

}
