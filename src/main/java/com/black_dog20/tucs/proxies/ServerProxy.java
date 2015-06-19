package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import com.black_dog20.tucs.tucs;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		
	}
	
	@Override
	public void openToolUpgrade(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		// NOOP
		
	}

	@Override
	public void keyinput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id,
			MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerRenders() {
		// TODO Auto-generated method stub
		
	}
}
