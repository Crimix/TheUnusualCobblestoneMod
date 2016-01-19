package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemSmiteUpgrade extends ItemTUCSUpgrades {

	public ItemSmiteUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("smite" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.smite;
	}

}
