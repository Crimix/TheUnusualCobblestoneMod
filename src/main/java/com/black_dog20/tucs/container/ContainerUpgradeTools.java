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
	public IInventory slot = new InventoryUpgradeTools();

	public ContainerUpgradeTools(World world, int x, int y, int z, EntityPlayer player, ItemStack item)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;

		for(int i = 0; i < 3; i++){
		this.addSlotToContainer(new Slot(slot, i, 57+18*i, 37));
		}
		System.out.println("slot works");
		
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
					this.slot.setInventorySlotContents(0 ,ItemStack.loadItemStackFromNBT(nbttagcompound1));
			
			nbttaglist.removeTag(i);
			}
		}
		}

		bindPlayerInventory(player.inventory);

		
	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	   public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
	      /*Slot slotObject = (Slot) inventorySlots.get(slot);
	      if(slotObject != null && slotObject.getHasStack()) {
	         ItemStack stackInSlot = slotObject.getStack();
	         ItemStack stack = stackInSlot.copy();
	         if(slot <= 1) {
	            if(!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
	               return null;
	         } else if(slot != 1 && stack.isItemEqual(new ItemStack(ModItems.soulboundUpgrade)) && !getSlot(0).getHasStack()) {
	            ItemStack copy = slotObject.decrStackSize(1);
	            getSlot(0).putStack(copy);
	            return null;

	         } else {
	            return null;
	         }

	         if(stackInSlot.stackSize == 0)
	            slotObject.putStack(null);
	         else
	            slotObject.onSlotChanged();

	         return stack;
	      }*/
	      return null;
	   }
	   
	 
	@Override
	public boolean canInteractWith(EntityPlayer player){
		boolean test;
		if(player.getHeldItem() != null){
			if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOC))){
				test = true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLBOTB))){
				test = true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLHOWF))){
				test = true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLPOLM))){
				test = true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOHD))){
				test = true;
			}
			else{
				test = false;
			}

		return test;
		}
		else{
			return false;
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		
		super.onContainerClosed(player);
		ItemStack itemstack = this.slot.getStackInSlotOnClosing(0);
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
		}
	}
	
	public boolean isItemValid(ItemStack itemstack) {
	      return ItemStack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade));
	   }


}
