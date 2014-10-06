package com.black_dog20.tucs.container;

import com.black_dog20.tucs.crafting.AncientForgeRecipes;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerDummy extends Container
{


    public ContainerDummy(InventoryPlayer IPlayer, TileEntityAncientForge tileForge)
    {
        
    }

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {

		return false;
	}
}