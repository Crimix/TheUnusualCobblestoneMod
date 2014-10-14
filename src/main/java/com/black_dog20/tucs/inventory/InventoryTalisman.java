package com.black_dog20.tucs.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryTalisman implements IInventory
{
    /** A list of one item containing the result of the crafting formula */
    private ItemStack[] stackResult = new ItemStack[1];
    private static final String __OBFID = "CL_00001760";

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return 1;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int i)
    {
        return this.stackResult[i];
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return "Result";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int slot, int number)
    {
        if (this.stackResult[slot] != null)
        {
            ItemStack itemstack = this.stackResult[slot];
            this.stackResult[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.stackResult[i] != null)
        {
            ItemStack itemstack = this.stackResult[i];
            this.stackResult[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int i, ItemStack stack)
    {
        this.stackResult[i] = stack;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void markDirty() {}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return true;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }
}