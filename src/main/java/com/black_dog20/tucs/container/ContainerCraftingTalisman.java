package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.init.ModItems;

public class ContainerCraftingTalisman extends Container {
	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	public ItemStack Result;
	private World worldObj;

	public ContainerCraftingTalisman(InventoryPlayer IPlayer, World world, int x, int y, int z, EntityPlayer eplayer) {
		this.worldObj = world;

		this.addSlotToContainer(new SlotCrafting(IPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
		int l;
		int i1;

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 3; ++i1) {
				this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
			}
		}

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(IPlayer, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
			}
		}

		for (l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(IPlayer, l, 8 + l * 18, 142));
		}

		this.onCraftMatrixChanged(this.craftMatrix);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void onCraftMatrixChanged(IInventory inventory) {
		Result = AncientTableManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
		if (Result == null) {
			this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
		} else {
			this.craftResult.setInventorySlotContents(0, Result);

		}

	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer EPlayer) {
		super.onContainerClosed(EPlayer);
		if (!worldObj.isRemote) {
			for (int i = 0; i < 9; ++i) {
				ItemStack itemstack = craftMatrix.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					EPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (player.getHeldItem() != null) {
			boolean test = player.getHeldItem().isItemEqual(new ItemStack(ModItems.craftingTalisman));

			return test;
		} else {
			player.closeScreen();
			return false;
		}
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer EPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (par2 >= 10 && par2 < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (par2 >= 37 && par2 < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(EPlayer, itemstack1);
		}

		return itemstack;
	}

	public boolean func_94530_a(ItemStack p_94530_1_, Slot p_94530_2_) {
		return p_94530_2_.inventory != this.craftResult && super.func_94530_a(p_94530_1_, p_94530_2_);
	}

}
