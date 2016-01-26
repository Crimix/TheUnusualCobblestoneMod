package com.black_dog20.tucs.item.armor.cobblestonedium;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.item.ItemUpgradableArmorTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

public class ItemLegCobblestonedium extends ItemUpgradableArmorTUCS {

	public ItemLegCobblestonedium(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() instanceof ItemLegCobblestonedium) {
			return Reference.MOD_ID + ":models/armor/Cobblestonedium_2.png";
		} else {
			return null;
		}
	}

}
