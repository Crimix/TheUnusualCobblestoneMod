package com.black_dog20.tucs.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class Recipes {
	
	public static void init(){
		//OreDictionary
		OreDictionary.registerOre("ingotCobblestoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("ingotCobblestonedium", new ItemStack(ModItems.ingotCobblestonedium));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneLighter,1,OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestonediumLighter,1,OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneiumLighter,1,OreDictionary.WILDCARD_VALUE));
		
		//Smelting
		GameRegistry.addSmelting(ModBlocks.oreCobblestoneium, new ItemStack(ModItems.ingotCobblestoneium), 1.0f);
		
		//Recipes vanilla
		//Ore
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), "ingotIron", Items.gunpowder, new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)));
		
		//Tools
		GameRegistry.addRecipe(new ItemStack(ModItems.cobblestoneLighter) , new Object[] {" f ", "cgc" , "cgc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'g' , Items.gunpowder, 'c' , Blocks.cobblestone});
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hatchetCobblestoneium, new Object[] {"cc " , "cs " , " s " , 'c', "ingotCobblestoneium" , 's' , "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.pickaxeCobblestoneium, new Object[] {"ccc" , " s " , " s " , 'c', "ingotCobblestoneium" , 's' , "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hoeCobblestoneium, new Object[] {" cc" , " s " , " s " , 'c', "ingotCobblestoneium" , 's' , "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.shovelCobblestoneium, new Object[] {" c " , " s " , " s " , 'c', "ingotCobblestoneium" , 's' , "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.swordCobblestoneium, new Object[] {" c " , " c " , " s " , 'c', "ingotCobblestoneium" , 's' , "stickWood"}));
		
		//Armor
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.helmetCobblestoneium, new Object[] {"ccc" , "c c" , 'c', "ingotCobblestoneium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.chestplateCobblestoneium, new Object[] {"c c" , "ccc" , "ccc" , 'c', "ingotCobblestoneium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.leggingsCobblestoneium, new Object[] {"ccc" , "c c" , "c c" , 'c', "ingotCobblestoneium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.bootsCobblestoneium, new Object[] {"c c" , "c c" , 'c', "ingotCobblestoneium"}));
		
		//Blocks
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCobblestoneium) , new Object[] {"ccc", "ccc" , "ccc" , 'c' , "ingotCobblestoneium"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ingotCobblestoneium , 9) , new ItemStack(ModBlocks.blockCobblestoneium)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ancientTable), new Object[] {"gcg" , "cbc" , "gcg" , 'g' , "ingotGold", 'c', "ingotCobblestoneium" , 'b' , new ItemStack(Blocks.crafting_table)}));
		
		//Items
		
		
		
		//Recipes Ancient Table
		//Ores
		TucsRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), "ingotIron", Items.gunpowder, "cobblestoneLigthers"));
		
		//Blocks
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockCobblestonedium) , new Object[] {"ccc", "ccc" , "ccc" , 'c' , ModItems.ingotCobblestonedium });
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockAncientForge) , new Object[] {"ggg", "gcg" , "glg" , 'c' , ModBlocks.blockCobblestoneium, 'g', Items.gold_ingot, 'l' ,ModItems.cobblestoneiumLighter });
		
		//Items
		TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSbook), new Object[]{"ccc", "cbc", "ccc", 'c', Blocks.cobblestone, 'b', Items.book});
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ingotCobblestonedium), new Object[] {" c ", "cdc" , " c " , 'c', ModItems.ingotCobblestoneium , 'd' , Items.diamond}));
		TucsRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestonedium , 9) , new ItemStack(ModBlocks.blockCobblestonedium));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.CobbleCoal), new Object[]{" c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l' ,"cobblestoneLigthers"}));
		TucsRegistry.addRecipe(new ItemStack(Blocks.torch,5), new Object[] {"c", "s", 'c', ModItems.CobbleCoal, 's', Items.stick});
		
		//Tools
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestoneiumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestoneium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestonediumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestonedium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE)});
	}
	

}
