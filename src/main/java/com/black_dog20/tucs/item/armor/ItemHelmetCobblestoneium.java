package com.black_dog20.tucs.item.armor;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.reference.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemHelmetCobblestoneium extends ItemArmorTUCS{

	public ItemHelmetCobblestoneium(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 0, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModItems.helmetCobblestoneium)
		{
			return Reference.MOD_ID + ":models/armor/Cobblestoneium_1.png";
		}
		else
		{
			return null;
		}
	}

}
