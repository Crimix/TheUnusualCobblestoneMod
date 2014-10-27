package com.black_dog20.tucs.item;

import java.util.List;

import javax.print.attribute.standard.Sides;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.proxies.ClientProxy;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.PageTypes;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemBook extends ItemTUCS  {
	NBTTagCompound nbt;
	
	public ItemBook(){
		super();
		this.setUnlocalizedName("tucsBook");
		this.setMaxStackSize(1);
	    
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
	list.add("by The Lost Writer");
	}
	
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
			nbt = NBTHelper.getPlayerNBT(player);
			Boolean cannotGetBook = nbt.getBoolean(NBTTags.BOOK); //Checks if the player have got the book before
			Boolean openBefore = nbt.getBoolean(NBTTags.BOOK_OPEN); //Checks if the player have opened the book before
			
			if(cannotGetBook == true){
				if(openBefore == false){
					player.addChatMessage(new ChatComponentTranslation("msg.message_yfab.txt")); //Sends the message to the player
					nbt.setBoolean(NBTTags.BOOK_OPEN, true); 
				}
				else if(openBefore == true){
					tucs.Proxy.openBook(player);				
				}
			}
			
		return Item;
		
	    }
	
}
