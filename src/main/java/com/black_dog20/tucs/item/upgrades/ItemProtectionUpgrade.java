package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemProtectionUpgrade extends ItemTUCSUpgrades {

	public ItemProtectionUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("protection" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.protection;
	}

}
