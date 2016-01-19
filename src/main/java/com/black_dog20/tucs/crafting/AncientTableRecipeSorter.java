package com.black_dog20.tucs.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AncientTableRecipeSorter implements Comparator {

	final AncientTableManager AncientTable;

	public AncientTableRecipeSorter(AncientTableManager AncientTableManager) {
		this.AncientTable = AncientTableManager;
	}

	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof AncientTableShapelessRecipes
				&& irecipe2 instanceof AncientTableShapedRecipes ? 1
				: (irecipe2 instanceof AncientTableShapelessRecipes
						&& irecipe1 instanceof AncientTableShapedRecipes ? -1
						: (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1
								: (irecipe2.getRecipeSize() > irecipe1
										.getRecipeSize() ? 1 : 0)));
	}

	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe) o1, (IRecipe) o2);
	}

}
