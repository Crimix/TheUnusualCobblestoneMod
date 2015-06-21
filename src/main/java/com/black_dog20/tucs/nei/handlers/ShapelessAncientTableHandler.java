package com.black_dog20.tucs.nei.handlers;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;

import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.crafting.AncientTableShapelessRecipes;
import com.black_dog20.tucs.reference.Reference;

public class ShapelessAncientTableHandler extends ShapedAncientTableHandler
{
    public int[][] stackorder = new int[][]{
            {0, 0},
            {1, 0},
            {0, 1},
            {1, 1},
            {0, 2},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2}};

    public class CachedShapelessAncientTableRecipe extends CachedRecipe
    {
        public CachedShapelessAncientTableRecipe() {
            ingredients = new ArrayList<PositionedStack>();
        }

        public CachedShapelessAncientTableRecipe(ItemStack output) {
            this();
            setResult(output);
        }

        public CachedShapelessAncientTableRecipe(Object[] input, ItemStack output) {
            this(Arrays.asList(input), output);
        }

        public CachedShapelessAncientTableRecipe(List<?> input, ItemStack output) {
            this(output);
            setIngredients(input);
        }

        public void setIngredients(List<?> items) {
            ingredients.clear();
            for (int ingred = 0; ingred < items.size(); ingred++) {
                PositionedStack stack = new PositionedStack(items.get(ingred), 25 + stackorder[ingred][0] * 18, 6 + stackorder[ingred][1] * 18);
                stack.setMaxSize(1);
                ingredients.add(stack);
            }
        }

        public void setResult(ItemStack output) {
            result = new PositionedStack(output, 119, 24);
        }

        @Override
        public List<PositionedStack> getIngredients() {
            return getCycledIngredients(cycleticks / 20, ingredients);
        }

        @Override
        public PositionedStack getResult() {
            return result;
        }

        public ArrayList<PositionedStack> ingredients;
        public PositionedStack result;
    }

    public String getRecipeName() {
        return NEIClientUtils.translate("recipe.shapeless");
    }
    @Override
	public String getOverlayIdentifier() {
	    return Reference.MOD_ID+"AncientTable";
	}
    
    @Override
    public Class<? extends GuiContainer> getGuiClass() {
        return GuiAncientTable.class;
    }
    
    @Override
    public void loadTransferRects() {
        transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), Reference.MOD_ID+"AncientTable"));
    }

    @Override
    public void loadCraftingRecipes(String outputId, Object... results) {
        if (outputId.equals(Reference.MOD_ID+"AncientTable") && getClass() == ShapelessAncientTableHandler.class) {
            List<IRecipe> allrecipes = AncientTableManager.getInstance().getRecipeList();
            for (IRecipe irecipe : allrecipes) {
            	CachedShapelessAncientTableRecipe recipe = null;
                if (irecipe instanceof AncientTableShapelessRecipes)
                    recipe = shapelessRecipe((AncientTableShapelessRecipes) irecipe);

                if (recipe == null)
                    continue;

                arecipes.add(recipe);
            }
        } else {
            super.loadCraftingRecipes(outputId, results);
        }
    }

    @Override
    public void loadCraftingRecipes(ItemStack result) {
        List<IRecipe> allrecipes = CraftingManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
            if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
            	CachedShapelessAncientTableRecipe recipe = null;
                if (irecipe instanceof AncientTableShapelessRecipes)
                    recipe = shapelessRecipe((AncientTableShapelessRecipes) irecipe);

                if (recipe == null)
                    continue;

                arecipes.add(recipe);
            }
        }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient) {
        List<IRecipe> allrecipes = AncientTableManager.getInstance().getRecipeList();
        for (IRecipe irecipe : allrecipes) {
        	CachedShapelessAncientTableRecipe recipe = null;
            if (irecipe instanceof AncientTableShapelessRecipes)
                recipe = shapelessRecipe((AncientTableShapelessRecipes) irecipe);
            if (recipe == null)
                continue;
            if(recipe != null){
            	if (recipe.contains(recipe.ingredients, ingredient)) {
                	recipe.setIngredientPermutation(recipe.ingredients, ingredient);
                	arecipes.add(recipe);
            	}
            }
        }
    }

    private CachedShapelessAncientTableRecipe shapelessRecipe(AncientTableShapelessRecipes recipe) {
        if(recipe.recipeItems == null)
            return null;

        return new CachedShapelessAncientTableRecipe(recipe.recipeItems, recipe.getRecipeOutput());
    }


    public boolean isRecipe2x2(int recipe) {
        return getIngredientStacks(recipe).size() <= 4;
    }
}