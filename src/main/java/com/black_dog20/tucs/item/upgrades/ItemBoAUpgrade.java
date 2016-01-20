package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemBoAUpgrade extends ItemTUCSUpgrades {

	public ItemBoAUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("boa" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.baneOfArthropods;
	}

}
