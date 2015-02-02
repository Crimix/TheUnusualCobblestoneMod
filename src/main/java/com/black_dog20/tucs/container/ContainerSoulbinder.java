package com.black_dog20.tucs.container;

import java.util.List;

import com.black_dog20.tucs.crafting.AncientForgeRecipes;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.inventory.InventoryTUCS;
import com.black_dog20.tucs.inventory.InventoryTalisman;
import com.black_dog20.tucs.inventory.InventoryUpgradeTools;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotFlightTalisman;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;
import com.black_dog20.tucs.utility.NBTHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ContainerSoulbinder extends Container{

	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private EntityPlayer Player;
	public IInventory slot = new InventoryTUCS();

	public ContainerSoulbinder(World world, int x, int y, int z, EntityPlayer player)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;

		this.addSlotToContainer(new Slot(slot, 0, 75, 37));

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
	      Slot slotObject = (Slot) inventorySlots.get(slot);
	      if(slotObject != null && slotObject.getHasStack()) {
	         ItemStack stackInSlot = slotObject.getStack();
	         ItemStack stack = stackInSlot.copy();
	         if(slot <= 1) {
	            if(!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
	               return null;
	         } else if(slot != 1 && !getSlot(0).getHasStack()) {
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
	      }
	      return null;
	   }

	@Override
	public void onContainerClosed(EntityPlayer player){
		super.onContainerClosed(player);
		ItemStack itemstack = this.slot.getStackInSlotOnClosing(0);
		if(itemstack != null){
			if(itemstack != null && !itemstack.hasTagCompound()){
				itemstack.stackTagCompound = new NBTTagCompound();
			}
			if(itemstack != null && itemstack.hasTagCompound()){
			NBTTagCompound NBT = itemstack.getTagCompound();
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
			}
			itemstack.setTagInfo("ench", new NBTTagList());
			player.dropPlayerItemWithRandomChoice(itemstack, false);
		}
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}

}
