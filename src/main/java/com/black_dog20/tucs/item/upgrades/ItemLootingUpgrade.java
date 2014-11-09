package com.black_dog20.tucs.item.upgrades;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.item.ItemTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemLootingUpgrade extends ItemTUCSUpgrades {

	public ItemLootingUpgrade(int lvl){

		super();
		this.setUnlocalizedName("looting"+lvl+"Upgrade");

	}
}
