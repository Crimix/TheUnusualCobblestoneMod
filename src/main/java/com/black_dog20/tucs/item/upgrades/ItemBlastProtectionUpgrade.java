package com.black_dog20.tucs.item.upgrades;

import net.minecraft.enchantment.Enchantment;


public class ItemBlastProtectionUpgrade extends ItemTUCSUpgrades {

	public ItemBlastProtectionUpgrade(int lvl){

		super();
		this.setUnlocalizedName("blastProtection"+lvl+"Upgrade");

	}
	
	@Override
	public Enchantment getEnchantment(){
		return Enchantment.blastProtection;
	}

}
