package com.black_dog20.tucs.container;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.inventory.InventoryUpgradeTools;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotUpgradeTools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ContainerUpgradeTools extends Container {
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private EntityPlayer Player;
	public IInventory slotUpgrade = new InventoryUpgradeTools();
	private static final int INV_START = 3, INV_END = INV_START+3,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	


	public ContainerUpgradeTools(World world, int x, int y, int z, EntityPlayer player, ItemStack item)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;
		
			this.addSlotToContainer(new SlotUpgradeTools(this.slotUpgrade, 0, 57 , 70));
			//this.addSlotToContainer(new SlotUpgradeTools(this.slotUpgrade, 1, 57+18 , 70));
		
		/*for(int k = 0; k < 3; k++){
		this.addSlotToContainer(new SlotUpgradeTools(this.slotUpgrade, k, 57 +(k*18), 37));
		}*/
		
		if(!item.hasTagCompound()){
			item.stackTagCompound = new NBTTagCompound();
		}
		if(item.hasTagCompound()){
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagList nbttaglist = nbt.getTagList("upgradeItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			if(slotItem !=null){
					this.slotUpgrade.setInventorySlotContents(b0 ,ItemStack.loadItemStackFromNBT(nbttagcompound1));
			
			nbttaglist.removeTag(i);
			}
		}
		}

		bindPlayerInventory(Player.inventory);

		
	}
	
	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; ++i){
			for (int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		ItemStack itemstack = null;
		Slot Islot = (Slot) this.inventorySlots.get(slot);

		if (Islot != null && Islot.getHasStack())
		{
			ItemStack itemstack1 = Islot.getStack();
			itemstack = itemstack1.copy();

			// If item is in our custom Inventory or armor slot
			if (slot < INV_START)
			{
				// try to place in player inventory / action bar
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true))
				{
					return null;
				}

				Islot.onSlotChange(itemstack1, itemstack);
			}
			// Item is in inventory / hotbar, try to place in custom inventory or armor slots
			else
			{
				/*
				If your inventory only stores certain instances of Items,
				you can implement shift-clicking to your inventory like this:
				
				// Check that the item is the right type
				if (itemstack1.getItem() instanceof ItemCustom)
				{
					// Try to merge into your custom inventory slots
					// We use 'InventoryItem.INV_SIZE' instead of INV_START just in case
					// you also add armor or other custom slots
					if (!this.mergeItemStack(itemstack1, 0, InventoryItem.INV_SIZE, false))
					{
						return null;
					}
				}
				// If you added armor slots, check them here as well:
				// Item being shift-clicked is armor - try to put in armor slot
				if (itemstack1.getItem() instanceof ItemArmor)
				{
					int type = ((ItemArmor) itemstack1.getItem()).armorType;
					if (!this.mergeItemStack(itemstack1, ARMOR_START + type, ARMOR_START + type + 1, false))
					{
						return null;
					}
				}
				Otherwise, you have basically 2 choices:
				1. shift-clicking between player inventory and custom inventory
				2. shift-clicking between action bar and inventory
				 
				Be sure to choose only ONE of the following implementations!!!
				*/
				/**
				 * Implementation number 1: Shift-click into your custom inventory
				 */
				if (slot >= INV_START)
        		    	{
            				// place in custom inventory
        				if (!this.mergeItemStack(itemstack1, 0, INV_START, false))
					{
						return null;
                			}
            			}
				
				/**
				 * Implementation number 2: Shift-click items between action bar and inventory
				 */
				// item is in player's inventory, but not in action bar
				if (slot >= INV_START && slot < HOTBAR_START)
				{
					// place in action bar
					if (!this.mergeItemStack(itemstack1, HOTBAR_START, HOTBAR_END+1, false))
					{
						return null;
					}
				}
				// item in action bar - place in player inventory
				else if (slot >= HOTBAR_START && slot < HOTBAR_END+1)	{
					if (!this.mergeItemStack(itemstack1, INV_START, INV_END+1, false))
					{
						return null;
					}
				}
			}

			if (itemstack1.stackSize == 0){
				Islot.putStack((ItemStack) null);
			}
			else{
				Islot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize){
				return null;
			}

			Islot.onPickupFromSlot(entityPlayer, itemstack1);
		}
		return itemstack;
	}
	
	@Override
	public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
		// this will prevent the player from interacting with the item that opened the inventory:
		if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
			return null;
		}
		return super.slotClick(slot, button, flag, player);
	}
	   
	 
	@Override
	public boolean canInteractWith(EntityPlayer player){
		/*boolean test;
		if(player.getHeldItem() != null){
			if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOC))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLBOTB))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLHOWF))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLPOLM))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOHD))){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}*/
		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		
		super.onContainerClosed(player);
		for(int i = 0; i < 3; i++){
			ItemStack item = this.slotUpgrade.getStackInSlot(i);
			player.dropPlayerItemWithRandomChoice(item, false);
		}
		/*
		ItemStack itemstack = this.slotUpgrade.getStackInSlotOnClosing(1);
		if(itemstack != null && itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade,1))){
			ItemStack stack = player.getHeldItem();
			if(stack != null && !stack.hasTagCompound()){
				stack.stackTagCompound = new NBTTagCompound();
			}
			if(stack != null && stack.hasTagCompound()){
			NBTTagCompound NBT = stack.getTagCompound();
			NBTTagList nbttaglist = new NBTTagList();
			NBTTagCompound nbttagcompound1 = new NBTTagCompound();
			nbttagcompound1.setByte("Slot", (byte)0);
			itemstack.writeToNBT(nbttagcompound1);
			nbttaglist.appendTag(nbttagcompound1);
			NBT.setTag("upgradeItems", nbttaglist);
			
			
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
			}
		}
		else{
			if (itemstack == null)
			{
				ItemStack stack = player.getHeldItem();
				if(stack != null &&!stack.hasTagCompound()){
					stack.stackTagCompound = new NBTTagCompound();
				}
				if(stack != null && stack.hasTagCompound()){
				NBTTagCompound NBT = stack.getTagCompound();
				NBT.removeTag(NBTTags.SOULBOUND);
				player.dropPlayerItemWithRandomChoice(itemstack, false);
			}
			
		}
		}*/
	}


}
