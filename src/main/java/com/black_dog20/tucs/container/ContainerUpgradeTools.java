package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import com.black_dog20.tucs.inventory.InventoryUpgradeTools;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotUpgradeTools;
import com.black_dog20.tucs.utility.EnchantHelper;

public class ContainerUpgradeTools extends Container {
	private EntityPlayer Player;
	public IInventory slotUpgrade = new InventoryUpgradeTools();

	public ContainerUpgradeTools(World world, int x, int y, int z, EntityPlayer player, ItemStack item) {
		this.Player = player;

		for (int i = 0; i < 3; i++) {
			this.addSlotToContainer(new SlotUpgradeTools(this.slotUpgrade, i, 58 + (i * 18), 38));
		}

		if (!item.hasTagCompound()) {
			item.stackTagCompound = new NBTTagCompound();
		}
		if (item.hasTagCompound()) {
			item.stackTagCompound.removeTag("ench");
			item.stackTagCompound.removeTag(NBTTags.SOULBOUND);
			item.stackTagCompound.removeTag(NBTTags.Beheading);
			item.stackTagCompound.removeTag(NBTTags.NoArrow);
			item.stackTagCompound.removeTag(NBTTags.MachineBow);
			NBTTagCompound nbt = item.getTagCompound();

			NBTTagList nbttaglist = nbt.getTagList("upgradeItems", Constants.NBT.TAG_COMPOUND);
			for (int i = 0; i <= nbttaglist.tagCount(); i++) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int b0 = nbttagcompound1.getInteger("Slot");
				ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
				if (slotItem != null) {
					slotUpgrade.setInventorySlotContents(b0, slotItem);

				}
				nbt.removeTag("upgradeItems");
			}
		}

		bindPlayerInventory(Player.inventory);

	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if (slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			ItemStack stack = stackInSlot.copy();
			if (slot <= 1) {
				if (!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
					return null;
			} else if (slot != 1 && EnchantHelper.checkItem(stack) && !getSlot(0).getHasStack()) {
				ItemStack copy = slotObject.decrStackSize(1);
				getSlot(0).putStack(copy);
				return null;
			} else if (slot != 2 && EnchantHelper.checkItem(stack) && !getSlot(1).getHasStack()) {
				ItemStack copy = slotObject.decrStackSize(1);
				getSlot(1).putStack(copy);
				return null;
			} else if (slot != 3 && EnchantHelper.checkItem(stack) && !getSlot(2).getHasStack()) {
				ItemStack copy = slotObject.decrStackSize(1);
				getSlot(2).putStack(copy);
				return null;
			} else {
				return null;
			}

			if (stackInSlot.stackSize == 0)
				slotObject.putStack(null);
			else
				slotObject.onSlotChanged();

			return stack;
		}
		return null;
	}

	@Override public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
		// this will prevent the player from interacting with the item that
		// opened the inventory:
		if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
			return null;
		}
		return super.slotClick(slot, button, flag, player);
	}

	@Override public boolean canInteractWith(EntityPlayer player) {
		if (player.getHeldItem() != null) {
			return true;
		}
		return false;
	}

	@Override public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		ItemStack tool = player.getHeldItem();
		if (tool != null && !tool.hasTagCompound()) {
			tool.stackTagCompound = new NBTTagCompound();
		}

		if (tool.hasTagCompound()) {
			NBTTagCompound NBT = tool.getTagCompound();

			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < 3; i++) {
				ItemStack upgrade = this.slotUpgrade.getStackInSlot(i);
				if (upgrade != null && EnchantHelper.checkItem(upgrade)) {
					if (tool != null && tool.hasTagCompound()) {
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						nbttagcompound1.setInteger("Slot", i);
						upgrade.writeToNBT(nbttagcompound1);
						nbttaglist.appendTag(nbttagcompound1);

						EnchantHelper.setEnchant(tool, upgrade, NBT);

					}
				} else {
					if (upgrade != null) {
						player.dropPlayerItemWithRandomChoice(upgrade, false);
					}
				}
			}
			NBT.setTag("upgradeItems", nbttaglist);
		}
	}

}
