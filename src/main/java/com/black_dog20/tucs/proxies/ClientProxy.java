package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.client.handler.KeyInputEventHandler;
import com.black_dog20.tucs.client.settings.Keybindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;


public class ClientProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.fly);
		
	}

	@Override
	public void keyinput() {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
		
	}

}
