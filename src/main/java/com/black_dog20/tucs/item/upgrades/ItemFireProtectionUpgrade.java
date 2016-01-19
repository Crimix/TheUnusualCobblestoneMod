package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemFireProtectionUpgrade extends ItemTUCSUpgrades {

	public ItemFireProtectionUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("fireProtection" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.fireProtection;
	}

}