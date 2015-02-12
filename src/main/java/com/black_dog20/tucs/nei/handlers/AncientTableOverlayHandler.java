package com.black_dog20.tucs.nei.handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.black_dog20.tucs.block.BlockAncientTable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import codechicken.nei.ClientHandler;
import codechicken.nei.FastTransferManager;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.OffsetPositioner;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.guihook.GuiContainerManager;
import codechicken.nei.recipe.DefaultOverlayHandler.DistributedIngred;
import codechicken.nei.recipe.DefaultOverlayHandler.IngredientDistribution;
import codechicken.nei.recipe.IRecipeHandler;

public class AncientTableOverlayHandler implements IOverlayHandler{
    private boolean invert;
    private String command;
    private int xOffs, yOffs;
    private Class<? extends Slot> craftingSlot;

    public AncientTableOverlayHandler(String command, int xOffs, int yOffs, boolean invert, Class<? extends Slot> craftingSlot) {
        super();
        this.command = command;
        this.xOffs = xOffs;
        this.yOffs = yOffs;
        this.craftingSlot = craftingSlot;
        this.invert = invert;
    }

    private Slot findMatchingSlot(GuiContainer cont, PositionedStack pstack) {
        for (Object slotob : cont.inventorySlots.inventorySlots) {
            Slot slot = (Slot) slotob;
            if ((slot.xDisplayPosition == pstack.relx + xOffs) && (slot.yDisplayPosition == pstack.rely + yOffs)) {
                return slot;
            }
        }
        return null;
    }

    private Boolean isValidSlot(Slot slot) {
        // Don't try to take items from special slots
        return (slot.inventory == Minecraft.getMinecraft().thePlayer.inventory) || (slot.getClass() == Slot.class);
    }

    private Slot findItem(GuiContainer cont, PositionedStack p) {
        for (ItemStack teststack : p.items) {
            for (Object slotob : cont.inventorySlots.inventorySlots) {
                Slot slot = (Slot) slotob;
                if (isValidSlot(slot)) {
                    ItemStack stack = slot.getStack();
                    if (stack != null && stack.areItemStacksEqual(stack, teststack)) {
                        return slot;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void overlayRecipe(GuiContainer cont, IRecipeHandler recipe, int recipeIndex, boolean shift) {
        List<PositionedStack> ingr = recipe.getIngredientStacks(recipeIndex);

        if (invert) {
            shift = !shift;
        }

        if (!shift) {
            IStackPositioner positioner = new OffsetPositioner(xOffs, yOffs);
            LayoutManager.overlayRenderer = new DefaultOverlayRenderer(ingr, positioner);

        } else {
            if (NEIClientUtils.getHeldItem() != null) {
                return;
            }
            GuiContainerManager manager = GuiContainerManager.getManager(cont);
            for (Object slotob : cont.inventorySlots.inventorySlots) {
                if (craftingSlot.isInstance(slotob)) {
                    Slot slot = (Slot) slotob;
                    // Left click once to clear
                    manager.handleSlotClick(slot.slotNumber, 0, 0);
                }
            }
            for (PositionedStack pstack : ingr) {
                if (pstack != null) {

                    Slot slotTo = findMatchingSlot(cont, pstack);
                    if (slotTo == null)
                        continue;

                    Slot slotFrom = findItem(cont, pstack);
                    if (slotFrom == null)
                        continue;

                    // pick up item
                    manager.handleSlotClick(slotFrom.slotNumber, 0, 0);
                    // right click to add 1
                    manager.handleSlotClick(slotTo.slotNumber, 1, 0);
                    // put item back
                    manager.handleSlotClick(slotFrom.slotNumber, 0, 0);
                }
            }
        }
    }
}