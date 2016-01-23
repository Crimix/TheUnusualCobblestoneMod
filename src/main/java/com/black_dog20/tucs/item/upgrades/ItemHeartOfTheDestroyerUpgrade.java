package com.black_dog20.tucs.item.upgrades;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.handler.ConfigurationHandler;

public class ItemHeartOfTheDestroyerUpgrade extends ItemTUCSUpgrades {

	public ItemHeartOfTheDestroyerUpgrade() {
		super();
		this.setUnlocalizedName("heartOfTheDestroyerUpgrade");
		this.setMaxStackSize(1);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List List, boolean par) {
		List.add(EnumChatFormatting.DARK_RED+"You are really twisted, plz don't destroy the world now");
	}

}
