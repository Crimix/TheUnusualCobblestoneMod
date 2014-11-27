package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.handler.GuiHandler;

import cpw.mods.fml.common.network.NetworkRegistry;

public abstract class CommonProxy implements IProxy {

	
	public void registerNetworkStuff(){
		  NetworkRegistry.INSTANCE.registerGuiHandler(tucs.instance, new GuiHandler());
		}
	public void openBook(){
		
	}
	
public void openToolUpgrade(){
		
	}
}
