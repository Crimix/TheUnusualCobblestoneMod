package com.black_dog20.tucs.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.black_dog20.tucs.crafting.AirRecipes;
import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class Recipes {
	static String yellowstoneium = "ingotYellowstoneium";
	static String cobblestonedium = "ingotCobblestonedium";
	static String cobblestoneium = "ingotCobblestoneium";

	public static void init() {

		// ItemStack used in crafting

		// OreDictionary
		OreDictionary.registerOre("ingotCobblestoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("ingotYellowstoneium", new ItemStack(ModItems.ingotYellowstoneium));
		OreDictionary.registerOre("ingotCobblestonedium", new ItemStack(ModItems.ingotCobblestonedium));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));

		// Smelting
		GameRegistry.addSmelting(ModBlocks.oreCobblestoneium, new ItemStack(ModItems.ingotCobblestoneium), 1.0f);

		// Recipes vanilla
		// Ore
		//GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), Blocks.cobblestone, Items.iron_ingot, Items.gunpowder, "cobblestoneLigthers" );
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModBlocks.oreCobblestoneium, Blocks.cobblestone, Items.iron_ingot, Items.gunpowder, "cobblestoneLigthers"));
		
		// Tools
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cobblestoneLighter), new Object[] { " f ", "cgc", "cgc", 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'g', Items.gunpowder, 'c', Blocks.cobblestone });
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hatchetCobblestoneium, new Object[] { "cc ", "cs ", " s ", 'c', "ingotCobblestoneium", 's', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.pickaxeCobblestoneium, new Object[] { "ccc", " s ", " s ", 'c', "ingotCobblestoneium", 's', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.hoeCobblestoneium, new Object[] { " cc", " s ", " s ", 'c', "ingotCobblestoneium", 's', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.shovelCobblestoneium, new Object[] { " c ", " s ", " s ", 'c', "ingotCobblestoneium", 's', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.swordCobblestoneium, new Object[] { " c ", " c ", " s ", 'c', "ingotCobblestoneium", 's', "stickWood" }));

		// Armor
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.helmetCobblestoneium, new Object[] { "ccc", "c c", 'c', "ingotCobblestoneium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.chestplateCobblestoneium, new Object[] { "c c", "ccc", "ccc", 'c', "ingotCobblestoneium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.leggingsCobblestoneium, new Object[] { "ccc", "c c", "c c", 'c', "ingotCobblestoneium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.bootsCobblestoneium, new Object[] { "c c", "c c", 'c', "ingotCobblestoneium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ScubaMask, new Object[] { "yyy", "ygy", "yyy", 'y', yellowstoneium, 'g', Blocks.glass_pane }));
		ItemStack AirTank = new ItemStack(ModItems.AirTank, 1);
		// IScubaAirTank item = (IScubaAirTank)AirTank.getItem();
		// item.setNBT(AirTank);
		GameRegistry.addRecipe(new ShapedOreRecipe(AirTank, new Object[] { "cyc", "c c", "ccc", 'y', yellowstoneium, 'c', cobblestoneium }));

		// Blocks
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCobblestoneium), new Object[] { "ccc", "ccc", "ccc", 'c', cobblestoneium }));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium, 9), ModBlocks.blockCobblestoneium);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.ancientTable), new Object[] { "gcg", "cbc", "gcg", 'g', yellowstoneium, 'c', cobblestoneium, 'b', Blocks.crafting_table}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockAirMaker), new Object[] { "ggg", "gfg", "ggg", 'g', yellowstoneium, 'f', Blocks.furnace }));

		// Items
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ingotCobblestoneium), ModBlocks.oreCobblestoneium, "cobblestoneLigthers"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.CobbleCoal), new Object[] { " c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l', "cobblestoneLigthers" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ingotYellowstoneium, 2), new Object[] { "ccc", "cyc", "clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye, 1, 11), 'l', "cobblestoneLigthers" }));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.dye, 3, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), "cobblestoneLigthers"));

		// Recipes Ancient Table
		// Blocks
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCobblestonedium), new Object[] { "ccc", "ccc", "ccc", 'c', cobblestonedium }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockAncientForge), new Object[] { "ggg", "gcg", "glg", 'c', cobblestoneium, 'g', yellowstoneium, 'l', ModItems.cobblestoneiumLighter }));
		TucsRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockSoulbind), new Object[] { "sgs", "gcg", "sgs", 'g', ModItems.soulboundUpgrade, 'c', ModItems.Tier2CraftingMat, 's', Blocks.soul_sand });

		// Items
		//TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSbook), new Object[] { "ccc", "cbc", "ccc", 'c', Blocks.cobblestone, 'b', Items.book });
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ingotCobblestonedium), new Object[] { " c ", "cdc", " c ", 'c', cobblestoneium, 'd', Items.diamond }));
		TucsRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestonedium, 9), ModBlocks.blockCobblestonedium);
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.torch, 5), new Object[] { "c", "s", 'c', ModItems.CobbleCoal, 's', "stickWood" }));
		TucsRegistry.addRecipe(new ItemStack(ModItems.FragmentHeartDestroyer), new Object[] { "ttt", "tnt", "ttt", 't', ModItems.Tier4CraftingMat, 'n', Items.nether_star });

		
		// Tools
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cobblestoneiumLighter), new Object[] { " f ", "cic", "clc", 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i', cobblestoneium, 'c', Blocks.cobblestone, 'l', new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE) }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.cobblestonediumLighter), new Object[] { " f ", "cic", "clc", 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i', cobblestonedium, 'c', Blocks.cobblestone, 'l', new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE) }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLSOC), new Object[] { "b", "h", 'b', ModItems.SwordBlade, 'h', ModItems.SwordHilt }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLPOLM), new Object[] { "p", "h", 'p', ModItems.pickaxeHead, 'h', ModItems.toolRod }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLSOHD), new Object[] { "s", "h", 's', ModItems.shovelHead, 'h', ModItems.toolRod }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLHOWF), new Object[] { "e", "h", 'e', ModItems.hoeHead, 'h', ModItems.toolRod }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLBOTB), new Object[] { "e", "h", 'e', ModItems.hatchetHead, 'h', ModItems.toolRod }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.talismanBaseT1), new Object[] { "gcg", "cdc", "gcg", 'd', ModItems.Tier1CraftingMat, 'g', yellowstoneium, 'c', cobblestoneium }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TalismanBase), new Object[] { "ded", "ete", "ded", 'd', ModItems.Tier1CraftingMat, 'e', ModItems.Tier2CraftingMat, 't', ModItems.talismanBaseT1 }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.UnfinshedFlightTalisman), new Object[] { "ccc", "ctc", "ccc", 'c', cobblestonedium, 't', ModItems.TalismanBase }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ungoldenFligtTalisman), new Object[] { "ccc", "ctc", "ccc", 'c', cobblestoneium, 't', ModItems.UnfinshedFlightTalisman }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FlightTalisman), new Object[] { "ggg", "gtg", "ggg", 'g', yellowstoneium, 't', ModItems.ungoldenFligtTalisman }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.craftingTalisman), new Object[] { "gcg", "cac", "gcg", 'g', cobblestoneium, 'c', Blocks.crafting_table, 'a', ModBlocks.ancientTable }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.torchTalisman), new Object[] { "gcg", "cac", "gcg", 'g', cobblestoneium, 'c', Blocks.torch, 'a', ModItems.talismanBaseT1 }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TLSOTD), new Object[] { "sns", "efe", "dcd", 's', ModItems.TLSOC, 'n', Items.nether_star, 'e', Blocks.emerald_block, 'f', ModItems.FlightTalisman, 'd', Items.diamond, 'c', ModBlocks.blockCobblestonedium }));

		// Tools Parts
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SwordBlade), new Object[] { "gcg", "gdg", "gcg", 'g', yellowstoneium, 'c', cobblestonedium, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.SwordHilt), new Object[] { "gcg", " s ", " e ", 'g', yellowstoneium, 'c', cobblestonedium, 's', Items.stick, 'e', ModItems.Tier2CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hoeHead), new Object[] { "cd ", " cg", "  g", 'g', yellowstoneium, 'c', cobblestonedium, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.shovelHead), new Object[] { " cg", "gdg", "cg ", 'g', yellowstoneium, 'c', cobblestonedium, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.hatchetHead), new Object[] { "c c", "gdg", "c c", 'g', yellowstoneium, 'c', cobblestonedium, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.pickaxeHead), new Object[] { "sgs", "cdc", "ggg", 'g', yellowstoneium, 's', cobblestoneium, 'c', cobblestonedium, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.toolRod), new Object[] { "  s", " s ", "e  ", 's', Items.stick, 'e', ModItems.Tier2CraftingMat }));

		// Upgrades
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.upgradBase), new Object[] { "ccc", "cdc", "ccc", 'd', ModItems.Tier1CraftingMat, 'c', yellowstoneium }));
		TucsRegistry.addRecipe(new ItemStack(ModItems.upgradBaseT2), new Object[] { "ccc", "cdc", "ccc", 'd', ModItems.Tier3CraftingMat, 'c', ModItems.upgradBase });
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.soulboundUpgrade), new Object[] { "csc", "sus", "csc", 's', Blocks.soul_sand, 'c', yellowstoneium, 'u', ModItems.upgradBaseT2 }));
		TucsRegistry.addRecipe(new ItemStack(ModItems.HeartOfTheDestroyerUpgrade), new Object[] { "ccc", "cdc", "ccc", 'd', Items.nether_star, 'c', ModItems.FragmentHeartDestroyer });
		
		Upgrades();

		// Armor
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.helmetCobblestonedium), new Object[] { "cyc", "chc", "   ", 'y', yellowstoneium, 'c', cobblestonedium, 'h', Items.golden_helmet }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.chestplateCobblestonedium), new Object[] { "c c", "ehe", "dyd", 'y', yellowstoneium, 'c', cobblestonedium, 'h', Items.golden_chestplate, 'e', ModItems.Tier2CraftingMat, 'd', ModItems.Tier1CraftingMat }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leggingsCobblestonedium), new Object[] { "yyy", "chc", "c c", 'y', yellowstoneium, 'c', cobblestonedium, 'h', Items.golden_leggings}));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bootsCobblestonedium), new Object[] { "c c", "yhy", "   ", 'y', yellowstoneium, 'c', cobblestonedium, 'h', Items.golden_boots }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.helmetCobblestonedium_scuba), new Object[] { "yhy", "csc", "   ", 'y', yellowstoneium, 'c', cobblestoneium, 'h', ModItems.helmetCobblestonedium }));
		//TucsRegistry.addRecipe(new ItemStack(ModItems.chestplateCobblestonedium_scuba), new Object[] { "yyy", "chc", "yyy", 'y', yellowstoneium, 'c', cobblestoneium, 'h', ModItems.chestplateCobblestonedium});
		TucsRegistry.addRecipe(new AirRecipes(new ItemStack(ModItems.chestplateCobblestonedium_scuba), new ItemStack(ModItems.chestplateCobblestonedium),new ItemStack(ModItems.AirTank)));
		
		// Ranged
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.TUCSBow), new Object[] { " dy", "eby", " dy", 'd', ModItems.Tier1CraftingMat, 'e', ModItems.Tier2CraftingMat, 'b', Items.bow, 'y', "ingotYellowstoneium" }));
		TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.M1911), new Object[] { "ccc", "dgt", "  c", 'c', cobblestonedium, 'd', Blocks.dispenser, 'g', Items.gunpowder, 't', ModItems.Tier3CraftingMat }));
		TucsRegistry.addRecipe(new ItemStack(ModItems.ammo, 4), new Object[] { "ccc", "cgc", "cic", 'c', Blocks.cobblestone, 'i', Items.iron_ingot, 'g', Items.gunpowder });
	}

	public static void Upgrades() {
		switch (ConfigurationHandler.Max_Luck_Upgrade) {
		case 3:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.looting1Upgrade), new Object[] { "yly", "lul", "yly", 'y', yellowstoneium, 'l', new ItemStack(Items.dye, 1, 4), 'u', ModItems.upgradBase }));
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.looting2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.looting1Upgrade), 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.looting3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.looting2Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Max_Sharpness_Upgrade) {
		case 5:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Sharpness1Upgrade), new Object[] { "yly", "lul", "yly", 'y', yellowstoneium, 'l', Items.quartz, 'u', ModItems.upgradBase }));
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Sharpness1Upgrade, 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Sharpness2Upgrade, 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Sharpness3Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Sharpness4Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Silktouch_Upgrade) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Sliktouch1Upgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', Items.string, 'u', ModItems.upgradBase }));
		}
		if (ConfigurationHandler.Max_Beheading_Upgrade) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BeheadingUpgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', new ItemStack(Items.skull, 1, 2), 'u', ModItems.upgradBase }));
		}
		if (ConfigurationHandler.Max_Infi_Upgrade) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.InfiUpgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', Items.arrow, 'u', ModItems.upgradBase }));
		}
		switch (ConfigurationHandler.Max_Bane_of_Arthropods) {
		case 5:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BoA1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.spider_eye, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.BoA1Upgrade, 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.BoA2Upgrade, 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.BoA3Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.BoA4Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Aqua_Affinity) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.AquaAffinityUpgrade), new Object[] { "csc", "sus", "csc", 's', Items.water_bucket, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		}
		if (ConfigurationHandler.Max_Auto_Bow) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.AutoBowUpgrade), new Object[] { "csc", "sus", "csc", 's', Items.bow, 'c', yellowstoneium, 'u', ModItems.upgradBaseT2 }));
		}
		switch (ConfigurationHandler.Max_Blast_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.BlastProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', Blocks.tnt, 'i', Items.iron_chestplate, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.BlastProtection1Upgrade, 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.BlastProtection2Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.BlastProtection3Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Efficiency) {
		case 5:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Efficiency1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.iron_pickaxe, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Efficiency1Upgrade, 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Efficiency2Upgrade, 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Efficiency3Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Efficiency4Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Feather_Falling) {
		case 4:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FeatherFalling1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.feather, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.FeatherFalling1Upgrade, 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.FeatherFalling2Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.FeatherFalling3Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Fire_Aspect) {
		case 2:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FireAspect1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.blaze_rod, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireAspect2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.FireAspect1Upgrade, 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Fire_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FireProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', Items.blaze_rod, 'i', Items.iron_chestplate, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.FireProtection1Upgrade, 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.FireProtection2Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.FireProtection3Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Flame) {
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.FlameUpgrade), new Object[] { "csc", "sus", "csc", 's', Items.flint_and_steel, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		}
		switch (ConfigurationHandler.Knockback) {
		case 2:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Knockback1Upgrade), new Object[] { "csc", "sus", "csc", 's', Blocks.piston, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Knockback2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Knockback1Upgrade, 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Power) {
		case 5:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Power1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.flint, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Power1Upgrade, 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Power2Upgrade, 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Power3Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Power4Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Projectile_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.ProjectileProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', Items.arrow, 'i', Items.iron_chestplate, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.ProjectileProtection1Upgrade, 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.ProjectileProtection2Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.ProjectileProtection3Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Protection) {
		case 4:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Protection1Upgrade), new Object[] { "cic", "sus", "cic", 's', Items.iron_ingot, 'i', Items.iron_chestplate, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Protection1Upgrade, 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Protection2Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Protection3Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Punch) {
		case 2:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Punch1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.leather, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Punch2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Punch1Upgrade, 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Respiration) {
		case 3:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Respiration1Upgrade), new Object[] { "cic", "sus", "cic", 's', Items.golden_apple, 'i', Items.water_bucket, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Respiration1Upgrade, 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Respiration2Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Smite) {
		case 5:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Smite1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.rotten_flesh, 'c', yellowstoneium, 'u',ModItems.upgradBase }));
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Smite1Upgrade, 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Smite2Upgrade, 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Smite3Upgrade, 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Smite4Upgrade, 'r', Blocks.redstone_block });
			break;

		}
		switch (ConfigurationHandler.Thorns) {
		case 3:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Thorns1Upgrade), new Object[] { "csc", "sus", "csc", 's', Blocks.vine, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Thorns1Upgrade, 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Thorns2Upgrade, 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Unbreaking) {
		case 3:
			TucsRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.Unbreaking1Upgrade), new Object[] { "csc", "sus", "csc", 's', Items.diamond, 'c', yellowstoneium, 'u', ModItems.upgradBase }));
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', ModItems.Unbreaking1Upgrade, 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', ModItems.Unbreaking2Upgrade, 'r', Blocks.redstone_block });
			break;
		}
	}
}
