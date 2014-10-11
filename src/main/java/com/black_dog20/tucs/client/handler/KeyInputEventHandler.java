package com.black_dog20.tucs.client.handler;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.reference.Key;
import com.black_dog20.tucs.utility.LogHelper;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler {

	NBTTagCompound nbt;
	 private static Key getPressedKeybinding()
	    {
	        if (Keybindings.Fly.isPressed())
	        {
	            return Key.FLY;
	        }

	        return Key.UNKNOWN;
	    }

	    @SubscribeEvent
	    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	    {
	    	if(getPressedKeybinding() == Key.FLY){
	    		System.out.println("test");
	    	if(FMLClientHandler.instance().getClient().inGameHasFocus)
	        {
	            if(FMLClientHandler.instance().getClientPlayerEntity() != null)
	            {
	                EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
	                nbt = NBTHelper.getPlayerNBT(entityPlayer);
	                String test = nbt.getString("TucsFly");
	                if(test.equals("nook")){
	                	nbt.setString("TucsFly", "ok");
	                	entityPlayer.capabilities.allowFlying = true;
	                	entityPlayer.capabilities.isFlying = true;
	                	entityPlayer.capabilities.setFlySpeed(0.2F);
	                	entityPlayer.sendPlayerAbilities();
	                }
	                else if(test.equals("ok")){
	                	nbt.setString("TucsFly", "nook");
	                	entityPlayer.capabilities.allowFlying = false;
	                	entityPlayer.capabilities.isFlying = false;
	                	entityPlayer.sendPlayerAbilities();
	                }
	                
	            }
	        }

	    	
	    	}
	    }
}
