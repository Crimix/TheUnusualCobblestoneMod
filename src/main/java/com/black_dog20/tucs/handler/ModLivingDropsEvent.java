package com.black_dog20.tucs.handler;


import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class ModLivingDropsEvent {
	NBTTagCompound nbt;


          //Event for dropping items when a entity dies
          @SubscribeEvent
          public void onEntityDrop(LivingDropsEvent event) {
        	  boolean isPlayerCaused = event.source.getEntity() instanceof EntityPlayer; //Checks if the caused of death is by player
        	  if(isPlayerCaused == true){ 
        		  
            	  if(event.entityLiving instanceof EntityZombie) {
            		  EntityPlayer player = (EntityPlayer) event.source.getEntity();
                  	 nbt = NBTHelper.getPlayerNBT(player); //Gets the nbt tag compound of the player
                	  Boolean cannotGetBook = nbt.getBoolean(NBTTags.BOOK); //Checks if the player have got the book before 
                	  if(cannotGetBook == false){ 
                		  event.entityLiving.dropItem(ModItems.TUCSbook, 1); //Gives the player a book
                		  nbt.setBoolean(NBTTags.BOOK, true); //Sets the boolean on the player for the book to true

                	  }
            	  }
            	  if(event.entityLiving instanceof EntitySkeleton) {
            		  double rand = Math.random();
            		  EntitySkeleton skeleton = (EntitySkeleton) event.entityLiving;
            		  if(skeleton.getSkeletonType() == 1){
            			  EntityPlayer player = (EntityPlayer) event.source.getEntity();
            			  if(player.getHeldItem().hasTagCompound()){
            				  NBTTagCompound nbtt = player.getHeldItem().getTagCompound();
            				  if(nbtt.hasKey(NBTTags.Beheading) && rand < 0.10D){
            					  skeleton.entityDropItem(new ItemStack(Items.skull,1, 1), 1);
            				  }
            			  }
            			  
            		  }
            	  }
        	  }

          }
                  
}