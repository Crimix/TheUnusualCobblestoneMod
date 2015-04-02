package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;


public class ItemThornsUpgrade extends ItemTUCSUpgrades {

	public ItemThornsUpgrade(int lvl){

		super();
		this.setUnlocalizedName("thorns"+lvl+"Upgrade");

	}
	@Override
	public Enchantment getEnchantment(){
		return Enchantment.thorns;
	}

}
