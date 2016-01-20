package com.black_dog20.tucs.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy extends CommonProxy {

	String FIRSTFLY = "firstFlight";
	String night = "TUCSNight";
	String nightA = "TUCSNightA";

	@Override
	public void openBook(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);

	}

	@Override
	public void openToolUpgrade(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		// NOOP

	}

	@Override
	public void keyinput() {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerRenders() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ServerRecipes() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ActivateFlight(EntityPlayer entityPlayer) {
		if (entityPlayer != null) {
			EntityPlayerMP EMP = (EntityPlayerMP) entityPlayer;
			NBTTagCompound nbt = NBTHelper.getPlayerNBT(EMP);
			if (EMP.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)) || EMP.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD))) {
				if (!EMP.capabilities.allowFlying) {
					EMP.capabilities.allowFlying = true;
					EMP.capabilities.isFlying = true;
				} else if (EMP.capabilities.allowFlying && !EMP.capabilities.isCreativeMode) {
					EMP.capabilities.allowFlying = false;
					EMP.capabilities.isFlying = false;
				}
			}
			EMP.sendPlayerAbilities();
			entityPlayer.sendPlayerAbilities();
		}

	}
}
