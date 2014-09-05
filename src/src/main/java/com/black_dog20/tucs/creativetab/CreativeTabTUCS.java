package com.black_dog20.tucs.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.Reference;

public class CreativeTabTUCS {
	
	public static final  CreativeTabs TUCS_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()){
	
	 @Override
     public Item getTabIconItem()
     {
         return ModItems.TLSOC;
     }

     @Override
     public String getTranslatedTabLabel()
     {
         return Reference.MOD_NAME;
     }
 };

}
