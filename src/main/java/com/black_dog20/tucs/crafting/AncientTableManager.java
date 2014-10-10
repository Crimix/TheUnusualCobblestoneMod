package com.black_dog20.tucs.crafting;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.black_dog20.tucs.container.ContainerAncientTable;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemTUCS;
import com.black_dog20.tucs.utility.PageHelper;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class AncientTableManager
{
	/** The static instance of this class */
	private static final AncientTableManager instance = new AncientTableManager();
	/** A list of all the recipes added */
	private List recipes = new ArrayList();
	private static final String __OBFID = "CL_00000090";

	/**
	 * Returns the static instance of this class
	 */
	public static final AncientTableManager getInstance()
	{
		/** The static instance of this class */
		return instance;
	}

	private AncientTableManager()
	{
		Collections.sort(this.recipes, new AncientTableRecipeSorter(this));
	}



	public AncientTableShapedRecipes addRecipe(ItemStack item,  Object ... params)
	{
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (params[i] instanceof String[])
		{
			String[] astring = (String[])((String[])params[i++]);

			for (int l = 0; l < astring.length; ++l)
			{
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		}
		else
		{
			while (params[i] instanceof String)
			{
				String s2 = (String)params[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < params.length; i += 2)
		{
			Character character = (Character)params[i];
			ItemStack itemstack1 = null;

			if (params[i + 1] instanceof Item)
			{
				itemstack1 = new ItemStack((Item)params[i + 1]);
			}
			else if (params[i + 1] instanceof Block)
			{
				itemstack1 = new ItemStack((Block)params[i + 1], 1, 32767);
			}
			else if (params[i + 1] instanceof ItemStack)
			{
				itemstack1 = (ItemStack)params[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1)
		{
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0)))
			{
				aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
			}
			else
			{
				aitemstack[i1] = null;
			}
		}

		AncientTableShapedRecipes shapedrecipes = new AncientTableShapedRecipes(j, k, aitemstack, item);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack item, Object ... params)
	{
		ArrayList arraylist = new ArrayList();
		Object[] aobject = params;
		int i = params.length;

		for (int j = 0; j < i; ++j)
		{
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack)
			{
				arraylist.add(((ItemStack)object1).copy());
			}
			else if (object1 instanceof Item)
			{
				arraylist.add(new ItemStack((Item)object1));
			}
			else
			{
				if (!(object1 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				arraylist.add(new ItemStack((Block)object1));
			}
		}

		this.recipes.add(new AncientTableShapelessRecipes(item, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting invC, World world)
	{
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < invC.getSizeInventory(); ++j)
		{
			ItemStack itemstack2 = invC.getStackInSlot(j);

			if (itemstack2 != null)
			{
				if (i == 0)
				{
					itemstack = itemstack2;
				}

				if (i == 1)
				{
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
		{
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0)
			{
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		}
		else
		{
			for (j = 0; j < this.recipes.size(); ++j)
			{
				IRecipe irecipe = (IRecipe)this.recipes.get(j);

				if (irecipe.matches(invC, world))
				{
					return irecipe.getCraftingResult(invC);
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList()
	{
		return this.recipes;
	}

}
