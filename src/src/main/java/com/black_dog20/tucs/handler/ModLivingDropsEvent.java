package com.black_dog20.tucs.handler;


import scala.Console;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;


public class ModLivingDropsEvent {
	NBTTagCompound nbt;


          //Event for dropping items when a entity dies
          @SubscribeEvent
          public void onEntityDrop(LivingDropsEvent event) {
        	  boolean isPlayerCaused = event.source.getEntity() instanceof EntityPlayer; //Checks if the caused of death is by player
        	  if(isPlayerCaused == true){ 
            	  if(event.entityLiving instanceof EntityZombie) {
                  	 nbt = event.source.getEntity().getEntityData(); //Gets the nbt tag compound of the player
                	  Boolean cannotGetBook = nbt.getBoolean("TUCSBook"); //Checks if the player have got the book before 
                	  if(cannotGetBook == false){ 
                		  event.entityLiving.dropItem(ModItems.TUCSbook, 1); //Gives the player a book
                		  nbt.setBoolean("TUCSBook", true); //Sets the boolean on the player for the book to true

                	  }
            	  }
        	  }

          }
                  
}