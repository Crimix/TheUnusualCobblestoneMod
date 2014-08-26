package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.black_dog20.tucs.client.gui.GuiTUCSBook;


public class ClientProxy extends CommonProxy {

	@Override
	public void openBook(EntityPlayer player){
		Minecraft.getMinecraft().displayGuiScreen(new GuiTUCSBook(player));
	}

}
