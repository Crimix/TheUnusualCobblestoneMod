package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemProjectileProtectionUpgrade extends ItemTUCSUpgrades {

	public ItemProjectileProtectionUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("projectileProtection" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.projectileProtection;
	}

}
