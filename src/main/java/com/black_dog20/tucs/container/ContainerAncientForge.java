package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.crafting.AncientForgeRecipes;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAncientForge extends Container {
	private TileEntityAncientForge tileFurnace;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public ContainerAncientForge(InventoryPlayer IPlayer, TileEntityAncientForge tileForge) {
		this.tileFurnace = tileForge;
		this.addSlotToContainer(new Slot(tileForge, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileForge, 1, 56, 53));
		this.addSlotToContainer(new SlotFurnace(IPlayer.player, tileForge, 2, 116, 35));
		int i;

		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(IPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(IPlayer, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting ICraft) {
		super.addCraftingToCrafters(ICraft);
		ICraft.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
		ICraft.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
		ICraft.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); ++i) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);

			if (this.lastCookTime != this.tileFurnace.furnaceCookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.tileFurnace.furnaceCookTime);
			}

			if (this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
			}

			if (this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
			}
		}

		this.lastCookTime = this.tileFurnace.furnaceCookTime;
		this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
		this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1, int par2) {
		if (par1 == 0) {
			this.tileFurnace.furnaceCookTime = par2;
		}

		if (par1 == 1) {
			this.tileFurnace.furnaceBurnTime = par2;
		}

		if (par1 == 2) {
			this.tileFurnace.currentItemBurnTime = par2;
		}
	}

	public boolean canInteractWith(EntityPlayer player) {
		return this.tileFurnace.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int par1) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par1);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par1 == 2) {
				if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (par1 != 1 && par1 != 0) {
				if (AncientForgeRecipes.smelting().getSmeltingResult(itemstack1) != null) {
					if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
						return null;
					}
				} else if (TileEntityAncientForge.isItemFuel(itemstack1)) {
					if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
						return null;
					}
				} else if (par1 >= 3 && par1 < 30) {
					if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
						return null;
					}
				} else if (par1 >= 30 && par1 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
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

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}
}