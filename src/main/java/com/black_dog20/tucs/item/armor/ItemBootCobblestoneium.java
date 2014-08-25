package com.black_dog20.tucs.item.armor;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemBootCobblestoneium extends ItemArmorTUCS {

	public ItemBootCobblestoneium(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 0, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == ModItems.bootsCobblestoneium)
		{
			return Reference.MOD_ID + ":models/armor/Cobblestoneium_2.png";
		}
		else
		{
			return null;
		}
	}

}
