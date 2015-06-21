package com.black_dog20.tucs.item.armor;

import net.minecraft.item.ItemStack;

public interface IScubaAirTank {
	
	int MAX_AIR = 300000;
	
	public double getMaxAir();
	public int getAir(ItemStack Item);
	public void decAir(ItemStack Item);
	public void addAir(ItemStack Item, int amount);
	public void removeAir(ItemStack Item, int amount);
	public void setAir(ItemStack Item, int amount);
	public void setMaxAir(ItemStack Item, int amount);

}
