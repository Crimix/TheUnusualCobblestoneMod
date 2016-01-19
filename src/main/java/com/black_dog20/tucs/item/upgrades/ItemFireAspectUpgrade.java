package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemFireAspectUpgrade extends ItemTUCSUpgrades {

	public ItemFireAspectUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("fireaspect" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.fireAspect;
	}

}
