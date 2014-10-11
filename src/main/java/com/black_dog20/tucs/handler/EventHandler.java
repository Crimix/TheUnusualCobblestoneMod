package com.black_dog20.tucs.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class EventHandler {
	ItemStack item;
	NBTTagCompound nbt;
	
	 @SubscribeEvent
     public void onEntityDeath(PlayerDropsEvent event) {
			 System.out.println("dead");
			 EntityPlayer player = event.entityPlayer;
			 getSoulbound(player.inventory);

     }
	 
	 @SubscribeEvent
	 public void onPlayerRespawn(PlayerRespawnEvent event){
		 System.out.println("live");
		 InventoryPlayer player = event.player.inventory;
		 setSoulboundItems(player);
	 }
	 
	 
	 
	 private void getSoulbound(InventoryPlayer IPlayer){
			
			for(int i = 0; i < IPlayer.getSizeInventory(); i++){
				
				item = IPlayer.getStackInSlot(i);
				nbt = NBTHelper.getPlayerNBT(IPlayer.player);
				if(item !=null){
					String test= item.stackTagCompound.getString("TucsSoul");
					System.out.println(test);
				if(test.equals("ok")){
					nbt.setString("TucsSoul "+ i, item.getDisplayName());
				}
				}
				
			}
		}
	 private void setSoulboundItems(InventoryPlayer IPlayer){
		 
		 for(int i = 0; i < IPlayer.getSizeInventory(); i++){
				item = IPlayer.getStackInSlot(i);
				nbt = NBTHelper.getPlayerNBT(IPlayer.player);
				String stringItem = nbt.getString("TucsSoul"+1);
				System.out.println(stringItem);
				switch(stringItem){
				case "The Ancient book":
					IPlayer.setInventorySlotContents(i, new ItemStack(ModItems.TUCSbook));
				break;
				}
				
			}
	 }

}