package com.black_dog20.tucs.container;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.inventory.InventoryUpgradeTools;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.slot.SlotUpgradeTools;

import net.minecraft.enchantment.Enchantment;
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

public class ContainerUpgradeTools extends Container {
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private EntityPlayer Player;
	public IInventory slotUpgrade = new InventoryUpgradeTools();
	private static final int INV_START = 3, INV_END = INV_START+3,
			HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;



	public ContainerUpgradeTools(World world, int x, int y, int z, EntityPlayer player, ItemStack item)
	{
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.Player = player;


		for(int i = 0; i < 3; i++){
			this.addSlotToContainer(new SlotUpgradeTools(this.slotUpgrade, i, 58 +(i*18), 38));
		}

		if(!item.hasTagCompound()){
			item.stackTagCompound = new NBTTagCompound();
		}
		if(item.hasTagCompound()){
			item.stackTagCompound.removeTag("ench");
			item.stackTagCompound.removeTag(NBTTags.SOULBOUND);
			item.hasEffect(0);
			NBTTagCompound nbt = item.getTagCompound();

			NBTTagList nbttaglist = nbt.getTagList("upgradeItems", Constants.NBT.TAG_COMPOUND);
			for(int i = 0; i <= nbttaglist.tagCount(); i++){
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int b0 = nbttagcompound1.getInteger("Slot");
				ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
				if(slotItem !=null){
					slotUpgrade.setInventorySlotContents(b0, slotItem);

				}
				nbt.removeTag("upgradeItems");
			}
		}

		bindPlayerInventory(Player.inventory);


	}

	protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 3; ++i){
			for (int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slot) {
		Slot slotObject = (Slot) inventorySlots.get(slot);
		if(slotObject != null && slotObject.getHasStack()) {
			ItemStack stackInSlot = slotObject.getStack();
			ItemStack stack = stackInSlot.copy();
			if(slot <= 3) {
				if(!mergeItemStack(stackInSlot, 2, inventorySlots.size(), true))
					return null;
			}
			else if(slot != 1 && checkItem(stack) && !getSlot(0).getHasStack()) {
				ItemStack copy = slotObject.decrStackSize(1);
				getSlot(0).putStack(copy);
				return null;
			} 
			else {
				return null;
			}

			if(stackInSlot.stackSize == 0)
				slotObject.putStack(null);
			else
				slotObject.onSlotChanged();

			return stack;
		}
		return null;
	}

	@Override
	public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
		// this will prevent the player from interacting with the item that opened the inventory:
			if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
				return null;
			}
			return super.slotClick(slot, button, flag, player);
	}


	@Override
	public boolean canInteractWith(EntityPlayer player){
		if(player.getHeldItem() != null){
			if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOC))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLBOTB))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLHOWF))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLPOLM))){
				return true;
			}
			else if(player.getHeldItem().isItemEqual(new ItemStack(ModItems.TLSOHD))){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		ItemStack tool = player.getHeldItem();
		if(tool != null && !tool.hasTagCompound()){
			tool.stackTagCompound = new NBTTagCompound();
		}

		NBTTagCompound NBT = tool.getTagCompound();
		NBTTagList nbttaglist = new NBTTagList();

		super.onContainerClosed(player);
		for(int i = 0; i < 3; i++){
			ItemStack upgrade = this.slotUpgrade.getStackInSlot(i);
			if(upgrade != null && checkItem(upgrade)){
				if(tool != null && tool.hasTagCompound()){
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setInteger("Slot", i);
					upgrade.writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);

					setEnchant(tool, upgrade, NBT);

				}
			}
			else{
				if(upgrade != null){
					player.dropPlayerItemWithRandomChoice(upgrade, false);
				}
			}
		}
		NBT.setTag("upgradeItems", nbttaglist);
	}


	void setEnchant(ItemStack ContainerItem, ItemStack UpgradeItem, NBTTagCompound NBT){
		if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.soulboundUpgrade,1))){
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
			ContainerItem.hasEffect(1);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting1Upgrade,1))){
			ContainerItem.addEnchantment(Enchantment.looting, 1);
			ContainerItem.hasEffect(1);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting2Upgrade,1))){
			ContainerItem.addEnchantment(Enchantment.looting, 2);
			ContainerItem.hasEffect(1);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting3Upgrade,1))){
			ContainerItem.addEnchantment(Enchantment.looting, 3);
			ContainerItem.hasEffect(1);
		}
	}

	boolean checkItem(ItemStack UpgradeItem){
		if(UpgradeItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.soulboundUpgrade,1))){
			return true;
		}
		else if(UpgradeItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting1Upgrade,1))){
			return true;
		}
		else if(UpgradeItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting2Upgrade,1))){
			return true;
		}
		else if(UpgradeItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting3Upgrade,1))){
			return true;
		}
		else{
			return false;
		}
	}


}
