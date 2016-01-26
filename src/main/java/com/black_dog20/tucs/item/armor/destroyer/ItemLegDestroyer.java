package com.black_dog20.tucs.item.armor.destroyer;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemUpgradableArmorTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

public class ItemLegDestroyer extends ItemUpgradableArmorTUCS {

	public ItemLegDestroyer(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ModItems.leggingsDestroyer) {
			return Reference.MOD_ID + ":models/armor/Destroyer_2.png";
		} else {
			return null;
		}
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List subItems) {
		ItemStack armor = new ItemStack(ModItems.leggingsDestroyer);
		armor.stackTagCompound = new NBTTagCompound();
		armor.stackTagCompound.setBoolean(NBTTags.NO_BREAKING, true);
		subItems.add(armor);
	}

}
