package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;

import com.black_dog20.tucs.client.gui.GuiTUCSBook;


public class ClientProxy extends CommonProxy {

	@Override
	public void openBook(){
		Minecraft.getMinecraft().displayGuiScreen(new GuiTUCSBook());
	}
}
