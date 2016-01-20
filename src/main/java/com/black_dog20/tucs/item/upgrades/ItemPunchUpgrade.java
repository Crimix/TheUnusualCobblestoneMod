package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemPunchUpgrade extends ItemTUCSUpgrades {

	public ItemPunchUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("punch" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.punch;
	}

}
