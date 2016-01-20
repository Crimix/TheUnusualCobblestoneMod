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
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

public class ItemLegCobblestonedium extends ItemArmorTUCS {

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

	@Override
	public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player) {

		if (player.isSneaking()) {
			tucs.Proxy.openToolUpgrade(player);
		} else {
			this.Euip(Item, world, player);
		}

		return Item;

	}

	@Override
	public boolean hasEffect(ItemStack stack) {

		if (!stack.hasTagCompound()) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();

			if (nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK) || nbt.hasKey("ench")) {
				return true;
			}
			if (nbt.hasKey(NBTTags.SOULBOUND_P) || nbt.hasKey("ench")) {
				return true;
			}
			if (nbt.hasKey(NBTTags.Beheading) || nbt.hasKey("ench")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List List, boolean par) {
		List.add(EnumChatFormatting.GOLD + "Upgradeable");
	}

}
