package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public interface IProxy {

	void openBook(EntityPlayer player);

	public abstract void registerKeyBindings();

	public abstract void keyinput();

	void openToolUpgrade(EntityPlayer player);

	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx);

	EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx);

	public void registerRenders();

	public void ServerRecipes();

	public void ActivateFlight(EntityPlayer entityPlayer);
	
	public void Speed();


}
