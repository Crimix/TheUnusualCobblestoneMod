package com.black_dog20.tucs.container;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.entity.IEntityHoverVehicle;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.inventory.InventoryHoverBike;

public class ContainerHoverBike extends Container {
   public IInventory craftMatrix = new InventoryCrafting(this, 3, 3);
   public final InventoryHoverBike iventory;
   private World worldObj;
   private int posX;
   private int posY;
   private int posZ;
   private IEntityHoverVehicle hoverBike;

   public ContainerHoverBike(EntityPlayer player, World world, int x, int y, int z, Entity entity)
   {
       this.worldObj = world;
       this.posX = x;
       this.posY = y;
       this.posZ = z;
       this.iventory = new InventoryHoverBike(entity.getEntityId());
       if(entity instanceof IEntityHoverVehicle){
    	   this.hoverBike = (IEntityHoverVehicle)entity;
       }
       int rows = hoverBike.getRows();
       int columns = hoverBike.getColumns();
       
       for (int rowIndex = 0; rowIndex < rows; ++rowIndex)
       {
           for (int columnIndex = 0; columnIndex < columns; ++columnIndex)
           {
                   this.addSlotToContainer(new Slot(iventory, columnIndex + rowIndex * columns, 8 + columnIndex * 18, 18 + rowIndex * 18));
           }
       }

       for (int row = 0; row < 3; ++row)
       {
           for (int column = 0; column < 9; ++column)
           {
               this.addSlotToContainer(new Slot(player.inventory, column + row * 9 + 9, 8 + column * 18, 84 + row * 18));
           }
       }

       for (int row = 0; row < 9; ++row)
       {
           this.addSlotToContainer(new Slot(player.inventory, row, 8 + row * 18, 142));
       }

       this.onCraftMatrixChanged(this.craftMatrix);
   }


	/**
    * Called when the container is closed.
    */
   public void onContainerClosed(EntityPlayer EPlayer)
   {
   	
       super.onContainerClosed(EPlayer);

       if (!this.worldObj.isRemote)
       {
           for (int i = 0; i < 9; ++i)
           {
               ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

               if (itemstack != null)
               {
                   EPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
               }
           }
       }
   }

   public boolean canInteractWith(EntityPlayer EPlayer)
   {
       return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != ModBlocks.ancientTable ? false : EPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
   }

   /**
    * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
    */
   public ItemStack transferStackInSlot(EntityPlayer EPlayer, int par2)
   {
       ItemStack itemstack = null;
       Slot slot = (Slot)this.inventorySlots.get(par2);

       if (slot != null && slot.getHasStack())
       {
           ItemStack itemstack1 = slot.getStack();
           itemstack = itemstack1.copy();

           if (par2 == 0)
           {
               if (!this.mergeItemStack(itemstack1, 10, 46, true))
               {
                   return null;
               }

               slot.onSlotChange(itemstack1, itemstack);
           }
           else if (par2 >= 10 && par2 < 37)
           {
               if (!this.mergeItemStack(itemstack1, 37, 46, false))
               {
                   return null;
               }
           }
           else if (par2 >= 37 && par2 < 46)
           {
               if (!this.mergeItemStack(itemstack1, 10, 37, false))
               {
                   return null;
               }
           }
           else if (!this.mergeItemStack(itemstack1, 10, 46, false))
           {
               return null;
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

           slot.onPickupFromSlot(EPlayer, itemstack1);
       }

       return itemstack;
   }

}
