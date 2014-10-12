package com.black_dog20.tucs.container;

import java.util.List;

import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

public class ContainerFlightTalisman extends Container{

	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private EntityPlayer Player;
	private NBTTagCompound nbt;
	public IInventory craftResult = new InventoryCraftResult();

	public ContainerFlightTalisman(World world, int x, int y, int z, EntityPlayer player, ItemStack item)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;

		this.addSlotToContainer(new Slot(craftResult, 10, 10, 10));

		bindPlayerInventory(player.inventory);

		if(!item.hasTagCompound()){
			item.stackTagCompound = new NBTTagCompound();
		}
		nbt = item.getTagCompound();
		if(nbt.hasKey("slot")){
			String itemS = nbt.getString("slot");
			nbt.removeTag("slot");
			//Change later
			if(itemS.equalsIgnoreCase("Stone")){
				itemS = null;
				this.craftResult.setInventorySlotContents(1,  new ItemStack(Blocks.stone,1));
			}
		}
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
	public ItemStack transferStackInSlot(EntityPlayer player, int parSlot){ 
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(parSlot);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();


			if (parSlot == 1 )
			{
				if (!this.mergeItemStack(itemstack1, 0, 1, false))
				{
					return null;
				}
				else if (parSlot >= 3 && parSlot < 30)
				{
					if (!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if (parSlot >= 30 && parSlot < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer EPlayer) {

		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		
		super.onContainerClosed(player);
		ItemStack itemstack = this.craftResult.getStackInSlotOnClosing(1);
		if(itemstack != null && itemstack.areItemStacksEqual(itemstack, new ItemStack(Blocks.stone,1))){
			ItemStack stack = player.getHeldItem();
			if(!stack.hasTagCompound()){
				stack.stackTagCompound = new NBTTagCompound();
			}
			NBTTagCompound NBT = stack.getTagCompound();
			NBT.setString("slot", itemstack.getDisplayName());
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
		}
		else{
			if (itemstack != null)
			{
				ItemStack stack = player.getHeldItem();
				if(!stack.hasTagCompound()){
					stack.stackTagCompound = new NBTTagCompound();
				}
				NBTTagCompound NBT = stack.getTagCompound();
				NBT.removeTag(NBTTags.SOULBOUND);
				player.dropPlayerItemWithRandomChoice(itemstack, false);
			}
			
		}
	}

}
