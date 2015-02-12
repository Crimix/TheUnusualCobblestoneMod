package com.black_dog20.tucs.nei.handlers;

import java.util.List;

import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.crafting.AncientTableShapedRecipes;
import com.black_dog20.tucs.reference.Reference;

import codechicken.core.ReflectionManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.DefaultOverlayRenderer;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.api.IStackPositioner;
import codechicken.nei.recipe.ShapedRecipeHandler;
import codechicken.nei.recipe.ShapedRecipeHandler.CachedShapedRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class ShapedAncientTableHandler extends TemplateRecipeHandler {
	
	
	public class CachedShapedAncientTableRecipe extends CachedRecipe
    {
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

        /**
         * @param width
         * @param height
         * @param items  an ItemStack[] or ItemStack[][]
         */
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
	public String getRecipeName() {
		return "Ancient Table";
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
	    return Reference.MOD_ID+"AncientTable";
	}
	
	 @Override
	 public void loadCraftingRecipes(String outputId, Object... results) {
			 if (outputId.equals("ancient table") && getClass() == ShapedAncientTableHandler.class) {
				for (IRecipe irecipe : (List<IRecipe>) AncientTableManager.getInstance().getRecipeList()) {
	            	CachedShapedAncientTableRecipe recipe = null;
	                if (irecipe instanceof AncientTableShapedRecipes)
	                    recipe = new CachedShapedAncientTableRecipe((AncientTableShapedRecipes) irecipe);


	                if (recipe == null)
	                    continue;

	                recipe.computeVisuals();
	                if(!recipe.result.item.areItemStacksEqual(recipe.result.item, new ItemStack(Items.emerald,2))){
	               		arecipes.add(recipe);
	               	}
	            }
			 } else {
	            super.loadCraftingRecipes(outputId, results);
			 }
	 }
	 
	    @Override
	    public void loadCraftingRecipes(ItemStack result) {
	    	for (IRecipe irecipe : (List<IRecipe>) AncientTableManager.getInstance().getRecipeList()) {
	        	if (NEIServerUtils.areStacksSameTypeCrafting(irecipe.getRecipeOutput(), result)) {
	           		CachedShapedAncientTableRecipe recipe = null;
	               	if (irecipe instanceof AncientTableShapedRecipes)
	                   	recipe = new CachedShapedAncientTableRecipe((AncientTableShapedRecipes) irecipe);

	               	if (recipe == null)
	                   	continue;

	               	recipe.computeVisuals();
	               	if(!recipe.result.item.areItemStacksEqual(recipe.result.item, new ItemStack(Items.emerald,2))){
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
	            if(recipe != null){
	            	recipe.computeVisuals();
	            	if (recipe.contains(recipe.ingredients, ingredient)) {
	            		recipe.setIngredientPermutation(recipe.ingredients, ingredient);
	            		if(!recipe.result.item.areItemStacksEqual(recipe.result.item, new ItemStack(Items.emerald,2))){
		               		arecipes.add(recipe);
		               	}
	            	}
	            }
	        }
	    }

}