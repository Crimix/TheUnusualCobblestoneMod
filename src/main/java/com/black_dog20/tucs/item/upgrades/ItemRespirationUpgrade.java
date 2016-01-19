package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemRespirationUpgrade extends ItemTUCSUpgrades {

	public ItemRespirationUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("respiration" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.respiration;
	}

}
