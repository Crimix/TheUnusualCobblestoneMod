package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.handler.KeyInputEventHandler;
import com.black_dog20.tucs.client.render.TUCSWeaponOverlayRender;
import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.init.ModItems;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;


public class ClientProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void openToolUpgrade(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.fly);
		ClientRegistry.registerKeyBinding(Keybindings.flyspeed);
		ClientRegistry.registerKeyBinding(Keybindings.night);
	}

	@Override
	public void keyinput() {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
	}

	@Override
	public EntityPlayer getPlayerFromMessageContext( MessageContext ctx){
		switch (ctx.side) {
			case CLIENT: 
				EntityPlayer entityClientPlayerMP = Minecraft.getMinecraft().thePlayer;
				return entityClientPlayerMP;
			case SERVER:
				EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
				return entityPlayerMP;
		}
		return null;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx){
		if(ctx.side == Side.CLIENT) {
			EntityPlayer entityClientPlayerMP = (EntityPlayer) Minecraft.getMinecraft().theWorld.getEntityByID(id);
			return entityClientPlayerMP;
		}
		return null;
	}

	@Override
	public void registerRenders() {
		MinecraftForgeClient.registerItemRenderer(ModItems.TUCSBow, new TUCSWeaponOverlayRender());
		
	}

}
