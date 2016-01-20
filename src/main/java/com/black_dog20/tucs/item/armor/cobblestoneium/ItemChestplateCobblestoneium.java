package com.black_dog20.tucs.item.armor.cobblestoneium;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.reference.Reference;

public class ItemChestplateCobblestoneium extends ItemArmorTUCS {

	public ItemChestplateCobblestoneium(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == ModItems.chestplateCobblestoneium) {
			return Reference.MOD_ID + ":models/armor/Cobblestoneium_1.png";
		} else {
			return null;
		}
	}

}
