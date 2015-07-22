package com.black_dog20.tucs.handler;

import java.util.ArrayList;
import java.util.ListIterator;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import com.black_dog20.tucs.entity.IEntityHoverVehicle;
import com.black_dog20.tucs.network.PacketHandler;
import com.black_dog20.tucs.network.message.MessageConfigSync;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.InventoryHelper;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class PlayerEventHandler {

	NBTTagCompound nbt;
	boolean hasChanged;
	
	@SubscribeEvent
	public void onEntityDeath(PlayerDropsEvent event) {
		EntityPlayer player = event.entityPlayer;
		ArrayList<EntityItem> list = event.drops;
		NBTTagList nbttaglist = new NBTTagList();
		ListIterator<EntityItem> litr = list.listIterator();
		nbt = NBTHelper.getPlayerNBT(player);
		int i = 0;
		while(litr.hasNext()){

			EntityItem item = litr.next();
			ItemStack itemstack = item.getEntityItem();

			if(item !=null){
				if(itemstack.hasTagCompound()){
					NBTTagCompound itemT = itemstack.getTagCompound();
					if(itemT.hasKey(NBTTags.SOULBOUND) || itemT.hasKey(NBTTags.SOULBOUND_P)){
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						nbttagcompound1.setByte("Slot", (byte)i);
						itemstack.writeToNBT(nbttagcompound1);
						nbttaglist.appendTag(nbttagcompound1);
						litr.remove();
						i++;
					}
				}
			}
		}
		nbt.setTag("SoulboundItems", nbttaglist);

	}
	@SubscribeEvent
	public void Interact( PlayerInteractEvent event){
		if(event.entityPlayer.ridingEntity instanceof IEntityHoverVehicle){
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event){
		EntityPlayer player = event.player;
		nbt = NBTHelper.getPlayerNBT(player);
		NBTTagList nbttaglist = nbt.getTagList("SoulboundItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			ItemStack item = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			if(item != null && item.getItem() instanceof ItemArmor){
				ItemArmor armor = (ItemArmor)item.getItem(); 
				System.out.println(InventoryHelper.getArmorPosition(armor));
				if (player.inventory.armorInventory[InventoryHelper.getArmorPosition(armor)] == null)
				{
					player.inventory.armorInventory[InventoryHelper.getArmorPosition(armor)] = item;
				}
				else{
					player.inventory.addItemStackToInventory(item);
				}

			}else{
				player.inventory.addItemStackToInventory(item);
			}
		}
		nbt.removeTag("SoulboundItems");
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event){
		if(!event.player.worldObj.isRemote){
			PacketHandler.network.sendTo(new MessageConfigSync(), (EntityPlayerMP) event.player);
		}
	}
	
	
}