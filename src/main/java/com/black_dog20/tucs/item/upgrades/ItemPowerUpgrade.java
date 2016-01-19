package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemPowerUpgrade extends ItemTUCSUpgrades {

	public ItemPowerUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("power" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.power;
	}

}
