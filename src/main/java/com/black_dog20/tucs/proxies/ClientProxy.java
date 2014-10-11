package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.client.settings.Keybindings;

import cpw.mods.fml.client.registry.ClientRegistry;


public class ClientProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.Fly);
		
	}

}
