package com.black_dog20.tucs.container;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.inventory.InventoryTalisman;
import com.black_dog20.tucs.inventory.InventoryUpgradeTools;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotFlightTalisman;
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
	


	public ContainerUpgradeTools(World world, int x, int y, int z, EntityPlayer player, ItemStack item)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;
		
		
		for(int i = 0; i < 3; i++){
		this.addSlotToContainer(new SlotUpgradeTools(slotUpgrade, i, 57/* +(i*18)*/, 37));
		}
		
		if(!item.hasTagCompound()){
			item.stackTagCompound = new NBTTagCompound();
		}
		if(item.hasTagCompound()){
			NBTTagCompound nbt = item.getTagCompound();
			NBTTagList nbttaglist = nbt.getTagList("TalismanItems", Constants.NBT.TAG_COMPOUND);
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
	    for (int l = 0; l < 3; ++l)
        {
            for (int i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (int l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, l, 8 + l * 18, 142));
        }
	}

	@Override
	   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
	      Slot slotObject = (Slot) inventorySlots.get(slot);
	      if(slotObject != null && slotObject.getHasStack()) {
	         ItemStack stackInSlot = slotObject.getStack();
	         ItemStack stack = stackInSlot.copy();
	         if(slot <= 3) {
	            if(!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
	               return null;
	         } else if(slot != 1 && stack.isItemEqual(new ItemStack(ModItems.soulboundUpgrade)) && !getSlot(slot).getHasStack()) {
	            ItemStack copy = slotObject.decrStackSize(1);
	            getSlot(slot).putStack(copy);
	            return null;

	         } else {
	            return null;
	         }

	         if(stackInSlot.stackSize == 0)
	            slotObject.putStack(null);
	         else
	            slotObject.onSlotChanged();

	         return stack;
	      }
	      return null;
	   }
	   
	 
	@Override
	public boolean canInteractWith(EntityPlayer player){
		boolean test;
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
		}
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
			NBT.setTag("TalismanItems", nbttaglist);
			
			
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
