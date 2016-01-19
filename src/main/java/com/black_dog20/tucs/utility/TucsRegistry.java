package com.black_dog20.tucs.utility;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.crafting.AncientTableManager;

import cpw.mods.fml.common.registry.GameRegistry;

public class TucsRegistry {

	public static int number = 0;

	public static void addRecipe(ItemStack output, Object... params) {
		addShapedRecipe(output, params);
	}

	public static IRecipe addShapedRecipe(ItemStack output, Object... params) {
		return AncientTableManager.getInstance().addRecipe(output, params);
	}

	public static void addShapelessRecipe(ItemStack output, Object... params) {
		AncientTableManager.getInstance().addShapelessRecipe(output, params);
	}

	/*
	 * @SuppressWarnings("unchecked") public static void addRecipe(IRecipe
	 * recipe) { AncientTableManager.getInstance().getRecipeList().add(recipe);
	 * }
	 */

	public static void RemoveRecipe(Item item) {
		AncientTableManager.getInstance().RemoveRecipe(item);
		number++;
	}

	public static void registerItem(Item item, String name) {
		tucs.overlayList.add(item);
		GameRegistry.registerItem(item, name);
	}
}
