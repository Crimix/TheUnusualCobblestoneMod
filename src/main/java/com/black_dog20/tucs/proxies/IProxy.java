package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;

public interface IProxy {

	void openBook(EntityPlayer player);
	
	 public abstract void registerKeyBindings();
	 
	 public abstract void keyinput();

}
