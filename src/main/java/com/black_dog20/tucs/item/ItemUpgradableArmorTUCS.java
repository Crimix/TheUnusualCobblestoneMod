package com.black_dog20.tucs.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUpgradableArmorTUCS extends ItemArmorTUCS {

	public final static int render = 0;
	public final static ArmorMaterial material = null;

	public ItemUpgradableArmorTUCS(ArmorMaterial material, int render, int armorType) {
		super(material, render, armorType);
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
	public void addInformation(ItemStack stack, EntityPlayer player, List List, boolean par) {
		List.add(EnumChatFormatting.GOLD + "Upgradeable");
	}

}
