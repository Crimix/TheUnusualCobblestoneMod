package com.black_dog20.tucs.utility;

import com.black_dog20.tucs.crafting.AncientTableManager;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class TucsRegistry {

	 public static void addRecipe(ItemStack output, Object... params)
	    {
	        addShapedRecipe(output, params);
	    }

	    public static IRecipe addShapedRecipe(ItemStack output, Object... params)
	    {
	        return AncientTableManager.getInstance().addRecipe(output, params);
	    }

	    public static void addShapelessRecipe(ItemStack output, Object... params)
	    {
	    	AncientTableManager.getInstance().addShapelessRecipe(output, params);
	    }

	    @SuppressWarnings("unchecked")
	    public static void addRecipe(IRecipe recipe)
	    {
	    	AncientTableManager.getInstance().getRecipeList().add(recipe);
	    }
}
