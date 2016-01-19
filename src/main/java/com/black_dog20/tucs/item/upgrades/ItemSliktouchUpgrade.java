package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemSliktouchUpgrade extends ItemTUCSUpgrades {

	public ItemSliktouchUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("sliktouch" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.silkTouch;
	}

}
