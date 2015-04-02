package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;


public class ItemFeatherFallingUpgrade extends ItemTUCSUpgrades {

	public ItemFeatherFallingUpgrade(int lvl){

		super();
		this.setUnlocalizedName("featherFalling"+lvl+"Upgrade");

	}
	@Override
	public Enchantment getEnchantment(){
		return Enchantment.featherFalling;
	}

}
