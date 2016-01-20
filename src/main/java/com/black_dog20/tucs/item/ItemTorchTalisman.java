package com.black_dog20.tucs.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.lwjgl.input.Keyboard;

import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.reference.NBTTags;

public class ItemTorchTalisman extends ItemTUCS {

	public ItemTorchTalisman() {
		super();
		this.setUnlocalizedName("torchTalisman");
		this.setMaxStackSize(1);

	}

	@Override
	public boolean hasEffect(ItemStack stack) {

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

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List List, boolean par) {
		List.add("Press " + Keyboard.getKeyName(Keybindings.night.getKeyCode()) + " to activate night vision");

	}

}
