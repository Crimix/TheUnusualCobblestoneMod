package com.black_dog20.tucs.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.black_dog20.tucs.block.BlockAncientForge;
import com.black_dog20.tucs.crafting.AncientForgeRecipes;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.utility.OreHelp;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityAncientForge extends TileEntity implements ISidedInventory
{
	private static final int[] slotsTop = new int[] {0};
	private static final int[] slotsBottom = new int[] {2, 1};
	private static final int[] slotsSides = new int[] {1};
	private static boolean isOre2x = true;
	private static boolean oredic = true;
	private static ItemStack itemstackResult;
	private ItemStack[] furnaceItemStacks = new ItemStack[3];
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;
	private String display;

	public int getSizeInventory()
	{
		return this.furnaceItemStacks.length;
	}

	public ItemStack getStackInSlot(int par1)
	{
		return this.furnaceItemStacks[par1];
	}

	public ItemStack decrStackSize(int slot, int number)
	{
		if (this.furnaceItemStacks[slot] != null)
		{
			ItemStack itemstack;

			if (this.furnaceItemStacks[slot].stackSize <= number)
			{
				itemstack = this.furnaceItemStacks[slot];
				this.furnaceItemStacks[slot] = null;
				return itemstack;
			}
			else
			{
				itemstack = this.furnaceItemStacks[slot].splitStack(number);

				if (this.furnaceItemStacks[slot].stackSize == 0)
				{
					this.furnaceItemStacks[slot] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.furnaceItemStacks[par1] != null)
		{
			ItemStack itemstack = this.furnaceItemStacks[par1];
			this.furnaceItemStacks[par1] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int slot, ItemStack item)
	{
		this.furnaceItemStacks[slot] = item;

		if (item != null && item.stackSize > this.getInventoryStackLimit())
		{
			item.stackSize = this.getInventoryStackLimit();
		}
	}

	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.display : "Ancient Forge";
	}

	public boolean hasCustomInventoryName()
	{
		return this.display != null && this.display.length() > 0;
	}

	public void setDisplayName(String displayName)
	{
		this.display = displayName;
	}

	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.furnaceItemStacks.length)
			{
				this.furnaceItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		this.furnaceBurnTime = nbt.getShort("BurnTime");
		this.furnaceCookTime = nbt.getShort("CookTime");
		this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

		if (nbt.hasKey("CustomName", 8))
		{
			this.display = nbt.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setShort("BurnTime", (short)this.furnaceBurnTime);
		nbt.setShort("CookTime", (short)this.furnaceCookTime);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.furnaceItemStacks.length; ++i)
		{
			if (this.furnaceItemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.furnaceItemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName())
		{
			nbt.setString("CustomName", this.display);
		}
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return this.furnaceCookTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1)
	{
		if (this.currentItemBurnTime == 0)
		{
			this.currentItemBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
	}

	public boolean isBurning()
	{
		return this.furnaceBurnTime > 0;
	}

	public void updateEntity()
	{
		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;

		if (this.furnaceBurnTime > 0)
		{
			--this.furnaceBurnTime;
		}

		if (!this.worldObj.isRemote)
		{
			if (this.furnaceBurnTime != 0 || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null)
			{
				if (this.furnaceBurnTime == 0 && this.canSmelt())
				{
					this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

					if (this.furnaceBurnTime > 0)
					{
						flag1 = true;

						if (this.furnaceItemStacks[1] != null)
						{
							--this.furnaceItemStacks[1].stackSize;

							if (this.furnaceItemStacks[1].stackSize == 0)
							{
								this.furnaceItemStacks[1] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
							}
						}
					}
				}

				if (this.isBurning() && this.canSmelt())
				{
					++this.furnaceCookTime;

					if (this.furnaceCookTime == 200)
					{
						this.furnaceCookTime = 0;
						this.smeltItem();
						flag1 = true;
					}
				}
				else
				{
					this.furnaceCookTime = 0;
				}
			}

			if (flag != this.furnaceBurnTime > 0)
			{
				flag1 = true;
				BlockAncientForge.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1)
		{
			this.markDirty();
		}
	}

	 private boolean canSmelt()
	{
		 if (this.furnaceItemStacks[0] == null)
		 {
			 return false;
		 }
		 else
		 {
			 
			 itemstackResult = AncientForgeRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
				if (itemstackResult == null){
					itemstackResult = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
			 	}
				if (itemstackResult == null){
			 		return false;
			 	}
				 if (this.furnaceItemStacks[2] == null) {
					 return true;
				 }
				 if (!this.furnaceItemStacks[2].isItemEqual(itemstackResult)){
					 return false;
				 }
				 int result = furnaceItemStacks[2].stackSize + itemstackResult.stackSize;
				 return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[2].getMaxStackSize();
			 
		 }
	}

	 public void smeltItem()
	 {
		 if (this.canSmelt())
		 {


			 if (this.furnaceItemStacks[2] == null)
			 {
				 
				oredic = OreHelp.ore(this.furnaceItemStacks[0], itemstackResult);
				 
				 if(isOre2x == true && oredic == true){
					
					 this.furnaceItemStacks[2] = itemstackResult.copy();
					 this.furnaceItemStacks[2].stackSize += itemstackResult.stackSize;
				 }
				 else{
					 this.furnaceItemStacks[2] = itemstackResult.copy();
				 }
			 }

			 else if (this.furnaceItemStacks[2].getItem() == itemstackResult.getItem())
			 {
				 if(isOre2x == true && oredic == true){
					 
					 this.furnaceItemStacks[2].stackSize += itemstackResult.stackSize;
					 this.furnaceItemStacks[2].stackSize += itemstackResult.stackSize;
				 }
				 else{
					 this.furnaceItemStacks[2].stackSize += itemstackResult.stackSize;
				 }
			 }


			 --this.furnaceItemStacks[0].stackSize;

			 if (this.furnaceItemStacks[0].stackSize <= 0)
			 {
				 this.furnaceItemStacks[0] = null;
			 }
		 }
	 }

	 public static int getItemBurnTime(ItemStack itemstack)
	 {
		 if (itemstack == null)
		 {
			 return 0;
		 }
		 else
		 {
			 Item item = itemstack.getItem();
			 if (item == ModItems.CobbleCoal) {
				 return 2600;
			 }
		 }
		return 0;
	 }

	 public static boolean isItemFuel(ItemStack itemstack)
	 {
		 return getItemBurnTime(itemstack) > 0;
	 }

	 public boolean isUseableByPlayer(EntityPlayer player)
	 {
		 return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	 }

	 public void openInventory() {}

	 public void closeInventory() {}

	 public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	 {
		 return slot == 2 ? false : (slot == 1 ? isItemFuel(itemstack) : true);
	 }

	 public int[] getAccessibleSlotsFromSide(int side)
	 {
		 return side == 0 ? slotsBottom : (side == 1 ? slotsTop : slotsSides);
	 }

	 public boolean canInsertItem(int slot, ItemStack itemstack, int side)
	 {
		 return this.isItemValidForSlot(slot, itemstack);
	 }
	 
	 public boolean canExtractItem(int slot, ItemStack itemstack, int side)
	 {
		 return side != 0 || slot != 1 || itemstack.getItem() == Items.bucket;
	 }
}