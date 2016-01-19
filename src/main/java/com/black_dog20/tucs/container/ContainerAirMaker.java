package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.black_dog20.tucs.item.armor.IScubaAirTank;
import com.black_dog20.tucs.slot.SlotAirMakerFuel;
import com.black_dog20.tucs.slot.SlotAirMakerTank;
import com.black_dog20.tucs.tileEntity.TileEntityAirMaker;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAirMaker extends Container
{
    private TileEntityAirMaker tileAirMaker;
   

    public ContainerAirMaker(InventoryPlayer IPlayer, TileEntityAirMaker tileAirMaker)
    {
    	final EntityPlayer thePlayer = IPlayer.player;
        this.tileAirMaker = tileAirMaker;
        this.addSlotToContainer(new SlotAirMakerFuel(tileAirMaker, 1, 58, 38));
        this.addSlotToContainer(new SlotAirMakerTank(tileAirMaker, 0, 94, 38));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(IPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(IPlayer, i, 8 + i * 18, 142));
        }
        
        this.addSlotToContainer(new Slot(IPlayer, IPlayer.getSizeInventory() - 1 - 1, 20, 38)
        {
        	
            private static final String __OBFID = "CL_00001755";
            /**
             * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1
             * in the case of armor slots)
             */
            public int getSlotStackLimit()
            {
                return 1;
            }
            /**
             * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
             */
            public boolean isItemValid(ItemStack p_75214_1_)
            {
                if (p_75214_1_ == null) return false;
                return p_75214_1_.getItem().isValidArmor(p_75214_1_, 1, thePlayer);
            }
            /**
             * Returns the icon index on items.png that is used as background image of the slot.
             */
            @SideOnly(Side.CLIENT)
            public IIcon getBackgroundIconIndex()
            {
                return ItemArmor.func_94602_b(1);
            }
        });
        
    }


    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileAirMaker.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par1)
    {
    	 Slot slotObject = (Slot) inventorySlots.get(par1);
	      if(slotObject != null && slotObject.getHasStack()) {
	         ItemStack stackInSlot = slotObject.getStack();
	         ItemStack stack = stackInSlot.copy();
	         if(par1 <= 1) {
	            if(!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true))
	               return null;
	         } else if(par1 != 1 && stack.getItem() instanceof IScubaAirTank && !getSlot(1).getHasStack()) {
	            ItemStack copy = slotObject.decrStackSize(1);
	            getSlot(1).putStack(copy);
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
        /*ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par1);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par1 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par1 != 1 && par1 != 0)
            {
                if (par1 >= 3 && par1 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par1 >= 30 && par1 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
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

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;*/
    }
}