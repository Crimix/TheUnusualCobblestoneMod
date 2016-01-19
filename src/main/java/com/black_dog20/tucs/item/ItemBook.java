package com.black_dog20.tucs.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

public class ItemBook extends ItemTUCS {
	NBTTagCompound nbt;

	public ItemBook() {
		super();
		this.setUnlocalizedName("tucsBook");
		this.setMaxStackSize(1);

	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4) {
		list.add("by The Lost Writer");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Item, World world,
			EntityPlayer player) {
		nbt = NBTHelper.getPlayerNBT(player);
		Boolean openBefore = nbt.getBoolean(NBTTags.BOOK_OPEN); // Checks if the
																// player have
																// opened the
																// book before
		if (!openBefore) {
			player.addChatMessage(new ChatComponentTranslation(
					"msg.message_book.txt")); // Sends the message to the player
			nbt.setBoolean(NBTTags.BOOK_OPEN, true);
		} else if (openBefore == true) {
			tucs.Proxy.openBook(player);
		}
		return Item;

	}

}
