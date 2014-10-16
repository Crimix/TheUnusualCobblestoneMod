package com.black_dog20.tucs.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.black_dog20.tucs.reference.NBTTags;
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
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), "cobblestoneLighters"));
		
		
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
		TucsRegistry.addRecipe(new ItemStack(Items.emerald,2), new Object[]{"dbd", "beb", "dld", 'd', new ItemStack(Items.dye,1,10), 'b', new ItemStack(Items.diamond), 'e', new ItemStack(Items.emerald), 'l', new ItemStack(ModItems.cobblestonediumLighter,OreDictionary.WILDCARD_VALUE)});
		
		//Tools
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestoneiumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestoneium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestonediumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestonedium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOC), new Object[]{"b","h", 'b', new ItemStack(ModItems.SwordBlade), 'h', new ItemStack(ModItems.SwordHilt)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLPOLM), new Object[]{"p", "h", 'p', new ItemStack(ModItems.pickaxeHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOHD), new Object[]{"s", "h", 's', new ItemStack(ModItems.shovelHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLHOWF), new Object[]{"e", "h", 'e', new ItemStack(ModItems.hoeHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLBOTB), new Object[]{"e", "h", 'e', new ItemStack(ModItems.hatchetHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.talismanBaseT1), new Object[]{"gcg", "cdc", "gcg", 'd', new ItemStack(Items.diamond), 'g', new ItemStack(Items.gold_ingot), 'c', new ItemStack(ModItems.ingotCobblestoneium)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TalismanBase), new Object[]{"ded", "ete", "ded", 'd', new ItemStack(Items.diamond), 'e', new ItemStack(Items.emerald), 't', new ItemStack(ModItems.talismanBaseT1)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.UnfinshedFlightTalisman), new Object[]{"ccc", "ctc", "ccc", 'c', new ItemStack(ModItems.ingotCobblestonedium), 't', new ItemStack(ModItems.TalismanBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ungoldenFligtTalisman), new Object[]{"ccc", "ctc", "ccc", 'c', new ItemStack(ModItems.ingotCobblestoneium), 't', new ItemStack(ModItems.UnfinshedFlightTalisman)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FlightTalisman), new Object[]{"ggg", "gtg", "ggg", 'g', new ItemStack(Items.gold_ingot), 't', new ItemStack(ModItems.ungoldenFligtTalisman)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.craftingTalisman), new Object[]{"gcg", "cac", "gcg", 'g', new ItemStack(ModItems.ingotCobblestoneium), 'c', new ItemStack(Blocks.crafting_table), 'a', new ItemStack(ModBlocks.ancientTable)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.torchTalisman), new Object[]{"gcg", "cac", "gcg", 'g', new ItemStack(ModItems.ingotCobblestoneium), 'c', new ItemStack(Blocks.torch), 'a', new ItemStack(ModItems.cobblestoneiumLighter)});
		Enchanted();
		
		//Tools Parts
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SwordBlade), new Object[]{"gcg", "gdg","gcg", 'g', "ingotGold", 'c', "ingotCobblestonedium", 'd', new ItemStack(Items.diamond)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SwordHilt), new Object[]{"gcg", " s "," e ", 'g', "ingotGold", 'c', "ingotCobblestonedium", 's', new ItemStack(Items.stick), 'e', new ItemStack(Items.emerald)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hoeHead), new Object[]{"cd ", " cg", "  g", 'g', "ingotGold", 'c', "ingotCobblestonedium",  'd', new ItemStack(Items.diamond)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.shovelHead), new Object[]{" cg", "gdg", "cg ", 'g', "ingotGold", 'c', "ingotCobblestonedium", 'd', new ItemStack(Items.diamond)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hatchetHead), new Object[]{"c c", "gdg", "c c", 'g', "ingotGold", 'c', "ingotCobblestonedium", 'd', new ItemStack(Items.diamond)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.pickaxeHead), new Object[]{"cgc", "cdc", "cgc", 'g', "ingotGold", 'c', "ingotCobblestonedium", 'd', new ItemStack(Items.diamond)}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.toolRod), new Object[]{"  s", " s ", "e  ", 's', new ItemStack(Items.stick), 'e', new ItemStack(Items.emerald)}));
		
		//Upgrades
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.upgradBase), new Object[]{"ccc", "cdc","ccc", 'd', new ItemStack(Items.diamond), 'c', "ingotCobblestonedium"}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.soulboundUpgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Blocks.soul_sand), 'c', "ingotCobblestonedium", 'u', new ItemStack(ModItems.upgradBase)}));
		
		
	}
	
	public static void Enchanted(){

		ItemStack ct = new ItemStack(ModItems.craftingTalisman);
		if(!ct.hasTagCompound()){
			ct.stackTagCompound = new NBTTagCompound();
		}
		if(ct.hasTagCompound()){
			NBTTagCompound nbt= ct.getTagCompound();
			nbt.setString(NBTTags.SOULBOUND, NBTTags.OK);
			}
		ItemStack tt = new ItemStack(ModItems.craftingTalisman);
		if(!tt.hasTagCompound()){
			tt.stackTagCompound = new NBTTagCompound();
		}
		if(tt.hasTagCompound()){
			NBTTagCompound nbt= tt.getTagCompound();
			nbt.setString(NBTTags.SOULBOUND, NBTTags.OK);
			}
		
		TucsRegistry.addRecipe(ct, new Object[]{"g", "t", 'g', new ItemStack(ModItems.soulboundUpgrade), 't', new ItemStack(ModItems.craftingTalisman)});
		TucsRegistry.addRecipe(tt, new Object[]{"g", "t", 'g', new ItemStack(ModItems.soulboundUpgrade), 't', new ItemStack(ModItems.torchTalisman)});	
		
	}
	

}
