package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;


public class ItemFlameUpgrade extends ItemTUCSUpgrades {

	public ItemFlameUpgrade(int lvl){

		super();
		this.setUnlocalizedName("flame"+lvl+"Upgrade");

	}
	@Override
	public Enchantment getEnchantment(){
		return Enchantment.flame;
	}

}
