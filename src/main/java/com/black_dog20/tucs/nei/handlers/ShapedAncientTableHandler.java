package com.black_dog20.tucs.nei.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.ShapedRecipeHandler.CachedShapedRecipe;

import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.crafting.AirRecipes;
import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.crafting.AncientTableShapedRecipes;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.tool.ItemTLSOTD;
import com.black_dog20.tucs.reference.Reference;

public class ShapedAncientTableHandler extends TemplateRecipeHandler {

	public class CachedShapedAncientTableRecipe extends CachedRecipe {
		public ArrayList<PositionedStack> ingredients;
		public PositionedStack result;

		public CachedShapedAncientTableRecipe(int width, int height, Object[] items, ItemStack out) {
			result = new PositionedStack(out, 119, 24);
			ingredients = new ArrayList<PositionedStack>();
			setIngredients(width, height, items);
		}

		public CachedShapedAncientTableRecipe(AncientTableShapedRecipes recipe) {
			this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.getRecipeOutput());
		}

		public void setIngredients(int width, int height, Object[] items) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (items[y * width + x] == null)
						continue;

					PositionedStack stack = new PositionedStack(items[y * width + x], 25 + x * 18, 6 + y * 18, false);
					stack.setMaxSize(1);
					ingredients.add(stack);
				}
			}
		}

		@Override
		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 20, ingredients);
		}

		public PositionedStack getResult() {
			return result;
		}

		public void computeVisuals() {
			for (PositionedStack p : ingredients)
				p.generatePermutations();
		}
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), Reference.MOD_ID + "AncientTable"));
	}

	@Override
	public String getRecipeName() {
		return "Ancient Table";
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return GuiAncientTable.class;
	}

	@Override
	public String getGuiTexture() {
		return "minecraft:textures/gui/container/crafting_table.png";
	}

	@Override
	public int recipiesPerPage() {
		return 2;
	}

	@Override
	public String getOverlayIdentifier() {
		return Reference.MOD_ID + "AncientTable";
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals(Reference.MOD_ID + "AncientTable") && getClass() == ShapedAncientTableHandler.class) {
			for (IRecipe irecipe : (List<IRecipe>) AncientTableManager.getInstance().getRecipeList()) {
				CachedShapedAncientTableRecipe recipe = null;
				if (irecipe instanceof AncientTableShapedRecipes)
					recipe = new CachedShapedAncientTableRecipe((AncientTableShapedRecipes) irecipe);
				else if (irecipe instanceof ShapedOreRecipe)
                    recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);
	            else if (irecipe instanceof AirRecipes)
	                recipe = AirRecipe((AirRecipes) irecipe);

				if (recipe == null)
					continue;

				recipe.computeVisuals();
				if (AncientTableManager.getInstance().getRecipeList().contains(irecipe) && this.checkRecipe(recipe)) {
					arecipes.add(recipe);
				}
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	private boolean checkRecipe(CachedShapedAncientTableRecipe recipe) {
		boolean result = true;
		if (ItemStack.areItemStacksEqual(recipe.result.item, new ItemStack(Items.emerald, 2)) && checkRecipeForItem(ModItems.cobblestonediumLighter, recipe.ingredients) && checkNameOfUser(Minecraft.getMinecraft().thePlayer)) {
			result = true;
		} else if (ItemStack.areItemStacksEqual(recipe.result.item, new ItemStack(Items.emerald, 2)) && checkRecipeForItem(ModItems.cobblestonediumLighter, recipe.ingredients)) {
			result = false;
		}
		if (recipe.result.item.getItem() instanceof ItemTLSOTD && checkNameOfUser(Minecraft.getMinecraft().thePlayer)) {
			result = true;
		} else if (recipe.result.item.getItem() instanceof ItemTLSOTD) {
			result = false;
		}
		return result;
	}

	private boolean checkNameOfUser(EntityPlayer player) {
		boolean result = false;
		if (player.getDisplayName().toLowerCase().equals("black_dog20")) {

			result = true;
		} else if (player.getDisplayName().toLowerCase().equals("simmebabz")) {
			result = true;
		}
		return result;
	}

	private boolean checkRecipeForItem(Item compareItem, ArrayList<PositionedStack> recipe) {
		for (PositionedStack object : recipe) {
			if (object.item.getItem() == compareItem) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		for (IRecipe irecipe : (List<IRecipe>) AncientTableManager.getInstance().getRecipeList()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
				CachedShapedAncientTableRecipe recipe = null;
				if (irecipe instanceof AncientTableShapedRecipes)
					recipe = new CachedShapedAncientTableRecipe((AncientTableShapedRecipes) irecipe);
                else if (irecipe instanceof ShapedOreRecipe)
                    recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);
                else if (irecipe instanceof AirRecipes)
                    recipe = AirRecipe((AirRecipes) irecipe);

				if (recipe == null)
					continue;

				recipe.computeVisuals();
				if (AncientTableManager.getInstance().getRecipeList().contains(irecipe) && checkRecipe(recipe)) {
					arecipes.add(recipe);
				}
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		for (IRecipe irecipe : (List<IRecipe>) AncientTableManager.getInstance().getRecipeList()) {
			CachedShapedAncientTableRecipe recipe = null;
			if (irecipe instanceof AncientTableShapedRecipes)
				recipe = new CachedShapedAncientTableRecipe((AncientTableShapedRecipes) irecipe);
            else if (irecipe instanceof ShapedOreRecipe)
                recipe = forgeShapedRecipe((ShapedOreRecipe) irecipe);
            else if (irecipe instanceof AirRecipes)
                recipe = AirRecipe((AirRecipes) irecipe);
			if (recipe != null) {
				recipe.computeVisuals();
				if (recipe.contains(recipe.ingredients, ingredient)) {
					recipe.setIngredientPermutation(recipe.ingredients, ingredient);
					if (AncientTableManager.getInstance().getRecipeList().contains(irecipe) && checkRecipe(recipe)) {
						arecipes.add(recipe);
					}
				}
			}
		}
	}
	
	public CachedShapedAncientTableRecipe forgeShapedRecipe(ShapedOreRecipe recipe) {
        try {
            int width = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 4);
            int height = ReflectionManager.getField(ShapedOreRecipe.class, Integer.class, recipe, 5);

            Object[] items = recipe.getInput();
            for (Object item : items)
                if (item instanceof List && ((List<?>) item).isEmpty())//ore handler, no ores
                    return null;

            return new CachedShapedAncientTableRecipe(width, height, items, recipe.getRecipeOutput());
        } catch (Exception e) {
            NEIClientConfig.logger.error("Error loading recipe: ", e);
            return null;
        }
    }
	
	public CachedShapedAncientTableRecipe AirRecipe(AirRecipes recipe) {
        try {
            int width = 2;
            int height = 1;

            Object[] items = recipe.getInput();

            return new CachedShapedAncientTableRecipe(width, height, items, recipe.getRecipeOutput());
        } catch (Exception e) {
            NEIClientConfig.logger.error("Error loading recipe: ", e);
            return null;
        }
    }

}