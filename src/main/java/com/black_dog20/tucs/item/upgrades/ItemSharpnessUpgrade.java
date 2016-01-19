package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;

public class ItemSharpnessUpgrade extends ItemTUCSUpgrades {

	public ItemSharpnessUpgrade(int lvl) {

		super();
		this.setUnlocalizedName("sharpness" + lvl + "Upgrade");

	}

	@Override
	public Enchantment getEnchantment() {
		return Enchantment.sharpness;
	}

}
