package com.black_dog20.tucs.container;

import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.PageTypes;
import com.black_dog20.tucs.utility.LogHelper;
import com.black_dog20.tucs.utility.NBTHelper;
import com.black_dog20.tucs.utility.PageHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ContainerAncientTable extends Container {
	 /** The crafting matrix inventory (3x3). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    public ItemStack Result;
    private World worldObj;
    private int posX;
    private int posY;
    private int posZ;
    private EntityPlayer EPlayer;
    private NBTTagCompound nbt;
    private String test;

    public ContainerAncientTable(InventoryPlayer IPlayer, World world, int x, int y, int z, EntityPlayer eplayer)
    {
        this.worldObj = world;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.EPlayer = eplayer;
        this.nbt = NBTHelper.getPlayerNBT(EPlayer);
       
        
        
        
        this.addSlotToContainer(new SlotCrafting(IPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        int l;
        int i1;

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 3; ++i1)
            {
                this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
            }
        }

        for (l = 0; l < 3; ++l)
        {
            for (i1 = 0; i1 < 9; ++i1)
            {
                this.addSlotToContainer(new Slot(IPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
            }
        }

        for (l = 0; l < 9; ++l)
        {
            this.addSlotToContainer(new Slot(IPlayer, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventory)
    {
    	Result = AncientTableManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
    	if(Result == null){
    		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    	}
    	else{
    			this.craftResult.setInventorySlotContents(0, Result);
    			
    	}		
    	
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

    public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_)
    {
        return p_94530_2_.inventory != this.craftResult && super.func_94530_a(p_94530_1_, p_94530_2_);
    }

}
