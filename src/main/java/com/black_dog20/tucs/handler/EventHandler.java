package com.black_dog20.tucs.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import com.black_dog20.tucs.init.ModItems;
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
		int size = event.drops.size();
		for(int i = 0; i < size;){
			EntityItem item = event.drops.get(i);
			ItemStack itemstack = item.getEntityItem();

			nbt = NBTHelper.getPlayerNBT(player);
			if(item !=null){
				if(itemstack.hasTagCompound()){
					NBTTagCompound itemT = itemstack.getTagCompound();
					if(itemT.hasKey("TucsSoul")){
						String test= itemT.getString("TucsSoul");
						if(test.equals("ok")){
							nbt.setInteger("TucsDroplist",size);
							nbt.setString("TucsSoul"+ i, itemstack.getDisplayName());
							event.drops.remove(i);
						}
					}
				}
			}
			i++;
		}

	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event){
		EntityPlayer player = event.player;
		nbt = NBTHelper.getPlayerNBT(player);
		int size = nbt.getInteger("TucsDroplist");
		for(int i = 0; i < size; i++){
			String stringItem = nbt.getString("TucsSoul"+i);
			nbt.removeTag("TucsSoul"+i);
			switch(stringItem){
			case "The Ancient book":
				player.inventory.setInventorySlotContents(i, new ItemStack(ModItems.TUCSbook));
				break;
			}
		}
	}
	
	@SubscribeEvent
	public void onItemLeaveInventory(ItemTossEvent event){
		System.out.println("drop");
		EntityPlayer player = event.player;
		EntityItem item = event.entityItem;
		ItemStack itemStack = item.getEntityItem();
		
		if(itemStack.areItemStacksEqual(itemStack, new ItemStack(ModItems.FlightTalisman))){
			System.out.println("nofly");
			player.capabilities.allowFlying=false;
			player.capabilities.isFlying=false;
			player.sendPlayerAbilities();
		}
	}
	
	
}