package com.black_dog20.tucs.proxies;

import com.black_dog20.tucs.tucs;

import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		
	}

	@Override
	public void registerKeyBindings() {
		// NOOP
		
	}

}
