package com.black_dog20.tucs.item.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.reference.Reference;

public class ItemScubaMask extends ItemArmorTUCS implements IScubaMask{
	
	public ItemScubaMask(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setNoRepair();
		this.setMaxDamage(-1);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{

		if(stack.getItem() instanceof ItemScubaMask)
		{
			return Reference.MOD_ID + ":models/armor/scuba_1.png";

		}
		else
		{
			return null;
		}
	}
}
