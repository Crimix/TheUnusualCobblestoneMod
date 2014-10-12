package com.black_dog20.tucs.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemPickupEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class EventHandler {
	NBTTagCompound nbt;

	@SubscribeEvent
	public void onEntityDeath(PlayerDropsEvent event) {
		EntityPlayer player = event.entityPlayer;
		ArrayList<EntityItem> list = event.drops;
		
		ListIterator<EntityItem> litr = list.listIterator();
		int i = 0;
		while(litr.hasNext()){
			
			EntityItem item = litr.next();
			ItemStack itemstack = item.getEntityItem();
			
			nbt = NBTHelper.getPlayerNBT(player);
			if(item !=null){
				if(!itemstack.hasTagCompound()){
					itemstack.stackTagCompound = new NBTTagCompound();
					}
				if(itemstack.hasTagCompound()){
					NBTTagCompound itemT = itemstack.getTagCompound();
					if(itemT.hasKey(NBTTags.SOULBOUND)){
						String test= itemT.getString(NBTTags.SOULBOUND);
						if(test.equals(NBTTags.OK)){
							nbt.setInteger(NBTTags.DROPLIST, i);
							nbt.setString(NBTTags.SOULBOUND + i, itemstack.getDisplayName());
							litr.remove();
							i++;
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event){
		EntityPlayer player = event.player;
		nbt = NBTHelper.getPlayerNBT(player);
		int size = nbt.getInteger(NBTTags.DROPLIST);
		for(int i = 0; i <= size; i++){
			String stringItem = nbt.getString(NBTTags.SOULBOUND +i);
			nbt.removeTag(NBTTags.SOULBOUND +i);
			ItemStack stack;
			NBTTagCompound stackT;
			switch(stringItem){
			case "The Ancient book":
				stack = new ItemStack(ModItems.TUCSbook,1);
				if(!stack.hasTagCompound()){
					stack.stackTagCompound = new NBTTagCompound();
				}
				stackT = stack.getTagCompound();
				stackT.setString(NBTTags.SOULBOUND, NBTTags.OK);
				player.inventory.setInventorySlotContents(i, stack);
				break;
			case "Semi-gods Talisman of flying":
				stack = new ItemStack(ModItems.FlightTalisman,1);
				
				if(!stack.hasTagCompound()){
					stack.stackTagCompound = new NBTTagCompound();
				}
				stackT = stack.getTagCompound();
				stackT.setString(NBTTags.SOULBOUND, NBTTags.OK);
				stackT.setString("slot", new ItemStack(Blocks.stone,1).getDisplayName());
				player.inventory.setInventorySlotContents(i, stack);
				break;
			}
		}
	}

	@SubscribeEvent
	public void onLivingUpdatePlayer(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
		EntityPlayer player = (EntityPlayer) event.entity;
         if(player.capabilities.allowFlying && !(player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)))){
        	 player.capabilities.allowFlying = false;
        	 player.capabilities.isFlying = false;
        	 player.sendPlayerAbilities();
         }
		}
	}
	
	@SubscribeEvent
	public void onFall(LivingFallEvent event){
		if (event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if((player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)))){
			event.setCanceled(true);
			}
		}
	}


}