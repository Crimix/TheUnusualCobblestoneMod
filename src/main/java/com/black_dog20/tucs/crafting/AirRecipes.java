package com.black_dog20.tucs.crafting;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemChestplateCobblestonedium_scuba;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class AirRecipes implements IRecipe{
	private final ItemStack[] input;
	private ItemStack output;

	public AirRecipes(ItemStack genericOutput, ItemStack... inputs) {
		this.input = inputs;
		this.output = genericOutput;
	}
	
	@Override
	public boolean matches(InventoryCrafting crafting, World world) {
		boolean chest = false;
		boolean tank = false;
		int numberOfItems = 0;
		for (int i = 0; i < crafting.getSizeInventory(); i++) {
			if (crafting.getStackInSlot(i) != null) {
				if (crafting.getStackInSlot(i).getItem() == ModItems.chestplateCobblestonedium && !chest) {
					chest = true;
				}
				else if (crafting.getStackInSlot(i).getItem() == ModItems.AirTank && !tank) {
					tank = true;
				}
				numberOfItems++;
				
			}
		}
		return(chest && tank && numberOfItems==2);
	}
	
	public ItemStack[] getInput(){
		return input;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting crafting) {
		boolean chest = false;
		boolean tank = false;
		int chestSlot = 0, tankSlot = 0;
		for (int i = 0; i < crafting.getSizeInventory(); i++) {
			if (crafting.getStackInSlot(i) != null) {
				if (crafting.getStackInSlot(i).getItem() == ModItems.chestplateCobblestonedium && !chest) {
					chest = true;
					chestSlot=i;
				}
				else if (crafting.getStackInSlot(i).getItem() == ModItems.AirTank && !tank) {
					tank = true;
					tankSlot=i;
				}
			}
		}
		if(chest && tank){
			ItemStack chestplate = crafting.getStackInSlot(chestSlot).copy();
			ItemStack airtank = crafting.getStackInSlot(tankSlot).copy();
			
			ItemStack ScubaChestTank = new ItemStack(ModItems.chestplateCobblestonedium_scuba);
			if(chestplate.hasTagCompound()){
				ScubaChestTank.setTagCompound(chestplate.getTagCompound());
			}
			ItemStack chestTank = ScubaChestTank.copy();
			ItemChestplateCobblestonedium_scuba item = (ItemChestplateCobblestonedium_scuba) chestTank.getItem();
			item.setAir(chestTank, 0);
			item.setAir(chestTank, item.getAir(airtank));
			return chestTank;
		}
		
		return null;
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return output;
	}

}
