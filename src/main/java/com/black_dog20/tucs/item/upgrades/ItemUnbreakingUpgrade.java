package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemUnbreakingUpgrade extends ItemTUCSUpgrades {

	public ItemUnbreakingUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("unbreaking" + lvl + "Upgrade");

	}

	@Override public Enchantment getEnchantment() {
		return Enchantment.unbreaking;
	}

}
