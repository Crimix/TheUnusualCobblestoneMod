package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemKnockbackUpgrade extends ItemTUCSUpgrades {

	public ItemKnockbackUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("knockback" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.knockback;
	}

}
