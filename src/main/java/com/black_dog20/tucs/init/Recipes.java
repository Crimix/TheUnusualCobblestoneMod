package com.black_dog20.tucs.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class Recipes {
	
	public static void init(){
		
		//ItemStack used in crafting
		ItemStack yellowstoneium = new ItemStack(ModItems.ingotYellowstoneium);
		
		//OreDictionary
		OreDictionary.registerOre("ingotCobblestoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("yellowstoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("ingotCobblestonedium", new ItemStack(ModItems.ingotCobblestonedium));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneLighter,1,OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestonediumLighter,1,OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneiumLighter,1,OreDictionary.WILDCARD_VALUE));
		
		//Smelting
		GameRegistry.addSmelting(ModBlocks.oreCobblestoneium, new ItemStack(ModItems.ingotCobblestoneium), 1.0f);
		
		//Recipes vanilla
		//Ore
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));
		
		//Tools
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cobblestoneLighter), new Object[] {" f ", "cgc" , "cgc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'g' , Items.gunpowder, 'c' , Blocks.cobblestone});
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
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockCobblestoneium) , new Object[] {"ccc", "ccc" , "ccc" , 'c' , ModItems.ingotCobblestoneium});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium , 9) , new ItemStack(ModBlocks.blockCobblestoneium));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.ancientTable), new Object[] {"gcg" , "cbc" , "gcg" , 'g' , yellowstoneium, 'c', ModItems.ingotCobblestoneium , 'b' , new ItemStack(Blocks.crafting_table)});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockSoulbind),new Object[]{"ggg","gcg","ggg",'g', new ItemStack(ModItems.soulboundUpgrade),'c',new ItemStack(Items.nether_star)});
		
		//Items
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[]{" c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l' ,new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[]{" c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l' ,new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[]{" c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l' ,new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium,2), new Object[]{"ccc","cyc","clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye,1,11), 'l', new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium,2), new Object[]{"ccc","cyc","clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye,1,11), 'l', new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium,2), new Object[]{"ccc","cyc","clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye,1,11), 'l', new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye,3,11), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,15), new ItemStack(Items.dye,1,15), new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye,3,11), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,15), new ItemStack(Items.dye,1,15), new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye,3,11), new ItemStack(Items.dye,1,11), new ItemStack(Items.dye,1,15), new ItemStack(Items.dye,1,15), new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));
		
		
		//Recipes Ancient Table
		//Blocks
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockCobblestonedium) , new Object[] {"ccc", "ccc" , "ccc" , 'c' , ModItems.ingotCobblestonedium });
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockAncientForge) , new Object[] {"ggg", "gcg" , "glg" , 'c' , ModBlocks.blockCobblestoneium, 'g', yellowstoneium, 'l' ,ModItems.cobblestoneiumLighter });
		
		//Items
		TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSbook), new Object[]{"ccc", "cbc", "ccc", 'c', Blocks.cobblestone, 'b', Items.book});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ingotCobblestonedium), new Object[] {" c ", "cdc" , " c " , 'c', ModItems.ingotCobblestoneium , 'd' , Items.diamond});
		TucsRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestonedium , 9) , new ItemStack(ModBlocks.blockCobblestonedium));
		TucsRegistry.addRecipe(new ItemStack(Blocks.torch,5), new Object[] {"c", "s", 'c', ModItems.CobbleCoal, 's', Items.stick});
		TucsRegistry.addRecipe(new ItemStack(Items.emerald,2), new Object[]{"dbd", "beb", "dld", 'd', new ItemStack(Items.dye,1,10), 'b', new ItemStack(Items.diamond), 'e', new ItemStack(Items.emerald), 'l', new ItemStack(ModItems.cobblestonediumLighter,1,OreDictionary.WILDCARD_VALUE)});
		
		//Tools
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestoneiumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestoneium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestonediumLighter) , new Object[] {" f ", "cic" , "clc" , 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i' , ModItems.ingotCobblestonedium, 'c' , Blocks.cobblestone, 'l' , new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOC), new Object[]{"b","h", 'b', new ItemStack(ModItems.SwordBlade), 'h', new ItemStack(ModItems.SwordHilt)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLPOLM), new Object[]{"p", "h", 'p', new ItemStack(ModItems.pickaxeHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOHD), new Object[]{"s", "h", 's', new ItemStack(ModItems.shovelHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLHOWF), new Object[]{"e", "h", 'e', new ItemStack(ModItems.hoeHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLBOTB), new Object[]{"e", "h", 'e', new ItemStack(ModItems.hatchetHead), 'h', new ItemStack(ModItems.toolRod)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.talismanBaseT1), new Object[]{"gcg", "cdc", "gcg", 'd', new ItemStack(Items.diamond), 'g', yellowstoneium, 'c', new ItemStack(ModItems.ingotCobblestoneium)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TalismanBase), new Object[]{"ded", "ete", "ded", 'd', new ItemStack(Items.diamond), 'e', new ItemStack(Items.emerald), 't', new ItemStack(ModItems.talismanBaseT1)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.UnfinshedFlightTalisman), new Object[]{"ccc", "ctc", "ccc", 'c', new ItemStack(ModItems.ingotCobblestonedium), 't', new ItemStack(ModItems.TalismanBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ungoldenFligtTalisman), new Object[]{"ccc", "ctc", "ccc", 'c', new ItemStack(ModItems.ingotCobblestoneium), 't', new ItemStack(ModItems.UnfinshedFlightTalisman)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FlightTalisman), new Object[]{"ggg", "gtg", "ggg", 'g', yellowstoneium, 't', new ItemStack(ModItems.ungoldenFligtTalisman)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.craftingTalisman), new Object[]{"gcg", "cac", "gcg", 'g', new ItemStack(ModItems.ingotCobblestoneium), 'c', new ItemStack(Blocks.crafting_table), 'a', new ItemStack(ModBlocks.ancientTable)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.torchTalisman), new Object[]{"gcg", "cac", "gcg", 'g', new ItemStack(ModItems.ingotCobblestoneium), 'c', new ItemStack(Blocks.torch), 'a', new ItemStack(ModItems.talismanBaseT1,1,OreDictionary.WILDCARD_VALUE)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOTD), new Object[]{"sns","efe", "dcd", 's' , new ItemStack(ModItems.TLSOC), 'n', new ItemStack(Items.nether_star), 'e', new ItemStack(Blocks.emerald_block),'f', new ItemStack(ModItems.FlightTalisman),'d', new ItemStack(Items.diamond),'c', new ItemStack(ModBlocks.blockCobblestonedium)});
		
		//Tools Parts
		ItemStack cobblestondium = new ItemStack(ModItems.ingotCobblestonedium);
		TucsRegistry.addRecipe(new ItemStack(ModItems.SwordBlade), new Object[]{"gcg", "gdg","gcg", 'g', yellowstoneium, 'c', cobblestondium, 'd', new ItemStack(Items.diamond)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.SwordHilt), new Object[]{"gcg", " s "," e ", 'g', yellowstoneium, 'c', cobblestondium, 's', new ItemStack(Items.stick), 'e', new ItemStack(Items.emerald)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.hoeHead), new Object[]{"cd ", " cg", "  g", 'g', yellowstoneium, 'c', cobblestondium,  'd', new ItemStack(Items.diamond)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.shovelHead), new Object[]{" cg", "gdg", "cg ", 'g', yellowstoneium, 'c', cobblestondium, 'd', new ItemStack(Items.diamond)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.hatchetHead), new Object[]{"c c", "gdg", "c c", 'g', yellowstoneium, 'c', cobblestondium, 'd', new ItemStack(Items.diamond)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.pickaxeHead), new Object[]{"sgs", "cdc", "ggg", 'g', yellowstoneium, 's', ModItems.ingotCobblestoneium, 'c', cobblestondium, 'd', new ItemStack(Items.diamond)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.toolRod), new Object[]{"  s", " s ", "e  ", 's', new ItemStack(Items.stick), 'e', new ItemStack(Items.emerald)});
		
		//Upgrades
		TucsRegistry.addRecipe(new ItemStack(ModItems.upgradBase), new Object[]{"ccc", "cdc","ccc", 'd', new ItemStack(Items.diamond), 'c', yellowstoneium});
		TucsRegistry.addRecipe(new ItemStack(ModItems.upgradBaseT2), new Object[]{"ccc", "cdc","ccc", 'd', new ItemStack(Items.nether_star), 'c', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.soulboundUpgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Blocks.soul_sand), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBaseT2)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.looting1Upgrade), new Object[]{"yly","lul","yly", 'y', yellowstoneium, 'l', new ItemStack(Items.dye,1,4), 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.looting2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.looting1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.looting3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.looting2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness1Upgrade), new Object[]{"yly","lul","yly", 'y', yellowstoneium, 'l', new ItemStack(Items.quartz), 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Sharpness1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness3Upgrade), new Object[]{"rrr","rlr","rrr", 'l', new ItemStack(ModItems.Sharpness2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness4Upgrade), new Object[]{"rrr","rlr","rrr", 'l', new ItemStack(ModItems.Sharpness3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness5Upgrade), new Object[]{"rrr","rlr","rrr", 'l', new ItemStack(ModItems.Sharpness4Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Sliktouch1Upgrade), new Object[]{"ysy","sus","ysy", 'y', yellowstoneium, 's', new ItemStack(Items.string), 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BeheadingUpgrade), new Object[]{"ysy","sus","ysy", 'y', yellowstoneium, 's', new ItemStack(Items.skull,1,2), 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.InfiUpgrade), new Object[]{"ysy","sus","ysy", 'y', yellowstoneium, 's', new ItemStack(Items.arrow), 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BoA1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.spider_eye), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BoA2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.BoA1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BoA3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.BoA2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BoA4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.BoA3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BoA5Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.BoA4Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.AquaAffinityUpgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.water_bucket), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.AutoBowUpgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.bow), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBaseT2)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection1Upgrade), new Object[]{"cic", "sus","cic", 's', new ItemStack(Blocks.tnt), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.BlastProtection1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.BlastProtection2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.BlastProtection3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.iron_pickaxe), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Efficiency1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency5Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency4Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.feather), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.FeatherFalling1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.FeatherFalling2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.FeatherFalling3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireAspect1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.blaze_rod), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireAspect2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.FireAspect1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection1Upgrade), new Object[]{"cic", "sus","cic", 's', new ItemStack(Items.blaze_rod), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.FireProtection1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.FireProtection2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.FireProtection3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.FlameUpgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.flint_and_steel), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Knockback1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Blocks.piston), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Knockback2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Knockback1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Power1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.flint), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Power2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Power1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Power3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Power2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Power4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Power3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Power5Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Power4Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection1Upgrade), new Object[]{"cic", "sus","cic", 's', new ItemStack(Items.arrow), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.ProjectileProtection1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.ProjectileProtection2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.ProjectileProtection3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Protection1Upgrade), new Object[]{"cic", "sus","cic", 's', new ItemStack(Items.iron_ingot), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Protection2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Protection1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Protection3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Protection2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Protection4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Protection3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Punch1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.leather), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Punch2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Punch1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration1Upgrade), new Object[]{"cic", "sus","cic", 's', new ItemStack(Items.golden_apple), 'i', new ItemStack(Items.water_bucket), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Respiration1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Respiration2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Smite1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.rotten_flesh), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Smite2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Smite1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Smite3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Smite2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Smite4Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Smite3Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Smite5Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Smite4Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Blocks.vine), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Thorns1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Thorns2Upgrade), 'r', Blocks.redstone_block});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking1Upgrade), new Object[]{"csc", "sus","csc", 's', new ItemStack(Items.diamond), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking2Upgrade), new Object[]{"ggg","glg", "ggg", 'l', new ItemStack(ModItems.Unbreaking1Upgrade), 'g', Blocks.glowstone});
		TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking3Upgrade), new Object[]{"rrr","rlr", "rrr", 'l', new ItemStack(ModItems.Unbreaking2Upgrade), 'r', Blocks.redstone_block});
		
		//Armor
		TucsRegistry.addRecipe(new ItemStack(ModItems.helmetCobblestonedium), new Object[]{"cyc","chc","   ", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_helmet)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.chestplateCobblestonedium), new Object[]{"c c","ehe","dyd", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_chestplate), 'e' , Items.emerald, 'd' , Items.diamond});
		TucsRegistry.addRecipe(new ItemStack(ModItems.leggingsCobblestonedium), new Object[]{"yyy","chc","c c", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_leggings)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.bootsCobblestonedium), new Object[]{"c c","yhy","   ", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_boots)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.helmetCobblestonedium), new Object[]{"h","g", 'h', ModItems.helmetCobblestonediumBroken, 'g', new ItemStack(Items.golden_helmet)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.chestplateCobblestonedium), new Object[]{"h","g", 'h', ModItems.chestplateCobblestonediumBroken, 'g', new ItemStack(Items.golden_chestplate)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.leggingsCobblestonedium), new Object[]{"h","g", 'h', ModItems.leggingsCobblestonediumBroken, 'g', new ItemStack(Items.golden_leggings)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.bootsCobblestonedium), new Object[]{"h","g", 'h' , ModItems.bootsCobblestonediumBroken, 'g', new ItemStack(Items.golden_boots)});
	
		//Ranged
		TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSBow), new Object[]{" dy","eby", " dy", 'd', Items.diamond, 'e', Items.emerald, 'b', new ItemStack(Items.bow), 'y', ModItems.ingotYellowstoneium});
		TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSBow), new Object[]{"b","n", 'b', ModItems.TUCSBowBroken, 'n', new ItemStack(Items.bow)});
		TucsRegistry.addRecipe(new ItemStack(ModItems.M1911), new Object[]{"ccc","dgc","  c", 'c', ModItems.ingotCobblestonedium, 'd', Blocks.dispenser, 'g', Items.gunpowder});
		TucsRegistry.addRecipe(new ItemStack(ModItems.ammo,4), new Object[]{"ccc","cgc","cic", 'c', Blocks.cobblestone, 'i', Items.iron_ingot, 'g', Items.gunpowder});
	}
}
