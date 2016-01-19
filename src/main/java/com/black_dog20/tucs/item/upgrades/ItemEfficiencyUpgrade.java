package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemEfficiencyUpgrade extends ItemTUCSUpgrades {

	public ItemEfficiencyUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("efficiency" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.efficiency;
	}
}
