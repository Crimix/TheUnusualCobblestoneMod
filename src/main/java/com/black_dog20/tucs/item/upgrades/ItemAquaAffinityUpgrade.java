package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;


public class ItemAquaAffinityUpgrade extends ItemTUCSUpgrades {

	public ItemAquaAffinityUpgrade(int lvl){

		super();
		this.setUnlocalizedName("aquaAffinity"+lvl+"Upgrade");

	}
	@Override
	public Enchantment getEnchantment(){
		return Enchantment.aquaAffinity;
	}

}
