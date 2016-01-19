package com.black_dog20.tucs.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID) public class Recipes {
	static ItemStack yellowstoneium = new ItemStack(ModItems.ingotYellowstoneium);

	public static void init() {

		// ItemStack used in crafting

		// OreDictionary
		OreDictionary.registerOre("ingotCobblestoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("yellowstoneium", new ItemStack(ModItems.ingotCobblestoneium));
		OreDictionary.registerOre("ingotCobblestonedium", new ItemStack(ModItems.ingotCobblestonedium));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestoneLigthers", new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));

		// Smelting
		GameRegistry.addSmelting(ModBlocks.oreCobblestoneium, new ItemStack(ModItems.ingotCobblestoneium), 1.0f);

		// Recipes vanilla
		// Ore
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(Blocks.cobblestone), Items.iron_ingot, Items.gunpowder, new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));

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
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ScubaMask, new Object[] { "yyy", "ygy", "yyy", 'y', ModItems.ingotYellowstoneium, 'g', Blocks.glass_pane }));
		ItemStack AirTank = new ItemStack(ModItems.AirTank, 1);
		// IScubaAirTank item = (IScubaAirTank)AirTank.getItem();
		// item.setNBT(AirTank);
		GameRegistry.addRecipe(new ShapedOreRecipe(AirTank, new Object[] { "cyc", "c c", "ccc", 'y', ModItems.ingotYellowstoneium, 'c', ModItems.ingotCobblestoneium }));

		// Blocks
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockCobblestoneium), new Object[] { "ccc", "ccc", "ccc", 'c', ModItems.ingotCobblestoneium });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium, 9), new ItemStack(ModBlocks.blockCobblestoneium));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.ancientTable), new Object[] { "gcg", "cbc", "gcg", 'g', yellowstoneium, 'c', ModItems.ingotCobblestoneium, 'b', new ItemStack(Blocks.crafting_table) });
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockAirMaker), new Object[] { "ggg", "gfg", "ggg", 'g', yellowstoneium, 'f', Blocks.furnace });

		// Items
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestoneium), new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[] { " c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l', new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[] { " c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l', new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.CobbleCoal), new Object[] { " c ", "ckc", "clc", 'c', Blocks.cobblestone, 'k', Items.coal, 'l', new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE) });

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium, 2), new Object[] { "ccc", "cyc", "clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye, 1, 11), 'l', new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium, 2), new Object[] { "ccc", "cyc", "clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye, 1, 11), 'l', new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE) });
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotYellowstoneium, 2), new Object[] { "ccc", "cyc", "clc", 'c', Blocks.cobblestone, 'y', new ItemStack(Items.dye, 1, 11), 'l', new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE) });

		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 3, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 3, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 3, 11), new ItemStack(Items.dye, 1, 11), new ItemStack(Items.dye, 1, 15), new ItemStack(Items.dye, 1, 15), new ItemStack(ModItems.cobblestonediumLighter, 1, OreDictionary.WILDCARD_VALUE));

		// Recipes Ancient Table
		// Blocks
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockCobblestonedium), new Object[] { "ccc", "ccc", "ccc", 'c', ModItems.ingotCobblestonedium });
		TucsRegistry.addRecipe(new ItemStack(ModBlocks.blockAncientForge), new Object[] { "ggg", "gcg", "glg", 'c', ModBlocks.blockCobblestoneium, 'g', yellowstoneium, 'l', ModItems.cobblestoneiumLighter });
		TucsRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockSoulbind), new Object[] { "sgs", "gcg", "sgs", 'g', ModItems.soulboundUpgrade, 'c', ModItems.Tier2CraftingMat, 's', Blocks.soul_sand });

		// Items
		//TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSbook), new Object[] { "ccc", "cbc", "ccc", 'c', Blocks.cobblestone, 'b', Items.book });
		TucsRegistry.addRecipe(new ItemStack(ModItems.ingotCobblestonedium), new Object[] { " c ", "cdc", " c ", 'c', ModItems.ingotCobblestoneium, 'd', Items.diamond });
		TucsRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotCobblestonedium, 9), ModBlocks.blockCobblestonedium);
		TucsRegistry.addRecipe(new ItemStack(Blocks.torch, 5), new Object[] { "c", "s", 'c', ModItems.CobbleCoal, 's', Items.stick });

		// Tools
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestoneiumLighter), new Object[] { " f ", "cic", "clc", 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i', ModItems.ingotCobblestoneium, 'c', Blocks.cobblestone, 'l', new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE) });
		TucsRegistry.addRecipe(new ItemStack(ModItems.cobblestonediumLighter), new Object[] { " f ", "cic", "clc", 'f', new ItemStack(Items.flint_and_steel, 1, OreDictionary.WILDCARD_VALUE), 'i', ModItems.ingotCobblestonedium, 'c', Blocks.cobblestone, 'l', new ItemStack(ModItems.cobblestoneiumLighter, 1, OreDictionary.WILDCARD_VALUE) });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOC), new Object[] { "b", "h", 'b', ModItems.SwordBlade, 'h', ModItems.SwordHilt });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLPOLM), new Object[] { "p", "h", 'p', ModItems.pickaxeHead, 'h', ModItems.toolRod });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOHD), new Object[] { "s", "h", 's', ModItems.shovelHead, 'h', ModItems.toolRod });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLHOWF), new Object[] { "e", "h", 'e', ModItems.hoeHead, 'h', ModItems.toolRod });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLBOTB), new Object[] { "e", "h", 'e', ModItems.hatchetHead, 'h', ModItems.toolRod });
		TucsRegistry.addRecipe(new ItemStack(ModItems.talismanBaseT1), new Object[] { "gcg", "cdc", "gcg", 'd', ModItems.Tier1CraftingMat, 'g', yellowstoneium, 'c', ModItems.ingotCobblestoneium });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TalismanBase), new Object[] { "ded", "ete", "ded", 'd', ModItems.Tier1CraftingMat, 'e', ModItems.Tier2CraftingMat, 't', ModItems.talismanBaseT1 });
		TucsRegistry.addRecipe(new ItemStack(ModItems.UnfinshedFlightTalisman), new Object[] { "ccc", "ctc", "ccc", 'c', ModItems.ingotCobblestonedium, 't', ModItems.TalismanBase });
		TucsRegistry.addRecipe(new ItemStack(ModItems.ungoldenFligtTalisman), new Object[] { "ccc", "ctc", "ccc", 'c', ModItems.ingotCobblestoneium, 't', ModItems.UnfinshedFlightTalisman });
		TucsRegistry.addRecipe(new ItemStack(ModItems.FlightTalisman), new Object[] { "ggg", "gtg", "ggg", 'g', yellowstoneium, 't', new ItemStack(ModItems.ungoldenFligtTalisman) });
		TucsRegistry.addRecipe(new ItemStack(ModItems.craftingTalisman), new Object[] { "gcg", "cac", "gcg", 'g', ModItems.ingotCobblestoneium, 'c', Blocks.crafting_table, 'a', ModBlocks.ancientTable });
		TucsRegistry.addRecipe(new ItemStack(ModItems.torchTalisman), new Object[] { "gcg", "cac", "gcg", 'g', ModItems.ingotCobblestoneium, 'c', Blocks.torch, 'a', ModItems.talismanBaseT1 });
		TucsRegistry.addRecipe(new ItemStack(ModItems.TLSOTD), new Object[] { "sns", "efe", "dcd", 's', ModItems.TLSOC, 'n', Items.nether_star, 'e', Blocks.emerald_block, 'f', ModItems.FlightTalisman, 'd', Items.diamond, 'c', ModBlocks.blockCobblestonedium });

		// Tools Parts
		ItemStack cobblestondium = new ItemStack(ModItems.ingotCobblestonedium);
		TucsRegistry.addRecipe(new ItemStack(ModItems.SwordBlade), new Object[] { "gcg", "gdg", "gcg", 'g', yellowstoneium, 'c', cobblestondium, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.SwordHilt), new Object[] { "gcg", " s ", " e ", 'g', yellowstoneium, 'c', cobblestondium, 's', Items.stick, 'e', ModItems.Tier2CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.hoeHead), new Object[] { "cd ", " cg", "  g", 'g', yellowstoneium, 'c', cobblestondium, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.shovelHead), new Object[] { " cg", "gdg", "cg ", 'g', yellowstoneium, 'c', cobblestondium, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.hatchetHead), new Object[] { "c c", "gdg", "c c", 'g', yellowstoneium, 'c', cobblestondium, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.pickaxeHead), new Object[] { "sgs", "cdc", "ggg", 'g', yellowstoneium, 's', ModItems.ingotCobblestoneium, 'c', cobblestondium, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.toolRod), new Object[] { "  s", " s ", "e  ", 's', Items.stick, 'e', ModItems.Tier2CraftingMat });

		// Upgrades
		TucsRegistry.addRecipe(new ItemStack(ModItems.upgradBase), new Object[] { "ccc", "cdc", "ccc", 'd', ModItems.Tier1CraftingMat, 'c', yellowstoneium });
		TucsRegistry.addRecipe(new ItemStack(ModItems.upgradBaseT2), new Object[] { "ccc", "cdc", "ccc", 'd', ModItems.Tier3CraftingMat, 'c', ModItems.upgradBase });
		TucsRegistry.addRecipe(new ItemStack(ModItems.soulboundUpgrade), new Object[] { "csc", "sus", "csc", 's', Blocks.soul_sand, 'c', yellowstoneium, 'u', ModItems.upgradBaseT2 });

		Upgrades();

		// Armor
		TucsRegistry.addRecipe(new ItemStack(ModItems.helmetCobblestonedium), new Object[] { "cyc", "chc", "   ", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_helmet) });
		TucsRegistry.addRecipe(new ItemStack(ModItems.chestplateCobblestonedium), new Object[] { "c c", "ehe", "dyd", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_chestplate), 'e', ModItems.Tier2CraftingMat, 'd', ModItems.Tier1CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.leggingsCobblestonedium), new Object[] { "yyy", "chc", "c c", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_leggings) });
		TucsRegistry.addRecipe(new ItemStack(ModItems.bootsCobblestonedium), new Object[] { "c c", "yhy", "   ", 'y', yellowstoneium, 'c', cobblestondium, 'h', new ItemStack(Items.golden_boots) });

		// Ranged
		TucsRegistry.addRecipe(new ItemStack(ModItems.TUCSBow), new Object[] { " dy", "eby", " dy", 'd', ModItems.Tier1CraftingMat, 'e', ModItems.Tier2CraftingMat, 'b', new ItemStack(Items.bow), 'y', ModItems.ingotYellowstoneium });
		TucsRegistry.addRecipe(new ItemStack(ModItems.M1911), new Object[] { "ccc", "dgt", "  c", 'c', ModItems.ingotCobblestonedium, 'd', Blocks.dispenser, 'g', Items.gunpowder, 't', ModItems.Tier3CraftingMat });
		TucsRegistry.addRecipe(new ItemStack(ModItems.ammo, 4), new Object[] { "ccc", "cgc", "cic", 'c', Blocks.cobblestone, 'i', Items.iron_ingot, 'g', Items.gunpowder });
	}

	public static void Upgrades() {
		switch (ConfigurationHandler.Max_Luck_Upgrade) {
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.looting1Upgrade), new Object[] { "yly", "lul", "yly", 'y', yellowstoneium, 'l', new ItemStack(Items.dye, 1, 4), 'u', new ItemStack(ModItems.upgradBase) });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.looting2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.looting1Upgrade), 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.looting3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.looting2Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Max_Sharpness_Upgrade) {
		case 5:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness1Upgrade), new Object[] { "yly", "lul", "yly", 'y', yellowstoneium, 'l', new ItemStack(Items.quartz), 'u', new ItemStack(ModItems.upgradBase) });
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Sharpness1Upgrade), 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Sharpness2Upgrade), 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Sharpness3Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sharpness5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Sharpness4Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Silktouch_Upgrade) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.Sliktouch1Upgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', new ItemStack(Items.string), 'u', new ItemStack(ModItems.upgradBase) });
		}
		if (ConfigurationHandler.Max_Beheading_Upgrade) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.BeheadingUpgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', new ItemStack(Items.skull, 1, 2), 'u', new ItemStack(ModItems.upgradBase) });
		}
		if (ConfigurationHandler.Max_Infi_Upgrade) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.InfiUpgrade), new Object[] { "ysy", "sus", "ysy", 'y', yellowstoneium, 's', new ItemStack(Items.arrow), 'u', new ItemStack(ModItems.upgradBase) });
		}
		switch (ConfigurationHandler.Max_Bane_of_Arthropods) {
		case 5:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.spider_eye), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.BoA1Upgrade), 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.BoA2Upgrade), 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.BoA3Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BoA5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.BoA4Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Aqua_Affinity) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.AquaAffinityUpgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.water_bucket), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		}
		if (ConfigurationHandler.Max_Auto_Bow) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.AutoBowUpgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.bow), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBaseT2) });
		}
		switch (ConfigurationHandler.Max_Blast_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', new ItemStack(Blocks.tnt), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.BlastProtection1Upgrade), 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.BlastProtection2Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.BlastProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.BlastProtection3Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Efficiency) {
		case 5:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.iron_pickaxe), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Efficiency1Upgrade), 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency2Upgrade), 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency3Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Efficiency5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Efficiency4Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Feather_Falling) {
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.feather), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.FeatherFalling1Upgrade), 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.FeatherFalling2Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FeatherFalling4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.FeatherFalling3Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Fire_Aspect) {
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireAspect1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.blaze_rod), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireAspect2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.FireAspect1Upgrade), 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Fire_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', new ItemStack(Items.blaze_rod), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.FireProtection1Upgrade), 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.FireProtection2Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.FireProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.FireProtection3Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		if (ConfigurationHandler.Max_Flame) {
			TucsRegistry.addRecipe(new ItemStack(ModItems.FlameUpgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.flint_and_steel), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		}
		switch (ConfigurationHandler.Knockback) {
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Knockback1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Blocks.piston), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Knockback2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Knockback1Upgrade), 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Power) {
		case 5:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.flint), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Power1Upgrade), 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Power2Upgrade), 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Power3Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Power5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Power4Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Projectile_Protection) {
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection1Upgrade), new Object[] { "cic", "sus", "cic", 's', new ItemStack(Items.arrow), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.ProjectileProtection1Upgrade), 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.ProjectileProtection2Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.ProjectileProtection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.ProjectileProtection3Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Protection) {
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection1Upgrade), new Object[] { "cic", "sus", "cic", 's', new ItemStack(Items.iron_ingot), 'i', new ItemStack(Items.iron_chestplate), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Protection1Upgrade), 'g', Blocks.glowstone });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Protection2Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Protection4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Protection3Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Punch) {
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Punch1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.leather), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Punch2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Punch1Upgrade), 'g', Blocks.glowstone });
			break;
		}
		switch (ConfigurationHandler.Respiration) {
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration1Upgrade), new Object[] { "cic", "sus", "cic", 's', new ItemStack(Items.golden_apple), 'i', new ItemStack(Items.water_bucket), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Respiration1Upgrade), 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Respiration3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Respiration2Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Smite) {
		case 5:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.rotten_flesh), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 4:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Smite1Upgrade), 'g', Blocks.glowstone });
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Smite2Upgrade), 'r', Blocks.redstone_block });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite4Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Smite3Upgrade), 'r', Blocks.redstone_block });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Smite5Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Smite4Upgrade), 'r', Blocks.redstone_block });
			break;

		}
		switch (ConfigurationHandler.Thorns) {
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Blocks.vine), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Thorns1Upgrade), 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Thorns3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Thorns2Upgrade), 'r', Blocks.redstone_block });
			break;
		}
		switch (ConfigurationHandler.Unbreaking) {
		case 3:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking1Upgrade), new Object[] { "csc", "sus", "csc", 's', new ItemStack(Items.diamond), 'c', yellowstoneium, 'u', new ItemStack(ModItems.upgradBase) });
		case 2:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking2Upgrade), new Object[] { "ggg", "glg", "ggg", 'l', new ItemStack(ModItems.Unbreaking1Upgrade), 'g', Blocks.glowstone });
		case 1:
			TucsRegistry.addRecipe(new ItemStack(ModItems.Unbreaking3Upgrade), new Object[] { "rrr", "rlr", "rrr", 'l', new ItemStack(ModItems.Unbreaking2Upgrade), 'r', Blocks.redstone_block });
			break;
		}
	}
}
