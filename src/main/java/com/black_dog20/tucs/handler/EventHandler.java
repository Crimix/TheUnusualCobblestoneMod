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
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
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
					if(itemT.hasKey(NBTTags.SOULBOUND)){
						String test= itemT.getString(NBTTags.SOULBOUND);
						if(test.equals(NBTTags.OK)){
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
		}
		nbt.setTag("SoulboundItems", nbttaglist);

	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event){
		EntityPlayer player = event.player;
		nbt = NBTHelper.getPlayerNBT(player);
		NBTTagList nbttaglist = nbt.getTagList("SoulboundItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			player.inventory.addItemStackToInventory(ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
		nbt.removeTag("SoulboundItems");
	}

	@SubscribeEvent
	public void onLivingUpdatePlayer(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(player.capabilities.allowFlying && !player.capabilities.isCreativeMode){
			if(player.capabilities.allowFlying && !(player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)))){
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				player.sendPlayerAbilities();
			}
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
	
	@SubscribeEvent
	public void onItemUseUp(PlayerDestroyItemEvent event){
			EntityPlayer player = (EntityPlayer) event.entity;
			System.out.println("test");
			ItemStack item = event.original;
			System.out.println(item.getDisplayName());
			InventoryPlayer inv = player.inventory;
					if(item.isItemEqual( new ItemStack(ModItems.TLSOC))){
						ItemStack hilt = new ItemStack(ModItems.SwordHilt);
						ItemStack blade = new ItemStack(ModItems.SwordBlade);
						inv.addItemStackToInventory(blade);
						inv.addItemStackToInventory(hilt);
						
						giveItems(item, inv);
						
					}
					else if(item.isItemEqual( new ItemStack(ModItems.TLBOTB))){
						ItemStack rod = new ItemStack(ModItems.toolRod);
						ItemStack toolHead = new ItemStack(ModItems.hatchetHead);
						inv.addItemStackToInventory(rod);
						inv.addItemStackToInventory(toolHead);
						
						giveItems(item, inv);
					}
					else if(item.isItemEqual(new ItemStack(ModItems.TLHOWF))){
						ItemStack rod = new ItemStack(ModItems.toolRod);
						ItemStack toolHead = new ItemStack(ModItems.hoeHead);
						inv.addItemStackToInventory(rod);
						inv.addItemStackToInventory(toolHead);
						
						giveItems(item, inv);
					}
					else if(item.isItemEqual(new ItemStack(ModItems.TLPOLM))){
						ItemStack rod = new ItemStack(ModItems.toolRod);
						ItemStack toolHead = new ItemStack(ModItems.pickaxeHead);
						inv.addItemStackToInventory(rod);
						inv.addItemStackToInventory(toolHead);
						
						giveItems(item, inv);
					}
					else if(item.isItemEqual(new ItemStack(ModItems.TLSOHD))){
						ItemStack rod = new ItemStack(ModItems.toolRod);
						ItemStack toolHead = new ItemStack(ModItems.shovelHead);
						inv.addItemStackToInventory(rod);
						inv.addItemStackToInventory(toolHead);
						
						giveItems(item, inv);
					}
			}
	
	private void giveItems(ItemStack item, InventoryPlayer inv){
		NBTTagCompound nbt = item.getTagCompound();
		NBTTagList nbttaglist = nbt.getTagList("upgradeItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int b0 = nbttagcompound1.getInteger("Slot");
			ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			if(slotItem !=null){
				inv.addItemStackToInventory(slotItem);
			}
			nbt.removeTag("upgradeItems");
	}
	}

}