package com.black_dog20.tucs.client.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;

import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyInputEventHandler {

	String FIRSTFLY = "firstFlight";
	String night ="TUCSNight";
	String nightA ="TUCSNightA";

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
		if(Keybindings.fly.isPressed() && ConfigurationHandler.Allow_To_Fly && ConfigurationHandler.Server_Flying_Allowed){
			if(FMLClientHandler.instance().getClientPlayerEntity() != null){
				EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
				NBTTagCompound nbt = NBTHelper.getPlayerNBT(entityPlayer);
				if(entityPlayer.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)) || entityPlayer.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD))){
					if(!entityPlayer.capabilities.allowFlying){
						entityPlayer.capabilities.allowFlying = true;
						entityPlayer.capabilities.isFlying = true;
						entityPlayer.sendPlayerAbilities();
						if(nbt.getBoolean(FIRSTFLY) == false){
							entityPlayer.capabilities.setFlySpeed(0.1F);
							nbt.setBoolean(FIRSTFLY, true);
						}
						entityPlayer.sendPlayerAbilities();
					}
					else if(entityPlayer.capabilities.allowFlying && !entityPlayer.capabilities.isCreativeMode){
						entityPlayer.capabilities.allowFlying = false;
						entityPlayer.capabilities.isFlying = false;
						entityPlayer.sendPlayerAbilities();
					}


			}
			}
		}
		else if(Keybindings.flyspeed.isPressed()){
			if(FMLClientHandler.instance().getClientPlayerEntity() != null){
				EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
				if(entityPlayer.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)) || entityPlayer.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD))){
					if(Float.compare(entityPlayer.capabilities.getFlySpeed(), 0.1F)==0){
						entityPlayer.addChatMessage(new ChatComponentTranslation("msg.message_highfly.txt"));
						entityPlayer.capabilities.setFlySpeed(0.2F);
						entityPlayer.sendPlayerAbilities();
					}
					else if(Float.compare(entityPlayer.capabilities.getFlySpeed(), 0.2F)==0){
						entityPlayer.addChatMessage(new ChatComponentTranslation("msg.message_normalfly.txt"));
						entityPlayer.capabilities.setFlySpeed(0.1F);
						entityPlayer.sendPlayerAbilities();
					}
				}	
			}
		}
		else if(Keybindings.night.isPressed()){
			if(FMLClientHandler.instance().getClientPlayerEntity() != null){
				EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();
				NBTTagCompound nbtp = NBTHelper.getPlayerNBT(entityPlayer);
				if(nbtp.hasKey(night) && !(nbtp.hasKey(nightA))){
					entityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id,500,1,false));
					nbtp.setBoolean(nightA, true);
				}
				else if(nbtp.hasKey(night) && nbtp.hasKey(nightA)){
					entityPlayer.removePotionEffect(Potion.nightVision.id);
					nbtp.removeTag(nightA);
				}
			}
		}
	}
}
