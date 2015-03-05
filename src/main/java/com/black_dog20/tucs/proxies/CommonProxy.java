package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.handler.GuiHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public abstract class CommonProxy implements IProxy {

	
	public void registerNetworkStuff(){
		  NetworkRegistry.INSTANCE.registerGuiHandler(tucs.instance, new GuiHandler());
		}
	public void openBook(){
		
	}
	
public void openToolUpgrade(){
		
	}

public EntityPlayer getPlayerFromMessageContext( MessageContext ctx)
{
  switch (ctx.side) {
    case CLIENT: {
       assert false : "Message for CLIENT received on dedicated server";
    }
    case SERVER: {
      EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
      return  entityPlayerMP;
    }
    default:
      assert false : "Invalid side in TestMsgHandler: " + ctx.side;
  }
return null;
  
}
public void render() {
	
}
}
