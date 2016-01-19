package com.black_dog20.tucs.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;

public class ItemCraftingTalisman extends ItemTUCS {

	NBTTagCompound nbt;

	public ItemCraftingTalisman() {
		super();
		this.setUnlocalizedName("craftingTalisman");
		this.setMaxStackSize(1);

	}

	@Override public boolean hasEffect(ItemStack stack) {

		if (!stack.hasTagCompound()) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();

			if (nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player) {

		player.openGui(tucs.instance, tucs.guiIDCraftingTalisman, world, (int) player.posX, (int) player.posY, (int) player.posZ);

		return Item;

	}
}
